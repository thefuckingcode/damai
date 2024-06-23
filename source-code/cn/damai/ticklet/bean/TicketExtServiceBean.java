package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class TicketExtServiceBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String iconUrl;
    @Nullable
    private String note;
    @Nullable
    private String orderDetailSource;
    @Nullable
    private String orderId;
    @Nullable
    private String subNote;
    @Nullable
    private String title;

    /* compiled from: Taobao */
    public static final class OrderDetailSource {
        @NotNull
        public static final String DETAIL_CARD_ARROW_JUMP_TYPE = "0";
        @NotNull
        public static final OrderDetailSource INSTANCE = new OrderDetailSource();

        private OrderDetailSource() {
        }
    }

    @Nullable
    public final String getIconUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1693836744")) {
            return this.iconUrl;
        }
        return (String) ipChange.ipc$dispatch("1693836744", new Object[]{this});
    }

    @Nullable
    public final String getNote() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "914876758")) {
            return this.note;
        }
        return (String) ipChange.ipc$dispatch("914876758", new Object[]{this});
    }

    @Nullable
    public final String getOrderDetailSource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1176608524")) {
            return this.orderDetailSource;
        }
        return (String) ipChange.ipc$dispatch("1176608524", new Object[]{this});
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-975003365")) {
            return this.orderId;
        }
        return (String) ipChange.ipc$dispatch("-975003365", new Object[]{this});
    }

    @Nullable
    public final String getSubNote() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-894898204")) {
            return this.subNote;
        }
        return (String) ipChange.ipc$dispatch("-894898204", new Object[]{this});
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-548759894")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-548759894", new Object[]{this});
    }

    public final boolean isHideArrowProhibitJump() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1439287668")) {
            return k21.d("0", this.orderDetailSource);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1439287668", new Object[]{this})).booleanValue();
    }

    public final void setIconUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-646922066")) {
            ipChange.ipc$dispatch("-646922066", new Object[]{this, str});
            return;
        }
        this.iconUrl = str;
    }

    public final void setNote(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996348344")) {
            ipChange.ipc$dispatch("-1996348344", new Object[]{this, str});
            return;
        }
        this.note = str;
    }

    public final void setOrderDetailSource(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168846614")) {
            ipChange.ipc$dispatch("-1168846614", new Object[]{this, str});
            return;
        }
        this.orderDetailSource = str;
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1776586821")) {
            ipChange.ipc$dispatch("-1776586821", new Object[]{this, str});
            return;
        }
        this.orderId = str;
    }

    public final void setSubNote(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706673170")) {
            ipChange.ipc$dispatch("706673170", new Object[]{this, str});
            return;
        }
        this.subNote = str;
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1635287284")) {
            ipChange.ipc$dispatch("-1635287284", new Object[]{this, str});
            return;
        }
        this.title = str;
    }
}
