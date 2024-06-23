package com.alibaba.yymidservice.popup.popupcenter.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.R$style;
import com.alibaba.yymidservice.popup.popupcenter.view.PicDialog;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.if1;
import tb.jr1;
import tb.k12;
import tb.k21;
import tb.kr1;
import tb.l70;
import tb.or1;
import tb.p30;
import tb.q32;
import tb.sq2;
import tb.ur2;

/* compiled from: Taobao */
public final class PopupDialogKt {

    /* compiled from: Taobao */
    public static final class a extends PictureGaiaXEventProvider {
        final /* synthetic */ PicDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(PicDialog picDialog, Activity activity) {
            super(activity);
            this.a = picDialog;
        }

        @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
        public void onGaiaXEvent(@NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i) {
            k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
            this.a.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class b implements DialogInterface.OnDismissListener {
        final /* synthetic */ PopupDetailBean a;
        final /* synthetic */ Activity b;
        final /* synthetic */ Continuation<jr1> c;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.coroutines.Continuation<? super tb.jr1> */
        /* JADX WARN: Multi-variable type inference failed */
        b(PopupDetailBean popupDetailBean, Activity activity, Continuation<? super jr1> continuation) {
            this.a = popupDetailBean;
            this.b = activity;
            this.c = continuation;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.a.needReport) {
                kr1.a aVar = kr1.Companion;
                aVar.a().o(this.b, aVar.a().e(), this.a.pkId, null);
            }
            Continuation<jr1> continuation = this.c;
            Result.a aVar2 = Result.Companion;
            continuation.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        }
    }

    /* compiled from: Taobao */
    public static final class c implements PicDialog.OnDialogShowTimeListener {
        final /* synthetic */ sq2 a;
        final /* synthetic */ Map<String, JSONObject> b;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
        /* JADX WARN: Multi-variable type inference failed */
        c(sq2 sq2, Map<String, ? extends JSONObject> map) {
            this.a = sq2;
            this.b = map;
        }

        @Override // com.alibaba.yymidservice.popup.popupcenter.view.PicDialog.OnDialogShowTimeListener
        public void exposureTime(long j) {
            this.a.exposureUt(j, null, this.b);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Nullable
    public static final Object a(@NotNull Activity activity, @Nullable PopupResponseBean popupResponseBean, @NotNull Continuation<? super jr1> continuation) {
        PopupDialogKt$showDialog$1 popupDialogKt$showDialog$1;
        int i;
        jr1 jr1;
        if (continuation instanceof PopupDialogKt$showDialog$1) {
            popupDialogKt$showDialog$1 = (PopupDialogKt$showDialog$1) continuation;
            int i2 = popupDialogKt$showDialog$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                popupDialogKt$showDialog$1.label = i2 - Integer.MIN_VALUE;
                Object obj = popupDialogKt$showDialog$1.result;
                Object obj2 = kotlin.coroutines.intrinsics.b.d();
                i = popupDialogKt$showDialog$1.label;
                if (i != 0) {
                    k12.b(obj);
                    if (popupResponseBean == null) {
                        jr1 = null;
                        if (jr1 != null) {
                            return jr1;
                        }
                        popupDialogKt$showDialog$1.L$0 = null;
                        popupDialogKt$showDialog$1.label = 2;
                        obj = d(activity, popupDialogKt$showDialog$1);
                        if (obj == obj2) {
                            return obj2;
                        }
                        return (jr1) obj;
                    }
                    ArrayList<PopupDetailBean> arrayList = popupResponseBean.show;
                    popupDialogKt$showDialog$1.L$0 = activity;
                    popupDialogKt$showDialog$1.label = 1;
                    obj = b(activity, arrayList, popupDialogKt$showDialog$1);
                    if (obj == obj2) {
                        return obj2;
                    }
                } else if (i == 1) {
                    activity = (Activity) popupDialogKt$showDialog$1.L$0;
                    k12.b(obj);
                } else if (i == 2) {
                    k12.b(obj);
                    return (jr1) obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jr1 = (jr1) obj;
                if (jr1 != null) {
                }
            }
        }
        popupDialogKt$showDialog$1 = new PopupDialogKt$showDialog$1(continuation);
        Object obj3 = popupDialogKt$showDialog$1.result;
        Object obj22 = kotlin.coroutines.intrinsics.b.d();
        i = popupDialogKt$showDialog$1.label;
        if (i != 0) {
        }
        jr1 = (jr1) obj3;
        if (jr1 != null) {
        }
    }

    private static final Object b(Activity activity, ArrayList<PopupDetailBean> arrayList, Continuation<? super jr1> continuation) {
        PopupDetailBean popupDetailBean;
        if (arrayList == null || arrayList.size() <= 0 || (popupDetailBean = arrayList.get(0)) == null) {
            return d(activity, continuation);
        }
        return c(activity, popupDetailBean, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f6  */
    private static final Object c(Activity activity, PopupDetailBean popupDetailBean, Continuation<? super jr1> continuation) {
        DialogCustomView dialogCustomView;
        sq2 sq2;
        Map map;
        PicDialog picDialog;
        Object a2;
        String str;
        Object obj;
        String str2;
        String str3;
        Exception e;
        DialogCustomView dialogCustomView2;
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        PicDialog picDialog2 = new PicDialog(activity, R$style.pic_translucent_dialog_style);
        List<DialogCustomView> i = kr1.Companion.a().i(activity);
        sq2 sq22 = new sq2(activity);
        PopupDetailBean.PopupItem popupItem = popupDetailBean.item;
        ur2 ur2 = null;
        Object obj2 = (popupItem == null || (jSONObject = popupItem.value) == null) ? null : jSONObject.get("action");
        Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
        if (i == null) {
            i = null;
            dialogCustomView = null;
        } else {
            if (i.size() > 0) {
                dialogCustomView2 = i.get(0);
                dialogCustomView2.bindData(popupDetailBean);
                hashMap.put("isGaiax", "false");
                hashMap.put("type", "业务注入自定义view");
                String simpleName = dialogCustomView2.getClass().getSimpleName();
                k21.h(simpleName, "view::class.java.simpleName");
                hashMap.put("view", simpleName);
            } else {
                dialogCustomView2 = null;
            }
            dialogCustomView = dialogCustomView2;
        }
        if (i == null) {
            PopupDetailBean.PopupItem popupItem2 = popupDetailBean.item;
            if (popupItem2 == null || (str2 = popupItem2.templateUrl) == null) {
                obj = "msg";
                map = map2;
                sq2 = sq22;
                picDialog = picDialog2;
                str = null;
            } else {
                try {
                    hashMap.put("isGaiax", "true");
                    hashMap.put("type", "Gaiax模版");
                    hashMap.put("templateUrl", str2);
                    Uri parse = Uri.parse(str2);
                    String queryParameter = parse.getQueryParameter(if1.DIMEN_BIZ);
                    String queryParameter2 = parse.getQueryParameter("templateId");
                    String queryParameter3 = parse.getQueryParameter("templateVersion");
                    if (queryParameter2 == null) {
                        str3 = str2;
                        obj = "msg";
                        map = map2;
                        sq2 = sq22;
                        picDialog = picDialog2;
                    } else {
                        l70.a aVar = l70.Companion;
                        PopupDetailBean.PopupItem popupItem3 = popupDetailBean.item;
                        str3 = str2;
                        map = map2;
                        sq2 = sq22;
                        picDialog = picDialog2;
                        try {
                            View b2 = l70.a.b(aVar, activity, queryParameter, queryParameter2, queryParameter3, popupItem3 == null ? null : popupItem3.value, 0.0f, new a(picDialog2, activity), true, true, 32, null);
                            FrameLayout frameLayout = b2 instanceof FrameLayout ? (FrameLayout) b2 : null;
                            if (frameLayout == null) {
                                obj = "msg";
                            } else {
                                if (frameLayout.getChildCount() > 0) {
                                    obj = "msg";
                                    try {
                                        hashMap.put(obj, "模版加载成功");
                                        dialogCustomView = b2;
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        hashMap.put("Exception", ur2.INSTANCE.toString());
                                        e.printStackTrace();
                                        str = str3;
                                        if (str == null) {
                                        }
                                        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
                                        if (dialogCustomView == null) {
                                        }
                                        if (ur2 == null) {
                                        }
                                        ur2 ur22 = ur2.INSTANCE;
                                        a2 = q32.a();
                                        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
                                        }
                                        return a2;
                                    }
                                } else {
                                    obj = "msg";
                                    hashMap.put(obj, "模版加载失败");
                                    dialogCustomView = null;
                                }
                                ur2 ur23 = ur2.INSTANCE;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            obj = "msg";
                            e.printStackTrace();
                            hashMap.put("Exception", ur2.INSTANCE.toString());
                            e.printStackTrace();
                            str = str3;
                            if (str == null) {
                            }
                            q32 q322 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
                            if (dialogCustomView == null) {
                            }
                            if (ur2 == null) {
                            }
                            ur2 ur222 = ur2.INSTANCE;
                            a2 = q322.a();
                            if (a2 == kotlin.coroutines.intrinsics.b.d()) {
                            }
                            return a2;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    str3 = str2;
                    obj = "msg";
                    map = map2;
                    sq2 = sq22;
                    picDialog = picDialog2;
                    e.printStackTrace();
                    hashMap.put("Exception", ur2.INSTANCE.toString());
                    e.printStackTrace();
                    str = str3;
                    if (str == null) {
                    }
                    q32 q3222 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
                    if (dialogCustomView == null) {
                    }
                    if (ur2 == null) {
                    }
                    ur2 ur2222 = ur2.INSTANCE;
                    a2 = q3222.a();
                    if (a2 == kotlin.coroutines.intrinsics.b.d()) {
                    }
                    return a2;
                }
                str = str3;
            }
            if (str == null) {
                hashMap.put(obj, "templateUrl模版为null");
                ur2 ur24 = ur2.INSTANCE;
            }
        } else {
            map = map2;
            sq2 = sq22;
            picDialog = picDialog2;
        }
        q32 q32222 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        if (dialogCustomView == null) {
            picDialog.setCanceledOnTouchOutside(false);
            picDialog.setContentView(dialogCustomView);
            picDialog.setOnDismissListener(new b(popupDetailBean, activity, q32222));
            picDialog.h(new c(sq2, map));
            if (!activity.isFinishing()) {
                hashMap.put("popup_show", "弹窗正常展示");
                String simpleName2 = activity.getClass().getSimpleName();
                k21.h(simpleName2, "context::class.java.simpleName");
                or1.g(simpleName2, "popupDialog", "success", hashMap);
                picDialog.show();
            } else {
                hashMap.put("popup_show", "弹窗Activity停止");
                String simpleName3 = activity.getClass().getSimpleName();
                k21.h(simpleName3, "context::class.java.simpleName");
                or1.g(simpleName3, "popupDialog", "fail", hashMap);
                Result.a aVar2 = Result.Companion;
                q32222.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            }
            ur2 = ur2.INSTANCE;
        }
        if (ur2 == null) {
            hashMap.put("popup_show", "弹窗view加载为null");
            String simpleName4 = activity.getClass().getSimpleName();
            k21.h(simpleName4, "context::class.java.simpleName");
            or1.g(simpleName4, "popupDialog", "fail", hashMap);
            Result.a aVar3 = Result.Companion;
            q32222.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
            ur2 ur25 = ur2.INSTANCE;
        }
        ur2 ur22222 = ur2.INSTANCE;
        a2 = q32222.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }

    private static final Object d(Activity activity, Continuation<? super jr1> continuation) {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", "数据不满足需求");
        String simpleName = activity.getClass().getSimpleName();
        k21.h(simpleName, "context::class.java.simpleName");
        or1.g(simpleName, "popupDialog", "fail", hashMap);
        q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        Result.a aVar = Result.Companion;
        q32.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
        Object a2 = q32.a();
        if (a2 == kotlin.coroutines.intrinsics.b.d()) {
            p30.c(continuation);
        }
        return a2;
    }
}
