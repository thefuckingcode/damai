package cn.damai.issue.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.common.nav.DMNav;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import tb.k21;
import tb.m40;
import tb.xn;

public final class CorrelationView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private String correlationId;
    private String currentItemId;
    private String name;
    private String num;
    private TextView tvCorrelationDes;
    private TextView tvCorrelationRequired;
    private TextView tvCorrelationTitle;
    private DMIconFontTextView tvIcon;
    private CorrelationType type;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CorrelationView(Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CorrelationView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-953342314")) {
            ipChange.ipc$dispatch("-953342314", new Object[]{this});
            return;
        }
        this.tvCorrelationDes = (TextView) findViewById(R$id.tv_correlation_des);
        this.tvCorrelationTitle = (TextView) findViewById(R$id.tv_correlation_title);
        this.tvCorrelationRequired = (TextView) findViewById(R$id.tv_correlation_required);
        this.tvIcon = (DMIconFontTextView) findViewById(R$id.tv_arrow);
    }

    private final void setClickListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127878351")) {
            ipChange.ipc$dispatch("-1127878351", new Object[]{this});
            return;
        }
        setOnClickListener(new xn(this));
    }

    /* renamed from: setClickListener$lambda-0 */
    public static final void m50setClickListener$lambda0(CorrelationView correlationView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2008977450")) {
            ipChange.ipc$dispatch("2008977450", new Object[]{correlationView, view});
            return;
        }
        k21.i(correlationView, "this$0");
        StringBuilder sb = new StringBuilder();
        sb.append("damai://V1/ScriptSelect");
        CorrelationType correlationType = correlationView.type;
        CorrelationType correlationType2 = CorrelationType.STORE;
        if (correlationType == correlationType2) {
            sb.append("?pageType=" + correlationType2.getType());
        } else {
            CorrelationType correlationType3 = CorrelationType.SCRIPT;
            if (correlationType == correlationType3) {
                sb.append("?pageType=" + correlationType3.getType());
            }
        }
        sb.append("&targetId=" + correlationView.currentItemId);
        if (correlationView.correlationId != null) {
            sb.append("&selectedId=" + correlationView.correlationId);
        }
        DMNav.from(correlationView.getContext()).forResult(105).toUri(sb.toString());
    }

    public static /* synthetic */ void setDefaultData$default(CorrelationView correlationView, String str, CorrelationType correlationType, String str2, Boolean bool, int i, Object obj) {
        if ((i & 8) != 0) {
            bool = null;
        }
        correlationView.setDefaultData(str, correlationType, str2, bool);
    }

    public final String getCorrelationId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "223898748")) {
            return this.correlationId;
        }
        return (String) ipChange.ipc$dispatch("223898748", new Object[]{this});
    }

    public final String getCurrentItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1653513306")) {
            return this.currentItemId;
        }
        return (String) ipChange.ipc$dispatch("-1653513306", new Object[]{this});
    }

    public final String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1694179682")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("1694179682", new Object[]{this});
    }

    public final String getNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-582994875")) {
            return this.num;
        }
        return (String) ipChange.ipc$dispatch("-582994875", new Object[]{this});
    }

    public final TextView getTvCorrelationDes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "858081099")) {
            return this.tvCorrelationDes;
        }
        return (TextView) ipChange.ipc$dispatch("858081099", new Object[]{this});
    }

    public final TextView getTvCorrelationRequired() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "732077238")) {
            return this.tvCorrelationRequired;
        }
        return (TextView) ipChange.ipc$dispatch("732077238", new Object[]{this});
    }

    public final TextView getTvCorrelationTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-948285371")) {
            return this.tvCorrelationTitle;
        }
        return (TextView) ipChange.ipc$dispatch("-948285371", new Object[]{this});
    }

    public final DMIconFontTextView getTvIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1645684437")) {
            return this.tvIcon;
        }
        return (DMIconFontTextView) ipChange.ipc$dispatch("1645684437", new Object[]{this});
    }

    public final CorrelationType getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "254697565")) {
            return this.type;
        }
        return (CorrelationType) ipChange.ipc$dispatch("254697565", new Object[]{this});
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    public final void restore() {
        DMIconFontTextView dMIconFontTextView;
        TextView textView;
        TextView textView2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1047218095")) {
            ipChange.ipc$dispatch("-1047218095", new Object[]{this});
            return;
        }
        String str = this.num + this.type.getDes();
        if (!k21.d(this.num, "0")) {
            String str2 = this.num;
            if (!(str2 == null || str2.length() == 0)) {
                setClickable(true);
                dMIconFontTextView = this.tvIcon;
                if (dMIconFontTextView != null) {
                    if (!isClickable()) {
                        i = 8;
                    }
                    dMIconFontTextView.setVisibility(i);
                }
                textView = this.tvCorrelationDes;
                if (textView != null) {
                    textView.setText(str);
                }
                textView2 = this.tvCorrelationDes;
                if (textView2 == null) {
                    textView2.setTextColor(Color.parseColor("#9C9CA5"));
                    return;
                }
                return;
            }
        }
        str = this.type.getNullDes();
        setClickable(false);
        dMIconFontTextView = this.tvIcon;
        if (dMIconFontTextView != null) {
        }
        textView = this.tvCorrelationDes;
        if (textView != null) {
        }
        textView2 = this.tvCorrelationDes;
        if (textView2 == null) {
        }
    }

    public final void setCorrelationId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777230202")) {
            ipChange.ipc$dispatch("777230202", new Object[]{this, str});
            return;
        }
        this.correlationId = str;
    }

    public final void setCurrentItemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587968624")) {
            ipChange.ipc$dispatch("-1587968624", new Object[]{this, str});
            return;
        }
        this.currentItemId = str;
    }

    public final void setDefaultData(String str, CorrelationType correlationType, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332428132")) {
            ipChange.ipc$dispatch("-332428132", new Object[]{this, str, correlationType, str2});
            return;
        }
        k21.i(correlationType, "type");
        setDefaultData(str, correlationType, str2, null);
    }

    public final void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "687205820")) {
            ipChange.ipc$dispatch("687205820", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public final void setNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "525576145")) {
            ipChange.ipc$dispatch("525576145", new Object[]{this, str});
            return;
        }
        this.num = str;
    }

    public final void setSelectData(String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1459729899")) {
            ipChange.ipc$dispatch("1459729899", new Object[]{this, str, str2});
            return;
        }
        this.correlationId = str;
        this.name = str2;
        if (!(str == null || str.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                z = false;
            }
            if (!z) {
                TextView textView = this.tvCorrelationDes;
                if (textView != null) {
                    textView.setText(str2);
                }
                TextView textView2 = this.tvCorrelationDes;
                if (textView2 != null) {
                    textView2.setTextColor(Color.parseColor(isClickable() ? "#111111" : "#9C9CA5"));
                }
            }
        }
    }

    public final void setTvCorrelationDes(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492086105")) {
            ipChange.ipc$dispatch("1492086105", new Object[]{this, textView});
            return;
        }
        this.tvCorrelationDes = textView;
    }

    public final void setTvCorrelationRequired(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "344602294")) {
            ipChange.ipc$dispatch("344602294", new Object[]{this, textView});
            return;
        }
        this.tvCorrelationRequired = textView;
    }

    public final void setTvCorrelationTitle(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-940248929")) {
            ipChange.ipc$dispatch("-940248929", new Object[]{this, textView});
            return;
        }
        this.tvCorrelationTitle = textView;
    }

    public final void setTvIcon(DMIconFontTextView dMIconFontTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773845519")) {
            ipChange.ipc$dispatch("1773845519", new Object[]{this, dMIconFontTextView});
            return;
        }
        this.tvIcon = dMIconFontTextView;
    }

    public final void setType(CorrelationType correlationType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-713450693")) {
            ipChange.ipc$dispatch("-713450693", new Object[]{this, correlationType});
            return;
        }
        k21.i(correlationType, "<set-?>");
        this.type = correlationType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CorrelationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.type = CorrelationType.STORE;
        LayoutInflater.from(context).inflate(R$layout.correlation_view_layout, (ViewGroup) this, true);
        initView();
        setClickListener();
    }

    public final void setDefaultData(String str, CorrelationType correlationType, String str2, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502911183")) {
            ipChange.ipc$dispatch("-1502911183", new Object[]{this, str, correlationType, str2, bool});
            return;
        }
        k21.i(correlationType, "type");
        int i = 8;
        if (str2 == null || str2.length() == 0) {
            setVisibility(8);
        }
        this.num = str;
        this.type = correlationType;
        this.currentItemId = str2;
        String str3 = str + correlationType.getDes();
        if (bool != null) {
            setClickable(bool.booleanValue());
        } else {
            if (!k21.d(str, "0")) {
                if (!(str == null || str.length() == 0)) {
                    setClickable(true);
                }
            }
            str3 = correlationType.getNullDes();
            setClickable(false);
        }
        TextView textView = this.tvCorrelationTitle;
        if (textView != null) {
            textView.setText(correlationType.getTitle());
        }
        TextView textView2 = this.tvCorrelationTitle;
        if (textView2 != null) {
            textView2.setTextColor(isClickable() ? Color.parseColor("#111111") : Color.parseColor("#9C9CA5"));
        }
        TextView textView3 = this.tvCorrelationRequired;
        if (textView3 != null) {
            textView3.setVisibility(correlationType.getRequired() ? 8 : 0);
        }
        TextView textView4 = this.tvCorrelationDes;
        if (textView4 != null) {
            textView4.setText(str3);
        }
        TextView textView5 = this.tvCorrelationDes;
        if (textView5 != null) {
            textView5.setTextColor(Color.parseColor("#9C9CA5"));
        }
        DMIconFontTextView dMIconFontTextView = this.tvIcon;
        if (dMIconFontTextView != null) {
            if (isClickable()) {
                i = 0;
            }
            dMIconFontTextView.setVisibility(i);
        }
        setVisibility(0);
    }
}
