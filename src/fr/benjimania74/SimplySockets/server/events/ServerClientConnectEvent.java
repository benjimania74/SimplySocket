package fr.benjimania74.SimplySockets.server.events;

abstract class ServerClientConnectEvent extends Event {
    public ServerClientConnectEvent(){setType(EventType.CLIENT_CONNECT);}
}
