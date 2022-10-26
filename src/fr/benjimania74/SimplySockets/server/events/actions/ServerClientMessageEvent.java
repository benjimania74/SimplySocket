package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.Event;
import fr.benjimania74.SimplySockets.server.events.EventType;

public abstract class ServerClientMessageEvent extends Event {
    public ServerClientMessageEvent(){setType(EventType.CLIENT_MESSAGE);}
}
