package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.events.EventInfo;

public class ServerClientConnectInfo extends EventInfo {
    private final int port;
    private final String clientIP;

    public ServerClientConnectInfo(int port, String clientIP){
        setName("ClientConnectInfo");
        this.port = port;
        this.clientIP = clientIP;
    }

    public int getPort() {return port;}
    public String getIp() {return clientIP;}
}
