package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.ClientManager;
import fr.benjimania74.SimplySockets.server.events.EventInfo;

public class ServerClientConnectInfo extends EventInfo {
    private final ClientManager clientManager;

    public ServerClientConnectInfo(ClientManager clientManager){
        setName("ClientConnectInfo");
        this.clientManager = clientManager;
    }

    public ClientManager getClientManager() {return clientManager;}
}
