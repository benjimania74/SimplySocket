package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;

public abstract class ServerSocketStopServerEvent extends ServerEvent {
    public ServerSocketStopServerEvent(){setType(ServerEventType.STOP);}
}
