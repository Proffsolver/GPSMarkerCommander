package mobi.gpsmarker.gpsmarkercommander.data.network.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SettingsDeviceRes {

    @SerializedName("error")
    @Expose
    public String error;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

    public class Datum {

        @SerializedName("error")
        @Expose
        public String error;
        @SerializedName("mode_device")
        @Expose
        public int modeDevice;
        @SerializedName("language_device")
        @Expose
        public int languageDevice;
        @SerializedName("name_device")
        @Expose
        public String nameDevice;
        @SerializedName("name_device_on")
        @Expose
        public int nameDeviceOn;
        @SerializedName("gps_url_device")
        @Expose
        public int gpsUrlDevice;
        @SerializedName("gps_device_on")
        @Expose
        public int gpsDeviceOn;
        @SerializedName("unsleep_sms_device")
        @Expose
        public int unsleepSmsDevice;
        @SerializedName("worry_call_device")
        @Expose
        public int worryCallDevice;
        @SerializedName("time_park_device")
        @Expose
        public String timeParkDevice;
        @SerializedName("utc_device")
        @Expose
        public String utcDevice;
        @SerializedName("lbs_device_on")
        @Expose
        public int lbsDeviceOn;
        @SerializedName("phone_1_device")
        @Expose
        public Object phone1Device;
        @SerializedName("phone_1_device_on")
        @Expose
        public int phone1DeviceOn;
        @SerializedName("phone_2_device")
        @Expose
        public Object phone2Device;
        @SerializedName("phone_2_device_on")
        @Expose
        public int phone2DeviceOn;
        @SerializedName("phone_3_device")
        @Expose
        public Object phone3Device;
        @SerializedName("phone_3_device_on")
        @Expose
        public int phone3DeviceOn;
        @SerializedName("phone_4_device")
        @Expose
        public Object phone4Device;
        @SerializedName("phone_4_device_on")
        @Expose
        public int phone4DeviceOn;
        @SerializedName("phone_5_device")
        @Expose
        public Object phone5Device;
        @SerializedName("phone_5_device_on")
        @Expose
        public int phone5DeviceOn;
        @SerializedName("phone_6_device")
        @Expose
        public Object phone6Device;
        @SerializedName("phone_6_device_on")
        @Expose
        public int phone6DeviceOn;
        @SerializedName("phone_7_device")
        @Expose
        public Object phone7Device;
        @SerializedName("phone_7_device_on")
        @Expose
        public int phone7DeviceOn;
        @SerializedName("phone_8_device")
        @Expose
        public Object phone8Device;
        @SerializedName("phone_8_device_on")
        @Expose
        public int phone8DeviceOn;
        @SerializedName("phone_9_device")
        @Expose
        public Object phone9Device;
        @SerializedName("phone_9_device_on")
        @Expose
        public int phone9DeviceOn;
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
        @SerializedName("balance_device_on")
        @Expose
        public int balanceDeviceOn;
        @SerializedName("min_balance_device")
        @Expose
        public String minBalanceDevice;
        @SerializedName("ussd_balance_device")
        @Expose
        public Object ussdBalanceDevice;
        @SerializedName("button_device_on")
        @Expose
        public int buttonDeviceOn;
        @SerializedName("move_device")
        @Expose
        public int moveDevice;
        @SerializedName("move_device_on")
        @Expose
        public int moveDeviceOn;
        @SerializedName("unmove_device")
        @Expose
        public int unmoveDevice;
        @SerializedName("unmove_device_on")
        @Expose
        public int unmoveDeviceOn;
        @SerializedName("speed_device")
        @Expose
        public int speedDevice;
        @SerializedName("speed_device_on")
        @Expose
        public int speedDeviceOn;
        @SerializedName("jack_device_on")
        @Expose
        public int jackDeviceOn;
        @SerializedName("temp_device_on")
        @Expose
        public int tempDeviceOn;
        @SerializedName("temp_device_1")
        @Expose
        public String tempDevice1;
        @SerializedName("temp_device_2")
        @Expose
        public String tempDevice2;
        @SerializedName("temp_relay_device")
        @Expose
        public int tempRelayDevice;
        @SerializedName("temp_relay_sms_device")
        @Expose
        public int tempRelaySmsDevice;
        @SerializedName("temp_imp_device")
        @Expose
        public int tempImpDevice;
        @SerializedName("internet_device_on")
        @Expose
        public int internetDeviceOn;
        @SerializedName("url_server_device")
        @Expose
        public String urlServerDevice;
        @SerializedName("port_sever_device")
        @Expose
        public int portSeverDevice;
        @SerializedName("url_apn_device")
        @Expose
        public String urlApnDevice;
        @SerializedName("login_apn_device")
        @Expose
        public String loginApnDevice;
        @SerializedName("password_apn_device")
        @Expose
        public String passwordApnDevice;
        @SerializedName("time_send_message_device")
        @Expose
        public int timeSendMessageDevice;
        @SerializedName("adtrack_device_on")
        @Expose
        public int adtrackDeviceOn;
        @SerializedName("date_device_data")
        @Expose
        public String dateDeviceData;
        @SerializedName("battery_device")
        @Expose
        public String batteryDevice;
        @SerializedName("longitube_device_gps")
        @Expose
        public int longitubeDeviceGps;
        @SerializedName("latitube_device_gps")
        @Expose
        public int latitubeDeviceGps;
        @SerializedName("date_device_gps")
        @Expose
        public String dateDeviceGps;
        @SerializedName("count_device_gps")
        @Expose
        public String countDeviceGps;
        @SerializedName("longitube_device_lbs")
        @Expose
        public int longitubeDeviceLbs;
        @SerializedName("latitube_device_lbs")
        @Expose
        public int latitubeDeviceLbs;
        @SerializedName("date_device_lbs")
        @Expose
        public String dateDeviceLbs;
        @SerializedName("count_device_lbs")
        @Expose
        public String countDeviceLbs;
        @SerializedName("balance_device")
        @Expose
        public String balanceDevice;
        @SerializedName("temp_device")
        @Expose
        public String tempDevice;

    }
}
