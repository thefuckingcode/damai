package cn.damai.commonbusiness.discover.viewholder;

import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.bean.VoteActionRes;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.request.VoteActionRequest;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.uikit.view.BottomListDialog;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;
import tb.n42;
import tb.uw2;
import tb.xs0;

/* compiled from: Taobao */
public class VotePanel implements OnItemClickListener<VoteBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup a;
    private TextView b;
    private TextView c;
    private ViewGroup d;
    private VoteInfoBean e;
    public int f;
    private VoteActionListener g;
    private int h;

    /* compiled from: Taobao */
    public interface VoteActionListener extends VoteUtListener {
        @Nullable
        Activity getActivity();

        void onVoteInfoUpdate(@NonNull VoteInfoBean voteInfoBean);

        void showActivityLoading(boolean z);
    }

    /* compiled from: Taobao */
    public interface VoteUtListener {
        void ut4CancelVoteClick(VoteInfoBean voteInfoBean);

        void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i);

        void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i);
    }

    /* compiled from: Taobao */
    public class a implements BottomListDialog.OnActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ VoteBean a;
        final /* synthetic */ String b;

        a(VoteBean voteBean, String str) {
            this.a = voteBean;
            this.b = str;
        }

        @Override // cn.damai.uikit.view.BottomListDialog.OnActionListener
        public void onCancelVoteClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "744406274")) {
                ipChange.ipc$dispatch("744406274", new Object[]{this});
                return;
            }
            VotePanel votePanel = VotePanel.this;
            votePanel.g(this.a, this.b, false, votePanel.f);
        }

        @Override // cn.damai.uikit.view.BottomListDialog.OnActionListener
        public void onGiveUpClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "430793354")) {
                ipChange.ipc$dispatch("430793354", new Object[]{this});
            }
        }
    }

    public VotePanel(ViewGroup viewGroup, @NonNull VoteActionListener voteActionListener) {
        this.a = viewGroup;
        this.b = (TextView) viewGroup.findViewById(R$id.vote_select_title);
        this.c = (TextView) viewGroup.findViewById(R$id.vote_select_count);
        this.d = (ViewGroup) viewGroup.findViewById(R$id.vote_select_item_container);
        this.g = voteActionListener;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(final VoteBean voteBean, String str, final boolean z, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-530631960")) {
            ipChange.ipc$dispatch("-530631960", new Object[]{this, voteBean, str, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (j() || this.e == null) {
            this.g.showActivityLoading(true);
            new VoteActionRequest(this.e.id, str, z).request(new DMMtopRequestListener<VoteActionRes>(VoteActionRes.class) {
                /* class cn.damai.commonbusiness.discover.viewholder.VotePanel.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "921746651")) {
                        ipChange.ipc$dispatch("921746651", new Object[]{this, str, str2});
                        return;
                    }
                    VotePanel.this.g.showActivityLoading(false);
                    ToastUtil.a().j(xs0.a(), str2);
                }

                public void onSuccess(VoteActionRes voteActionRes) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "661154305")) {
                        ipChange.ipc$dispatch("661154305", new Object[]{this, voteActionRes});
                        return;
                    }
                    VotePanel.this.g.showActivityLoading(false);
                    if (voteActionRes.isShouldShowToast()) {
                        ToastUtil.a().j(xs0.a(), voteActionRes.msg);
                    }
                    if (voteActionRes.isValid()) {
                        VotePanel.this.g.onVoteInfoUpdate(voteActionRes.voteVO);
                        VotePanel votePanel = VotePanel.this;
                        votePanel.f(voteActionRes.voteVO, true, votePanel.f);
                    } else {
                        onFail("-1", "数据异常，请点击重试");
                    }
                    if (VotePanel.this.e == null) {
                        return;
                    }
                    if (z) {
                        VotePanel.this.g.ut4VoteClick(VotePanel.this.e, voteBean, i);
                    } else {
                        VotePanel.this.g.ut4CancelVoteClick(VotePanel.this.e);
                    }
                }
            });
        }
    }

    private boolean j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "179699397")) {
            return ((Boolean) ipChange.ipc$dispatch("179699397", new Object[]{this})).booleanValue();
        }
        Activity activity = this.g.getActivity();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    private void l(boolean z, List<VoteBean> list, boolean z2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131087032")) {
            ipChange.ipc$dispatch("131087032", new Object[]{this, Boolean.valueOf(z), list, Boolean.valueOf(z2), Integer.valueOf(i)});
            return;
        }
        if (f92.d(list)) {
            this.d.removeAllViews();
        } else {
            int childCount = this.d.getChildCount();
            int size = list.size();
            int i2 = size - childCount;
            if (i2 > 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(xs0.a()).inflate(R$layout.item_single_vote_bar, this.d, false);
                    viewGroup.setTag(new uw2(viewGroup, this));
                    this.d.addView(viewGroup);
                }
            }
            if (i2 < 0) {
                this.d.removeViews(size, -i2);
            }
        }
        int childCount2 = this.d.getChildCount();
        for (int i4 = 0; i4 < childCount2; i4++) {
            VoteBean voteBean = (VoteBean) f92.b(list, i4);
            Object tag = this.d.getChildAt(i4).getTag();
            if ((tag instanceof uw2) && voteBean != null) {
                if (i == 1 && Build.VERSION.SDK_INT >= 21) {
                    ((uw2) tag).d(this.a.getContext().getDrawable(R$drawable.purple_progress_drawable), this.a.getContext().getDrawable(R$drawable.grey_progress_drawable), "#8F8FFF", "#333333");
                }
                ((uw2) tag).b(voteBean, z, i4, z2);
            }
        }
    }

    public void d(VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602395606")) {
            ipChange.ipc$dispatch("-1602395606", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
            return;
        }
        f(voteInfoBean, false, i);
    }

    public void e(VoteInfoBean voteInfoBean, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1865373209")) {
            ipChange.ipc$dispatch("1865373209", new Object[]{this, voteInfoBean, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.h = i2;
        f(voteInfoBean, false, i);
    }

    public void f(VoteInfoBean voteInfoBean, boolean z, int i) {
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "1865879656")) {
            ipChange.ipc$dispatch("1865879656", new Object[]{this, voteInfoBean, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (voteInfoBean != null) {
            this.e = voteInfoBean;
            this.f = i;
            voteInfoBean.computeItemProgressIntIfNeed();
            this.b.setText(voteInfoBean.name);
            TextView textView = this.c;
            if (this.h == 1) {
                z2 = true;
            }
            textView.setText(voteInfoBean.getPeopleCountText(z2));
            try {
                l(this.e.hasVote, voteInfoBean.activityOptions, z, this.h);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.g.ut4VoteCardExposure(this.a, this.e, this.f);
        }
    }

    public int h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-759779354")) {
            return ((Integer) ipChange.ipc$dispatch("-759779354", new Object[]{this})).intValue();
        }
        int i = DisplayMetrics.getwidthPixels(n42.b(xs0.a()));
        int i2 = DisplayMetrics.getheightPixels(n42.b(xs0.a()));
        this.a.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
        return this.a.getMeasuredHeight();
    }

    public View i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1960650769")) {
            return this.a;
        }
        return (View) ipChange.ipc$dispatch("1960650769", new Object[]{this});
    }

    /* renamed from: k */
    public void onItemClick(VoteBean voteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315081262")) {
            ipChange.ipc$dispatch("-1315081262", new Object[]{this, voteBean, Integer.valueOf(i)});
        } else if (this.e != null && j()) {
            Activity activity = this.g.getActivity();
            VoteInfoBean voteInfoBean = this.e;
            if (voteInfoBean.hasVote) {
                new BottomListDialog(activity, new a(voteBean, voteInfoBean.getVotedItemId())).show();
            } else {
                g(voteBean, voteBean.id, true, this.f);
            }
        }
    }
}
