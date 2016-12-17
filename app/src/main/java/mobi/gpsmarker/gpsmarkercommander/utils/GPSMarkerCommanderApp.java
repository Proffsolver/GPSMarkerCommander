package mobi.gpsmarker.gpsmarkercommander.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class GPSMarkerCommanderApp extends Application{

    public static SharedPreferences sSharedPreferences;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public static Context getContext(){ return sContext;}

    public static SharedPreferences getSharedPreferences() {
        return sSharedPreferences;
    }

}
