package cn.damai.projectfiltercopy.model;

import cn.damai.projectfiltercopy.bean.CategoryLevelOne;
import cn.damai.projectfiltercopy.bean.CategoryLevelTwo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class CategoryUpdate {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final List<CategoryLevelOne> cloneOneList;
    @Nullable
    private final List<CategoryLevelTwo> cloneTwoList;

    public CategoryUpdate(@Nullable List<CategoryLevelOne> list, @Nullable List<CategoryLevelTwo> list2) {
        this.cloneOneList = list;
        this.cloneTwoList = list2;
    }

    @Nullable
    public final List<CategoryLevelOne> getCloneOneList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1763196328")) {
            return this.cloneOneList;
        }
        return (List) ipChange.ipc$dispatch("1763196328", new Object[]{this});
    }

    @Nullable
    public final List<CategoryLevelTwo> getCloneTwoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1073233650")) {
            return this.cloneTwoList;
        }
        return (List) ipChange.ipc$dispatch("-1073233650", new Object[]{this});
    }
}
