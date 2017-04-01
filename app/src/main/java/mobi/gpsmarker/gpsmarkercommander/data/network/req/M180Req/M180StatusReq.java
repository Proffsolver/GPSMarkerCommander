package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180StatusReq {

    private String method;
    private M180StatusOption options;

    public M180StatusReq(String method, M180StatusOption options) {
        this.method = method;
        this.options = options;
    }
}
