package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

/**
 * Created by solver on 28.03.2017.
 */

public class M180SettingMonitoringServerOption {

    public String id_user;
    public String token;
    public String id_device;
    public M180SettingMonitoringServerData data;

    public M180SettingMonitoringServerOption(String id_user, String token, String id_device, M180SettingMonitoringServerData data) {
        this.id_user = id_user;
        this.token = token;
        this.id_device = id_device;
        this.data = data;
    }
}
