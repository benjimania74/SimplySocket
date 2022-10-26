package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.ClientManager;
import fr.benjimania74.SimplySockets.server.events.ServerEventInfo;

public class ServerClientDisconnectInfo extends ServerEventInfo {
    private final ClientManager clientManager;

    public ServerClientDisconnectInfo(ClientManager clientManager){
        setName("ClientDisconnectInfo");
        this.clientManager = clientManager;
    }

    public ClientManager getClientManager() {return clientManager;}
}
