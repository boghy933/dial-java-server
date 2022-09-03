package com.example.castPlayer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ApplicationsController {
    @GetMapping(value = "apps/YouTube", produces = "text/xml; charset=utf-8")
    public String youTube() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<service xmlns=\"urn:dial-multiscreen-org:schemas:dial\" dialVer=\"1.7\">\n" +
                "  <name>YouTube</name>\n" +
                "  <options allowStop=\"true\"/>\n" +
                "  <state>stopped</state>\n" +
                "</service>";
    }
}
