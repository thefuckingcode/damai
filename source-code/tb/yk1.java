package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.OneSchedulerExceptionHandler;
import com.alibaba.android.onescheduler.TaskTracker;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.group.Group;

/* compiled from: Taobao */
public class yk1 {
    public static final String DEFAULT_GROUP = "default_group";
    private jt0 a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final yk1 a = new yk1();
    }

    public static void d(Runnable runnable) {
        g().h().setTaskName(runnable.toString()).setTaskGroup("default_group").setRunnable(runnable).buildCommonTask().run();
    }

    public static void e(Runnable runnable, TaskType taskType) {
        g().h().setTaskName(runnable.toString()).setTaskGroup("default_group").setRunnable(runnable).setTaskType(taskType).buildCommonTask().run();
    }

    public static yk1 g() {
        return b.a;
    }

    public void a(String str, int i) {
        if (!TextUtils.isEmpty(str) && i > 0) {
            this.a.a(str, i);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.b(str);
        }
    }

    public String c() {
        return this.a.c();
    }

    public Group f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.a.d(str);
    }

    public com.alibaba.android.onescheduler.task.a h() {
        return new com.alibaba.android.onescheduler.task.a();
    }

    public void i(@Nullable String str) {
        if (str != null) {
            this.a.e(str);
        }
    }

    public void j(@Nullable OneSchedulerExceptionHandler oneSchedulerExceptionHandler) {
        if (oneSchedulerExceptionHandler != null) {
            ve0.a().h(oneSchedulerExceptionHandler);
        }
    }

    public void k(@Nullable TaskTracker taskTracker) {
        if (taskTracker != null) {
            ve0.a().i(taskTracker);
        }
    }

    public void l(@Nullable String str) {
        if (str != null) {
            this.a.f(str);
        }
    }

    private yk1() {
        jt0 e = kj2.f().e();
        this.a = e;
        e.a("default_group", 10);
    }
}
