package cn.damai.homepage.util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import cn.damai.category.discountticket.model.OnTListener;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.yymember.MemberGuideCallBackRequest;
import cn.damai.commonbusiness.yymember.bean.MemberFinishedInfo;
import cn.damai.commonbusiness.yymember.bean.WrapFirstGuideBean;
import cn.damai.commonbusiness.yymember.request.MemberFinishGuideCallBackRequest;
import cn.damai.homepage.MainAlertEntity;
import cn.damai.homepage.util.window.UTHelperCallback;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.request.ImageFlowMonitor;
import com.taobao.phenix.request.ImageStatistics;
import tb.ax0;
import tb.h03;
import tb.tp1;

/* compiled from: Taobao */
public class MemberGuideDialogManger {
    private static transient /* synthetic */ IpChange $ipChange;
    private final BaseActivity a;
    private final g b;
    private UTHelperCallback c;

    /* compiled from: Taobao */
    public interface IMemberDialogDispatcher {
        void dialogToShow(Dialog dialog);
    }

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnTListener a;

        a(OnTListener onTListener) {
            this.a = onTListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1578956669")) {
                ipChange.ipc$dispatch("1578956669", new Object[]{this, eVar});
            } else if (MemberGuideDialogManger.this.j() && eVar != null && (bitmap = eVar.b) != null && !bitmap.isRecycled()) {
                this.a.callBack(eVar.b);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnTListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WrapFirstGuideBean a;

        b(WrapFirstGuideBean wrapFirstGuideBean) {
            this.a = wrapFirstGuideBean;
        }

        /* renamed from: a */
        public void callBack(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "621737652")) {
                ipChange.ipc$dispatch("621737652", new Object[]{this, bitmap});
                return;
            }
            MemberGuideDialogManger.this.g(this.a, bitmap);
        }
    }

    /* compiled from: Taobao */
    public class c implements OnTListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MemberFinishedInfo a;

        c(MemberFinishedInfo memberFinishedInfo) {
            this.a = memberFinishedInfo;
        }

        /* renamed from: a */
        public void callBack(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2083317651")) {
                ipChange.ipc$dispatch("2083317651", new Object[]{this, bitmap});
                return;
            }
            MemberGuideDialogManger.this.f(this.a, bitmap);
        }
    }

    /* compiled from: Taobao */
    public class d implements DialogUtil.MemberDialogAction {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WrapFirstGuideBean a;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2029129409")) {
                    ipChange.ipc$dispatch("-2029129409", new Object[]{this, view});
                    return;
                }
                if (MemberGuideDialogManger.this.c != null) {
                    MemberGuideDialogManger.this.c.confirmUt("");
                } else {
                    ax0.h(d.this.a.tipType);
                }
                h03.e(MemberGuideDialogManger.this.a);
            }
        }

        /* compiled from: Taobao */
        public class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "82160960")) {
                    ipChange.ipc$dispatch("82160960", new Object[]{this, view});
                } else if (MemberGuideDialogManger.this.c != null) {
                    MemberGuideDialogManger.this.c.closeUt();
                } else {
                    ax0.g(d.this.a.tipType);
                }
            }
        }

        d(WrapFirstGuideBean wrapFirstGuideBean) {
            this.a = wrapFirstGuideBean;
        }

        @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
        public void exposureTime(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1711029143")) {
                ipChange.ipc$dispatch("1711029143", new Object[]{this, Long.valueOf(j)});
            } else if (MemberGuideDialogManger.this.c != null) {
                MemberGuideDialogManger.this.c.exposureUt(j);
            } else {
                ax0.r(j, this.a.tipType);
            }
        }

        @Override // cn.damai.uikit.util.DialogUtil.MemberDialogAction
        public View.OnClickListener getCloseClick() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1653062356")) {
                return new b();
            }
            return (View.OnClickListener) ipChange.ipc$dispatch("-1653062356", new Object[]{this});
        }

        @Override // cn.damai.uikit.util.DialogUtil.MemberDialogAction
        public View.OnClickListener getContentClick() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-148446483")) {
                return new a();
            }
            return (View.OnClickListener) ipChange.ipc$dispatch("-148446483", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public class e implements DialogInterface.OnShowListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WrapFirstGuideBean a;

        e(MemberGuideDialogManger memberGuideDialogManger, WrapFirstGuideBean wrapFirstGuideBean) {
            this.a = wrapFirstGuideBean;
        }

        public void onShow(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "605002976")) {
                ipChange.ipc$dispatch("605002976", new Object[]{this, dialogInterface});
                return;
            }
            MemberGuideCallBackRequest.asyncWriteBack(this.a.tipType);
        }
    }

    /* compiled from: Taobao */
    public class f implements DialogInterface.OnShowListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f(MemberGuideDialogManger memberGuideDialogManger) {
        }

        public void onShow(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1761691618")) {
                ipChange.ipc$dispatch("-1761691618", new Object[]{this, dialogInterface});
                return;
            }
            MemberFinishGuideCallBackRequest.syncWriteBack();
        }
    }

    /* compiled from: Taobao */
    public static class g implements IMemberDialogDispatcher {
        private static transient /* synthetic */ IpChange $ipChange;
        private final IMemberDialogDispatcher a;

        public g(IMemberDialogDispatcher iMemberDialogDispatcher) {
            this.a = iMemberDialogDispatcher;
        }

        @Override // cn.damai.homepage.util.MemberGuideDialogManger.IMemberDialogDispatcher
        public void dialogToShow(Dialog dialog) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1528346004")) {
                ipChange.ipc$dispatch("1528346004", new Object[]{this, dialog});
                return;
            }
            IMemberDialogDispatcher iMemberDialogDispatcher = this.a;
            if (iMemberDialogDispatcher != null) {
                iMemberDialogDispatcher.dialogToShow(dialog);
            }
        }
    }

    public MemberGuideDialogManger(BaseActivity baseActivity, IMemberDialogDispatcher iMemberDialogDispatcher) {
        this.a = baseActivity;
        this.b = new g(iMemberDialogDispatcher);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void f(final MemberFinishedInfo memberFinishedInfo, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108449975")) {
            ipChange.ipc$dispatch("-108449975", new Object[]{this, memberFinishedInfo, bitmap});
            return;
        }
        Dialog c2 = DialogUtil.c(this.a, bitmap, memberFinishedInfo.avatar, memberFinishedInfo.userNick, memberFinishedInfo.memberFlag, memberFinishedInfo.gifUrl, new DialogUtil.MemberDialogActionV2() {
            /* class cn.damai.homepage.util.MemberGuideDialogManger.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$5$a */
            /* compiled from: Taobao */
            public class a implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-761844542")) {
                        ipChange.ipc$dispatch("-761844542", new Object[]{this, view});
                        return;
                    }
                    if (MemberGuideDialogManger.this.c != null) {
                        MemberGuideDialogManger.this.c.confirmUt("");
                    } else {
                        ax0.f(memberFinishedInfo.memberFlag);
                    }
                    h03.e(MemberGuideDialogManger.this.a);
                }
            }

            /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$5$b */
            /* compiled from: Taobao */
            public class b implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                b() {
                }

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1349445827")) {
                        ipChange.ipc$dispatch("1349445827", new Object[]{this, view});
                    } else if (MemberGuideDialogManger.this.c != null) {
                        MemberGuideDialogManger.this.c.closeUt();
                    }
                }
            }

            @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
            public void exposureTime(long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "893380693")) {
                    ipChange.ipc$dispatch("893380693", new Object[]{this, Long.valueOf(j)});
                } else if (MemberGuideDialogManger.this.c != null) {
                    MemberGuideDialogManger.this.c.exposureUt(j);
                } else {
                    ax0.q(j, memberFinishedInfo.memberFlag);
                }
            }

            @Override // cn.damai.uikit.util.DialogUtil.MemberDialogAction
            public View.OnClickListener getCloseClick() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-777043350")) {
                    return new b();
                }
                return (View.OnClickListener) ipChange.ipc$dispatch("-777043350", new Object[]{this});
            }

            @Override // cn.damai.uikit.util.DialogUtil.MemberDialogAction
            public View.OnClickListener getContentClick() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-107771733")) {
                    return new a();
                }
                return (View.OnClickListener) ipChange.ipc$dispatch("-107771733", new Object[]{this});
            }

            @Override // cn.damai.uikit.util.DialogUtil.MemberDialogActionV2
            public void loadGifImg(final ImageView imageView, final String str, final View view, final View view2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "102970370")) {
                    ipChange.ipc$dispatch("102970370", new Object[]{this, imageView, str, view, view2});
                    return;
                }
                tp1.o().y(new ImageFlowMonitor(this) {
                    /* class cn.damai.homepage.util.MemberGuideDialogManger.AnonymousClass5.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* access modifiers changed from: private */
                    /* access modifiers changed from: public */
                    private void b() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1549477317")) {
                            ipChange.ipc$dispatch("-1549477317", new Object[]{this});
                            return;
                        }
                        imageView.setVisibility(8);
                        view.setVisibility(0);
                        view2.setVisibility(0);
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public int getMinimumScheduleTime2StatWaitSize() {
                        IpChange ipChange = $ipChange;
                        if (!AndroidInstantRuntime.support(ipChange, "-467494899")) {
                            return 0;
                        }
                        return ((Integer) ipChange.ipc$dispatch("-467494899", new Object[]{this})).intValue();
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onCancel(ImageStatistics imageStatistics) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-69587336")) {
                            ipChange.ipc$dispatch("-69587336", new Object[]{this, imageStatistics});
                            return;
                        }
                        Log.e("ImageStatistics", "onCancel 2");
                        b();
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onFail(ImageStatistics imageStatistics, Throwable th) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2080041895")) {
                            ipChange.ipc$dispatch("-2080041895", new Object[]{this, imageStatistics, th});
                        } else if (str.equals(imageStatistics.p().k())) {
                            Log.e("ImageStatistics", "onFail 5 " + imageStatistics.p().k());
                            b();
                        }
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onProcess(ImageStatistics imageStatistics, String str, String str2) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1519280711")) {
                            ipChange.ipc$dispatch("-1519280711", new Object[]{this, imageStatistics, str, str2});
                        }
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onStart(ImageStatistics imageStatistics) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1557207768")) {
                            ipChange.ipc$dispatch("1557207768", new Object[]{this, imageStatistics});
                        } else if (str.equals(imageStatistics.p().k())) {
                            Log.e("ImageStatistics", "onStart 1 " + imageStatistics.p().k());
                            imageView.setVisibility(0);
                            view.setVisibility(4);
                            view2.setVisibility(4);
                        }
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onSuccess(ImageStatistics imageStatistics) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2120165959")) {
                            ipChange.ipc$dispatch("-2120165959", new Object[]{this, imageStatistics});
                        } else if (str.equals(imageStatistics.p().k())) {
                            Log.e("ImageStatistics", "onSuccess 3 " + imageStatistics.p().k());
                            imageView.postDelayed(new Runnable() {
                                /* class cn.damai.homepage.util.MemberGuideDialogManger.AnonymousClass5.AnonymousClass1.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "310644706")) {
                                        ipChange.ipc$dispatch("310644706", new Object[]{this});
                                        return;
                                    }
                                    AnonymousClass1.this.b();
                                }
                            }, 2000);
                        }
                    }
                });
                tp1.o().s(str).y(imageView);
            }

            @Override // cn.damai.uikit.util.DialogUtil.MemberDialogActionV2
            public void loadHeadImg(DMAvatar dMAvatar, String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1495228065")) {
                    ipChange.ipc$dispatch("-1495228065", new Object[]{this, dMAvatar, str});
                    return;
                }
                dMAvatar.setAvatar(str);
            }
        });
        c2.setOnShowListener(new f(this));
        this.b.dialogToShow(c2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(WrapFirstGuideBean wrapFirstGuideBean, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "559967750")) {
            ipChange.ipc$dispatch("559967750", new Object[]{this, wrapFirstGuideBean, bitmap});
            return;
        }
        Dialog d2 = DialogUtil.d(this.a, bitmap, new d(wrapFirstGuideBean));
        d2.setOnShowListener(new e(this, wrapFirstGuideBean));
        this.b.dialogToShow(d2);
    }

    private void i(String str, OnTListener<Bitmap> onTListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "580040991")) {
            ipChange.ipc$dispatch("580040991", new Object[]{this, str, onTListener});
            return;
        }
        cn.damai.common.image.a.b().e(str).n(new a(onTListener)).f();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902122751")) {
            return ((Boolean) ipChange.ipc$dispatch("-902122751", new Object[]{this})).booleanValue();
        }
        BaseActivity baseActivity = this.a;
        return baseActivity != null && !baseActivity.isFinishing();
    }

    public void h(@NonNull MainAlertEntity mainAlertEntity, DialogInterface.OnDismissListener onDismissListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872403930")) {
            ipChange.ipc$dispatch("872403930", new Object[]{this, mainAlertEntity, onDismissListener});
        } else if (mainAlertEntity.isFirstMemberGuide()) {
            WrapFirstGuideBean wrapFirstGuideBean = mainAlertEntity.getWrapFirstGuideBean();
            if (wrapFirstGuideBean.isValid()) {
                i(wrapFirstGuideBean.firstMemberGuideUrl, new b(wrapFirstGuideBean));
            } else {
                onDismissListener.onDismiss(null);
            }
        } else if (mainAlertEntity.isMemberFinishGuide()) {
            MemberFinishedInfo memberFinishedInfo = mainAlertEntity.getMemberFinishedInfo();
            if (memberFinishedInfo.isValid4FinishDialog()) {
                i(memberFinishedInfo.profitImageUrl, new c(memberFinishedInfo));
            } else {
                onDismissListener.onDismiss(null);
            }
        } else {
            onDismissListener.onDismiss(null);
        }
    }

    public boolean k(MainAlertEntity mainAlertEntity) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1608786287")) {
            return mainAlertEntity != null && mainAlertEntity.isType4Member();
        }
        return ((Boolean) ipChange.ipc$dispatch("-1608786287", new Object[]{this, mainAlertEntity})).booleanValue();
    }

    public void l(UTHelperCallback uTHelperCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189059994")) {
            ipChange.ipc$dispatch("1189059994", new Object[]{this, uTHelperCallback});
            return;
        }
        this.c = uTHelperCallback;
    }
}
