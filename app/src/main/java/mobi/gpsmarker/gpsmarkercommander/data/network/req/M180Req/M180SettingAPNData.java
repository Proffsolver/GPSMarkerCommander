package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180SettingAPNData {

    private String url_apn_device;
    private String login_apn_device;
    private String password_apn_device;

    public M180SettingAPNData(String url_apn_device, String login_apn_device,
                                       String password_apn_device){
        this.url_apn_device = url_apn_device;
        this.login_apn_device = login_apn_device;
        this.password_apn_device = password_apn_device;
    }
}
