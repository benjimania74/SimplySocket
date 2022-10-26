package fr.benjimania74.SimplySockets.server.events;

public abstract class Event {
    EventType type = EventType.NONE;
    public EventType getType(){return this.type;};
    public void setType(EventType type){this.type = type;};

    public abstract void call();
}
