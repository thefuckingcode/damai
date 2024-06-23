package cn.damai.projectfiltercopy.bean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
public class CategoryInitResult implements Serializable {
    public CategoryLevelTwo mInitSelectTwo;
    @NonNull
    public HashMap<String, CategoryLevelOne> mOneMap = new HashMap<>();
    @Nullable
    public CategoryLevelTwo mResetSelectTwo;
    @Nullable
    public CategoryLevelTwo mTwoAll;
}
