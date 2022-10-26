package fr.benjimania74.SimplySockets.client.events.infos;

import fr.benjimania74.SimplySockets.client.events.ClientEventInfo;

public class ClientSendMessageInfo extends ClientEventInfo {
    private final String ip;
    private final int port;
    private final String message;

    public ClientSendMessageInfo(String ip, int port, String message){
        setName("ClientSendMessageInfo");
        this.ip = ip;
        this.port = port;
        this.message = message;
    }

    public String getIp() {return ip;}
    public int getPort() {return port;}
    public String getMessage() {return message;}
}
