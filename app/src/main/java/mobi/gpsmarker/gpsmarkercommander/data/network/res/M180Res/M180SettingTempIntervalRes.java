package mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class M180SettingTempIntervalRes {

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

        @SerializedName("temp_device_1")
        @Expose
        public String tempDevice1;
        @SerializedName("temp_device_2")
        @Expose
        public String tempDevice2;

        public void setTempDevice1(String tempDevice1) {
            this.tempDevice1 = tempDevice1;
        }

        public void setTempDevice2(String tempDevice2) {
            this.tempDevice2 = tempDevice2;
        }

        public String getTempDevice1() {
            return tempDevice1;
        }

        public String getTempDevice2() {
            return tempDevice2;
        }
    }


}
