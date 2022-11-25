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

        upnpDto.setXmlns("urn:schemas-upnp-org:device-1-0");
        upnpDeviceDto.setDeviceType("urn:schemas-upnp-org:device:tvdevice:1");
        upnpDeviceDto.setFriendlyName(friendlyName);
        upnpDeviceDto.setManufacturer("boghy933");
        upnpDeviceDto.setUdn("uuid:Upnp-TVEmulator-1_0-1234567890001");
        upnpDto.setDeviceDto(upnpDeviceDto);

        return upnpDto;
    }
}
