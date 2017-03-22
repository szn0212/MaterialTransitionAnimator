package com.szn.project.materialtransitionanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author suzhuning
 * @date 2017/3/13.
 * Description:
 */
public class BeginDelayedActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView topLeft;
    private ImageView topRight;
    private ImageView bottomLeft;
    private ImageView bottomRight;
    private RelativeLayout scenceRoot;
    private boolean isImageBigger;
    private int primarySize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_delayed);
        initToolBar();
        initView();
    }

    @Override
    public void onClick(View v) {
        TransitionManager.beginDelayedTransition(scenceRoot, TransitionInflater.from(this)
                .inflateTransition(R.transition.explode_and_changebounds));
        changeScence(v);
    }

    private void changeScence(View v) {
        changeSize(v);
        changeVisibility(topLeft, topRight, bottomLeft, bottomRight);
        v.setVisibility(View.VISIBLE);
    }

    /**
     * view的宽高1.5倍和原尺寸大小切换
     * 配合ChangeBounds实现缩放效果
     * @param v
     */
    private void changeSize(View v) {
        isImageBigger = !isImageBigger;
        ViewGroup.LayoutParams params = v.getLayoutParams();
        if(isImageBigger){
            params.width = (int) (1.5 * primarySize);
            params.height = (int) (1.5 * primarySize);
        }else {
            params.width = primarySize;
            params.height = primarySize;
        }
        v.setLayoutParams(params);
    }

    /**
     * VISIBLE和INVISIBLE状态切换
     * @param views
     */
    private void changeVisibility(View ...views){
        for (View view:views){
            view.setVisibility(view.getVisibility()==View.VISIBLE?View.INVISIBLE:View.VISIBLE);
        }
    }

    private void initView() {
        scenceRoot = (RelativeLayout) findViewById(R.id.scence_root);
        topLeft = (ImageView) findViewById(R.id.topLeft);
        topRight = (ImageView) findViewById(R.id.topRight);
        bottomLeft = (ImageView) findViewById(R.id.bottomLeft);
        bottomRight = (ImageView) findViewById(R.id.bottomRight);
        primarySize = topLeft.getLayoutParams().width;
        topLeft.setOnClickListener(this);
        topRight.setOnClickListener(this);
        bottomLeft.setOnClickListener(this);
        bottomRight.setOnClickListener(this);
    }


    private void initToolBar() {
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
