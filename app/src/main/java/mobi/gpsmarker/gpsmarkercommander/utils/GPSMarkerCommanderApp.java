package mobi.gpsmarker.gpsmarkercommander.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/*import com.facebook.stetho.Stetho;

import org.greenrobot.greendao.database.Database;*/

public class GPSMarkerCommanderApp extends Application{

    public static SharedPreferences sSharedPreferences;
    private static Context sContext;
  //  private static DaoSession sDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        sContext = getContext();

/*        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "gpsmc-db");
        Database db = helper.getWritableDb();
        sDaoSession = new DaoMaster(db).newSession();

        Stetho.initializeWithDefaults(this);*/
    }

    public static Context getContext(){ return sContext;}

    public static SharedPreferences getSharedPreferences() {
        return sSharedPreferences;
    }

 //   public static DaoSession getDaoSession() { return sDaoSession;  }
}
