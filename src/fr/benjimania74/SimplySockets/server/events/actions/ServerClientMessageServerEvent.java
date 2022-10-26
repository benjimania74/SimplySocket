package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;

public abstract class ServerClientMessageServerEvent extends ServerEvent {
    public ServerClientMessageServerEvent(){setType(ServerEventType.CLIENT_MESSAGE);}
}
