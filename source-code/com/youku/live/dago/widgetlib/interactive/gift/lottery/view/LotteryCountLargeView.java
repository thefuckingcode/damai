package com.youku.live.dago.widgetlib.interactive.gift.lottery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;

/* compiled from: Taobao */
public class LotteryCountLargeView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private ImageView mHundredDigitView;
    private ImageView mSingleDigitView;
    private ImageView mTenDigitView;

    public LotteryCountLargeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void displayDigitCount(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1612392327")) {
            ipChange.ipc$dispatch("-1612392327", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        if (i == 0) {
            this.mHundredDigitView.setVisibility(8);
        } else {
            this.mHundredDigitView.setImageResource(getDigitResId(i));
            this.mHundredDigitView.setVisibility(0);
        }
        if (i2 == 0) {
            this.mTenDigitView.setVisibility(8);
        } else {
            this.mTenDigitView.setImageResource(getDigitResId(i2));
            this.mTenDigitView.setVisibility(0);
        }
        this.mSingleDigitView.setImageResource(getDigitResId(i3));
        this.mSingleDigitView.setVisibility(0);
    }

    private int getDigitResId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920033748")) {
            return ((Integer) ipChange.ipc$dispatch("-1920033748", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        switch (i) {
            case 0:
                return R.drawable.large_num_0;
            case 1:
                return R.drawable.large_num_01;
            case 2:
                return R.drawable.large_num_02;
            case 3:
                return R.drawable.large_num_03;
            case 4:
                return R.drawable.large_num_04;
            case 5:
                return R.drawable.large_num_05;
            case 6:
                return R.drawable.large_num_06;
            case 7:
                return R.drawable.large_num_07;
            case 8:
                return R.drawable.large_num_08;
            case 9:
                return R.drawable.large_num_09;
            default:
                return 0;
        }
    }

    private int getNumFromCount(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1510513133")) {
            return ((Integer) ipChange.ipc$dispatch("-1510513133", new Object[]{this, str, Integer.valueOf(i)})).intValue();
        } else if (str.length() < i) {
            return 0;
        } else {
            return Character.getNumericValue(str.charAt((str.length() - 1) - (i - 1)));
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1115031591")) {
            ipChange.ipc$dispatch("1115031591", new Object[]{this});
            return;
        }
        LayoutInflater.from(this.mContext).inflate(R.layout.dago_pgc_gift_lottery_count_large_layout, this);
        this.mHundredDigitView = (ImageView) findViewById(R.id.hundred_digit);
        this.mTenDigitView = (ImageView) findViewById(R.id.ten_digit);
        this.mSingleDigitView = (ImageView) findViewById(R.id.single_digit);
    }

    public void displayCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520082457")) {
            ipChange.ipc$dispatch("520082457", new Object[]{this, str});
            return;
        }
        displayDigitCount(getNumFromCount(str, 3), getNumFromCount(str, 2), getNumFromCount(str, 1));
    }

    public LotteryCountLargeView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }
}
