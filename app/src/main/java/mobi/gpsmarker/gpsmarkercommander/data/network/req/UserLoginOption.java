package mobi.gpsmarker.gpsmarkercommander.data.network.req;

public class UserLoginOption {

    public String login_user;
    public String password_user;

    public UserLoginOption(String login_user, String password_user) {
        this.login_user = login_user;
        this.password_user = password_user;
    }
}
