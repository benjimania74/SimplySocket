package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.Event;
import fr.benjimania74.SimplySockets.server.events.EventType;

public abstract class ServerClientDisconnectEvent extends Event {
    public ServerClientDisconnectEvent(){setType(EventType.CLIENT_DISCONNECT);}
}
