package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.s.bt;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.ArrayList;

/* compiled from: Taobao */
public final class bb implements IInputtipsSearch {
    private Context a;
    private Inputtips.InputtipsListener b;
    private Handler c;
    private InputtipsQuery d;

    public bb(Context context, Inputtips.InputtipsListener inputtipsListener) throws AMapException {
        bu a2 = bt.a(context, h.a(false));
        if (a2.a == bt.c.SuccessCode) {
            this.a = context.getApplicationContext();
            this.b = inputtipsListener;
            this.c = t.a();
            return;
        }
        String str = a2.b;
        throw new AMapException(str, 1, str, a2.a.a());
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final InputtipsQuery getQuery() {
        return this.d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final ArrayList<Tip> requestInputtips() throws AMapException {
        return a(this.d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        try {
            ao.a().a(new Runnable() {
                /* class com.amap.api.col.s.bb.AnonymousClass1 */

                public final void run() {
                    Message obtainMessage = t.a().obtainMessage();
                    obtainMessage.obj = bb.this.b;
                    obtainMessage.arg1 = 5;
                    try {
                        bb bbVar = bb.this;
                        ArrayList<? extends Parcelable> a2 = bbVar.a((bb) bbVar.d);
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("result", a2);
                        obtainMessage.setData(bundle);
                        obtainMessage.what = 1000;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        bb.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    bb.this.c.sendMessage(obtainMessage);
                }
            });
        } catch (Throwable th) {
            i.a(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(InputtipsQuery inputtipsQuery) {
        this.d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ArrayList<Tip> a(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            r.a(this.a);
            if (inputtipsQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (inputtipsQuery.getKeyword() != null && !inputtipsQuery.getKeyword().equals("")) {
                return (ArrayList) new p(this.a, inputtipsQuery).b();
            } else {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
        } catch (Throwable th) {
            i.a(th, "Inputtips", "requestInputtips");
            if (!(th instanceof AMapException)) {
                return null;
            }
            throw th;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str == null || str.equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
        this.d = inputtipsQuery;
        inputtipsQuery.setType(str3);
        requestInputtipsAsyn();
    }

    public bb(Context context, InputtipsQuery inputtipsQuery) {
        this.a = context.getApplicationContext();
        this.d = inputtipsQuery;
        this.c = t.a();
    }
}
