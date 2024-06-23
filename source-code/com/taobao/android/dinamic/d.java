package com.taobao.android.dinamic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.view.CompatibleView;
import tb.g80;
import tb.r70;
import tb.x70;

/* compiled from: Taobao */
public class d extends LayoutInflater {
    private x70 a;

    protected d(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
    }

    private CompatibleView a(String str, String str2) {
        Context context = getContext();
        return new CompatibleView(context, str2 + str);
    }

    public static d b(Context context, x70 x70) {
        d dVar = new d(LayoutInflater.from(context), context);
        dVar.c(x70);
        return dVar;
    }

    public void c(x70 x70) {
        this.a = x70;
    }

    public LayoutInflater cloneInContext(Context context) {
        return LayoutInflater.from(context);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.LayoutInflater
    public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        if (b.d(str) != null) {
            try {
                return g80.b(str, getContext(), attributeSet, this.a);
            } catch (Throwable th) {
                this.a.e().b().a(r70.ERROR_CODE_VIEW_EXCEPTION, str);
                DinamicLog.c("DinamicInflater", th, "onCreateView failed");
                return a(r70.ERROR_CODE_VIEW_EXCEPTION, str);
            }
        } else {
            this.a.e().b().a(r70.ERROR_CODE_VIEW_NOT_FOUND, str);
            return a(r70.ERROR_CODE_VIEW_NOT_FOUND, str);
        }
    }
}
