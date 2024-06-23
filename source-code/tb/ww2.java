package tb;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class ww2 {
    private static VrParamsProvider a;

    /* compiled from: Taobao */
    public static class a {
        public final ContentProviderClient a;
        public final String b;

        a(ContentProviderClient contentProviderClient, String str) {
            this.a = contentProviderClient;
            this.b = str;
        }
    }

    public static VrParamsProvider a(Context context) {
        VrParamsProvider vrParamsProvider = a;
        if (vrParamsProvider != null) {
            return vrParamsProvider;
        }
        a d = d(context);
        if (d != null) {
            return new b(d.a, d.b);
        }
        return new d71();
    }

    private static List<String> b(Context context) {
        List<ResolveInfo> queryIntentContentProviders;
        if (Build.VERSION.SDK_INT < 19 || (queryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent(xw2.PROVIDER_INTENT_ACTION), 0)) == null || queryIntentContentProviders.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentContentProviders) {
            ProviderInfo providerInfo = resolveInfo.providerInfo;
            if (nn1.a(providerInfo.packageName)) {
                arrayList.add(providerInfo.authority);
            }
        }
        return arrayList;
    }

    public static boolean c(Context context) {
        VrParamsProvider vrParamsProvider = a;
        if (vrParamsProvider != null && (vrParamsProvider instanceof b)) {
            return true;
        }
        List<String> b = b(context);
        if (b == null || b.isEmpty()) {
            return false;
        }
        return true;
    }

    public static a d(Context context) {
        List<String> b = b(context);
        if (b == null) {
            return null;
        }
        for (String str : b) {
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(str);
            if (acquireContentProviderClient != null) {
                return new a(acquireContentProviderClient, str);
            }
        }
        return null;
    }
}
