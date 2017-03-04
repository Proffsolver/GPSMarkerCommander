package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class SettingsDeviceOption {

    public String id_user;
    public String token;
    public String id_device;
    public SettingsDeviceM180Data data;

    public SettingsDeviceOption(String id_user, String token, String id_device, SettingsDeviceM180Data data) {
        this.id_user = id_user;
        this.token = token;
        this.id_device = id_device;
        this.data = data;
    }
}
