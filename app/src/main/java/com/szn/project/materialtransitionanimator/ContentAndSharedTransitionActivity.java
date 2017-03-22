package com.szn.project.materialtransitionanimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.szn.project.materialtransitionanimator.fragment.FragmentTransitionActivity;

/**
 * @author suzhuning
 * @date 2017/3/13.
 * Description:
 */
public class ContentAndSharedTransitionActivity extends AppCompatActivity {

    private ImageView shared_image;
    private TextView shared_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivty_with_shared);
        initView();
        initToolbar();
    }

    private void initView() {
        shared_image = (ImageView) findViewById(R.id.shared_image);
        shared_text = (TextView) findViewById(R.id.shared_text);

    }


    public void withShared(View view){
        Intent intent = new Intent(this, WithSharedElementTransitionsActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this
                ,new Pair<View, String>(shared_image,"shared_image_")
                ,new Pair<View, String>(shared_text,"shared_text_"));
        startActivity(intent,activityOptionsCompat.toBundle());
    }

    public void fragmentDemo(View view){
        startActivity(new Intent(this,FragmentTransitionActivity.class));
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
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
