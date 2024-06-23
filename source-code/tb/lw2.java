package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.fission.util.FissionUtil;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.member.R$drawable;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.PerformTable;
import cn.damai.ticklet.bean.TicketAlipayCardBean;
import cn.damai.ticklet.bean.TicketExtAttr;
import cn.damai.ticklet.bean.TicketNftExtAttr;
import cn.damai.ticklet.bean.TicketSouvenirBean;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.ui.activity.TickletTransferManageActivity;
import cn.damai.ticklet.ui.activity.TickletVenueActivity;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.youku.arch.v3.util.ColorUtil;
import java.util.ArrayList;
import java.util.List;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
public class lw2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static lw2 a;
    private static long b;

    /* compiled from: Taobao */
    public class a implements GenerateImageUtil.OnImageGenerateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        a(lw2 lw2, View view) {
            this.a = view;
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2117192064")) {
                ipChange.ipc$dispatch("2117192064", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "346881127")) {
                ipChange.ipc$dispatch("346881127", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
            ShareManager.E().C();
        }
    }

    /* compiled from: Taobao */
    public class b implements GenerateImageUtil.OnImageGenerateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        b(lw2 lw2, View view) {
            this.a = view;
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1606657887")) {
                ipChange.ipc$dispatch("1606657887", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-163653050")) {
                ipChange.ipc$dispatch("-163653050", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
            ShareManager.E().C();
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ Context b;

        c(String str, Context context) {
            this.a = str;
            this.b = context;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "131227509")) {
                ipChange.ipc$dispatch("131227509", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(this.a)) {
                new f4(this.b).i(this.b.getResources().getString(R$string.ticklet_perform_change_notice)).c(false).e(this.a).h(this.b.getResources().getString(R$string.ticklet_know), null).j();
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ ImageView b;

        d(int i, ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1935479896")) {
                ipChange.ipc$dispatch("-1935479896", new Object[]{this, dVar});
                return;
            }
            if (dVar != null) {
                String.valueOf(dVar.a);
            }
            int i = this.a;
            if (i != -1) {
                this.b.setImageResource(i);
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        e(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "717324093")) {
                ipChange.ipc$dispatch("717324093", new Object[]{this, eVar});
            } else if (eVar != null && (bitmap = eVar.b) != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ ImageView b;

        f(int i, ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1987669420")) {
                ipChange.ipc$dispatch("1987669420", new Object[]{this, dVar});
                return;
            }
            if (dVar != null) {
                String.valueOf(dVar.a);
            }
            int i = this.a;
            if (i != -1) {
                this.b.setImageResource(i);
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        g(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1714983359")) {
                ipChange.ipc$dispatch("-1714983359", new Object[]{this, eVar});
            } else if (eVar != null && (bitmap = eVar.b) != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: Taobao */
    public class h implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        h(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-345723218")) {
                ipChange.ipc$dispatch("-345723218", new Object[]{this, dVar});
                return;
            }
            if (dVar != null) {
                String.valueOf(dVar.a);
            }
            this.a.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    public class i implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        i(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1363830211")) {
                ipChange.ipc$dispatch("1363830211", new Object[]{this, eVar});
            } else if (eVar != null && (bitmap = eVar.b) != null) {
                this.a.setVisibility(0);
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    private lw2() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0092, code lost:
        if (r6.equals("2") == false) goto L_0x002e;
     */
    public static void A(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        char c2 = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1124257672")) {
            ipChange.ipc$dispatch("-1124257672", new Object[]{str, imageView});
        } else if (yf2.c(str)) {
            imageView.setVisibility(8);
        } else {
            str.hashCode();
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 52:
                    if (str.equals("4")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 53:
                    if (str.equals("5")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 54:
                    if (str.equals("6")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 55:
                    if (str.equals("7")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 56:
                    if (str.equals("8")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 57:
                    if (str.equals("9")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case SecExceptionCode.SEC_ERROR_SIMULATORDETECT_UNSUPPORTED:
                    if (str.equals("20")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                case '\t':
                    v(imageView);
                    return;
                case 1:
                    imageView.setImageResource(R$drawable.ticket_has_use_state);
                    F(imageView);
                    return;
                case 2:
                    imageView.setImageResource(R$drawable.ticket_received_state);
                    F(imageView);
                    return;
                case 3:
                    imageView.setImageResource(R$drawable.ticket_code_refund);
                    F(imageView);
                    return;
                case 4:
                    imageView.setImageResource(R$drawable.ticket_has_end_state);
                    F(imageView);
                    return;
                case 5:
                    imageView.setImageResource(R$drawable.ticket_donationing_state);
                    F(imageView);
                    return;
                case 6:
                    imageView.setImageResource(R$drawable.ticket_has_donation_state);
                    F(imageView);
                    return;
                case 7:
                    imageView.setImageResource(R$drawable.ticklet_transfer_selling);
                    F(imageView);
                    return;
                case '\b':
                    imageView.setImageResource(R$drawable.ticklet_transfer_sold);
                    F(imageView);
                    return;
                default:
                    v(imageView);
                    return;
            }
        }
    }

    public static void B(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861088451")) {
            ipChange.ipc$dispatch("1861088451", new Object[]{str, imageView});
        } else if (yf2.c(str)) {
            imageView.setVisibility(8);
        } else {
            str.hashCode();
            if (str.equals("1")) {
                imageView.setImageResource(R$drawable.ticket_has_entrance_state);
                imageView.setVisibility(0);
            } else if (!str.equals("2")) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageResource(R$drawable.ticket_has_exit_state);
                imageView.setVisibility(0);
            }
        }
    }

    public static void C(Context context, TextView textView, String str, long j, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004645999")) {
            ipChange.ipc$dispatch("1004645999", new Object[]{context, textView, str, Long.valueOf(j), str2, str3, str4});
            return;
        }
        if (yf2.c(str)) {
            str = b30.h(Long.valueOf(j), "yyyy.MM.dd HH:mm");
        }
        if (!TextUtils.isEmpty(str4) && gl2.PERFORM_CANCEL.equals(str4)) {
            G(context, textView, str, R$drawable.ticklet_perform_cancel, null);
        } else if ("1".equals(str2)) {
            G(context, textView, str, R$drawable.ticklet_detail_change_tip_icon, new c(str3, context));
        } else {
            textView.setText(str);
        }
    }

    public static void D(View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465871444")) {
            ipChange.ipc$dispatch("-1465871444", new Object[]{view, Boolean.valueOf(z)});
        } else if (z) {
            if (view.getVisibility() == 8) {
                view.setVisibility(0);
            }
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    public static void E(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1118384028")) {
            ipChange.ipc$dispatch("-1118384028", new Object[]{textView, str});
        } else if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
    }

    public static void F(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778491563")) {
            ipChange.ipc$dispatch("1778491563", new Object[]{view});
        } else if (view.getVisibility() == 8 || view.getVisibility() == 4) {
            view.setVisibility(0);
        }
    }

    public static void G(Context context, TextView textView, String str, int i2, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113262261")) {
            ipChange.ipc$dispatch("2113262261", new Object[]{context, textView, str, Integer.valueOf(i2), onClickListener});
        } else if (context != null) {
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            e01 e01 = new e01(context, i2);
            SpannableString spannableString = new SpannableString(AltriaXLaunchTime.SPACE + str);
            spannableString.setSpan(e01, 0, 1, 33);
            textView.setText(spannableString);
        }
    }

    public static boolean e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388222970")) {
            return ((Boolean) ipChange.ipc$dispatch("388222970", new Object[]{context})).booleanValue();
        }
        if ((Build.VERSION.SDK_INT >= 8 ? context.getResources().getConfiguration().uiMode & 48 : 0) == 32) {
            return true;
        }
        return false;
    }

    public static lw2 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809650971")) {
            return (lw2) ipChange.ipc$dispatch("809650971", new Object[0]);
        }
        if (a == null) {
            synchronized (lw2.class) {
                if (a == null) {
                    a = new lw2();
                }
            }
        }
        return a;
    }

    public static boolean p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1541009126")) {
            return ((Boolean) ipChange.ipc$dispatch("1541009126", new Object[0])).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b < 500) {
            b = currentTimeMillis;
            return true;
        }
        b = currentTimeMillis;
        return false;
    }

    public static void q(Context context, ImageView imageView, String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111646923")) {
            ipChange.ipc$dispatch("-1111646923", new Object[]{context, imageView, str, Integer.valueOf(i2)});
            return;
        }
        cn.damai.common.image.a.b().e(str).k(new DMRoundedCornersBitmapProcessor(v50.a(context, 6.0f), 0)).n(new e(imageView)).e(new d(i2, imageView)).f();
    }

    public static void r(ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858904574")) {
            ipChange.ipc$dispatch("-858904574", new Object[]{imageView, str});
            return;
        }
        cn.damai.common.image.a.b().e(str).k(new DMRoundedCornersBitmapProcessor(6, 0)).n(new i(imageView)).e(new h(imageView)).f();
    }

    public static void s(ImageView imageView, String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-856208575")) {
            ipChange.ipc$dispatch("-856208575", new Object[]{imageView, str, Integer.valueOf(i2)});
            return;
        }
        cn.damai.common.image.a.b().e(str).k(new DMRoundedCornersBitmapProcessor(6, 0)).n(new g(imageView)).e(new f(i2, imageView)).f();
    }

    public static void u(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165467936")) {
            ipChange.ipc$dispatch("-165467936", new Object[]{imageView});
            return;
        }
        imageView.setImageResource(R$drawable.ticket_refund_coupon_state);
        imageView.setVisibility(0);
    }

    public static void v(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723211168")) {
            ipChange.ipc$dispatch("1723211168", new Object[]{view});
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    public static void w(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477347194")) {
            ipChange.ipc$dispatch("-477347194", new Object[]{view});
        } else if (view.getVisibility() == 0) {
            view.setVisibility(4);
        }
    }

    public static void x(Context context, UserTicketTable userTicketTable, LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308515651")) {
            ipChange.ipc$dispatch("-1308515651", new Object[]{context, userTicketTable, linearLayout});
        } else if (!TextUtils.isEmpty(userTicketTable.seatInfo) || !TextUtils.isEmpty(userTicketTable.getPrice())) {
            linearLayout.setVisibility(0);
            if (!TextUtils.isEmpty(userTicketTable.seatInfo)) {
                TextView textView = new TextView(context);
                textView.setGravity(17);
                textView.setTextSize(1, 16.0f);
                y(userTicketTable.getVoucherState(), textView, "#000000", "#999999");
                textView.setText(userTicketTable.seatInfo);
                linearLayout.addView(textView);
            }
            if (!TextUtils.isEmpty(userTicketTable.getPrice())) {
                TextView textView2 = new TextView(context);
                textView2.setGravity(17);
                textView2.setTextSize(1, 13.0f);
                textView2.setTextColor(Color.parseColor("#999999"));
                textView2.setText(userTicketTable.getPrice());
                linearLayout.addView(textView2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams.topMargin = v50.a(context, 9.0f);
                textView2.setLayoutParams(layoutParams);
            }
        } else {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r7.equals("20") == false) goto L_0x0028;
     */
    public static void y(String str, TextView textView, String str2, String str3) {
        IpChange ipChange = $ipChange;
        char c2 = 3;
        if (AndroidInstantRuntime.support(ipChange, "1118326251")) {
            ipChange.ipc$dispatch("1118326251", new Object[]{str, textView, str2, str3});
            return;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case SecExceptionCode.SEC_ERROR_SIMULATORDETECT_UNSUPPORTED:
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                textView.setTextColor(Color.parseColor(str2));
                return;
            default:
                textView.setTextColor(Color.parseColor(str3));
                return;
        }
    }

    public static void z(Context context, String str, int i2, String str2, LinearLayout linearLayout, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006969353")) {
            ipChange.ipc$dispatch("2006969353", new Object[]{context, str, Integer.valueOf(i2), str2, linearLayout, Integer.valueOf(i3)});
            return;
        }
        linearLayout.removeAllViews();
        if (!TextUtils.isEmpty(str2)) {
            linearLayout.setVisibility(0);
            TextView textView = new TextView(context);
            textView.setGravity(i3);
            textView.setTextSize(1, (float) i2);
            y(str, textView, "#111111", "#999999");
            textView.setText(str2);
            linearLayout.addView(textView);
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void a(View view, Activity activity, TicketSouvenirBean ticketSouvenirBean, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065426754")) {
            ipChange.ipc$dispatch("-2065426754", new Object[]{this, view, activity, ticketSouvenirBean, bitmap});
        } else if (activity != null) {
            view.setClickable(false);
            DMShareMessage dMShareMessage = new DMShareMessage();
            dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_NEW_SHARE;
            dMShareMessage.sharePictureUrl = ticketSouvenirBean.projectImage;
            dMShareMessage.shareTitle = ticketSouvenirBean.projectName;
            dMShareMessage.shareLink = ticketSouvenirBean.projectDetailH5Url;
            dMShareMessage.businessBitmap = bitmap;
            dMShareMessage.projectId = ticketSouvenirBean.itemId;
            dMShareMessage.commentType = "";
            dMShareMessage.tip = "去大麦了解更多";
            dMShareMessage.bgImageUrl = ticketSouvenirBean.bgImage;
            DMShareMessage.QRCodeColor qRCodeColor = new DMShareMessage.QRCodeColor();
            qRCodeColor.radius = v50.a(activity, 6.0f);
            qRCodeColor.solidColor = "#ffffff";
            qRCodeColor.strokeColor = "#FFEAD8";
            qRCodeColor.strokeWidth = v50.a(activity, 3.0f);
            dMShareMessage.qrCodeColor = qRCodeColor;
            GenerateImageUtil.q(activity, dMShareMessage, false);
            GenerateImageUtil.G(new b(this, view));
        }
    }

    public List<PerformTable> b(List<PerformTable> list) {
        String str;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2063202307")) {
            return (List) ipChange.ipc$dispatch("2063202307", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        new PerformTable();
        for (PerformTable performTable : list) {
            try {
                PerformTable performTable2 = (PerformTable) performTable.clone();
                if (performTable2.sepType == 0) {
                    if (yf2.c(performTable2.getTimeTitle())) {
                        if (performTable2.getStartTimeByLong() == 0) {
                            performTable2.timeShow = null;
                        }
                    }
                    if (yf2.c(performTable2.getTimeTitle())) {
                        str = b30.h(Long.valueOf(performTable2.getStartTimeByLong()), "yyyy.MM.dd HH:mm");
                    } else {
                        str = performTable2.getTimeTitle().trim();
                    }
                    performTable2.timeShow = str;
                    if (gl2.PERFORM_CANCEL.equals(performTable2.performStatus)) {
                        performTable2.timeShowIcon = performTable2.isHistoryTicket() ? R$drawable.ticklet_perform_cancel_history : R$drawable.ticklet_perform_cancel;
                    } else if ("1".equals(performTable2.isTimeChanged)) {
                        if (performTable2.isHistoryTicket()) {
                            i2 = R$drawable.ticklet_detail_change_tip_icon_history;
                        } else {
                            i2 = R$drawable.ticklet_list_change_tip_icon;
                        }
                        performTable2.timeShowIcon = i2;
                    } else {
                        performTable2.timeShowIcon = -1;
                    }
                }
                performTable = performTable2;
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
            }
            arrayList.add(performTable);
        }
        return arrayList;
    }

    public int[] c(int i2, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "688467923")) {
            return (int[]) ipChange.ipc$dispatch("688467923", new Object[]{this, Integer.valueOf(i2), arrayList});
        }
        int[] iArr = {i2, i2, ColorUtil.parseColorSafely(gl2.DETAIL_PAGE_DEFAULT_COLOR)};
        if (arrayList != null && arrayList.size() > 0) {
            int e2 = xf2.e(arrayList);
            if (e2 < 2) {
                return iArr;
            }
            iArr = new int[e2];
            for (int i3 = 0; i3 < e2; i3++) {
                iArr[i3] = ColorUtil.parseColorSafely(arrayList.get(i3));
            }
        }
        return iArr;
    }

    public int d(float f2, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-567421826")) {
            return (Math.min(255, Math.max(0, (int) (f2 * 255.0f))) << 24) + (i2 & 16777215);
        }
        return ((Integer) ipChange.ipc$dispatch("-567421826", new Object[]{this, Float.valueOf(f2), Integer.valueOf(i2)})).intValue();
    }

    public void g(FrameLayout frameLayout, TextView textView, TicketExtAttr ticketExtAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "458719633")) {
            ipChange.ipc$dispatch("458719633", new Object[]{this, frameLayout, textView, ticketExtAttr});
        } else if (ticketExtAttr == null || TextUtils.isEmpty(ticketExtAttr.ticketGetModelMark)) {
            v(frameLayout);
        } else {
            F(frameLayout);
            textView.setText(ticketExtAttr.ticketGetModelMark);
        }
    }

    public float[] h(boolean z, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282377229")) {
            return (float[]) ipChange.ipc$dispatch("-1282377229", new Object[]{this, Boolean.valueOf(z), iArr});
        }
        float f2 = 0.4f;
        if (z) {
            f2 = 0.37f;
        }
        float[] fArr = {0.0f, f2, 1.0f};
        if (iArr.length == 2) {
            return new float[]{0.0f, 1.0f};
        }
        return fArr;
    }

    public String i(Context context, DamaiBaseActivity damaiBaseActivity, int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1638533095")) {
            return (context == null || damaiBaseActivity == null || damaiBaseActivity.isFinishing()) ? "" : context.getResources().getString(i2);
        }
        return (String) ipChange.ipc$dispatch("1638533095", new Object[]{this, context, damaiBaseActivity, Integer.valueOf(i2)});
    }

    public void j(Activity activity, String str, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1095152788")) {
            ipChange.ipc$dispatch("1095152788", new Object[]{this, activity, str, str2, Integer.valueOf(i2)});
        } else if (activity != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra(TicketDetailExtFragment.PERFORM_ID, str);
            intent.putExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str2);
            intent.setClass(activity, TickletTransferManageActivity.class);
            activity.startActivityForResult(intent, i2);
        }
    }

    public void k(Context context, String str, TicketAlipayCardBean ticketAlipayCardBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1724769580")) {
            ipChange.ipc$dispatch("-1724769580", new Object[]{this, context, str, ticketAlipayCardBean});
        } else if (!TextUtils.isEmpty(str) && ticketAlipayCardBean != null && context != null) {
            Bundle bundle = new Bundle();
            bundle.putString(TicketDetailExtFragment.PERFORM_ID, str);
            bundle.putSerializable("ecertTipsInfo", ticketAlipayCardBean);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("ticklet_toalipayguide"));
        }
    }

    public void l(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343702057")) {
            ipChange.ipc$dispatch("1343702057", new Object[]{this, context, str, str2});
        } else if (context != null && !TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(TicketDetailExtFragment.PERFORM_ID, str);
            bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str2);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(gr.TICKET_E_SOUNENVIR));
        }
    }

    public void m(Context context, String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505049389")) {
            ipChange.ipc$dispatch("1505049389", new Object[]{this, context, str, str2, Boolean.valueOf(z), str3, str4, str5, str6, str7, str8, Boolean.valueOf(z2)});
        } else if (!z || !(context instanceof DamaiBaseActivity)) {
            l(context, str, str2);
        } else {
            FissionUtil fissionUtil = new FissionUtil();
            fissionUtil.h((DamaiBaseActivity) context, fissionUtil.f(str3, str4, str5, "", str6, str8, str7, "4", "3", z2 ? "1" : "0"));
        }
    }

    public void n(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050323637")) {
            ipChange.ipc$dispatch("-2050323637", new Object[]{this, context, str});
        } else if (!TextUtils.isEmpty(str) && context != null) {
            new Bundle().putString("url", str);
            DMNav.from(context).toUri(str);
        }
    }

    public void o(Context context, String str, String str2, String str3, String str4, String str5, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989505776")) {
            ipChange.ipc$dispatch("1989505776", new Object[]{this, context, str, str2, str3, str4, str5, Integer.valueOf(i2)});
        } else if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra(TicketDetailExtFragment.PERFORM_ID, str);
            intent.putExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str2);
            intent.putExtra("chosenLat", str3);
            intent.putExtra("chosenLng", str4);
            intent.putExtra("venueName", str5);
            intent.putExtra(PushConstants.CLICK_TYPE, i2);
            intent.putExtra("from", TickletVenueActivity.TICKLET_VENUE_FROM_MAP);
            intent.setClass(context, TickletVenueActivity.class);
            context.startActivity(intent);
        }
    }

    public void t(View view, Activity activity, TicketNftExtAttr ticketNftExtAttr, String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "650804835")) {
            ipChange.ipc$dispatch("650804835", new Object[]{this, view, activity, ticketNftExtAttr, str, str2, Boolean.valueOf(z)});
        } else if (activity != null) {
            view.setClickable(false);
            DMShareMessage dMShareMessage = new DMShareMessage();
            dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_NFT_CARD_SHARE;
            dMShareMessage.windowTitle = "炫耀一下";
            dMShareMessage.sharePictureUrl = ticketNftExtAttr.coverURL;
            dMShareMessage.shareTitle = ticketNftExtAttr.title;
            dMShareMessage.userNick = str;
            dMShareMessage.ycCode = ticketNftExtAttr.acSn;
            dMShareMessage.shareLink = str2;
            dMShareMessage.vip = z;
            GenerateImageUtil.q(activity, dMShareMessage, false);
            GenerateImageUtil.G(new a(this, view));
        }
    }
}
