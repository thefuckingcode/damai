package cn.damai.ticklet.ui.detailholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.im.AliMeUtil;
import cn.damai.login.LoginManager;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketExtFAQBean;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import tb.bl2;
import tb.cl2;
import tb.d20;
import tb.dl2;
import tb.k21;
import tb.lw2;
import tb.sl2;
import tb.wk;
import tb.xf2;

/* compiled from: Taobao */
public final class TicketExtFAQViewHolder extends BaseViewHolder<TicketExtFAQBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final TextView content;
    @NotNull
    private final FlowLayout faq;
    @NotNull
    private final TextView faqEntrance;
    @NotNull
    private final TextView title;
    @NotNull
    private final ImageView titleIcon;

    /* compiled from: Taobao */
    public static final class a implements AliMeUtil.OnAliMeTokenListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TicketExtFAQViewHolder a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        a(TicketExtFAQViewHolder ticketExtFAQViewHolder, String str, String str2, String str3) {
            this.a = ticketExtFAQViewHolder;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onFailed(@NotNull String str, @NotNull String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "869657325")) {
                ipChange.ipc$dispatch("869657325", new Object[]{this, str, str2});
                return;
            }
            k21.i(str, "errorCode");
            k21.i(str2, "errorMsg");
            Context context = this.a.getContext();
            k21.g(context, "null cannot be cast to non-null type cn.damai.commonbusiness.base.DamaiBaseActivity<*, *>");
            ((DamaiBaseActivity) context).stopProgressDialog();
            AliMeUtil.p(str, str2);
        }

        @Override // cn.damai.im.AliMeUtil.OnAliMeTokenListener
        public void onSuccess(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "415474683")) {
                ipChange.ipc$dispatch("415474683", new Object[]{this, str});
                return;
            }
            k21.i(str, "token");
            Context context = this.a.getContext();
            k21.g(context, "null cannot be cast to non-null type cn.damai.commonbusiness.base.DamaiBaseActivity<*, *>");
            ((DamaiBaseActivity) context).stopProgressDialog();
            if (!xf2.j(str)) {
                this.a.launchAliMe(str, this.b, this.c, this.d);
            } else {
                AliMeUtil.o();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TicketExtFAQViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        View findViewById = view.findViewById(R$id.title);
        k21.h(findViewById, "itemView.findViewById(R.id.title)");
        this.title = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.faq_entrance);
        k21.h(findViewById2, "itemView.findViewById(R.id.faq_entrance)");
        this.faqEntrance = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.title_icon);
        k21.h(findViewById3, "itemView.findViewById(R.id.title_icon)");
        this.titleIcon = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R$id.content);
        k21.h(findViewById4, "itemView.findViewById(R.id.content)");
        this.content = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R$id.faq);
        k21.h(findViewById5, "itemView.findViewById(R.id.faq)");
        this.faq = (FlowLayout) findViewById5;
    }

    private final void addProblemItems(ArrayList<String> arrayList) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871621228")) {
            ipChange.ipc$dispatch("-871621228", new Object[]{this, arrayList});
            return;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = arrayList.get(i3);
            k21.h(str, "normalQuestionList[i]");
            String str2 = str;
            View childAt = this.faq.getChildAt(i3);
            if (childAt == null) {
                FlowLayout flowLayout = this.faq;
                String str3 = arrayList.get(i3);
                k21.h(str3, "normalQuestionList[i]");
                flowLayout.addView(getItemView(str3));
            } else {
                TextView textView = (TextView) childAt;
                if (!TextUtils.equals(textView.getText().toString(), str2)) {
                    textView.setText(str2);
                    textView.setOnClickListener(new cl2(this, str2));
                }
            }
        }
        int childCount = this.faq.getChildCount();
        if (childCount > size && childCount > 0 && (i2 = (size - 1) + 1) <= (i = childCount - 1)) {
            while (true) {
                this.faq.removeViewAt(i);
                if (i != i2) {
                    i--;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addProblemItems$lambda-2  reason: not valid java name */
    public static final void m67addProblemItems$lambda2(TicketExtFAQViewHolder ticketExtFAQViewHolder, String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2014087008")) {
            ipChange.ipc$dispatch("2014087008", new Object[]{ticketExtFAQViewHolder, str, view});
            return;
        }
        k21.i(ticketExtFAQViewHolder, "this$0");
        k21.i(str, "$content");
        if (k21.d(((TicketExtFAQBean) ticketExtFAQViewHolder.getValue()).getRoleAndSceneGame(), Boolean.TRUE)) {
            ticketExtFAQViewHolder.gotoMyKeFu(AliMeUtil.SESSION_SCRIPT_COUPON_DETAIL, str);
        } else {
            ticketExtFAQViewHolder.gotoMyKeFu(AliMeUtil.FROM_SERVICE_PROBLEM, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-1  reason: not valid java name */
    public static final void m68bindData$lambda1(TicketExtFAQViewHolder ticketExtFAQViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1241012694")) {
            ipChange.ipc$dispatch("1241012694", new Object[]{ticketExtFAQViewHolder, view});
            return;
        }
        k21.i(ticketExtFAQViewHolder, "this$0");
        HashMap hashMap = new HashMap();
        Context context = ticketExtFAQViewHolder.getContext();
        k21.g(context, "null cannot be cast to non-null type cn.damai.ticklet.ui.activity.TicketDeatilActivity");
        String str = ((TicketDeatilActivity) context).performId;
        Context context2 = ticketExtFAQViewHolder.getContext();
        k21.g(context2, "null cannot be cast to non-null type cn.damai.ticklet.ui.activity.TicketDeatilActivity");
        String projectId = ((TicketDeatilActivity) context2).getProjectId();
        k21.h(str, TicketDetailExtFragment.PERFORM_ID);
        hashMap.put("screening_id", str);
        k21.h(projectId, "projectId");
        hashMap.put("item_id", projectId);
        c e = c.e();
        b instance = b.getInstance();
        Boolean bool = Boolean.TRUE;
        e.x(instance.e(sl2.TICKLET_DETAIL_PAGE, "ticket_info", wk.MY_ALIME_PAGE, hashMap, bool));
        if (k21.d(((TicketExtFAQBean) ticketExtFAQViewHolder.getValue()).getRoleAndSceneGame(), bool)) {
            ticketExtFAQViewHolder.gotoMyKeFu(AliMeUtil.SESSION_SCRIPT_COUPON_DETAIL, null);
        } else {
            ticketExtFAQViewHolder.gotoMyKeFu(AliMeUtil.FROM_SERVICE, null);
        }
    }

    private final void getAliMeTokenAndEnter(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1872274812")) {
            ipChange.ipc$dispatch("1872274812", new Object[]{this, str, str2, str3});
            return;
        }
        String E = d20.E();
        if (LoginManager.k().q() && !TextUtils.isEmpty(E)) {
            int k = xf2.k(E);
            Context context = getContext();
            k21.g(context, "null cannot be cast to non-null type cn.damai.commonbusiness.base.DamaiBaseActivity<*, *>");
            ((DamaiBaseActivity) context).startProgressDialog();
            AliMeUtil.d(k, str, new a(this, str, str2, str3));
        } else if (!LoginManager.k().q()) {
            LoginManager k2 = LoginManager.k();
            Context context2 = getContext();
            k21.g(context2, "null cannot be cast to non-null type android.app.Activity");
            k2.x((Activity) context2, new Intent(), 1000);
        }
    }

    private final View getItemView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1481880522")) {
            return (View) ipChange.ipc$dispatch("-1481880522", new Object[]{this, str});
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.common_problem_item, (ViewGroup) this.faq, false);
        View findViewById = inflate.findViewById(R$id.problem_name_tv);
        k21.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        textView.setText(str);
        textView.setOnClickListener(new dl2(this, str));
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: getItemView$lambda-3  reason: not valid java name */
    public static final void m69getItemView$lambda3(TicketExtFAQViewHolder ticketExtFAQViewHolder, String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-460131029")) {
            ipChange.ipc$dispatch("-460131029", new Object[]{ticketExtFAQViewHolder, str, view});
            return;
        }
        k21.i(ticketExtFAQViewHolder, "this$0");
        k21.i(str, "$content");
        HashMap hashMap = new HashMap();
        Context context = ticketExtFAQViewHolder.getContext();
        k21.g(context, "null cannot be cast to non-null type cn.damai.ticklet.ui.activity.TicketDeatilActivity");
        String str2 = ((TicketDeatilActivity) context).performId;
        Context context2 = ticketExtFAQViewHolder.getContext();
        k21.g(context2, "null cannot be cast to non-null type cn.damai.ticklet.ui.activity.TicketDeatilActivity");
        String projectId = ((TicketDeatilActivity) context2).getProjectId();
        k21.h(str2, TicketDetailExtFragment.PERFORM_ID);
        hashMap.put("screening_id", str2);
        k21.h(projectId, "projectId");
        hashMap.put("item_id", projectId);
        c e = c.e();
        b instance = b.getInstance();
        Boolean bool = Boolean.TRUE;
        e.x(instance.e(sl2.TICKLET_DETAIL_PAGE, "ticket_info", wk.MY_ALIME_PAGE, hashMap, bool));
        if (k21.d(((TicketExtFAQBean) ticketExtFAQViewHolder.getValue()).getRoleAndSceneGame(), bool)) {
            ticketExtFAQViewHolder.gotoMyKeFu(AliMeUtil.SESSION_SCRIPT_COUPON_DETAIL, str);
        } else {
            ticketExtFAQViewHolder.gotoMyKeFu(AliMeUtil.FROM_SERVICE_PROBLEM, str);
        }
    }

    private final void gotoMyKeFu(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-429202802")) {
            ipChange.ipc$dispatch("-429202802", new Object[]{this, str, str2});
            return;
        }
        Context context = getContext();
        k21.g(context, "null cannot be cast to non-null type cn.damai.ticklet.ui.activity.TicketDeatilActivity");
        String projectId = ((TicketDeatilActivity) context).getProjectId();
        if (!LoginManager.k().q()) {
            LoginManager k = LoginManager.k();
            Context context2 = getContext();
            k21.g(context2, "null cannot be cast to non-null type android.app.Activity");
            k.x((Activity) context2, new Intent(), 1000);
            return;
        }
        k21.h(projectId, "projectId");
        getAliMeTokenAndEnter(str, str2, projectId);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void launchAliMe(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-114699619")) {
            ipChange.ipc$dispatch("-114699619", new Object[]{this, str, str2, str3, str4});
            return;
        }
        String f = AliMeUtil.f(str2, str, str4, str3);
        if (!xf2.j(f)) {
            Context context = getContext();
            k21.g(context, "null cannot be cast to non-null type cn.damai.commonbusiness.base.DamaiBaseActivity<*, *>");
            AliMeUtil.b((DamaiBaseActivity) context, f);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1901988071")) {
            ipChange.ipc$dispatch("1901988071", new Object[]{this, iItem});
            return;
        }
        k21.i(iItem, "item");
        TicketExtFAQBean ticketExtFAQBean = (TicketExtFAQBean) getValue();
        this.title.setText(ticketExtFAQBean.getTitle());
        String iconUrl = ticketExtFAQBean.getIconUrl();
        if (iconUrl == null || iconUrl.length() == 0) {
            this.titleIcon.setVisibility(8);
        } else {
            lw2.s(this.titleIcon, ticketExtFAQBean.getIconUrl(), R$drawable.uikit_default_image_bg_grey);
            this.titleIcon.setVisibility(0);
        }
        String note = ticketExtFAQBean.getNote();
        if (note == null || note.length() == 0) {
            this.content.setVisibility(8);
        } else {
            this.content.setVisibility(0);
            this.content.setText(ticketExtFAQBean.getNote());
        }
        ArrayList<String> normalQuestionList = ticketExtFAQBean.getNormalQuestionList();
        if (normalQuestionList != null && !normalQuestionList.isEmpty()) {
            z = false;
        }
        if (z) {
            this.faq.setVisibility(8);
        } else {
            this.faq.setVisibility(0);
            ArrayList<String> normalQuestionList2 = ticketExtFAQBean.getNormalQuestionList();
            k21.f(normalQuestionList2);
            addProblemItems(normalQuestionList2);
        }
        this.faqEntrance.setOnClickListener(new bl2(this));
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1857367009")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1857367009", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1483058087")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1483058087", new Object[]{this})).booleanValue();
    }
}
