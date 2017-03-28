package mobi.gpsmarker.gpsmarkercommander.data.network.req;


public class UserResetPasswordReq {

    private String method;
    private UserResetPasswordOption options;

    public UserResetPasswordReq(String method, UserResetPasswordOption options) {
        this.method = method;
        this.options = options;
    }
}
