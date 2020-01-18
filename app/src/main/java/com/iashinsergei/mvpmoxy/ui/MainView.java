package com.iashinsergei.mvpmoxy.ui;

import com.iashinsergei.mvpmoxy.data.model.RequestModel;

import moxy.MvpView;

public interface MainView extends MvpView {
    void initRecyclerView(RequestModel model);
    void showNetworkErrorMassage();
}
