package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class UserSetPasswordReq {

    private String method;
    private UserSetPasswordOption options;

    public UserSetPasswordReq(String method, UserSetPasswordOption options) {
        this.method = method;
        this.options = options;
    }
}
