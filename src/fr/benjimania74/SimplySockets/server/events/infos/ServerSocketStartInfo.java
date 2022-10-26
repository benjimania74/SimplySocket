package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.events.ServerEventInfo;

public class ServerSocketStartInfo extends ServerEventInfo {
    private final int port;

    public ServerSocketStartInfo(int port){
        setName("StartSocketInfo");
        this.port = port;
    }
    public int getPort() {return port;}
}
