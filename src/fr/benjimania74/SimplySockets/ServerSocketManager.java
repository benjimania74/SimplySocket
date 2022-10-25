package fr.benjimania74.SimplySockets;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketManager {
    private ServerSocket socket;

    public ServerSocketManager(int port){
        try {
            this.socket = new ServerSocket(port);
        }catch (IOException e){e.printStackTrace();}
    }
}
