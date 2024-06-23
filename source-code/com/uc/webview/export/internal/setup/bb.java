package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.ValueCallback;
import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.uc.startup.b;
import com.uc.webview.export.internal.utility.p;

/* compiled from: Taobao */
public final class bb extends ax {

    /* compiled from: Taobao */
    class a extends bu {
        final ValueCallback<Object> a = new bc(this);

        public a(UCSubSetupTask uCSubSetupTask, bt btVar) {
            super(uCSubSetupTask, btVar);
        }

        /* access modifiers changed from: protected */
        @Override // com.uc.webview.export.internal.setup.bu
        public final boolean a() {
            b.a(298);
            Context context = (Context) this.f.getOption("CONTEXT");
            boolean z = !p.b((Boolean) bb.this.mOptions.get(UCCore.OPTION_USE_SDK_SETUP));
            if (z) {
                int i = ae.d.b;
                ae.b bVar = ae.b.CHECK_VERSION;
                ae a2 = ae.a();
                a2.getClass();
                a(i, bVar, new ae.a(new bd(this, context), this.a), this.a);
            }
            int i2 = ae.d.b;
            ae.b bVar2 = ae.b.CHECK_OLD_KERNEL;
            ae a3 = ae.a();
            a3.getClass();
            a(i2, bVar2, new ae.a(new be(this, context, z), this.a), this.a);
            b.a(299);
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // com.uc.webview.export.internal.setup.bu
        public final void b() {
            b.a(300);
            Context context = (Context) this.f.getOption("CONTEXT");
            Integer num = (Integer) this.f.getOption(UCCore.OPTION_VERIFY_POLICY);
            b.a(302);
            b.a(303);
            if (!(num == null || (num.intValue() & 8) == 0)) {
                int i = ae.d.b;
                ae.b bVar = ae.b.CHECK_SO;
                ae a2 = ae.a();
                a2.getClass();
                a(i, bVar, new ae.a(new bf(this, context, num), this.a), this.a);
            }
            b.a(304);
            if (!(num == null || (num.intValue() & 32) == 0)) {
                int i2 = ae.d.b;
                ae.b bVar2 = ae.b.CHECK_PAK;
                ae a3 = ae.a();
                a3.getClass();
                a(i2, bVar2, new ae.a(new bg(this, context, num), this.a), this.a);
            }
            b.a(301);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.uc.webview.export.internal.setup.ax
    public final bu a(bt btVar) {
        return new a(this, btVar);
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public final void run() {
        b.a(279);
        if (!af.b() || getUCM() == null) {
            a(p.a((Context) this.mOptions.get("CONTEXT"), this.mOptions));
        } else {
            b(getUCM());
        }
        b.a(ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE);
    }

    /* access modifiers changed from: protected */
    @Override // com.uc.webview.export.internal.setup.ax
    public final void a(String str, Object obj) {
        if (!p.a(str) && obj != null) {
            try {
                if (!((Boolean) ((UCCore.Callable) obj).call(str)).booleanValue()) {
                    throw new UCSetupException(4031, "inject failed.");
                }
            } catch (Exception e) {
                throw new UCSetupException(4031, e);
            }
        }
    }
}
