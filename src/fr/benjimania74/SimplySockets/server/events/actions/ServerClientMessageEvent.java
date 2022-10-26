package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;

public abstract class ServerClientMessageEvent extends ServerEvent {
    public ServerClientMessageEvent(){setType(ServerEventType.CLIENT_MESSAGE);}
}
