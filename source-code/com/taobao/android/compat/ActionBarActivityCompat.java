package com.taobao.android.compat;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.ActionBarActivity;
import javax.annotation.Nullable;

/* compiled from: Taobao */
public class ActionBarActivityCompat extends ActionBarActivity implements ActivityCompatJellyBean {
    private static final boolean COMPAT = (Build.VERSION.SDK_INT < 14);
    private boolean mDestroyed;

    private ApplicationCompat getApplicationCompat() {
        return (ApplicationCompat) getApplication();
    }

    @Override // com.taobao.android.compat.ActivityCompatJellyBean
    @TargetApi(17)
    public boolean isDestroyed() {
        if (Build.VERSION.SDK_INT < 17) {
            return this.mDestroyed;
        }
        try {
            return ActionBarActivityCompat.super.isDestroyed();
        } catch (Throwable unused) {
            return this.mDestroyed;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.taobao.android.compat.ActionBarActivityCompat */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        ActionBarActivityCompat.super.onCreate(bundle);
        if (COMPAT) {
            getApplicationCompat().dispatchActivityCreatedCompat(this, bundle);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.taobao.android.compat.ActionBarActivityCompat */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mDestroyed = true;
        ActionBarActivityCompat.super.onDestroy();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityDestroyedCompat(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.taobao.android.compat.ActionBarActivityCompat */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void onPause() {
        ActionBarActivityCompat.super.onPause();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityPausedCompat(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.taobao.android.compat.ActionBarActivityCompat */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void onResume() {
        ActionBarActivityCompat.super.onResume();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityResumedCompat(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.taobao.android.compat.ActionBarActivityCompat */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        ActionBarActivityCompat.super.onSaveInstanceState(bundle);
        if (COMPAT) {
            getApplicationCompat().dispatchActivitySaveInstanceStateCompat(this, bundle);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.taobao.android.compat.ActionBarActivityCompat */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void onStart() {
        ActionBarActivityCompat.super.onStart();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityStartedCompat(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.taobao.android.compat.ActionBarActivityCompat */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public void onStop() {
        ActionBarActivityCompat.super.onStop();
        if (COMPAT) {
            getApplicationCompat().dispatchActivityStoppedCompat(this);
        }
    }
}
