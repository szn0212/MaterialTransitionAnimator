package com.szn.project.materialtransitionanimator.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;

import com.szn.project.materialtransitionanimator.R;


/**
 * @author suzhuning
 * @date 2017/3/13.
 * Description:
 */
public class FragmentTransitionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transition);
        initToolbar();
        SmallIconFragment smallIconFragment=new SmallIconFragment();
        smallIconFragment.setExitTransition(new Slide());
        getSupportFragmentManager().beginTransaction().add(R.id.container_fragment,smallIconFragment).commit();
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
