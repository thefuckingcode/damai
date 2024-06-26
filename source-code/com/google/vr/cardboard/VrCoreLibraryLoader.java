package com.google.vr.cardboard;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.ndk.base.Version;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.library.api.IVrNativeLibraryLoader;
import com.google.vr.vrcore.library.api.ObjectWrapper;
import com.google.vr.vrcore.library.api.a;

@UsedByNative
/* compiled from: Taobao */
public class VrCoreLibraryLoader {
    private static void a(Context context, Version version) throws VrCoreNotAvailableException {
        String d = VrCoreUtils.d(context);
        Version parse = Version.parse(d);
        if (parse == null) {
            Log.i("VrCoreLibraryLoader", "VrCore version does not support library loading.");
            throw new VrCoreNotAvailableException(4);
        } else if (!parse.isAtLeast(version)) {
            Log.w("VrCoreLibraryLoader", String.format("VrCore GVR library version obsolete; VrCore supports %s but client min is %s", d, version.toString()));
            throw new VrCoreNotAvailableException(4);
        }
    }

    @UsedByNative
    public static long loadNativeDlsymMethod(Context context) {
        if (Build.VERSION.SDK_INT > 22) {
            return 0;
        }
        try {
            if (VrCoreUtils.getVrCoreClientApiVersion(context) < 14) {
                return 0;
            }
            IVrNativeLibraryLoader newNativeLibraryLoader = a.c(context).newNativeLibraryLoader(ObjectWrapper.wrap(a.a(context)), ObjectWrapper.wrap(context));
            if (newNativeLibraryLoader != null) {
                return newNativeLibraryLoader.loadNativeDlsymMethod();
            }
            Log.e("VrCoreLibraryLoader", "Failed to load native dlsym handle from VrCore: no library loader available.");
            return 0;
        } catch (RemoteException | VrCoreNotAvailableException | IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 50);
            sb.append("Failed to load native dlsym handle from VrCore:\n  ");
            sb.append(valueOf);
            Log.e("VrCoreLibraryLoader", sb.toString());
            return 0;
        }
    }

    @UsedByNative
    public static long loadNativeGvrLibrary(Context context) {
        return loadNativeGvrLibrary(context, Version.MIN, Version.CURRENT);
    }

    @UsedByNative
    public static long loadNativeGvrLibrary(Context context, Version version, Version version2) {
        try {
            a(context, version);
            Context a = a.a(context);
            int b = a.b(context);
            IVrNativeLibraryLoader newNativeLibraryLoader = a.c(context).newNativeLibraryLoader(ObjectWrapper.wrap(a), ObjectWrapper.wrap(context));
            if (newNativeLibraryLoader == null) {
                Log.e("VrCoreLibraryLoader", "Failed to load native GVR library from VrCore: no library loader available.");
                return 0;
            } else if (b < 19) {
                return newNativeLibraryLoader.loadNativeGvrLibrary(version2.majorVersion, version2.minorVersion, version2.patchVersion);
            } else {
                return newNativeLibraryLoader.loadNativeGvrLibraryWithMinVersion(version.toString(), version2.toString());
            }
        } catch (RemoteException | VrCoreNotAvailableException | IllegalArgumentException | IllegalStateException | SecurityException | UnsatisfiedLinkError e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 49);
            sb.append("Failed to load native GVR library from VrCore:\n  ");
            sb.append(valueOf);
            Log.e("VrCoreLibraryLoader", sb.toString());
            return 0;
        }
    }
}
