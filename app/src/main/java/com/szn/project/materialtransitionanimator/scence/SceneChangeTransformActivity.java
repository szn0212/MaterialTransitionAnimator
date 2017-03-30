package com.szn.project.materialtransitionanimator.scence;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.ChangeTransform;
import android.transition.Transition;

import com.szn.project.materialtransitionanimator.R;


/**
 * @author suzhuning
 * @date 2017/3/13.
 * Description:
 */
public class SceneChangeTransformActivity extends BaseSceneActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_change_transform);
        initToolbar();
        initScene(R.id.scene_root, R.layout.scene_1_changetransform, R.layout.scene_2_changetransform);
    }

    @Override
    Transition getTransition() {
        return new ChangeTransform();
    }
}
