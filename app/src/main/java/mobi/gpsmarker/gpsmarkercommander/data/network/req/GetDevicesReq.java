package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class GetDevicesReq {
    private String method;
    private GetDevicesOption options;

    public GetDevicesReq(String method, GetDevicesOption options) {
        this.method = method;
        this.options = options;
    }
}
