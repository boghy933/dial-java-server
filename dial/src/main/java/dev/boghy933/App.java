package dev.boghy933;

import dev.boghy933.config.SsdpConfig;
import dev.boghy933.ssdp.Listener;
import dev.boghy933.ssdp.Sender;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        Sender mSearchSender = new Sender();

        Listener mSearchListener = new Listener();
        mSearchListener.setHost(SsdpConfig.SSDP_IP);
        mSearchListener.setPort(SsdpConfig.SSDP_PORT);
        mSearchListener.setSender(mSearchSender);
        mSearchListener.start();

        //SsdpListener listener = new SsdpListener();
        //listener.listenForPackets();
    }
}
