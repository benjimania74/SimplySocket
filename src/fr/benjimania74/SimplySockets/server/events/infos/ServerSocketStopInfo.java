package fr.benjimania74.SimplySockets.server.events.infos;

import fr.benjimania74.SimplySockets.server.events.ServerEventInfo;

public class ServerSocketStopInfo extends ServerEventInfo {
    private final int port;
    private final String reason;

    public ServerSocketStopInfo(int port, String reason){
        setName("StopSocketInfo");
        this.port = port;
        this.reason = reason;
    }

    public int getPort() {return port;}
    public String getReason() {return reason;}
}
