package com.example.castPlayer.model.upnp;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class UpnpDto {

    private String xmlns;
    private UpnpSpecVersion specVersion;
    private UpnpDeviceDto deviceDto;

    @XmlAttribute(name="xmlns")
    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public UpnpSpecVersion getSpecVersion() {
        return specVersion;
    }

    public void setSpecVersion(UpnpSpecVersion specVersion) {
        this.specVersion = specVersion;
    }

    @XmlElement(name="device")
    public UpnpDeviceDto getDeviceDto() {
        return deviceDto;
    }

    public void setDeviceDto(UpnpDeviceDto deviceDto) {
        this.deviceDto = deviceDto;
    }
}
