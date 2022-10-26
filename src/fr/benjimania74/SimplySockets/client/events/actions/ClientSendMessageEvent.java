package fr.benjimania74.SimplySockets.client.events.actions;

import fr.benjimania74.SimplySockets.client.events.ClientEvent;
import fr.benjimania74.SimplySockets.client.events.ClientEventType;

public abstract class ClientSendMessageEvent extends ClientEvent {
    public ClientSendMessageEvent(){setType(ClientEventType.SEND_MESSAGE);}
}
