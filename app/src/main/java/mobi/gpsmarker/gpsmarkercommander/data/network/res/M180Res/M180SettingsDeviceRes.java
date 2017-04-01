package mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class M180SettingsDeviceRes {


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
        @SerializedName("adtrack_device_on")
        @Expose
        public int adtrackDeviceOn;

        @SerializedName("balance_device_on")
        @Expose
        public int balanceDeviceOn;

        @SerializedName("button_device_on")
        @Expose
        public int buttonDeviceOn;

        @SerializedName("gps_device_on")
        @Expose
        public int gpsDeviceOn;
        @SerializedName("internet_device_on")
        @Expose
        public int internetDeviceOn;
        @SerializedName("jack_device_on")
        @Expose
        public int jackDeviceOn;
        @SerializedName("language_device")
        @Expose
        public int languageDevice;
        @SerializedName("latitube_device")
        @Expose
        public String latitubeDevice;

        @SerializedName("lbs_device_on")
        @Expose
        public int lbsDeviceOn;
        @SerializedName("longitube_device")
        @Expose
        public String longitubeDevice;

        @SerializedName("min_balance_device")
        @Expose
        public String minBalanceDevice;
        @SerializedName("mode_device")
        @Expose
        public int modeDevice;
        @SerializedName("move_device")
        @Expose
        public int moveDevice;
        @SerializedName("move_device_on")
        @Expose
        public int moveDeviceOn;
        @SerializedName("name_device")
        @Expose
        public String nameDevice;
        @SerializedName("name_device_on")
        @Expose
        public int nameDeviceOn;
        @SerializedName("radius_device")
        @Expose
        public int radiusDevice;
        @SerializedName("speed_device")
        @Expose
        public int speedDevice;
        @SerializedName("speed_device_on")
        @Expose
        public int speedDeviceOn;

        @SerializedName("temp_device_on")
        @Expose
        public int tempDeviceOn;
        @SerializedName("temp_imp_device")
        @Expose
        public int tempImpDevice;
        @SerializedName("temp_relay_sms_device")
        @Expose
        public int tempRelaySmsDevice;
        @SerializedName("time_park_device")
        @Expose
        public String timeParkDevice;
        @SerializedName("time_send_message_device")
        @Expose
        public int timeSendMessageDevice;
        @SerializedName("unmove_device")
        @Expose
        public int unmoveDevice;
        @SerializedName("unmove_device_on")
        @Expose
        public int unmoveDeviceOn;
        @SerializedName("unsleep_sms_device")
        @Expose
        public int unsleepSmsDevice;

        @SerializedName("ussd_balance_device")
        @Expose
        public String ussd_balance_device;
        @SerializedName("utc_device")
        @Expose
        public String utcDevice;
        @SerializedName("worry_call_device")
        @Expose
        public int worryCallDevice;

        public String getError() {
            return error;
        }

        public String getCode() {
            return code;
        }

        public int getAdtrackDeviceOn() {
            return adtrackDeviceOn;
        }



        public int getBalanceDeviceOn() {
            return balanceDeviceOn;
        }



        public int getButtonDeviceOn() {
            return buttonDeviceOn;
        }







        public int getGpsDeviceOn() {
            return gpsDeviceOn;
        }

        public int getInternetDeviceOn() {
            return internetDeviceOn;
        }

        public int getJackDeviceOn() {
            return jackDeviceOn;
        }

        public int getLanguageDevice() {
            return languageDevice;
        }

        public String getLatitubeDevice() {
            return latitubeDevice;
        }


        public int getLbsDeviceOn() {
            return lbsDeviceOn;
        }

        public String getLongitubeDevice() {
            return longitubeDevice;
        }



        public String getMinBalanceDevice() {
            return minBalanceDevice;
        }

        public int getModeDevice() {
            return modeDevice;
        }

        public int getMoveDevice() {
            return moveDevice;
        }

        public int getMoveDeviceOn() {
            return moveDeviceOn;
        }

        public String getNameDevice() {
            return nameDevice;
        }

        public int getNameDeviceOn() {
            return nameDeviceOn;
        }

        public int getRadiusDevice() {
            return radiusDevice;
        }

        public int getSpeedDevice() {
            return speedDevice;
        }

        public int getSpeedDeviceOn() {
            return speedDeviceOn;
        }



        public int getTempDeviceOn() {
            return tempDeviceOn;
        }

        public int getTempImpDevice() {
            return tempImpDevice;
        }

        public int getTempRelaySmsDevice() {
            return tempRelaySmsDevice;
        }

        public String getTimeParkDevice() {
            return timeParkDevice;
        }

        public int getTimeSendMessageDevice() {
            return timeSendMessageDevice;
        }

        public int getUnmoveDevice() {
            return unmoveDevice;
        }

        public int getUnmoveDeviceOn() {
            return unmoveDeviceOn;
        }

        public int getUnsleepSmsDevice() {
            return unsleepSmsDevice;
        }

        public String getUtcDevice() {
            return utcDevice;
        }

        public int getWorryCallDevice() {
            return worryCallDevice;
        }

        public void setAdtrackDeviceOn(int adtrackDeviceOn) {
            this.adtrackDeviceOn = adtrackDeviceOn;
        }


        public void setBalanceDeviceOn(int balanceDeviceOn) {
            this.balanceDeviceOn = balanceDeviceOn;
        }

        public void setButtonDeviceOn(int buttonDeviceOn) {
            this.buttonDeviceOn = buttonDeviceOn;
        }






        public void setGpsDeviceOn(int gpsDeviceOn) {
            this.gpsDeviceOn = gpsDeviceOn;
        }

/*        public void setGpsUrlDevice(int gpsUrlDevice) {
            this.gpsUrlDevice = gpsUrlDevice;
        }*/

        public void setInternetDeviceOn(int internetDeviceOn) {
            this.internetDeviceOn = internetDeviceOn;
        }

        public void setJackDeviceOn(int jackDeviceOn) {
            this.jackDeviceOn = jackDeviceOn;
        }

        public void setLanguageDevice(int languageDevice) {
            this.languageDevice = languageDevice;
        }

        public String getUssd_balance_device() {
            return ussd_balance_device;
        }

        public void setUssd_balance_device(String ussd_balance_device) {
            this.ussd_balance_device = ussd_balance_device;
        }

        public void setLatitubeDevice(String latitubeDevice) {
            this.latitubeDevice = latitubeDevice;
        }



        public void setLbsDeviceOn(int lbsDeviceOn) {
            this.lbsDeviceOn = lbsDeviceOn;
        }

        public void setLongitubeDevice(String longitubeDevice) {
            this.longitubeDevice = longitubeDevice;
        }



        public void setMinBalanceDevice(String minBalanceDevice) {
            this.minBalanceDevice = minBalanceDevice;
        }

        public void setModeDevice(int modeDevice) {
            this.modeDevice = modeDevice;
        }

        public void setMoveDevice(int moveDevice) {
            this.moveDevice = moveDevice;
        }

        public void setMoveDeviceOn(int moveDeviceOn) {
            this.moveDeviceOn = moveDeviceOn;
        }

        public void setNameDevice(String nameDevice) {
            this.nameDevice = nameDevice;
        }

        public void setNameDeviceOn(int nameDeviceOn) {
            this.nameDeviceOn = nameDeviceOn;
        }

        public void setRadiusDevice(int radiusDevice) {
            this.radiusDevice = radiusDevice;
        }

        public void setSpeedDevice(int speedDevice) {
            this.speedDevice = speedDevice;
        }

        public void setSpeedDeviceOn(int speedDeviceOn) {
            this.speedDeviceOn = speedDeviceOn;
        }



        public void setTempDeviceOn(int tempDeviceOn) {
            this.tempDeviceOn = tempDeviceOn;
        }

        public void setTempImpDevice(int tempImpDevice) {
            this.tempImpDevice = tempImpDevice;
        }

        public void setTempRelaySmsDevice(int tempRelaySmsDevice) {
            this.tempRelaySmsDevice = tempRelaySmsDevice;
        }

        public void setTimeParkDevice(String timeParkDevice) {
            this.timeParkDevice = timeParkDevice;
        }

        public void setTimeSendMessageDevice(int timeSendMessageDevice) {
            this.timeSendMessageDevice = timeSendMessageDevice;
        }

        public void setUnmoveDevice(int unmoveDevice) {
            this.unmoveDevice = unmoveDevice;
        }

        public void setUnmoveDeviceOn(int unmoveDeviceOn) {
            this.unmoveDeviceOn = unmoveDeviceOn;
        }

        public void setUnsleepSmsDevice(int unsleepSmsDevice) {
            this.unsleepSmsDevice = unsleepSmsDevice;
        }

        public void setUtcDevice(String utcDevice) {
            this.utcDevice = utcDevice;
        }

        public void setWorryCallDevice(int worryCallDevice) {
            this.worryCallDevice = worryCallDevice;
        }
    }
}
