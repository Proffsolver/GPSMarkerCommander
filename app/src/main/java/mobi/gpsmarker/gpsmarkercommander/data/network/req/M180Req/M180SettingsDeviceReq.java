package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180SettingsDeviceReq {

    private String method;
    private M180SettingsDeviceOption options;

    public M180SettingsDeviceReq(String method, M180SettingsDeviceOption options) {
        this.method = method;
        this.options = options;
    }
}