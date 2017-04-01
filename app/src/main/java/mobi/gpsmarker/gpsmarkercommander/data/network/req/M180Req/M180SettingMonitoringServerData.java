package mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req;


public class M180SettingMonitoringServerData {
    private String url_server_device;
    private String port_sever_device;

    public M180SettingMonitoringServerData(String url_server_device, String port_sever_device){
        this.url_server_device = url_server_device;
        this.port_sever_device = port_sever_device;
    }
}
