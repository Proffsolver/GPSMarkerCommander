package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class UserSetPasswordOption {

    private String id_user;
    private String token;
    private String password_user_old;
    private String password_user_new;

    public UserSetPasswordOption(String id_user, String token, String password_user_old, String password_user_new) {
        this.id_user = id_user;
        this.token = token;
        this.password_user_old = password_user_old;
        this.password_user_new = password_user_new;
    }
}
