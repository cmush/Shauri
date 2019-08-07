package interview.cmush.shauri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvFortune;
    Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFortune = findViewById(R.id.tv_fortune);
        btnRefresh = findViewById(R.id.btn_refresh);

        UshauriApiService ushauriApiService = UshauriClient.getInstance().getUshauriApiService();
        Call<Fortune> fortuneCall = ushauriApiService.getFortune();
        fortuneCall.enqueue(new Callback<Fortune>() {
            @Override
            public void onResponse(Call<Fortune> call, Response<Fortune> response) {
                Log.d("response code", String.valueOf(response.code()));
                Log.d("response", String.valueOf(response.body().getFortune().toString()));
                if (response.isSuccessful()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    List<String> fortunes = response.body().getFortune();
                    for (String f : fortunes) {
                        stringBuilder = stringBuilder.append(f);
                    }
                    String fortuneStr = stringBuilder.toString();
                    tvFortune.setText(fortuneStr);
                    return;
                } else {
                    tvFortune.setText(getResources().getString(R.string.prompt_refresh));
                    Log.e("response_unsuccessful", String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<Fortune> call, Throwable t) {
                tvFortune.setText(getResources().getString(R.string.prompt_refresh));
                Log.e("onFailure", t.getMessage());
            }
        });
    }
}
