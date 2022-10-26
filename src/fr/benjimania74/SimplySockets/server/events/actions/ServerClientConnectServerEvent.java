package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;

public abstract class ServerClientConnectServerEvent extends ServerEvent {
    public ServerClientConnectServerEvent(){setType(ServerEventType.CLIENT_CONNECT);}
}
