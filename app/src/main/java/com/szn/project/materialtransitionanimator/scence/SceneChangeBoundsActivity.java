package com.szn.project.materialtransitionanimator.scence;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;

import com.szn.project.materialtransitionanimator.R;


/**
 * @author suzhuning
 * @date 2017/3/13.
 * Description:
 */
public class SceneChangeBoundsActivity extends BaseSceneActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_change_bounds);
        initToolbar();
        initScene(R.id.scene_root,R.layout.scene_1_changebounds,R.layout.scene_2_changebounds);
    }

    @Override
    Transition getTransition() {
        return new ChangeBounds();
//        return new ChangeClipBounds();
    }


}
