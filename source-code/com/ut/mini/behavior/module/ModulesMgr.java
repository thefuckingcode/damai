package com.ut.mini.behavior.module;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.zf2;

/* compiled from: Taobao */
public class ModulesMgr {
    private static final String TAG = "ModulesMgr";
    public static final String UT_TAG = "ut_tag";
    private final Object Lock_Object;
    private ModulesConfig mModulesConfig;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SingletonHolder {
        private static ModulesMgr instance = new ModulesMgr();

        private SingletonHolder() {
        }
    }

    public static ModulesMgr getInstance() {
        return SingletonHolder.instance;
    }

    /* access modifiers changed from: package-private */
    public void init(String str) {
        if (zf2.f(str)) {
            this.mModulesConfig = null;
            return;
        }
        try {
            this.mModulesConfig = (ModulesConfig) JSON.parseObject(str, ModulesConfig.class);
        } catch (Exception e) {
            Logger.h(TAG, e, new Object[0]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        r0 = r1.iterator();
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        if (r0.hasNext() == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        r3 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (com.ut.mini.behavior.expression.ExpressionEvaluator.getInstance().evaluateData(r3.data, r7) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r1 != null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        r1 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r1.add(r3.name);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r1 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        r7 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r7 = com.alibaba.fastjson.JSON.toJSONString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        if (r1 == null) goto L_0x0055;
     */
    public Map<String, String> makeTag(Map<String, String> map) {
        String str;
        synchronized (this.Lock_Object) {
            ModulesConfig modulesConfig = this.mModulesConfig;
            if (modulesConfig == null) {
                return null;
            }
            List<Module> list = modulesConfig.moduleList;
        }
        if (!str.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put(UT_TAG, str);
            return hashMap;
        }
        return null;
    }

    private ModulesMgr() {
        this.Lock_Object = new Object();
    }

    public void init(ModulesConfig modulesConfig) {
        synchronized (this.Lock_Object) {
            this.mModulesConfig = modulesConfig;
        }
    }
}
