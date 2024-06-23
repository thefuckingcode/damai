package tb;

import android.text.TextUtils;
import com.alibaba.android.umbrella.performance.ProcessEntity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class zs1 {
    public static final int INIT_SIZE = 5;
    private static zs1 b;
    private HashMap<String, ProcessEntity> a;

    private zs1(int i) {
        this.a = new HashMap<>(i);
    }

    public static zs1 b() {
        if (b == null) {
            b = new zs1(5);
        }
        return b;
    }

    public void a(ProcessEntity processEntity) {
        if (processEntity != null && !TextUtils.isEmpty(processEntity.bizName)) {
            if (this.a.containsKey(processEntity.bizName)) {
                this.a.remove(processEntity);
            }
            this.a.put(processEntity.bizName, processEntity);
        }
    }

    public ProcessEntity c(String str) {
        HashMap<String, ProcessEntity> hashMap;
        if (TextUtils.isEmpty(str) || (hashMap = this.a) == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.a.get(str);
    }

    public Map<String, ProcessEntity> d() {
        return this.a;
    }

    public boolean e(String str) {
        HashMap<String, ProcessEntity> hashMap;
        return !TextUtils.isEmpty(str) && (hashMap = this.a) != null && hashMap.containsKey(str);
    }

    public void f(ProcessEntity processEntity) {
        if (processEntity != null && !TextUtils.isEmpty(processEntity.bizName) && this.a.containsKey(processEntity.bizName)) {
            this.a.remove(processEntity.bizName);
        }
    }
}
