package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180SettingTempIntervalData {
    private String temp_device_1;
    private String temp_device_2;

    public M180SettingTempIntervalData(String temp_device_1, String temp_device_2){
        this.temp_device_1 = temp_device_1;
        this.temp_device_2 = temp_device_2;
    }
}
