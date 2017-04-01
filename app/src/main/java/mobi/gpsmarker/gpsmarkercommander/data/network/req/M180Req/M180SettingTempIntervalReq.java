package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180SettingTempIntervalReq {

    private String method;
    private M180SettingTempIntervalOption options;

    public M180SettingTempIntervalReq(String method, M180SettingTempIntervalOption options) {
        this.method = method;
        this.options = options;
    }

}
