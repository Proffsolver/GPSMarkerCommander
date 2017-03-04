package mobi.gpsmarker.gpsmarkercommander.data.network;

import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.SettingsDeviceReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserLoginReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.M180SettingsDeviceRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserLoginRes;
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
    Call<M180SettingsDeviceRes> getSettingsDevice(@Body SettingsDeviceReq GetSettingsDevice);
    //   @Multipart
    //   @POST("user/{userId}/publicValues/profilePhoto")
    //   Call<UploadPhotoRes> uploadPhoto(@Path("userId") String userId),
    //                                    @Part MultipartBody.Part file);

/*
    @GET("user/list?orderBy=rating")
    Call<UserListRes> getUserList();

    @Multipart
    @POST ("user/{userId}/publicValues/profilePhoto")
    Call<ResponseBody> uploadPhoto(@Path("userId") String userId, @Part MultipartBody.Part file);
*/

}