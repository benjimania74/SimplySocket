package fr.benjimania74.SimplySockets.client.events.infos;

import fr.benjimania74.SimplySockets.client.events.ClientEventInfo;

public class ClientReceiveMessageInfo extends ClientEventInfo {
    private final String message;

    public ClientReceiveMessageInfo(String message){
        setName("ClientReceiveMessageInfo");
        this.message = message;
    }

    public String getMessage() {return message;}
}
