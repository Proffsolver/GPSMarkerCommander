package mobi.gpsmarker.gpsmarkercommander.data.network.res.M180;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class M180DeviceListAlarmRes {

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
        @SerializedName("unsleep_alarm_device")
        @Expose
        public String unsleepAlarmDevice;
        @SerializedName("alarm_1_device")
        @Expose
        public String alarm1Device;
        @SerializedName("alarm_1_device_on")
        @Expose
        public int alarm1DeviceOn;
        @SerializedName("alarm_2_device")
        @Expose
        public String alarm2Device;
        @SerializedName("alarm_2_device_on")
        @Expose
        public int alarm2DeviceOn;
        @SerializedName("alarm_3_device")
        @Expose
        public String alarm3Device;
        @SerializedName("alarm_3_device_on")
        @Expose
        public int alarm3DeviceOn;
        @SerializedName("alarm_4_device")
        @Expose
        public String alarm4Device;
        @SerializedName("alarm_4_device_on")
        @Expose
        public int alarm4DeviceOn;
        @SerializedName("alarm_5_device")
        @Expose
        public String alarm5Device;
        @SerializedName("alarm_5_device_on")
        @Expose
        public int alarm5DeviceOn;
        @SerializedName("alarm_6_device")
        @Expose
        public String alarm6Device;
        @SerializedName("alarm_6_device_on")
        @Expose
        public int alarm6DeviceOn;
        @SerializedName("alarm_7_device")
        @Expose
        public String alarm7Device;
        @SerializedName("alarm_7_device_on")
        @Expose
        public int alarm7DeviceOn;
        @SerializedName("alarm_8_device")
        @Expose
        public String alarm8Device;
        @SerializedName("alarm_8_device_on")
        @Expose
        public int alarm8DeviceOn;
        @SerializedName("alarm_9_device")
        @Expose
        public String alarm9Device;
        @SerializedName("alarm_9_device_on")
        @Expose
        public int alarm9DeviceOn;

        public String getAlarm1Device() {
            return alarm1Device;
        }

        public int getAlarm1DeviceOn() {
            return alarm1DeviceOn;
        }

        public String getAlarm2Device() {
            return alarm2Device;
        }

        public int getAlarm2DeviceOn() {
            return alarm2DeviceOn;
        }

        public String getAlarm3Device() {
            return alarm3Device;
        }

        public int getAlarm3DeviceOn() {
            return alarm3DeviceOn;
        }

        public String getAlarm4Device() {
            return alarm4Device;
        }

        public int getAlarm4DeviceOn() {
            return alarm4DeviceOn;
        }

        public String getAlarm5Device() {
            return alarm5Device;
        }

        public int getAlarm5DeviceOn() {
            return alarm5DeviceOn;
        }

        public String getAlarm6Device() {
            return alarm6Device;
        }

        public int getAlarm6DeviceOn() {
            return alarm6DeviceOn;
        }

        public String getAlarm7Device() {
            return alarm7Device;
        }

        public int getAlarm7DeviceOn() {
            return alarm7DeviceOn;
        }

        public String getAlarm8Device() {
            return alarm8Device;
        }

        public int getAlarm8DeviceOn() {
            return alarm8DeviceOn;
        }

        public String getAlarm9Device() {
            return alarm9Device;
        }

        public int getAlarm9DeviceOn() {
            return alarm9DeviceOn;
        }

        public String getUnsleepAlarmDevice() {
            return unsleepAlarmDevice;
        }

        public void setUnsleepAlarmDevice(String unsleepAlarmDevice) {
            this.unsleepAlarmDevice = unsleepAlarmDevice;
        }

        public void setAlarm1Device(String alarm1Device) {
            this.alarm1Device = alarm1Device;
        }

        public void setAlarm1DeviceOn(int alarm1DeviceOn) {
            this.alarm1DeviceOn = alarm1DeviceOn;
        }

        public void setAlarm2Device(String alarm2Device) {
            this.alarm2Device = alarm2Device;
        }

        public void setAlarm2DeviceOn(int alarm2DeviceOn) {
            this.alarm2DeviceOn = alarm2DeviceOn;
        }

        public void setAlarm3Device(String alarm3Device) {
            this.alarm3Device = alarm3Device;
        }

        public void setAlarm3DeviceOn(int alarm3DeviceOn) {
            this.alarm3DeviceOn = alarm3DeviceOn;
        }

        public void setAlarm4Device(String alarm4Device) {
            this.alarm4Device = alarm4Device;
        }

        public void setAlarm4DeviceOn(int alarm4DeviceOn) {
            this.alarm4DeviceOn = alarm4DeviceOn;
        }

        public void setAlarm5Device(String alarm5Device) {
            this.alarm5Device = alarm5Device;
        }

        public void setAlarm5DeviceOn(int alarm5DeviceOn) {
            this.alarm5DeviceOn = alarm5DeviceOn;
        }

        public void setAlarm6Device(String alarm6Device) {
            this.alarm6Device = alarm6Device;
        }

        public void setAlarm6DeviceOn(int alarm6DeviceOn) {
            this.alarm6DeviceOn = alarm6DeviceOn;
        }

        public void setAlarm7Device(String alarm7Device) {
            this.alarm7Device = alarm7Device;
        }

        public void setAlarm7DeviceOn(int alarm7DeviceOn) {
            this.alarm7DeviceOn = alarm7DeviceOn;
        }

        public void setAlarm8Device(String alarm8Device) {
            this.alarm8Device = alarm8Device;
        }

        public void setAlarm8DeviceOn(int alarm8DeviceOn) {
            this.alarm8DeviceOn = alarm8DeviceOn;
        }

        public void setAlarm9Device(String alarm9Device) {
            this.alarm9Device = alarm9Device;
        }

        public void setAlarm9DeviceOn(int alarm9DeviceOn) {
            this.alarm9DeviceOn = alarm9DeviceOn;
        }
    }

}
