package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.ClientManager;
import fr.benjimania74.SimplySockets.server.events.ServerEventInfo;

public class ServerClientMessageInfo extends ServerEventInfo {
    private final ClientManager clientManager;
    private final String message;

    public ServerClientMessageInfo(ClientManager clientManager, String message){
        setName("ClientMessageInfo");
        this.clientManager = clientManager;
        this.message = message;
    }

    public ClientManager getClientManager() {return clientManager;}
    public String getMessage() {return message;}
}
