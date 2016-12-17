package mobi.gpsmarker.gpsmarkercommander.data.managers;

import android.content.Context;

import mobi.gpsmarker.gpsmarkercommander.data.network.RestService;
import mobi.gpsmarker.gpsmarkercommander.data.network.ServiceGenerator;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserLoginReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserLoginRes;
import mobi.gpsmarker.gpsmarkercommander.utils.GPSMarkerCommanderApp;
import retrofit2.Call;

public class DataManager {

    private static DataManager INSTANCE = null;

    private Context mContext;
    private PreferenceManager mPreferenceManager;
    private RestService mRestService;


    public DataManager() {
        this.mPreferenceManager = new PreferenceManager();
        this.mContext = GPSMarkerCommanderApp.getContext();
        this.mRestService = ServiceGenerator.createService(RestService.class);
    }


    public static DataManager getInstance(){
        if (INSTANCE==null){
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public PreferenceManager getPreferenceManager() {
        return mPreferenceManager;
    }

    public Call<UserLoginRes> loginUser(UserLoginReq userLoginReq){
        return mRestService.loginUser(userLoginReq);
    }

    public Call<GetDevicesRes> getDevices(GetDevicesReq getDevicesReq){
        return mRestService.getDevices(getDevicesReq);
    }
}
