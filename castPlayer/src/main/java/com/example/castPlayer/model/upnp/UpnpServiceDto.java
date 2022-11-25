package com.example.castPlayer.model.upnp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "service")
public class UpnpServiceDto {
    private String serviceType;
    private String serviceId;
    private String controlUrl;
    private String eventSubUrl;
    private String scpdurl;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @XmlElement(name="controlURL")
    public String getControlUrl() {
        return controlUrl;
    }

    public void setControlUrl(String controlUrl) {
        this.controlUrl = controlUrl;
    }

    @XmlElement(name="eventSubURL")
    public String getEventSubUrl() {
        return eventSubUrl;
    }

    public void setEventSubUrl(String eventSubUrl) {
        this.eventSubUrl = eventSubUrl;
    }

    @XmlElement(name="SCPDURL")
    public String getScpdurl() {
        return scpdurl;
    }

    public void setScpdurl(String scpdurl) {
        this.scpdurl = scpdurl;
    }
}
