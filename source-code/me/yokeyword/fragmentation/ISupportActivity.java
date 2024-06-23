package me.yokeyword.fragmentation;

import android.view.MotionEvent;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public interface ISupportActivity {
    boolean dispatchTouchEvent(MotionEvent motionEvent);

    ExtraTransaction extraTransaction();

    FragmentAnimator getFragmentAnimator();

    SupportActivityDelegate getSupportDelegate();

    void onBackPressed();

    void onBackPressedSupport();

    FragmentAnimator onCreateFragmentAnimator();

    void setFragmentAnimator(FragmentAnimator fragmentAnimator);
}
