package com.pokidin.a.helloquotemvp.models;

import com.pokidin.a.helloquotemvp.contracts.MainContract;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GetQuoteFetcherImpl implements MainContract.GetQuoteFetcher {

    private List<String> quoteList = Arrays.asList(
            "Be yourself. everyone else is already taken.",
            "A room without books is like a body without a soul.",
            "You only live once, but if you do it right, once is enough.",
            "Be the change that you wish to see in the world.",
            "If you tell the truth, you don't have to remember anything."
    );

    @Override
    public void getNextQuote(final OnFinishedListener listener) {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(getRandomString());
            }
        }, 1200);
    }

    private String getRandomString() {
        Random random = new Random();
        int index = random.nextInt(quoteList.size());
        return quoteList.get(index);
    }
}
