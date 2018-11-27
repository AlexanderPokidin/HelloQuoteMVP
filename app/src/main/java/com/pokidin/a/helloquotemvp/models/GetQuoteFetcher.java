package com.pokidin.a.helloquotemvp.models;

public interface GetQuoteFetcher {

    void getNextQuote(OnFinishedListener listener);

    interface OnFinishedListener {
        void onFinished(String string);
    }
}
