package mobi.gpsmarker.gpsmarkercommander.data.storage.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusData;

import static android.R.attr.data;

public class DeviceData {
    private String sDDIdDevice;
    private String sDDIdDeviceType;
    private String sDDNameDevice;
    private String SDDImeiDevice;
    private String sDDBalanceDevice;
    private String sDDBatteryDevice;
    private String sDDCountDeviceGps;
    private String sDDCountDeviceLbs;
    private String sDDDateDeviceData;
    private String sDDTempDevice;


    public DeviceData(String sDDIdDevice,
                      String sDDIdDeviceType,
                      String sDDNameDevice,
                      String SDDImeiDevice,
                      String sDDBalanceDevice,
                      String sDDBatteryDevice,
                      String sDDCountDeviceGps,
                      String sDDCountDeviceLbs,
                      String sDDDateDeviceData,
                      String sDDTempDevice) {
        this.sDDIdDevice = sDDIdDevice;
        this.sDDIdDeviceType = sDDIdDeviceType;
        this.sDDNameDevice = sDDNameDevice;
        this.SDDImeiDevice = SDDImeiDevice;
        this.sDDBalanceDevice = sDDBalanceDevice;
        this.sDDBatteryDevice = sDDBatteryDevice;
        this.sDDCountDeviceGps = sDDCountDeviceGps;
        this.sDDCountDeviceLbs = sDDCountDeviceLbs;
        this.sDDDateDeviceData = sDDDateDeviceData;
        this.sDDTempDevice = sDDTempDevice;
    }
}
