package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class UserRegReq {

    private String method;
    private UserRegOption options;

    public UserRegReq(String method, UserRegOption options) {
        this.method = method;
        this.options = options;
    }
}
