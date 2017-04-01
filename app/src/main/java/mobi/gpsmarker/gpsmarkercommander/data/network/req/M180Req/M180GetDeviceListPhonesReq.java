package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180GetDeviceListPhonesReq {

    private String method;
    private M180GetDeviceListPhonesOption options;

    public M180GetDeviceListPhonesReq(String method, M180GetDeviceListPhonesOption options) {
        this.method = method;
        this.options = options;
    }

}
