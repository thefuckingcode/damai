package com.alibaba.yymidservice.popup.popupcenter;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.popupcenter.view.MiddlePriortyDefaultHandle;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bo1;
import tb.jr1;
import tb.k12;
import tb.k21;
import tb.lr1;
import tb.or1;
import tb.pr1;
import tb.ur2;

/* compiled from: Taobao */
public final class PopupPriorityManager {
    @NotNull
    private Activity a;
    @Nullable
    private pr1 b;
    @Nullable
    private pr1 c;
    @Nullable
    private MiddlePriortyDefaultHandle d;
    @Nullable
    private pr1 e;
    @Nullable
    private pr1 f;
    @NotNull
    private InterceptType g = InterceptType.SAMEAPPEAR;
    @NotNull
    private lr1<PopupResponseBean> h = new lr1<>();
    @NotNull
    private lr1<JSONObject> i = new lr1<>();
    @NotNull
    private lr1<JSONObject> j = new lr1<>();
    @NotNull
    private lr1<JSONObject> k = new lr1<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/yymidservice/popup/popupcenter/PopupPriorityManager$InterceptType;", "", "<init>", "(Ljava/lang/String;I)V", "PREAPPEAR", "SAMEAPPEAR", "POSRAPPEAR", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public enum InterceptType {
        PREAPPEAR,
        SAMEAPPEAR,
        POSRAPPEAR
    }

    public PopupPriorityManager(@NotNull Activity activity) {
        k21.i(activity, WPKFactory.INIT_KEY_CONTEXT);
        this.a = activity;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    public final Object g(PopupResponseBean popupResponseBean, jr1 jr1, Continuation<? super ur2> continuation) {
        PopupPriorityManager$interceptAction$1 popupPriorityManager$interceptAction$1;
        int i2;
        if (continuation instanceof PopupPriorityManager$interceptAction$1) {
            popupPriorityManager$interceptAction$1 = (PopupPriorityManager$interceptAction$1) continuation;
            int i3 = popupPriorityManager$interceptAction$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                popupPriorityManager$interceptAction$1.label = i3 - Integer.MIN_VALUE;
                Object obj = popupPriorityManager$interceptAction$1.result;
                Object obj2 = b.d();
                i2 = popupPriorityManager$interceptAction$1.label;
                if (i2 != 0) {
                    k12.b(obj);
                    pr1 f2 = f();
                    if (f2 != null) {
                        popupPriorityManager$interceptAction$1.label = 1;
                        obj = f2.popHandle(popupResponseBean, jr1, popupPriorityManager$interceptAction$1);
                        if (obj == obj2) {
                            return obj2;
                        }
                    }
                    return ur2.INSTANCE;
                } else if (i2 == 1) {
                    k12.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jr1 jr12 = (jr1) obj;
                return ur2.INSTANCE;
            }
        }
        popupPriorityManager$interceptAction$1 = new PopupPriorityManager$interceptAction$1(this, continuation);
        Object obj3 = popupPriorityManager$interceptAction$1.result;
        Object obj22 = b.d();
        i2 = popupPriorityManager$interceptAction$1.label;
        if (i2 != 0) {
        }
        jr1 jr122 = (jr1) obj3;
        return ur2.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        if (tb.k21.d(r11, r6) != false) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public final Object h(jr1 jr1, Continuation<? super jr1> continuation) {
        PopupPriorityManager$lastHandle$1 popupPriorityManager$lastHandle$1;
        int i2;
        jr1 jr12;
        PopupPriorityManager popupPriorityManager;
        PopupPriorityManager popupPriorityManager2;
        pr1 pr1;
        if (continuation instanceof PopupPriorityManager$lastHandle$1) {
            popupPriorityManager$lastHandle$1 = (PopupPriorityManager$lastHandle$1) continuation;
            int i3 = popupPriorityManager$lastHandle$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                popupPriorityManager$lastHandle$1.label = i3 - Integer.MIN_VALUE;
                Object obj = popupPriorityManager$lastHandle$1.result;
                Object obj2 = b.d();
                i2 = popupPriorityManager$lastHandle$1.label;
                if (i2 != 0) {
                    k12.b(obj);
                    lr1<JSONObject> lr1 = this.j;
                    popupPriorityManager$lastHandle$1.L$0 = this;
                    popupPriorityManager$lastHandle$1.L$1 = jr1;
                    popupPriorityManager$lastHandle$1.label = 1;
                    obj = lr1.a(popupPriorityManager$lastHandle$1);
                    if (obj == obj2) {
                        return obj2;
                    }
                    popupPriorityManager = this;
                } else if (i2 == 1) {
                    jr1 = (jr1) popupPriorityManager$lastHandle$1.L$1;
                    popupPriorityManager = (PopupPriorityManager) popupPriorityManager$lastHandle$1.L$0;
                    k12.b(obj);
                } else if (i2 == 2) {
                    popupPriorityManager2 = (PopupPriorityManager) popupPriorityManager$lastHandle$1.L$0;
                    k12.b(obj);
                    popupPriorityManager = popupPriorityManager2;
                    jr12 = (jr1) obj;
                    if (jr12 == null) {
                        jr12 = jr1.c.INSTANCE;
                    }
                    popupPriorityManager.e = null;
                    return jr12;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                JSONObject jSONObject = (JSONObject) obj;
                HashMap hashMap = new HashMap();
                if (jr1 != null) {
                    jr12 = jr1.c.INSTANCE;
                }
                pr1 = popupPriorityManager.e;
                if (pr1 != null) {
                    jr12 = null;
                    if (jr12 == null) {
                    }
                    popupPriorityManager.e = null;
                    return jr12;
                }
                hashMap.put("head_task", "执行尾部任务");
                String simpleName = popupPriorityManager.a.getClass().getSimpleName();
                k21.h(simpleName, "mContent::class.java.simpleName");
                or1.g(simpleName, AgooConstants.MESSAGE_POPUP, "lastHandle", hashMap);
                popupPriorityManager$lastHandle$1.L$0 = popupPriorityManager;
                popupPriorityManager$lastHandle$1.L$1 = null;
                popupPriorityManager$lastHandle$1.label = 2;
                obj = pr1.popHandle(jSONObject, jr1, popupPriorityManager$lastHandle$1);
                if (obj == obj2) {
                    return obj2;
                }
                popupPriorityManager2 = popupPriorityManager;
                popupPriorityManager = popupPriorityManager2;
                jr12 = (jr1) obj;
                if (jr12 == null) {
                }
                popupPriorityManager.e = null;
                return jr12;
            }
        }
        popupPriorityManager$lastHandle$1 = new PopupPriorityManager$lastHandle$1(this, continuation);
        Object obj3 = popupPriorityManager$lastHandle$1.result;
        Object obj22 = b.d();
        i2 = popupPriorityManager$lastHandle$1.label;
        if (i2 != 0) {
        }
        JSONObject jSONObject2 = (JSONObject) obj3;
        HashMap hashMap2 = new HashMap();
        if (jr1 != null) {
        }
        pr1 = popupPriorityManager.e;
        if (pr1 != null) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0113, code lost:
        if (tb.k21.d(r10, r6) != false) goto L_0x0115;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01d3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    public final Object j(jr1 jr1, Continuation<? super jr1> continuation) {
        PopupPriorityManager$middleHandle$1 popupPriorityManager$middleHandle$1;
        jr1 jr12;
        PopupPriorityManager popupPriorityManager;
        lr1<JSONObject> lr1;
        HashMap hashMap;
        jr1 jr13;
        PopupPriorityManager popupPriorityManager2;
        PopupResponseBean popupResponseBean;
        HashMap hashMap2;
        PopupPriorityManager popupPriorityManager3;
        jr1 jr14;
        pr1 pr1;
        PopupResponseBean popupResponseBean2;
        jr1 jr15;
        lr1<JSONObject> lr12;
        if (continuation instanceof PopupPriorityManager$middleHandle$1) {
            popupPriorityManager$middleHandle$1 = (PopupPriorityManager$middleHandle$1) continuation;
            int i2 = popupPriorityManager$middleHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                popupPriorityManager$middleHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = popupPriorityManager$middleHandle$1.result;
                Object obj2 = b.d();
                switch (popupPriorityManager$middleHandle$1.label) {
                    case 0:
                        k12.b(obj);
                        lr1<PopupResponseBean> lr13 = this.h;
                        popupPriorityManager$middleHandle$1.L$0 = this;
                        popupPriorityManager$middleHandle$1.L$1 = jr1;
                        popupPriorityManager$middleHandle$1.label = 1;
                        obj = lr13.a(popupPriorityManager$middleHandle$1);
                        if (obj == obj2) {
                            return obj2;
                        }
                        popupPriorityManager2 = this;
                        PopupResponseBean popupResponseBean3 = (PopupResponseBean) obj;
                        if (popupPriorityManager2.e() != InterceptType.PREAPPEAR) {
                            popupPriorityManager$middleHandle$1.L$0 = popupPriorityManager2;
                            popupPriorityManager$middleHandle$1.L$1 = jr1;
                            popupPriorityManager$middleHandle$1.L$2 = popupResponseBean3;
                            popupPriorityManager$middleHandle$1.label = 2;
                            if (popupPriorityManager2.g(popupResponseBean3, jr1, popupPriorityManager$middleHandle$1) == obj2) {
                                return obj2;
                            }
                            jr15 = jr1;
                            popupResponseBean2 = popupResponseBean3;
                            lr12 = popupPriorityManager2.k;
                            popupPriorityManager$middleHandle$1.L$0 = popupPriorityManager2;
                            popupPriorityManager$middleHandle$1.L$1 = jr15;
                            popupPriorityManager$middleHandle$1.L$2 = popupResponseBean2;
                            popupPriorityManager$middleHandle$1.label = 3;
                            if (lr12.a(popupPriorityManager$middleHandle$1) == obj2) {
                                return obj2;
                            }
                            popupResponseBean = popupResponseBean2;
                            jr1 = jr15;
                            hashMap2 = new HashMap();
                            if (jr1 != null) {
                                jr13 = jr1.c.INSTANCE;
                                break;
                            }
                            pr1 = popupPriorityManager2.c;
                            if (pr1 == null) {
                                hashMap = hashMap2;
                                jr13 = null;
                                if (jr13 == null) {
                                    hashMap.put("middle_task", "执行业务默认任务");
                                    MiddlePriortyDefaultHandle middlePriortyDefaultHandle = popupPriorityManager2.d;
                                    if (middlePriortyDefaultHandle == null) {
                                        hashMap2 = hashMap;
                                        jr13 = null;
                                        popupPriorityManager = popupPriorityManager2;
                                        String simpleName = popupPriorityManager.a.getClass().getSimpleName();
                                        k21.h(simpleName, "mContent::class.java.simpleName");
                                        or1.g(simpleName, AgooConstants.MESSAGE_POPUP, "middleHandle", hashMap2);
                                        popupPriorityManager.c = null;
                                        popupPriorityManager.d = null;
                                        if (popupPriorityManager.e() == InterceptType.POSRAPPEAR) {
                                            return jr13;
                                        }
                                        popupPriorityManager$middleHandle$1.L$0 = popupPriorityManager;
                                        popupPriorityManager$middleHandle$1.L$1 = jr13;
                                        popupPriorityManager$middleHandle$1.L$2 = null;
                                        popupPriorityManager$middleHandle$1.label = 8;
                                        if (popupPriorityManager.g(popupResponseBean, jr13, popupPriorityManager$middleHandle$1) == obj2) {
                                            return obj2;
                                        }
                                        jr12 = jr13;
                                        lr1 = popupPriorityManager.k;
                                        popupPriorityManager$middleHandle$1.L$0 = jr12;
                                        popupPriorityManager$middleHandle$1.L$1 = null;
                                        popupPriorityManager$middleHandle$1.label = 9;
                                        if (lr1.a(popupPriorityManager$middleHandle$1) == obj2) {
                                            return obj2;
                                        }
                                        return jr12;
                                    }
                                    popupPriorityManager$middleHandle$1.L$0 = popupPriorityManager2;
                                    popupPriorityManager$middleHandle$1.L$1 = popupResponseBean;
                                    popupPriorityManager$middleHandle$1.L$2 = hashMap;
                                    popupPriorityManager$middleHandle$1.label = 7;
                                    obj = middlePriortyDefaultHandle.popHandle(popupResponseBean, null, popupPriorityManager$middleHandle$1);
                                    if (obj == obj2) {
                                        return obj2;
                                    }
                                    popupPriorityManager3 = popupPriorityManager2;
                                    jr13 = (jr1) obj;
                                    popupPriorityManager2 = popupPriorityManager3;
                                }
                                hashMap2 = hashMap;
                                popupPriorityManager = popupPriorityManager2;
                                String simpleName2 = popupPriorityManager.a.getClass().getSimpleName();
                                k21.h(simpleName2, "mContent::class.java.simpleName");
                                or1.g(simpleName2, AgooConstants.MESSAGE_POPUP, "middleHandle", hashMap2);
                                popupPriorityManager.c = null;
                                popupPriorityManager.d = null;
                                if (popupPriorityManager.e() == InterceptType.POSRAPPEAR) {
                                }
                            } else {
                                hashMap2.put("middle_task", "执行业务注入任务");
                                if (or1.e(popupResponseBean)) {
                                    hashMap2.put("isGaiax", "true");
                                    MiddlePriortyDefaultHandle middlePriortyDefaultHandle2 = popupPriorityManager2.d;
                                    if (middlePriortyDefaultHandle2 == null) {
                                        hashMap = hashMap2;
                                        jr14 = null;
                                        jr13 = jr14;
                                        if (jr13 == null) {
                                        }
                                        hashMap2 = hashMap;
                                        popupPriorityManager = popupPriorityManager2;
                                        String simpleName22 = popupPriorityManager.a.getClass().getSimpleName();
                                        k21.h(simpleName22, "mContent::class.java.simpleName");
                                        or1.g(simpleName22, AgooConstants.MESSAGE_POPUP, "middleHandle", hashMap2);
                                        popupPriorityManager.c = null;
                                        popupPriorityManager.d = null;
                                        if (popupPriorityManager.e() == InterceptType.POSRAPPEAR) {
                                        }
                                    } else {
                                        popupPriorityManager$middleHandle$1.L$0 = popupPriorityManager2;
                                        popupPriorityManager$middleHandle$1.L$1 = popupResponseBean;
                                        popupPriorityManager$middleHandle$1.L$2 = hashMap2;
                                        popupPriorityManager$middleHandle$1.label = 5;
                                        Object popHandle = middlePriortyDefaultHandle2.popHandle(popupResponseBean, null, popupPriorityManager$middleHandle$1);
                                        if (popHandle == obj2) {
                                            return obj2;
                                        }
                                        obj = popHandle;
                                        hashMap = hashMap2;
                                        jr14 = (jr1) obj;
                                        jr13 = jr14;
                                        if (jr13 == null) {
                                        }
                                        hashMap2 = hashMap;
                                        popupPriorityManager = popupPriorityManager2;
                                        String simpleName222 = popupPriorityManager.a.getClass().getSimpleName();
                                        k21.h(simpleName222, "mContent::class.java.simpleName");
                                        or1.g(simpleName222, AgooConstants.MESSAGE_POPUP, "middleHandle", hashMap2);
                                        popupPriorityManager.c = null;
                                        popupPriorityManager.d = null;
                                        if (popupPriorityManager.e() == InterceptType.POSRAPPEAR) {
                                        }
                                    }
                                } else {
                                    hashMap2.put("isGaiax", "false");
                                    popupPriorityManager$middleHandle$1.L$0 = popupPriorityManager2;
                                    popupPriorityManager$middleHandle$1.L$1 = popupResponseBean;
                                    popupPriorityManager$middleHandle$1.L$2 = hashMap2;
                                    popupPriorityManager$middleHandle$1.label = 6;
                                    Object popHandle2 = pr1.popHandle(popupResponseBean, null, popupPriorityManager$middleHandle$1);
                                    if (popHandle2 == obj2) {
                                        return obj2;
                                    }
                                    obj = popHandle2;
                                    hashMap = hashMap2;
                                    jr14 = (jr1) obj;
                                    jr13 = jr14;
                                    if (jr13 == null) {
                                    }
                                    hashMap2 = hashMap;
                                    popupPriorityManager = popupPriorityManager2;
                                    String simpleName2222 = popupPriorityManager.a.getClass().getSimpleName();
                                    k21.h(simpleName2222, "mContent::class.java.simpleName");
                                    or1.g(simpleName2222, AgooConstants.MESSAGE_POPUP, "middleHandle", hashMap2);
                                    popupPriorityManager.c = null;
                                    popupPriorityManager.d = null;
                                    if (popupPriorityManager.e() == InterceptType.POSRAPPEAR) {
                                    }
                                }
                            }
                        } else if (popupPriorityManager2.e() == InterceptType.SAMEAPPEAR) {
                            popupPriorityManager$middleHandle$1.L$0 = popupPriorityManager2;
                            popupPriorityManager$middleHandle$1.L$1 = jr1;
                            popupPriorityManager$middleHandle$1.L$2 = popupResponseBean3;
                            popupPriorityManager$middleHandle$1.label = 4;
                            if (popupPriorityManager2.g(popupResponseBean3, jr1, popupPriorityManager$middleHandle$1) == obj2) {
                                return obj2;
                            }
                            jr15 = jr1;
                            popupResponseBean2 = popupResponseBean3;
                            popupResponseBean = popupResponseBean2;
                            jr1 = jr15;
                            hashMap2 = new HashMap();
                            if (jr1 != null) {
                            }
                            pr1 = popupPriorityManager2.c;
                            if (pr1 == null) {
                            }
                        } else {
                            popupResponseBean = popupResponseBean3;
                            hashMap2 = new HashMap();
                            if (jr1 != null) {
                            }
                            pr1 = popupPriorityManager2.c;
                            if (pr1 == null) {
                            }
                        }
                    case 1:
                        jr1 = (jr1) popupPriorityManager$middleHandle$1.L$1;
                        k12.b(obj);
                        popupPriorityManager2 = (PopupPriorityManager) popupPriorityManager$middleHandle$1.L$0;
                        PopupResponseBean popupResponseBean32 = (PopupResponseBean) obj;
                        if (popupPriorityManager2.e() != InterceptType.PREAPPEAR) {
                        }
                        break;
                    case 2:
                        popupResponseBean2 = (PopupResponseBean) popupPriorityManager$middleHandle$1.L$2;
                        jr15 = (jr1) popupPriorityManager$middleHandle$1.L$1;
                        popupPriorityManager2 = (PopupPriorityManager) popupPriorityManager$middleHandle$1.L$0;
                        k12.b(obj);
                        lr12 = popupPriorityManager2.k;
                        popupPriorityManager$middleHandle$1.L$0 = popupPriorityManager2;
                        popupPriorityManager$middleHandle$1.L$1 = jr15;
                        popupPriorityManager$middleHandle$1.L$2 = popupResponseBean2;
                        popupPriorityManager$middleHandle$1.label = 3;
                        if (lr12.a(popupPriorityManager$middleHandle$1) == obj2) {
                        }
                        popupResponseBean = popupResponseBean2;
                        jr1 = jr15;
                        hashMap2 = new HashMap();
                        if (jr1 != null) {
                        }
                        pr1 = popupPriorityManager2.c;
                        if (pr1 == null) {
                        }
                        break;
                    case 3:
                    case 4:
                        popupResponseBean2 = (PopupResponseBean) popupPriorityManager$middleHandle$1.L$2;
                        jr15 = (jr1) popupPriorityManager$middleHandle$1.L$1;
                        popupPriorityManager2 = (PopupPriorityManager) popupPriorityManager$middleHandle$1.L$0;
                        k12.b(obj);
                        popupResponseBean = popupResponseBean2;
                        jr1 = jr15;
                        hashMap2 = new HashMap();
                        if (jr1 != null) {
                        }
                        pr1 = popupPriorityManager2.c;
                        if (pr1 == null) {
                        }
                        break;
                    case 5:
                        hashMap = (HashMap) popupPriorityManager$middleHandle$1.L$2;
                        popupResponseBean = (PopupResponseBean) popupPriorityManager$middleHandle$1.L$1;
                        popupPriorityManager2 = (PopupPriorityManager) popupPriorityManager$middleHandle$1.L$0;
                        k12.b(obj);
                        jr14 = (jr1) obj;
                        jr13 = jr14;
                        if (jr13 == null) {
                        }
                        hashMap2 = hashMap;
                        popupPriorityManager = popupPriorityManager2;
                        String simpleName22222 = popupPriorityManager.a.getClass().getSimpleName();
                        k21.h(simpleName22222, "mContent::class.java.simpleName");
                        or1.g(simpleName22222, AgooConstants.MESSAGE_POPUP, "middleHandle", hashMap2);
                        popupPriorityManager.c = null;
                        popupPriorityManager.d = null;
                        if (popupPriorityManager.e() == InterceptType.POSRAPPEAR) {
                        }
                        break;
                    case 6:
                        hashMap = (HashMap) popupPriorityManager$middleHandle$1.L$2;
                        popupResponseBean = (PopupResponseBean) popupPriorityManager$middleHandle$1.L$1;
                        popupPriorityManager2 = (PopupPriorityManager) popupPriorityManager$middleHandle$1.L$0;
                        k12.b(obj);
                        jr14 = (jr1) obj;
                        jr13 = jr14;
                        if (jr13 == null) {
                        }
                        hashMap2 = hashMap;
                        popupPriorityManager = popupPriorityManager2;
                        String simpleName222222 = popupPriorityManager.a.getClass().getSimpleName();
                        k21.h(simpleName222222, "mContent::class.java.simpleName");
                        or1.g(simpleName222222, AgooConstants.MESSAGE_POPUP, "middleHandle", hashMap2);
                        popupPriorityManager.c = null;
                        popupPriorityManager.d = null;
                        if (popupPriorityManager.e() == InterceptType.POSRAPPEAR) {
                        }
                        break;
                    case 7:
                        hashMap = (HashMap) popupPriorityManager$middleHandle$1.L$2;
                        popupResponseBean = (PopupResponseBean) popupPriorityManager$middleHandle$1.L$1;
                        popupPriorityManager3 = (PopupPriorityManager) popupPriorityManager$middleHandle$1.L$0;
                        k12.b(obj);
                        jr13 = (jr1) obj;
                        popupPriorityManager2 = popupPriorityManager3;
                        hashMap2 = hashMap;
                        popupPriorityManager = popupPriorityManager2;
                        String simpleName2222222 = popupPriorityManager.a.getClass().getSimpleName();
                        k21.h(simpleName2222222, "mContent::class.java.simpleName");
                        or1.g(simpleName2222222, AgooConstants.MESSAGE_POPUP, "middleHandle", hashMap2);
                        popupPriorityManager.c = null;
                        popupPriorityManager.d = null;
                        if (popupPriorityManager.e() == InterceptType.POSRAPPEAR) {
                        }
                        break;
                    case 8:
                        jr12 = (jr1) popupPriorityManager$middleHandle$1.L$1;
                        popupPriorityManager = (PopupPriorityManager) popupPriorityManager$middleHandle$1.L$0;
                        k12.b(obj);
                        lr1 = popupPriorityManager.k;
                        popupPriorityManager$middleHandle$1.L$0 = jr12;
                        popupPriorityManager$middleHandle$1.L$1 = null;
                        popupPriorityManager$middleHandle$1.label = 9;
                        if (lr1.a(popupPriorityManager$middleHandle$1) == obj2) {
                        }
                        return jr12;
                    case 9:
                        jr12 = (jr1) popupPriorityManager$middleHandle$1.L$0;
                        k12.b(obj);
                        return jr12;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        popupPriorityManager$middleHandle$1 = new PopupPriorityManager$middleHandle$1(this, continuation);
        Object obj3 = popupPriorityManager$middleHandle$1.result;
        Object obj22 = b.d();
        switch (popupPriorityManager$middleHandle$1.label) {
        }
    }

    private final void o() {
        bo1 bo1 = new bo1();
        bo1.d(this);
        bo1.c(new WeakReference<>(this.a));
        bo1.e();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public final Object p(Continuation<? super jr1> continuation) {
        PopupPriorityManager$topHandle$1 popupPriorityManager$topHandle$1;
        int i2;
        Object obj;
        PopupPriorityManager popupPriorityManager;
        PopupPriorityManager popupPriorityManager2;
        pr1 pr1;
        if (continuation instanceof PopupPriorityManager$topHandle$1) {
            popupPriorityManager$topHandle$1 = (PopupPriorityManager$topHandle$1) continuation;
            int i3 = popupPriorityManager$topHandle$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                popupPriorityManager$topHandle$1.label = i3 - Integer.MIN_VALUE;
                Object obj2 = popupPriorityManager$topHandle$1.result;
                Object obj3 = b.d();
                i2 = popupPriorityManager$topHandle$1.label;
                if (i2 != 0) {
                    k12.b(obj2);
                    lr1<JSONObject> lr1 = this.i;
                    popupPriorityManager$topHandle$1.L$0 = this;
                    popupPriorityManager$topHandle$1.label = 1;
                    obj2 = lr1.a(popupPriorityManager$topHandle$1);
                    if (obj2 == obj3) {
                        return obj3;
                    }
                    popupPriorityManager = this;
                } else if (i2 == 1) {
                    popupPriorityManager = (PopupPriorityManager) popupPriorityManager$topHandle$1.L$0;
                    k12.b(obj2);
                } else if (i2 == 2) {
                    popupPriorityManager2 = (PopupPriorityManager) popupPriorityManager$topHandle$1.L$0;
                    k12.b(obj2);
                    obj = (jr1) obj2;
                    popupPriorityManager = popupPriorityManager2;
                    if (obj == null) {
                        obj = jr1.c.INSTANCE;
                    }
                    popupPriorityManager.b = null;
                    return obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                JSONObject jSONObject = (JSONObject) obj2;
                HashMap hashMap = new HashMap();
                pr1 = popupPriorityManager.b;
                if (pr1 != null) {
                    obj = null;
                    if (obj == null) {
                    }
                    popupPriorityManager.b = null;
                    return obj;
                }
                hashMap.put("head_task", "执行头部任务");
                String simpleName = popupPriorityManager.a.getClass().getSimpleName();
                k21.h(simpleName, "mContent::class.java.simpleName");
                or1.g(simpleName, AgooConstants.MESSAGE_POPUP, "topHandle", hashMap);
                popupPriorityManager$topHandle$1.L$0 = popupPriorityManager;
                popupPriorityManager$topHandle$1.label = 2;
                obj2 = pr1.popHandle(jSONObject, null, popupPriorityManager$topHandle$1);
                if (obj2 == obj3) {
                    return obj3;
                }
                popupPriorityManager2 = popupPriorityManager;
                obj = (jr1) obj2;
                popupPriorityManager = popupPriorityManager2;
                if (obj == null) {
                }
                popupPriorityManager.b = null;
                return obj;
            }
        }
        popupPriorityManager$topHandle$1 = new PopupPriorityManager$topHandle$1(this, continuation);
        Object obj22 = popupPriorityManager$topHandle$1.result;
        Object obj32 = b.d();
        i2 = popupPriorityManager$topHandle$1.label;
        if (i2 != 0) {
        }
        JSONObject jSONObject2 = (JSONObject) obj22;
        HashMap hashMap2 = new HashMap();
        pr1 = popupPriorityManager.b;
        if (pr1 != null) {
        }
    }

    @NotNull
    public final InterceptType e() {
        return this.g;
    }

    @Nullable
    public final pr1 f() {
        return this.f;
    }

    public final void i(@Nullable JSONObject jSONObject) {
        this.j.b(jSONObject);
    }

    public final void k(@Nullable PopupResponseBean popupResponseBean) {
        this.h.b(popupResponseBean);
    }

    public final void l(boolean z) {
        Activity activity = this.a;
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity != null) {
            if (z) {
                o();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("isPopRequest", z ? "true" : "false");
            String simpleName = this.a.getClass().getSimpleName();
            k21.h(simpleName, "mContent::class.java.simpleName");
            or1.g(simpleName, AgooConstants.MESSAGE_POPUP, "start", hashMap);
            this.d = new MiddlePriortyDefaultHandle(fragmentActivity);
            Job unused = f.b(LifecycleOwnerKt.getLifecycleScope(fragmentActivity), null, null, new PopupPriorityManager$popupLaunch$1$1(this, null), 3, null);
        }
    }

    public final void m(@Nullable pr1 pr1, @Nullable pr1 pr12, @Nullable pr1 pr13) {
        this.b = pr1;
        this.c = pr12;
        this.e = pr13;
    }

    public final void n(@Nullable pr1 pr1, @NotNull InterceptType interceptType) {
        k21.i(interceptType, "type");
        this.f = pr1;
        this.g = interceptType;
    }

    public final void q(@Nullable JSONObject jSONObject) {
        this.i.b(jSONObject);
    }
}
