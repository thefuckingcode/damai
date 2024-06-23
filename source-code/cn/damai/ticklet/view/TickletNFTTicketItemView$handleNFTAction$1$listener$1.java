package cn.damai.ticklet.view;

import android.animation.Animator;
import android.view.View;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.member.R$id;
import cn.damai.member.R$raw;
import cn.damai.ticklet.bean.TicketNftExtAttr;
import cn.damai.ticklet.view.TickletNFTTicketItemView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.br;
import tb.k21;
import tb.vl2;

/* compiled from: Taobao */
public final class TickletNFTTicketItemView$handleNFTAction$1$listener$1 extends DMMtopRequestListener<TicketNftExtAttr> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ View $partent;
    final /* synthetic */ TickletNFTTicketItemView this$0;

    /* compiled from: Taobao */
    public static final class a implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;
        final /* synthetic */ TicketNftExtAttr b;
        final /* synthetic */ TickletNFTTicketItemView c;

        a(LottieAnimationView lottieAnimationView, TicketNftExtAttr ticketNftExtAttr, TickletNFTTicketItemView tickletNFTTicketItemView) {
            this.a = lottieAnimationView;
            this.b = ticketNftExtAttr;
            this.c = tickletNFTTicketItemView;
        }

        public void onAnimationCancel(@Nullable Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-795011604")) {
                ipChange.ipc$dispatch("-795011604", new Object[]{this, animator});
            }
        }

        public void onAnimationEnd(@Nullable Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "864668867")) {
                ipChange.ipc$dispatch("864668867", new Object[]{this, animator});
                return;
            }
            this.a.setVisibility(8);
            this.b.position = this.c.mPosition;
            br.c(TickletNFTTicketItemView.NFT_RECEIVE_ACTION, this.b);
        }

        public void onAnimationRepeat(@Nullable Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1518564011")) {
                ipChange.ipc$dispatch("1518564011", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(@Nullable Animator animator) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "573691228")) {
                ipChange.ipc$dispatch("573691228", new Object[]{this, animator});
                return;
            }
            this.a.setVisibility(0);
            this.b.nftStatus = TickletNFTTicketItemView.NFTTicketStatus.UNAUTHENTIC.getCode();
            TicketNftExtAttr ticketNftExtAttr = this.b;
            TicketNftExtAttr ticketNftExtAttr2 = this.c.mNftData;
            ticketNftExtAttr.title = ticketNftExtAttr2 != null ? ticketNftExtAttr2.title : null;
            this.c.updateNftData(this.b);
            if (k21.d(this.b.subContentType, "audio") || k21.d(this.b.subContentType, "video")) {
                String str = this.b.vid;
                if (!(str == null || str.length() == 0)) {
                    z = false;
                }
                if (z) {
                    vl2.c(vl2.f(vl2.TICKLET_NFT_RECEIVE_SOURCE_ERROR_MSG, "mtop.damai.wireless.ticklet2.nft.prepareIssue", "", "", " performId:" + this.c.mPerformId + " , voucherUniqueKey:" + this.c.mVoucherUniqueKey + " , nftYcCode:" + this.b.acSn + " ，subContentType：" + this.b.subContentType + ' '), vl2.TICKLET_NFT_RECEIVE_SOURCE_ERROR_CODE, vl2.TICKLET_NFT_RECEIVE_SOURCE_ERROR_MSG);
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TickletNFTTicketItemView$handleNFTAction$1$listener$1(View view, TickletNFTTicketItemView tickletNFTTicketItemView, Class<TicketNftExtAttr> cls) {
        super(cls);
        this.$partent = view;
        this.this$0 = tickletNFTTicketItemView;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1544090214")) {
            ipChange.ipc$dispatch("1544090214", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "code");
        k21.i(str2, "msg");
        br.c(TickletNFTTicketItemView.NFT_LOADING_ACTION, Boolean.FALSE);
        cn.damai.common.util.toastutil.a.i(this.this$0.getContext(), str2);
        vl2.c(vl2.f(vl2.TICKLET_NFT_RECEIVE_ERROR_MSG, "mtop.damai.wireless.ticklet2.nft.prepareIssue", str, str2, " performId:" + this.this$0.mPerformId + " , voucherUniqueKey:" + this.this$0.mVoucherUniqueKey), vl2.TICKLET_NFT_RECEIVE_ERROR_CODE, vl2.TICKLET_NFT_RECEIVE_ERROR_MSG);
    }

    public void onSuccess(@NotNull TicketNftExtAttr ticketNftExtAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1747783407")) {
            ipChange.ipc$dispatch("-1747783407", new Object[]{this, ticketNftExtAttr});
            return;
        }
        k21.i(ticketNftExtAttr, "s");
        br.c(TickletNFTTicketItemView.NFT_LOADING_ACTION, Boolean.FALSE);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.$partent.findViewById(R$id.lav_receiver_lottie);
        lottieAnimationView.setAnimation(R$raw.ticket_receive_lottie);
        lottieAnimationView.addAnimatorListener(new a(lottieAnimationView, ticketNftExtAttr, this.this$0));
        lottieAnimationView.playAnimation();
    }
}
