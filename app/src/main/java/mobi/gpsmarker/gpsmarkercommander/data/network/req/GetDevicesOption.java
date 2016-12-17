package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class GetDevicesOption {

    public String id_user;
    public String token;

    public GetDevicesOption(String id_user, String token) {
        this.id_user = id_user;
        this.token = token;
    }
}
