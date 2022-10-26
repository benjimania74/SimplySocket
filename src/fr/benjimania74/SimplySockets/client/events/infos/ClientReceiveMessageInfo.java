package fr.benjimania74.SimplySockets.client.events.infos;

import fr.benjimania74.SimplySockets.client.events.ClientEventInfo;

public class ClientReceiveMessageInfo extends ClientEventInfo {
    private final String ip;
    private final int port;
    private final String message;

    public ClientReceiveMessageInfo(String ip, int port, String message){
        setName("ClientReceiveMessageInfo");
        this.ip = ip;
        this.port = port;
        this.message = message;
    }

    public String getIp() {return ip;}
    public int getPort() {return port;}
    public String getMessage() {return message;}
}
