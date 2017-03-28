package mobi.gpsmarker.gpsmarkercommander.data.network.res;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginRes {

    @SerializedName("error")
    @Expose
    private String error;

    public String getCode() {
        return code;
    }

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("email_user")
    @Expose
    private String emailUser;
    @SerializedName("phone_user")
    @Expose
    private String phoneUser;
    @SerializedName("token")
    @Expose
    private String token;

    public String getError() {
        return error;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public String getToken() {
        return token;
    }
}