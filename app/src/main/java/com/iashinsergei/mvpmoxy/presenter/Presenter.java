package com.iashinsergei.mvpmoxy.presenter;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.iashinsergei.mvpmoxy.data.RetrofitData;
import com.iashinsergei.mvpmoxy.data.model.RequestModel;
import com.iashinsergei.mvpmoxy.ui.MainView;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class Presenter extends MvpPresenter<MainView> {

    @SuppressLint("StaticFieldLeak")
    public Presenter() {
        new AsyncTask<Void,Void,Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                updateData();
                return null;
            }
        }.execute();
    }

    private void updateData() {
        RetrofitData.getRetrofitData().getAPI().loadData()
                .enqueue(new Callback<RequestModel>() {
                    @Override
                    public void onResponse(@NonNull Call<RequestModel> call, @NonNull Response<RequestModel> response) {
                        if (response.body() != null && response.isSuccessful()) {
                            getViewState().initRecyclerView(response.body());
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<RequestModel> call, @NonNull Throwable t) {
                        Log.e("RESPONSE", Objects.requireNonNull(t.getMessage()));
                        getViewState().showNetworkErrorMassage();
                    }
                });
    }
}
