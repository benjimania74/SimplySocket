package fr.benjimania74.SimplySockets.server.events;

abstract class ServerSocketStartEvent extends Event {
    public ServerSocketStartEvent(){setType(EventType.START);}
}
