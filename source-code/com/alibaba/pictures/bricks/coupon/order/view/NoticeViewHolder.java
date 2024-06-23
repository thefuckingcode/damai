package com.alibaba.pictures.bricks.coupon.order.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.coupon.order.bean.Notice;
import com.alibaba.pictures.bricks.listener.OnItemListener;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.qm1;
import tb.uj1;

/* compiled from: Taobao */
public final class NoticeViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OnItemListener<Notice> a;
    @Nullable
    private Notice b;
    @Nullable
    private TrackInfo c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoticeViewHolder(@NotNull View view, @Nullable OnItemListener<Notice> onItemListener) {
        super(view);
        k21.i(view, "itemView");
        this.a = onItemListener;
        view.setOnClickListener(new uj1(this));
    }

    /* access modifiers changed from: private */
    public static final void b(NoticeViewHolder noticeViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1945094552")) {
            ipChange.ipc$dispatch("-1945094552", new Object[]{noticeViewHolder, view});
            return;
        }
        k21.i(noticeViewHolder, "this$0");
        Notice notice = noticeViewHolder.b;
        if (notice != null) {
            TrackInfo trackInfo = noticeViewHolder.c;
            if (trackInfo != null) {
                qm1 qm1 = qm1.INSTANCE;
                k21.h(view, AdvanceSetting.NETWORK_TYPE);
                qm1.g(view, trackInfo);
            }
            UserTrackProviderProxy.click(view, noticeViewHolder.c, false);
            OnItemListener<Notice> onItemListener = noticeViewHolder.a;
            if (onItemListener != null) {
                onItemListener.onItemClick(notice, 0);
            }
        }
    }

    public final void c(@NotNull Notice notice, @NotNull TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401355779")) {
            ipChange.ipc$dispatch("-1401355779", new Object[]{this, notice, trackInfo});
            return;
        }
        k21.i(notice, "bean");
        k21.i(trackInfo, "trackInfo");
        this.b = notice;
        this.c = trackInfo;
        qm1 qm1 = qm1.INSTANCE;
        View view = this.itemView;
        k21.h(view, "itemView");
        qm1.h(view, trackInfo);
        UserTrackProviderProxy.expose(this.itemView, this.c);
    }
}
