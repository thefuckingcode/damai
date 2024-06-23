package cn.damai.homepage.util.window;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.coupondialog.net.CouponListResponse;
import cn.damai.homepage.MainAlertEntity;
import cn.damai.homepage.bean.HomeWantSeeBean;
import cn.damai.homepage.ui.view.HomepageEvaluateDialog;
import cn.damai.homepage.util.MemberGuideDialogManger;
import cn.damai.rank.view.WantSeePosterTips;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.util.TDialog;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.o;
import tb.a03;
import tb.ax0;
import tb.d20;
import tb.jr1;
import tb.k21;
import tb.kr1;
import tb.nr1;
import tb.p30;
import tb.pr1;
import tb.q32;
import tb.s41;
import tb.sq2;
import tb.ur2;

public final class MiddlePriortyHandle extends pr1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private BaseActivity<?, ?> a;
    private WantSeePosterTips b;
    private PopupCallback c;

    public static final class a implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<jr1> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super jr1> continuation) {
            this.a = continuation;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1461104051")) {
                ipChange.ipc$dispatch("1461104051", new Object[]{this, dialogInterface});
                return;
            }
            Continuation<jr1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    public static final class b implements UTHelperCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ sq2 a;
        final /* synthetic */ Map<String, JSONObject> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
        /* JADX WARN: Multi-variable type inference failed */
        b(sq2 sq2, Map<String, ? extends JSONObject> map) {
            this.a = sq2;
            this.b = map;
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void closeUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1455106567")) {
                ipChange.ipc$dispatch("-1455106567", new Object[]{this});
                return;
            }
            this.a.closeUt(a03.f(), this.b);
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void confirmUt(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2038833413")) {
                ipChange.ipc$dispatch("-2038833413", new Object[]{this, str});
                return;
            }
            k21.i(str, "content");
            this.a.confirmUt(a03.f(), this.b);
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void exposureUt(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-788461552")) {
                ipChange.ipc$dispatch("-788461552", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.a.exposureUt(j, a03.f(), this.b);
        }
    }

    public static final class c implements UTHelperCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ sq2 a;
        final /* synthetic */ Map<String, JSONObject> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
        /* JADX WARN: Multi-variable type inference failed */
        c(sq2 sq2, Map<String, ? extends JSONObject> map) {
            this.a = sq2;
            this.b = map;
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void closeUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1965640744")) {
                ipChange.ipc$dispatch("-1965640744", new Object[]{this});
                return;
            }
            this.a.closeUt(a03.f(), this.b);
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void confirmUt(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-88533158")) {
                ipChange.ipc$dispatch("-88533158", new Object[]{this, str});
                return;
            }
            k21.i(str, "content");
            this.a.confirmUt(a03.f(), this.b);
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void exposureUt(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1197285777")) {
                ipChange.ipc$dispatch("-1197285777", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.a.exposureUt(j, a03.f(), this.b);
        }
    }

    public static final class d implements MemberGuideDialogManger.IMemberDialogDispatcher {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MiddlePriortyHandle a;
        final /* synthetic */ Continuation<jr1> b;

        public static final class a implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Continuation<jr1> a;

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
            /* JADX WARN: Multi-variable type inference failed */
            a(Continuation<? super jr1> continuation) {
                this.a = continuation;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-582645883")) {
                    ipChange.ipc$dispatch("-582645883", new Object[]{this, dialogInterface});
                    return;
                }
                Continuation<jr1> continuation = this.a;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        d(MiddlePriortyHandle middlePriortyHandle, Continuation<? super jr1> continuation) {
            this.a = middlePriortyHandle;
            this.b = continuation;
        }

        @Override // cn.damai.homepage.util.MemberGuideDialogManger.IMemberDialogDispatcher
        public final void dialogToShow(Dialog dialog) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1979109994")) {
                ipChange.ipc$dispatch("1979109994", new Object[]{this, dialog});
                return;
            }
            dialog.setOnDismissListener(new a(this.b));
            if (!this.a.a.isFinishing()) {
                dialog.show();
                return;
            }
            Continuation<jr1> continuation = this.b;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    public static final class e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<jr1> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super jr1> continuation) {
            this.a = continuation;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public final void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1358157982")) {
                ipChange.ipc$dispatch("1358157982", new Object[]{this, dVar});
                return;
            }
            Continuation<jr1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    public static final class f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MiddlePriortyHandle a;
        final /* synthetic */ Ref$ObjectRef<Dialog> b;
        final /* synthetic */ boolean c;
        final /* synthetic */ String d;
        final /* synthetic */ Continuation<jr1> e;
        final /* synthetic */ MainAlertEntity.MainAlertModel f;
        final /* synthetic */ Map<String, JSONObject> g;
        final /* synthetic */ sq2 h;
        final /* synthetic */ MainAlertEntity i;

        public static final class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ MainAlertEntity.MainAlertModel a;
            final /* synthetic */ MiddlePriortyHandle b;
            final /* synthetic */ Map<String, JSONObject> c;
            final /* synthetic */ Ref$ObjectRef<Dialog> d;
            final /* synthetic */ sq2 e;
            final /* synthetic */ MainAlertEntity f;

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
            /* JADX WARN: Multi-variable type inference failed */
            a(MainAlertEntity.MainAlertModel mainAlertModel, MiddlePriortyHandle middlePriortyHandle, Map<String, ? extends JSONObject> map, Ref$ObjectRef<Dialog> ref$ObjectRef, sq2 sq2, MainAlertEntity mainAlertEntity) {
                this.a = mainAlertModel;
                this.b = middlePriortyHandle;
                this.c = map;
                this.d = ref$ObjectRef;
                this.e = sq2;
                this.f = mainAlertEntity;
            }

            public final void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "333717818")) {
                    ipChange.ipc$dispatch("333717818", new Object[]{this, view});
                    return;
                }
                if (this.a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(MonitorType.SKIP, true);
                    bundle.putString("from_page", "homepage");
                    DMNav.from(this.b.a).withExtras(bundle).toUri(this.a.schema);
                    boolean d2 = k21.d(MainAlertEntity.PICK_TYPE_CALLBACK, this.a.pkType);
                    Map<String, JSONObject> map = this.c;
                    if (map != null) {
                        this.e.confirmUt(a03.f(), map);
                    } else {
                        MainAlertEntity.MainAlertModel mainAlertModel = this.a;
                        MainAlertEntity mainAlertEntity = this.f;
                        if (d2) {
                            cn.damai.common.user.c.e().x(ax0.I().z(String.valueOf(mainAlertModel.circleId), "0", 0, mainAlertModel.imageUrl));
                        } else {
                            cn.damai.common.user.c.e().x(ax0.I().y(mainAlertModel.schema, mainAlertModel.scm, mainAlertEntity.id, String.valueOf(mainAlertModel.circleId), mainAlertModel.imageUrl));
                        }
                    }
                }
                T t = this.d.element;
                if (t != null) {
                    t.dismiss();
                }
            }
        }

        public static final class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Ref$ObjectRef<Dialog> a;
            final /* synthetic */ MainAlertEntity.MainAlertModel b;
            final /* synthetic */ Map<String, JSONObject> c;
            final /* synthetic */ sq2 d;

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
            /* JADX WARN: Multi-variable type inference failed */
            b(Ref$ObjectRef<Dialog> ref$ObjectRef, MainAlertEntity.MainAlertModel mainAlertModel, Map<String, ? extends JSONObject> map, sq2 sq2) {
                this.a = ref$ObjectRef;
                this.b = mainAlertModel;
                this.c = map;
                this.d = sq2;
            }

            public final void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1849959109")) {
                    ipChange.ipc$dispatch("-1849959109", new Object[]{this, view});
                } else if (this.a.element != null && k21.d(MainAlertEntity.PICK_TYPE_CALLBACK, this.b.pkType)) {
                    Map<String, JSONObject> map = this.c;
                    if (map != null) {
                        this.d.closeUt(a03.f(), map);
                        return;
                    }
                    MainAlertEntity.MainAlertModel mainAlertModel = this.b;
                    cn.damai.common.user.c.e().x(ax0.I().z(String.valueOf(mainAlertModel.circleId), "0", 1, mainAlertModel.imageUrl));
                }
            }
        }

        public static final class c implements TDialog.OnDialogShowTimeListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Map<String, JSONObject> a;
            final /* synthetic */ sq2 b;
            final /* synthetic */ MainAlertEntity.MainAlertModel c;

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
            /* JADX WARN: Multi-variable type inference failed */
            c(Map<String, ? extends JSONObject> map, sq2 sq2, MainAlertEntity.MainAlertModel mainAlertModel) {
                this.a = map;
                this.b = sq2;
                this.c = mainAlertModel;
            }

            @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
            public final void exposureTime(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-759494451")) {
                    ipChange.ipc$dispatch("-759494451", new Object[]{this, Long.valueOf(j)});
                    return;
                }
                Map<String, JSONObject> map = this.a;
                if (map != null) {
                    this.b.exposureUt(j, a03.f(), map);
                    return;
                }
                MainAlertEntity.MainAlertModel mainAlertModel = this.c;
                if (k21.d(MainAlertEntity.PICK_TYPE_CALLBACK, mainAlertModel.pkType)) {
                    ax0.p(j, mainAlertModel.schema, String.valueOf(mainAlertModel.circleId), "0", mainAlertModel.imageUrl);
                } else {
                    ax0.o(j, mainAlertModel.schema, mainAlertModel.scm, mainAlertModel.imageUrl);
                }
            }
        }

        public static final class d implements DialogInterface.OnDismissListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Continuation<jr1> a;

            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
            /* JADX WARN: Multi-variable type inference failed */
            d(Continuation<? super jr1> continuation) {
                this.a = continuation;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1521765997")) {
                    ipChange.ipc$dispatch("-1521765997", new Object[]{this, dialogInterface});
                    return;
                }
                Continuation<jr1> continuation = this.a;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
        /* JADX WARN: Multi-variable type inference failed */
        f(MiddlePriortyHandle middlePriortyHandle, Ref$ObjectRef<Dialog> ref$ObjectRef, boolean z, String str, Continuation<? super jr1> continuation, MainAlertEntity.MainAlertModel mainAlertModel, Map<String, ? extends JSONObject> map, sq2 sq2, MainAlertEntity mainAlertEntity) {
            this.a = middlePriortyHandle;
            this.b = ref$ObjectRef;
            this.c = z;
            this.d = str;
            this.e = continuation;
            this.f = mainAlertModel;
            this.g = map;
            this.h = sq2;
            this.i = mainAlertEntity;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public final void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2031199309")) {
                ipChange.ipc$dispatch("-2031199309", new Object[]{this, eVar});
            } else if (this.a.a.isActivityFinsihed() || !this.a.a.isActivityForeground() || eVar.b == null) {
                Continuation<jr1> continuation = this.e;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            } else {
                this.b.element = (T) DialogUtil.a(this.a.a, eVar.b, new a(this.f, this.a, this.g, this.b, this.h, this.i), new b(this.b, this.f, this.g, this.h), new c(this.g, this.h, this.f));
                T t = this.b.element;
                if (t != null) {
                    t.setOnDismissListener(new d(this.e));
                }
                if (!this.a.a.isFinishing()) {
                    T t2 = this.b.element;
                    if (t2 != null) {
                        t2.show();
                    }
                    if (this.c && !TextUtils.isEmpty(this.d)) {
                        this.a.f(this.d);
                        return;
                    }
                    return;
                }
                Continuation<jr1> continuation2 = this.e;
                Result.a aVar2 = Result.Companion;
                continuation2.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            }
        }
    }

    public static final class g implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<jr1> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        g(Continuation<? super jr1> continuation) {
            this.a = continuation;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public final void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1019514299")) {
                ipChange.ipc$dispatch("1019514299", new Object[]{this, dVar});
                return;
            }
            Continuation<jr1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    public static final class h implements UTHelperCallback {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ sq2 a;
        final /* synthetic */ Map<String, JSONObject> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
        /* JADX WARN: Multi-variable type inference failed */
        h(sq2 sq2, Map<String, ? extends JSONObject> map) {
            this.a = sq2;
            this.b = map;
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void closeUt() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1766029314")) {
                ipChange.ipc$dispatch("-1766029314", new Object[]{this});
                return;
            }
            this.a.closeUt(a03.f(), this.b);
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void confirmUt(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1407099776")) {
                ipChange.ipc$dispatch("-1407099776", new Object[]{this, str});
                return;
            }
            k21.i(str, "score");
            HashMap<String, String> f = a03.f();
            if (!(o.y(str))) {
                k21.h(f, "map");
                f.put("titlelabel", str);
            }
            this.a.confirmUt(f, this.b);
        }

        @Override // cn.damai.homepage.util.window.UTHelperCallback
        public void exposureUt(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-141152363")) {
                ipChange.ipc$dispatch("-141152363", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.a.exposureUt(j, a03.f(), this.b);
        }
    }

    public static final class i implements HomepageEvaluateDialog.OnUserRejectListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MiddlePriortyHandle a;

        i(MiddlePriortyHandle middlePriortyHandle) {
            this.a = middlePriortyHandle;
        }

        @Override // cn.damai.homepage.ui.view.HomepageEvaluateDialog.OnUserRejectListener
        public final void onUserReject(CouponListResponse.ContentList contentList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-893546913")) {
                ipChange.ipc$dispatch("-893546913", new Object[]{this, contentList});
                return;
            }
            PopupCallback popupCallback = this.a.c;
            if (popupCallback != null) {
                String str = contentList.targetId;
                k21.h(str, "data.targetId");
                popupCallback.evaluateOnUserReject(str);
            }
        }
    }

    public static final class j implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<jr1> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        j(Continuation<? super jr1> continuation) {
            this.a = continuation;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "177327639")) {
                ipChange.ipc$dispatch("177327639", new Object[]{this, dialogInterface});
                return;
            }
            Continuation<jr1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    public static final class k implements WantSeePosterTips.ActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ MiddlePriortyHandle c;
        final /* synthetic */ sq2 d;
        final /* synthetic */ Map<String, JSONObject> e;
        final /* synthetic */ Continuation<jr1> f;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        k(boolean z, String str, MiddlePriortyHandle middlePriortyHandle, sq2 sq2, Map<String, ? extends JSONObject> map, Continuation<? super jr1> continuation) {
            this.a = z;
            this.b = str;
            this.c = middlePriortyHandle;
            this.d = sq2;
            this.e = map;
            this.f = continuation;
        }

        @Override // cn.damai.rank.view.WantSeePosterTips.ActionListener
        public void click() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-982599872")) {
                ipChange.ipc$dispatch("-982599872", new Object[]{this});
                return;
            }
            HashMap<String, String> f2 = a03.f();
            k21.h(f2, "getUserCodeAndCityMap()");
            this.d.confirmUt(f2, this.e);
        }

        @Override // cn.damai.rank.view.WantSeePosterTips.ActionListener
        public void hide(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "630711428")) {
                ipChange.ipc$dispatch("630711428", new Object[]{this, Long.valueOf(j)});
                return;
            }
            if (this.a && !TextUtils.isEmpty(this.b)) {
                this.c.f(this.b);
            }
            HashMap<String, String> f2 = a03.f();
            k21.h(f2, "getUserCodeAndCityMap()");
            this.d.exposureUt(j, f2, this.e);
            try {
                Continuation<jr1> continuation = this.f;
                Result.a aVar = Result.Companion;
                continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            } catch (Exception e2) {
                System.out.println((Object) ("suspendCoroutine 执行失败 返回异常：" + e2));
            }
        }
    }

    public MiddlePriortyHandle(BaseActivity<?, ?> baseActivity) {
        k21.i(baseActivity, "mContext");
        this.a = baseActivity;
    }

    private final Object d(ArrayList<PopupDetailBean> arrayList, Continuation<? super jr1> continuation) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1645245951")) {
            return ipChange.ipc$dispatch("-1645245951", new Object[]{this, arrayList, continuation});
        }
        if (arrayList == null || arrayList.size() <= 0) {
            q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
            Result.a aVar = Result.Companion;
            q32.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            Object a2 = q32.a();
            if (a2 == kotlin.coroutines.intrinsics.b.d()) {
                p30.c(continuation);
            }
            return a2;
        }
        PopupDetailBean popupDetailBean = arrayList.get(0);
        if (popupDetailBean != null) {
            PopupDetailBean.PopupItem popupItem = popupDetailBean.item;
            JSONObject jSONObject2 = null;
            Object obj = (popupItem == null || (jSONObject = popupItem.value) == null) ? null : jSONObject.get("action");
            Map<String, ? extends JSONObject> map = obj instanceof Map ? (Map) obj : null;
            if (k21.d(popupDetailBean.sceneType + '_' + popupDetailBean.eventType, nr1.WANT_SEE_UPDATE)) {
                PopupDetailBean.PopupItem popupItem2 = popupDetailBean.item;
                if (popupItem2 != null) {
                    jSONObject2 = popupItem2.value;
                }
                return l(HomeWantSeeBean.getValidBean(jSONObject2), popupDetailBean.pkId, popupDetailBean.needReport, map, continuation);
            }
            PopupDetailBean.PopupItem popupItem3 = popupDetailBean.item;
            if (popupItem3 != null) {
                jSONObject2 = popupItem3.value;
            }
            MainAlertEntity mainAlertEntity = (MainAlertEntity) s41.d(jSONObject2, MainAlertEntity.class);
            if (mainAlertEntity != null) {
                if (k21.d("3", mainAlertEntity.type)) {
                    CouponListResponse.ContentList contentList = mainAlertEntity.content;
                    k21.h(contentList, "alertEntity.content");
                    return k(contentList, map, continuation);
                } else if (k21.d("4", mainAlertEntity.type) || k21.d("6", mainAlertEntity.type) || k21.d("5", mainAlertEntity.type)) {
                    return e(mainAlertEntity, map, continuation);
                } else {
                    return i(mainAlertEntity, popupDetailBean.pkId, popupDetailBean.needReport, map, continuation);
                }
            }
        }
        q32 q322 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        Result.a aVar2 = Result.Companion;
        q322.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        Object a3 = q322.a();
        if (a3 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a3;
    }

    private final Object e(MainAlertEntity mainAlertEntity, Map<String, ? extends JSONObject> map, Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-864564105")) {
            return ipChange.ipc$dispatch("-864564105", new Object[]{this, mainAlertEntity, map, continuation});
        }
        sq2 sq2 = new sq2(this.a);
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        MemberGuideDialogManger memberGuideDialogManger = new MemberGuideDialogManger(this.a, new d(this, q32));
        memberGuideDialogManger.h(mainAlertEntity, new a(q32));
        if (k21.d("4", mainAlertEntity.type)) {
            if (map != null) {
                memberGuideDialogManger.l(new b(sq2, map));
            }
        } else if (k21.d("6", mainAlertEntity.type) && map != null) {
            memberGuideDialogManger.l(new c(sq2, map));
        }
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    private final void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1973100413")) {
            ipChange.ipc$dispatch("1973100413", new Object[]{this, str});
            return;
        }
        kr1 a2 = kr1.Companion.a();
        BaseActivity<?, ?> baseActivity = this.a;
        String c2 = d20.c();
        k21.h(c2, "getCityId()");
        a2.o(baseActivity, c2, str, null);
    }

    private final Object h(MainAlertEntity.MainAlertModel mainAlertModel, MainAlertEntity mainAlertEntity, String str, boolean z, Map<String, ? extends JSONObject> map, Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-415076913")) {
            return ipChange.ipc$dispatch("-415076913", new Object[]{this, mainAlertModel, mainAlertEntity, str, Boolean.valueOf(z), map, continuation});
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        sq2 sq2 = new sq2(this.a);
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        cn.damai.common.image.a.b().c(mainAlertModel.imageUrl).e(new e(q32)).n(new f(this, ref$ObjectRef, z, str, q32, mainAlertModel, map, sq2, mainAlertEntity)).f();
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    private final Object i(MainAlertEntity mainAlertEntity, String str, boolean z, Map<String, ? extends JSONObject> map, Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99647947")) {
            return ipChange.ipc$dispatch("99647947", new Object[]{this, mainAlertEntity, str, Boolean.valueOf(z), map, continuation});
        }
        MainAlertEntity.MainAlertModel mainAlertModel = mainAlertEntity.item;
        if (mainAlertModel != null) {
            k21.h(mainAlertModel, "mMainAlertEntity.item");
            if (k21.d("7", mainAlertEntity.type)) {
                return j(mainAlertModel, str, z, map, continuation);
            }
            return h(mainAlertModel, mainAlertEntity, str, z, map, continuation);
        }
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        Result.a aVar = Result.Companion;
        q32.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    private final Object j(MainAlertEntity.MainAlertModel mainAlertModel, String str, boolean z, Map<String, ? extends JSONObject> map, Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1491691689")) {
            return ipChange.ipc$dispatch("-1491691689", new Object[]{this, mainAlertModel, str, Boolean.valueOf(z), map, continuation});
        }
        sq2 sq2 = new sq2(this.a);
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        cn.damai.common.image.a.b().c(mainAlertModel.imageUrl).e(new g(q32)).n(new MiddlePriortyHandle$showDnaProtocolDialog$2$2(this, mainAlertModel, z, str, q32, map, sq2)).f();
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    private final Object k(CouponListResponse.ContentList contentList, Map<String, ? extends JSONObject> map, Continuation<? super jr1> continuation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604731695")) {
            return ipChange.ipc$dispatch("-1604731695", new Object[]{this, contentList, map, continuation});
        }
        sq2 sq2 = new sq2(this.a);
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        HomepageEvaluateDialog homepageEvaluateDialog = new HomepageEvaluateDialog(this.a, contentList, 1010, new j(q32));
        if (map != null) {
            homepageEvaluateDialog.t(new h(sq2, map));
        }
        homepageEvaluateDialog.s(new i(this));
        if (!this.a.isFinishing()) {
            homepageEvaluateDialog.show();
        } else {
            Result.a aVar = Result.Companion;
            q32.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x007b, code lost:
        if (r10 == null) goto L_0x007d;
     */
    private final Object l(HomeWantSeeBean homeWantSeeBean, String str, boolean z, Map<String, ? extends JSONObject> map, Continuation<? super jr1> continuation) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "236187336")) {
            return ipChange.ipc$dispatch("236187336", new Object[]{this, homeWantSeeBean, str, Boolean.valueOf(z), map, continuation});
        }
        sq2 sq2 = new sq2(this.a);
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        if (homeWantSeeBean != null) {
            WantSeePosterTips.b.C0037b bVar = WantSeePosterTips.b.C0037b.INSTANCE;
            bVar.u(homeWantSeeBean.title);
            bVar.v(homeWantSeeBean.titleSuffix);
            bVar.t(homeWantSeeBean.subTitle);
            bVar.r(homeWantSeeBean.verticalPic);
            bVar.p(homeWantSeeBean.schema);
            WantSeePosterTips wantSeePosterTips = this.b;
            if (wantSeePosterTips != null) {
                wantSeePosterTips.setPageSource(bVar);
                wantSeePosterTips.setListener(new k(z, str, this, sq2, map, q32));
                wantSeePosterTips.showAnim();
                obj = wantSeePosterTips;
            } else {
                Result.a aVar = Result.Companion;
                q32.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
                obj = ur2.INSTANCE;
            }
        }
        Result.a aVar2 = Result.Companion;
        q32.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        ur2 ur2 = ur2.INSTANCE;
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    public final void g(PopupCallback popupCallback, WantSeePosterTips wantSeePosterTips) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276126731")) {
            ipChange.ipc$dispatch("-1276126731", new Object[]{this, popupCallback, wantSeePosterTips});
            return;
        }
        this.c = popupCallback;
        this.b = wantSeePosterTips;
    }

    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    public <T, K> Object popHandle(T t, K k2, Continuation<? super jr1> continuation) {
        ArrayList<PopupDetailBean> arrayList;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "636582814")) {
            return ipChange.ipc$dispatch("636582814", new Object[]{this, t, k2, continuation});
        }
        T t2 = t instanceof PopupResponseBean ? t : null;
        if (t2 == null) {
            return jr1.c.INSTANCE;
        }
        PopupCallback popupCallback = this.c;
        if (popupCallback != null) {
            popupCallback.showLottie();
        }
        PopupCallback popupCallback2 = this.c;
        if (popupCallback2 == null || true != popupCallback2.isHomePageTab()) {
            z = false;
        }
        if (!z || (arrayList = t2.show) == null) {
            return jr1.c.INSTANCE;
        }
        Object d2 = d(arrayList, continuation);
        return d2 == kotlin.coroutines.intrinsics.b.d() ? d2 : (jr1) d2;
    }
}
