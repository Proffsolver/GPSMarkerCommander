package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class SettingsDeviceReq {

    private String method;
    private SettingsDeviceOption options;

    public SettingsDeviceReq (String method, SettingsDeviceOption options) {
        this.method = method;
        this.options = options;
    }
}