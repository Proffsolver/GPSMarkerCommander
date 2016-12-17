package mobi.gpsmarker.gpsmarkercommander.data.network.interceptors;

import java.io.IOException;
import mobi.gpsmarker.gpsmarkercommander.data.managers.PreferenceManager;

import mobi.gpsmarker.gpsmarkercommander.data.managers.DataManager;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
        PreferenceManager pm = DataManager.getInstance().getPreferenceManager();

        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("X-Access-Token", pm.getAuthToken())
                .header("Request-User-Id", pm.getUserId())
                .header("User-Agent", "GPSMarkerCommander")
                .header("Cache-Control", "max-age="+(60*60*24));

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
