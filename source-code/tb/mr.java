package tb;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.IDMRequester;
import com.taobao.android.ultron.datamodel.imp.DMRequester;
import java.util.Map;

/* compiled from: Taobao */
public class mr {
    public static final String NAMESPACE = "trade_debug";
    String a;
    String b;
    boolean c = true;
    boolean d = true;
    String e;
    String f;
    int g;
    boolean h = true;
    boolean i = false;
    Map<String, String> j;
    Map<String, String> k;
    String l = "default";
    IDMContext m;
    boolean n = false;
    boolean o = false;
    IDMComponent p;
    Class<?> q;
    boolean r = true;
    Context s;
    SharedPreferences t;

    public mr(Context context) {
        this.s = context;
        if (t30.a(context)) {
            this.t = this.s.getSharedPreferences(NAMESPACE, 0);
        }
    }

    private boolean g() {
        String str;
        String str2 = this.a;
        if (str2 == null || str2.length() <= 0 || (str = this.b) == null || str.length() <= 0) {
            return false;
        }
        return true;
    }

    public boolean A() {
        return this.i;
    }

    public mr B(boolean z) {
        this.d = z;
        return this;
    }

    public mr C(boolean z) {
        this.c = z;
        return this;
    }

    public mr D(Map<String, String> map) {
        this.j = map;
        return this;
    }

    public mr E(boolean z) {
        this.h = z;
        return this;
    }

    public mr F(Map<String, String> map) {
        this.k = map;
        return this;
    }

    public mr G(String str) {
        this.f = str;
        return this;
    }

    public mr H(boolean z) {
        this.i = z;
        return this;
    }

    public mr I(String str) {
        this.b = str;
        return this;
    }

    public mr a(String str) {
        this.a = str;
        return this;
    }

    public mr b(int i2) {
        this.g = i2;
        return this;
    }

    public IDMRequester c() {
        if (!g()) {
            return null;
        }
        return new DMRequester(this);
    }

    public IDMRequester d(IDMComponent iDMComponent, IDMContext iDMContext) {
        if (!g() || iDMContext == null) {
            return null;
        }
        this.p = iDMComponent;
        this.n = true;
        this.m = iDMContext;
        return new DMRequester(this);
    }

    public IDMRequester e(IDMContext iDMContext) {
        if (!g() || iDMContext == null) {
            return null;
        }
        this.m = iDMContext;
        return new DMRequester(this);
    }

    public IDMRequester f(Class<?> cls, IDMContext iDMContext) {
        if (!g() || iDMContext == null) {
            return null;
        }
        this.o = true;
        this.q = cls;
        this.m = iDMContext;
        return new DMRequester(this);
    }

    public mr h(String str) {
        this.e = str;
        return this;
    }

    public String i() {
        if (!t30.a(this.s)) {
            return this.a;
        }
        SharedPreferences sharedPreferences = this.t;
        String str = this.a;
        return sharedPreferences.getString(str, str);
    }

    public int j() {
        return this.g;
    }

    public String k() {
        return this.l;
    }

    public Context l() {
        return this.s;
    }

    public IDMContext m() {
        return this.m;
    }

    public String n() {
        return this.e;
    }

    public Map<String, String> o() {
        return this.k;
    }

    public Map<String, String> p() {
        return this.j;
    }

    public Class<?> q() {
        return this.q;
    }

    public IDMComponent r() {
        return this.p;
    }

    public String s() {
        return this.f;
    }

    public String t() {
        if (!t30.a(this.s)) {
            return this.b;
        }
        SharedPreferences sharedPreferences = this.t;
        return sharedPreferences.getString(this.a + ".version", this.b);
    }

    public boolean u() {
        return this.n;
    }

    public boolean v() {
        return this.r;
    }

    public boolean w() {
        return this.d;
    }

    public boolean x() {
        return this.c;
    }

    public boolean y() {
        return this.h;
    }

    public boolean z() {
        return this.o;
    }
}
