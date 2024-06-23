package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public abstract class gn {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected static final String f428a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f429a;
    private static String b = null;
    private static String c = (gy.a(5) + "-");

    /* renamed from: a  reason: collision with other field name */
    private gr f430a = null;

    /* renamed from: a  reason: collision with other field name */
    private List<gk> f431a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, Object> f432a = new HashMap();
    private String d = b;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f429a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public gn() {
    }

    public gn(Bundle bundle) {
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f431a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                gk a2 = gk.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f431a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f430a = new gr(bundle2);
        }
    }

    public static synchronized String i() {
        String sb;
        synchronized (gn.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c);
            long j = a;
            a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String q() {
        return f428a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("ext_ns", this.d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_to", this.f);
        }
        if (!TextUtils.isEmpty(this.e)) {
            bundle.putString("ext_pkt_id", this.e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        gr grVar = this.f430a;
        if (grVar != null) {
            bundle.putBundle("ext_ERROR", grVar.a());
        }
        List<gk> list = this.f431a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            for (gk gkVar : this.f431a) {
                Bundle a2 = gkVar.a();
                if (a2 != null) {
                    bundleArr[i2] = a2;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public gk a(String str) {
        return a(str, null);
    }

    public gk a(String str, String str2) {
        for (gk gkVar : this.f431a) {
            if ((str2 == null || str2.equals(gkVar.b())) && str.equals(gkVar.m516a())) {
                return gkVar;
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public gr m521a() {
        return this.f430a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m522a(String str) {
        Map<String, Object> map = this.f432a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m523a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<gk> m524a() {
        if (this.f431a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f431a));
    }

    public void a(gk gkVar) {
        this.f431a.add(gkVar);
    }

    public void a(gr grVar) {
        this.f430a = grVar;
    }

    public synchronized Collection<String> b() {
        if (this.f432a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f432a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gn gnVar = (gn) obj;
        gr grVar = this.f430a;
        if (grVar == null ? gnVar.f430a != null : !grVar.equals(gnVar.f430a)) {
            return false;
        }
        String str = this.g;
        if (str == null ? gnVar.g != null : !str.equals(gnVar.g)) {
            return false;
        }
        if (!this.f431a.equals(gnVar.f431a)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? gnVar.e != null : !str2.equals(gnVar.e)) {
            return false;
        }
        String str3 = this.h;
        if (str3 == null ? gnVar.h != null : !str3.equals(gnVar.h)) {
            return false;
        }
        Map<String, Object> map = this.f432a;
        if (map == null ? gnVar.f432a != null : !map.equals(gnVar.f432a)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? gnVar.f != null : !str4.equals(gnVar.f)) {
            return false;
        }
        String str5 = this.d;
        String str6 = gnVar.d;
        if (str5 != null) {
            return str5.equals(str6);
        }
        if (str6 == null) {
            return true;
        }
    }

    public int hashCode() {
        String str = this.d;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f431a.hashCode()) * 31) + this.f432a.hashCode()) * 31;
        gr grVar = this.f430a;
        if (grVar != null) {
            i2 = grVar.hashCode();
        }
        return hashCode5 + i2;
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.e)) {
            return null;
        }
        if (this.e == null) {
            this.e = i();
        }
        return this.e;
    }

    public String k() {
        return this.h;
    }

    public void k(String str) {
        this.e = str;
    }

    public String l() {
        return this.f;
    }

    public void l(String str) {
        this.h = str;
    }

    public String m() {
        return this.g;
    }

    public void m(String str) {
        this.f = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.g = str;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ef */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0106 A[SYNTHETIC, Splitter:B:55:0x0106] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0119 A[SYNTHETIC, Splitter:B:64:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0120 A[SYNTHETIC, Splitter:B:68:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x010e A[SYNTHETIC] */
    public synchronized String o() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Exception e2;
        Exception e3;
        String str;
        sb = new StringBuilder();
        for (gk gkVar : m524a()) {
            sb.append(gkVar.d());
        }
        Map<String, Object> map = this.f432a;
        if (map != null && !map.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String str2 : b()) {
                Object a2 = m522a(str2);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(gy.a(str2));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (a2 instanceof Integer) {
                    sb.append("integer\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof Long) {
                    sb.append("long\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof Float) {
                    sb.append("float\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof Double) {
                    sb.append("double\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof Boolean) {
                    sb.append("boolean\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof String) {
                    sb.append("string\">");
                    sb.append(gy.a((String) a2));
                    str = "</value>";
                } else {
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        } catch (Exception e4) {
                            e3 = e4;
                            objectOutputStream = null;
                            e2 = e3;
                            try {
                                e2.printStackTrace();
                                if (objectOutputStream != null) {
                                }
                                if (byteArrayOutputStream == null) {
                                }
                                byteArrayOutputStream.close();
                                sb.append("</property>");
                            } catch (Throwable th2) {
                                th = th2;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (objectOutputStream2 != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            throw th;
                        }
                        try {
                            objectOutputStream.writeObject(a2);
                            sb.append("java-object\">");
                            sb.append(gy.a(byteArrayOutputStream.toByteArray()));
                            sb.append("</value>");
                            objectOutputStream.close();
                        } catch (Exception e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            if (objectOutputStream != null) {
                            }
                            if (byteArrayOutputStream == null) {
                            }
                            byteArrayOutputStream.close();
                            sb.append("</property>");
                        }
                    } catch (Exception e6) {
                        e3 = e6;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                        e2 = e3;
                        e2.printStackTrace();
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (byteArrayOutputStream == null) {
                            sb.append("</property>");
                        }
                        byteArrayOutputStream.close();
                        sb.append("</property>");
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream = null;
                        if (objectOutputStream2 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused4) {
                    }
                    sb.append("</property>");
                }
                sb.append(str);
                sb.append("</property>");
            }
            sb.append("</properties>");
        }
        return sb.toString();
    }

    public void o(String str) {
        this.i = str;
    }

    public String p() {
        return this.d;
    }
}
