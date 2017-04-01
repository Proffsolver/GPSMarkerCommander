package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180ChangeModeTempSignalReq {

    private String method;
    private M180ChangeModeTempSignalOption options;

    public M180ChangeModeTempSignalReq(String method, M180ChangeModeTempSignalOption options) {
        this.method = method;
        this.options = options;
    }


}
