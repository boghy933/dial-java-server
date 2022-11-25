package com.example.castPlayer.service.app;

import com.example.castPlayer.model.OptionsDto;
import com.example.castPlayer.model.ServiceDto;
import org.springframework.stereotype.Service;

@Service
public class Youtube {

    // TODO: use h2 to track of app status
    public ServiceDto getStatus() {

        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setName("YouTube");
        serviceDto.setState("stopped");
        serviceDto.setXmlns("urn:dial-multiscreen-org:schemas:dial");
        serviceDto.setDialVer("1.7");
        serviceDto.setOptionsDto(new OptionsDto(true));

        return serviceDto;
    }
}
