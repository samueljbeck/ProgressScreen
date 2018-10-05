package com.acst.progressscreen;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.rahatarmanahmed.cpv.CircularProgressView;

/**
 * Created by samuelbeck on 11/9/15.
 *
 * add
 *  include layout="@layout/progress_bar_bg"
 * to the bottom of your layout
 *
 * add  to Activity
 *
 * declaration
 *
 * ProgressScreen progressBar;
 *
 * super.onCreate(icicle);
 * this.setContentView(R.layout.login);
 * thisActivity = this;
 * progressBar = new ProgressBar(thisActivity);
 */
public class ProgressScreen {
    private Activity thisActivity;
    private CircularProgressView progressBar;
    private RelativeLayout progressHolder;

    public ProgressScreen(Activity _thisActivity) {
        thisActivity = _thisActivity;
        progressBar = thisActivity.findViewById(R.id.progressBarScreen);
        progressHolder = thisActivity.findViewById(R.id.progress_holder);
    }

    public ProgressScreen(Activity _thisActivity, View subView) {
        thisActivity = _thisActivity;
        progressBar = subView.findViewById(R.id.progressBarScreen);
        progressHolder = subView.findViewById(R.id.progress_holder);
    }

    public void on() {
        thisActivity.runOnUiThread(() -> {
            if (progressHolder != null) {
                progressHolder.setVisibility(View.VISIBLE);
                if (progressBar != null)
                    progressBar.setVisibility(View.VISIBLE);
            }

        });

    }

    public void off() {
        thisActivity.runOnUiThread(() -> {
            if (progressHolder != null) {
                progressHolder.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void holderOnlyOn() {
        thisActivity.runOnUiThread(() -> {
            if (progressHolder != null && progressBar != null) {
                progressHolder.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
                progressHolder.setOnClickListener(view -> holderOnlyOff());
            }
        });
    }

    public void holderOnlyOff() {
        thisActivity.runOnUiThread(() -> {
            if (progressHolder != null && progressBar != null) {
                progressHolder.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                progressHolder.setOnClickListener(view -> {

                });
            }
        });
    }


    public void showMessage(final String msg) {
        if (TextUtils.isEmpty(msg))
            return;

        thisActivity.runOnUiThread(() -> Toast.makeText(thisActivity.getBaseContext(), msg, Toast.LENGTH_SHORT).show());
    }

    public RelativeLayout getProgressHolder() {
        return progressHolder;
    }

}
