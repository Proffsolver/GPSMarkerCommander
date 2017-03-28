package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters;

public class M180GetDeviceListAlarmsOption {

    public String id_user;
    public String token;
    public String id_device;
    public M180GetDeviceListAlarmsData data;

    public M180GetDeviceListAlarmsOption(String id_user, String token, String id_device, M180GetDeviceListAlarmsData data) {
        this.id_user = id_user;
        this.token = token;
        this.id_device = id_device;
        this.data = data;
    }
}


