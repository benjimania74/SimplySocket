package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;

public abstract class ServerSocketStopEvent extends ServerEvent {
    public ServerSocketStopEvent(){setType(ServerEventType.STOP);}
}
