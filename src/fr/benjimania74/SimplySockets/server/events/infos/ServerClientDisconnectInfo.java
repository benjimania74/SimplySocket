package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.events.EventInfo;

public class ServerClientDisconnectInfo extends EventInfo {
    private final int port;
    private final String clientIP;

    public ServerClientDisconnectInfo(int port, String clientIP){
        setName("ClientDisconnectInfo");
        this.port = port;
        this.clientIP = clientIP;
    }

    public int getPort() {return port;}
    public String getIp() {return clientIP;}
}
