package com.taobao.weex.devtools.common.android;

import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Taobao */
public interface FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT> {
    @Nullable
    List<FRAGMENT> getAddedFragments(FRAGMENT_MANAGER fragment_manager);
}
