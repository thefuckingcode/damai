package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
/* compiled from: Taobao */
public class FragmentManagerNonConfig {
    @Nullable
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
    @Nullable
    private final Collection<Fragment> mFragments;
    @Nullable
    private final Map<String, ViewModelStore> mViewModelStores;

    FragmentManagerNonConfig(@Nullable Collection<Fragment> collection, @Nullable Map<String, FragmentManagerNonConfig> map, @Nullable Map<String, ViewModelStore> map2) {
        this.mFragments = collection;
        this.mChildNonConfigs = map;
        this.mViewModelStores = map2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    /* access modifiers changed from: package-private */
    public boolean isRetaining(Fragment fragment) {
        Collection<Fragment> collection = this.mFragments;
        if (collection == null) {
            return false;
        }
        return collection.contains(fragment);
    }
}
