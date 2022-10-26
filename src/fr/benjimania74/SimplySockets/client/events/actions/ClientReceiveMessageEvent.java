package fr.benjimania74.SimplySockets.client.events.actions;

import fr.benjimania74.SimplySockets.client.events.ClientEvent;
import fr.benjimania74.SimplySockets.client.events.ClientEventType;

public abstract class ClientReceiveMessageEvent extends ClientEvent {
    public ClientReceiveMessageEvent(){setType(ClientEventType.RECEIVE_MESSAGE);}
}
