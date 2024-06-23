package com.taobao.android.launcher.schedulers;

import com.taobao.android.job.core.DAGSchedulerConfig;
import com.taobao.android.launcher.DefaultOnDemandReceiver;
import com.taobao.android.launcher.LaunchScheduler;
import com.taobao.android.launcher.common.OnDemandReceiver;
import com.taobao.android.launcher.config.Configuration;

/* compiled from: Taobao */
public class EmptyScheduler extends LaunchScheduler {

    /* compiled from: Taobao */
    private static class Lazy {
        private static final OnDemandReceiver receiver = new DefaultOnDemandReceiver();

        private Lazy() {
        }
    }

    public EmptyScheduler(Configuration configuration) {
        super(configuration);
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    public OnDemandReceiver asReceiver() {
        return Lazy.receiver;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.launcher.LaunchScheduler
    public DAGSchedulerConfig<String, Void> createConfig() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.android.launcher.LaunchScheduler
    public DAGSchedulerConfig<String, Void> createDemandConfig() {
        return null;
    }

    @Override // com.taobao.android.launcher.LaunchScheduler
    public void schedule() {
    }
}
