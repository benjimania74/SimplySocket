package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;

public abstract class ServerClientConnectEvent extends ServerEvent {
    public ServerClientConnectEvent(){setType(ServerEventType.CLIENT_CONNECT);}
}
