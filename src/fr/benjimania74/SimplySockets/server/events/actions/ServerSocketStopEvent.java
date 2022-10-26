package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.Event;
import fr.benjimania74.SimplySockets.server.events.EventType;

public abstract class ServerSocketStopEvent extends Event {
    public ServerSocketStopEvent(){setType(EventType.STOP);}
}
