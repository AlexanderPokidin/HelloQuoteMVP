package com.pokidin.a.helloquotemvp.presenters;

import com.pokidin.a.helloquotemvp.models.GetQuoteFetcher;
import com.pokidin.a.helloquotemvp.views.MainView;

public class MainPresenterImpl implements MainPresenter, GetQuoteFetcher.OnFinishedListener {

    private MainView mMainView;
    private GetQuoteFetcher mGetQuoteFetcher;

    public MainPresenterImpl(MainView mainView, GetQuoteFetcher getQuoteFetcher) {
        mMainView = mainView;
        mGetQuoteFetcher = getQuoteFetcher;
    }

    @Override
    public void onFinished(String string) {
        if (mMainView != null) {
            mMainView.setQuote(string);
            mMainView.hideProgress();
        }
    }

    @Override
    public void onButtonClick() {
        if (mMainView != null) {
            mMainView.showProgress();
        }
        mGetQuoteFetcher.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }
}
