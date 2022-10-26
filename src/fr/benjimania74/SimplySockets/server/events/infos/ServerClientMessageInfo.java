package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.events.EventInfo;

public class ServerClientMessageInfo extends EventInfo {
    private final int port;
    private final String clientIP;
    private final String message;

    public ServerClientMessageInfo(int port, String clientIP, String message){
        setName("ClientMessageInfo");
        this.port = port;
        this.clientIP = clientIP;
        this.message = message;
    }

    public int getPort() {return port;}
    public String getClientIP() {return clientIP;}
    public String getMessage() {return message;}
}
