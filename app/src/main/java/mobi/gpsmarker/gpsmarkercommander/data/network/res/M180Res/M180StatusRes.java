package mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class M180StatusRes {

    @SerializedName("error")
    @Expose
    public String error;
    @SerializedName("code")
    @Expose
    public String code;

    public String getError() {
        return error;
    }

    public String getCode() {
        return code;
    }
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

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
        @SerializedName("balance_device")
        @Expose
        public String balanceDevice;
        @SerializedName("battery_device")
        @Expose
        public String batteryDevice;
        @SerializedName("count_device_gps")
        @Expose
        public String countDeviceGps;
        @SerializedName("count_device_lbs")
        @Expose
        public String countDeviceLbs;
        @SerializedName("date_device_data")
        @Expose
        public String dateDeviceData;
        @SerializedName("temp_device")
        @Expose
        public String tempDevice;

        public String getBalanceDevice() {
            return balanceDevice;
        }
        public String getBatteryDevice() {
            return batteryDevice;
        }
        public String getCountDeviceGps() {
            return countDeviceGps;
        }
        public void setDateDeviceData(String dateDeviceData) {
            this.dateDeviceData = dateDeviceData;
        }
        public String getCountDeviceLbs() {
            return countDeviceLbs;
        }
        public String getTempDevice() {
            return tempDevice;
        }
        public String getDateDeviceData() {
            return dateDeviceData;
        }

        public void setBalanceDevice(String balanceDevice) {
            this.balanceDevice = balanceDevice;
        }

        public void setBatteryDevice(String batteryDevice) {
            this.batteryDevice = batteryDevice;
        }
        public void setCountDeviceGps(String countDeviceGps) {
            this.countDeviceGps = countDeviceGps;
        }

        public void setCountDeviceLbs(String countDeviceLbs) {
            this.countDeviceLbs = countDeviceLbs;
        }
        public void setTempDevice(String tempDevice) {
            this.tempDevice = tempDevice;
        }
    }
}
