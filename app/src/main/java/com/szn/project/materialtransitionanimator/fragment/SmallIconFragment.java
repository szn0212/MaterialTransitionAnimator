package com.szn.project.materialtransitionanimator.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.szn.project.materialtransitionanimator.R;


/**
 * @author suzhuning
 * @date 2017/3/13.
 * Description:
 */
public class SmallIconFragment extends Fragment {

    private ImageView shared_small_circle;

    public SmallIconFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_small_icon, container, false);
        shared_small_circle = (ImageView) view.findViewById(R.id.shared_small_circle);
        view.findViewById(R.id.nextFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BigIconFragment bigIconFragment=new BigIconFragment();
                bigIconFragment.setSharedElementEnterTransition(new ChangeBounds());
                bigIconFragment.setEnterTransition(new Slide(Gravity.RIGHT));
                getFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment,bigIconFragment)
                        .addToBackStack(null)
                        .addSharedElement(shared_small_circle,"shared_circle_")
                        .commit();
            }
        });
        return view;
    }


}
