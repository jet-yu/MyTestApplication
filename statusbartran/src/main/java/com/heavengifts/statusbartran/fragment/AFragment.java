package com.heavengifts.statusbartran.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heavengifts.statusbartran.MyFragmentManager;
import com.heavengifts.statusbartran.R;
import com.heavengifts.statusbartran.SystemBarHelper;

/**
 * Created by xu.yu
 *
 * @date 2017/11/21.
 * @update
 * @function
 */

public class AFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        view.findViewById(R.id.btn_f_a).setOnClickListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        ((DActivity) getActivity()).clearPadding();
        SystemBarHelper.settingBar(getActivity(), R.color.transparent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_f_a) {
            BFragment b = new BFragment();
            MyFragmentManager.getInstance().addFragment(b);
        }
    }
}
