package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180ChangeModeTempSignalOption {

    public String id_user;
    public String token;
    public String id_device;
    public M180ChangeModeTempSignalData data;

    public M180ChangeModeTempSignalOption(String id_user, String token, String id_device, M180ChangeModeTempSignalData data) {
        this.id_user = id_user;
        this.token = token;
        this.id_device = id_device;
        this.data = data;
    }
}
