package mobi.gpsmarker.gpsmarkercommander.data.network.req;


public class UserDataChangeData {

    public String email_user;
    public String phone_user;

    public UserDataChangeData(String email_user, String phone_user) {
        this.email_user = email_user;
        this.phone_user = phone_user;
    }
}
