package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.events.EventInfo;

public class ServerSocketStartInfo extends EventInfo {
    private final int port;

    public ServerSocketStartInfo(int port){
        setName("StartSocketInfo");
        this.port = port;
    }
    public int getPort() {return port;}
}
