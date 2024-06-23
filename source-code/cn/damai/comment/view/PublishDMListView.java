package cn.damai.comment.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import cn.damai.comment.bean.DmInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.n42;
import tb.tv1;

/* compiled from: Taobao */
public final class PublishDMListView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnItemClickListener itemClickListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMListView(@NotNull Context context) {
        this(context, null, 2, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublishDMListView(Context context, AttributeSet attributeSet, int i, m40 m40) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: bindData$lambda-2$lambda-1  reason: not valid java name */
    public static final void m2bindData$lambda2$lambda1(List list, PublishDMListView publishDMListView, DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1292581221")) {
            ipChange.ipc$dispatch("1292581221", new Object[]{list, publishDMListView, dmInfo});
            return;
        }
        k21.i(publishDMListView, "this$0");
        if (list != null) {
            Iterator it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                DmInfo dmInfo2 = (DmInfo) it.next();
                if (k21.d(dmInfo.getDmId(), dmInfo2 != null ? dmInfo2.getDmId() : null)) {
                    break;
                }
                i++;
            }
            if (i < 0 || i >= list.size()) {
                z = false;
            }
            if (z) {
                publishDMListView.smoothScrollToPosition(i);
            }
        }
    }

    public final void bindData(@Nullable List<DmInfo> list, @Nullable DmInfo dmInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127596889")) {
            ipChange.ipc$dispatch("-2127596889", new Object[]{this, list, dmInfo});
            return;
        }
        RecyclerView.Adapter adapter = getAdapter();
        DMSelectListAdapter dMSelectListAdapter = adapter instanceof DMSelectListAdapter ? (DMSelectListAdapter) adapter : null;
        if (dMSelectListAdapter != null) {
            dMSelectListAdapter.e(list, dmInfo);
        }
        if (dmInfo != null) {
            postDelayed(new tv1(list, this, dmInfo), 500);
        }
    }

    @Nullable
    public final OnItemClickListener getItemClickListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "73609740")) {
            return this.itemClickListener;
        }
        return (OnItemClickListener) ipChange.ipc$dispatch("73609740", new Object[]{this});
    }

    @Nullable
    public final DmInfo getSelectedDm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-778657437")) {
            return (DmInfo) ipChange.ipc$dispatch("-778657437", new Object[]{this});
        }
        RecyclerView.Adapter adapter = getAdapter();
        DMSelectListAdapter dMSelectListAdapter = adapter instanceof DMSelectListAdapter ? (DMSelectListAdapter) adapter : null;
        if (dMSelectListAdapter != null) {
            return dMSelectListAdapter.b();
        }
        return null;
    }

    public final void setItemClickListener(@Nullable OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-802496124")) {
            ipChange.ipc$dispatch("-802496124", new Object[]{this, onItemClickListener});
            return;
        }
        this.itemClickListener = onItemClickListener;
        RecyclerView.Adapter adapter = getAdapter();
        DMSelectListAdapter dMSelectListAdapter = adapter instanceof DMSelectListAdapter ? (DMSelectListAdapter) adapter : null;
        if (dMSelectListAdapter != null) {
            dMSelectListAdapter.f(onItemClickListener);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PublishDMListView(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        addItemDecoration(new RecyclerView.ItemDecoration() {
            /* class cn.damai.comment.view.PublishDMListView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1095740389")) {
                    ipChange.ipc$dispatch("-1095740389", new Object[]{this, rect, view, recyclerView, state});
                    return;
                }
                k21.i(rect, "outRect");
                k21.i(view, "view");
                k21.i(recyclerView, "parent");
                k21.i(state, "state");
                super.getItemOffsets(rect, view, recyclerView, state);
                int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
                rect.left = n42.a(context, 6.0f);
                rect.right = n42.a(context, 6.0f);
                if (childLayoutPosition == 0) {
                    rect.left = n42.a(context, 20.0f);
                    return;
                }
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                k21.f(adapter);
                if (childLayoutPosition == adapter.getItemCount() - 1) {
                    rect.right = n42.a(context, 20.0f);
                }
            }
        });
        RecyclerView.ItemAnimator itemAnimator = getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        setLayoutManager(new LinearLayoutManager(context, 0, false));
        setAdapter(new DMSelectListAdapter(this.itemClickListener));
    }
}
