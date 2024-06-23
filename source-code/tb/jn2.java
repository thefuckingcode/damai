package tb;

import android.content.Context;
import com.alibaba.android.ultron.trade.event.rollback.RollbackHandler;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class jn2 {
    private Context a;
    private String b;
    private String c;
    private IDMComponent d;
    private IPresenter e;
    private Object f;
    private Map<String, Object> g = new HashMap();
    private RollbackHandler h;

    jn2() {
    }

    public IDMComponent a() {
        return this.d;
    }

    public Context b() {
        return this.a;
    }

    public <T> T c() {
        try {
            return (T) this.f;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String d() {
        return this.b;
    }

    public <T> T e(String str) {
        if (str == null) {
            return null;
        }
        return (T) this.g.get(str);
    }

    public IPresenter f() {
        return this.e;
    }

    public String g() {
        return this.c;
    }

    public void h() {
        RollbackHandler rollbackHandler = this.h;
        if (rollbackHandler != null) {
            rollbackHandler.rollback();
        }
    }

    public jn2 i(IDMComponent iDMComponent) {
        this.d = iDMComponent;
        return this;
    }

    /* access modifiers changed from: package-private */
    public jn2 j(Context context) {
        this.a = context;
        return this;
    }

    public jn2 k(Object obj) {
        this.f = obj;
        return this;
    }

    public jn2 l(String str) {
        this.b = str;
        return this;
    }

    public jn2 m(String str, Object obj) {
        if (str != null) {
            this.g.put(str, obj);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public jn2 n(IPresenter iPresenter) {
        this.e = iPresenter;
        return this;
    }

    public void o(RollbackHandler rollbackHandler) {
        this.h = rollbackHandler;
    }

    public jn2 p(String str) {
        this.c = str;
        return this;
    }
}
