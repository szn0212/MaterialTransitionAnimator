package com.szn.project.materialtransitionanimator.scence;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author suzhuning
 * @date 2017/3/21.
 * Description:
 */
public class ChangeColorTransition extends Transition {
    private static final String PROPNAME_BACKGROUND =
            "com.project.flygifttest.scence:changecolor:background";


    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        if(transitionValues.view.getBackground() instanceof ColorDrawable){
            captureValues(transitionValues);
        }

    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_BACKGROUND,
                ((ColorDrawable)transitionValues.view.getBackground()).getColor());
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        if(transitionValues.view.getBackground() instanceof ColorDrawable){
            captureValues(transitionValues);
        }
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
        if(null == startValues || null == endValues){
            return null;
        }
        final View view = endValues.view;
        int startBackground = (Integer) startValues.values.get(PROPNAME_BACKGROUND);
        int endBackground = (Integer) endValues.values.get(PROPNAME_BACKGROUND);

        if(startBackground != endBackground){
            ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), startBackground, endBackground);
            animator.setDuration(1000);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Object value = animation.getAnimatedValue();
                    if(null != value){
                        view.setBackgroundColor((Integer) value);
                    }
                }
            });
            return animator;
        }

        return null;
    }

    @Override
    public String[] getTransitionProperties() {
        return new String[]{
                PROPNAME_BACKGROUND
        };
    }
}
