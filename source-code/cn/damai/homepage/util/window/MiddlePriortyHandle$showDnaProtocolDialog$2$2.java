package cn.damai.homepage.util.window;

import android.content.DialogInterface;
import android.text.TextUtils;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.MainAlertEntity;
import cn.damai.uikit.view.DMProtocolDialog;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import tb.a03;
import tb.aa0;
import tb.ax0;
import tb.jr1;
import tb.k21;
import tb.sq2;
import tb.tj;

/* compiled from: Taobao */
public final class MiddlePriortyHandle$showDnaProtocolDialog$2$2 implements DMImageCreator.DMImageSuccListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ MiddlePriortyHandle a;
    final /* synthetic */ MainAlertEntity.MainAlertModel b;
    final /* synthetic */ boolean c;
    final /* synthetic */ String d;
    final /* synthetic */ Continuation<jr1> e;
    final /* synthetic */ Map<String, JSONObject> f;
    final /* synthetic */ sq2 g;

    /* compiled from: Taobao */
    public static final class a implements DMProtocolDialog.OnDialogShowTimeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Map<String, JSONObject> a;
        final /* synthetic */ sq2 b;
        final /* synthetic */ MainAlertEntity.MainAlertModel c;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
        /* JADX WARN: Multi-variable type inference failed */
        a(Map<String, ? extends JSONObject> map, sq2 sq2, MainAlertEntity.MainAlertModel mainAlertModel) {
            this.a = map;
            this.b = sq2;
            this.c = mainAlertModel;
        }

        @Override // cn.damai.uikit.view.DMProtocolDialog.OnDialogShowTimeListener
        public final void exposureTime(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-738702958")) {
                ipChange.ipc$dispatch("-738702958", new Object[]{this, Long.valueOf(j)});
                return;
            }
            Map<String, JSONObject> map = this.a;
            if (map != null) {
                this.b.exposureUt(j, a03.f(), map);
                return;
            }
            MainAlertEntity.MainAlertModel mainAlertModel = this.c;
            ax0.p(j, mainAlertModel.schema, String.valueOf(mainAlertModel.circleId), "1", null);
        }
    }

    /* compiled from: Taobao */
    public static final class b implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Continuation<jr1> a;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super jr1> continuation) {
            this.a = continuation;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-654933266")) {
                ipChange.ipc$dispatch("-654933266", new Object[]{this, dialogInterface});
                return;
            }
            Continuation<jr1> continuation = this.a;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
    /* JADX WARN: Multi-variable type inference failed */
    MiddlePriortyHandle$showDnaProtocolDialog$2$2(MiddlePriortyHandle middlePriortyHandle, MainAlertEntity.MainAlertModel mainAlertModel, boolean z, String str, Continuation<? super jr1> continuation, Map<String, ? extends JSONObject> map, sq2 sq2) {
        this.a = middlePriortyHandle;
        this.b = mainAlertModel;
        this.c = z;
        this.d = str;
        this.e = continuation;
        this.f = map;
        this.g = sq2;
    }

    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
    public final void onSuccess(DMImageCreator.e eVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "481822480")) {
            ipChange.ipc$dispatch("481822480", new Object[]{this, eVar});
        } else if (MiddlePriortyHandle.b(this.a).isActivityFinsihed() || !MiddlePriortyHandle.b(this.a).isActivityForeground() || eVar.b == null) {
            Continuation<jr1> continuation = this.e;
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        } else {
            List<MainAlertEntity.MainAlertContentListItem> list = this.b.contentList;
            if (list == null || list.size() <= 0) {
                Continuation<jr1> continuation2 = this.e;
                Result.a aVar2 = Result.Companion;
                continuation2.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
                return;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.b.contentList.size();
            for (int i = 0; i < size; i++) {
                aa0 aa0 = new aa0();
                aa0.h(tj.b(this.b.titleColor));
                aa0.g(this.b.contentList.get(i).content);
                if (k21.d("1", this.b.contentList.get(i).contentType)) {
                    aa0.i(true);
                    aa0.l(this.b.protocolName);
                    aa0.j(tj.b(this.b.protocolColor));
                    aa0.k(this.b.protocolLink);
                }
                arrayList.add(aa0);
            }
            DMProtocolDialog n = new DMProtocolDialog(MiddlePriortyHandle.b(this.a)).r(DMProtocolDialog.DMDialogTheme.THEME_DNA).o(arrayList).m(eVar.b).p(new MiddlePriortyHandle$showDnaProtocolDialog$2$2$dialog$1(this.f, this.a, this.g, this.b)).n(false);
            n.q(new a(this.f, this.g, this.b));
            n.setOnDismissListener(new b(this.e));
            if (!MiddlePriortyHandle.b(this.a).isFinishing()) {
                n.show();
                if (this.c && !TextUtils.isEmpty(this.d)) {
                    MiddlePriortyHandle.c(this.a, this.d);
                    return;
                }
                return;
            }
            Continuation<jr1> continuation3 = this.e;
            Result.a aVar3 = Result.Companion;
            continuation3.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }
}
