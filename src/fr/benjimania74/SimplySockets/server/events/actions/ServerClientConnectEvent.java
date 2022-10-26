package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.Event;
import fr.benjimania74.SimplySockets.server.events.EventType;

public abstract class ServerClientConnectEvent extends Event {
    public ServerClientConnectEvent(){setType(EventType.CLIENT_CONNECT);}
}
