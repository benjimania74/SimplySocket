package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.ClientManager;
import fr.benjimania74.SimplySockets.server.events.ServerEventInfo;

public class ServerClientConnectInfo extends ServerEventInfo {
    private final ClientManager clientManager;

    public ServerClientConnectInfo(ClientManager clientManager){
        setName("ClientConnectInfo");
        this.clientManager = clientManager;
    }

    public ClientManager getClientManager() {return clientManager;}
}
