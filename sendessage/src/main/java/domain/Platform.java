package domain;

import java.util.List;

public class Platform {
    /**
     * 设备类型
     */
    private String deviceType;
    /**
     * 订阅频道
     */
    private List channels;

    public Platform() {
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public List getChannels() {
        return channels;
    }

    public void setChannels(List channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "deviceType='" + deviceType + '\'' +
                ", channels=" + channels +
                '}';
    }
}
