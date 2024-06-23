package com.alibaba.aliweex.bundle;

import android.content.Context;
import android.view.View;
import com.alibaba.aliweex.bundle.WeexPageContract;
import tb.hx2;

/* compiled from: Taobao */
public class a implements WeexPageContract.IErrorView {
    private hx2 a;
    private WeexPageContract.IRenderPresenter b;

    /* renamed from: com.alibaba.aliweex.bundle.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class View$OnClickListenerC0073a implements View.OnClickListener {
        View$OnClickListenerC0073a() {
        }

        public void onClick(View view) {
            if (a.this.b != null) {
                a.this.b.reload();
            }
            a.this.showErrorView(false, null);
        }
    }

    public a(WeexPageContract.IRenderPresenter iRenderPresenter) {
        this.b = iRenderPresenter;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IErrorView
    public void createErrorView(Context context, View view) {
        if (this.a == null && view != null) {
            hx2 hx2 = new hx2(context, view);
            this.a = hx2;
            hx2.d();
            this.a.f(new View$OnClickListenerC0073a());
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IErrorView
    public void destroy() {
        hx2 hx2 = this.a;
        if (hx2 != null) {
            hx2.b();
        }
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IErrorView
    public void showErrorView(boolean z, String str) {
        hx2 hx2 = this.a;
        if (hx2 == null) {
            return;
        }
        if (z) {
            hx2.g(str);
        } else {
            hx2.d();
        }
    }
}
