package com.surya.apiandrecyclerviewmvp.presenter;

import android.view.View;

import com.surya.apiandrecyclerviewmvp.view.IView;

public class MainPresenter implements IPresenter {


    IView iView;

    public MainPresenter(IView iView) {
        this.iView = iView;
    }

    @Override
    public void handleButtonClick(View view) {
//        iView.showMessage("Button clicked.");
        iView.onButtonClick();
    }
}
