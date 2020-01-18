package com.iashinsergei.mvpmoxy.ui;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.iashinsergei.mvpmoxy.R;
import com.iashinsergei.mvpmoxy.data.model.RequestModel;
import com.iashinsergei.mvpmoxy.presenter.Presenter;
import com.iashinsergei.mvpmoxy.ui.adapter.RvAdapter;

import moxy.presenter.ProvidePresenter;


public class MainActivity extends AppCompatActivity implements MainView {


    @ProvidePresenter
    Presenter providePresenter() {
     return new Presenter(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void initRecyclerView(RequestModel model){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RvAdapter adapter = new RvAdapter(model.getViewList(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
