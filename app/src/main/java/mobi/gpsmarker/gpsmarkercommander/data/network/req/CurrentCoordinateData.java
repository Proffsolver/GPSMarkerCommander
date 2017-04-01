package mobi.gpsmarker.gpsmarkercommander.data.network.req;

import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingsDeviceData;

public class CurrentCoordinateData {
    private String longitube_device_gps;
    private String latitube_device_gps;
    private String date_device_gps;
    private String longitube_device_lbs;
    private String latitube_device_lbs;
    private String date_device_lbs;
    private String lbs_device_on;
    private String gps_device_on;

    public CurrentCoordinateData(
            String longitube_device_gps,
            String latitube_device_gps,
            String date_device_gps,
            String longitube_device_lbs,
            String latitube_device_lbs,
            String date_device_lbs,
            String gps_device_on,
            String lbs_device_on){
        this.longitube_device_gps = longitube_device_gps;
        this.latitube_device_gps = latitube_device_gps;
        this.date_device_gps = date_device_gps;
        this.longitube_device_lbs = longitube_device_lbs;
        this.latitube_device_lbs = latitube_device_lbs;
        this.date_device_lbs = date_device_lbs;
        this.gps_device_on = gps_device_on;
        this.lbs_device_on = lbs_device_on;
    }
}
