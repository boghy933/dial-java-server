package dev.boghy933.ssdp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.*;

public class Sender extends Thread {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String host;
    private int port;

    @Override
    public void run() {
        logger.info("Sending m-search response");
        try {
            this.sendResponse();
        } catch (IOException e) {
            logger.error("Failed to start sender {}", e.getMessage());
        }
    }

    private void sendResponse() throws IOException {
        // Get the address that we are going to connect to.
        InetAddress addr = InetAddress.getByName(host);

        // Open a new DatagramSocket, which will be used to send the data.
        DatagramSocket serverSocket = new DatagramSocket();
        String msg = mSearchResponse();

        // Create a packet that will contain the data(in the form of bytes) and send it.
        DatagramPacket msgPacket =
                new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, port);
        serverSocket.send(msgPacket);

        logger.info("M-Search message sent");

    }

    private String mSearchResponse() throws UnknownHostException {
        return "HTTP/1.1 200 OK\n" +
                "LOCATION: http://"+InetAddress.getLocalHost().getHostAddress()+":8080/dd.xml\n" +
                "CACHE-CONTROL: max-age=1800\n" +
                "EXT: \n" +
                "BOOTID.UPNP.ORG: 1\n"+
                "SERVER: FreeBSD/8.0 UPnP/1.0 Secret-MIL-DLNA-SV/1.0\n" +
                "USN: uuid:4e3244a6-46d6-4875-adef-e886895406d96\n"+
                "ST: urn:dial-multiscreen-org:service:dial:1\r\t\r\t";
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
