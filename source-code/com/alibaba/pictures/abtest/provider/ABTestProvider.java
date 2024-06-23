package com.alibaba.pictures.abtest.provider;

import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.pictures.abtest.model.ABTestExperiment;
import com.alibaba.pictures.abtest.model.ABTestScenarioResult;
import com.alibaba.pictures.abtest.model.ABTestScenarioResultList;
import com.alibaba.pictures.abtest.request.ABTestExperimentRequest;
import com.alibaba.pictures.abtest.request.ABTestUploadRequest;
import com.alibaba.pictures.ut.DogCat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import tb.a;
import tb.c;
import tb.d;
import tb.k21;
import tb.ta0;

public final class ABTestProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String ABTestCacheKey;
    public static final ABTestProvider INSTANCE = new ABTestProvider();
    private static ABTestScenarioResultList a;
    private static String b;
    private static String c;
    private static Set<String> d = new LinkedHashSet();

    private ABTestProvider() {
    }

    private final String b(ABTestExperiment aBTestExperiment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1420511100")) {
            return (String) ipChange.ipc$dispatch("-1420511100", new Object[]{this, aBTestExperiment});
        }
        StringBuilder sb = new StringBuilder();
        if (aBTestExperiment != null) {
            sb.append(aBTestExperiment.scenario);
            sb.append(".");
            Long l = aBTestExperiment.experimentId;
            k21.h(l, "experimentId");
            sb.append(l.longValue());
            sb.append("|");
            ABTestExperiment.Params params = aBTestExperiment.params;
            sb.append(params != null ? params.bucketId : null);
            sb.append(";");
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply {\n…       }\n    }.toString()");
        return sb2;
    }

    public static /* synthetic */ String g(ABTestProvider aBTestProvider, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return aBTestProvider.f(str, l, str2);
    }

    private final String h() {
        List<ABTestScenarioResult> list;
        List<ABTestExperiment> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1207865922")) {
            return (String) ipChange.ipc$dispatch("1207865922", new Object[]{this});
        }
        ABTestScenarioResultList c2 = c();
        if (c2 == null || (list = c2.scenarioResultList) == null) {
            return "";
        }
        for (T t : list) {
            if (!(!k21.d(b, t.scenario)) && (list2 = t.experimentList) != null) {
                Iterator<T> it = list2.iterator();
                if (it.hasNext()) {
                    return INSTANCE.b(it.next());
                }
            }
        }
        return "";
    }

    public static /* synthetic */ void k(ABTestProvider aBTestProvider, String str, Long l, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            bool = Boolean.TRUE;
        }
        aBTestProvider.j(str, l, str2, bool);
    }

    public static /* synthetic */ void m(ABTestProvider aBTestProvider, List list, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = Boolean.TRUE;
        }
        aBTestProvider.l(list, bool);
    }

    public final ABTestScenarioResultList c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1183621581")) {
            return (ABTestScenarioResultList) ipChange.ipc$dispatch("-1183621581", new Object[]{this});
        }
        ABTestScenarioResultList aBTestScenarioResultList = a;
        if (aBTestScenarioResultList != null) {
            return aBTestScenarioResultList;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("ABTestCacheKey: ABTestExperimentData_");
            d.a aVar = d.Companion;
            String b2 = aVar.b().b();
            String str = "";
            if (b2 == null) {
                b2 = str;
            }
            sb.append(b2);
            c.b(null, sb.toString(), 1, null);
            Gson gson = new Gson();
            a aVar2 = a.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ABTestCacheKey);
            String b3 = aVar.b().b();
            if (b3 != null) {
                str = b3;
            }
            sb2.append(str);
            return (ABTestScenarioResultList) gson.fromJson(aVar2.b(sb2.toString()), ABTestScenarioResultList.class);
        } catch (Exception e) {
            c.b(null, "getABAllExperimentData error=" + e, 1, null);
            return a;
        }
    }

    public final String d() {
        List<ABTestScenarioResult> list;
        List<ABTestExperiment> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656097181")) {
            return (String) ipChange.ipc$dispatch("-656097181", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        ABTestScenarioResultList c2 = INSTANCE.c();
        if (!(c2 == null || (list = c2.scenarioResultList) == null)) {
            for (T t : list) {
                if (!(t == null || (list2 = t.experimentList) == null)) {
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        sb.append(INSTANCE.b(it.next()));
                    }
                }
            }
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply {\n…       }\n    }.toString()");
        return sb2;
    }

    public final String e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2066715869")) {
            return (String) ipChange.ipc$dispatch("2066715869", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = d.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply {\n…       }\n    }.toString()");
        return sb2;
    }

    public final String f(String str, Long l, String str2) {
        ABTestExperiment.Params params;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "360756829")) {
            return (String) ipChange.ipc$dispatch("360756829", new Object[]{this, str, l, str2});
        }
        b = str;
        d.a aVar = d.Companion;
        if (!aVar.b().a()) {
            m(this, aVar.b().c(), null, 2, null);
        }
        if (str2 == null || str2.length() == 0) {
            ABTestExperiment i = i(str, l);
            str2 = (i == null || (params = i.params) == null) ? null : params.bucketId;
        }
        c = str2;
        if (!(str2 == null || str2.length() == 0)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("spm", "app.yingyan.abtest.get");
            linkedHashMap.put(ParamsConstants.Key.PARAM_SCENE_CODE, String.valueOf(str));
            linkedHashMap.put("experimentId", String.valueOf(l));
            linkedHashMap.put("bucketId", String.valueOf(c));
            DogCat.INSTANCE.g().c("Page_All").b("MVPABTestGetBucket").d(linkedHashMap).a();
        }
        String h = h();
        if (h.length() <= 0) {
            z = false;
        }
        if (z) {
            d.add(h);
        }
        return c;
    }

    public final ABTestExperiment i(String str, Long l) {
        ABTestScenarioResultList c2;
        List<ABTestScenarioResult> list;
        List<ABTestExperiment> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468534438")) {
            return (ABTestExperiment) ipChange.ipc$dispatch("468534438", new Object[]{this, str, l});
        }
        if (!(str == null || l == null || (c2 = c()) == null || (list = c2.scenarioResultList) == null)) {
            for (T t : list) {
                if (!(!k21.d(str, t.scenario)) && (list2 = t.experimentList) != null) {
                    for (T t2 : list2) {
                        if (k21.d(l, t2.experimentId)) {
                            return t2;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final void j(String str, Long l, String str2, Boolean bool) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1658612360")) {
            ipChange.ipc$dispatch("1658612360", new Object[]{this, str, l, str2, bool});
            return;
        }
        if (!(str2 == null || str2.length() == 0)) {
            z = false;
        }
        if (!z) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("spm", "app.yingyan.abtest.touch");
            linkedHashMap.put(ParamsConstants.Key.PARAM_SCENE_CODE, String.valueOf(str));
            linkedHashMap.put("experimentId", String.valueOf(l));
            linkedHashMap.put("bucketId", String.valueOf(str2));
            linkedHashMap.put("needReport", String.valueOf(bool));
            DogCat.INSTANCE.g().c("Page_All").b("MVPABTestTouch").d(linkedHashMap).a();
        }
    }

    public final void l(List<String> list, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "241589815")) {
            ipChange.ipc$dispatch("241589815", new Object[]{this, list, bool});
            return;
        }
        ABTestExperimentRequest aBTestExperimentRequest = new ABTestExperimentRequest();
        aBTestExperimentRequest.setScenarios(list);
        aBTestExperimentRequest.setPreload(bool);
        a = null;
        ta0.Companion.b(aBTestExperimentRequest).a().doOnKTSuccess(ABTestProvider$requestABTestExperimentData$1.INSTANCE).doOnKTSuccessNull(ABTestProvider$requestABTestExperimentData$2.INSTANCE).doOnKTFail(ABTestProvider$requestABTestExperimentData$3.INSTANCE);
    }

    public final void n(String str, Long l) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1926320133")) {
            ipChange.ipc$dispatch("1926320133", new Object[]{this, str, l});
            return;
        }
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (z || l == null) {
            c.b(null, "request params scenario or experimentId is null", 1, null);
            return;
        }
        ABTestExperiment i = i(str, l);
        if (i == null) {
            c.b(null, "request params abUploadInfo is null", 1, null);
            return;
        }
        ABTestUploadRequest aBTestUploadRequest = new ABTestUploadRequest();
        aBTestUploadRequest.setScenario(str);
        aBTestUploadRequest.setAbUploadInfo(new Gson().toJson(i));
        ta0.Companion.b(aBTestUploadRequest).a().doOnKTSuccess(ABTestProvider$startABTestExperiment$1.INSTANCE).doOnKTSuccessNull(ABTestProvider$startABTestExperiment$2.INSTANCE).doOnKTFail(ABTestProvider$startABTestExperiment$3.INSTANCE);
    }
}
