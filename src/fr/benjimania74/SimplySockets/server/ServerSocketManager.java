package fr.benjimania74.SimplySockets.server;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventInfo;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;
import fr.benjimania74.SimplySockets.server.events.infos.ServerSocketStartInfo;
import fr.benjimania74.SimplySockets.server.events.infos.ServerSocketStopInfo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServerSocketManager {
    private ClientWaiter cw;
    private ServerSocket socket = null;
    private final int port;
    private List<ServerEvent> serverEvents = new ArrayList<>();

    public ServerSocketManager(int port){this.port = port;}

    public void start(){
        try{
            if(this.socket != null && !this.socket.isClosed()){
                stop();
            }
            this.socket = new ServerSocket(this.port);
            callEvents(ServerEventType.START, new ServerSocketStartInfo(this.port));
            this.cw = new ClientWaiter(this);
            new Thread(this.cw).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stop(){
        try {
            if(this.socket.isClosed()){return;}
            this.cw.disconnectAll();
            callEvents(ServerEventType.STOP, new ServerSocketStopInfo(this.port, "Manual Stopping"));
            this.socket.close();
        }catch (Exception e){
            e.printStackTrace();
            callEvents(ServerEventType.STOP, new ServerSocketStopInfo(this.port, "Crash while manual stopping"));
        }
    }

    public boolean isStarted(){
        return !this.socket.isClosed();
    }

    public Socket acceptClient(){
        try {
            return this.socket.accept();
        }catch (IOException e){
            return null;
        }
    }

    public void registerEvents(ServerEvent... e){
        this.serverEvents.addAll(Arrays.asList(e));
    }

    protected void callEvents(ServerEventType event, ServerEventInfo serverEventInfo){
        serverEvents.forEach(e -> {
            if(e.getType() == event){
                e.call(serverEventInfo);
            }
        });
    }
}
