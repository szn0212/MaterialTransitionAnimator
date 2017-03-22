package com.szn.project.materialtransitionanimator;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        getWindow().setExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.slide));
//        getWindow().setExitTransition(new Fade());
    }

    private void initToolbar() {
        Toolbar toolbar=  (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void goScene(View v){
        startActivity(new Intent(this, ScenceActivity.class));
    }

    public void goBeginDelayed(View v){
        startActivity(new Intent(this, BeginDelayedActivity.class));
    }

    public void goContentTransitions(View v){
        Intent intent = new Intent(this, ContentTransitionsActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        startActivity(intent,activityOptionsCompat.toBundle());
    }

    public void goContent_and_Shared(View v){
        startActivity(new Intent(this,ContentAndSharedTransitionActivity.class));
    }
}
