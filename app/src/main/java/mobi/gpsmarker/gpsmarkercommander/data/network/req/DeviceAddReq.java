package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class DeviceAddReq {

    private String method;
    private DeviceAddOption options;

    public DeviceAddReq(String method, DeviceAddOption options) {
        this.method = method;
        this.options = options;
    }

}
