package mobi.gpsmarker.gpsmarkercommander.data.network;

import mobi.gpsmarker.gpsmarkercommander.data.network.req.GetDevicesReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.req.UserLoginReq;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.GetDevicesRes;
import mobi.gpsmarker.gpsmarkercommander.data.network.res.UserLoginRes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestService {

//    @POST("login")
//    Call<UserLoginRes> loginUser (@Body UserLoginReq req);

   // @POST("api/{method}")     //api/authorization
    @POST("api/")     //api/authorization
    Call<UserLoginRes> loginUser(@Body UserLoginReq UserLogin);

    @POST("api/")     //api/authorization
    Call<GetDevicesRes> getDevices(@Body GetDevicesReq GetDevices);
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