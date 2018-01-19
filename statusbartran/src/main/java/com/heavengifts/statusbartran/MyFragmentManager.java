package com.heavengifts.statusbartran;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yangyihao on 17/2/13.
 */
public class MyFragmentManager {

    public static void clear() {
        myFragmentManager = null;
    }

    private static MyFragmentManager myFragmentManager = null;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Activity activity;

    protected boolean isDisplayAnimation = true;

    protected final String STRING_PARAM = "string_param";
    protected final String STRING_WPARAM = "string_wparam";
    protected final String STRING_DWPARAM = "string_dwparam";
    protected final String STRING_ZWPARAM = "string_zwparam";


    private MyFragmentManager() {
    }

    public static MyFragmentManager getInstance() {
        if (myFragmentManager == null)
            myFragmentManager = new MyFragmentManager();
        return myFragmentManager;
    }

//    public Fragment findFragmentByTag(String tag){
//       return fragmentManager.findFragmentByTag(tag);
//    }

    public void setIsDisplayAnimation(boolean isDisplayAnimation) {
        this.isDisplayAnimation = isDisplayAnimation;
    }

    public void addFragmentWithSystemAnim(Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (isDisplayAnimation) {
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        } else {
            fragmentTransaction.setCustomAnimations(0, 0, 0, 0);
            isDisplayAnimation = true;
        }
        fragmentTransaction.replace(R.id.main_frame, fragment, "fragmentTag");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void addFragment(Fragment fragment, boolean isAlpha) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (isAlpha) {
//            fragmentTransaction.setCustomAnimations(
//                    R.anim.fragment_fade_out,
//                    R.anim.fragment_fade_in,
//                    R.anim.fragment_fade_out,
//                    R.anim.fragment_fade_in);

            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        } else {
            fragmentTransaction.setCustomAnimations(0, 0, 0, 0);
            isDisplayAnimation = true;
        }
        fragmentTransaction.replace(R.id.main_frame, fragment, "fragmentTag");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void addFragment(Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (isDisplayAnimation) {

            fragmentTransaction.setCustomAnimations(
                    R.anim.fragment_slide_in_from_right,
                    R.anim.fragment_slide_out_to_left,
                    R.anim.fragment_slide_in_from_left,
                    R.anim.fragment_slide_out_to_right);
        } else {
            fragmentTransaction.setCustomAnimations(0, 0, 0, 0);
            isDisplayAnimation = true;
        }
        fragmentTransaction.replace(R.id.main_frame, fragment, "fragmentTag");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public Fragment getCurrentFragment() {
        if (fragmentManager == null)
            return null;
        return fragmentManager.findFragmentByTag("fragmentTag");
    }

    public boolean goBack() {
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
            return true;
        } else {
            fragmentManager.popBackStack();
            return false;
        }
    }

    public void goBackZoom() {
        if (fragmentManager.getBackStackEntryCount() <= 1) {
            zoomfinish();
        } else {
            fragmentManager.popBackStack();
        }
    }

    public void goBackWithSystemAnim() {
        if (fragmentManager.getBackStackEntryCount() <= 1) {
            finishWithSystemAnim();
        } else {
            fragmentManager.popBackStack();
        }
    }

    public void popBackStackInclusive() {
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }


    public void finish() {
        activity.finish();
        activity.overridePendingTransition(R.anim.fragment_slide_in_from_left, R.anim.fragment_slide_out_to_right);
    }

    public void zoomfinish() {
        activity.finish();
        activity.overridePendingTransition(R.anim.fragment_no_anim, R.anim.fragment_fade_out);
    }

    public void finishWithSystemAnim() {
        activity.finish();
        activity.overridePendingTransition(R.anim.fragment_no_anim, R.anim.fragment_out_from_top);
    }

    public void setActivity(AppCompatActivity activity) {

        this.activity = activity;
        fragmentManager = activity.getSupportFragmentManager();
    }

    public int getBackStackEntryCount() {
        if (fragmentManager == null) {
            return 0;
        }
        return fragmentManager.getBackStackEntryCount();
    }


}


