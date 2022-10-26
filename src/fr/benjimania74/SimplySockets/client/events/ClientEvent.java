package fr.benjimania74.SimplySockets.client.events;

public abstract class ClientEvent {
    ClientEventType type = ClientEventType.NONE;

    public ClientEventType getType() {return this.type;}
    public void setType(ClientEventType type) {this.type = type;}

    public abstract void call(ClientEventInfo clientEventInfo);
}
