package com.alibaba.pictures.bricks.view;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.VoteBean;
import com.alibaba.pictures.bricks.bean.VoteInfoBean;
import com.alibaba.pictures.bricks.view.BottomListDialog;
import com.alibaba.pictures.bricks.view.request.VoteActionRequest;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ca1;
import tb.e92;
import tb.eb0;
import tb.k21;
import tb.tw2;

/* compiled from: Taobao */
public final class VotePanel implements OnItemClickListener<VoteBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final ViewGroup a;
    @NotNull
    private final TextView b;
    @NotNull
    private final TextView c;
    @NotNull
    private final ViewGroup d;
    @Nullable
    private VoteInfoBean e;
    private int f;
    @NotNull
    private final VoteActionListener g;
    private int h;

    /* compiled from: Taobao */
    public interface VoteActionListener extends VoteUtListener {
        @Nullable
        Activity getActivity();

        void onVoteInfoUpdate(@NotNull VoteInfoBean voteInfoBean);

        void showActivityLoading(boolean z);
    }

    /* compiled from: Taobao */
    public interface VoteUtListener {
        void ut4CancelVoteClick(@Nullable VoteInfoBean voteInfoBean);

        void ut4VoteCardExposure(@Nullable View view, @Nullable VoteInfoBean voteInfoBean, int i);

        void ut4VoteClick(@Nullable VoteInfoBean voteInfoBean, @Nullable VoteBean voteBean, int i);
    }

    /* compiled from: Taobao */
    public static final class a implements BottomListDialog.OnActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ VotePanel a;
        final /* synthetic */ VoteBean b;
        final /* synthetic */ String c;

        a(VotePanel votePanel, VoteBean voteBean, String str) {
            this.a = votePanel;
            this.b = voteBean;
            this.c = str;
        }

        @Override // com.alibaba.pictures.bricks.view.BottomListDialog.OnActionListener
        public void onCancelVoteClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-569016308")) {
                ipChange.ipc$dispatch("-569016308", new Object[]{this});
                return;
            }
            VotePanel votePanel = this.a;
            VoteBean voteBean = this.b;
            String str = this.c;
            k21.h(str, "activityId");
            votePanel.f(voteBean, str, false, this.a.g());
        }

        @Override // com.alibaba.pictures.bricks.view.BottomListDialog.OnActionListener
        public void onGiveUpClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-645711212")) {
                ipChange.ipc$dispatch("-645711212", new Object[]{this});
            }
        }
    }

    public VotePanel(@NotNull ViewGroup viewGroup, @NotNull VoteActionListener voteActionListener) {
        k21.i(viewGroup, "mRoot");
        k21.i(voteActionListener, "listener");
        this.a = viewGroup;
        View findViewById = viewGroup.findViewById(R$id.vote_select_title);
        k21.h(findViewById, "mRoot.findViewById(R.id.vote_select_title)");
        this.b = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R$id.vote_select_count);
        k21.h(findViewById2, "mRoot.findViewById(R.id.vote_select_count)");
        this.c = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R$id.vote_select_item_container);
        k21.h(findViewById3, "mRoot.findViewById(R.id.…te_select_item_container)");
        this.d = (ViewGroup) findViewById3;
        this.g = voteActionListener;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void f(VoteBean voteBean, String str, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525228938")) {
            ipChange.ipc$dispatch("-1525228938", new Object[]{this, voteBean, str, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (i() || this.e == null) {
            this.g.showActivityLoading(true);
            if (!DoloresLoginHandler.Companion.a().c()) {
                ca1.a aVar = ca1.Companion;
                Context context = this.a.getContext();
                k21.h(context, "mRoot.context");
                aVar.b(context);
                return;
            }
            VoteInfoBean voteInfoBean = this.e;
            k21.f(voteInfoBean);
            String str2 = voteInfoBean.id;
            k21.h(str2, "mBean!!.id");
            eb0.a(new VoteActionRequest(str2, str, z)).doOnKTSuccess(new VotePanel$dispatchVoteAction$1(this, z, voteBean, i)).doOnKTFail(new VotePanel$dispatchVoteAction$2(this));
        }
    }

    private final boolean i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348392824")) {
            return ((Boolean) ipChange.ipc$dispatch("348392824", new Object[]{this})).booleanValue();
        }
        Activity activity = this.g.getActivity();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    private final void k(boolean z, List<? extends VoteBean> list, boolean z2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1507467371")) {
            ipChange.ipc$dispatch("1507467371", new Object[]{this, Boolean.valueOf(z), list, Boolean.valueOf(z2), Integer.valueOf(i)});
            return;
        }
        if (e92.d(list)) {
            this.d.removeAllViews();
        } else {
            int childCount = this.d.getChildCount();
            int size = list.size();
            int i2 = size - childCount;
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    View inflate = LayoutInflater.from(AppInfoProviderProxy.getApplication()).inflate(R$layout.bricks_item_single_vote_bar, this.d, false);
                    k21.g(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                    ViewGroup viewGroup = (ViewGroup) inflate;
                    viewGroup.setTag(new tw2(viewGroup, this));
                    this.d.addView(viewGroup);
                }
            }
            if (i2 < 0) {
                this.d.removeViews(size, -i2);
            }
        }
        int childCount2 = this.d.getChildCount();
        for (int i4 = 0; i4 < childCount2; i4++) {
            VoteBean voteBean = (VoteBean) e92.b(list, i4);
            Object tag = this.d.getChildAt(i4).getTag();
            if ((tag instanceof tw2) && voteBean != null) {
                if (i == 1 && Build.VERSION.SDK_INT >= 21) {
                    ((tw2) tag).d(this.a.getContext().getDrawable(R$drawable.bricks_purple_progress_drawable), this.a.getContext().getDrawable(R$drawable.bricks_grey_progress_drawable), "#8F8FFF", "#333333");
                }
                ((tw2) tag).b(voteBean, z, i4, z2);
            }
        }
    }

    public final void d(@Nullable VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1682325428")) {
            ipChange.ipc$dispatch("-1682325428", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
            return;
        }
        e(voteInfoBean, false, i);
    }

    public final void e(@Nullable VoteInfoBean voteInfoBean, boolean z, int i) {
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-611944826")) {
            ipChange.ipc$dispatch("-611944826", new Object[]{this, voteInfoBean, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (voteInfoBean != null) {
            this.e = voteInfoBean;
            this.f = i;
            k21.f(voteInfoBean);
            voteInfoBean.computeItemProgressIntIfNeed();
            this.b.setText(voteInfoBean.name);
            TextView textView = this.c;
            if (this.h == 1) {
                z2 = true;
            }
            textView.setText(voteInfoBean.getPeopleCountText(z2));
            try {
                VoteInfoBean voteInfoBean2 = this.e;
                k21.f(voteInfoBean2);
                boolean z3 = voteInfoBean2.hasVote;
                List<VoteBean> list = voteInfoBean.activityOptions;
                k21.h(list, "bean.activityOptions");
                k(z3, list, z, this.h);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.g.ut4VoteCardExposure(this.a, this.e, this.f);
        }
    }

    public final int g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1150712746")) {
            return this.f;
        }
        return ((Integer) ipChange.ipc$dispatch("-1150712746", new Object[]{this})).intValue();
    }

    @NotNull
    public final View h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1961751998")) {
            return this.a;
        }
        return (View) ipChange.ipc$dispatch("1961751998", new Object[]{this});
    }

    /* renamed from: j */
    public void onItemClick(@Nullable VoteBean voteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1093666558")) {
            ipChange.ipc$dispatch("-1093666558", new Object[]{this, voteBean, Integer.valueOf(i)});
        } else if (this.e != null && i()) {
            Activity activity = this.g.getActivity();
            VoteInfoBean voteInfoBean = this.e;
            k21.f(voteInfoBean);
            if (voteInfoBean.hasVote) {
                VoteInfoBean voteInfoBean2 = this.e;
                k21.f(voteInfoBean2);
                String votedItemId = voteInfoBean2.getVotedItemId();
                k21.f(activity);
                new BottomListDialog(activity, new a(this, voteBean, votedItemId)).show();
                return;
            }
            k21.f(voteBean);
            String str = voteBean.id;
            k21.h(str, "bean!!.id");
            f(voteBean, str, true, this.f);
        }
    }
}
