package com.example.castPlayer.controller;

import com.example.castPlayer.factory.ProcessBuilderFactory;
import com.example.castPlayer.model.ServiceDto;
import com.example.castPlayer.service.app.Youtube;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;


@RestController()
public class ApplicationsController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Youtube youtube;

    @GetMapping(value = "apps/YouTube",  produces = MediaType.APPLICATION_XML_VALUE)
            //produces = "text/xml; charset=utf-8")
    public ServiceDto youTube() {
        return youtube.getStatus();
/*        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<service xmlns=\"urn:dial-multiscreen-org:schemas:dial\" dialVer=\"1.7\">\n" +
                "  <name>YouTube</name>\n" +
                "  <options allowStop=\"true\"/>\n" +
                "  <state>stopped</state>\n" +
                "</service>";*/
    }

    @PostMapping(value = "apps/YouTube")
    public ResponseEntity startVideo(@RequestBody String videoUrl, HttpServletResponse response, HttpServletRequest request) throws IOException, InterruptedException {
        logger.info("Body {}", videoUrl);
        logger.info("Request Uri {}", request.getRequestURI());

        response.addHeader("Application-URL", "http://"+ InetAddress.getLocalHost().getHostAddress()+":8080/apps/YouTube/run");

        // ProcessBuilderFactory processBuilderFactory = new ProcessBuilderFactory();
        // processBuilderFactory.build().linuxCommand("/usr/bin/open", "-a", "\"/Applications/Google Chrome.app\"", "'https://www.youtube.com/watch?v=dQw4w9WgXcQ'").run();

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "apps/YouTube/run")
    public ResponseEntity stopVideo() {
        // TODO: Stop video
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
