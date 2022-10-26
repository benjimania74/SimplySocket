package fr.benjimania74.SimplySockets.server.events.actions;

import fr.benjimania74.SimplySockets.server.events.ServerEvent;
import fr.benjimania74.SimplySockets.server.events.ServerEventType;

public abstract class ServerSendMessageEvent extends ServerEvent {
    public ServerSendMessageEvent(){setType(ServerEventType.SERVER_MESSAGE);}
}
