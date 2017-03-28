package mobi.gpsmarker.gpsmarkercommander.data.network;

import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceAddReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceDeleteReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.DeviceTypeReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180ChangeModeTempSignalReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180GetDeviceListAlarmsReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180GetDeviceListPhonesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.M180Parameters.M180SettingsDeviceReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserDataChangeReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserLoginReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserRegReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserResetPasswordReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserSetPasswordReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180.M180ChangeModeTempSignalRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180.M180DeviceListAlarmRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180.M180DeviceListPhonesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180.M180SettingsDeviceRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserLoginRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserAccoutActionRes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RestService {

//    @POST("login")
//    Call<UserLoginRes> loginUser (@Body UserLoginReq req);

   // @POST
    @POST("api/")
    Call<UserLoginRes> loginUser(@Body UserLoginReq UserLogin);

    @POST("api/")
    Call<GetDevicesRes> getDevices(@Body GetDevicesReq GetDevices);

    @POST("api/")
    Call<M180SettingsDeviceRes> getM180SettingsDevice(@Body M180SettingsDeviceReq GetSettingsDevice);
    //   @Multipart
    //   @POST("user/{userId}/publicValues/profilePhoto")
    //   Call<UploadPhotoRes> uploadPhoto(@Path("userId") String userId),
    //                                    @Part MultipartBody.Part file);

    @POST("api/")
    Call<UserAccoutActionRes> setUserResetPassword(@Body UserResetPasswordReq userResetPasswordReq);

    @POST("api/")
    Call<UserAccoutActionRes> userRegistration(@Body UserRegReq userRegReq);

    @POST("api/")
    Call<UserAccoutActionRes> setUserPassword(@Body UserSetPasswordReq setUserPasswordReq);

    @POST("api/")
    Call<UserAccoutActionRes> newDeviceAdd(@Body DeviceAddReq newDeviceAddReq);

    @POST("api/")
    Call<UserAccoutActionRes> userDataChange(@Body UserDataChangeReq userDataChangeReq);

    @POST("api/")
    Call<UserAccoutActionRes> deviceDelete(@Body DeviceDeleteReq deviceDeleteReq);

    @POST("api/")
    Call<UserAccoutActionRes> setM180SettingsDevice(@Body M180SettingsDeviceReq setM180M180SettingsDeviceReq);

    @POST("api/")
    Call<UserAccoutActionRes> getDeviceType(@Body DeviceTypeReq deviceTypeReq);

    @POST("api/")
    Call<M180DeviceListPhonesRes> getDeviceListPhones(@Body M180GetDeviceListPhonesReq m180GetDeviceListPhonesReq);

    @POST("api/")
    Call<UserAccoutActionRes> setDeviceListPhones(@Body M180GetDeviceListPhonesReq m180SetDeviceListPhonesReq);

    @POST("api/")
    Call<M180DeviceListAlarmRes> getDeviceListAlarms(@Body M180GetDeviceListAlarmsReq m180GetDeviceListAlarmsReq);

    @POST("api/")
    Call<UserAccoutActionRes> setDeviceListAlarms(@Body M180GetDeviceListAlarmsReq m180SetDeviceListAlarmsReq);

    @POST("api/")
    Call<M180ChangeModeTempSignalRes> getTempSignal(@Body M180ChangeModeTempSignalReq m180GetTempSignalReq);

    @POST("api/")
    Call<UserAccoutActionRes> setTempSignal(@Body M180ChangeModeTempSignalReq m180SetTempSignalReq);
/*
    @GET("user/list?orderBy=rating")
    Call<UserListRes> getUserList();

    @Multipart
    @POST ("user/{userId}/publicValues/profilePhoto")
    Call<ResponseBody> uploadPhoto(@Path("userId") String userId, @Part MultipartBody.Part file);
*/

}