package me.ele.altriax.launcher.biz.impl.base;

import android.app.Application;
import androidx.annotation.NonNull;
import java.util.HashMap;

/* compiled from: Taobao */
public interface Task {
    void delegateInit(@NonNull Application application, @NonNull HashMap<String, Object> hashMap);
}
