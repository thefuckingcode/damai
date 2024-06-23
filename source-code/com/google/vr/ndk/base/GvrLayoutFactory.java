package com.google.vr.ndk.base;

import android.content.Context;
import android.util.Log;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.library.api.IGvrLayout;
import com.google.vr.vrcore.library.api.ObjectWrapper;
import com.google.vr.vrcore.library.api.a;
import tb.vw2;

/* compiled from: Taobao */
public class GvrLayoutFactory {
    public static IGvrLayout create(Context context) {
        IGvrLayout tryCreateFromVrCorePackage = tryCreateFromVrCorePackage(context);
        if (tryCreateFromVrCorePackage != null) {
            return tryCreateFromVrCorePackage;
        }
        IGvrLayout createFromCurrentPackage = createFromCurrentPackage(context);
        Log.d("GvrLayoutFactory", "Loaded GvrLayout from SDK.");
        return createFromCurrentPackage;
    }

    private static IGvrLayout createFromCurrentPackage(Context context) {
        return new GvrLayoutImplWrapper(new GvrLayoutImpl(context));
    }

    private static IGvrLayout tryCreateFromVrCorePackage(Context context) {
        if (VrCoreUtils.e(context.getPackageName())) {
            return createFromCurrentPackage(context);
        }
        if (context instanceof vw2) {
            throw new IllegalArgumentException("VrContextWrapper only supported within VrCore.");
        } else if (!GvrApi.usingDynamicLibrary(context)) {
            Log.v("GvrLayoutFactory", "Dynamic library loading disabled, using built-in GvrLayout implementation.");
            return null;
        } else {
            Boolean bool = SdkConfigurationReader.getParams(context).allowDynamicJavaLibraryLoading;
            if (bool == null || !bool.booleanValue()) {
                Log.v("GvrLayoutFactory", "Dynamic Java library loading disabled, using built-in GvrLayout implementation.");
                return null;
            }
            try {
                if (VrCoreUtils.getVrCoreClientApiVersion(context) < 17) {
                    Log.d("GvrLayoutFactory", "VrCore outdated, using built-in GvrLayout implementation.");
                    return null;
                }
                try {
                    IGvrLayout newGvrLayout = a.c(context).newGvrLayout(ObjectWrapper.wrap(a.a(context)), ObjectWrapper.wrap(context));
                    if (newGvrLayout != null) {
                        Log.i("GvrLayoutFactory", "Successfully loaded GvrLayout from VrCore.");
                    } else {
                        Log.w("GvrLayoutFactory", "GvrLayout creation from VrCore failed.");
                    }
                    return newGvrLayout;
                } catch (Exception e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 40);
                    sb.append("Failed to load GvrLayout from VrCore:\n  ");
                    sb.append(valueOf);
                    Log.e("GvrLayoutFactory", sb.toString());
                    return null;
                }
            } catch (VrCoreNotAvailableException unused) {
                Log.d("GvrLayoutFactory", "VrCore unavailable, using built-in GvrLayout implementation.");
                return null;
            }
        }
    }
}
