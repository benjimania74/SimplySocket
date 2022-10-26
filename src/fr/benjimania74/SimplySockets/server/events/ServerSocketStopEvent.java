package fr.benjimania74.SimplySockets.server.events;

abstract class ServerSocketStopEvent extends Event{
    public ServerSocketStopEvent(){setType(EventType.STOP);}
}
