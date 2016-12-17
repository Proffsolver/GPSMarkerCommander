package mobi.gpsmarker.gpsmarkercommander.data.network.req;


import android.graphics.Path;

public class UserLoginReq {

    private String method;
    private UserLoginOption options;

    public UserLoginReq(String method, UserLoginOption options) {
        this.method = method;
        this.options = options;
    }

}