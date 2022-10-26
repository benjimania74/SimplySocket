package fr.benjimania74.SimplySockets.server;

import fr.benjimania74.SimplySockets.server.events.EventType;
import fr.benjimania74.SimplySockets.server.events.infos.ServerClientDisconnectInfo;
import fr.benjimania74.SimplySockets.server.events.infos.ServerClientMessageInfo;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientWaiter {
    private List<ClientManager> clients = new ArrayList<>();
    private final ServerSocketManager ssm;

    public ClientWaiter(ServerSocketManager ssm){
        this.ssm = ssm;
        waitClient();
    }

    private void waitClient(){
        while(ssm.isStarted()){
            try {
                Socket client = ssm.acceptClient();
                this.clients.add(new ClientManager(client));
            }catch (Exception e){
                e.printStackTrace();
            }

            this.clients.forEach(cm -> {
                if(!cm.isConnected()){
                    this.ssm.callEvents(EventType.CLIENT_DISCONNECT, new ServerClientDisconnectInfo(cm));
                    this.clients.remove(cm);
                }
                String msg = cm.readData();
                if(!msg.equals("")){
                    this.ssm.callEvents(EventType.CLIENT_MESSAGE, new ServerClientMessageInfo(cm, cm.readData()));
                }
            });
        }
    }
}
