package com.example.castPlayer.model.upnp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "specVersion")
public class UpnpSpecVersion {
    private int major;
    private int minor;

    public UpnpSpecVersion() {
    }

    public UpnpSpecVersion(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }
}
