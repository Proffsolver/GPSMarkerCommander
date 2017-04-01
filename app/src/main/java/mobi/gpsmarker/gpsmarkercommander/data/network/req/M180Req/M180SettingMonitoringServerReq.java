package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180SettingMonitoringServerReq {

    private String method;
    private M180SettingMonitoringServerOption options;

    public M180SettingMonitoringServerReq(String method, M180SettingMonitoringServerOption options) {
        this.method = method;
        this.options = options;
    }

}
