package cn.damai.projectfiltercopy.model;

import cn.damai.projectfiltercopy.bean.CategoryInitResult;
import cn.damai.projectfiltercopy.bean.CategoryLevelOne;
import cn.damai.projectfiltercopy.bean.CategoryLevelTwo;
import cn.damai.projectfiltercopy.bean.PresetBean;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.yc;

/* compiled from: Taobao */
public final class CategoryDataAssembler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int MAX_SELECT_COUNT = 10;
    @Nullable
    private List<CategoryLevelOne> mCategoryList;
    @Nullable
    private CategoryLevelTwo mInitSelectTwo;
    @Nullable
    private OnCategoryUpdateListener mListener;
    @NotNull
    private final HashMap<String, CategoryLevelOne> mPid2LevelOneMap = new HashMap<>();
    @Nullable
    private CategoryLevelTwo mResetSelectTwo;
    @NotNull
    private final HashSet<CategoryLevelTwo> mSelectTwosUsed4UiSet = new HashSet<>();
    @NotNull
    private final ArrayList<CategoryLevelOne> mSelectUsed4RequestList = new ArrayList<>();
    @Nullable
    private CategoryLevelTwo mTwoAll;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    public static /* synthetic */ void doReset$default(CategoryDataAssembler categoryDataAssembler, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        categoryDataAssembler.doReset(z);
    }

    public static /* synthetic */ void selectOne$default(CategoryDataAssembler categoryDataAssembler, CategoryLevelOne categoryLevelOne, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        categoryDataAssembler.selectOne(categoryLevelOne, z);
    }

    public static /* synthetic */ boolean selectTwo$default(CategoryDataAssembler categoryDataAssembler, CategoryLevelTwo categoryLevelTwo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return categoryDataAssembler.selectTwo(categoryLevelTwo, z);
    }

    public final void doConfirm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "196768338")) {
            ipChange.ipc$dispatch("196768338", new Object[]{this});
            return;
        }
        this.mSelectUsed4RequestList.clear();
        for (T t : this.mSelectTwosUsed4UiSet) {
            CategoryLevelOne categoryLevelOne = this.mPid2LevelOneMap.get(t.parentValue);
            if (categoryLevelOne != null) {
                int indexOf = this.mSelectUsed4RequestList.indexOf(categoryLevelOne);
                if (indexOf >= 0) {
                    List<CategoryLevelTwo> list = this.mSelectUsed4RequestList.get(indexOf).lineItemList;
                    if (list != null) {
                        list.add(t);
                    }
                } else {
                    CategoryLevelOne cloneWithoutChild = categoryLevelOne.cloneWithoutChild();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(t);
                    cloneWithoutChild.lineItemList = arrayList;
                    this.mSelectUsed4RequestList.add(cloneWithoutChild);
                }
            }
        }
    }

    public final void doMatchIfNeed() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-673589734")) {
            ipChange.ipc$dispatch("-673589734", new Object[]{this});
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : this.mSelectUsed4RequestList) {
            List<CategoryLevelTwo> list = t.lineItemList;
            if (!(list == null || list.isEmpty())) {
                arrayList.addAll(t.lineItemList);
            }
        }
        Iterator<T> it = this.mSelectTwosUsed4UiSet.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next());
        }
        if (arrayList.size() == arrayList2.size()) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!arrayList2.contains((CategoryLevelTwo) it2.next())) {
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            doReset(false);
            Iterator<T> it3 = this.mSelectUsed4RequestList.iterator();
            while (it3.hasNext()) {
                List<CategoryLevelTwo> list2 = it3.next().lineItemList;
                if (list2 != null) {
                    k21.h(list2, "lineItemList");
                    for (T t2 : list2) {
                        k21.h(t2, AdvanceSetting.NETWORK_TYPE);
                        selectTwo(t2, false);
                    }
                }
            }
            List<CategoryLevelOne> list3 = this.mCategoryList;
            if (list3 != null) {
                for (CategoryLevelOne categoryLevelOne : list3) {
                    if (this.mSelectUsed4RequestList.contains(categoryLevelOne)) {
                        selectOne$default(this, categoryLevelOne, false, 2, null);
                        return;
                    }
                }
            }
        }
    }

    public final void doReset(boolean z) {
        OnCategoryUpdateListener onCategoryUpdateListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353663343")) {
            ipChange.ipc$dispatch("-353663343", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        Iterator<T> it = this.mSelectTwosUsed4UiSet.iterator();
        while (it.hasNext()) {
            it.next().select = false;
        }
        this.mSelectTwosUsed4UiSet.clear();
        CategoryLevelTwo categoryLevelTwo = this.mResetSelectTwo;
        if (categoryLevelTwo != null) {
            selectTwo$default(this, categoryLevelTwo, false, 2, null);
        }
        if (z && (onCategoryUpdateListener = this.mListener) != null) {
            onCategoryUpdateListener.categoryUpdate(getUpdate());
        }
    }

    @NotNull
    public final String getBtnText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4033040")) {
            return (String) ipChange.ipc$dispatch("-4033040", new Object[]{this});
        }
        String str = "品类";
        if (this.mSelectUsed4RequestList.size() != 0) {
            try {
                str = yc.g(this.mCategoryList, this.mSelectUsed4RequestList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            k21.h(str, "{\n            try {\n    …\"\n            }\n        }");
        }
        return str;
    }

    @Nullable
    public final OnCategoryUpdateListener getMListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "730855173")) {
            return this.mListener;
        }
        return (OnCategoryUpdateListener) ipChange.ipc$dispatch("730855173", new Object[]{this});
    }

    @NotNull
    public final ArrayList<CategoryLevelOne> getSelect4Request() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1477399092")) {
            return this.mSelectUsed4RequestList;
        }
        return (ArrayList) ipChange.ipc$dispatch("1477399092", new Object[]{this});
    }

    @NotNull
    public final CategoryUpdate getUpdate() {
        List<CategoryLevelTwo> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1511039960")) {
            return (CategoryUpdate) ipChange.ipc$dispatch("-1511039960", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<CategoryLevelOne> list2 = this.mCategoryList;
        if (list2 != null) {
            for (CategoryLevelOne categoryLevelOne : list2) {
                categoryLevelOne.updateTag();
                arrayList.add(categoryLevelOne.cloneWithoutChild());
                if (categoryLevelOne.select && (list = categoryLevelOne.lineItemList) != null) {
                    k21.h(list, "lineItemList");
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        Object clone = it.next().clone();
                        k21.g(clone, "null cannot be cast to non-null type cn.damai.projectfiltercopy.bean.CategoryLevelTwo");
                        arrayList2.add((CategoryLevelTwo) clone);
                    }
                }
            }
        }
        return new CategoryUpdate(arrayList, arrayList2);
    }

    public final int indexOneSelect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956336730")) {
            return ((Integer) ipChange.ipc$dispatch("-1956336730", new Object[]{this})).intValue();
        }
        List<CategoryLevelOne> list = this.mCategoryList;
        if (list == null) {
            return 0;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).select) {
                return i;
            }
        }
        return 0;
    }

    public final void init(@Nullable List<CategoryLevelOne> list, @NotNull PresetBean presetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-30621751")) {
            ipChange.ipc$dispatch("-30621751", new Object[]{this, list, presetBean});
            return;
        }
        k21.i(presetBean, "presetBean");
        this.mCategoryList = list;
        CategoryInitResult init = CategoryLevelOne.init(list, presetBean);
        this.mTwoAll = init.mTwoAll;
        this.mResetSelectTwo = init.mResetSelectTwo;
        this.mInitSelectTwo = init.mInitSelectTwo;
        this.mPid2LevelOneMap.putAll(init.mOneMap);
        List<CategoryLevelOne> list2 = this.mCategoryList;
        if (list2 != null && list2.size() > 0) {
            selectOne$default(this, list2.get(0), false, 2, null);
            CategoryLevelTwo categoryLevelTwo = this.mInitSelectTwo;
            if (categoryLevelTwo != null) {
                selectTwo$default(this, categoryLevelTwo, false, 2, null);
            }
        }
        doConfirm();
    }

    public final void selectOne(@NotNull CategoryLevelOne categoryLevelOne, boolean z) {
        OnCategoryUpdateListener onCategoryUpdateListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683606659")) {
            ipChange.ipc$dispatch("683606659", new Object[]{this, categoryLevelOne, Boolean.valueOf(z)});
            return;
        }
        k21.i(categoryLevelOne, "oneClone");
        if (!categoryLevelOne.select) {
            List<CategoryLevelOne> list = this.mCategoryList;
            if (list != null) {
                for (T t : list) {
                    t.select = t.equals(categoryLevelOne);
                }
            }
            if (z && (onCategoryUpdateListener = this.mListener) != null) {
                onCategoryUpdateListener.categoryUpdate(getUpdate());
            }
        }
    }

    public final boolean selectTwo(@NotNull CategoryLevelTwo categoryLevelTwo, boolean z) {
        OnCategoryUpdateListener onCategoryUpdateListener;
        OnCategoryUpdateListener onCategoryUpdateListener2;
        CategoryLevelTwo categoryLevelTwo2;
        OnCategoryUpdateListener onCategoryUpdateListener3;
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-1522589997")) {
            return ((Boolean) ipChange.ipc$dispatch("-1522589997", new Object[]{this, categoryLevelTwo, Boolean.valueOf(z)})).booleanValue();
        }
        k21.i(categoryLevelTwo, "twoClone");
        List<CategoryLevelOne> list = this.mCategoryList;
        if (list == null || list.isEmpty()) {
            return false;
        }
        if (!categoryLevelTwo.isAllFilter()) {
            CategoryLevelOne categoryLevelOne = this.mPid2LevelOneMap.get(categoryLevelTwo.parentValue);
            if (categoryLevelOne == null) {
                return false;
            }
            if (categoryLevelTwo.select) {
                categoryLevelOne.countOrSelectUpdate(categoryLevelTwo, false, false);
                this.mSelectTwosUsed4UiSet.remove(categoryLevelTwo);
                if (this.mSelectTwosUsed4UiSet.size() == 0 && (categoryLevelTwo2 = this.mResetSelectTwo) != null) {
                    if (categoryLevelTwo2.isAllFilter()) {
                        categoryLevelTwo2.select = true;
                    } else {
                        selectTwo$default(this, categoryLevelTwo2, false, 2, null);
                    }
                }
                CategoryLevelTwo categoryLevelTwo3 = this.mTwoAll;
                if (categoryLevelTwo3 != null) {
                    if (this.mSelectTwosUsed4UiSet.size() == 0) {
                        z2 = true;
                    }
                    categoryLevelTwo3.select = z2;
                }
                if (z && (onCategoryUpdateListener2 = this.mListener) != null) {
                    onCategoryUpdateListener2.categoryUpdate(getUpdate());
                }
                return true;
            } else if (categoryLevelOne.countOrSelectUpdate(categoryLevelTwo, true, true) + this.mSelectTwosUsed4UiSet.size() > 10) {
                if (z) {
                    BricksToastUtil.INSTANCE.b("最多可选10个");
                }
                return false;
            } else {
                categoryLevelOne.countOrSelectUpdate(categoryLevelTwo, true, false);
                List<CategoryLevelTwo> list2 = categoryLevelOne.lineItemList;
                if (list2 != null) {
                    k21.h(list2, "lineItemList");
                    for (T t : list2) {
                        if (t.select) {
                            this.mSelectTwosUsed4UiSet.add(t);
                        } else {
                            this.mSelectTwosUsed4UiSet.remove(t);
                        }
                    }
                }
                CategoryLevelTwo categoryLevelTwo4 = this.mTwoAll;
                if (categoryLevelTwo4 != null) {
                    if (this.mSelectTwosUsed4UiSet.size() == 0) {
                        z2 = true;
                    }
                    categoryLevelTwo4.select = z2;
                }
                if (z && (onCategoryUpdateListener = this.mListener) != null) {
                    onCategoryUpdateListener.categoryUpdate(getUpdate());
                }
                return true;
            }
        } else if (categoryLevelTwo.select) {
            return false;
        } else {
            Iterator<T> it = this.mSelectTwosUsed4UiSet.iterator();
            while (it.hasNext()) {
                it.next().select = false;
            }
            this.mSelectTwosUsed4UiSet.clear();
            CategoryLevelOne categoryLevelOne2 = this.mPid2LevelOneMap.get(categoryLevelTwo.parentValue);
            if (categoryLevelOne2 != null) {
                categoryLevelOne2.countOrSelectUpdate(categoryLevelTwo, true, false);
            }
            if (z && (onCategoryUpdateListener3 = this.mListener) != null) {
                onCategoryUpdateListener3.categoryUpdate(getUpdate());
            }
            return true;
        }
    }

    public final void setMListener(@Nullable OnCategoryUpdateListener onCategoryUpdateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096273383")) {
            ipChange.ipc$dispatch("-1096273383", new Object[]{this, onCategoryUpdateListener});
            return;
        }
        this.mListener = onCategoryUpdateListener;
    }
}
