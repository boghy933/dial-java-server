package com.example.castPlayer.model.upnp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


public class UpnpServiceListDto {

    private List<UpnpServiceDto> serviceList;

    @XmlElement(name="service")
    public List<UpnpServiceDto> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<UpnpServiceDto> serviceList) {
        this.serviceList = serviceList;
    }
}
