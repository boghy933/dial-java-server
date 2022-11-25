package com.example.castPlayer.controller;

import com.example.castPlayer.model.upnp.UpnpDto;
import com.example.castPlayer.service.DeviceDescriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class DeviceDescriptionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DeviceDescriptionService deviceDescriptionService;

    @GetMapping(value = "/dd.xml",  produces = MediaType.APPLICATION_XML_VALUE)
    public UpnpDto deviceDescription(HttpServletResponse response) {

        logger.info("Giving device info to device {}", "todo");
        // TODO: retrieve ip in more efficient way
        response.addHeader("Application-URL", "http://192.168.1.104:8080/apps");
        //response.addHeader("Application-URL", "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/apps");
        return deviceDescriptionService.deviceDescription();
    }
}
