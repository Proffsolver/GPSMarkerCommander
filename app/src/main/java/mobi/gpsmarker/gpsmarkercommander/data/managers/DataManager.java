package mobi.gpsmarker.gpsmarkercommander.data.managers;

import android.content.Context;

import mobi.gpsmarker.gpsmarkercommander.data.network.RestService;
import mobi.gpsmarker.gpsmarkercommander.data.network.ServiceGenerator;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.CurrentCoordinateReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceAddReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceDeleteReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceTypeReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180ChangeModeTempSignalReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180GetDeviceListAlarmsReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180GetDeviceListPhonesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingAPNReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingMonitoringServerReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingTempIntervalReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180SettingsDeviceReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Req.M180StatusReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserDataChangeReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserLoginReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserRegReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserResetPasswordReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserSetPasswordReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.CurrentCoordinateRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180ChangeModeTempSignalRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180DeviceListAlarmRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180DeviceListPhonesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180SettingAPNRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180SettingMonitoringServerRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180SettingTempIntervalRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180SettingsDeviceRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180Res.M180StatusRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserLoginRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import mobi.gpsmarker.gpsmarkercommander.utils.GPSMarkerCommanderApp;
import retrofit2.Call;

public class DataManager {

    private static DataManager INSTANCE = null;

    private Context mContext;
    private PreferenceManager mPreferenceManager;
    private RestService mRestService;

   // private DaoSession mDaoSession;


    public Context getContext() {
        return mContext;
    }

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

    public Call<GetDevicesRes> getDevicesFromNetwork(GetDevicesReq getDevicesReq){
        return mRestService.getDevices(getDevicesReq);
    }

    public Call<M180SettingsDeviceRes> getM180SettingsDeviceFromNetwork(M180SettingsDeviceReq getM180SettingsDevice){
        return mRestService.getM180SettingsDevice(getM180SettingsDevice);
    }

    public Call<UserAccoutActionRes> setUserResetPassword(UserResetPasswordReq userResetPasswordReq){
        return mRestService.setUserResetPassword(userResetPasswordReq);
    }

    public Call<UserAccoutActionRes> userRegistration(UserRegReq userRegReq){
        return mRestService.userRegistration(userRegReq);
    }

    public Call<UserAccoutActionRes> setUserPassword(UserSetPasswordReq setUserPasswordReq){
        return mRestService.setUserPassword(setUserPasswordReq);
    }

    public Call<UserAccoutActionRes> newDeviceAdd(DeviceAddReq newDeviceAddReq){
            return mRestService.newDeviceAdd(newDeviceAddReq);
    }


    public Call<UserAccoutActionRes> userDataChange (UserDataChangeReq userDataChangeReq) {
        return mRestService.userDataChange(userDataChangeReq);
    }

    public Call<UserAccoutActionRes> deviceDelete (DeviceDeleteReq deviceDeleteReq) {
        return mRestService.deviceDelete(deviceDeleteReq);
    }

    public Call<UserAccoutActionRes> setM180SettingsDevice(M180SettingsDeviceReq setM180M180SettingsDeviceReq) {
        return mRestService.setM180SettingsDevice(setM180M180SettingsDeviceReq);
    }

    public Call<UserAccoutActionRes> getDeviceType(DeviceTypeReq deviceTypeReq) {
        return mRestService.getDeviceType(deviceTypeReq);
    }

    public Call<M180DeviceListPhonesRes> getM180DeviceListPhones(M180GetDeviceListPhonesReq deviceListPhonesReq) {
        return mRestService.getM180DeviceListPhones(deviceListPhonesReq);
    }

    public Call<UserAccoutActionRes> setDeviceListPhones(M180GetDeviceListPhonesReq deviceListPhonesReq) {
        return mRestService.setDeviceListPhones(deviceListPhonesReq);
    }

    public Call<M180DeviceListAlarmRes> getDeviceListAlarms(M180GetDeviceListAlarmsReq deviceListAlarmsReq) {
        return mRestService.getDeviceListAlarms(deviceListAlarmsReq);
    }

    public Call<UserAccoutActionRes> setDeviceListAlarms(M180GetDeviceListAlarmsReq m180SetDeviceListAlarmsReq) {
        return mRestService.setDeviceListAlarms(m180SetDeviceListAlarmsReq);
    }

    public Call<M180ChangeModeTempSignalRes> getTempSignal(M180ChangeModeTempSignalReq m180GetTempSignalReq) {
        return mRestService.getTempSignal(m180GetTempSignalReq);
    }

    public Call<UserAccoutActionRes> setTempSignal(M180ChangeModeTempSignalReq m180SetTempSignalReq) {
        return mRestService.setTempSignal(m180SetTempSignalReq);
    }

    public Call<M180SettingTempIntervalRes> getTempInterval(M180SettingTempIntervalReq m180SettingTempIntervalReq) {
        return mRestService.getTempInterval(m180SettingTempIntervalReq);
    }

    public Call<UserAccoutActionRes> setTempInterval(M180SettingTempIntervalReq m180SettingTempIntervalReq) {
        return mRestService.setTempInterval(m180SettingTempIntervalReq);
    }

    public Call<M180SettingAPNRes> getSettingAPN(M180SettingAPNReq m180SettingAPNReq) {
        return mRestService.getSettingAPN(m180SettingAPNReq);
    }

    public Call<UserAccoutActionRes> setSettingAPN(M180SettingAPNReq m180SettingAPNReq) {
        return mRestService.setSettingAPN(m180SettingAPNReq);
    }

    public Call<M180SettingMonitoringServerRes> getSettingMonitoringServer(M180SettingMonitoringServerReq m180SettingTempIntervalReq) {
        return mRestService.getSettingMonitoringServer(m180SettingTempIntervalReq);
    }

    public Call<UserAccoutActionRes> setSettingMonitoringServer(M180SettingMonitoringServerReq m180SettingTempIntervalReq) {
        return mRestService.setSettingMonitoringServer(m180SettingTempIntervalReq);
    }

    public Call<M180StatusRes> getM180Status(M180StatusReq m180StatusReq) {
        return mRestService.getM180Status(m180StatusReq);
    }

    public Call<CurrentCoordinateRes> getCurrentCoordinate(CurrentCoordinateReq mCurrentCoordinateReq) {
        return mRestService.getCurrentCoordinate(mCurrentCoordinateReq);
    }



/*    public List<M180Device> getM180DeviceFromDB (){
        List<M180Device> temp = new ArrayList<>();
        return temp;
    }

    public List<User> getUserFromDB (){
        List<User> temp = new ArrayList<>();
        return temp;
    }*/
}