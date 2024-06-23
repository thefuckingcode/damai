package cn.damai.commonbusiness.dynamicx.customwidget.temp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView;
import cn.damai.tetris.component.home.HomeData;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import tb.c31;
import tb.d20;
import tb.g91;
import tb.gr;
import tb.n42;
import tb.xs0;
import tb.zs0;

/* compiled from: Taobao */
public class DMDXHomeGrabTicketNoticeView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int goodsNum;
    private int highlightColor;
    private String isDisEnabled;
    private Animation.AnimationListener mAnimationListener = new a();
    private View.OnClickListener mOnClickListener = new b();
    private DMUpMarqueeView.OnItemClickListener mOnItemClickListener = new c();
    private ImageView marqueeLabel;
    private DMUpMarqueeView marqueeView;
    private int normalColor;
    private int pointSize;

    /* compiled from: Taobao */
    public class a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onAnimationEnd(Animation animation) {
            View currentView;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-373624845")) {
                ipChange.ipc$dispatch("-373624845", new Object[]{this, animation});
                return;
            }
            try {
                if (DMDXHomeGrabTicketNoticeView.this.marqueeView != null && (currentView = DMDXHomeGrabTicketNoticeView.this.marqueeView.getCurrentView()) != null) {
                    JSONObject jSONObject = (JSONObject) currentView.getTag();
                    DMDXHomeGrabTicketNoticeView.this.marqueeLabel.setTag(jSONObject);
                    HashMap hashMap = new HashMap();
                    hashMap.put("city", d20.d());
                    String string = jSONObject.getString("highlightTitle");
                    String string2 = jSONObject.getString("title");
                    Object[] objArr = new Object[2];
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    objArr[0] = string;
                    if (TextUtils.isEmpty(string2)) {
                        string2 = "";
                    }
                    objArr[1] = string2;
                    hashMap.put("titlelabel", String.format("%1$s%2$s", objArr));
                    hashMap.put("item_id", jSONObject.getString("itemId"));
                    String string3 = jSONObject.getString("utIndex");
                    if (TextUtils.isEmpty(string3)) {
                        string3 = "0";
                    }
                    cn.damai.common.user.c e = cn.damai.common.user.c.e();
                    e.G(currentView, "more_item_" + string3, zs0.GRAB_PAGE, "home", hashMap);
                }
            } catch (Exception e2) {
                g91.c("DMDXHomeGrabTicketNoticeView", e2.getMessage());
            }
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1384867489")) {
                ipChange.ipc$dispatch("1384867489", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "218976908")) {
                ipChange.ipc$dispatch("218976908", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "242322395")) {
                ipChange.ipc$dispatch("242322395", new Object[]{this, view});
                return;
            }
            DMDXHomeGrabTicketNoticeView.this.grabItemClick(view);
        }
    }

    /* compiled from: Taobao */
    public class c implements DMUpMarqueeView.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView.OnItemClickListener
        public void onItemClick(int i, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1184353448")) {
                ipChange.ipc$dispatch("-1184353448", new Object[]{this, Integer.valueOf(i), view});
                return;
            }
            DMDXHomeGrabTicketNoticeView.this.grabItemClick(view);
        }
    }

    public DMDXHomeGrabTicketNoticeView(@NonNull Context context) {
        super(context);
        initView();
    }

    private View createView(int i, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744863094")) {
            return (View) ipChange.ipc$dispatch("-744863094", new Object[]{this, Integer.valueOf(i), jSONObject});
        } else if (jSONObject == null) {
            return null;
        } else {
            View inflate = LayoutInflater.from(getContext()).inflate(R$layout.homepage_grab_ticket_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R$id.homepage_grab_ticket_item_heightlight_text);
            int i2 = this.pointSize;
            if (i2 > 0) {
                textView.setTextSize(0, (float) i2);
            }
            int i3 = this.highlightColor;
            if (i3 != 0) {
                textView.setTextColor(i3);
            }
            if (jSONObject.containsKey("highlightTitle")) {
                textView.setText(jSONObject.getString("highlightTitle"));
            }
            TextView textView2 = (TextView) inflate.findViewById(R$id.homepage_grab_ticket_item_text);
            int i4 = this.pointSize;
            if (i4 > 0) {
                textView2.setTextSize(0, (float) i4);
            }
            int i5 = this.normalColor;
            if (i5 != 0) {
                textView2.setTextColor(i5);
            }
            if (jSONObject.containsKey("title")) {
                textView2.setText(jSONObject.getString("title"));
            }
            jSONObject.put("utIndex", (Object) Integer.valueOf(i));
            inflate.setTag(jSONObject);
            return inflate;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void grabItemClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289042643")) {
            ipChange.ipc$dispatch("-1289042643", new Object[]{this, view});
            return;
        }
        try {
            String str = this.isDisEnabled;
            if (str == null || !"true".equals(str)) {
                JSONObject jSONObject = (JSONObject) view.getTag();
                Bundle bundle = new Bundle();
                if (!jSONObject.containsKey("itemId") || TextUtils.isEmpty(jSONObject.getString("itemId"))) {
                    if (jSONObject.containsKey("schema") && !TextUtils.isEmpty(jSONObject.getString("schema"))) {
                        DMNav.from(getContext()).withExtras(bundle).toUri(jSONObject.getString("schema"));
                    }
                } else if (this.goodsNum == 1) {
                    String string = jSONObject.getString("itemId");
                    String str2 = HomeData.topItemId;
                    if (str2 != null && !string.equals(str2)) {
                        bundle.putString("topProjectId", jSONObject.getString("itemId"));
                        DMNav.from(getContext()).withExtras(bundle).toUri(NavUri.b("grab"));
                    } else if (!jSONObject.containsKey("schema") || TextUtils.isEmpty(jSONObject.getString("schema"))) {
                        bundle.putString("from_page", "homepage");
                        bundle.putString("id", jSONObject.getString("itemId"));
                        DMNav.from(getContext()).withExtras(bundle).toUri(NavUri.b(gr.b));
                    } else {
                        DMNav.from(getContext()).withExtras(bundle).toUri(jSONObject.getString("schema"));
                    }
                } else {
                    bundle.putString("topProjectId", jSONObject.getString("itemId"));
                    DMNav.from(getContext()).withExtras(bundle).toUri(NavUri.b("grab"));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("city", d20.d());
                String string2 = jSONObject.getString("highlightTitle");
                String string3 = jSONObject.getString("title");
                Object[] objArr = new Object[2];
                if (TextUtils.isEmpty(string2)) {
                    string2 = "";
                }
                objArr[0] = string2;
                if (TextUtils.isEmpty(string3)) {
                    string3 = "";
                }
                objArr[1] = string3;
                hashMap.put("titlelabel", String.format("%1$s%2$s", objArr));
                hashMap.put("item_id", jSONObject.getString("itemId"));
                String string4 = jSONObject.getString("utIndex");
                if (TextUtils.isEmpty(string4)) {
                    string4 = "0";
                }
                a.b f = new a.b().i("home").f(zs0.GRAB_PAGE);
                cn.damai.common.user.c.e().x(f.l("more_item_" + string4).g(true).j(hashMap));
            }
        } catch (Exception e) {
            g91.b("DMDXHomeGrabTicketNoticeView", e.getMessage());
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973892071")) {
            ipChange.ipc$dispatch("973892071", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.homepage_grab_ticket_notice, (ViewGroup) null);
        this.marqueeLabel = (ImageView) inflate.findViewById(R$id.homepage_grab_ticket_label);
        DMUpMarqueeView dMUpMarqueeView = (DMUpMarqueeView) inflate.findViewById(R$id.homepage_grab_ticket_cntainer);
        this.marqueeView = dMUpMarqueeView;
        dMUpMarqueeView.setOnItemClickListener(this.mOnItemClickListener);
        this.marqueeLabel.setOnClickListener(this.mOnClickListener);
        addView(inflate);
    }

    public void create(JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2143603128")) {
            ipChange.ipc$dispatch("-2143603128", new Object[]{this, jSONArray});
            return;
        }
        this.goodsNum = 0;
        int b2 = c31.b(jSONArray);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b2; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject != null) {
                if (jSONObject.containsKey("itemId")) {
                    this.goodsNum++;
                }
                View createView = createView(i, jSONObject);
                if (createView != null) {
                    arrayList.add(createView);
                }
            }
        }
        this.marqueeView.setItems(arrayList);
    }

    public void setAnimateTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-517314764")) {
            ipChange.ipc$dispatch("-517314764", new Object[]{this, Long.valueOf(j)});
            return;
        }
        DMUpMarqueeView dMUpMarqueeView = this.marqueeView;
        if (dMUpMarqueeView != null) {
            if (j <= 0) {
                j = 500;
            }
            dMUpMarqueeView.setAnimationDuration(j);
            Animation inAnimation = this.marqueeView.getInAnimation();
            if (inAnimation != null) {
                inAnimation.setAnimationListener(this.mAnimationListener);
            }
        }
    }

    public void setDataStatus(String str) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "579874874")) {
            ipChange.ipc$dispatch("579874874", new Object[]{this, str});
            return;
        }
        if (TextUtils.equals("1", str)) {
            this.marqueeLabel.setImageResource(R$drawable.icon_yiqi_beng);
            i = n42.a(xs0.a(), 95.0f);
        } else {
            i = n42.a(xs0.a(), 92.0f);
            this.marqueeLabel.setImageResource(R$drawable.ic_home_grab_ticket_logo);
        }
        ViewGroup.LayoutParams layoutParams = this.marqueeLabel.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            this.marqueeLabel.requestLayout();
        }
    }

    public void setHighlightColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092886682")) {
            ipChange.ipc$dispatch("-1092886682", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.highlightColor = i;
    }

    public void setInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691801380")) {
            ipChange.ipc$dispatch("-1691801380", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        DMUpMarqueeView dMUpMarqueeView = this.marqueeView;
        if (dMUpMarqueeView != null) {
            if (i <= 0) {
                i = 3000;
            }
            dMUpMarqueeView.setFlipInterval(i);
        }
    }

    public void setIsDisEnabled(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529213881")) {
            ipChange.ipc$dispatch("529213881", new Object[]{this, str});
            return;
        }
        this.isDisEnabled = str;
    }

    public void setNormalColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101132831")) {
            ipChange.ipc$dispatch("-101132831", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.normalColor = i;
    }

    public void setPointSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1059490838")) {
            ipChange.ipc$dispatch("1059490838", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pointSize = i;
    }

    public DMDXHomeGrabTicketNoticeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public DMDXHomeGrabTicketNoticeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
