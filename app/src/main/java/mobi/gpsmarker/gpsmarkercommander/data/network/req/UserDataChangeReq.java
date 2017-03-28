package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class UserDataChangeReq {

    private String method;
    private UserDataChangeOption options;

    public UserDataChangeReq(String method, UserDataChangeOption options) {
        this.method = method;
        this.options = options;
    }
}
