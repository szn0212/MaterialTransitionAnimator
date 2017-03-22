package com.szn.project.materialtransitionanimator.scence;

import android.os.Bundle;
import android.transition.Transition;

import com.szn.project.materialtransitionanimator.R;


/**
 * @author suzhuning
 * @date 2017/3/21.
 * Description:
 */
public class CustomTransitionActivity extends BaseSceneActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_change_bounds);
        initToolbar();
        initScene(R.id.scene_root,R.layout.scene_1_changecolor,R.layout.scene_2_changecolor);
    }

    @Override
    Transition getTransition() {
        return new ChangeColorTransition();
    }

}
