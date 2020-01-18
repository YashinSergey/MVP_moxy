package com.iashinsergei.mvpmoxy.ui;

import com.arellomobile.mvp.MvpView;
import com.iashinsergei.mvpmoxy.data.model.RequestModel;



public interface MainView extends MvpView {
    void initRecyclerView(RequestModel model);
    void showNetworkErrorMassage();
}
