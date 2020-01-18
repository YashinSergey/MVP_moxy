package com.iashinsergei.mvpmoxy.ui;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.iashinsergei.mvpmoxy.R;
import com.iashinsergei.mvpmoxy.data.RequestModel;
import com.iashinsergei.mvpmoxy.data.RetrofitData;
import com.iashinsergei.mvpmoxy.ui.adapter.RvAdapter;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainView {

    private SimpleDraweeView image;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        initViews();

        updateData();
    }

    private void initViews() {
        image = findViewById(R.id.image);

    }


    private void updateData() {
        RetrofitData.getRetrofitData().getAPI().loadData()
                .enqueue(new Callback<RequestModel>() {
                    @Override
                    public void onResponse(@NonNull Call<RequestModel> call,@NonNull Response<RequestModel> response) {
                        if (response.body() != null && response.isSuccessful()) {
                            initRecyclerView(response.body());
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

    private void initRecyclerView(RequestModel model){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RvAdapter adapter = new RvAdapter(model.getViewList(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void renderData(RequestModel model) {
//         image.setImageURI(model.getMainDataList().get(1).getData().getUrl());
//
////        for (String s : model.getViewList()) {
//            textView.append(model.getMainDataList().get(1).getData().getText());
////        }
    }
}
