package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;

public abstract class ServerClientDisconnectServerEvent extends ServerEvent {
    public ServerClientDisconnectServerEvent(){setType(ServerEventType.CLIENT_DISCONNECT);}
}
