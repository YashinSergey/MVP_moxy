package com.iashinsergei.mvpmoxy.ui;


import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iashinsergei.mvpmoxy.R;
import com.iashinsergei.mvpmoxy.data.model.RequestModel;
import com.iashinsergei.mvpmoxy.presenter.Presenter;
import com.iashinsergei.mvpmoxy.ui.adapter.RvAdapter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;


public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void initRecyclerView(RequestModel model){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RvAdapter adapter = new RvAdapter(model.getViewList(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showNetworkErrorMassage() {
        Toast.makeText(this, String.valueOf(R.string.network_error_massage), Toast.LENGTH_SHORT).show();
    }
}
