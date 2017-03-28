package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class DeviceDeleteReq {

    private String method;
    private DeviceDeleteOption options;

    public DeviceDeleteReq(String method, DeviceDeleteOption options) {
        this.method = method;
        this.options = options;
    }

}
