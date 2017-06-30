package com.example.song.snackbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.tv3)
    TextView tv3;
    @Bind(R.id.tv4)
    TextView tv4;
    @Bind(R.id.tv5)
    TextView tv5;
    @Bind(R.id.tv6)
    TextView tv6;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    @Bind(R.id.tv7)
    TextView tv7;
    @Bind(R.id.tv8)
    TextView tv8;
    @Bind(R.id.tv9)
    TextView tv9;


    /**
     * 提示常用的snackbar  封装
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);
        activityMain.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                SnackBarUtils.ShortSnackBar(activityMain, "ShortSnackBar", SnackBarUtils.red, SnackBarUtils.blue).show();
                break;
            case R.id.tv2:
                SnackBarUtils.LongSnackBar(activityMain, "ShortSnackBar", SnackBarUtils.blue, SnackBarUtils.red).show();
                break;
            case R.id.tv3:
                SnackBarUtils.IndefiniteSnackbar(activityMain, "IndefiniteSnackbar", 2000, SnackBarUtils.orange, SnackBarUtils.red).show();
                break;
            case R.id.tv4:
                SnackBarUtils.ShortSnackbar(activityMain, "IndefiniteSnackbar", SnackBarUtils.Info).show();
                break;
            case R.id.tv5:
                SnackBarUtils.LongSnackbar(activityMain, "IndefiniteSnackbar", SnackBarUtils.Confirm).show();
                break;
            case R.id.tv6:
                SnackBarUtils.IndefiniteSnackbar(activityMain, "IndefiniteSnackbar", 2000, SnackBarUtils.Confirm).show();
                break;
            case R.id.tv7:
                Snackbar snackbar = SnackBarUtils.ShortSnackBar(activityMain, "", SnackBarUtils.red, SnackBarUtils.blue);
                SnackBarUtils.SnackbarAddView(snackbar
                        , R.layout.snackbar_addview, 0);
                snackbar.show();
                break;
            case R.id.activity_main:
                break;
            case R.id.tv8:
                Intent intent = new Intent(this, NetSnackBarActivity.class);
                startActivity(intent);
                break;
            case R.id.tv9:
                Intent intentw = new Intent(this, PlusSnackBarActivity.class);
                startActivity(intentw);
                break;
        }
    }
}
