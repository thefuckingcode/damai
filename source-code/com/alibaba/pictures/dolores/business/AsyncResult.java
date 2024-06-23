package com.alibaba.pictures.dolores.business;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamic.property.DAttrConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.de2;
import tb.fb0;
import tb.fv0;
import tb.gb0;
import tb.ij2;
import tb.k21;
import tb.kx1;
import tb.pg0;
import tb.ur2;
import tb.vg2;
import tb.vp;
import tb.wg2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\t¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J!\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001dJ\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010*\u001a\u0004\u0018\u00010)JA\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u000023\u00100\u001a/\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050,j\b\u0012\u0004\u0012\u00028\u0000`/J9\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002+\u00104\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\n\u0018\u00010,j\u0004\u0018\u0001`3JT\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002F\u00109\u001aB\u0012\u0013\u0012\u00110\n¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u000106j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`8J?\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010<\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00050,j\b\u0012\u0004\u0012\u00028\u0000`;J9\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002+\u0010?\u001a'\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00050,j\b\u0012\u0004\u0012\u00028\u0000`>J?\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010C\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00050,j\b\u0012\u0004\u0012\u00028\u0000`BJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\u0010G\u001a\f\u0012\u0004\u0012\u00020\u00050Ej\u0002`FJ\u0016\u0010I\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003J\u0010\u0010J\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001f\u0010K\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\bK\u0010\u000eJ\u0014\u0010L\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\u0015\u0010M\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\bM\u0010\u0012J\u0014\u0010N\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fJ\u0006\u0010O\u001a\u00020\u0005R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010PR\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010QRG\u00100\u001a3\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010RR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010SR;\u00104\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\n\u0018\u00010,j\u0004\u0018\u0001`38\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010RR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010TRV\u00109\u001aB\u0012\u0013\u0012\u00110\n¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u000106j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`88\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010UR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010VRE\u0010<\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010RR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010WR?\u0010?\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0005\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010RR\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010XRE\u0010C\u001a1\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u0005\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010RR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010YR$\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010Ej\u0004\u0018\u0001`F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010ZR*\u0010\\\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010[8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR,\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR,\u0010j\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010i8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR*\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010p8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR*\u0010x\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010w8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R/\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010~8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R4\u0010\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/alibaba/pictures/dolores/business/AsyncResult;", "BizResponse", "Lcom/alibaba/pictures/dolores/business/Result;", "Lcom/alibaba/pictures/dolores/request/DoloresRequest;", "request", "Ltb/ur2;", "onInnerStart", "", "oriResponse", "onInnerReceiveOriResponse", "", "isHit", "response", "onInnerHitCache", "(ZLjava/lang/Object;)V", "Ltb/fb0;", "onInnerSuccessNull", "onInnerSuccess", "(Ljava/lang/Object;)V", "onInnerFail", "onInnerFinish", "dispatchOnOri", "(Ljava/lang/Boolean;)Lcom/alibaba/pictures/dolores/business/AsyncResult;", "Lcom/alibaba/pictures/dolores/business/StartAction;", "startAction", "doOnStart", "Lcom/alibaba/pictures/dolores/business/OriReceiveAction;", "oriReceiveAction", "doOnReceiveOri", "Lcom/alibaba/pictures/dolores/business/HitCacheAction;", "hitCacheAction", "doOnHitCache", "Lcom/alibaba/pictures/dolores/business/SuccessNullAction;", "successNullAction", "doOnSuccessNull", "Lcom/alibaba/pictures/dolores/business/SuccessAction;", "successAction", "doOnSuccess", "Lcom/alibaba/pictures/dolores/business/FailAction;", "failAction", "doOnFail", "Lcom/alibaba/pictures/dolores/business/FinishAction;", "finishAction", "doOnFinish", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/alibaba/pictures/dolores/business/StartFuc;", "startFuc", "doOnKTStart", "mtopResponse", "Lcom/alibaba/pictures/dolores/business/OriReceiveFuc;", "oriReceiveFuc", "doOnKTReceiveOri", "Lkotlin/Function2;", "bizResponse", "Lcom/alibaba/pictures/dolores/business/HitCacheFuc;", "hitCacheFuc", "doOnKTHitCache", "Lcom/alibaba/pictures/dolores/business/SuccessNullFuc;", "successNullFuc", "doOnKTSuccessNull", "Lcom/alibaba/pictures/dolores/business/SuccessFuc;", "successFuc", "doOnKTSuccess", "failResponse", "Lcom/alibaba/pictures/dolores/business/FailFuc;", "failFuc", "doOnKTFail", "Lkotlin/Function0;", "Lcom/alibaba/pictures/dolores/business/FinishFuc;", "finishFuc", "doOnKTFinish", "onStart", "onReceiveOriResponse", "onHitCache", "onSuccessNull", "onSuccess", "onFail", DAttrConstant.VIEW_EVENT_FINISH, "Ljava/lang/Boolean;", "Lcom/alibaba/pictures/dolores/business/StartAction;", "Lkotlin/jvm/functions/Function1;", "Lcom/alibaba/pictures/dolores/business/OriReceiveAction;", "Lcom/alibaba/pictures/dolores/business/HitCacheAction;", "Lkotlin/jvm/functions/Function2;", "Lcom/alibaba/pictures/dolores/business/SuccessNullAction;", "Lcom/alibaba/pictures/dolores/business/SuccessAction;", "Lcom/alibaba/pictures/dolores/business/FailAction;", "Lcom/alibaba/pictures/dolores/business/FinishAction;", "Lkotlin/jvm/functions/Function0;", "Ltb/de2;", "startEvent", "Ltb/de2;", "getStartEvent", "()Ltb/de2;", "setStartEvent", "(Ltb/de2;)V", "Ltb/kx1;", "receiveOriResponseEvent", "Ltb/kx1;", "getReceiveOriResponseEvent", "()Ltb/kx1;", "setReceiveOriResponseEvent", "(Ltb/kx1;)V", "Ltb/fv0;", "hitCacheEvent", "Ltb/fv0;", "getHitCacheEvent", "()Ltb/fv0;", "setHitCacheEvent", "(Ltb/fv0;)V", "Ltb/wg2;", "successNullEvent", "Ltb/wg2;", "getSuccessNullEvent", "()Ltb/wg2;", "setSuccessNullEvent", "(Ltb/wg2;)V", "Ltb/vg2;", "successEvent", "Ltb/vg2;", "getSuccessEvent", "()Ltb/vg2;", "setSuccessEvent", "(Ltb/vg2;)V", "Ltb/pg0;", "failEvent", "Ltb/pg0;", "getFailEvent", "()Ltb/pg0;", "setFailEvent", "(Ltb/pg0;)V", "Ltb/ij2;", "taskFinishEvent", "Ltb/ij2;", "getTaskFinishEvent", "()Ltb/ij2;", "setTaskFinishEvent", "(Ltb/ij2;)V", "<init>", "()V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class AsyncResult<BizResponse> extends Result<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Boolean dispatchOnOri = Boolean.FALSE;
    private FailAction<BizResponse> failAction;
    @Nullable
    private pg0<BizResponse> failEvent;
    private Function1<? super fb0<BizResponse>, ur2> failFuc;
    private FinishAction finishAction;
    private Function0<ur2> finishFuc;
    private HitCacheAction<BizResponse> hitCacheAction;
    @Nullable
    private fv0<BizResponse> hitCacheEvent;
    private Function2<? super Boolean, ? super BizResponse, ur2> hitCacheFuc;
    private OriReceiveAction oriReceiveAction;
    private Function1<Object, Boolean> oriReceiveFuc;
    @Nullable
    private kx1<Object> receiveOriResponseEvent;
    private StartAction<BizResponse> startAction;
    @Nullable
    private de2<BizResponse> startEvent;
    private Function1<? super DoloresRequest<BizResponse>, ur2> startFuc;
    private SuccessAction<BizResponse> successAction;
    @Nullable
    private vg2<BizResponse> successEvent;
    private Function1<? super BizResponse, ur2> successFuc;
    private SuccessNullAction<BizResponse> successNullAction;
    @Nullable
    private wg2<BizResponse> successNullEvent;
    private Function1<? super fb0<BizResponse>, ur2> successNullFuc;
    @Nullable
    private ij2<Object> taskFinishEvent;

    public static /* synthetic */ AsyncResult dispatchOnOri$default(AsyncResult asyncResult, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = Boolean.TRUE;
        }
        return asyncResult.dispatchOnOri(bool);
    }

    /* access modifiers changed from: private */
    public final void onInnerFail(fb0<BizResponse> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215368562")) {
            ipChange.ipc$dispatch("-215368562", new Object[]{this, fb0});
            return;
        }
        Function1<? super fb0<BizResponse>, ur2> function1 = this.failFuc;
        if (function1 == null && this.failAction == null) {
            this.failEvent = new pg0<>(fb0);
            return;
        }
        if (function1 != null) {
            function1.invoke(fb0);
        }
        FailAction<BizResponse> failAction2 = this.failAction;
        if (failAction2 != null) {
            failAction2.onFail(fb0);
        }
    }

    /* access modifiers changed from: private */
    public final void onInnerFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "220764227")) {
            ipChange.ipc$dispatch("220764227", new Object[]{this});
            return;
        }
        Function0<ur2> function0 = this.finishFuc;
        if (function0 == null && this.finishAction == null) {
            this.taskFinishEvent = new ij2<>(null);
            return;
        }
        if (function0 != null) {
            function0.invoke();
        }
        FinishAction finishAction2 = this.finishAction;
        if (finishAction2 != null) {
            finishAction2.onFinish();
        }
    }

    /* access modifiers changed from: private */
    public final void onInnerHitCache(boolean z, BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355969257")) {
            ipChange.ipc$dispatch("1355969257", new Object[]{this, Boolean.valueOf(z), bizresponse});
            return;
        }
        Function2<? super Boolean, ? super BizResponse, ur2> function2 = this.hitCacheFuc;
        if (function2 == null && this.hitCacheAction == null) {
            fv0<BizResponse> fv0 = new fv0<>(bizresponse);
            fv0.c(Boolean.valueOf(z));
            ur2 ur2 = ur2.INSTANCE;
            this.hitCacheEvent = fv0;
            return;
        }
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(z), bizresponse);
        }
        HitCacheAction<BizResponse> hitCacheAction2 = this.hitCacheAction;
        if (hitCacheAction2 != null) {
            hitCacheAction2.onHitCache(z, bizresponse);
        }
    }

    /* access modifiers changed from: private */
    public final void onInnerReceiveOriResponse(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-969952594")) {
            ipChange.ipc$dispatch("-969952594", new Object[]{this, obj});
            return;
        }
        Function1<Object, Boolean> function1 = this.oriReceiveFuc;
        if (function1 == null && this.oriReceiveAction == null) {
            this.receiveOriResponseEvent = new kx1<>(obj);
            return;
        }
        if (function1 != null) {
            function1.invoke(obj);
        }
        OriReceiveAction oriReceiveAction2 = this.oriReceiveAction;
        if (oriReceiveAction2 != null) {
            oriReceiveAction2.onReceiveOriRes(obj);
        }
    }

    /* access modifiers changed from: private */
    public final void onInnerStart(DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857071868")) {
            ipChange.ipc$dispatch("857071868", new Object[]{this, doloresRequest});
            return;
        }
        Function1<? super DoloresRequest<BizResponse>, ur2> function1 = this.startFuc;
        if (function1 == null && this.startAction == null) {
            this.startEvent = new de2<>(doloresRequest);
            return;
        }
        if (function1 != null) {
            function1.invoke(doloresRequest);
        }
        StartAction<BizResponse> startAction2 = this.startAction;
        if (startAction2 != null) {
            startAction2.onRequestStart(doloresRequest);
        }
    }

    /* access modifiers changed from: private */
    public final void onInnerSuccess(BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "521920525")) {
            ipChange.ipc$dispatch("521920525", new Object[]{this, bizresponse});
            return;
        }
        Function1<? super BizResponse, ur2> function1 = this.successFuc;
        if (function1 == null && this.successAction == null) {
            this.successEvent = new vg2<>(bizresponse);
            return;
        }
        if (function1 != null) {
            function1.invoke(bizresponse);
        }
        SuccessAction<BizResponse> successAction2 = this.successAction;
        if (successAction2 != null) {
            successAction2.onSuccess(bizresponse);
        }
    }

    /* access modifiers changed from: private */
    public final void onInnerSuccessNull(fb0<BizResponse> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-488946436")) {
            ipChange.ipc$dispatch("-488946436", new Object[]{this, fb0});
            return;
        }
        vp.a("AsyncResult", "onSuccess-dispatchOnOri=" + this.dispatchOnOri);
        Function1<? super fb0<BizResponse>, ur2> function1 = this.successNullFuc;
        if (function1 == null && this.successNullAction == null) {
            this.successNullEvent = new wg2<>(fb0);
            return;
        }
        if (function1 != null) {
            function1.invoke(fb0);
        }
        SuccessNullAction<BizResponse> successNullAction2 = this.successNullAction;
        if (successNullAction2 != null) {
            successNullAction2.onSuccess(fb0);
        }
    }

    @NotNull
    public final AsyncResult<BizResponse> dispatchOnOri(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "43187998")) {
            return (AsyncResult) ipChange.ipc$dispatch("43187998", new Object[]{this, bool});
        }
        this.dispatchOnOri = bool;
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnFail(@Nullable FailAction<BizResponse> failAction2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998515480")) {
            return (AsyncResult) ipChange.ipc$dispatch("-998515480", new Object[]{this, failAction2});
        }
        vp.a("AsyncResult", "doOnFail");
        this.failAction = failAction2;
        pg0<BizResponse> pg0 = this.failEvent;
        if (pg0 != null) {
            if (failAction2 != null) {
                k21.f(pg0);
                failAction2.onFail((fb0) pg0.a());
            }
            this.failEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnFinish(@Nullable FinishAction finishAction2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-144226242")) {
            return (AsyncResult) ipChange.ipc$dispatch("-144226242", new Object[]{this, finishAction2});
        }
        vp.a("AsyncResult", "doOnFinish");
        this.finishAction = finishAction2;
        if (this.taskFinishEvent != null) {
            if (finishAction2 != null) {
                finishAction2.onFinish();
            }
            this.taskFinishEvent = null;
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.alibaba.pictures.dolores.business.HitCacheAction<BizResponse> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final AsyncResult<BizResponse> doOnHitCache(@Nullable HitCacheAction<BizResponse> hitCacheAction2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508447750")) {
            return (AsyncResult) ipChange.ipc$dispatch("508447750", new Object[]{this, hitCacheAction2});
        }
        vp.a("AsyncResult", "doOnHitCache");
        this.hitCacheAction = hitCacheAction2;
        fv0<BizResponse> fv0 = this.hitCacheEvent;
        if (fv0 != null) {
            if (hitCacheAction2 != 0) {
                k21.f(fv0);
                boolean d = k21.d(fv0.b(), Boolean.TRUE);
                fv0<BizResponse> fv02 = this.hitCacheEvent;
                k21.f(fv02);
                hitCacheAction2.onHitCache(d, fv02.a());
            }
            this.hitCacheEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTFail(@NotNull Function1<? super fb0<BizResponse>, ur2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841902819")) {
            return (AsyncResult) ipChange.ipc$dispatch("841902819", new Object[]{this, function1});
        }
        k21.i(function1, "failFuc");
        vp.a("AsyncResult", "doOnKTFail");
        this.failFuc = function1;
        pg0<BizResponse> pg0 = this.failEvent;
        if (pg0 != null) {
            if (function1 != null) {
                k21.f(pg0);
                function1.invoke((Object) pg0.a());
            }
            this.failEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTFinish(@NotNull Function0<ur2> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500788561")) {
            return (AsyncResult) ipChange.ipc$dispatch("-1500788561", new Object[]{this, function0});
        }
        k21.i(function0, "finishFuc");
        vp.a("AsyncResult", "doOnKTFinish");
        this.finishFuc = function0;
        if (this.taskFinishEvent != null) {
            if (function0 != null) {
                function0.invoke();
            }
            this.taskFinishEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTHitCache(@Nullable Function2<? super Boolean, ? super BizResponse, ur2> function2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865445103")) {
            return (AsyncResult) ipChange.ipc$dispatch("-865445103", new Object[]{this, function2});
        }
        vp.a("AsyncResult", "doOnKTHitCache");
        this.hitCacheFuc = function2;
        fv0<BizResponse> fv0 = this.hitCacheEvent;
        if (fv0 != null) {
            if (function2 != null) {
                k21.f(fv0);
                Boolean valueOf = Boolean.valueOf(k21.d(fv0.b(), Boolean.TRUE));
                fv0<BizResponse> fv02 = this.hitCacheEvent;
                k21.f(fv02);
                function2.invoke(valueOf, (Object) fv02.a());
            }
            this.hitCacheEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTReceiveOri(@Nullable Function1<Object, Boolean> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951124898")) {
            return (AsyncResult) ipChange.ipc$dispatch("-1951124898", new Object[]{this, function1});
        }
        vp.a("AsyncResult", "doOnKTReceiveOri");
        this.oriReceiveFuc = function1;
        kx1<Object> kx1 = this.receiveOriResponseEvent;
        if (kx1 != null) {
            if (function1 != null) {
                k21.f(kx1);
                function1.invoke(kx1.a());
            }
            this.receiveOriResponseEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTStart(@NotNull Function1<? super DoloresRequest<BizResponse>, ur2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98144235")) {
            return (AsyncResult) ipChange.ipc$dispatch("-98144235", new Object[]{this, function1});
        }
        k21.i(function1, "startFuc");
        vp.a("AsyncResult", "doOnKTStart");
        this.startFuc = function1;
        de2<BizResponse> de2 = this.startEvent;
        if (de2 != null) {
            if (function1 != null) {
                k21.f(de2);
                function1.invoke((Object) de2.a());
            }
            this.startEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTSuccess(@NotNull Function1<? super BizResponse, ur2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "239440980")) {
            return (AsyncResult) ipChange.ipc$dispatch("239440980", new Object[]{this, function1});
        }
        k21.i(function1, "successFuc");
        vp.a("AsyncResult", "doOnKTSuccess");
        this.successFuc = function1;
        vg2<BizResponse> vg2 = this.successEvent;
        if (vg2 != null) {
            if (function1 != null) {
                k21.f(vg2);
                function1.invoke((Object) vg2.a());
            }
            this.successEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnKTSuccessNull(@NotNull Function1<? super fb0<BizResponse>, ur2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529597171")) {
            return (AsyncResult) ipChange.ipc$dispatch("-529597171", new Object[]{this, function1});
        }
        k21.i(function1, "successNullFuc");
        vp.a("AsyncResult", "doOnKTSuccessNull");
        this.successNullFuc = function1;
        wg2<BizResponse> wg2 = this.successNullEvent;
        if (wg2 != null) {
            if (function1 != null) {
                k21.f(wg2);
                function1.invoke((Object) wg2.a());
            }
            this.successNullEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnReceiveOri(@Nullable OriReceiveAction oriReceiveAction2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423747324")) {
            return (AsyncResult) ipChange.ipc$dispatch("-423747324", new Object[]{this, oriReceiveAction2});
        }
        vp.a("AsyncResult", "doOnReceiveOri");
        this.oriReceiveAction = oriReceiveAction2;
        kx1<Object> kx1 = this.receiveOriResponseEvent;
        if (kx1 != null) {
            if (oriReceiveAction2 != null) {
                k21.f(kx1);
                oriReceiveAction2.onReceiveOriRes(kx1.a());
            }
            this.receiveOriResponseEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnStart(@Nullable StartAction<BizResponse> startAction2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870163070")) {
            return (AsyncResult) ipChange.ipc$dispatch("870163070", new Object[]{this, startAction2});
        }
        vp.a("AsyncResult", "doOnStart");
        this.startAction = startAction2;
        de2<BizResponse> de2 = this.startEvent;
        if (de2 != null) {
            if (startAction2 != null) {
                k21.f(de2);
                startAction2.onRequestStart((DoloresRequest) de2.a());
            }
            this.startEvent = null;
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.alibaba.pictures.dolores.business.SuccessAction<BizResponse> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final AsyncResult<BizResponse> doOnSuccess(@Nullable SuccessAction<BizResponse> successAction2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535368226")) {
            return (AsyncResult) ipChange.ipc$dispatch("-535368226", new Object[]{this, successAction2});
        }
        vp.a("AsyncResult", "doOnSuccess");
        this.successAction = successAction2;
        vg2<BizResponse> vg2 = this.successEvent;
        if (vg2 != null) {
            if (successAction2 != 0) {
                k21.f(vg2);
                successAction2.onSuccess(vg2.a());
            }
            this.successEvent = null;
        }
        return this;
    }

    @NotNull
    public final AsyncResult<BizResponse> doOnSuccessNull(@NotNull SuccessNullAction<BizResponse> successNullAction2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665585470")) {
            return (AsyncResult) ipChange.ipc$dispatch("665585470", new Object[]{this, successNullAction2});
        }
        k21.i(successNullAction2, "successNullAction");
        vp.a("AsyncResult", "doOnSuccessNull");
        this.successNullAction = successNullAction2;
        wg2<BizResponse> wg2 = this.successNullEvent;
        if (wg2 != null) {
            if (successNullAction2 != null) {
                k21.f(wg2);
                successNullAction2.onSuccess((fb0) wg2.a());
            }
            this.successNullEvent = null;
        }
        return this;
    }

    @Nullable
    public final pg0<BizResponse> getFailEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2098543173")) {
            return this.failEvent;
        }
        return (pg0) ipChange.ipc$dispatch("2098543173", new Object[]{this});
    }

    @Nullable
    public final fv0<BizResponse> getHitCacheEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1725203371")) {
            return this.hitCacheEvent;
        }
        return (fv0) ipChange.ipc$dispatch("-1725203371", new Object[]{this});
    }

    @Nullable
    public final kx1<Object> getReceiveOriResponseEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1337424081")) {
            return this.receiveOriResponseEvent;
        }
        return (kx1) ipChange.ipc$dispatch("1337424081", new Object[]{this});
    }

    @Nullable
    public final de2<BizResponse> getStartEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "834305653")) {
            return this.startEvent;
        }
        return (de2) ipChange.ipc$dispatch("834305653", new Object[]{this});
    }

    @Nullable
    public final vg2<BizResponse> getSuccessEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1261955819")) {
            return this.successEvent;
        }
        return (vg2) ipChange.ipc$dispatch("-1261955819", new Object[]{this});
    }

    @Nullable
    public final wg2<BizResponse> getSuccessNullEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1990716555")) {
            return this.successNullEvent;
        }
        return (wg2) ipChange.ipc$dispatch("-1990716555", new Object[]{this});
    }

    @Nullable
    public final ij2<Object> getTaskFinishEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-907595527")) {
            return this.taskFinishEvent;
        }
        return (ij2) ipChange.ipc$dispatch("-907595527", new Object[]{this});
    }

    public final void onFail(@NotNull fb0<BizResponse> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128889382")) {
            ipChange.ipc$dispatch("2128889382", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, "response");
        vp.a("AsyncResult", "onFail-dispatchOnOri=" + this.dispatchOnOri);
        if (k21.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerFail(fb0);
        } else {
            gb0.INSTANCE.a(new AsyncResult$onFail$1(this, fb0));
        }
    }

    public final void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273503829")) {
            ipChange.ipc$dispatch("-1273503829", new Object[]{this});
            return;
        }
        vp.a("AsyncResult", "onFinish-dispatchOnOri=" + this.dispatchOnOri);
        if (k21.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerFinish();
        } else {
            gb0.INSTANCE.a(new AsyncResult$onFinish$1(this));
        }
    }

    public final void onHitCache(boolean z, @Nullable BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1650023553")) {
            ipChange.ipc$dispatch("1650023553", new Object[]{this, Boolean.valueOf(z), bizresponse});
            return;
        }
        vp.a("AsyncResult", "onHitCache-dispatchOnOri=" + this.dispatchOnOri);
        if (k21.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerHitCache(z, bizresponse);
        } else {
            gb0.INSTANCE.a(new AsyncResult$onHitCache$1(this, z, bizresponse));
        }
    }

    public final void onReceiveOriResponse(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285600746")) {
            ipChange.ipc$dispatch("-285600746", new Object[]{this, obj});
            return;
        }
        vp.a("AsyncResult", "onReceiveOriResponse-dispatchOnOri=" + this.dispatchOnOri);
        if (k21.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerReceiveOriResponse(obj);
        } else {
            gb0.INSTANCE.a(new AsyncResult$onReceiveOriResponse$1(this, obj));
        }
    }

    public final void onStart(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "932693092")) {
            ipChange.ipc$dispatch("932693092", new Object[]{this, doloresRequest});
            return;
        }
        vp.a("AsyncResult", "onStart-dispatchOnOri=" + this.dispatchOnOri);
        if (k21.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerStart(doloresRequest);
        } else {
            gb0.INSTANCE.a(new AsyncResult$onStart$1(this, doloresRequest));
        }
    }

    public final void onSuccess(BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671068251")) {
            ipChange.ipc$dispatch("-671068251", new Object[]{this, bizresponse});
            return;
        }
        vp.a("AsyncResult", "onSuccess-dispatchOnOri=" + this.dispatchOnOri);
        if (k21.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerSuccess(bizresponse);
        } else {
            gb0.INSTANCE.a(new AsyncResult$onSuccess$1(this, bizresponse));
        }
    }

    public final boolean onSuccessNull(@NotNull fb0<BizResponse> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1063829400")) {
            return ((Boolean) ipChange.ipc$dispatch("-1063829400", new Object[]{this, fb0})).booleanValue();
        }
        k21.i(fb0, "response");
        vp.a("AsyncResult", "onSuccess-dispatchOnOri=" + this.dispatchOnOri);
        if (this.successNullFuc == null && this.successNullAction == null) {
            return false;
        }
        if (k21.d(this.dispatchOnOri, Boolean.TRUE)) {
            onInnerSuccessNull(fb0);
        } else {
            gb0.INSTANCE.a(new AsyncResult$onSuccessNull$1(this, fb0));
        }
        return true;
    }

    public final void setFailEvent(@Nullable pg0<BizResponse> pg0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386909627")) {
            ipChange.ipc$dispatch("1386909627", new Object[]{this, pg0});
            return;
        }
        this.failEvent = pg0;
    }

    public final void setHitCacheEvent(@Nullable fv0<BizResponse> fv0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790221093")) {
            ipChange.ipc$dispatch("-790221093", new Object[]{this, fv0});
            return;
        }
        this.hitCacheEvent = fv0;
    }

    public final void setReceiveOriResponseEvent(@Nullable kx1<Object> kx1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-271166917")) {
            ipChange.ipc$dispatch("-271166917", new Object[]{this, kx1});
            return;
        }
        this.receiveOriResponseEvent = kx1;
    }

    public final void setStartEvent(@Nullable de2<BizResponse> de2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88918961")) {
            ipChange.ipc$dispatch("88918961", new Object[]{this, de2});
            return;
        }
        this.startEvent = de2;
    }

    public final void setSuccessEvent(@Nullable vg2<BizResponse> vg2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489235789")) {
            ipChange.ipc$dispatch("-1489235789", new Object[]{this, vg2});
            return;
        }
        this.successEvent = vg2;
    }

    public final void setSuccessNullEvent(@Nullable wg2<BizResponse> wg2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516833279")) {
            ipChange.ipc$dispatch("-1516833279", new Object[]{this, wg2});
            return;
        }
        this.successNullEvent = wg2;
    }

    public final void setTaskFinishEvent(@Nullable ij2<Object> ij2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "198769339")) {
            ipChange.ipc$dispatch("198769339", new Object[]{this, ij2});
            return;
        }
        this.taskFinishEvent = ij2;
    }
}
