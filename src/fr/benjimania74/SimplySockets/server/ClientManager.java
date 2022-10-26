package fr.benjimania74.SimplySockets.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientManager {
    private final Socket client;

    public ClientManager(Socket client){
        this.client = client;
    }

    public String getIP(){
        return this.client.getInetAddress().getHostAddress();
    }

    public int getPort(){
        return this.client.getPort();
    }

    public boolean isConnected(){
        return client.isConnected();
    }

    public String readData(){
        try{
            if(isConnected()){
                    DataInputStream dis = new DataInputStream(this.client.getInputStream());
                    return dis.readUTF();
            }
            this.client.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }
}
