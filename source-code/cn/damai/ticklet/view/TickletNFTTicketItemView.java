package cn.damai.ticklet.view;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.app.widget.ProtocolDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.member.R$color;
import cn.damai.member.R$dimen;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.PerformNftExtAttr;
import cn.damai.ticklet.bean.TicketExtAttr;
import cn.damai.ticklet.bean.TicketNftExtAttr;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.uikit.view.HoleCardView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.text.o;
import org.android.agoo.message.MessageService;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d20;
import tb.g70;
import tb.jl2;
import tb.k21;
import tb.kl2;
import tb.ll2;
import tb.lw2;
import tb.m40;
import tb.ml2;
import tb.nl2;
import tb.ol2;
import tb.sl2;
import tb.ur2;

/* compiled from: Taobao */
public final class TickletNFTTicketItemView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String NFT_LOADING_ACTION = "NFT_LOADING_ACTION";
    @NotNull
    public static final String NFT_RECEIVE_ACTION = "NFT_RECEIVE_ACTION";
    @JvmField
    public static boolean jumpToAuth;
    @Nullable
    private ImageView backRimIv;
    @Nullable
    private ImageView bottomIconIv;
    @Nullable
    private ImageView coverIv;
    @Nullable
    private HoleCardView holeCardView;
    @Nullable
    private View line;
    @Nullable
    private TicketNftExtAttr mNftData;
    @Nullable
    private PerformNftExtAttr mPerformData;
    @Nullable
    private String mPerformId;
    private int mPosition;
    @Nullable
    private String mProjectId;
    @Nullable
    private String mTicketStatus;
    @Nullable
    private String mVoucherUniqueKey;
    @Nullable
    private ImageView mainIconIv;
    @Nullable
    private TextView receiveBtnTv;
    @Nullable
    private ImageView sourceTypeIv;
    @Nullable
    private TextView statusDesTv;
    @Nullable
    private TextView statusTv;
    @Nullable
    private TextView titleTv;
    @Nullable
    private RelativeLayout unityContainerRl;
    @Nullable
    private TextView ycCodeTv;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TickletNFTTicketItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TickletNFTTicketItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TickletNFTTicketItemView(Context context, AttributeSet attributeSet, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void decideShowDialog(Function0<ur2> function0) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142259601")) {
            ipChange.ipc$dispatch("-142259601", new Object[]{this, function0});
            return;
        }
        String str2 = "ticketNFT_" + d20.i() + '_' + this.mPerformId;
        if (!k21.d(d20.B(str2), "true")) {
            SpannableString spannableString = new SpannableString(getResources().getString(R$string.ticklet_nft_rule_content));
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.color_ff2d79)), 7, spannableString.length(), 33);
            Context context = getContext();
            String string = getResources().getString(R$string.ticklet_nft_rule_tip);
            PerformNftExtAttr performNftExtAttr = this.mPerformData;
            ProtocolDialog.C(context, string, Html.fromHtml((performNftExtAttr == null || (str = performNftExtAttr.nftIssueTips) == null) ? null : o.F(str, StringUtils.LF, "<br/>", false, 4, null)), spannableString, getResources().getString(R$string.ticklet_transfer_cancel_button_thought), -16777216, jl2.a, getResources().getString(R$string.ticklet_nft_accept), Color.parseColor("#ff2d79"), new nl2(str2, this, function0), new kl2(this)).show();
            return;
        }
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: decideShowDialog$lambda-3  reason: not valid java name */
    public static final void m70decideShowDialog$lambda3(DialogInterface dialogInterface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2029653266")) {
            ipChange.ipc$dispatch("-2029653266", new Object[]{dialogInterface, Integer.valueOf(i)});
            return;
        }
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: decideShowDialog$lambda-5  reason: not valid java name */
    public static final void m71decideShowDialog$lambda5(String str, TickletNFTTicketItemView tickletNFTTicketItemView, Function0 function0, boolean z, DialogInterface dialogInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123802687")) {
            ipChange.ipc$dispatch("-123802687", new Object[]{str, tickletNFTTicketItemView, function0, Boolean.valueOf(z), dialogInterface});
            return;
        }
        k21.i(str, "$key");
        k21.i(tickletNFTTicketItemView, "this$0");
        k21.i(function0, "$function");
        if (z) {
            dialogInterface.dismiss();
            d20.T(str, "true");
            if (tickletNFTTicketItemView.mPerformData != null) {
                function0.invoke();
                return;
            }
            return;
        }
        ToastUtil.a().j(AppInfoProviderProxy.getApplication(), tickletNFTTicketItemView.getResources().getString(R$string.ticklet_nft_rule_toast));
    }

    /* access modifiers changed from: private */
    /* renamed from: decideShowDialog$lambda-6  reason: not valid java name */
    public static final void m72decideShowDialog$lambda6(TickletNFTTicketItemView tickletNFTTicketItemView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1158543531")) {
            ipChange.ipc$dispatch("-1158543531", new Object[]{tickletNFTTicketItemView, view});
            return;
        }
        k21.i(tickletNFTTicketItemView, "this$0");
        PerformNftExtAttr performNftExtAttr = tickletNFTTicketItemView.mPerformData;
        lw2.f().n(tickletNFTTicketItemView.getContext(), performNftExtAttr != null ? performNftExtAttr.nftRuleUrl : null);
    }

    private final NFTTicketStatus getStatues(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1984296297")) {
            return (NFTTicketStatus) ipChange.ipc$dispatch("1984296297", new Object[]{this, str});
        }
        NFTTicketStatus nFTTicketStatus = NFTTicketStatus.NULL;
        if (k21.d(str, nFTTicketStatus.getCode())) {
            return nFTTicketStatus;
        }
        NFTTicketStatus nFTTicketStatus2 = NFTTicketStatus.UNCLAIMED;
        if (!k21.d(str, nFTTicketStatus2.getCode())) {
            nFTTicketStatus2 = NFTTicketStatus.UNAUTHENTIC;
            if (!k21.d(str, nFTTicketStatus2.getCode())) {
                nFTTicketStatus2 = NFTTicketStatus.AUTHENTIC;
                if (!k21.d(str, nFTTicketStatus2.getCode())) {
                    nFTTicketStatus2 = NFTTicketStatus.ROLLOUTING;
                    if (!k21.d(str, nFTTicketStatus2.getCode())) {
                        nFTTicketStatus2 = NFTTicketStatus.ROLLOUT;
                        if (!k21.d(str, nFTTicketStatus2.getCode())) {
                            nFTTicketStatus2 = NFTTicketStatus.INVALID;
                            if (!k21.d(str, nFTTicketStatus2.getCode())) {
                                nFTTicketStatus2 = NFTTicketStatus.DESTROYED;
                                if (!k21.d(str, nFTTicketStatus2.getCode())) {
                                    nFTTicketStatus2 = NFTTicketStatus.EXPIRED;
                                    if (!k21.d(str, nFTTicketStatus2.getCode())) {
                                        return nFTTicketStatus;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return nFTTicketStatus2;
    }

    /* access modifiers changed from: private */
    public final void handleNFTAction(View view, PerformNftExtAttr performNftExtAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068368822")) {
            ipChange.ipc$dispatch("1068368822", new Object[]{this, view, performNftExtAttr});
            return;
        }
        String str = performNftExtAttr.nftUserValidateStatus;
        if (str != null) {
            ol2.a(str, new TickletNFTTicketItemView$handleNFTAction$1(this, view), new TickletNFTTicketItemView$handleNFTAction$2(this, performNftExtAttr), new TickletNFTTicketItemView$handleNFTAction$3(this, performNftExtAttr));
        }
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2028366944")) {
            ipChange.ipc$dispatch("2028366944", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.ticklet_ticket_nft_item, this);
        this.holeCardView = (HoleCardView) inflate.findViewById(R$id.hv_container);
        this.unityContainerRl = (RelativeLayout) inflate.findViewById(R$id.rl_unity_container);
        this.mainIconIv = (ImageView) inflate.findViewById(R$id.iv_nft_main_icon);
        this.statusTv = (TextView) inflate.findViewById(R$id.tv_nft_status);
        this.statusDesTv = (TextView) inflate.findViewById(R$id.tv_nft_status_des);
        this.receiveBtnTv = (TextView) inflate.findViewById(R$id.tv_receive_btn);
        this.coverIv = (ImageView) inflate.findViewById(R$id.iv_cover);
        this.line = inflate.findViewById(R$id.v_line);
        this.sourceTypeIv = (ImageView) inflate.findViewById(R$id.iv_source_type);
        this.ycCodeTv = (TextView) inflate.findViewById(R$id.tv_yc_code);
        this.titleTv = (TextView) inflate.findViewById(R$id.tv_title);
        this.bottomIconIv = (ImageView) inflate.findViewById(R$id.iv_bottom_icon);
        this.backRimIv = (ImageView) inflate.findViewById(R$id.iv_nft_back_rim);
        TextView textView = this.statusTv;
        ViewGroup.LayoutParams layoutParams = null;
        TextPaint paint = textView != null ? textView.getPaint() : null;
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        int d = g70.d() - ((int) getResources().getDimension(R$dimen.ticklet_nft_hole_site));
        ImageView imageView = this.coverIv;
        if (imageView != null) {
            layoutParams = imageView.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.height = d;
        }
        HoleCardView holeCardView2 = this.holeCardView;
        if (holeCardView2 != null) {
            holeCardView2.setmScallopPositionPx(d);
        }
        TextView textView2 = this.receiveBtnTv;
        if (textView2 != null) {
            textView2.setOnClickListener(new ml2(this, inflate));
        }
        ImageView imageView2 = this.sourceTypeIv;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new ll2(this));
        }
        controlVisibleByBits(NFTTicketStatus.NULL.getControlBits());
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m73initView$lambda0(TickletNFTTicketItemView tickletNFTTicketItemView, View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234269109")) {
            ipChange.ipc$dispatch("-234269109", new Object[]{tickletNFTTicketItemView, view, view2});
            return;
        }
        k21.i(tickletNFTTicketItemView, "this$0");
        c.e().x(sl2.j().J(tickletNFTTicketItemView.mPerformId, tickletNFTTicketItemView.mProjectId, tickletNFTTicketItemView.mPosition, tickletNFTTicketItemView.mTicketStatus));
        tickletNFTTicketItemView.decideShowDialog(new TickletNFTTicketItemView$initView$1$1(tickletNFTTicketItemView, view));
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m74initView$lambda2(TickletNFTTicketItemView tickletNFTTicketItemView, View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "542544297")) {
            ipChange.ipc$dispatch("542544297", new Object[]{tickletNFTTicketItemView, view});
            return;
        }
        k21.i(tickletNFTTicketItemView, "this$0");
        TicketNftExtAttr ticketNftExtAttr = tickletNFTTicketItemView.mNftData;
        if (ticketNftExtAttr != null) {
            c e = c.e();
            sl2 j = sl2.j();
            TicketNftExtAttr ticketNftExtAttr2 = tickletNFTTicketItemView.mNftData;
            e.x(j.I(ticketNftExtAttr2 != null ? ticketNftExtAttr2.subContentType : null, tickletNFTTicketItemView.mPosition));
            String str = ticketNftExtAttr.nftContentUrl;
            if (!(str == null || str.length() == 0)) {
                z = false;
            }
            if (!z) {
                DMNav.from(tickletNFTTicketItemView.getContext()).toUri(ticketNftExtAttr.nftContentUrl);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateNftData(TicketNftExtAttr ticketNftExtAttr) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "301170450")) {
            ipChange.ipc$dispatch("301170450", new Object[]{this, ticketNftExtAttr});
            return;
        }
        this.mNftData = ticketNftExtAttr;
        String str = ticketNftExtAttr.nftStatus;
        if (str != null && !(o.y(str))) {
            z = false;
        }
        if (z) {
            str = NFTTicketStatus.NULL.getCode();
        }
        k21.h(str, "nftStatus");
        controlVisibleByBits(getStatues(str).getControlBits());
        validShow(this.statusTv, ticketNftExtAttr.issueTips);
        validShow(this.statusDesTv, ticketNftExtAttr.issueLimitTime);
        TextView textView = this.receiveBtnTv;
        if (textView != null) {
            PerformNftExtAttr performNftExtAttr = this.mPerformData;
            textView.setText(k21.d(performNftExtAttr != null ? performNftExtAttr.nftUserValidateStatus : null, "300") ? "授权实名" : "立即领取");
        }
        ImageView imageView = this.coverIv;
        if (imageView != null) {
            cn.damai.common.image.a.b().loadinto(ticketNftExtAttr.coverURL, imageView);
        }
        validShow(this.ycCodeTv, ticketNftExtAttr.acSn);
        validShow(this.titleTv, ticketNftExtAttr.title);
        String str2 = ticketNftExtAttr.subContentType;
        if (str2 != null) {
            switch (str2.hashCode()) {
                case 92944:
                    if (str2.equals("_3D")) {
                        ImageView imageView2 = this.sourceTypeIv;
                        if (imageView2 != null) {
                            imageView2.setImageResource(R$drawable.ticket_nft_source_3d);
                            return;
                        }
                        return;
                    }
                    break;
                case 93166550:
                    if (str2.equals("audio")) {
                        ImageView imageView3 = this.sourceTypeIv;
                        if (imageView3 != null) {
                            imageView3.setImageResource(R$drawable.ticket_nft_source_sound);
                            return;
                        }
                        return;
                    }
                    break;
                case 100313435:
                    if (str2.equals("image")) {
                        ImageView imageView4 = this.sourceTypeIv;
                        if (imageView4 != null) {
                            imageView4.setImageResource(R$drawable.ticket_nft_source_pic);
                            return;
                        }
                        return;
                    }
                    break;
                case 112202875:
                    if (str2.equals("video")) {
                        ImageView imageView5 = this.sourceTypeIv;
                        if (imageView5 != null) {
                            imageView5.setImageResource(R$drawable.ticket_nft_source_video);
                            return;
                        }
                        return;
                    }
                    break;
            }
        }
        ImageView imageView6 = this.sourceTypeIv;
        if (imageView6 != null) {
            imageView6.setVisibility(8);
        }
    }

    private final void validShow(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1315719858")) {
            ipChange.ipc$dispatch("1315719858", new Object[]{this, textView, str});
            return;
        }
        if (!(textView != null && textView.getVisibility() == 8) && textView != null) {
            if (!(str == null || str.length() == 0)) {
                z = false;
            }
            if (z) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    public final void controlVisibleByBits(@NotNull byte[] bArr) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2043888534")) {
            ipChange.ipc$dispatch("-2043888534", new Object[]{this, bArr});
            return;
        }
        k21.i(bArr, "controlBits");
        if (bArr.length == 9) {
            ImageView imageView = this.mainIconIv;
            if (imageView != null) {
                imageView.setVisibility(bArr[0] == 1 ? 0 : 8);
            }
            TextView textView = this.statusTv;
            if (textView != null) {
                textView.setVisibility(bArr[1] == 1 ? 0 : 8);
            }
            TextView textView2 = this.statusDesTv;
            if (textView2 != null) {
                textView2.setVisibility(bArr[2] == 1 ? 0 : 8);
            }
            TextView textView3 = this.receiveBtnTv;
            if (textView3 != null) {
                textView3.setVisibility(bArr[3] == 1 ? 0 : 8);
            }
            ImageView imageView2 = this.coverIv;
            if (imageView2 != null) {
                imageView2.setVisibility(bArr[4] == 1 ? 0 : 8);
            }
            View view = this.line;
            if (view != null) {
                view.setVisibility(bArr[4] == 1 ? 0 : 8);
            }
            ImageView imageView3 = this.sourceTypeIv;
            if (imageView3 != null) {
                imageView3.setVisibility(bArr[5] == 1 ? 0 : 8);
            }
            TextView textView4 = this.ycCodeTv;
            if (textView4 != null) {
                textView4.setVisibility(bArr[6] == 1 ? 0 : 8);
            }
            TextView textView5 = this.titleTv;
            if (textView5 != null) {
                textView5.setVisibility(bArr[7] == 1 ? 0 : 8);
            }
            ImageView imageView4 = this.bottomIconIv;
            if (imageView4 != null) {
                if (bArr[8] != 1) {
                    i = 8;
                }
                imageView4.setVisibility(i);
            }
        }
    }

    public final void setData(@Nullable UserTicketTable userTicketTable, @Nullable TickletExtraInfo tickletExtraInfo, int i) {
        PerformNftExtAttr performNftExtAttr;
        TicketExtAttr extAttr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-633785389")) {
            ipChange.ipc$dispatch("-633785389", new Object[]{this, userTicketTable, tickletExtraInfo, Integer.valueOf(i)});
            return;
        }
        TicketNftExtAttr ticketNftExtAttr = (userTicketTable == null || (extAttr = userTicketTable.getExtAttr()) == null) ? null : extAttr.nftAttr;
        if (ticketNftExtAttr != null && tickletExtraInfo != null && (performNftExtAttr = tickletExtraInfo.extAttr) != null) {
            this.mPerformData = performNftExtAttr;
            this.mTicketStatus = userTicketTable.voucherState;
            this.mPosition = i;
            this.mNftData = ticketNftExtAttr;
            this.mVoucherUniqueKey = userTicketTable.voucherUniqueKey;
            this.mPerformId = userTicketTable.performId;
            this.mProjectId = tickletExtraInfo.projectId;
            TextView textView = this.receiveBtnTv;
            if (textView != null) {
                sl2.j().K(textView, this.mPosition);
            }
            if (tickletExtraInfo.isTMNormalMember()) {
                ImageView imageView = this.backRimIv;
                if (imageView != null) {
                    imageView.setImageResource(R$drawable.ticket_nft_back_rim_vip);
                }
            } else {
                ImageView imageView2 = this.backRimIv;
                if (imageView2 != null) {
                    imageView2.setImageResource(R$drawable.ticket_nft_back_rim);
                }
            }
            updateNftData(ticketNftExtAttr);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TickletNFTTicketItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        initView();
    }

    /* compiled from: Taobao */
    public enum NFTTicketStatus {
        NULL(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, "000"),
        UNCLAIMED(new byte[]{1, 1, 1, 1, 0, 0, 0, 0, 0}, MessageService.MSG_DB_COMPLETE),
        UNAUTHENTIC(new byte[]{0, 0, 0, 0, 1, 1, 1, 1, 1}, "200"),
        AUTHENTIC(new byte[]{0, 0, 0, 0, 1, 1, 1, 1, 1}, "300"),
        ROLLOUTING(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "401"),
        ROLLOUT(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "400"),
        INVALID(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "500"),
        DESTROYED(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "600"),
        EXPIRED(new byte[]{1, 1, 1, 0, 0, 0, 0, 0, 0}, "700");
        
        @NotNull
        private final String code;
        @NotNull
        private final byte[] controlBits;

        private NFTTicketStatus(byte[] bArr, String str) {
            this.controlBits = bArr;
            this.code = str;
        }

        @NotNull
        public final String getCode() {
            return this.code;
        }

        @NotNull
        public final byte[] getControlBits() {
            return this.controlBits;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ NFTTicketStatus(byte[] bArr, String str, int i, m40 m40) {
            this(bArr, (i & 2) != 0 ? "000" : str);
        }
    }
}
