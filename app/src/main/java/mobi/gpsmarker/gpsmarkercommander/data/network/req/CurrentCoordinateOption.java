package mobi.gpsmarker.gpsmarkercommander.data.network.req;

import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusData;
public class CurrentCoordinateOption {

    public String id_user;
    public String token;
    public String id_device;
    public CurrentCoordinateData data;

    public CurrentCoordinateOption(String id_user, String token, String id_device, CurrentCoordinateData data) {
        this.id_user = id_user;
        this.token = token;
        this.id_device = id_device;
        this.data = data;
    }
}
