package fr.benjimania74.SimplySockets.server;

import fr.benjimania74.SimplySockets.server.events.Event;
import fr.benjimania74.SimplySockets.server.events.EventInfo;
import fr.benjimania74.SimplySockets.server.events.EventType;
import fr.benjimania74.SimplySockets.server.events.infos.ServerSocketStartInfo;
import fr.benjimania74.SimplySockets.server.events.infos.ServerSocketStopInfo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServerSocketManager {
    private ServerSocket socket;
    private final int port;
    private List<Event> events = new ArrayList<>();

    public ServerSocketManager(int port){this.port = port;}

    public void start(){
        try{
            this.socket = new ServerSocket(this.port);
            callEvents(EventType.START, new ServerSocketStartInfo(this.port));
            new ClientWaiter(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stop(){
        try {
            this.socket.close();
            callEvents(EventType.STOP, new ServerSocketStopInfo(this.port, "Manual Stopping"));
        }catch (Exception e){
            e.printStackTrace();
            callEvents(EventType.STOP, new ServerSocketStopInfo(this.port, "Crash while manual stopping"));
        }
    }

    public boolean isStarted(){
        return !this.socket.isClosed();
    }

    public Socket acceptClient(){
        try {
            return this.socket.accept();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void registerEvents(Event ... e){
        this.events.addAll(Arrays.asList(e));
    }

    protected void callEvents(EventType event, EventInfo eventInfo){
        events.forEach(e -> {
            if(e.getType() == event){
                e.call(eventInfo);
            }
        });
    }
}
