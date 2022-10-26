package fr.benjimania74.SimplySockets.server;

import fr.benjimania74.SimplySockets.server.events.ServerEventType;
import fr.benjimania74.SimplySockets.server.events.infos.ServerClientMessageInfo;
import fr.benjimania74.SimplySockets.server.events.infos.ServerSendMessageInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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

    public boolean sendMessage(String message){
        try{
            if(!this.client.isConnected()){return false;}
            DataOutputStream out = new DataOutputStream(this.client.getOutputStream());
            out.writeUTF(message);
            out.flush();
            this.ssm.callEvents(ServerEventType.SERVER_MESSAGE, new ServerSendMessageInfo(this, message));
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public void disconnect(){
        try {
            this.client.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            if(isConnected()){
                try {
                    DataInputStream dis = new DataInputStream(this.client.getInputStream());
                    this.ssm.callEvents(ServerEventType.CLIENT_MESSAGE, new ServerClientMessageInfo(this, dis.readUTF()));
                    run();
                }catch (Exception e){
                    return;
                }
            }
            this.client.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
