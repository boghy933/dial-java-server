package com.example.castPlayer.service;

import com.example.castPlayer.model.upnp.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DeviceDescriptionService {

    @Value("${configuration.upnp.friendlyName}")
    private String friendlyName;

    public UpnpDto deviceDescription() {
        UpnpDto upnpDto = new UpnpDto();
        UpnpDeviceDto upnpDeviceDto = new UpnpDeviceDto();
        // UpnpServiceListDto upnpServiceListDto = new UpnpServiceListDto();

/*
        List<UpnpServiceDto> serviceList = new ArrayList<>();
        UpnpServiceDto upnpServiceDto1 = new UpnpServiceDto();
        UpnpServiceDto upnpServiceDto2 = new UpnpServiceDto();

        upnpServiceDto1.setServiceType("urn:schemas-upnp-org:service:tvcontrol:1");
        upnpServiceDto1.setServiceId("urn:upnp-org:serviceId:tvcontrol1");
        upnpServiceDto1.setControlUrl("/upnp/control/tvcontrol1");
        upnpServiceDto1.setEventSubUrl("/upnp/event/tvcontrol1");

        upnpServiceDto2.setServiceType("urn:schemas-upnp-org:service:tvpicture:1");
        upnpServiceDto2.setServiceId("urn:upnp-org:serviceId:tvpicture1");
        upnpServiceDto2.setControlUrl("/upnp/control/tvpicture1");
        upnpServiceDto2.setEventSubUrl("/upnp/event/tvpicture1");

        serviceList.add(upnpServiceDto1);
        serviceList.add(upnpServiceDto2);
        upnpServiceListDto.setServiceList(serviceList);
*/


        upnpDeviceDto.setDeviceType("urn:schemas-upnp-org:device:tvdevice:1");
        upnpDeviceDto.setFriendlyName(friendlyName);
        upnpDeviceDto.setManufacturer("boghy933");
        upnpDeviceDto.setUdn("uuid:Upnp-TVEmulator-1_0-1234567890001");
        // upnpDeviceDto.setUpc("123456789");
        // upnpDeviceDto.setSerialNumber("123456789001");
        // upnpDeviceDto.setModelDescription("UPnP Television Device Emulator 1.0");
        // upnpDeviceDto.setModelName("TVEmulator");
        // upnpDeviceDto.setModelNumber("1.0");
        // upnpDeviceDto.setServiceList(upnpServiceListDto);
        upnpDto.setDeviceDto(upnpDeviceDto);
        // upnpDto.setSpecVersion(new UpnpSpecVersion(1,0));
        upnpDto.setXmlns("urn:schemas-upnp-org:device-1-0");

        return upnpDto;
    }
}
