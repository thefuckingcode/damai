package com.loc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.taobao.downloader.adpater.Monitor;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.playerservice.axp.definition.FirstSliceCode;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;
import tb.i53;
import tb.jl1;

/* compiled from: Taobao */
public final class f1 {
    Hashtable<String, ArrayList<a>> a = new Hashtable<>();
    private long b = 0;
    private boolean c = false;
    private String d = "2.0.201501131131".replace(".", "");
    private String e = null;
    boolean f = true;
    long g = 0;
    String h = null;
    b1 i = null;
    private String j = null;
    private long k = 0;
    boolean l = true;
    boolean m = true;
    String n = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        private eo a = null;
        private String b = null;

        protected a() {
        }

        public final eo a() {
            return this.a;
        }

        public final void b(eo eoVar) {
            this.a = eoVar;
        }

        public final void c(String str) {
            this.b = TextUtils.isEmpty(str) ? null : str.replace("##", Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        }

        public final String d() {
            return this.b;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A[Catch:{ all -> 0x0094 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b A[Catch:{ all -> 0x0094 }] */
    private eo c(String str, StringBuilder sb, boolean z) {
        a aVar;
        eo a2;
        try {
            if (!str.contains("cgiwifi")) {
                if (!str.contains("wifi")) {
                    aVar = (!str.contains("cgi") || !this.a.containsKey(str) || this.a.get(str).size() <= 0) ? null : this.a.get(str).get(0);
                    if (aVar != null && m1.r(aVar.a())) {
                        a2 = aVar.a();
                        a2.e("mem");
                        a2.h(aVar.d());
                        if (!z) {
                            if (!i1.f(a2.getTime())) {
                                Hashtable<String, ArrayList<a>> hashtable = this.a;
                                if (hashtable != null && hashtable.containsKey(str)) {
                                    this.a.get(str).remove(aVar);
                                }
                            }
                        }
                        if (m1.r(a2)) {
                            this.g = 0;
                        }
                        a2.setLocationType(4);
                        return a2;
                    }
                    return null;
                }
            }
            aVar = d(sb, str);
            a2 = aVar.a();
            a2.e("mem");
            a2.h(aVar.d());
            if (!z) {
            }
            if (m1.r(a2)) {
            }
            a2.setLocationType(4);
            return a2;
        } catch (Throwable th) {
            j1.h(th, "Cache", "get1");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0068, code lost:
        r16 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0132, code lost:
        r3 = r16;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090 A[LOOP:1: B:19:0x0088->B:21:0x0090, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a8 A[LOOP:2: B:23:0x00a2->B:25:0x00a8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0068 A[EDGE_INSN: B:53:0x0068->B:15:0x0068 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f2 A[SYNTHETIC] */
    private a d(StringBuilder sb, String str) {
        a aVar;
        boolean z;
        double[] dArr;
        double[] dArr2;
        Iterator it;
        int i2;
        double[] s;
        String str2;
        if (this.a.isEmpty() || TextUtils.isEmpty(sb)) {
            return null;
        }
        if (!this.a.containsKey(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        ArrayList<a> arrayList = this.a.get(str);
        char c2 = 1;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                aVar = null;
                break;
            }
            a aVar2 = arrayList.get(size);
            if (!TextUtils.isEmpty(aVar2.d())) {
                if (q(aVar2.d(), sb)) {
                    if (m1.t(aVar2.d(), sb.toString())) {
                        break;
                    }
                    z = true;
                    n(aVar2.d(), hashtable);
                    n(sb.toString(), hashtable2);
                    hashtable3.clear();
                    for (String str3 : hashtable.keySet()) {
                        hashtable3.put(str3, "");
                    }
                    for (String str4 : hashtable2.keySet()) {
                        hashtable3.put(str4, "");
                    }
                    Set keySet = hashtable3.keySet();
                    dArr = new double[keySet.size()];
                    dArr2 = new double[keySet.size()];
                    it = keySet.iterator();
                    i2 = 0;
                    while (it != null && it.hasNext()) {
                        str2 = (String) it.next();
                        double d2 = 1.0d;
                        dArr[i2] = !hashtable.containsKey(str2) ? 1.0d : 0.0d;
                        if (hashtable2.containsKey(str2)) {
                            d2 = 0.0d;
                        }
                        dArr2[i2] = d2;
                        i2++;
                    }
                    keySet.clear();
                    s = s(dArr, dArr2);
                    if (s[0] < 0.800000011920929d) {
                        break;
                    }
                    a aVar3 = aVar2;
                    if (s[c2] < Math.min(i1.u(), 0.618d)) {
                        if (z && s[0] >= Math.min(i1.u(), 0.618d)) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    z = false;
                    n(aVar2.d(), hashtable);
                    n(sb.toString(), hashtable2);
                    hashtable3.clear();
                    while (r12.hasNext()) {
                    }
                    while (r12.hasNext()) {
                    }
                    Set keySet2 = hashtable3.keySet();
                    dArr = new double[keySet2.size()];
                    dArr2 = new double[keySet2.size()];
                    it = keySet2.iterator();
                    i2 = 0;
                    while (it != null) {
                        str2 = (String) it.next();
                        double d22 = 1.0d;
                        dArr[i2] = !hashtable.containsKey(str2) ? 1.0d : 0.0d;
                        if (hashtable2.containsKey(str2)) {
                        }
                        dArr2[i2] = d22;
                        i2++;
                    }
                    keySet2.clear();
                    s = s(dArr, dArr2);
                    if (s[0] < 0.800000011920929d) {
                    }
                }
            }
            size--;
            c2 = 1;
        }
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        return aVar;
    }

    private String e(String str, StringBuilder sb, Context context) {
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        this.e = m1.e0(context);
        if (str.contains("&")) {
            str = str.substring(0, str.indexOf("&"));
        }
        String substring = str.substring(str.lastIndexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + 1);
        if (substring.equals("cgi")) {
            jSONObject.put("cgi", str.substring(0, str.length() - 12));
        } else if (!TextUtils.isEmpty(sb) && sb.indexOf(",access") != -1) {
            jSONObject.put("cgi", str.substring(0, str.length() - (substring.length() + 9)));
            String[] split = sb.toString().split(",access");
            jSONObject.put("mmac", split[0].contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) ? split[0].substring(split[0].lastIndexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + 1) : split[0]);
        }
        try {
            return p1.f(e1.e(jSONObject.toString().getBytes("UTF-8"), this.e));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: android.content.Context */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.sqlite.SQLiteDatabase$CursorFactory] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x029a A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x029f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0260 A[EDGE_INSN: B:114:0x0260->B:81:0x0260 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd A[SYNTHETIC, Splitter:B:32:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0270 A[LOOP:0: B:38:0x00cf->B:82:0x0270, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0283  */
    private void h(Context context, String str, boolean z) throws Exception {
        Cursor cursor;
        Throwable th;
        boolean isOpen;
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        String str3;
        if (i1.r() && context != 0) {
            SQLiteDatabase sQLiteDatabase2 = 0;
            int i2 = 0;
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, sQLiteDatabase2);
                try {
                    if (m1.o(openOrCreateDatabase, "hist")) {
                        StringBuilder sb3 = new StringBuilder();
                        if (!z) {
                            sb3.append("time >");
                            sb3.append(m1.g() - i1.o());
                            if (str != null) {
                                sb3.append(" and feature = '");
                                str3 = str + "'";
                            }
                            cursor = openOrCreateDatabase.query("hist" + this.d, new String[]{"feature", " nb", "loc"}, sb3.toString(), null, null, null, "time ASC", null);
                            StringBuilder sb4 = new StringBuilder();
                            if (this.e == null) {
                                try {
                                    this.e = m1.e0(context);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            if (cursor != null || !cursor.moveToFirst()) {
                                sQLiteDatabase = openOrCreateDatabase;
                            } else {
                                while (true) {
                                    String str4 = ",access";
                                    if (cursor.getString(i2).startsWith(jl1.BLOCK_START_STR)) {
                                        jSONObject2 = new JSONObject(cursor.getString(i2));
                                        sb4.delete(i2, sb4.length());
                                        if (!TextUtils.isEmpty(cursor.getString(1))) {
                                            str4 = cursor.getString(1);
                                        } else {
                                            if (m1.u(jSONObject2, "mmac")) {
                                                sb4.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                                                sb4.append(jSONObject2.getString("mmac"));
                                            }
                                            jSONObject = new JSONObject(cursor.getString(2));
                                            if (m1.u(jSONObject, "type")) {
                                                jSONObject.put("type", "new");
                                            }
                                        }
                                        sb4.append(str4);
                                        jSONObject = new JSONObject(cursor.getString(2));
                                        if (m1.u(jSONObject, "type")) {
                                        }
                                    } else {
                                        JSONObject jSONObject3 = new JSONObject(new String(e1.h(p1.g(cursor.getString(i2)), this.e), "UTF-8"));
                                        sb4.delete(0, sb4.length());
                                        if (!TextUtils.isEmpty(cursor.getString(1))) {
                                            str4 = new String(e1.h(p1.g(cursor.getString(1)), this.e), "UTF-8");
                                        } else {
                                            if (m1.u(jSONObject3, "mmac")) {
                                                sb4.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                                                sb4.append(jSONObject3.getString("mmac"));
                                            }
                                            jSONObject = new JSONObject(new String(e1.h(p1.g(cursor.getString(2)), this.e), "UTF-8"));
                                            if (m1.u(jSONObject, "type")) {
                                                jSONObject.put("type", "new");
                                            }
                                            jSONObject2 = jSONObject3;
                                        }
                                        sb4.append(str4);
                                        jSONObject = new JSONObject(new String(e1.h(p1.g(cursor.getString(2)), this.e), "UTF-8"));
                                        if (m1.u(jSONObject, "type")) {
                                        }
                                        jSONObject2 = jSONObject3;
                                    }
                                    eo eoVar = new eo("");
                                    eoVar.b(jSONObject);
                                    if (!m1.u(jSONObject2, "mmac") || !m1.u(jSONObject2, "cgi")) {
                                        if (m1.u(jSONObject2, "cgi")) {
                                            String str5 = (jSONObject2.getString("cgi") + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + "network#";
                                            if (jSONObject2.getString("cgi").contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                                                str2 = str5 + "cgi";
                                            }
                                        }
                                        sb = sb3;
                                        sQLiteDatabase = openOrCreateDatabase;
                                        if (cursor.moveToNext()) {
                                            break;
                                        }
                                        sb3 = sb;
                                        openOrCreateDatabase = sQLiteDatabase;
                                        i2 = 0;
                                    } else {
                                        String str6 = (jSONObject2.getString("cgi") + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + "network#";
                                        if (jSONObject2.getString("cgi").contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                                            sb2 = new StringBuilder();
                                            sb2.append(str6);
                                            sb2.append("cgiwifi");
                                        } else {
                                            sb2 = new StringBuilder();
                                            sb2.append(str6);
                                            sb2.append("wifi");
                                        }
                                        str2 = sb2.toString();
                                    }
                                    sb = sb3;
                                    sQLiteDatabase = openOrCreateDatabase;
                                    try {
                                        m(str2, sb4, eoVar, context, false);
                                        if (cursor.moveToNext()) {
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sQLiteDatabase2 = sQLiteDatabase;
                                        j1.h(th, "DB", "fetchHist p2");
                                        if (sQLiteDatabase2 == 0 && isOpen) {
                                            return;
                                        }
                                    }
                                }
                                sb4.delete(0, sb4.length());
                                sb.delete(0, sb.length());
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                                return;
                            }
                            return;
                        }
                        sb3.append("time >");
                        sb3.append(m1.g() - 172800000);
                        if (str != null) {
                            sb3.append(" and feature = '");
                            str3 = str + "'";
                        }
                        cursor = openOrCreateDatabase.query("hist" + this.d, new String[]{"feature", " nb", "loc"}, sb3.toString(), null, null, null, "time ASC", null);
                        StringBuilder sb42 = new StringBuilder();
                        if (this.e == null) {
                        }
                        if (cursor != null) {
                        }
                        sQLiteDatabase = openOrCreateDatabase;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase.isOpen()) {
                        }
                        sb3.append(str3);
                        cursor = openOrCreateDatabase.query("hist" + this.d, new String[]{"feature", " nb", "loc"}, sb3.toString(), null, null, null, "time ASC", null);
                        try {
                            StringBuilder sb422 = new StringBuilder();
                            if (this.e == null) {
                            }
                            if (cursor != null) {
                            }
                            sQLiteDatabase = openOrCreateDatabase;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase.isOpen()) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            sQLiteDatabase = openOrCreateDatabase;
                            sQLiteDatabase2 = sQLiteDatabase;
                            j1.h(th, "DB", "fetchHist p2");
                        }
                    } else if (openOrCreateDatabase != null) {
                        try {
                            if (openOrCreateDatabase.isOpen()) {
                                openOrCreateDatabase.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            cursor = sQLiteDatabase2;
                            sQLiteDatabase2 = openOrCreateDatabase;
                            try {
                                j1.h(th, "DB", "fetchHist p2");
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase2 != 0 && sQLiteDatabase2.isOpen()) {
                                    sQLiteDatabase2.close();
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    sQLiteDatabase = openOrCreateDatabase;
                    cursor = sQLiteDatabase2;
                    sQLiteDatabase2 = sQLiteDatabase;
                    j1.h(th, "DB", "fetchHist p2");
                }
            } catch (Throwable th7) {
                th = th7;
                cursor = sQLiteDatabase2;
                j1.h(th, "DB", "fetchHist p2");
            }
        }
    }

    private void l(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context != null) {
            if (this.e == null) {
                this.e = m1.e0(context);
            }
            String e2 = e(str, sb, context);
            StringBuilder sb2 = new StringBuilder();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                sb2.append("CREATE TABLE IF NOT EXISTS hist");
                sb2.append(this.d);
                sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
                openOrCreateDatabase.execSQL(sb2.toString());
                sb2.delete(0, sb2.length());
                sb2.append("REPLACE INTO ");
                sb2.append("hist");
                sb2.append(this.d);
                sb2.append(" VALUES (?, ?, ?, ?)");
                byte[] e3 = e1.e(sb.toString().getBytes("UTF-8"), this.e);
                Object[] objArr = {e2, e3, e1.e(aMapLocation.toStr().getBytes("UTF-8"), this.e), Long.valueOf(aMapLocation.getTime())};
                for (int i2 = 1; i2 < 3; i2++) {
                    objArr[i2] = p1.f((byte[]) objArr[i2]);
                }
                openOrCreateDatabase.execSQL(sb2.toString(), objArr);
                sb2.delete(0, sb2.length());
                sb2.delete(0, sb2.length());
                if (openOrCreateDatabase.isOpen()) {
                    openOrCreateDatabase.close();
                }
            } catch (Throwable th) {
                sb2.delete(0, sb2.length());
                if (0 != 0 && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    private static void n(String str, Hashtable<String, String> hashtable) {
        if (!TextUtils.isEmpty(str)) {
            hashtable.clear();
            String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                    hashtable.put(str2, "");
                }
            }
        }
    }

    private boolean o(eo eoVar, boolean z) {
        if (!r(z)) {
            return false;
        }
        return eoVar == null || i1.f(eoVar.getTime()) || z;
    }

    private static boolean p(String str, eo eoVar) {
        if (TextUtils.isEmpty(str) || !m1.r(eoVar) || str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            return false;
        }
        return str.contains("network");
    }

    private static boolean q(String str, StringBuilder sb) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb) || !str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        String[] split = str.split(",access");
        String substring = split[0].contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) ? split[0].substring(split[0].lastIndexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) + 1) : split[0];
        if (TextUtils.isEmpty(substring)) {
            return false;
        }
        String sb2 = sb.toString();
        return sb2.contains(substring + ",access");
    }

    private boolean r(boolean z) {
        if (i1.r() || z) {
            return this.f || i1.t() || z;
        }
        return false;
    }

    private static double[] s(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < dArr.length; i4++) {
            d3 += dArr[i4] * dArr[i4];
            d4 += dArr2[i4] * dArr2[i4];
            d2 += dArr[i4] * dArr2[i4];
            if (dArr2[i4] == 1.0d) {
                i3++;
                if (dArr[i4] == 1.0d) {
                    i2++;
                }
            }
        }
        dArr3[0] = d2 / (Math.sqrt(d3) * Math.sqrt(d4));
        double d5 = (double) i2;
        dArr3[1] = (d5 * 1.0d) / ((double) i3);
        dArr3[2] = d5;
        for (int i5 = 0; i5 < 2; i5++) {
            if (dArr3[i5] > 1.0d) {
                dArr3[i5] = 1.0d;
            }
        }
        return dArr3;
    }

    private boolean u() {
        long B = m1.B();
        long j2 = this.b;
        long j3 = B - j2;
        if (j2 == 0) {
            return false;
        }
        return this.a.size() > 360 || j3 > 172800000;
    }

    private void v() {
        this.b = 0;
        if (!this.a.isEmpty()) {
            this.a.clear();
        }
        this.c = false;
    }

    private void w(Context context) throws Exception {
        if (context != null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                if (m1.o(openOrCreateDatabase, "hist")) {
                    String[] strArr = {String.valueOf(m1.g() - 172800000)};
                    try {
                        openOrCreateDatabase.delete("hist" + this.d, "time<?", strArr);
                    } catch (Throwable th) {
                        j1.h(th, "DB", "clearHist");
                        String message = th.getMessage();
                        if (!TextUtils.isEmpty(message)) {
                            message.contains("no such table");
                        }
                    }
                    if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                        openOrCreateDatabase.close();
                    }
                } else if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                    openOrCreateDatabase.close();
                }
            } catch (Throwable th2) {
                if (0 != 0 && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th2;
            }
        }
    }

    public final eo a(Context context, String str, StringBuilder sb, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str) || !i1.r()) {
            return null;
        }
        String str2 = str + "&" + this.l + "&" + this.m + "&" + this.n;
        if (str2.contains(GeocodeSearch.GPS) || !i1.r() || sb == null) {
            return null;
        }
        if (u()) {
            v();
            return null;
        }
        if (z && !this.c) {
            try {
                String e2 = e(str2, sb, context);
                v();
                h(context, e2, z2);
            } catch (Throwable unused) {
            }
        }
        if (this.a.isEmpty()) {
            return null;
        }
        return c(str2, sb, z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029 A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086 A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008d A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b5 A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ba A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c3 A[ADDED_TO_REGION, Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d4 A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00df A[Catch:{ all -> 0x00ec }] */
    public final eo b(c1 c1Var, boolean z, eo eoVar, i53 i53, StringBuilder sb, String str, Context context, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        String str2;
        String str3;
        eo a2;
        long g2;
        String str4;
        if (!o(eoVar, z2)) {
            return null;
        }
        try {
            b1 z6 = c1Var.z();
            if (!(z6 == null && this.i == null)) {
                b1 b1Var = this.i;
                if (b1Var != null) {
                    if (!b1Var.equals(z6)) {
                    }
                }
                z3 = true;
                if (eoVar == null) {
                    z4 = eoVar.getAccuracy() > 299.0f && i53.p().size() > 5;
                } else {
                    z4 = false;
                }
                if (eoVar != null || (str4 = this.h) == null || z4 || z3) {
                    z5 = false;
                } else {
                    z5 = m1.t(str4, sb.toString());
                    boolean z7 = this.g != 0 && m1.B() - this.g < 3000;
                    if ((z5 || z7) && m1.r(eoVar)) {
                        eoVar.e("mem");
                        eoVar.setLocationType(2);
                        return eoVar;
                    }
                }
                if (z5) {
                    this.g = m1.B();
                } else {
                    this.g = 0;
                }
                str2 = this.j;
                if (str2 != null || str.equals(str2)) {
                    if (this.j != null) {
                        g2 = m1.g();
                    } else {
                        this.k = m1.g();
                        str3 = str;
                        a2 = (!z4 || z) ? null : a(context, str3, sb, false, false);
                        if (!(z && !m1.r(a2))) {
                            if (!z4) {
                                if (z) {
                                    return null;
                                }
                                this.g = 0;
                                a2.setLocationType(4);
                                return a2;
                            }
                        }
                        return null;
                    }
                } else if (m1.g() - this.k < 3000) {
                    str3 = this.j;
                    if (!z4) {
                    }
                    if (!(z && !m1.r(a2))) {
                    }
                    return null;
                } else {
                    g2 = m1.g();
                }
                this.k = g2;
                this.j = str;
                str3 = str;
                if (!z4) {
                }
                if (!(z && !m1.r(a2))) {
                }
                return null;
            }
            z3 = false;
            if (eoVar == null) {
            }
            if (eoVar != null) {
            }
            z5 = false;
            if (z5) {
            }
            str2 = this.j;
            if (str2 != null) {
            }
            if (this.j != null) {
            }
        } catch (Throwable unused) {
        }
    }

    public final void f() {
        this.g = 0;
        this.h = null;
    }

    public final void g(Context context) {
        if (!this.c) {
            try {
                v();
                h(context, null, false);
            } catch (Throwable th) {
                j1.h(th, "Cache", "loadDB");
            }
            this.c = true;
        }
    }

    public final void i(AMapLocationClientOption aMapLocationClientOption) {
        this.m = aMapLocationClientOption.isNeedAddress();
        this.l = aMapLocationClientOption.isOffset();
        this.f = aMapLocationClientOption.isLocationCacheEnable();
        this.n = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void j(b1 b1Var) {
        this.i = b1Var;
    }

    public final void k(String str) {
        this.h = str;
    }

    public final void m(String str, StringBuilder sb, eo eoVar, Context context, boolean z) {
        try {
            if (m1.r(eoVar)) {
                String str2 = str + "&" + eoVar.isOffset() + "&" + eoVar.i() + "&" + eoVar.j();
                if (!p(str2, eoVar) || eoVar.e().equals("mem") || eoVar.e().equals("file")) {
                    return;
                }
                if (!eoVar.e().equals("wifioff")) {
                    if (!FirstSliceCode.FVV.equals(eoVar.d())) {
                        if (u()) {
                            v();
                        }
                        JSONObject f2 = eoVar.f();
                        if (m1.u(f2, "offpct")) {
                            f2.remove("offpct");
                            eoVar.a(f2);
                        }
                        if (str2.contains("wifi")) {
                            if (!TextUtils.isEmpty(sb)) {
                                if (eoVar.getAccuracy() >= 300.0f) {
                                    int i2 = 0;
                                    for (String str3 : sb.toString().split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                                        if (str3.contains(",")) {
                                            i2++;
                                        }
                                    }
                                    if (i2 >= 8) {
                                        return;
                                    }
                                } else if (eoVar.getAccuracy() <= 3.0f) {
                                    return;
                                }
                                if (str2.contains("cgiwifi") && !TextUtils.isEmpty(eoVar.g())) {
                                    String replace = str2.replace("cgiwifi", "cgi");
                                    eo h2 = eoVar.h();
                                    if (m1.r(h2)) {
                                        m(replace, new StringBuilder(), h2, context, true);
                                    }
                                }
                            } else {
                                return;
                            }
                        } else if (str2.contains("cgi") && (!(sb == null || sb.indexOf(",") == -1) || "4".equals(eoVar.d()))) {
                            return;
                        }
                        eo c2 = c(str2, sb, false);
                        if (!m1.r(c2) || !c2.toStr().equals(eoVar.toStr(3))) {
                            this.b = m1.B();
                            a aVar = new a();
                            aVar.b(eoVar);
                            aVar.c(TextUtils.isEmpty(sb) ? null : sb.toString());
                            if (this.a.containsKey(str2)) {
                                this.a.get(str2).add(aVar);
                            } else {
                                ArrayList<a> arrayList = new ArrayList<>();
                                arrayList.add(aVar);
                                this.a.put(str2, arrayList);
                            }
                            if (z) {
                                try {
                                    l(str2, eoVar, sb, context);
                                } catch (Throwable th) {
                                    j1.h(th, "Cache", Monitor.POINT_ADD);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            j1.h(th2, "Cache", Monitor.POINT_ADD);
        }
    }

    public final void t(Context context) {
        try {
            v();
            w(context);
            this.c = false;
            this.h = null;
            this.k = 0;
        } catch (Throwable th) {
            j1.h(th, "Cache", "destroy part");
        }
    }
}
