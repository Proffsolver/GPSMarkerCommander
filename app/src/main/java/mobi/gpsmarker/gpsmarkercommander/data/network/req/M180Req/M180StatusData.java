package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;

public class M180StatusData {

    private String count_device_gps;
    private String battery_device;
    private String count_device_lbs;
    private String balance_device;
    private String temp_device;
    private String date_device_data;

    public M180StatusData(String count_device_gps,
                          String battery_device,
                          String count_device_lbs,
                          String balance_device,
                          String temp_device,
                          String date_device_data){
        this.battery_device = battery_device;
        this.count_device_gps = count_device_gps;
        this.count_device_lbs = count_device_lbs;
        this.balance_device = balance_device;
        this.temp_device = temp_device;
        this.date_device_data = date_device_data;
    }
}
