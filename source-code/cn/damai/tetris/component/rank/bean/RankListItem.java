package cn.damai.tetris.component.rank.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class RankListItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String itemId;
    @Nullable
    private String name;
    private int offset;
    @Nullable
    private String pic;
    @Nullable
    private String price;
    @Nullable
    private String showTime;
    @Nullable
    private String venue;

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1224209003")) {
            return this.itemId;
        }
        return (String) ipChange.ipc$dispatch("-1224209003", new Object[]{this});
    }

    @Nullable
    public final String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1512850670")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-1512850670", new Object[]{this});
    }

    public final int getOffset() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1982597319")) {
            return this.offset;
        }
        return ((Integer) ipChange.ipc$dispatch("-1982597319", new Object[]{this})).intValue();
    }

    @Nullable
    public final String getPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1623555943")) {
            return this.pic;
        }
        return (String) ipChange.ipc$dispatch("-1623555943", new Object[]{this});
    }

    @Nullable
    public final String getPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "157395416")) {
            return this.price;
        }
        return (String) ipChange.ipc$dispatch("157395416", new Object[]{this});
    }

    @Nullable
    public final String getShowTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1204320369")) {
            return this.showTime;
        }
        return (String) ipChange.ipc$dispatch("1204320369", new Object[]{this});
    }

    @Nullable
    public final String getVenue() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1053709310")) {
            return this.venue;
        }
        return (String) ipChange.ipc$dispatch("1053709310", new Object[]{this});
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690865431")) {
            ipChange.ipc$dispatch("-690865431", new Object[]{this, str});
            return;
        }
        this.itemId = str;
    }

    public final void setName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "53512716")) {
            ipChange.ipc$dispatch("53512716", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public final void setOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-556813687")) {
            ipChange.ipc$dispatch("-556813687", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.offset = i;
    }

    public final void setPic(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1667045891")) {
            ipChange.ipc$dispatch("-1667045891", new Object[]{this, str});
            return;
        }
        this.pic = str;
    }

    public final void setPrice(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219309154")) {
            ipChange.ipc$dispatch("-1219309154", new Object[]{this, str});
            return;
        }
        this.price = str;
    }

    public final void setShowTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1203102067")) {
            ipChange.ipc$dispatch("-1203102067", new Object[]{this, str});
            return;
        }
        this.showTime = str;
    }

    public final void setVenue(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "796617784")) {
            ipChange.ipc$dispatch("796617784", new Object[]{this, str});
            return;
        }
        this.venue = str;
    }
}
