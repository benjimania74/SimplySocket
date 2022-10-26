package fr.benjimania74.SimplySockets.server.events;

abstract class ServerClientDisconnectEvent extends Event{
    public ServerClientDisconnectEvent(){setType(EventType.CLIENT_DISCONNECT);}
}
