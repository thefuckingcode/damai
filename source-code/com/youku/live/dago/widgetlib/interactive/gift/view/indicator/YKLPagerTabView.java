package com.youku.live.dago.widgetlib.interactive.gift.view.indicator;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.kcrason.dynamicpagerindicatorlibrary.BasePagerTabView;

/* compiled from: Taobao */
public class YKLPagerTabView extends BasePagerTabView {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mTabTextView;

    public YKLPagerTabView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kcrason.dynamicpagerindicatorlibrary.IPagerTabView
    @Nullable
    public TextView getTabTextView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1906618544")) {
            return this.mTabTextView;
        }
        return (TextView) ipChange.ipc$dispatch("1906618544", new Object[]{this});
    }

    @Override // com.kcrason.dynamicpagerindicatorlibrary.IPagerTabView
    public View onCreateTabView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1370317268")) {
            return (View) ipChange.ipc$dispatch("-1370317268", new Object[]{this, context});
        }
        TextView textView = new TextView(context);
        this.mTabTextView = textView;
        textView.setGravity(17);
        this.mTabTextView.setMaxLines(1);
        this.mTabTextView.setIncludeFontPadding(false);
        return this.mTabTextView;
    }

    public void setTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164287434")) {
            ipChange.ipc$dispatch("164287434", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTabTextView.setTextColor(i);
    }

    public void setTypeface(Typeface typeface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161808034")) {
            ipChange.ipc$dispatch("161808034", new Object[]{this, typeface});
            return;
        }
        this.mTabTextView.setTypeface(typeface);
    }

    public YKLPagerTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public YKLPagerTabView(Context context) {
        super(context);
    }
}
