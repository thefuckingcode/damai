package com.taobao.android.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import com.taobao.android.compat.ActionBarActivityCompat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

/* compiled from: Taobao */
public class PanguActivity extends ActionBarActivityCompat {
    private final List<IndividualActivityLifecycleCallback> mIndividualActivityLifecycleCallbacks = new CopyOnWriteArrayList();

    /* compiled from: Taobao */
    public interface IndividualActivityLifecycleCallback {
        void onCreated(Activity activity);

        void onDestroyed(Activity activity);

        void onPaused(Activity activity);

        void onResumed(Activity activity);

        void onStarted(Activity activity);

        void onStopped(Activity activity);
    }

    public PanguApplication getPanguApplication() {
        return (PanguApplication) getApplication();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.taobao.android.lifecycle.PanguActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.taobao.android.compat.ActionBarActivityCompat
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!this.mIndividualActivityLifecycleCallbacks.isEmpty()) {
            for (IndividualActivityLifecycleCallback individualActivityLifecycleCallback : this.mIndividualActivityLifecycleCallbacks) {
                individualActivityLifecycleCallback.onCreated(this);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.taobao.android.lifecycle.PanguActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.taobao.android.compat.ActionBarActivityCompat
    public void onDestroy() {
        if (!this.mIndividualActivityLifecycleCallbacks.isEmpty()) {
            for (IndividualActivityLifecycleCallback individualActivityLifecycleCallback : this.mIndividualActivityLifecycleCallbacks) {
                individualActivityLifecycleCallback.onDestroyed(this);
            }
        }
        super.onDestroy();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.taobao.android.lifecycle.PanguActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.taobao.android.compat.ActionBarActivityCompat
    public void onPause() {
        if (!this.mIndividualActivityLifecycleCallbacks.isEmpty()) {
            for (IndividualActivityLifecycleCallback individualActivityLifecycleCallback : this.mIndividualActivityLifecycleCallbacks) {
                individualActivityLifecycleCallback.onPaused(this);
            }
        }
        super.onPause();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.taobao.android.lifecycle.PanguActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.taobao.android.compat.ActionBarActivityCompat
    public void onResume() {
        super.onResume();
        if (!this.mIndividualActivityLifecycleCallbacks.isEmpty()) {
            for (IndividualActivityLifecycleCallback individualActivityLifecycleCallback : this.mIndividualActivityLifecycleCallbacks) {
                individualActivityLifecycleCallback.onResumed(this);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.taobao.android.lifecycle.PanguActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.taobao.android.compat.ActionBarActivityCompat
    public void onStart() {
        super.onStart();
        if (!this.mIndividualActivityLifecycleCallbacks.isEmpty()) {
            for (IndividualActivityLifecycleCallback individualActivityLifecycleCallback : this.mIndividualActivityLifecycleCallbacks) {
                individualActivityLifecycleCallback.onStarted(this);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.taobao.android.lifecycle.PanguActivity */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.taobao.android.compat.ActionBarActivityCompat
    public void onStop() {
        if (!this.mIndividualActivityLifecycleCallbacks.isEmpty()) {
            for (IndividualActivityLifecycleCallback individualActivityLifecycleCallback : this.mIndividualActivityLifecycleCallbacks) {
                individualActivityLifecycleCallback.onStopped(this);
            }
        }
        super.onStop();
    }

    public void registerIndividualActivityLifecycleCallback(IndividualActivityLifecycleCallback individualActivityLifecycleCallback) {
        this.mIndividualActivityLifecycleCallbacks.add(individualActivityLifecycleCallback);
    }

    public void unregisterIndividualActivityLifecycleCallback(IndividualActivityLifecycleCallback individualActivityLifecycleCallback) {
        this.mIndividualActivityLifecycleCallbacks.remove(individualActivityLifecycleCallback);
    }
}
