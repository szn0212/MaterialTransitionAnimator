package com.szn.project.materialtransitionanimator.scence;

import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;

import com.szn.project.materialtransitionanimator.R;


/**
 * @author suzhuning
 * @date 2017/3/13.
 * Description:
 */
public class SceneFadeSlideExplodeActivity extends BaseSceneActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_fade_slide_explode);
        initToolbar();
        initScene(R.id.scene_root,R.layout.scene_1_explode,R.layout.scene_2_explode);
    }

    @Override
    Transition getTransition() {

        return new Slide();
//        return TransitionInflater.from(this)
//                .inflateTransition(R.transition.changebounds_and_fade);
    }

}
