package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180SettingAPNReq {
    private String method;
    private M180SettingAPNOption options;

    public M180SettingAPNReq(String method, M180SettingAPNOption options) {
        this.method = method;
        this.options = options;
    }

}
