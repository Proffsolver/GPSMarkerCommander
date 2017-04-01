package mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class M180DeviceListPhonesRes {

    @SerializedName("error")
    @Expose
    public String error;
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

    public String getError() {
        return error;
    }

    public String getCode() {
        return code;
    }

    public List<Datum> getData() {
        return data;
    }

    public class Datum {

        @SerializedName("error")
        @Expose
        public String error;
        @SerializedName("code")
        @Expose
        public String code;
        @SerializedName("phone_1_device")
        @Expose
        public String phone1Device;
        @SerializedName("phone_1_device_on")
        @Expose
        public int phone1DeviceOn;
        @SerializedName("phone_2_device")
        @Expose
        public String phone2Device;
        @SerializedName("phone_2_device_on")
        @Expose
        public int phone2DeviceOn;
        @SerializedName("phone_3_device")
        @Expose
        public String phone3Device;
        @SerializedName("phone_3_device_on")
        @Expose
        public int phone3DeviceOn;
        @SerializedName("phone_4_device")
        @Expose
        public String phone4Device;
        @SerializedName("phone_4_device_on")
        @Expose
        public int phone4DeviceOn;
        @SerializedName("phone_5_device")
        @Expose
        public String phone5Device;
        @SerializedName("phone_5_device_on")
        @Expose
        public int phone5DeviceOn;
        @SerializedName("phone_6_device")
        @Expose
        public String phone6Device;
        @SerializedName("phone_6_device_on")
        @Expose
        public int phone6DeviceOn;
        @SerializedName("phone_7_device")
        @Expose
        public String phone7Device;
        @SerializedName("phone_7_device_on")
        @Expose
        public int phone7DeviceOn;
        @SerializedName("phone_8_device")
        @Expose
        public String phone8Device;
        @SerializedName("phone_8_device_on")
        @Expose
        public int phone8DeviceOn;
        @SerializedName("phone_9_device")
        @Expose
        public String phone9Device;
        @SerializedName("phone_9_device_on")
        @Expose
        public int phone9DeviceOn;

        public String getError() {
            return error;
        }

        public String getCode() {
            return code;
        }

        public String getPhone1Device() {
            return phone1Device;
        }

        public int getPhone1DeviceOn() {
            return phone1DeviceOn;
        }

        public String getPhone2Device() {
            return phone2Device;
        }

        public int getPhone2DeviceOn() {
            return phone2DeviceOn;
        }

        public String getPhone3Device() {
            return phone3Device;
        }

        public int getPhone3DeviceOn() {
            return phone3DeviceOn;
        }

        public String getPhone4Device() {
            return phone4Device;
        }

        public int getPhone4DeviceOn() {
            return phone4DeviceOn;
        }

        public String getPhone5Device() {
            return phone5Device;
        }

        public int getPhone5DeviceOn() {
            return phone5DeviceOn;
        }

        public String getPhone6Device() {
            return phone6Device;
        }

        public int getPhone6DeviceOn() {
            return phone6DeviceOn;
        }

        public String getPhone7Device() {
            return phone7Device;
        }

        public int getPhone7DeviceOn() {
            return phone7DeviceOn;
        }

        public String getPhone8Device() {
            return phone8Device;
        }

        public int getPhone8DeviceOn() {
            return phone8DeviceOn;
        }

        public String getPhone9Device() {
            return phone9Device;
        }

        public int getPhone9DeviceOn() {
            return phone9DeviceOn;
        }
    }

}
