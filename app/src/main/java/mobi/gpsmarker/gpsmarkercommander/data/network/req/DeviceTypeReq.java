package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class DeviceTypeReq {

    private String method;
    private DeviceTypeOption options;

    public DeviceTypeReq(String method, DeviceTypeOption options) {
        this.method = method;
        this.options = options;
    }
}
