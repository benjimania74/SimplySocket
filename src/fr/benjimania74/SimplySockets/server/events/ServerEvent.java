package fr.benjimania74.SimplySockets.server.events;

public abstract class ServerEvent {
    ServerEventType type = ServerEventType.NONE;
    public ServerEventType getType(){return this.type;};
    public void setType(ServerEventType type){this.type = type;};

    public abstract void call(ServerEventInfo serverEventInfo);
}
