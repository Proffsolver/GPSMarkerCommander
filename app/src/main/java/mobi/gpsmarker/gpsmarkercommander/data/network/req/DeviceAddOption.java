package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class DeviceAddOption {

    private String id_user;
    private String token;
    private String id_device_type;
    private String imei_device;
    private String name_device;

    public DeviceAddOption(String id_user, String token, String id_device_type, String imei_device, String name_device) {
        this.id_user = id_user;
        this.token = token;
        this.id_device_type = id_device_type;
        this.imei_device = imei_device;
        this.name_device = name_device;
    }

}
