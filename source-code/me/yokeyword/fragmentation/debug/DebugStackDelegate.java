package me.yokeyword.fragmentation.debug;

import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentationHack;
import java.util.ArrayList;
import java.util.List;
import me.yokeyword.fragmentation.R;

public class DebugStackDelegate implements SensorEventListener {
    private FragmentActivity mActivity;
    private SensorManager mSensorManager;
    private AlertDialog mStackDialog;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public DebugStackDelegate(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
    }

    public void onCreate(int i) {
        if (i == 1) {
            SensorManager sensorManager = (SensorManager) this.mActivity.getSystemService("sensor");
            this.mSensorManager = sensorManager;
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 3);
        }
    }

    public void onPostCreate(int i) {
        if (i == 2) {
            View findViewById = this.mActivity.findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                ImageView imageView = new ImageView(this.mActivity);
                imageView.setImageResource(R.drawable.fragmentation_ic_stack);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = GravityCompat.END;
                int applyDimension = (int) TypedValue.applyDimension(1, 18.0f, this.mActivity.getResources().getDisplayMetrics());
                layoutParams.topMargin = applyDimension * 7;
                layoutParams.rightMargin = applyDimension;
                imageView.setLayoutParams(layoutParams);
                ((FrameLayout) findViewById).addView(imageView);
                imageView.setOnTouchListener(new StackViewTouchListener(imageView, applyDimension / 4));
                imageView.setOnClickListener(new View.OnClickListener() {
                    /* class me.yokeyword.fragmentation.debug.DebugStackDelegate.AnonymousClass1 */

                    public void onClick(View view) {
                        DebugStackDelegate.this.showFragmentStackHierarchyView();
                    }
                });
            }
        }
    }

    public void onDestroy() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        float[] fArr = sensorEvent.values;
        if (type == 1) {
            float f = (float) 12;
            if (Math.abs(fArr[0]) >= f || Math.abs(fArr[1]) >= f || Math.abs(fArr[2]) >= f) {
                showFragmentStackHierarchyView();
            }
        }
    }

    public void showFragmentStackHierarchyView() {
        AlertDialog alertDialog = this.mStackDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            DebugHierarchyViewContainer debugHierarchyViewContainer = new DebugHierarchyViewContainer(this.mActivity);
            debugHierarchyViewContainer.bindFragmentRecords(getFragmentRecords());
            debugHierarchyViewContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            AlertDialog create = new AlertDialog.Builder(this.mActivity).setView(debugHierarchyViewContainer).setPositiveButton(17039360, (DialogInterface.OnClickListener) null).setCancelable(true).create();
            this.mStackDialog = create;
            create.show();
        }
    }

    public void logFragmentRecords(String str) {
        List<DebugFragmentRecord> fragmentRecords = getFragmentRecords();
        if (fragmentRecords != null) {
            StringBuilder sb = new StringBuilder();
            for (int size = fragmentRecords.size() - 1; size >= 0; size--) {
                DebugFragmentRecord debugFragmentRecord = fragmentRecords.get(size);
                if (size == fragmentRecords.size() - 1) {
                    sb.append("═══════════════════════════════════════════════════════════════════════════════════\n");
                    if (size == 0) {
                        sb.append("\t栈顶\t\t\t");
                        sb.append(debugFragmentRecord.fragmentName);
                        sb.append("\n");
                        sb.append("═══════════════════════════════════════════════════════════════════════════════════");
                    } else {
                        sb.append("\t栈顶\t\t\t");
                        sb.append(debugFragmentRecord.fragmentName);
                        sb.append("\n\n");
                    }
                } else if (size == 0) {
                    sb.append("\t栈底\t\t\t");
                    sb.append(debugFragmentRecord.fragmentName);
                    sb.append("\n\n");
                    processChildLog(debugFragmentRecord.childFragmentRecord, sb, 1);
                    sb.append("═══════════════════════════════════════════════════════════════════════════════════");
                    Log.i(str, sb.toString());
                    return;
                } else {
                    sb.append("\t↓\t\t\t");
                    sb.append(debugFragmentRecord.fragmentName);
                    sb.append("\n\n");
                }
                processChildLog(debugFragmentRecord.childFragmentRecord, sb, 1);
            }
        }
    }

    private List<DebugFragmentRecord> getFragmentRecords() {
        ArrayList arrayList = new ArrayList();
        List<Fragment> activeFragments = FragmentationHack.getActiveFragments(this.mActivity.getSupportFragmentManager());
        if (activeFragments == null || activeFragments.size() < 1) {
            return null;
        }
        for (Fragment fragment : activeFragments) {
            addDebugFragmentRecord(arrayList, fragment);
        }
        return arrayList;
    }

    private void processChildLog(List<DebugFragmentRecord> list, StringBuilder sb, int i) {
        if (!(list == null || list.size() == 0)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                DebugFragmentRecord debugFragmentRecord = list.get(i2);
                for (int i3 = 0; i3 < i; i3++) {
                    sb.append("\t\t\t");
                }
                if (i2 == 0) {
                    sb.append("\t子栈顶\t\t");
                    sb.append(debugFragmentRecord.fragmentName);
                    sb.append("\n\n");
                } else if (i2 == list.size() - 1) {
                    sb.append("\t子栈底\t\t");
                    sb.append(debugFragmentRecord.fragmentName);
                    sb.append("\n\n");
                    processChildLog(debugFragmentRecord.childFragmentRecord, sb, i + 1);
                    return;
                } else {
                    sb.append("\t↓\t\t\t");
                    sb.append(debugFragmentRecord.fragmentName);
                    sb.append("\n\n");
                }
                processChildLog(debugFragmentRecord.childFragmentRecord, sb, i);
            }
        }
    }

    private List<DebugFragmentRecord> getChildFragmentRecords(Fragment fragment) {
        ArrayList arrayList = new ArrayList();
        List<Fragment> activeFragments = FragmentationHack.getActiveFragments(fragment.getChildFragmentManager());
        if (activeFragments == null || activeFragments.size() < 1) {
            return null;
        }
        for (int size = activeFragments.size() - 1; size >= 0; size--) {
            addDebugFragmentRecord(arrayList, activeFragments.get(size));
        }
        return arrayList;
    }

    private void addDebugFragmentRecord(List<DebugFragmentRecord> list, Fragment fragment) {
        CharSequence charSequence;
        if (fragment != null) {
            int backStackEntryCount = fragment.getFragmentManager().getBackStackEntryCount();
            CharSequence simpleName = fragment.getClass().getSimpleName();
            if (backStackEntryCount == 0) {
                charSequence = span(simpleName);
            } else {
                int i = 0;
                while (i < backStackEntryCount && !fragment.getFragmentManager().getBackStackEntryAt(i).getName().equals(fragment.getClass().getName())) {
                    if (i == backStackEntryCount - 1) {
                        simpleName = span(simpleName);
                    }
                    i++;
                }
                charSequence = simpleName;
            }
            list.add(new DebugFragmentRecord(charSequence, getChildFragmentRecords(fragment)));
        }
    }

    private CharSequence span(CharSequence charSequence) {
        return ((Object) charSequence) + " *";
    }

    /* access modifiers changed from: private */
    public class StackViewTouchListener implements View.OnTouchListener {
        private int clickLimitValue;
        private float dX;
        private float dY = 0.0f;
        private float downX;
        private float downY = 0.0f;
        private boolean isClickState;
        private View stackView;

        StackViewTouchListener(View view, int i) {
            this.stackView = view;
            this.clickLimitValue = i;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (Math.abs(rawX - this.downX) >= ((float) this.clickLimitValue) || Math.abs(rawY - this.downY) >= ((float) this.clickLimitValue) || !this.isClickState) {
                        this.isClickState = false;
                        this.stackView.setX(motionEvent.getRawX() + this.dX);
                        this.stackView.setY(motionEvent.getRawY() + this.dY);
                    } else {
                        this.isClickState = true;
                    }
                }
                if (rawX - this.downX < ((float) this.clickLimitValue) && this.isClickState) {
                    this.stackView.performClick();
                }
            } else {
                this.isClickState = true;
                this.downX = rawX;
                this.downY = rawY;
                this.dX = this.stackView.getX() - motionEvent.getRawX();
                this.dY = this.stackView.getY() - motionEvent.getRawY();
            }
            return true;
        }
    }
}
