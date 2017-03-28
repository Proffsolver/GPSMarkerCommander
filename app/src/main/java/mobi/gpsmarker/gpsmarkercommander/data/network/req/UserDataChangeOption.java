package mobi.gpsmarker.gpsmarkercommander.data.network.req;


public class UserDataChangeOption {

    public String id_user;
    public String token;
    public UserDataChangeData data;

    public UserDataChangeOption(String id_user, String token, UserDataChangeData data) {
        this.id_user = id_user;
        this.token = token;
        this.data = data;
    }
}
