package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class CouponInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private BuyBtnVO buyBtnVO;
    @Nullable
    private String categoryId;
    @Nullable
    private String itemId;
    @Nullable
    private String itemName;
    @Nullable
    private String itemStatus;
    @Nullable
    private String itemType;
    @Nullable
    private String purchaseLimit;
    @Nullable
    private String sales;
    @Nullable
    private List<TicketNote> serviceNoteList;
    @Nullable
    private ShareInfoBean shareDO;
    @Nullable
    private ArrayList<SkuInfoBean> skuList;
    @Nullable
    private String storeName;

    @Nullable
    public final BuyBtnVO getBuyBtnVO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1503593872")) {
            return this.buyBtnVO;
        }
        return (BuyBtnVO) ipChange.ipc$dispatch("1503593872", new Object[]{this});
    }

    @Nullable
    public final String getCategoryId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-532698303")) {
            return this.categoryId;
        }
        return (String) ipChange.ipc$dispatch("-532698303", new Object[]{this});
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "798597654")) {
            return this.itemId;
        }
        return (String) ipChange.ipc$dispatch("798597654", new Object[]{this});
    }

    @Nullable
    public final String getItemName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1275917434")) {
            return this.itemName;
        }
        return (String) ipChange.ipc$dispatch("-1275917434", new Object[]{this});
    }

    @Nullable
    public final String getItemStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1067861139")) {
            return this.itemStatus;
        }
        return (String) ipChange.ipc$dispatch("-1067861139", new Object[]{this});
    }

    @Nullable
    public final String getItemType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "607384245")) {
            return this.itemType;
        }
        return (String) ipChange.ipc$dispatch("607384245", new Object[]{this});
    }

    @Nullable
    public final String getPurchaseLimit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1748506200")) {
            return this.purchaseLimit;
        }
        return (String) ipChange.ipc$dispatch("-1748506200", new Object[]{this});
    }

    @Nullable
    public final String getSales() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1349458298")) {
            return this.sales;
        }
        return (String) ipChange.ipc$dispatch("1349458298", new Object[]{this});
    }

    @Nullable
    public final List<TicketNote> getServiceNoteList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1692573158")) {
            return this.serviceNoteList;
        }
        return (List) ipChange.ipc$dispatch("-1692573158", new Object[]{this});
    }

    @Nullable
    public final ShareInfoBean getShareDO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-932908325")) {
            return this.shareDO;
        }
        return (ShareInfoBean) ipChange.ipc$dispatch("-932908325", new Object[]{this});
    }

    @Nullable
    public final ArrayList<SkuInfoBean> getSkuList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1809597009")) {
            return this.skuList;
        }
        return (ArrayList) ipChange.ipc$dispatch("1809597009", new Object[]{this});
    }

    @Nullable
    public final String getStoreName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-98609670")) {
            return this.storeName;
        }
        return (String) ipChange.ipc$dispatch("-98609670", new Object[]{this});
    }

    public final void setBuyBtnVO(@Nullable BuyBtnVO buyBtnVO2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1483060218")) {
            ipChange.ipc$dispatch("1483060218", new Object[]{this, buyBtnVO2});
            return;
        }
        this.buyBtnVO = buyBtnVO2;
    }

    public final void setCategoryId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1443661635")) {
            ipChange.ipc$dispatch("-1443661635", new Object[]{this, str});
            return;
        }
        this.categoryId = str;
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886598792")) {
            ipChange.ipc$dispatch("1886598792", new Object[]{this, str});
            return;
        }
        this.itemId = str;
    }

    public final void setItemName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781062632")) {
            ipChange.ipc$dispatch("-781062632", new Object[]{this, str});
            return;
        }
        this.itemName = str;
    }

    public final void setItemStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-853840367")) {
            ipChange.ipc$dispatch("-853840367", new Object[]{this, str});
            return;
        }
        this.itemStatus = str;
    }

    public final void setItemType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766714569")) {
            ipChange.ipc$dispatch("1766714569", new Object[]{this, str});
            return;
        }
        this.itemType = str;
    }

    public final void setPurchaseLimit(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237781042")) {
            ipChange.ipc$dispatch("-237781042", new Object[]{this, str});
            return;
        }
        this.purchaseLimit = str;
    }

    public final void setSales(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374901820")) {
            ipChange.ipc$dispatch("1374901820", new Object[]{this, str});
            return;
        }
        this.sales = str;
    }

    public final void setServiceNoteList(@Nullable List<TicketNote> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893277302")) {
            ipChange.ipc$dispatch("-1893277302", new Object[]{this, list});
            return;
        }
        this.serviceNoteList = list;
    }

    public final void setShareDO(@Nullable ShareInfoBean shareInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1102852641")) {
            ipChange.ipc$dispatch("1102852641", new Object[]{this, shareInfoBean});
            return;
        }
        this.shareDO = shareInfoBean;
    }

    public final void setSkuList(@Nullable ArrayList<SkuInfoBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373570439")) {
            ipChange.ipc$dispatch("373570439", new Object[]{this, arrayList});
            return;
        }
        this.skuList = arrayList;
    }

    public final void setStoreName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727137348")) {
            ipChange.ipc$dispatch("-727137348", new Object[]{this, str});
            return;
        }
        this.storeName = str;
    }
}
