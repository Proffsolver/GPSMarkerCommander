package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters;



public class M180GetDeviceListPhonesOption {

    public String id_user;
    public String token;
    public String id_device;
    public M180GetDeviceListPhonesData data;

    public M180GetDeviceListPhonesOption(String id_user, String token, String id_device, M180GetDeviceListPhonesData data) {
        this.id_user = id_user;
        this.token = token;
        this.id_device = id_device;
        this.data = data;
    }
}
