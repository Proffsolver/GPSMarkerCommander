package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class DeviceDeleteOption {

    private String id_user;
    private String token;
    private String id_device;

    public DeviceDeleteOption(String id_user, String token, String id_device) {
        this.id_user = id_user;
        this.token = token;
        this.id_device = id_device;
    }

}
