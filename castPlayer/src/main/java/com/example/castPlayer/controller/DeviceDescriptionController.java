package com.example.castPlayer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class DeviceDescriptionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/dd.xml", produces = "text/xml; charset=utf-8")
    public String deviceDescription(HttpServletResponse response) throws UnknownHostException {

        logger.info("Giving device info to device {}", "todo");

        response.addHeader("Application-URL", "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/apps");

        return "<?xml version=\"1.0\"?>\n" +
                "<root xmlns=\"urn:schemas-upnp-org:device-1-0\">\n" +
                "  <specVersion>\n" +
                "    <major>1</major>\n" +
                "    <minor>0</minor>\n" +
                "  </specVersion>\n" +
                "  <device>\n" +
                "    <deviceType>urn:schemas-upnp-org:device:tvdevice:1</deviceType>\n" +
                "    <friendlyName>UPnP Television Emulator</friendlyName>\n" +
                "    <manufacturer>TV Manufacturer Name</manufacturer>\n" +
                "    <manufacturerURL>http://www.manufacturer.com</manufacturerURL>\n" +
                "    <modelDescription>UPnP Television Device Emulator 1.0</modelDescription>\n" +
                "    <modelName>TVEmulator</modelName>\n" +
                "    <modelNumber>1.0</modelNumber>\n" +
                "    <modelURL>http://www.manufacturer.com/TVEmulator/</modelURL>\n" +
                "    <serialNumber>123456789001</serialNumber>\n" +
                "    <UDN>uuid:Upnp-TVEmulator-1_0-1234567890001</UDN>\n" +
                "    <UPC>123456789</UPC>\n" +
                "    <serviceList>\n" +
                "      <service>\n" +
                "        <serviceType>urn:schemas-upnp-org:service:tvcontrol:1</serviceType>\n" +
                "        <serviceId>urn:upnp-org:serviceId:tvcontrol1</serviceId>\n" +
                "        <controlURL>/upnp/control/tvcontrol1</controlURL>\n" +
                "        <eventSubURL>/upnp/event/tvcontrol1</eventSubURL>\n" +
                "        <SCPDURL>/tvcontrolSCPD.xml</SCPDURL>\n" +
                "      </service>\n" +
                "      <service>\n" +
                "        <serviceType>urn:schemas-upnp-org:service:tvpicture:1</serviceType>\n" +
                "        <serviceId>urn:upnp-org:serviceId:tvpicture1</serviceId>\n" +
                "        <controlURL>/upnp/control/tvpicture1</controlURL>\n" +
                "        <eventSubURL>/upnp/event/tvpicture1</eventSubURL>\n" +
                "        <SCPDURL>/tvpictureSCPD.xml</SCPDURL>\n" +
                "      </service>\n" +
                "    </serviceList>\n" +
                "   <presentationURL>/tvdevicepres.html</presentationURL>\n" +
                "</device>\n" +
                "</root>";
    }
}
