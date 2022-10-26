package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.ClientManager;
import fr.benjimania74.SimplySockets.server.events.ServerEventInfo;

public class ServerSendMessageInfo extends ServerEventInfo {
    private final ClientManager cm;
    private final String message;

    public ServerSendMessageInfo(ClientManager cm, String message){
        setName("ServerSendMessageInfo");
        this.cm = cm;
        this.message = message;
    }

    public ClientManager getCm() {return cm;}
    public String getMessage() {return message;}
}
