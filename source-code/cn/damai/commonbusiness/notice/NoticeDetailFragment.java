package cn.damai.commonbusiness.notice;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.qj1;

/* compiled from: Taobao */
public final class NoticeDetailFragment extends DamaiBaseMvpFragment<cn.damai.common.app.base.a<?, ?>, BaseModel> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private NoticeAdapter adapter;
    private View closeBtn;
    private String itemId;
    private View.OnClickListener listener;
    private ArrayList<ItemContent> noticeList;
    private RecyclerView recyclerView;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @JvmStatic
        @NotNull
        public final NoticeDetailFragment a(@NotNull ArrayList<ItemContent> arrayList, @NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "224309703")) {
                return (NoticeDetailFragment) ipChange.ipc$dispatch("224309703", new Object[]{this, arrayList, str});
            }
            k21.i(arrayList, "bean");
            k21.i(str, "id");
            NoticeDetailFragment noticeDetailFragment = new NoticeDetailFragment();
            noticeDetailFragment.noticeList = arrayList;
            noticeDetailFragment.itemId = str;
            return noticeDetailFragment;
        }
    }

    @JvmStatic
    @NotNull
    public static final NoticeDetailFragment instance(@NotNull ArrayList<ItemContent> arrayList, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-54849969")) {
            return Companion.a(arrayList, str);
        }
        return (NoticeDetailFragment) ipChange.ipc$dispatch("-54849969", new Object[]{arrayList, str});
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m4onViewCreated$lambda0(NoticeDetailFragment noticeDetailFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1765905682")) {
            ipChange.ipc$dispatch("1765905682", new Object[]{noticeDetailFragment, view});
            return;
        }
        k21.i(noticeDetailFragment, "this$0");
        View.OnClickListener onClickListener = noticeDetailFragment.listener;
        if (onClickListener != null) {
            if (onClickListener == null) {
                k21.A("listener");
                onClickListener = null;
            }
            onClickListener.onClick(view);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1207038773")) {
            return R$layout.fragment_notice_detail_list;
        }
        return ((Integer) ipChange.ipc$dispatch("-1207038773", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1158647261")) {
            ipChange.ipc$dispatch("1158647261", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365779474")) {
            ipChange.ipc$dispatch("-1365779474", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1814293999")) {
            ipChange.ipc$dispatch("1814293999", new Object[]{this});
            return;
        }
        View findViewById = this.rootView.findViewById(R$id.fg_notice_recycler);
        k21.h(findViewById, "rootView.findViewById(R.id.fg_notice_recycler)");
        this.recyclerView = (RecyclerView) findViewById;
        View findViewById2 = this.rootView.findViewById(R$id.desc_close);
        k21.h(findViewById2, "rootView.findViewById(R.id.desc_close)");
        this.closeBtn = findViewById2;
    }

    public void onClick(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493231083")) {
            ipChange.ipc$dispatch("-1493231083", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111644668")) {
            ipChange.ipc$dispatch("-111644668", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView2 = this.recyclerView;
        View view2 = null;
        if (recyclerView2 == null) {
            k21.A("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.adapter = new NoticeAdapter();
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            k21.A("recyclerView");
            recyclerView3 = null;
        }
        NoticeAdapter noticeAdapter = this.adapter;
        if (noticeAdapter == null) {
            k21.A("adapter");
            noticeAdapter = null;
        }
        recyclerView3.setAdapter(noticeAdapter);
        if (this.noticeList != null) {
            NoticeAdapter noticeAdapter2 = this.adapter;
            if (noticeAdapter2 == null) {
                k21.A("adapter");
                noticeAdapter2 = null;
            }
            ArrayList<ItemContent> arrayList = this.noticeList;
            if (arrayList == null) {
                k21.A("noticeList");
                arrayList = null;
            }
            noticeAdapter2.c(arrayList);
        }
        View view3 = this.closeBtn;
        if (view3 == null) {
            k21.A("closeBtn");
        } else {
            view2 = view3;
        }
        view2.setOnClickListener(new qj1(this));
    }

    public final void setClose(@NotNull View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1517963765")) {
            ipChange.ipc$dispatch("-1517963765", new Object[]{this, onClickListener});
            return;
        }
        k21.i(onClickListener, NotifyType.LIGHTS);
        this.listener = onClickListener;
    }
}
