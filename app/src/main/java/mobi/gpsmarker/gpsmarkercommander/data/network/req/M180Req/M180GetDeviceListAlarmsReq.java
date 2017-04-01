package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180GetDeviceListAlarmsReq {

    private String method;
    private M180GetDeviceListAlarmsOption options;

    public M180GetDeviceListAlarmsReq(String method, M180GetDeviceListAlarmsOption options) {
        this.method = method;
        this.options = options;
    }



}
