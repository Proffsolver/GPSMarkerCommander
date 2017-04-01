package mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class M180SettingAPNRes {

    @SerializedName("error")
    @Expose
    private String error;

    public String getCode() {
        return code;
    }

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getError() {
        return error;
    }

    public List<Datum> getData() {
        return data;
    }

    public class Datum {

        @SerializedName("error")
        @Expose
        public String error;

        public String getCode() {
            return code;
        }

        @SerializedName("code")
        @Expose
        private String code;

        @SerializedName("url_apn_device")
        @Expose
        public String urlApnDevice;

        @SerializedName("login_apn_device")
        @Expose
        public String loginApnDevice;

        public String getUrlApnDevice() {
            return urlApnDevice;
        }

        public String getLoginApnDevice() {
            return loginApnDevice;
        }

        public String getPasswordApnDevice() {
            return passwordApnDevice;
        }

        public void setUrlApnDevice(String urlApnDevice) {

            this.urlApnDevice = urlApnDevice;
        }

        public void setLoginApnDevice(String loginApnDevice) {
            this.loginApnDevice = loginApnDevice;
        }

        public void setPasswordApnDevice(String passwordApnDevice) {
            this.passwordApnDevice = passwordApnDevice;
        }

        @SerializedName("password_apn_device")
        @Expose

        public String passwordApnDevice;
    }
}
