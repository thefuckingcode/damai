package cn.damai.tetris.component.drama.bean;

import androidx.annotation.NonNull;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.s41;

/* compiled from: Taobao */
public class CategoryItemListInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PAGE_SIZE = 15;
    private static final long serialVersionUID = 2566111111706503L;
    public int currentCitySize;
    public boolean findComponent;
    public int nearByCitySize;
    public String targetLayerId;
    public String targetSectionId;
    public int total;

    public CategoryItemListInfo() {
    }

    public static CategoryItemListInfo defaultItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "70651612") ? (CategoryItemListInfo) ipChange.ipc$dispatch("70651612", new Object[0]) : new CategoryItemListInfo(0, 0, 0, false);
    }

    @NonNull
    public static CategoryItemListInfo obtainFromSection(ISection iSection, CategoryItemListInfo categoryItemListInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456548045")) {
            return (CategoryItemListInfo) ipChange.ipc$dispatch("456548045", new Object[]{iSection, categoryItemListInfo});
        }
        CategoryItemListInfo categoryItemListInfo2 = null;
        if (iSection != null) {
            try {
                if (iSection.getItem() != null) {
                    categoryItemListInfo2 = (CategoryItemListInfo) s41.d(iSection.getItem().getJSONObject("itemInfo"), CategoryItemListInfo.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return categoryItemListInfo2 == null ? categoryItemListInfo : categoryItemListInfo2;
    }

    public int getCurAndNearCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "731495453")) {
            return this.currentCitySize + this.nearByCitySize;
        }
        return ((Integer) ipChange.ipc$dispatch("731495453", new Object[]{this})).intValue();
    }

    public boolean hasListSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1525509233")) {
            return getCurAndNearCount() > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1525509233", new Object[]{this})).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r6.nearByCitySize >= 15) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r6.nearByCitySize >= 15) goto L_0x0041;
     */
    public boolean isCanRequestNextPage(boolean z, int i) {
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-1018720148")) {
            return ((Boolean) ipChange.ipc$dispatch("-1018720148", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)})).booleanValue();
        } else if (!this.findComponent) {
            return false;
        } else {
            if (z) {
                if (i > 1 || this.currentCitySize > 3) {
                    return true;
                }
            }
            z2 = true;
            return z2;
        }
    }

    public boolean isCurrentCityEnd(int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722915972")) {
            return ((Boolean) ipChange.ipc$dispatch("722915972", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        if (this.findComponent && (i2 = this.currentCitySize) > 0 && i + i2 < this.total) {
            return false;
        }
        return true;
    }

    public CategoryItemListInfo(int i, int i2, int i3, boolean z) {
        this.total = i;
        this.currentCitySize = i2;
        this.nearByCitySize = i3;
        this.findComponent = z;
    }
}
