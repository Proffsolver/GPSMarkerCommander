package mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class M180SettingMonitoringServerRes {

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

        @SerializedName("url_server_device")
        @Expose
        public String urlServerDevice;
        @SerializedName("port_sever_device")
        @Expose
        public int portSeverDevice;

        public String getUrlServerDevice() {
            return urlServerDevice;
        }

        public void setPortSeverDevice(int portSeverDevice) {
            this.portSeverDevice = portSeverDevice;
        }

        public int getPortSeverDevice() {
            return portSeverDevice;
        }

        public void setUrlServerDevice(String urlServerDevice) {
            this.urlServerDevice = urlServerDevice;
        }
    }
}
