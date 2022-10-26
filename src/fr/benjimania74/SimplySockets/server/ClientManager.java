package fr.benjimania74.SimplySockets.server;

import fr.benjimania74.SimplySockets.server.events.ServerEventType;
import fr.benjimania74.SimplySockets.server.events.infos.ServerClientMessageInfo;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientManager implements Runnable{
    private final Socket client;
    private final ServerSocketManager ssm;

    public ClientManager(Socket client, ServerSocketManager ssm){
        this.client = client;
        this.ssm = ssm;
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

    @Override
    public void run() {
        try{
            if(isConnected()){
                DataInputStream dis = new DataInputStream(this.client.getInputStream());
                this.ssm.callEvents(ServerEventType.CLIENT_MESSAGE, new ServerClientMessageInfo(this, dis.readUTF()));
                run();
            }
            this.client.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
