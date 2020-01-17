package com.iashinsergei.mvpmoxy.ui;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.iashinsergei.mvpmoxy.R;
import com.iashinsergei.mvpmoxy.data.RequestModel;
import com.iashinsergei.mvpmoxy.data.RetrofitData;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainView {

    private ImageView image;
    private TextView textView;
    RequestModel body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        updateData();
    }

    private void initViews() {
        image = findViewById(R.id.image);
        textView = findViewById(R.id.text_view);
    }


    private void updateData() {
        RetrofitData.getWeatherData().getAPI().loadData()
                .enqueue(new Callback<RequestModel>() {
                    @Override
                    public void onResponse(@NonNull Call<RequestModel> call,@NonNull Response<RequestModel> response) {
                        if (response.body() != null && response.isSuccessful()) {
                            body = response.body();
                            renderData(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<RequestModel> call, @NonNull Throwable t) {
                        Toast.makeText(getApplicationContext(), getString(R.string.network_error),
                                Toast.LENGTH_SHORT).show();
                        Log.e("RESPONSE", Objects.requireNonNull(t.getMessage()));
                    }
                });
    }

    @Override
    public void renderData(RequestModel model) {
//        Log.d("TEST",  model.getMainDataList().toString());
//        Uri uri = Uri.parse(model.getMainDataList().get(0).getData().getUrl());
//        image.setImageURI(uri);

        textView.setText(model.getViewList().get(0));
    }
}
