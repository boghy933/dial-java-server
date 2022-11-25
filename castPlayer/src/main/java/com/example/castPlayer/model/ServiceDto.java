package com.example.castPlayer.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "service") // , namespace = "urn:dial-multiscreen-org:schemas:dial"
public class ServiceDto {

    private String name;
    private String state;
    private String xmlns;
    private String dialVer;
    private OptionsDto optionsDto;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlAttribute(name="xmlns")
    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    @XmlAttribute(name="dialVer")
    public String getDialVer() {
        return dialVer;
    }

    public void setDialVer(String dialVer) {
        this.dialVer = dialVer;
    }

    @XmlElement(name = "options")
    public OptionsDto getOptionsDto() {
        return optionsDto;
    }

    public void setOptionsDto(OptionsDto optionsDto) {
        this.optionsDto = optionsDto;
    }
}