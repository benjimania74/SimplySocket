package fr.benjimania74.SimplySockets.server.events;

abstract class ServerClientMessageEvent extends Event{
    public ServerClientMessageEvent(){setType(EventType.CLIENT_MESSAGE);}
}
