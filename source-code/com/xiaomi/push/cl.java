package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cj;

/* compiled from: Taobao */
class cl implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cj.a f168a;

    cl(cj.a aVar, Context context) {
        this.f168a = aVar;
        this.a = context;
    }

    public void run() {
        Exception e;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = this.f168a.a();
            if (a2 != null && a2.isOpen()) {
                a2.beginTransaction();
                this.f168a.a(this.a, a2);
                a2.setTransactionSuccessful();
            }
            if (a2 != null) {
                try {
                    a2.endTransaction();
                } catch (Exception e2) {
                    e = e2;
                    b.a(e);
                    this.f168a.a(this.a);
                }
            }
            ch chVar = this.f168a.f159a;
            if (chVar != null) {
                chVar.close();
            }
        } catch (Exception e3) {
            b.a(e3);
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    e = e4;
                    b.a(e);
                    this.f168a.a(this.a);
                }
            }
            ch chVar2 = this.f168a.f159a;
            if (chVar2 != null) {
                chVar2.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e5) {
                    b.a(e5);
                    this.f168a.a(this.a);
                    throw th;
                }
            }
            ch chVar3 = this.f168a.f159a;
            if (chVar3 != null) {
                chVar3.close();
            }
            this.f168a.a(this.a);
            throw th;
        }
        this.f168a.a(this.a);
    }
}
