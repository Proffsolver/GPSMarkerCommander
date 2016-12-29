package mobi.gpsmarker.gpsmarkercommander.data.managers;

import android.content.SharedPreferences;

import mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager;
import mobi.gpsmarker.gpsmarkercommander.utils.GPSMarkerCommanderApp;

import static mobi.gpsmarker.gpsmarkercommander.utils.ConstantManager.TAG_PREFIX;

public class PreferenceManager {

    private SharedPreferences mSharedPreferences;

    public PreferenceManager() {
        this.mSharedPreferences = GPSMarkerCommanderApp.getSharedPreferences();
    }

    public void saveUserProfileData() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        //Данные для сохранения
        editor.apply();
    }

    public void loadUserProfileData() {
        //      Загрузка данных
        //    mSharedPreferences.getString(TAG_PREFIX);
    }

    public void saveAuthToken(String authToken) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.AUTH_TOKEN_KEY, authToken);
        editor.apply();
    }

    public String getAuthToken() {
        return mSharedPreferences.getString(ConstantManager.AUTH_TOKEN_KEY, "null");
    }


    public void saveUserId(String userId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_ID_KEY, userId);
        editor.apply();
    }

    public String getUserId() {
        return mSharedPreferences.getString(ConstantManager.USER_ID_KEY, "null");
    }


    public void saveUserEmail(String userId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_ID_EMAIL, userId);
        editor.apply();
    }

    public String getUserEmail() {
        return mSharedPreferences.getString(ConstantManager.USER_ID_EMAIL, "null");
    }

    public void saveUserMobile(String userId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.USER_ID_PHONE, userId);
        editor.apply();
    }

    public String getUserMobile() {
        return mSharedPreferences.getString(ConstantManager.USER_ID_PHONE, "null");
    }

    public void saveActiveDeviceId(String deviceId) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantManager.DEVICE_ID, deviceId);
        editor.apply();
    }

    public String getActiveDeviceId() {
        return mSharedPreferences.getString(ConstantManager.DEVICE_ID, "null");
    }
}
