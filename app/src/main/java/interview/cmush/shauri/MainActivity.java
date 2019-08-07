package interview.cmush.shauri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UshauriApi ushauriApi = retrofit.create(UshauriApi.class);
        Call<Fortune> fortuneCall = ushauriApi.getFortune();
        fortuneCall.enqueue(new Callback<Fortune>() {
            @Override
            public void onResponse(Call<Fortune> call, Response<Fortune> response) {
                if (!response.isSuccessful()) {
                    Log.d("onResponse", String.valueOf(response.body().getFortune().get(0)));
                    return;
                }
            }

            @Override
            public void onFailure(Call<Fortune> call, Throwable t) {
                Log.d("onResponse", t.getMessage());
            }
        });
    }
}
