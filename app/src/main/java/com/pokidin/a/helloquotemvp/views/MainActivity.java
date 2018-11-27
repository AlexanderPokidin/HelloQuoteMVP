package com.pokidin.a.helloquotemvp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pokidin.a.helloquotemvp.R;
import com.pokidin.a.helloquotemvp.contracts.MainContract;
import com.pokidin.a.helloquotemvp.models.GetQuoteFetcherImpl;
import com.pokidin.a.helloquotemvp.presenters.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private TextView mTextView;
    private Button mButton;
    private ProgressBar mProgressBar;
    MainContract.MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mProgressBar = findViewById(R.id.progressBar);
        mMainPresenter = new MainPresenterImpl(this, new GetQuoteFetcherImpl());
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.onButtonClick();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        mTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        mTextView.setText(string);
    }
}
