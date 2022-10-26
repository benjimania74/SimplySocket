package fr.benjimania74.SimplySockets.server;

import fr.benjimania74.SimplySockets.server.events.ServerEventType;
import fr.benjimania74.SimplySockets.server.events.infos.ServerClientConnectInfo;
import fr.benjimania74.SimplySockets.server.events.infos.ServerClientDisconnectInfo;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ClientWaiter implements Runnable{
    private List<ClientManager> clients = new ArrayList<>();
    private final ServerSocketManager ssm;

    public ClientWaiter(ServerSocketManager ssm){
        this.ssm = ssm;
    }

    public void disconnectAll(){
        clients.forEach(ClientManager::disconnect);
    }
    public void disconnect(ClientManager cm){
        clients.remove(cm);
        cm.disconnect();
    }

    @Override
    public void run() {
        if(this.ssm.isStarted()) {
            Socket client = ssm.acceptClient();
            if(client == null){return;}
            ClientManager cm = new ClientManager(client, this.ssm);
            new Thread(cm).start();
            this.clients.add(cm);
            this.ssm.callEvents(ServerEventType.CLIENT_CONNECT, new ServerClientConnectInfo(cm));

            this.clients.forEach(c -> {
                if(!c.isConnected()){
                    this.ssm.callEvents(ServerEventType.CLIENT_DISCONNECT, new ServerClientDisconnectInfo(cm));
                    this.clients.remove(c);
                }
            });

            run();
        }
    }
}
