package com.szn.project.materialtransitionanimator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.szn.project.materialtransitionanimator.scence.CustomTransitionActivity;
import com.szn.project.materialtransitionanimator.scence.SceneChangeBoundsActivity;
import com.szn.project.materialtransitionanimator.scence.SceneChangeClipBoundsActivity;
import com.szn.project.materialtransitionanimator.scence.SceneChangeImageTransformActivity;
import com.szn.project.materialtransitionanimator.scence.SceneChangeTransformActivity;
import com.szn.project.materialtransitionanimator.scence.SceneFadeSlideExplodeActivity;

/**
 * @author suzhuning
 * @date 2017/3/13.
 * Description:
 */
public class ScenceActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        initToolbar();
    }

    private void initToolbar() {
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

    public void changeBounds(View view){
        startActivity(new Intent(this, SceneChangeBoundsActivity.class));
    }
    public void changeTransform(View view){
        startActivity(new Intent(this, SceneChangeTransformActivity.class));
    }
    public void changeClipBounds(View view){
        startActivity(new Intent(this, SceneChangeClipBoundsActivity.class));
    }
    public void changeImageTransform(View view){
        startActivity(new Intent(this, SceneChangeImageTransformActivity.class));
    }
    public void fade(View view){
        startActivity(new Intent(this, SceneFadeSlideExplodeActivity.class));
    }

    public void changeColor(View v){
        startActivity(new Intent(this, CustomTransitionActivity.class));
    }

}
