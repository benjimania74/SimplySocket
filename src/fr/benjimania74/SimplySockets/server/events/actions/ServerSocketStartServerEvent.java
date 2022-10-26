package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;

public abstract class ServerSocketStartServerEvent extends ServerEvent {
    public ServerSocketStartServerEvent(){setType(ServerEventType.START);}
}
