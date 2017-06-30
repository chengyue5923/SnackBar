package com.example.song.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by uniz-song on 2017/6/30.
 */

public class PlusSnackBarActivity extends AppCompatActivity implements View.OnClickListener {


    @Bind(R.id.tv1)
    TextView tv1;
    @Bind(R.id.tv2)
    TextView tv2;
    @Bind(R.id.tv3)
    TextView tv3;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    /**
     * 复杂的snackbar  封装
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View vs) {
        switch (vs.getId()) {
            case R.id.tv1:
                Snackbar.make(activityMain, "it is Snackbar", Snackbar.LENGTH_SHORT)
                        //设置按钮颜色
                        .setActionTextColor(Color.WHITE)
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(PlusSnackBarActivity.this, "it is Toast", Toast.LENGTH_SHORT).show();
                            }

                        }).show();
                break;
            case R.id.tv2:
                Snackbar.make(activityMain, "it is Snackbar", Snackbar.LENGTH_SHORT)
                        .setActionTextColor(Color.WHITE)
                        .setCallback(new Snackbar.Callback() {
                            @Override
                            public void onDismissed(Snackbar snackbar, int event) {
                                super.onDismissed(snackbar, event);
                                Toast.makeText(PlusSnackBarActivity.this, "Snackbar dismiss", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onShown(Snackbar snackbar) {
                                super.onShown(snackbar);
                                Toast.makeText(PlusSnackBarActivity.this, "Snackbar show", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setAction("Click", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(PlusSnackBarActivity.this, "it is Toast", Toast.LENGTH_SHORT).show();
                            }

                        }).show();
                break;
            case R.id.tv3:

                Snackbar mSnackbar=Snackbar.make(activityMain, "", Snackbar.LENGTH_SHORT);
                View v=mSnackbar.getView();
//                ViewGroup.LayoutParams vl = v.getLayoutParams();
//                CoordinatorLayout.LayoutParams cl = new CoordinatorLayout.LayoutParams(vl.width,vl.height);
                //设置字体为红色
//                ((TextView) v.findViewById(R.id.snackbar_text)).setTextColor(Color.RED);
                //设置显示位置居中
//                cl.gravity = Gravity.CENTER_VERTICAL;
//                v.setLayoutParams(cl);
                //设置背景色为绿色
//                v.setBackgroundColor(Color.GREEN);
                //自定义动画
                //v.setAnimation();
                //设置icon
//                ImageView iconImage=new ImageView(PlusSnackBarActivity.this);
//                iconImage.setImageResource(R.mipmap.ic_launcher);
                //icon插入布局
                View add_view= LayoutInflater.from(this).inflate(R.layout.snackbar_addview,null);
                LinearLayout.LayoutParams  params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                params.gravity= Gravity.CENTER_VERTICAL;
                Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) v;
                snackbarLayout.addView(add_view,0,params);
                mSnackbar.show();
                break;
        }
    }
}
