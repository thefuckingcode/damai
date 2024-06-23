package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.event.OnTaskFinishedListener;
import com.alibaba.android.onescheduler.group.Group;
import com.alibaba.android.onescheduler.group.ITaskTools;
import com.alibaba.android.onescheduler.scheduler.SimpleScheduler;
import com.alibaba.android.onescheduler.task.InnerOneTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/* compiled from: Taobao */
public class kj2 {
    @NonNull
    private Map<FutureTask, InnerOneTask> a;
    private jt0 b;

    /* compiled from: Taobao */
    class a implements OnTaskFinishedListener {
        a() {
        }

        @Override // com.alibaba.android.onescheduler.event.OnTaskFinishedListener
        public void onFinished(FutureTask futureTask) {
            InnerOneTask innerOneTask = (InnerOneTask) kj2.this.a.remove(futureTask);
            if (innerOneTask != null) {
                String groupName = innerOneTask.getGroupName();
                if (TextUtils.isEmpty(groupName)) {
                    bl1.a("Doraemon thread Group name is null !!!");
                    return;
                }
                Group d = kj2.this.b.d(groupName);
                if (d != null) {
                    d.removeFinishedTask(innerOneTask);
                }
            }
        }
    }

    /* compiled from: Taobao */
    class b implements ITaskTools {
        b() {
        }

        @Override // com.alibaba.android.onescheduler.group.ITaskTools
        @NonNull
        public OneCommonTask convert(FutureTask futureTask) {
            return (OneCommonTask) kj2.this.a.get(futureTask);
        }

        @Override // com.alibaba.android.onescheduler.group.ITaskTools
        @Nullable
        public List<String> getTaskNames(TaskType taskType) {
            return kj2.this.g(taskType);
        }
    }

    /* compiled from: Taobao */
    private static class c {
        private static final kj2 a = new kj2(null);
    }

    /* synthetic */ kj2(a aVar) {
        this();
    }

    @NonNull
    public static kj2 f() {
        return c.a;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @Nullable
    private List<String> g(@Nullable TaskType taskType) {
        if (taskType == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = new ArrayList(this.a.values()).iterator();
        while (it.hasNext()) {
            InnerOneTask innerOneTask = (InnerOneTask) it.next();
            if (taskType == innerOneTask.getTaskType()) {
                arrayList.add(innerOneTask.getName());
            }
        }
        return arrayList;
    }

    public void d(@NonNull InnerOneTask innerOneTask) {
        String groupName = innerOneTask.getGroupName();
        if (TextUtils.isEmpty(groupName)) {
            bl1.a("Doraemon thread Group name is null !!!");
        }
        this.a.remove(innerOneTask.getFutureTask());
        Group d = this.b.d(groupName);
        if (d != null) {
            d.removeCanceledTask(innerOneTask);
        }
    }

    public jt0 e() {
        return this.b;
    }

    public void h(@NonNull InnerOneTask innerOneTask) {
        String groupName = innerOneTask.getGroupName();
        if (TextUtils.isEmpty(groupName)) {
            bl1.a("Doraemon thread Group name is null !!!");
            return;
        }
        Group d = this.b.d(groupName);
        if (d == null) {
            bl1.a("Group is null !!!");
            return;
        }
        this.a.put(innerOneTask.getFutureTask(), innerOneTask);
        d.addTask(innerOneTask);
    }

    private kj2() {
        this.a = new ConcurrentHashMap();
        this.b = new jt0(new SimpleScheduler());
        ve0.a().j(new a());
        ve0.a().k(new b());
    }
}
