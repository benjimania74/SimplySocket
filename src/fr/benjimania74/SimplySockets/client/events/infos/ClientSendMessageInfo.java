package fr.benjimania74.SimplySockets.client.events.infos;

import fr.benjimania74.SimplySockets.client.events.ClientEventInfo;

public class ClientSendMessageInfo extends ClientEventInfo {
    private final String message;

    public ClientSendMessageInfo(String message){
        setName("ClientSendMessageInfo");
        this.message = message;
    }

    public String getMessage() {return message;}
}
