package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class UrlLauncher {
    @Nullable
    private Activity activity;
    private final Context applicationContext;

    /* compiled from: Taobao */
    enum LaunchStatus {
        OK,
        NO_ACTIVITY,
        ACTIVITY_NOT_FOUND
    }

    UrlLauncher(Context context, @Nullable Activity activity2) {
        this.applicationContext = context;
        this.activity = activity2;
    }

    /* access modifiers changed from: package-private */
    public boolean canLaunch(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        ComponentName resolveActivity = intent.resolveActivity(this.applicationContext.getPackageManager());
        return resolveActivity != null && !"{com.android.fallback/com.android.fallback.Fallback}".equals(resolveActivity.toShortString());
    }

    /* access modifiers changed from: package-private */
    public void closeWebView() {
        this.applicationContext.sendBroadcast(new Intent(WebViewActivity.ACTION_CLOSE));
    }

    /* access modifiers changed from: package-private */
    public LaunchStatus launch(String str, Bundle bundle, boolean z, boolean z2, boolean z3) {
        Intent intent;
        Activity activity2 = this.activity;
        if (activity2 == null) {
            return LaunchStatus.NO_ACTIVITY;
        }
        if (z) {
            intent = WebViewActivity.createIntent(activity2, str, z2, z3, bundle);
        } else {
            intent = new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", bundle);
        }
        try {
            this.activity.startActivity(intent);
            return LaunchStatus.OK;
        } catch (ActivityNotFoundException unused) {
            return LaunchStatus.ACTIVITY_NOT_FOUND;
        }
    }

    /* access modifiers changed from: package-private */
    public void setActivity(@Nullable Activity activity2) {
        this.activity = activity2;
    }
}
