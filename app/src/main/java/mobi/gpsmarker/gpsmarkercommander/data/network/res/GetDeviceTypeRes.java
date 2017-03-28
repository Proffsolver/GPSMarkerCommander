package mobi.gpsmarker.gpsmarkercommander.data.network.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDeviceTypeRes {


    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("device_type")
    @Expose
    private List<DeviceType> devices = null;

    public String getError() {
        return error;
    }

    public List<DeviceType> getDevices() {
        return devices;
    }

    public class DeviceType {

        @SerializedName("id_device_type")
        @Expose
        private String idDeviceType;
        @SerializedName("name_device")
        @Expose
        private String nameDevice;

        public String getIdDeviceType() {
            return idDeviceType;
        }

        public String getNameDevice() {
            return nameDevice;
        }

        public String getCode() {
            return code;
        }

    }

}
