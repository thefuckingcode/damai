package cn.damai.ticklet.ui.detailholder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import cn.damai.member.R$id;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.inteface.TickletPerformCallBack;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.view.TickletDetailPerformTicketView;
import cn.damai.uikit.view.FrameLayoutGradientView;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import java.io.Serializable;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class TicketDetailPerformViewHolder extends BaseViewHolder<Object> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String PERFORM_TICKET_DATA = "performTicketData";
    private boolean isInited;
    @NotNull
    private final FrameLayoutGradientView maskBg;
    @NotNull
    private final TickletDetailPerformTicketView performTicketView;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TicketDetailPerformViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        View findViewById = view.findViewById(R$id.ticklet_detail_kernel);
        k21.h(findViewById, "itemView.findViewById(R.id.ticklet_detail_kernel)");
        this.performTicketView = (TickletDetailPerformTicketView) findViewById;
        View findViewById2 = view.findViewById(R$id.color_mask_bg);
        k21.h(findViewById2, "itemView.findViewById(R.id.color_mask_bg)");
        this.maskBg = (FrameLayoutGradientView) findViewById2;
    }

    private final void setBgView(TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1088178509")) {
            ipChange.ipc$dispatch("-1088178509", new Object[]{this, ticketDeatilResult});
            return;
        }
        this.maskBg.setColors(ticketDeatilResult.getBgGradientColors());
        this.maskBg.setPosition(ticketDeatilResult.getBgGradientPostions());
    }

    private final void updatePerformTicket(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355323187")) {
            ipChange.ipc$dispatch("355323187", new Object[]{this, iItem});
            return;
        }
        Bundle bundle = iItem.getPageContext().getBundle();
        TicketDeatilResult ticketDeatilResult = null;
        Serializable serializable = bundle != null ? bundle.getSerializable(PERFORM_TICKET_DATA) : null;
        if (serializable instanceof TicketDeatilResult) {
            ticketDeatilResult = (TicketDeatilResult) serializable;
        }
        if (ticketDeatilResult != null) {
            this.performTicketView.update(ticketDeatilResult);
            setBgView(ticketDeatilResult);
        }
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "944799570")) {
            ipChange.ipc$dispatch("944799570", new Object[]{this, iItem});
            return;
        }
        k21.i(iItem, "item");
        if (!this.isInited) {
            this.isInited = true;
            Activity activity = iItem.getPageContext().getActivity();
            TicketDeatilActivity ticketDeatilActivity = activity instanceof TicketDeatilActivity ? (TicketDeatilActivity) activity : null;
            if (ticketDeatilActivity != null) {
                setCallback(ticketDeatilActivity, ticketDeatilActivity);
            }
            EventDispatcher eventDispatcher = iItem.getPageContext().getEventDispatcher();
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent("EventBus://business/notification/LoadTicketExt", null);
            }
        }
        updatePerformTicket(iItem);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1911839850")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1911839850", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "601762450")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("601762450", new Object[]{this})).booleanValue();
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder, com.youku.arch.v3.event.EventHandler, com.youku.arch.v3.adapter.VBaseHolder
    public boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        IItem<ItemValue> data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611362908")) {
            return ((Boolean) ipChange.ipc$dispatch("-611362908", new Object[]{this, str, map})).booleanValue();
        }
        k21.i(str, "type");
        if (k21.d(str, "EventBus://business/notification/RefreshPerform") && (data = getData()) != null) {
            updatePerformTicket(data);
        }
        return super.onMessage(str, map);
    }

    public final void setCallback(@Nullable TickletTicketCallback tickletTicketCallback, @Nullable TickletPerformCallBack<?> tickletPerformCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900293507")) {
            ipChange.ipc$dispatch("-900293507", new Object[]{this, tickletTicketCallback, tickletPerformCallBack});
            return;
        }
        this.performTicketView.setCallback(tickletTicketCallback, tickletPerformCallBack);
    }
}
