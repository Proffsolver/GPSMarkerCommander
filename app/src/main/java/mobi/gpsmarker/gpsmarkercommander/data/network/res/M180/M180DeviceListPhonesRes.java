package mobi.gpsmarker.gpsmarkercommander.data.network.res.M180;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.List;

import static android.R.attr.data;

    public class M180DeviceListPhonesRes {

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


            public void setPhone1Device(String phone1Device) {
                this.phone1Device = phone1Device;
            }

            public void setPhone1DeviceOn(int phone1DeviceOn) {
                this.phone1DeviceOn = phone1DeviceOn;
            }

            public void setPhone2Device(String phone2Device) {
                this.phone2Device = phone2Device;
            }

            public void setPhone2DeviceOn(int phone2DeviceOn) {
                this.phone2DeviceOn = phone2DeviceOn;
            }

            public void setPhone3Device(String phone3Device) {
                this.phone3Device = phone3Device;
            }

            public void setPhone3DeviceOn(int phone3DeviceOn) {
                this.phone3DeviceOn = phone3DeviceOn;
            }

            public void setPhone4Device(String phone4Device) {
                this.phone4Device = phone4Device;
            }

            public void setPhone4DeviceOn(int phone4DeviceOn) {
                this.phone4DeviceOn = phone4DeviceOn;
            }

            public void setPhone5Device(String phone5Device) {
                this.phone5Device = phone5Device;
            }

            public void setPhone5DeviceOn(int phone5DeviceOn) {
                this.phone5DeviceOn = phone5DeviceOn;
            }

            public void setPhone6Device(String phone6Device) {
                this.phone6Device = phone6Device;
            }

            public void setPhone6DeviceOn(int phone6DeviceOn) {
                this.phone6DeviceOn = phone6DeviceOn;
            }

            public void setPhone7Device(String phone7Device) {
                this.phone7Device = phone7Device;
            }

            public void setPhone7DeviceOn(int phone7DeviceOn) {
                this.phone7DeviceOn = phone7DeviceOn;
            }

            public void setPhone8Device(String phone8Device) {
                this.phone8Device = phone8Device;
            }

            public void setPhone8DeviceOn(int phone8DeviceOn) {
                this.phone8DeviceOn = phone8DeviceOn;
            }

            public void setPhone9Device(String phone9Device) {
                this.phone9Device = phone9Device;
            }

            public void setPhone9DeviceOn(int phone9DeviceOn) {
                this.phone9DeviceOn = phone9DeviceOn;
            }


        }
    }
