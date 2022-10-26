package fr.benjimania74.SimplySockets.server;

import fr.benjimania74.SimplySockets.server.events.EventType;
import fr.benjimania74.SimplySockets.server.events.actions.ServerClientConnectEvent;
import fr.benjimania74.SimplySockets.server.events.infos.ServerClientConnectInfo;
import fr.benjimania74.SimplySockets.server.events.infos.ServerClientDisconnectInfo;
import fr.benjimania74.SimplySockets.server.events.infos.ServerClientMessageInfo;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientWaiter implements Runnable{
    private List<ClientManager> clients = new ArrayList<>();
    private final ServerSocketManager ssm;

    public ClientWaiter(ServerSocketManager ssm){
        this.ssm = ssm;
    }

    @Override
    public void run() {
        if(this.ssm.isStarted()) {
            try {
                Socket client = ssm.acceptClient();
                ClientManager cm = new ClientManager(client, this.ssm);
                new Thread(cm).start();
                this.clients.add(cm);
                this.ssm.callEvents(EventType.CLIENT_CONNECT, new ServerClientConnectInfo(cm));
            }catch (Exception e){
                e.printStackTrace();
            }

            this.clients.forEach(cm -> {
                if(!cm.isConnected()){
                    this.ssm.callEvents(EventType.CLIENT_DISCONNECT, new ServerClientDisconnectInfo(cm));
                    this.clients.remove(cm);
                }
            });
            run();
        }
    }
}
