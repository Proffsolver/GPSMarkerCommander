package mobi.gpsmarker.gpsmarkercommander.data.network.req;

import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusOption;

public class CurrentCoordinateReq {

    private String method;
    private CurrentCoordinateOption options;

    public CurrentCoordinateReq(String method, CurrentCoordinateOption options) {
        this.method = method;
        this.options = options;
    }
}
