package fr.benjimania74.SimplySockets.client.events.infos;

import fr.benjimania74.SimplySockets.client.events.ClientEventInfo;

public class ClientDisconnectInfo extends ClientEventInfo {
    private final String ip;
    private final int port;

    public ClientDisconnectInfo(String ip, int port){
        setName("ClientDisconnectInfo");
        this.ip = ip;
        this.port = port;
    }
}
