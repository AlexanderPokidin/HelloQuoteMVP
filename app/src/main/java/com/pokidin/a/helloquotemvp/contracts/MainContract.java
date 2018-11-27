package com.pokidin.a.helloquotemvp.contracts;

public interface MainContract {

    interface GetQuoteFetcher {
        void getNextQuote(OnFinishedListener listener);

        interface OnFinishedListener {
            void onFinished(String string);
        }
    }

    interface MainView {
        void showProgress();

        void hideProgress();

        void setQuote(String string);
    }

    interface MainPresenter {
        void onButtonClick();

        void onDestroy();
    }

}
