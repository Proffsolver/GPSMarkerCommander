package mobi.gpsmarker.gpsmarkercommander.data.network.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentCoordinateRes {

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

        @SerializedName("date_device_gps")
        @Expose
        public String dateDeviceGps;
        @SerializedName("date_device_lbs")
        @Expose
        public String dateDeviceLbs;

        @SerializedName("latitube_device_gps")
        @Expose
        public String latitubeDeviceGps;
        @SerializedName("latitube_device_lbs")
        @Expose
        public String latitubeDeviceLbs;

        @SerializedName("longitube_device_gps")
        @Expose
        public String longitubeDeviceGps;
        @SerializedName("longitube_device_lbs")
        @Expose
        public String longitubeDeviceLbs;
        @SerializedName("lbs_device_on")
        @Expose
        public int lbsDeviceOn;
        @SerializedName("gps_device_on")
        @Expose
        public int gpsDeviceOn;

        public int getGpsDeviceOn() {
            return gpsDeviceOn;
        }

        public void setGpsDeviceOn(int gpsDeviceOn) {
            this.gpsDeviceOn = gpsDeviceOn;
        }

        public int getLbsDeviceOn() {
            return lbsDeviceOn;
        }

        public void setLbsDeviceOn(int lbsDeviceOn) {
            this.lbsDeviceOn = lbsDeviceOn;
        }



        public String getDateDeviceGps() {
            return dateDeviceGps;
        }

        public String getDateDeviceLbs() {
            return dateDeviceLbs;
        }

        public String getLatitubeDeviceGps() {
            return latitubeDeviceGps;
        }

        public String getLatitubeDeviceLbs() {
            return latitubeDeviceLbs;
        }

        public String getLongitubeDeviceGps() {
            return longitubeDeviceGps;
        }

        public String getLongitubeDeviceLbs() {
            return longitubeDeviceLbs;
        }

        public void setDateDeviceGps(String dateDeviceGps) {
            this.dateDeviceGps = dateDeviceGps;
        }

        public void setDateDeviceLbs(String dateDeviceLbs) {
            this.dateDeviceLbs = dateDeviceLbs;
        }

        public void setLatitubeDeviceGps(String latitubeDeviceGps) {
            this.latitubeDeviceGps = latitubeDeviceGps;
        }

        public void setLatitubeDeviceLbs(String latitubeDeviceLbs) {
            this.latitubeDeviceLbs = latitubeDeviceLbs;
        }

        public void setLongitubeDeviceGps(String longitubeDeviceGps) {
            this.longitubeDeviceGps = longitubeDeviceGps;
        }

        public void setLongitubeDeviceLbs(String longitubeDeviceLbs) {
            this.longitubeDeviceLbs = longitubeDeviceLbs;
        }
    }
}