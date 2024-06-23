package com.uc.sandboxExport;

import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.uc.sandboxExport.IChildProcessSetup;
import com.uc.sandboxExport.helper.c;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class i extends IChildProcessSetup.Stub {
    final /* synthetic */ SandboxedProcessService a;

    i(SandboxedProcessService sandboxedProcessService) {
        this.a = sandboxedProcessService;
    }

    @Override // com.uc.sandboxExport.IChildProcessSetup
    public final IBinder preSetupConnection(Bundle bundle) {
        ParcelFileDescriptor[] parcelFileDescriptorArr;
        if (this.a.l.getExtras() == null) {
            c.a(4, this.a.c, "preSetupConnection, mLastIntent has not extras", null);
            this.a.l.putExtras(bundle);
            this.a.a();
        }
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("dex.fd");
        Parcelable[] parcelableArray = bundle.getParcelableArray("lib.fd");
        ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) bundle.getParcelable("crash.fd");
        c.a(this.a.c, "preSetupConnection, dex fd: %s", parcelFileDescriptor);
        if (parcelableArray != null) {
            parcelFileDescriptorArr = new ParcelFileDescriptor[parcelableArray.length];
            System.arraycopy(parcelableArray, 0, parcelFileDescriptorArr, 0, parcelableArray.length);
        } else {
            parcelFileDescriptorArr = null;
        }
        try {
            this.a.init(parcelFileDescriptor, parcelFileDescriptorArr, parcelFileDescriptor2);
            c.a(4, this.a.c, "preSetupConnection done.", null);
            return this.a.j;
        } catch (Throwable th) {
            c.a(this.a.c, "preSetupConnection.init exception", th);
            throw th;
        }
    }
}
