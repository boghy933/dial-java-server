package com.example.castPlayer.model;

import javax.xml.bind.annotation.XmlAttribute;

public class OptionsDto {
    private Boolean allowStop;

    public OptionsDto(Boolean allowStop) {
        this.allowStop = allowStop;
    }

    @XmlAttribute
    public Boolean getAllowStop() {
        return allowStop;
    }

    public void setAllowStop(Boolean allowStop) {
        this.allowStop = allowStop;
    }
}