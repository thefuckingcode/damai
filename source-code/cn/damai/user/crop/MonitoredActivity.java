package cn.damai.user.crop;

import android.app.Activity;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
public abstract class MonitoredActivity extends Activity {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ArrayList<LifeCycleListener> a = new ArrayList<>();

    /* compiled from: Taobao */
    public interface LifeCycleListener {
        void onActivityCreated(MonitoredActivity monitoredActivity);

        void onActivityDestroyed(MonitoredActivity monitoredActivity);

        void onActivityStarted(MonitoredActivity monitoredActivity);

        void onActivityStopped(MonitoredActivity monitoredActivity);
    }

    /* compiled from: Taobao */
    public static class a implements LifeCycleListener {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.user.crop.MonitoredActivity.LifeCycleListener
        public void onActivityCreated(MonitoredActivity monitoredActivity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "913435097")) {
                ipChange.ipc$dispatch("913435097", new Object[]{this, monitoredActivity});
            }
        }

        @Override // cn.damai.user.crop.MonitoredActivity.LifeCycleListener
        public void onActivityDestroyed(MonitoredActivity monitoredActivity) {
            throw null;
        }

        @Override // cn.damai.user.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStarted(MonitoredActivity monitoredActivity) {
            throw null;
        }

        @Override // cn.damai.user.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStopped(MonitoredActivity monitoredActivity) {
            throw null;
        }
    }

    MonitoredActivity() {
    }

    public void a(LifeCycleListener lifeCycleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-737641139")) {
            ipChange.ipc$dispatch("-737641139", new Object[]{this, lifeCycleListener});
        } else if (!this.a.contains(lifeCycleListener)) {
            this.a.add(lifeCycleListener);
        }
    }

    public void b(LifeCycleListener lifeCycleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1288491252")) {
            ipChange.ipc$dispatch("-1288491252", new Object[]{this, lifeCycleListener});
            return;
        }
        this.a.remove(lifeCycleListener);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1448994744")) {
            ipChange.ipc$dispatch("-1448994744", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Iterator<LifeCycleListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onActivityCreated(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1662194568")) {
            ipChange.ipc$dispatch("1662194568", new Object[]{this});
            return;
        }
        super.onDestroy();
        Iterator<LifeCycleListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onActivityDestroyed(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337793184")) {
            ipChange.ipc$dispatch("-1337793184", new Object[]{this});
            return;
        }
        super.onStart();
        Iterator<LifeCycleListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onActivityStarted(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-445999866")) {
            ipChange.ipc$dispatch("-445999866", new Object[]{this});
            return;
        }
        super.onStop();
        Iterator<LifeCycleListener> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().onActivityStopped(this);
        }
    }
}
