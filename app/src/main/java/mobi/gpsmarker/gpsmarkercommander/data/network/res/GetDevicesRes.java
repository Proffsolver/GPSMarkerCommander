package mobi.gpsmarker.gpsmarkercommander.data.network.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDevicesRes {



    @SerializedName("error")
    @Expose
    private String error;

    public String getCode() {
        return code;
    }

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("devices")
    @Expose
    private List<Device> devices = null;

    public String getError() {
        return error;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public class Device {

        @SerializedName("id_device")
        @Expose
        private String idDevice;
        @SerializedName("id_device_type")
        @Expose
        private String idDeviceType;
        @SerializedName("name_device")
        @Expose
        private String nameDevice;
        @SerializedName("date_device")
        @Expose
        private String dateDevice;
        @SerializedName("imei_device")
        @Expose
        private String imeiDevice;

        public String getIdDevice() {
            return idDevice;
        }

        public String getIdDeviceType() {
            return idDeviceType;
        }

        public String getNameDevice() {
            return nameDevice;
        }

        public String getImeiDevice() {
            return imeiDevice;
        }

        public String getDateRegDevice() {
            return dateDevice;
        }
    }

}
