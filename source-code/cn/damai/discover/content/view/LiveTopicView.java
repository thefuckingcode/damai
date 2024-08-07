package cn.damai.discover.content.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$string;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;

/* compiled from: Taobao */
public class LiveTopicView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView topicIcon;
    private TextView topicText;

    public LiveTopicView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567835775")) {
            ipChange.ipc$dispatch("1567835775", new Object[]{this});
            return;
        }
        setOrientation(0);
        setVisibility(8);
        setGravity(16);
        setBackgroundResource(R$drawable.bg_color_topic_text);
        setPadding(v50.a(getContext(), 4.0f), 0, v50.a(getContext(), 12.0f), 0);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(v50.a(getContext(), 18.0f), v50.a(getContext(), 18.0f));
        DMIconFontTextView dMIconFontTextView = new DMIconFontTextView(getContext());
        this.topicIcon = dMIconFontTextView;
        dMIconFontTextView.setText(R$string.iconfont_biaoqian_);
        this.topicIcon.setGravity(17);
        this.topicIcon.setTextColor(Color.parseColor("#30AEFF"));
        this.topicIcon.setTextSize(1, 16.0f);
        addView(this.topicIcon, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = v50.a(getContext(), 4.0f);
        TextView textView = new TextView(getContext());
        this.topicText = textView;
        textView.setMaxLines(1);
        this.topicText.setEllipsize(TextUtils.TruncateAt.END);
        this.topicText.setTextColor(Color.parseColor("#30AEFF"));
        this.topicText.setTextSize(1, 14.0f);
        addView(this.topicText, layoutParams2);
    }

    public void setTopicName(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1261968550")) {
            ipChange.ipc$dispatch("1261968550", new Object[]{this, str});
            return;
        }
        TextView textView = this.topicText;
        if (textView != null) {
            textView.setText(str);
            if (TextUtils.isEmpty(str)) {
                i = 8;
            }
            setVisibility(i);
        }
    }

    public LiveTopicView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveTopicView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
