package com.alibaba.pictures.bricks.coupon.order.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message = "")
/* compiled from: Taobao */
public final class ShopDetailBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String distance;
    @Nullable
    private String id;
    @Nullable
    private String latitude;
    @Nullable
    private String longitude;
    @Nullable
    private String mapUrl;
    @Nullable
    private String phoneIcon;
    @Nullable
    private String position;
    @Nullable
    private String positionIcon;
    @Nullable
    private String shopName;
    @Nullable
    private String shopStatus;
    @Nullable
    private ArrayList<String> telList;

    @JSONField(deserialize = false, serialize = false)
    @NotNull
    public final ArrayList<BottomAction> getCallActionList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1371797559")) {
            return (ArrayList) ipChange.ipc$dispatch("1371797559", new Object[]{this});
        }
        ArrayList<BottomAction> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = this.telList;
        if (arrayList2 != null) {
            for (T t : arrayList2) {
                arrayList.add(new BottomAction(t, t));
            }
        }
        return arrayList;
    }

    @Nullable
    public final String getDistance() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1350538598")) {
            return this.distance;
        }
        return (String) ipChange.ipc$dispatch("1350538598", new Object[]{this});
    }

    @Nullable
    public final String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2128634868")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("-2128634868", new Object[]{this});
    }

    @Nullable
    public final String getLatitude() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1572613027")) {
            return this.latitude;
        }
        return (String) ipChange.ipc$dispatch("-1572613027", new Object[]{this});
    }

    @Nullable
    public final String getLongitude() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1731105132")) {
            return this.longitude;
        }
        return (String) ipChange.ipc$dispatch("-1731105132", new Object[]{this});
    }

    @Nullable
    public final String getMapUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1955722652")) {
            return this.mapUrl;
        }
        return (String) ipChange.ipc$dispatch("-1955722652", new Object[]{this});
    }

    @Nullable
    public final String getPhoneIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1959079956")) {
            return this.phoneIcon;
        }
        return (String) ipChange.ipc$dispatch("-1959079956", new Object[]{this});
    }

    @Nullable
    public final String getPosition() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1156186266")) {
            return this.position;
        }
        return (String) ipChange.ipc$dispatch("1156186266", new Object[]{this});
    }

    @Nullable
    public final String getPositionIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1736611021")) {
            return this.positionIcon;
        }
        return (String) ipChange.ipc$dispatch("-1736611021", new Object[]{this});
    }

    @Nullable
    public final String getShopName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-471967214")) {
            return this.shopName;
        }
        return (String) ipChange.ipc$dispatch("-471967214", new Object[]{this});
    }

    @Nullable
    public final String getShopStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1565812999")) {
            return this.shopStatus;
        }
        return (String) ipChange.ipc$dispatch("-1565812999", new Object[]{this});
    }

    @Nullable
    public final ArrayList<String> getTelList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1266372100")) {
            return this.telList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1266372100", new Object[]{this});
    }

    public final void setDistance(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-965304264")) {
            ipChange.ipc$dispatch("-965304264", new Object[]{this, str});
            return;
        }
        this.distance = str;
    }

    public final void setId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573147986")) {
            ipChange.ipc$dispatch("1573147986", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public final void setLatitude(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388691423")) {
            ipChange.ipc$dispatch("-1388691423", new Object[]{this, str});
            return;
        }
        this.latitude = str;
    }

    public final void setLongitude(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "205110882")) {
            ipChange.ipc$dispatch("205110882", new Object[]{this, str});
            return;
        }
        this.longitude = str;
    }

    public final void setMapUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892952070")) {
            ipChange.ipc$dispatch("-1892952070", new Object[]{this, str});
            return;
        }
        this.mapUrl = str;
    }

    public final void setPhoneIcon(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727825930")) {
            ipChange.ipc$dispatch("1727825930", new Object[]{this, str});
            return;
        }
        this.phoneIcon = str;
    }

    public final void setPosition(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599708036")) {
            ipChange.ipc$dispatch("1599708036", new Object[]{this, str});
            return;
        }
        this.position = str;
    }

    public final void setPositionIcon(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1897453045")) {
            ipChange.ipc$dispatch("-1897453045", new Object[]{this, str});
            return;
        }
        this.positionIcon = str;
    }

    public final void setShopName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628409588")) {
            ipChange.ipc$dispatch("-1628409588", new Object[]{this, str});
            return;
        }
        this.shopName = str;
    }

    public final void setShopStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "889521157")) {
            ipChange.ipc$dispatch("889521157", new Object[]{this, str});
            return;
        }
        this.shopStatus = str;
    }

    public final void setTelList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-492191428")) {
            ipChange.ipc$dispatch("-492191428", new Object[]{this, arrayList});
            return;
        }
        this.telList = arrayList;
    }
}
