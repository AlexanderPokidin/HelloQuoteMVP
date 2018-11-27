package com.pokidin.a.helloquotemvp.presenters;

import com.pokidin.a.helloquotemvp.contracts.MainContract;
import com.pokidin.a.helloquotemvp.views.MainActivity;

public class MainPresenterImpl implements MainContract.MainPresenter, MainContract.GetQuoteFetcher.OnFinishedListener {

    private MainContract.MainView mMainView;
    private MainContract.GetQuoteFetcher mGetQuoteFetcher;

    public MainPresenterImpl(MainActivity mainView, MainContract.GetQuoteFetcher getQuoteFetcher) {
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
