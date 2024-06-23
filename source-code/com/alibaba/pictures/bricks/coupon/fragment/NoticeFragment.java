package com.alibaba.pictures.bricks.coupon.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.CouponServiceRuleBean;
import com.alibaba.pictures.bricks.coupon.bean.NoticeBean;
import com.alibaba.pictures.bricks.coupon.bean.NoticeInfo;
import com.alibaba.pictures.bricks.coupon.order.bean.Notice;
import com.alibaba.pictures.bricks.coupon.order.bean.NoticeItem;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.rj1;
import tb.sj1;

/* compiled from: Taobao */
public final class NoticeFragment extends Fragment {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private View.OnClickListener mCloseListener;
    @Nullable
    private NoticeBean mParams;

    /* compiled from: Taobao */
    public static final class ItemAdapter extends RecyclerView.Adapter<ItemVh> {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final ArrayList<NoticeInfo> a = new ArrayList<>();

        @NotNull
        public final ArrayList<NoticeInfo> a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1041286188")) {
                return this.a;
            }
            return (ArrayList) ipChange.ipc$dispatch("-1041286188", new Object[]{this});
        }

        /* renamed from: b */
        public void onBindViewHolder(@NotNull ItemVh itemVh, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1733004245")) {
                ipChange.ipc$dispatch("-1733004245", new Object[]{this, itemVh, Integer.valueOf(i)});
                return;
            }
            k21.i(itemVh, "holder");
            NoticeInfo noticeInfo = this.a.get(i);
            k21.h(noticeInfo, "mList[position]");
            itemVh.a(noticeInfo);
        }

        @NotNull
        /* renamed from: c */
        public ItemVh onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2091824491")) {
                return (ItemVh) ipChange.ipc$dispatch("2091824491", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            k21.i(viewGroup, "parent");
            return new ItemVh(viewGroup);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "130365500")) {
                return this.a.size();
            }
            return ((Integer) ipChange.ipc$dispatch("130365500", new Object[]{this})).intValue();
        }
    }

    /* compiled from: Taobao */
    public static final class ItemVh extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private final TextView a = ((TextView) this.itemView.findViewById(R$id.id_bricks_item_tag_name_tv));
        private final TextView b = ((TextView) this.itemView.findViewById(R$id.id_bricks_item_tag_desc_tv));

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemVh(@NotNull ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_one_notice_view, viewGroup, false));
            k21.i(viewGroup, "parent");
        }

        public final void a(@NotNull NoticeInfo noticeInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1517979190")) {
                ipChange.ipc$dispatch("1517979190", new Object[]{this, noticeInfo});
                return;
            }
            k21.i(noticeInfo, "info");
            this.a.setText(noticeInfo.getRuleName());
            this.b.setText(noticeInfo.getRuleDesc());
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public final void a(@Nullable FragmentManager fragmentManager, @Nullable Fragment fragment) {
            FragmentTransaction beginTransaction;
            FragmentTransaction remove;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1478825514")) {
                ipChange.ipc$dispatch("1478825514", new Object[]{this, fragmentManager, fragment});
            } else if (fragment != null && fragmentManager != null && (beginTransaction = fragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(fragment)) != null) {
                remove.commitAllowingStateLoss();
            }
        }

        @JvmStatic
        @NotNull
        public final NoticeFragment b(@NotNull NoticeBean noticeBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1213250336")) {
                return (NoticeFragment) ipChange.ipc$dispatch("1213250336", new Object[]{this, noticeBean});
            }
            k21.i(noticeBean, "noticeBean");
            NoticeFragment noticeFragment = new NoticeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("NOTICE_EXTRA", noticeBean);
            noticeFragment.setArguments(bundle);
            return noticeFragment;
        }

        @Nullable
        public final NoticeFragment c(@NotNull FragmentManager fragmentManager, int i, @Nullable Notice notice) {
            List<NoticeItem> noticeList;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1595234675")) {
                return (NoticeFragment) ipChange.ipc$dispatch("1595234675", new Object[]{this, fragmentManager, Integer.valueOf(i), notice});
            }
            k21.i(fragmentManager, "fm");
            if (notice == null || (noticeList = notice.getNoticeList()) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = noticeList.iterator();
            while (it.hasNext()) {
                T next = it.next();
                arrayList.add(new NoticeInfo(next != null ? next.getTitle() : null, next != null ? next.getContent() : null));
            }
            NoticeFragment b = NoticeFragment.Companion.b(new NoticeBean("须知事项", arrayList));
            fragmentManager.beginTransaction().add(i, b).commitAllowingStateLoss();
            return b;
        }

        @Nullable
        public final NoticeFragment d(@NotNull FragmentManager fragmentManager, int i, @Nullable OrderDetail orderDetail) {
            ArrayList<CouponServiceRuleBean> ruleContexts;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1855799287")) {
                return (NoticeFragment) ipChange.ipc$dispatch("-1855799287", new Object[]{this, fragmentManager, Integer.valueOf(i), orderDetail});
            }
            k21.i(fragmentManager, "fm");
            if (orderDetail == null || (ruleContexts = orderDetail.getRuleContexts()) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (T t : ruleContexts) {
                arrayList.add(new NoticeInfo(t.getRuleName(), t.getContexts()));
            }
            NoticeFragment b = NoticeFragment.Companion.b(new NoticeBean("购券服务", arrayList));
            fragmentManager.beginTransaction().add(i, b).commitAllowingStateLoss();
            return b;
        }
    }

    @JvmStatic
    @NotNull
    public static final NoticeFragment newInstance(@NotNull NoticeBean noticeBean) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1334970024")) {
            return Companion.b(noticeBean);
        }
        return (NoticeFragment) ipChange.ipc$dispatch("-1334970024", new Object[]{noticeBean});
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m149onViewCreated$lambda1(NoticeFragment noticeFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178471993")) {
            ipChange.ipc$dispatch("178471993", new Object[]{noticeFragment, view});
            return;
        }
        k21.i(noticeFragment, "this$0");
        View.OnClickListener onClickListener = noticeFragment.mCloseListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m150onViewCreated$lambda2(NoticeFragment noticeFragment, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306583558")) {
            ipChange.ipc$dispatch("-1306583558", new Object[]{noticeFragment, view});
            return;
        }
        k21.i(noticeFragment, "this$0");
        View.OnClickListener onClickListener = noticeFragment.mCloseListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Nullable
    public final View.OnClickListener getMCloseListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1443887495")) {
            return this.mCloseListener;
        }
        return (View.OnClickListener) ipChange.ipc$dispatch("1443887495", new Object[]{this});
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539577896")) {
            ipChange.ipc$dispatch("-539577896", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mParams = (NoticeBean) arguments.getParcelable("NOTICE_EXTRA");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "64956076")) {
            return (View) ipChange.ipc$dispatch("64956076", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        k21.i(layoutInflater, "inflater");
        return layoutInflater.inflate(R$layout.brciks_fragment_notice, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1084156687")) {
            ipChange.ipc$dispatch("-1084156687", new Object[]{this, view, bundle});
            return;
        }
        k21.i(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R$id.id_notice_title);
        view.findViewById(R$id.id_notice_close_btn).setOnClickListener(new sj1(this));
        view.findViewById(R$id.id_id_notice_top_view).setOnClickListener(new rj1(this));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.id_notice_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity, 1, false));
            ItemAdapter itemAdapter = new ItemAdapter();
            NoticeBean noticeBean = this.mParams;
            if (noticeBean != null) {
                textView.setText(noticeBean.getTitle());
                List<NoticeInfo> items = noticeBean.getItems();
                if (items != null) {
                    Iterator<T> it = items.iterator();
                    while (it.hasNext()) {
                        itemAdapter.a().add(it.next());
                    }
                }
            }
            recyclerView.setAdapter(itemAdapter);
        }
    }

    public final void setMCloseListener(@Nullable View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1284096793")) {
            ipChange.ipc$dispatch("-1284096793", new Object[]{this, onClickListener});
            return;
        }
        this.mCloseListener = onClickListener;
    }
}
