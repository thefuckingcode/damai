package com.alibaba.pictures.ut;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.ut.mini.UTAnalytics;
import com.youku.arch.v3.event.Subject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.oq2;
import tb.ot2;
import tb.uq2;

/* compiled from: Taobao */
public final class MovieShowUTHelper implements IUTPageOperation {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private Activity c;
    private boolean d;
    private Map<String, String> e;
    private final Object f;

    public MovieShowUTHelper(@Nullable Object obj) {
        Activity activity;
        this.f = obj;
        if (obj instanceof Fragment) {
            activity = ((Fragment) obj).getActivity();
        } else {
            activity = (Activity) (!(obj instanceof Activity) ? null : obj);
        }
        this.c = activity;
        g();
    }

    private final void d(Properties properties) {
        Intent intent;
        Intent intent2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1777066597")) {
            ipChange.ipc$dispatch("-1777066597", new Object[]{this, properties});
            return;
        }
        Activity activity = this.c;
        if (activity != null && (intent = activity.getIntent()) != null && intent.hasExtra(oq2.UT_CONST_SQM)) {
            Activity activity2 = this.c;
            properties.setProperty(oq2.UT_CONST_SQM, (activity2 == null || (intent2 = activity2.getIntent()) == null) ? null : intent2.getStringExtra(oq2.UT_CONST_SQM));
        }
    }

    private final void e() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1705683922")) {
            ipChange.ipc$dispatch("1705683922", new Object[]{this});
        } else if (this.d) {
            String str = this.b;
            if (str == null || str.length() == 0) {
                z = true;
            }
            if (z) {
                this.b = f();
            }
            String str2 = uq2.INSTANCE.f() + '.' + this.b;
            Properties properties = new Properties();
            properties.setProperty("spm-cnt", str2);
            DogCat dogCat = DogCat.INSTANCE;
            dogCat.B(this.c, properties);
            dogCat.C(str2);
        }
    }

    private final String f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "249384000")) {
            return (String) ipChange.ipc$dispatch("249384000", new Object[]{this});
        }
        Object obj = this.f;
        if (obj == null) {
            return "default";
        }
        String simpleName = obj.getClass().getSimpleName();
        k21.h(simpleName, "pageObj.javaClass.simpleName");
        String lowerCase = simpleName.toLowerCase();
        k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
        if ((o.v(lowerCase, "activity", false, 2, null)) || (o.v(lowerCase, Subject.FRAGMENT, false, 2, null))) {
            try {
                String substring = lowerCase.substring(0, lowerCase.length() - 8);
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                lowerCase = substring;
            } catch (Exception e2) {
                ot2.b(e2);
            }
        }
        uq2 uq2 = uq2.INSTANCE;
        String h = uq2.h("Page_" + lowerCase);
        return h != null ? h : lowerCase;
    }

    private final void g() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "24760086")) {
            ipChange.ipc$dispatch("24760086", new Object[]{this});
            return;
        }
        Object obj = this.f;
        if (obj != null) {
            SPM_Page sPM_Page = (SPM_Page) obj.getClass().getAnnotation(SPM_Page.class);
            this.a = sPM_Page != null ? sPM_Page.pageName() : null;
            this.b = sPM_Page != null ? sPM_Page.pageSpm() : null;
            String str = this.a;
            if (!(str == null || str.length() == 0)) {
                String str2 = this.b;
                if (!(str2 == null || str2.length() == 0)) {
                    uq2 uq2 = uq2.INSTANCE;
                    String str3 = this.a;
                    k21.f(str3);
                    String str4 = this.b;
                    k21.f(str4);
                    uq2.i(str3, str4);
                }
            }
            String str5 = this.a;
            if (str5 == null || str5.length() == 0) {
                String simpleName = this.f.getClass().getSimpleName();
                k21.h(simpleName, "pageObj.javaClass.simpleName");
                String lowerCase = simpleName.toLowerCase();
                k21.h(lowerCase, "(this as java.lang.String).toLowerCase()");
                if ((o.v(lowerCase, "activity", false, 2, null)) || (o.v(lowerCase, Subject.FRAGMENT, false, 2, null))) {
                    lowerCase = lowerCase.substring(0, lowerCase.length() - 8);
                    k21.h(lowerCase, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                this.a = lowerCase;
                uq2 uq22 = uq2.INSTANCE;
                String e2 = uq22.e();
                if (!(e2 == null || e2.length() == 0)) {
                    z = false;
                }
                String str6 = (z ? "Page_" : uq22.e()) + this.a;
                this.a = str6;
                this.b = uq22.h(str6);
            }
        }
    }

    private final void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005168735")) {
            ipChange.ipc$dispatch("-2005168735", new Object[]{this});
            return;
        }
        UTAnalytics instance = UTAnalytics.getInstance();
        k21.h(instance, "UTAnalytics.getInstance()");
        Map<String, String> pageProperties = instance.getDefaultTracker().getPageProperties(this.c);
        if (pageProperties != null) {
            Map<String, String> map = this.e;
            if (map == null) {
                this.e = new HashMap(pageProperties);
                return;
            }
            if (map != null) {
                map.clear();
            }
            Map<String, String> map2 = this.e;
            if (map2 != null) {
                map2.putAll(pageProperties);
            }
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public String getPageSPM() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1201306763")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("1201306763", new Object[]{this});
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public String getUTPageName() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-269073499")) {
            return (String) ipChange.ipc$dispatch("-269073499", new Object[]{this});
        }
        String str = this.a;
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (z) {
            SPM_Page sPM_Page = (SPM_Page) MovieShowUTHelper.class.getAnnotation(SPM_Page.class);
            this.a = sPM_Page != null ? sPM_Page.pageName() : null;
        }
        return this.a;
    }

    public final void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541660560")) {
            ipChange.ipc$dispatch("541660560", new Object[]{this});
            return;
        }
        Object obj = this.f;
        if (obj != null) {
            if (!(obj instanceof Fragment)) {
                ot2.a("onUTEnter:" + this.f + ',' + this.d);
                if (this.d) {
                    DogCat.INSTANCE.u(this.c, getUTPageName());
                    ot2.a("enterPage:" + this.c + AVFSCacheConstants.COMMA_SEP + getUTPageName());
                }
            } else if (this.d) {
                ot2.a("onUTEnter:" + this.f + ',' + this.d);
                StringBuilder sb = new StringBuilder();
                sb.append("leavePage:");
                sb.append(this.c);
                ot2.a(sb.toString());
                ot2.a("enterPageDonotSkip:" + this.c + AVFSCacheConstants.COMMA_SEP + getUTPageName());
                DogCat dogCat = DogCat.INSTANCE;
                dogCat.w(this.c);
                dogCat.v(this.c, getUTPageName());
            }
            e();
            j();
        }
    }

    public final void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69808815")) {
            ipChange.ipc$dispatch("-69808815", new Object[]{this});
            return;
        }
        ot2.a("onUTLeave:" + this.f);
        if (!(this.f instanceof Fragment)) {
            ot2.a("leavePage:" + this.c);
            DogCat.INSTANCE.w(this.c);
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void onUTButtonClick(@Nullable String str, @NotNull String... strArr) {
        Intent intent;
        Intent intent2;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1569997411")) {
            ipChange.ipc$dispatch("1569997411", new Object[]{this, str, strArr});
            return;
        }
        k21.i(strArr, "kvs");
        if (str == null) {
            ot2.c("onUTButtonClick error:controlName =null");
            return;
        }
        String str2 = null;
        if (!this.d) {
            Object obj = this.f;
            if (obj instanceof Fragment) {
                FragmentActivity activity = ((Fragment) obj).getActivity();
                if (activity instanceof IUTPageOperation) {
                    str2 = activity;
                }
                IUTPageOperation iUTPageOperation = (IUTPageOperation) str2;
                if (iUTPageOperation != null) {
                    iUTPageOperation.onUTButtonClick(str, (String[]) Arrays.copyOf(strArr, strArr.length));
                    return;
                }
                return;
            }
        }
        Activity activity2 = this.c;
        if (activity2 == null || (intent = activity2.getIntent()) == null || !intent.hasExtra(oq2.UT_CONST_SQM)) {
            DogCat.INSTANCE.d().n(getUTPageName()).k(str).p((String[]) Arrays.copyOf(strArr, strArr.length)).j();
            return;
        }
        String[] strArr2 = new String[(strArr.length + 2)];
        while (i < strArr.length) {
            strArr2[i] = strArr[i];
            i++;
        }
        strArr2[i] = oq2.UT_CONST_SQM;
        int i2 = i + 1;
        Activity activity3 = this.c;
        if (!(activity3 == null || (intent2 = activity3.getIntent()) == null)) {
            str2 = intent2.getStringExtra(oq2.UT_CONST_SQM);
        }
        strArr2[i2] = str2;
        DogCat.INSTANCE.d().n(getUTPageName()).k(str).p((String[]) Arrays.copyOf(strArr, strArr.length)).j();
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public String querySavedPageProperty(@Nullable String str) {
        Map<String, String> map;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1822708967")) {
            return (String) ipChange.ipc$dispatch("-1822708967", new Object[]{this, str});
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (!z && (map = this.e) != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void setUTPageEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "906410013")) {
            ipChange.ipc$dispatch("906410013", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ot2.a("setUTPageEnable:" + z + ',' + this.f);
        this.d = z;
        if (z) {
            Object obj = this.f;
            if (obj instanceof Fragment) {
                FragmentActivity activity = ((Fragment) obj).getActivity();
                if ((activity instanceof IUTPageOperation) && (obj instanceof IUTPageOperation)) {
                    IUTPageOperation iUTPageOperation = (IUTPageOperation) activity;
                    iUTPageOperation.setUTPageEnable(false);
                    iUTPageOperation.setUTPageName(((IUTPageOperation) obj).getUTPageName());
                }
            }
        }
        if (!this.d && !(this.f instanceof Fragment)) {
            ot2.a("skipPage:" + this.c);
            DogCat.INSTANCE.x(this.c);
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void setUTPageName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1861227303")) {
            ipChange.ipc$dispatch("-1861227303", new Object[]{this, str});
            return;
        }
        this.a = str;
        this.b = uq2.INSTANCE.h(str);
        Object obj = this.f;
        if (obj instanceof Fragment) {
            ((Fragment) obj).getLifecycle().addObserver(new MovieShowUTHelper$setUTPageName$1(this));
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void startExpoTrack(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599221371")) {
            ipChange.ipc$dispatch("1599221371", new Object[]{this, activity});
            return;
        }
        DogCat.INSTANCE.y(activity);
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void updateSPM(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "911059469")) {
            ipChange.ipc$dispatch("911059469", new Object[]{this, str});
            return;
        }
        this.b = str;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public void updateUTPageProperties(@Nullable Properties properties) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-604697006")) {
            ipChange.ipc$dispatch("-604697006", new Object[]{this, properties});
            return;
        }
        if (!this.d) {
            Object obj = this.f;
            if ((obj instanceof Fragment) && (((Fragment) obj).getActivity() instanceof IUTPageOperation)) {
                FragmentActivity activity = ((Fragment) this.f).getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type com.alibaba.pictures.ut.IUTPageOperation");
                ((IUTPageOperation) activity).updateUTPageProperties(properties);
                return;
            }
        }
        if (properties != null) {
            d(properties);
            DogCat.INSTANCE.B(this.c, properties);
        } else {
            Properties properties2 = new Properties();
            d(properties2);
            DogCat.INSTANCE.B(this.c, properties2);
        }
        j();
    }
}
