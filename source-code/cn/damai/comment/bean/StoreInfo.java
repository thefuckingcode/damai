package cn.damai.comment.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.lk1;
import tb.m40;

/* compiled from: Taobao */
public final class StoreInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private String des = "";
    @Nullable
    private Long playerCount;
    @Nullable
    private String priceDesc;
    @Nullable
    private String storeId;
    @Nullable
    private String storeImgUrl;
    @Nullable
    private String storeName;

    /* compiled from: Taobao */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }

        @JvmStatic
        @Nullable
        public final String geCountText(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1987265622")) {
                return lk1.g(lk1.k(str, 0));
            }
            return (String) ipChange.ipc$dispatch("-1987265622", new Object[]{this, str});
        }
    }

    @JvmStatic
    @Nullable
    public static final String geCountText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "373707554")) {
            return Companion.geCountText(str);
        }
        return (String) ipChange.ipc$dispatch("373707554", new Object[]{str});
    }

    @NotNull
    public final String getDes() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1158269308")) {
            return (String) ipChange.ipc$dispatch("-1158269308", new Object[]{this});
        }
        Long l = this.playerCount;
        String str = this.priceDesc;
        if (!(l == null || l.longValue() == 0)) {
            if (!(str == null || str.length() == 0)) {
                return Companion.geCountText(l.toString()) + "人去玩过 | " + str;
            }
        }
        if (l == null || l.longValue() == 0) {
            if (str == null || str.length() == 0) {
                z = true;
            }
            return !z ? str : "";
        }
        return Companion.geCountText(l.toString()) + "人去玩过";
    }

    @Nullable
    public final Long getPlayerCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1338243947")) {
            return this.playerCount;
        }
        return (Long) ipChange.ipc$dispatch("-1338243947", new Object[]{this});
    }

    @Nullable
    public final String getPriceDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1793862828")) {
            return this.priceDesc;
        }
        return (String) ipChange.ipc$dispatch("1793862828", new Object[]{this});
    }

    @Nullable
    public final String getStoreId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "30608334")) {
            return this.storeId;
        }
        return (String) ipChange.ipc$dispatch("30608334", new Object[]{this});
    }

    @Nullable
    public final String getStoreImgUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-263187745")) {
            return this.storeImgUrl;
        }
        return (String) ipChange.ipc$dispatch("-263187745", new Object[]{this});
    }

    @Nullable
    public final String getStoreName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-579279042")) {
            return this.storeName;
        }
        return (String) ipChange.ipc$dispatch("-579279042", new Object[]{this});
    }

    public final void setDes(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-128062094")) {
            ipChange.ipc$dispatch("-128062094", new Object[]{this, str});
            return;
        }
        k21.i(str, "<set-?>");
        this.des = str;
    }

    public final void setPlayerCount(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791178443")) {
            ipChange.ipc$dispatch("791178443", new Object[]{this, l});
            return;
        }
        this.playerCount = l;
    }

    public final void setPriceDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2104935242")) {
            ipChange.ipc$dispatch("2104935242", new Object[]{this, str});
            return;
        }
        this.priceDesc = str;
    }

    public final void setStoreId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-667395224")) {
            ipChange.ipc$dispatch("-667395224", new Object[]{this, str});
            return;
        }
        this.storeId = str;
    }

    public final void setStoreImgUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868836745")) {
            ipChange.ipc$dispatch("-1868836745", new Object[]{this, str});
            return;
        }
        this.storeImgUrl = str;
    }

    public final void setStoreName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1551981304")) {
            ipChange.ipc$dispatch("1551981304", new Object[]{this, str});
            return;
        }
        this.storeName = str;
    }
}
