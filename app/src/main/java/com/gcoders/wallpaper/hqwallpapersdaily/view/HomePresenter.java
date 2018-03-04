package com.gcoders.wallpaper.hqwallpapersdaily.view;

import com.gcoders.wallpaper.hqwallpapersdaily.service.MyServiceManager;

import nucleus5.presenter.RxPresenter;
import okhttp3.OkHttpClient;

/**
 * Created by kondareddygudipati on 2/14/18.
 */

public class HomePresenter extends RxPresenter<HomePresenter.View> {

    public void callService(String searchString, OkHttpClient okHttpClient, MyServiceManager serviceManager) {

        /*serviceManager.callService(searchString, okHttpClient, new MyServiceManager.ServiceManagerCallBack() {
            @Override
            public void showLoading(final boolean flag) {
                getView().showProgressDialog(flag);
            }

            @Override
            public void onSuccess() {
                getView().navigateToImageLoadingPage();
            }

            @Override
            public void showErrorMessage(final String errorMessage) {
                getView().showProgressDialog(false);
                getView().showErrorMessage(errorMessage);
            }
        });*/
    }

    interface View {
        void showProgressDialog(boolean flag);

        void showErrorMessage(String errorMessage);

        void navigateToImageLoadingPage();
    }
}
