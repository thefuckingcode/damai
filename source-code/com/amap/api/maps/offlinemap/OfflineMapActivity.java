package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.mapcore.util.fp;
import com.amap.api.mapcore.util.fq;
import com.amap.api.mapcore.util.fs;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;

/* compiled from: Taobao */
public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {
    private static int a;
    private a b;
    private fp c;
    private fp[] d = new fp[32];
    private int e = -1;
    private fq f;

    private void a(fp fpVar) {
        try {
            a aVar = this.b;
            if (aVar != null) {
                aVar.d();
                this.b = null;
            }
            a c2 = c(fpVar);
            this.b = c2;
            if (c2 != null) {
                this.c = fpVar;
                c2.a(this);
                this.b.a(this.c.b);
                this.b.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(fp fpVar) {
        try {
            a++;
            a(fpVar);
            int i = (this.e + 1) % 32;
            this.e = i;
            this.d[i] = fpVar;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a c(fp fpVar) {
        try {
            if (fpVar.a != 1) {
                return null;
            }
            if (this.f == null) {
                this.f = new fq();
            }
            return this.f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void closeScr() {
        try {
            if (!a((Bundle) null)) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.d();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onClick(View view) {
        try {
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            fs.a(getApplicationContext());
            this.e = -1;
            a = 0;
            b(new fp(1, null));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            super.onDestroy();
            a aVar = this.b;
            if (aVar != null) {
                aVar.d();
                this.b = null;
            }
            this.c = null;
            this.d = null;
            fq fqVar = this.f;
            if (fqVar != null) {
                fqVar.d();
                this.f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                a aVar = this.b;
                if (aVar != null && !aVar.b()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (a == 1) {
                        finish();
                    }
                    return false;
                }
                this.e = -1;
                a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            super.onPause();
            a aVar = this.b;
            if (aVar != null) {
                aVar.h();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.offlineservice.AMapPermissionActivity
    public void onResume() {
        try {
            super.onResume();
            a aVar = this.b;
            if (aVar != null) {
                aVar.f();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            super.onStart();
            a aVar = this.b;
            if (aVar != null) {
                aVar.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            super.onStop();
            a aVar = this.b;
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.b.c());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (!a(bundle)) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.d();
                }
                finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            int i = a;
            if ((i != 1 || this.b == null) && i > 1) {
                a = i - 1;
                int i2 = ((this.e - 1) + 32) % 32;
                this.e = i2;
                fp fpVar = this.d[i2];
                fpVar.b = bundle;
                a(fpVar);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
