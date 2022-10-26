package fr.benjimania74.SimplySockets.client.events.actions;

import fr.benjimania74.SimplySockets.client.events.ClientEvent;
import fr.benjimania74.SimplySockets.client.events.ClientEventType;

public abstract class ClientDisconnectEvent extends ClientEvent {
    public ClientDisconnectEvent(){setType(ClientEventType.DISCONNECT);}
}
