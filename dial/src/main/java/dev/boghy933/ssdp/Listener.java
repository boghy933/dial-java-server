package dev.boghy933.ssdp;

import dev.boghy933.config.SsdpConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Listener extends Thread {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String host;
    private int port;
    private byte[] buffer = new byte[4096];
    //Boolean mSearchReceived = null;
    private Sender sender;

    public void run() {
        try {
            this.startListener();
        } catch (IOException e) {
            logger.error("Failed to start listener {}", e.getMessage());
        }
    }

    private void startListener() throws IOException {
        // Get the address that we are going to connect to.
        InetAddress address = InetAddress.getByName(host);

        // Create a new Multicast socket (that will allow other sockets/programs to join it as well.
        MulticastSocket clientSocket = new MulticastSocket(port);

        //Joint the Multicast group.
        clientSocket.joinGroup(address);

        for (;;) {
            // Receive the information and print it.
            DatagramPacket msgPacket = new DatagramPacket(this.buffer, this.buffer.length);
            clientSocket.receive(msgPacket);

            String msg = new String(this.buffer, 0, this.buffer.length);
            //logger.info("Reading messages");
            if ( msg.contains("M-SEARCH * HTTP/1.1") && msg.contains("ST: urn:dial-multiscreen-org:service:dial:1")) {
                logger.info("M-SEARCH message received ip={}, port={}", msgPacket.getAddress().getHostAddress(), msgPacket.getPort());
                //clientSocket.close();
                //this.mSearchReceived = true;
                sender.setHost(msgPacket.getAddress().getHostAddress());
                sender.setPort(msgPacket.getPort());
                sender.run();
            }
        }
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }
    public void setSender(Sender sender) {
        this.sender = sender;
    }
}
