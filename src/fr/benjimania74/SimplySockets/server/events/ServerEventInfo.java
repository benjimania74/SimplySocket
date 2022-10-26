package fr.benjimania74.SimplySockets.server.events;

public abstract class ServerEventInfo {
    private String name = "";
    public void setName(String name){this.name = name;}
    public String getName() {return name;}
}
