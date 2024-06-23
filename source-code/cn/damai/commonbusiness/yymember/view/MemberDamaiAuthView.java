package cn.damai.commonbusiness.yymember.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.yymember.bean.MemberAuthBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import tb.g03;
import tb.gr;
import tb.jl1;
import tb.k21;
import tb.kc1;
import tb.lc1;
import tb.m40;
import tb.mc1;
import tb.v50;
import tb.xf2;

public final class MemberDamaiAuthView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final a Companion = new a(null);
    public static final String DM_AUTH;
    public static final String DM_AUTH_UT_MODULE;
    public static final String PP_AUTH;
    public static final String PP_AUTH_UT_MODULE;
    private CheckBox cbMemberAuth;
    private DMIconFontTextView close;
    private View.OnClickListener listener;
    private LinearLayout llMemberAuthProtocol;
    private LinearLayout llTppTip;
    private TextView memberAuthTip;
    private String pageSource;
    private IMemberPopEventListener popEventListener;
    private LinearLayout protocolInstruction;
    private RelativeLayout relativeLayout;
    private TextView tvCheckboxTip;
    private TextView tvProAgree;
    private TextView tvProCancel;
    private TextView tvProContent;
    private TextView tvTitle;
    private String viewType;

    public interface IMemberPopEventListener {
        void dmAgree();

        void popDismiss();

        void tppAgree();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public static final class b extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ MemberDamaiAuthView b;

        b(String str, MemberDamaiAuthView memberDamaiAuthView) {
            this.a = str;
            this.b = memberDamaiAuthView;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "495926579")) {
                ipChange.ipc$dispatch("495926579", new Object[]{this, view});
                return;
            }
            k21.i(view, "widget");
            Bundle bundle = new Bundle();
            bundle.putString("url", this.a);
            DMNav.from(this.b.getContext()).withExtras(bundle).toUri(NavUri.b(gr.t));
        }

        public void updateDrawState(TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2105067676")) {
                ipChange.ipc$dispatch("-2105067676", new Object[]{this, textPaint});
                return;
            }
            k21.i(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#DD7F60"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MemberDamaiAuthView(Context context) {
        this(context, null, 0, 6, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MemberDamaiAuthView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MemberDamaiAuthView(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600892555")) {
            ipChange.ipc$dispatch("-1600892555", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.commonbusiness_member_auth_pop_view, this);
        View findViewById = inflate.findViewById(R$id.tv_member_auth_title);
        k21.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.member_auth_right_close);
        k21.g(findViewById2, "null cannot be cast to non-null type cn.damai.uikit.iconfont.DMIconFontTextView");
        this.close = (DMIconFontTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R$id.ll_member_auth_layout);
        k21.g(findViewById3, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.relativeLayout = (RelativeLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R$id.ll_tiaopiaopiao_tip);
        k21.g(findViewById4, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.llTppTip = (LinearLayout) findViewById4;
        View findViewById5 = inflate.findViewById(R$id.ll_member_auth_protocol_instruction);
        k21.g(findViewById5, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.protocolInstruction = (LinearLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R$id.ll_member_auth_protocol);
        k21.g(findViewById6, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.llMemberAuthProtocol = (LinearLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R$id.member_auth_tip);
        k21.g(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.memberAuthTip = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R$id.tv_member_auth_checkbox_tip);
        k21.g(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.tvCheckboxTip = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R$id.cb_ll_member_auth);
        k21.g(findViewById9, "null cannot be cast to non-null type android.widget.CheckBox");
        this.cbMemberAuth = (CheckBox) findViewById9;
        View findViewById10 = inflate.findViewById(R$id.tv_ll_member_pro_content);
        k21.g(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.tvProContent = (TextView) findViewById10;
        View findViewById11 = inflate.findViewById(R$id.tv_ll_member_pro_cancel);
        k21.g(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.tvProCancel = (TextView) findViewById11;
        View findViewById12 = inflate.findViewById(R$id.tv_ll_member_pro_agree);
        k21.g(findViewById12, "null cannot be cast to non-null type android.widget.TextView");
        this.tvProAgree = (TextView) findViewById12;
        CheckBox checkBox = this.cbMemberAuth;
        CheckBox checkBox2 = null;
        if (checkBox == null) {
            k21.A("cbMemberAuth");
            checkBox = null;
        }
        checkBox.setChecked(false);
        LinearLayout linearLayout = this.llMemberAuthProtocol;
        if (linearLayout == null) {
            k21.A("llMemberAuthProtocol");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new lc1(this));
        CheckBox checkBox3 = this.cbMemberAuth;
        if (checkBox3 == null) {
            k21.A("cbMemberAuth");
        } else {
            checkBox2 = checkBox3;
        }
        checkBox2.setOnCheckedChangeListener(new mc1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.widget.TextView] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: initView$lambda-0 */
    public static final void m20initView$lambda0(MemberDamaiAuthView memberDamaiAuthView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1492179771")) {
            ipChange.ipc$dispatch("-1492179771", new Object[]{memberDamaiAuthView, view});
            return;
        }
        k21.i(memberDamaiAuthView, "this$0");
        CheckBox checkBox = memberDamaiAuthView.cbMemberAuth;
        CheckBox checkBox2 = null;
        if (checkBox == null) {
            k21.A("cbMemberAuth");
            checkBox = null;
        }
        if (checkBox.isChecked()) {
            CheckBox checkBox3 = memberDamaiAuthView.cbMemberAuth;
            if (checkBox3 == null) {
                k21.A("cbMemberAuth");
            } else {
                checkBox2 = checkBox3;
            }
            checkBox2.setChecked(false);
            return;
        }
        CheckBox checkBox4 = memberDamaiAuthView.cbMemberAuth;
        if (checkBox4 == null) {
            k21.A("cbMemberAuth");
            checkBox4 = null;
        }
        checkBox4.setChecked(true);
        ?? r5 = memberDamaiAuthView.tvCheckboxTip;
        if (r5 == 0) {
            k21.A("tvCheckboxTip");
        } else {
            checkBox2 = r5;
        }
        checkBox2.setVisibility(8);
    }

    /* renamed from: initView$lambda-1 */
    public static final void m21initView$lambda1(MemberDamaiAuthView memberDamaiAuthView, CompoundButton compoundButton, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "635778185")) {
            ipChange.ipc$dispatch("635778185", new Object[]{memberDamaiAuthView, compoundButton, Boolean.valueOf(z)});
            return;
        }
        k21.i(memberDamaiAuthView, "this$0");
        if (z) {
            TextView textView = memberDamaiAuthView.tvCheckboxTip;
            if (textView == null) {
                k21.A("tvCheckboxTip");
                textView = null;
            }
            textView.setVisibility(8);
        }
    }

    /* renamed from: listener$lambda-6 */
    public static final void m22listener$lambda6(MemberDamaiAuthView memberDamaiAuthView, View view) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257604706")) {
            ipChange.ipc$dispatch("-1257604706", new Object[]{memberDamaiAuthView, view});
            return;
        }
        k21.i(memberDamaiAuthView, "this$0");
        int id = view.getId();
        int i = R$id.member_auth_right_close;
        if (id == i || view.getId() == R$id.tv_ll_member_pro_cancel) {
            IMemberPopEventListener iMemberPopEventListener = memberDamaiAuthView.popEventListener;
            if (iMemberPopEventListener != null) {
                iMemberPopEventListener.popDismiss();
            }
            int id2 = view.getId();
            String str2 = PP_AUTH_UT_MODULE;
            if (id2 == i) {
                if (!k21.d(PP_AUTH, memberDamaiAuthView.viewType)) {
                    str2 = DM_AUTH_UT_MODULE;
                }
                c.e().x(g03.Companion.a().h(memberDamaiAuthView.pageSource, str2, "close"));
            } else if (view.getId() == R$id.tv_ll_member_pro_cancel) {
                if (k21.d(PP_AUTH, memberDamaiAuthView.viewType)) {
                    str = "refuse";
                } else {
                    str = "cancel";
                    str2 = DM_AUTH_UT_MODULE;
                }
                c.e().x(g03.Companion.a().h(memberDamaiAuthView.pageSource, str2, str));
            }
        } else if (view.getId() == R$id.tv_ll_member_pro_agree) {
            CheckBox checkBox = memberDamaiAuthView.cbMemberAuth;
            TextView textView = null;
            if (checkBox == null) {
                k21.A("cbMemberAuth");
                checkBox = null;
            }
            if (!checkBox.isChecked()) {
                TextView textView2 = memberDamaiAuthView.tvCheckboxTip;
                if (textView2 == null) {
                    k21.A("tvCheckboxTip");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(memberDamaiAuthView.getVisibility());
            } else if (k21.d(DM_AUTH, view.getTag())) {
                IMemberPopEventListener iMemberPopEventListener2 = memberDamaiAuthView.popEventListener;
                if (iMemberPopEventListener2 != null) {
                    iMemberPopEventListener2.dmAgree();
                }
            } else {
                IMemberPopEventListener iMemberPopEventListener3 = memberDamaiAuthView.popEventListener;
                if (iMemberPopEventListener3 != null) {
                    iMemberPopEventListener3.tppAgree();
                }
            }
        }
    }

    public final View.OnClickListener getListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-603694881")) {
            return this.listener;
        }
        return (View.OnClickListener) ipChange.ipc$dispatch("-603694881", new Object[]{this});
    }

    public final IMemberPopEventListener getPopEventListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-230621323")) {
            return this.popEventListener;
        }
        return (IMemberPopEventListener) ipChange.ipc$dispatch("-230621323", new Object[]{this});
    }

    public final void setListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-158531185")) {
            ipChange.ipc$dispatch("-158531185", new Object[]{this, onClickListener});
            return;
        }
        k21.i(onClickListener, "<set-?>");
        this.listener = onClickListener;
    }

    public final void setPopEventListener(IMemberPopEventListener iMemberPopEventListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596107817")) {
            ipChange.ipc$dispatch("-1596107817", new Object[]{this, iMemberPopEventListener});
            return;
        }
        this.popEventListener = iMemberPopEventListener;
    }

    public final void updateData(MemberAuthBean.AuthProtocol authProtocol) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023620843")) {
            ipChange.ipc$dispatch("1023620843", new Object[]{this, authProtocol});
            return;
        }
        k21.i(authProtocol, "authProtocol");
        String str = authProtocol.type;
        k21.h(str, "authProtocol.type");
        this.viewType = str;
        String str2 = authProtocol.pageSource;
        k21.h(str2, "authProtocol.pageSource");
        this.pageSource = str2;
        DMIconFontTextView dMIconFontTextView = null;
        if (k21.d(DM_AUTH, this.viewType)) {
            SpannableString spannableString = new SpannableString("完成授权 (1/2）");
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#DD7F60")), 6, 7, 33);
            TextView textView = this.tvTitle;
            if (textView == null) {
                k21.A("tvTitle");
                textView = null;
            }
            textView.setText(spannableString);
            LinearLayout linearLayout = this.llTppTip;
            if (linearLayout == null) {
                k21.A("llTppTip");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
            TextView textView2 = this.tvProCancel;
            if (textView2 == null) {
                k21.A("tvProCancel");
                textView2 = null;
            }
            textView2.setText("取消");
            TextView textView3 = this.tvProAgree;
            if (textView3 == null) {
                k21.A("tvProAgree");
                textView3 = null;
            }
            textView3.setText("同意");
        } else {
            SpannableString spannableString2 = new SpannableString("完成授权 (2/2）本页面由淘票票提供");
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#DD7F60")), 6, 7, 33);
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#9c9ca5")), 10, 19, 33);
            spannableString2.setSpan(new AbsoluteSizeSpan(v50.a(getContext(), 12.0f)), spannableString2.length(), spannableString2.length(), 33);
            TextView textView4 = this.tvTitle;
            if (textView4 == null) {
                k21.A("tvTitle");
                textView4 = null;
            }
            textView4.setText(spannableString2);
            LinearLayout linearLayout2 = this.llTppTip;
            if (linearLayout2 == null) {
                k21.A("llTppTip");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(0);
            TextView textView5 = this.tvProCancel;
            if (textView5 == null) {
                k21.A("tvProCancel");
                textView5 = null;
            }
            textView5.setText("拒绝");
            TextView textView6 = this.tvProAgree;
            if (textView6 == null) {
                k21.A("tvProAgree");
                textView6 = null;
            }
            textView6.setText("确认授权");
        }
        String str3 = authProtocol.title;
        if (str3 != null) {
            if (StringsKt__StringsKt.Q(str3, jl1.MUL, false, 2, null)) {
                str3 = o.F(str3, jl1.MUL, "", false, 4, null);
            }
            TextView textView7 = this.memberAuthTip;
            if (textView7 == null) {
                k21.A("memberAuthTip");
                textView7 = null;
            }
            textView7.setText(str3);
        }
        if (xf2.e(authProtocol.desc) > 0) {
            LinearLayout linearLayout3 = this.protocolInstruction;
            if (linearLayout3 == null) {
                k21.A("protocolInstruction");
                linearLayout3 = null;
            }
            linearLayout3.setVisibility(0);
            LinearLayout linearLayout4 = this.protocolInstruction;
            if (linearLayout4 == null) {
                k21.A("protocolInstruction");
                linearLayout4 = null;
            }
            linearLayout4.removeAllViews();
            int size = authProtocol.desc.size();
            for (int i = 0; i < size; i++) {
                View inflate = LayoutInflater.from(getContext()).inflate(R$layout.commonbusiness_member_auth_protocol_line, (ViewGroup) null);
                k21.h(inflate, "from(context)\n          …auth_protocol_line, null)");
                ((TextView) inflate.findViewById(R$id.tv_member_auth_protocol_desc)).setText(authProtocol.desc.get(i));
                LinearLayout linearLayout5 = this.protocolInstruction;
                if (linearLayout5 == null) {
                    k21.A("protocolInstruction");
                    linearLayout5 = null;
                }
                linearLayout5.addView(inflate);
            }
        } else {
            LinearLayout linearLayout6 = this.protocolInstruction;
            if (linearLayout6 == null) {
                k21.A("protocolInstruction");
                linearLayout6 = null;
            }
            linearLayout6.setVisibility(8);
        }
        if (xf2.e(authProtocol.protocol) > 0) {
            TextView textView8 = this.tvProContent;
            if (textView8 == null) {
                k21.A("tvProContent");
                textView8 = null;
            }
            textView8.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            int size2 = authProtocol.protocol.size();
            for (int i2 = 0; i2 < size2; i2++) {
                MemberAuthBean.Protocol protocol = authProtocol.protocol.get(i2);
                if (protocol != null) {
                    if (!TextUtils.isEmpty(protocol.protocolTitle)) {
                        sb.append(protocol.protocolTitle);
                    }
                    if (!TextUtils.isEmpty(protocol.protocolName)) {
                        sb.append(protocol.protocolName);
                    }
                }
            }
            String sb2 = sb.toString();
            k21.h(sb2, "with(StringBuilder()) {\n… toString()\n            }");
            SpannableString spannableString3 = new SpannableString(sb2);
            StringBuilder sb3 = new StringBuilder();
            int size3 = authProtocol.protocol.size();
            for (int i3 = 0; i3 < size3; i3++) {
                MemberAuthBean.Protocol protocol2 = authProtocol.protocol.get(i3);
                if (protocol2 != null) {
                    if (!TextUtils.isEmpty(protocol2.protocolTitle)) {
                        sb3.append(protocol2.protocolTitle);
                    }
                    int length = sb3.length();
                    if (!TextUtils.isEmpty(protocol2.protocolName)) {
                        sb3.append(protocol2.protocolName);
                    }
                    int length2 = sb3.length();
                    b bVar = new b(protocol2.protocolUrl, this);
                    spannableString3.setSpan(new StyleSpan(0), length, length2, 17);
                    spannableString3.setSpan(bVar, length, length2, 17);
                }
            }
            TextView textView9 = this.tvProContent;
            if (textView9 == null) {
                k21.A("tvProContent");
                textView9 = null;
            }
            textView9.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView10 = this.tvProContent;
            if (textView10 == null) {
                k21.A("tvProContent");
                textView10 = null;
            }
            textView10.setHighlightColor(0);
            TextView textView11 = this.tvProContent;
            if (textView11 == null) {
                k21.A("tvProContent");
                textView11 = null;
            }
            textView11.setText(spannableString3);
        } else {
            TextView textView12 = this.tvProContent;
            if (textView12 == null) {
                k21.A("tvProContent");
                textView12 = null;
            }
            textView12.setVisibility(8);
        }
        TextView textView13 = this.tvProCancel;
        if (textView13 == null) {
            k21.A("tvProCancel");
            textView13 = null;
        }
        textView13.setOnClickListener(this.listener);
        TextView textView14 = this.tvProAgree;
        if (textView14 == null) {
            k21.A("tvProAgree");
            textView14 = null;
        }
        textView14.setOnClickListener(this.listener);
        TextView textView15 = this.tvProAgree;
        if (textView15 == null) {
            k21.A("tvProAgree");
            textView15 = null;
        }
        textView15.setTag(this.viewType);
        DMIconFontTextView dMIconFontTextView2 = this.close;
        if (dMIconFontTextView2 == null) {
            k21.A("close");
        } else {
            dMIconFontTextView = dMIconFontTextView2;
        }
        dMIconFontTextView.setOnClickListener(this.listener);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MemberDamaiAuthView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.viewType = DM_AUTH;
        this.pageSource = "";
        initView();
        this.listener = new kc1(this);
    }
}
