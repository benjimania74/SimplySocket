package fr.benjimania74.SimplySockets.client.events.infos;

import fr.benjimania74.SimplySockets.client.events.ClientEventInfo;

public class ClientConnectInfo extends ClientEventInfo {
    private final String ip;
    private final int port;

    public ClientConnectInfo(String ip, int port){
        setName("ClientConnectInfo");
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {return ip;}
    public int getPort() {return port;}
}
