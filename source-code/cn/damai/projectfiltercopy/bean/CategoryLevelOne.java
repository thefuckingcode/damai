package cn.damai.projectfiltercopy.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.e92;
import tb.rk1;

/* compiled from: Taobao */
public class CategoryLevelOne implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<CategoryLevelTwo> lineItemList;
    public String name;
    public int pos;
    public boolean select;
    public String tag;
    public String value;

    public static CategoryInitResult init(List<CategoryLevelOne> list, PresetBean presetBean) {
        CategoryLevelOne categoryLevelOne;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "942257321")) {
            return (CategoryInitResult) ipChange.ipc$dispatch("942257321", new Object[]{list, presetBean});
        }
        CategoryInitResult categoryInitResult = new CategoryInitResult();
        if (e92.f(list)) {
            int size = list.size();
            CategoryLevelTwo categoryLevelTwo = null;
            CategoryLevelTwo categoryLevelTwo2 = null;
            for (int i = 0; i < size; i++) {
                CategoryLevelOne categoryLevelOne2 = list.get(i);
                categoryLevelOne2.setChildrenPid();
                categoryInitResult.mOneMap.put(categoryLevelOne2.value, categoryLevelOne2);
                List<CategoryLevelTwo> list2 = categoryLevelOne2.lineItemList;
                if (e92.f(list2)) {
                    int size2 = list2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        CategoryLevelTwo categoryLevelTwo3 = list2.get(i2);
                        if (categoryLevelOne2.isAll() && categoryLevelTwo3.isAll()) {
                            categoryInitResult.mTwoAll = categoryLevelTwo3;
                        }
                        if (presetBean != null && !TextUtils.isEmpty(presetBean.secondLevelSelection) && TextUtils.equals(categoryLevelTwo3.value, presetBean.secondLevelSelection)) {
                            categoryLevelTwo2 = categoryLevelTwo3;
                        }
                    }
                }
            }
            if (presetBean != null && !TextUtils.isEmpty(presetBean.firstLevelSelection) && (categoryLevelOne = categoryInitResult.mOneMap.get(presetBean.firstLevelSelection)) != null && e92.f(categoryLevelOne.lineItemList)) {
                categoryInitResult.mInitSelectTwo = categoryLevelOne.lineItemList.get(0);
            }
            if (categoryInitResult.mInitSelectTwo == null) {
                categoryInitResult.mInitSelectTwo = categoryLevelTwo2;
            }
            if (categoryInitResult.mInitSelectTwo == null) {
                categoryInitResult.mInitSelectTwo = categoryInitResult.mTwoAll;
            }
            categoryInitResult.mResetSelectTwo = categoryInitResult.mTwoAll;
            try {
                categoryLevelTwo = list.get(0).lineItemList.get(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (categoryInitResult.mResetSelectTwo == null) {
                categoryInitResult.mResetSelectTwo = categoryLevelTwo;
            }
            if (categoryInitResult.mInitSelectTwo == null) {
                categoryInitResult.mInitSelectTwo = categoryLevelTwo;
            }
        }
        return categoryInitResult;
    }

    public CategoryLevelOne cloneWithoutChild() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343880223")) {
            return (CategoryLevelOne) ipChange.ipc$dispatch("-343880223", new Object[]{this});
        }
        CategoryLevelOne categoryLevelOne = new CategoryLevelOne();
        categoryLevelOne.value = this.value;
        categoryLevelOne.name = this.name;
        categoryLevelOne.select = this.select;
        categoryLevelOne.tag = this.tag;
        return categoryLevelOne;
    }

    public int countOrSelectUpdate(CategoryLevelTwo categoryLevelTwo, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502866332")) {
            return ((Integer) ipChange.ipc$dispatch("-502866332", new Object[]{this, categoryLevelTwo, Boolean.valueOf(z), Boolean.valueOf(z2)})).intValue();
        } else if (e92.d(this.lineItemList)) {
            return 0;
        } else {
            if (z) {
                ArrayList<CategoryLevelTwo> arrayList = new ArrayList(this.lineItemList.size());
                int i = 0;
                for (CategoryLevelTwo categoryLevelTwo2 : this.lineItemList) {
                    if (categoryLevelTwo2.select) {
                        i++;
                    }
                    arrayList.add((CategoryLevelTwo) categoryLevelTwo2.clone());
                }
                for (CategoryLevelTwo categoryLevelTwo3 : arrayList) {
                    if (categoryLevelTwo.isAll()) {
                        categoryLevelTwo3.select = categoryLevelTwo3.isAll();
                    } else {
                        if (categoryLevelTwo3.isAll()) {
                            categoryLevelTwo3.select = false;
                        }
                        if (categoryLevelTwo3.equals(categoryLevelTwo)) {
                            categoryLevelTwo3.select = true;
                        }
                    }
                }
                int i2 = 0;
                for (CategoryLevelTwo categoryLevelTwo4 : arrayList) {
                    if (categoryLevelTwo4.select) {
                        i2++;
                    }
                }
                if (!z2) {
                    int size = this.lineItemList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        this.lineItemList.get(i3).select = ((CategoryLevelTwo) arrayList.get(i3)).select;
                    }
                }
                return i2 - i;
            }
            int indexOf = this.lineItemList.indexOf(categoryLevelTwo);
            if (indexOf < 0) {
                return 0;
            }
            if (!z2) {
                this.lineItemList.get(indexOf).select = false;
            }
            return -1;
        }
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "103702673")) {
            return ((Boolean) ipChange.ipc$dispatch("103702673", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CategoryLevelOne categoryLevelOne = (CategoryLevelOne) obj;
            if (!rk1.a(this.value, categoryLevelOne.value) || !rk1.a(this.name, categoryLevelOne.name)) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1173907896")) {
            return ((Integer) ipChange.ipc$dispatch("-1173907896", new Object[]{this})).intValue();
        }
        return rk1.b(this.value, this.name);
    }

    public boolean isAll() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-830543609")) {
            return TextUtils.isEmpty(this.value);
        }
        return ((Boolean) ipChange.ipc$dispatch("-830543609", new Object[]{this})).booleanValue();
    }

    public void setChildrenPid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198403962")) {
            ipChange.ipc$dispatch("-1198403962", new Object[]{this});
        } else if (!e92.d(this.lineItemList)) {
            for (CategoryLevelTwo categoryLevelTwo : this.lineItemList) {
                categoryLevelTwo.parentValue = this.value;
            }
        }
    }

    public void updateTag() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-69442999")) {
            ipChange.ipc$dispatch("-69442999", new Object[]{this});
            return;
        }
        CategoryLevelTwo categoryLevelTwo = null;
        this.tag = null;
        if (!TextUtils.isEmpty(this.value) && !e92.d(this.lineItemList)) {
            for (CategoryLevelTwo categoryLevelTwo2 : this.lineItemList) {
                if (categoryLevelTwo2.select) {
                    i++;
                    categoryLevelTwo = categoryLevelTwo2;
                }
            }
            if (i <= 0) {
                return;
            }
            if (categoryLevelTwo.isAll()) {
                this.tag = "全部";
            } else {
                this.tag = String.valueOf(i);
            }
        }
    }
}
