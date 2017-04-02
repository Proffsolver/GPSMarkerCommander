package mobi.gpsmarker.gpsmarkercommander.data.storage.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusData;

import static android.R.attr.data;

public class DeviceData {
    private String sDDIdDevice;
    private String sDDIdDeviceType;
    private String sDDNameDevice;
    private String sDDImeiDevice;
    private String sDDBalanceDevice;
    private String sDDBatteryDevice;
    private String sDDCountDeviceGps;
    private String sDDCountDeviceLbs;
    private String sDDDateDeviceData;
    private String sDDTempDevice;


    public DeviceData(String sDDIdDevice,
                      String sDDIdDeviceType,
                      String sDDNameDevice,
                      String sDDImeiDevice,
                      String sDDBalanceDevice,
                      String sDDBatteryDevice,
                      String sDDCountDeviceGps,
                      String sDDCountDeviceLbs,
                      String sDDDateDeviceData,
                      String sDDTempDevice) {
        this.sDDIdDevice = sDDIdDevice;
        this.sDDIdDeviceType = sDDIdDeviceType;
        this.sDDNameDevice = sDDNameDevice;
        this.sDDImeiDevice = sDDImeiDevice;
        this.sDDBalanceDevice = sDDBalanceDevice;
        this.sDDBatteryDevice = sDDBatteryDevice;
        this.sDDCountDeviceGps = sDDCountDeviceGps;
        this.sDDCountDeviceLbs = sDDCountDeviceLbs;
        this.sDDDateDeviceData = sDDDateDeviceData;
        this.sDDTempDevice = sDDTempDevice;
    }

    public String getsDDIdDevice() {
        return sDDIdDevice;
    }

    public String getsDDIdDeviceType() {
        return sDDIdDeviceType;
    }

    public String getsDDNameDevice() {
        return sDDNameDevice;
    }

    public String getsDDImeiDevice() {
        return sDDImeiDevice;
    }

    public String getsDDBalanceDevice() {
        return sDDBalanceDevice;
    }

    public String getsDDBatteryDevice() {
        return sDDBatteryDevice;
    }

    public String getsDDCountDeviceGps() {
        return sDDCountDeviceGps;
    }

    public String getsDDCountDeviceLbs() {
        return sDDCountDeviceLbs;
    }

    public String getsDDDateDeviceData() {
        return sDDDateDeviceData;
    }

    public String getsDDTempDevice() {
        return sDDTempDevice;
    }

    public void setsDDIdDevice(String sDDIdDevice) {
        this.sDDIdDevice = sDDIdDevice;
    }

    public void setsDDIdDeviceType(String sDDIdDeviceType) {
        this.sDDIdDeviceType = sDDIdDeviceType;
    }

    public void setsDDNameDevice(String sDDNameDevice) {
        this.sDDNameDevice = sDDNameDevice;
    }

    public void setsDDImeiDevice(String sDDImeiDevice) {
        this.sDDImeiDevice = sDDImeiDevice;
    }

    public void setsDDBalanceDevice(String sDDBalanceDevice) {
        this.sDDBalanceDevice = sDDBalanceDevice;
    }

    public void setsDDBatteryDevice(String sDDBatteryDevice) {
        this.sDDBatteryDevice = sDDBatteryDevice;
    }

    public void setsDDCountDeviceGps(String sDDCountDeviceGps) {
        this.sDDCountDeviceGps = sDDCountDeviceGps;
    }

    public void setsDDCountDeviceLbs(String sDDCountDeviceLbs) {
        this.sDDCountDeviceLbs = sDDCountDeviceLbs;
    }

    public void setsDDDateDeviceData(String sDDDateDeviceData) {
        this.sDDDateDeviceData = sDDDateDeviceData;
    }

    public void setsDDTempDevice(String sDDTempDevice) {
        this.sDDTempDevice = sDDTempDevice;
    }
}
