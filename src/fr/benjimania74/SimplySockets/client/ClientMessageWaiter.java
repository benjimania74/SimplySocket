package fr.benjimania74.SimplySockets.client;

import fr.benjimania74.SimplySockets.client.events.ClientEventType;
import fr.benjimania74.SimplySockets.client.events.infos.ClientReceiveMessageInfo;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientMessageWaiter implements Runnable{
    private final ClientSocketManager csm;
    private final Socket client;

    public ClientMessageWaiter(ClientSocketManager csm, Socket client){
        this.csm = csm;
        this.client = client;
    }

    @Override
    public void run() {
        while(this.client.isConnected()){
            try {
                DataInputStream in = new DataInputStream(this.client.getInputStream());
                csm.callEvents(ClientEventType.RECEIVE_MESSAGE, new ClientReceiveMessageInfo(csm.getIp(), csm.getPort(), in.readUTF()));
            }catch (IOException e){
                e.printStackTrace();
                this.csm.disconnect();
            }
        }
    }
}
