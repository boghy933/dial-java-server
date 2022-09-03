package dev.boghy933;

import io.resourcepool.ssdp.client.SsdpClient;
import io.resourcepool.ssdp.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.*;

public class SsdpListener {

    // SSDP port
    final int SSDP_PORT = 1900;
    // Broadcast address for finding routers.
    final String SSDP_IP = "239.255.255.250";

    public void listenForPackets() throws IOException {
        // Get the address that we are going to connect to.
        InetAddress address = InetAddress.getByName(SSDP_IP);

        // Create a buffer of bytes, which will be used to store
        // the incoming bytes containing the information from the server.
        // Since the message is small here, 256 bytes should be enough.
        byte[] buf = new byte[256];

        // Create a new Multicast socket (that will allow other sockets/programs
        // to join it as well.
        try (MulticastSocket clientSocket = new MulticastSocket(SSDP_PORT)){
            //Joint the Multicast group.
            clientSocket.joinGroup(address);

            while (true) {
                // Receive the information and print it.
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                clientSocket.receive(msgPacket);

                String msg = new String(buf, 0, buf.length);
                //System.out.println(">>>>>>>>>>>>>>>>>>>Socket 1 received msg: " + msg+ "\n-----------------------------\n\n");
                Thread.sleep(1000);
                if ( msg.contains("M-SEARCH * HTTP/1.1") && msg.contains("ST: urn:dial-multiscreen-org:service:dial:1")) {
                    clientSocket.close();
                    System.out.println("M-SEARCH message");
                    sendResponse();
                    Thread.sleep(2000);
                }
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    private void sendResponse() throws UnknownHostException {
        // Get the address that we are going to connect to.
        InetAddress addr = InetAddress.getByName(SSDP_IP);

        // Open a new DatagramSocket, which will be used to send the data.
        try (DatagramSocket serverSocket = new DatagramSocket()) {
                String msg = mSearchResponse();

                // Create a packet that will contain the data(in the form of bytes) and send it.
                DatagramPacket msgPacket =
                        new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, SSDP_PORT);
                serverSocket.send(msgPacket);

                System.out.println(">>>>>>>>>>Server sent packet with msg: " + msg + "\n-----------------------------\n\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String mSearchResponse() throws UnknownHostException {
        return "HTTP/1.1 200 OK\n" +
                "LOCATION: http://"+InetAddress.getLocalHost().getHostAddress()+":8080/dd.xml\n" +
                "CACHE-CONTROL: max-age=1800\n" +
                "EXT: \n" +
                "BOOTID.UPNP.ORG: 1\n"+
                "SERVER: FreeBSD/8.0 UPnP/1.0 Secret-MIL-DLNA-SV/1.0\n" +
                "USN: uuid:4D454930-0100-2000-9002-A81374A5D176::urn:dial-multiscreen-org:service:dial:1\n"+
                "ST: urn:dial-multiscreen-org:service:dial:1";
    }
}

