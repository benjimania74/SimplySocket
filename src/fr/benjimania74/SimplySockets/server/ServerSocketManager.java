package fr.benjimania74.SimplySockets.server;

import fr.benjimania74.SimplySockets.server.events.Event;
import fr.benjimania74.SimplySockets.server.events.EventType;

import java.io.IOException;
import java.net.ServerSocket;
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
            callEvents(EventType.START);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void registerEvents(Event ... e){
        this.events.addAll(Arrays.asList(e));
    }

    protected void callEvents(EventType event){
        events.forEach(e -> {
            if(e.getType() == event){
                e.call();
            }
        });
    }
}
