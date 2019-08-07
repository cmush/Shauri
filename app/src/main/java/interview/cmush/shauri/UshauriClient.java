package interview.cmush.shauri;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UshauriClient {
    private static UshauriClient instance;
    public static final String BASE_URL = BuildConfig.BASE_URL;

    private UshauriApiService ushauriApiService;

    public static UshauriClient getInstance() {
        if (instance == null) {
            instance = new UshauriClient();
        }

        return instance;
    }

    private UshauriClient() {
        buildRetrofit();
    }

    private void buildRetrofit() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        ushauriApiService = retrofit.create(UshauriApiService.class);
    }

    public UshauriApiService getUshauriApiService() {
        return ushauriApiService;
    }
}
