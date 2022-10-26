package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.ClientManager;
import fr.benjimania74.SimplySockets.server.events.EventInfo;

public class ServerClientDisconnectInfo extends EventInfo {
    private final ClientManager clientManager;

    public ServerClientDisconnectInfo(ClientManager clientManager){
        setName("ClientDisconnectInfo");
        this.clientManager = clientManager;
    }

    public ClientManager getClientManager() {return clientManager;}
}
