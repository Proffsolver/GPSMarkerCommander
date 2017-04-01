package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;


public class M180SettingAPNOption {

    public String id_user;
    public String token;
    public String id_device;
    public M180SettingAPNData data;

    public M180SettingAPNOption(String id_user, String token, String id_device, M180SettingAPNData data) {
        this.id_user = id_user;
        this.token = token;
        this.id_device = id_device;
        this.data = data;
    }
}
