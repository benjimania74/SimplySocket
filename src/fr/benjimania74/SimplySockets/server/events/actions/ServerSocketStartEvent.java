package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.Event;
import fr.benjimania74.SimplySockets.server.events.EventType;

abstract class ServerSocketStartEvent extends Event {
    public ServerSocketStartEvent(){setType(EventType.START);}
}
