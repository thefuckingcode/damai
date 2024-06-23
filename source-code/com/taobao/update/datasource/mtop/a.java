package com.taobao.update.datasource.mtop;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.update.datasource.UpdateDataSource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import tb.gl1;
import tb.js2;
import tb.ns2;
import tb.uo;

/* compiled from: Taobao */
public class a {
    public Context mContext;
    public String mFrom;
    public String mGroup;
    public boolean mIsOutApk;
    public String mTtid;

    /* compiled from: Taobao */
    public static class b {
        private Context a;
        private String b;
        private String c;
        private boolean d;
        private String e;

        private b(Context context) {
            this.a = context;
        }

        public static b newBuilder(Context context) {
            return new b(context);
        }

        public a build() {
            return new a(this.a, this.b, this.c, this.d, this.e);
        }

        public b setFrom(String str) {
            this.e = str;
            return this;
        }

        public b setGroup(String str) {
            this.c = str;
            return this;
        }

        public b setOutApk(boolean z) {
            this.d = z;
            return this;
        }

        public b setTtid(String str) {
            this.b = str;
            return this;
        }
    }

    private boolean a() {
        String str;
        String str2 = null;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class);
            str = (String) method.invoke(null, "ro.yunos.version");
            try {
                str2 = (String) method.invoke(null, "java.vm.name");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = null;
        }
        if ((str2 == null || !str2.toLowerCase().contains("lemur")) && (str == null || str.trim().length() <= 0)) {
            return false;
        }
        return true;
    }

    public JSONObject queryUpdateInfo() {
        UpdateRequest updateRequest = new UpdateRequest(this.mIsOutApk);
        if (!TextUtils.isEmpty(this.mFrom) && !this.mFrom.equals(js2.MTOP_SOURCE)) {
            updateRequest.betaSource = this.mFrom;
        }
        updateRequest.brand = Build.getMANUFACTURER();
        updateRequest.model = Build.getMODEL();
        updateRequest.identifier = this.mGroup;
        updateRequest.appVersion = ns2.getVersionName();
        updateRequest.apiLevel = (long) Build.VERSION.SDK_INT;
        updateRequest.patchVersion = 0;
        updateRequest.cpuArch = uo.getCpuArch();
        updateRequest.dexpatchVersion = 0;
        updateRequest.isYunos = a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(js2.MAIN);
        arrayList.add(js2.DYNAMIC);
        arrayList.add(js2.HOTPATCH);
        arrayList.add("bundles");
        arrayList.add("andfix");
        arrayList.add(js2.DEXPATCH);
        updateRequest.updateTypes = arrayList;
        return UpdateDataSource.sUpdateAdapter.invokePullApi(updateRequest, this.mContext, this.mTtid, this.mIsOutApk);
    }

    private a(Context context, String str, String str2, boolean z, String str3) {
        this.mContext = context;
        this.mTtid = str;
        this.mGroup = str2;
        this.mIsOutApk = z;
        this.mFrom = str3;
    }
}
