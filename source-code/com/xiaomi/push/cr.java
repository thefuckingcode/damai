package com.xiaomi.push;

import android.text.TextUtils;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.weex.annotation.JSMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class cr {
    private double a = 0.1d;

    /* renamed from: a  reason: collision with other field name */
    private long f172a;

    /* renamed from: a  reason: collision with other field name */
    public String f173a = "";

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<da> f174a = new ArrayList<>();
    private long b = 86400000;

    /* renamed from: b  reason: collision with other field name */
    public String f175b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private String i;
    private String j = "s.mi1.cc";

    public cr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f172a = System.currentTimeMillis();
            this.f174a.add(new da(str, -1));
            this.f173a = cv.m338a();
            this.f175b = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private synchronized void c(String str) {
        Iterator<da> it = this.f174a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f191a, str)) {
                it.remove();
            }
        }
    }

    public synchronized cr a(JSONObject jSONObject) {
        this.f173a = jSONObject.optString("net");
        this.b = jSONObject.getLong(RemoteMessageConst.TTL);
        this.a = jSONObject.getDouble("pct");
        this.f172a = jSONObject.getLong("ts");
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString(IRequestConst.ISP);
        this.f = jSONObject.optString(TbAuthConstants.IP);
        this.f175b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(new da().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        } else if (TextUtils.isEmpty(this.e)) {
            return "hardcode_isp";
        } else {
            String a2 = bp.a(new String[]{this.e, this.c, this.d, this.g, this.f}, JSMethod.NOT_SET);
            this.i = a2;
            return a2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m329a() {
        return a(false);
    }

    public ArrayList<String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f175b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    ct a2 = ct.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a2.m337a(), a2.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        int size = this.f174a.size();
        da[] daVarArr = new da[size];
        this.f174a.toArray(daVarArr);
        Arrays.sort(daVarArr);
        arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < size; i2++) {
            da daVar = daVarArr[i2];
            if (z) {
                substring = daVar.f191a;
            } else {
                int indexOf = daVar.f191a.indexOf(":");
                substring = indexOf != -1 ? daVar.f191a.substring(0, indexOf) : daVar.f191a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m330a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f173a);
        jSONObject.put(RemoteMessageConst.TTL, this.b);
        jSONObject.put("pct", this.a);
        jSONObject.put("ts", this.f172a);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put(IRequestConst.ISP, this.e);
        jSONObject.put(TbAuthConstants.IP, this.f);
        jSONObject.put("host", this.f175b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<da> it = this.f174a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d2) {
        this.a = d2;
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.b = j2;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j2);
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(da daVar) {
        c(daVar.f191a);
        this.f174a.add(daVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m331a(String str) {
        a(new da(str));
    }

    public void a(String str, int i2, long j2, long j3, Exception exc) {
        a(str, new cq(i2, j2, j3, exc));
    }

    public void a(String str, long j2, long j3) {
        try {
            b(new URL(str).getHost(), j2, j3);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j2, long j3, Exception exc) {
        try {
            b(new URL(str).getHost(), j2, j3, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public synchronized void a(String str, cq cqVar) {
        Iterator<da> it = this.f174a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            da next = it.next();
            if (TextUtils.equals(str, next.f191a)) {
                next.a(cqVar);
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        int i2;
        int size = this.f174a.size() - 1;
        while (true) {
            i2 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (TextUtils.equals(this.f174a.get(size).f191a, strArr[i2])) {
                    this.f174a.remove(size);
                    break;
                }
                i2++;
            }
            size--;
        }
        Iterator<da> it = this.f174a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i4 = it.next().a;
            if (i4 > i3) {
                i3 = i4;
            }
        }
        while (i2 < strArr.length) {
            a(new da(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m332a() {
        return TextUtils.equals(this.f173a, cv.m338a());
    }

    public boolean a(cr crVar) {
        return TextUtils.equals(this.f173a, crVar.f173a);
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(String str, long j2, long j3) {
        a(str, 0, j2, j3, null);
    }

    public void b(String str, long j2, long j3, Exception exc) {
        a(str, -1, j2, j3, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f172a < this.b;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        long j2 = this.b;
        if (864000000 >= j2) {
            j2 = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f172a;
        return currentTimeMillis - j3 > j2 || (currentTimeMillis - j3 > this.b && this.f173a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f173a);
        sb.append(StringUtils.LF);
        sb.append(a());
        Iterator<da> it = this.f174a.iterator();
        while (it.hasNext()) {
            sb.append(StringUtils.LF);
            sb.append(it.next().toString());
        }
        sb.append(StringUtils.LF);
        return sb.toString();
    }
}
