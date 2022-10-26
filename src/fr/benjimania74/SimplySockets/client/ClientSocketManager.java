package fr.benjimania74.SimplySockets.client;

import fr.benjimania74.SimplySockets.client.events.ClientEvent;
import fr.benjimania74.SimplySockets.client.events.ClientEventInfo;
import fr.benjimania74.SimplySockets.client.events.ClientEventType;
import fr.benjimania74.SimplySockets.client.events.infos.ClientConnectInfo;
import fr.benjimania74.SimplySockets.client.events.infos.ClientDisconnectInfo;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientSocketManager {
    private List<ClientEvent> clientEvents = new ArrayList<>();
    private Socket client = null;
    private final String ip;
    private final int port;

    public ClientSocketManager(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void connect(){
        if(this.client != null){return;}
        try{
            this.client = new Socket(this.ip, this.port);
            callEvents(ClientEventType.CONNECT, new ClientConnectInfo(this.ip, this.port));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void disconnect(){
        if(this.client == null){return;}
        if(this.client.isConnected()){
            try{
                this.client.close();
                callEvents(ClientEventType.DISCONNECT, new ClientDisconnectInfo(this.ip, this.port));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void registerEvents(ClientEvent ... e){
        this.clientEvents.addAll(Arrays.asList(e));
    }

    protected void callEvents(ClientEventType type, ClientEventInfo clientEventInfo){
        this.clientEvents.forEach(e -> {
            if(e.getType().equals(type)){
                e.call(clientEventInfo);
            }
        });
    }
}
