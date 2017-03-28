package mobi.gpsmarker.gpsmarkercommander.data.network.res.M180;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class M180ChangeModeTempSignalRes {

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
        @SerializedName("temp_relay_device")
        @Expose
        public int tempRelayDevice;


        public int getTempRelayDevice() {
            return tempRelayDevice;
        }


        public void setTempRelayDevice(int tempRelayDevice) {
            this.tempRelayDevice = tempRelayDevice;
        }
    }

}
