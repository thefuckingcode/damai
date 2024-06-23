package tb;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.member.R$drawable;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.zxing.DecodeQRImage;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class yz0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        a(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1427224189")) {
                ipChange.ipc$dispatch("1427224189", new Object[]{this, eVar});
                return;
            }
            Drawable drawable = eVar.a;
            if (drawable != null) {
                this.a.setImageBitmap(((BitmapDrawable) drawable).getBitmap());
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserTicketTable a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ Context c;
        final /* synthetic */ String d;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1361961925")) {
                    ipChange.ipc$dispatch("1361961925", new Object[]{this, view});
                    return;
                }
                b bVar = b.this;
                yz0.c(bVar.c, bVar.a, bVar.b, bVar.d);
            }
        }

        b(UserTicketTable userTicketTable, ImageView imageView, Context context, String str) {
            this.a = userTicketTable;
            this.b = imageView;
            this.c = context;
            this.d = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1562956778")) {
                ipChange.ipc$dispatch("1562956778", new Object[]{this, dVar});
            } else if (this.a.hasAvailableTicket()) {
                this.b.setImageResource(R$drawable.detail_static_zxing_fail_icon);
                this.b.setOnClickListener(new a());
                String valueOf = dVar != null ? String.valueOf(dVar.a) : "";
                if (gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(this.d)) {
                    String performId = this.a.getPerformId();
                    UserTicketTable userTicketTable = this.a;
                    yz0.e(valueOf, performId, userTicketTable.voucherUniqueKey, userTicketTable.getStaticUrl());
                    return;
                }
                String performId2 = this.a.getPerformId();
                UserTicketTable userTicketTable2 = this.a;
                yz0.d(valueOf, performId2, userTicketTable2.voucherUniqueKey, userTicketTable2.getStaticUrl());
            }
        }
    }

    public static void c(Context context, UserTicketTable userTicketTable, ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1373162896")) {
            ipChange.ipc$dispatch("-1373162896", new Object[]{context, userTicketTable, imageView, str});
        } else if (userTicketTable != null) {
            if (!userTicketTable.hasAvailableTicket()) {
                imageView.setImageResource(R$drawable.detail_zing_userd);
            } else if (!yf2.c(userTicketTable.getVerifyCode()) || !userTicketTable.isStaticQrcode()) {
                new DecodeQRImage(context, userTicketTable, imageView, str).start();
            } else {
                s90.a(imageView);
                imageView.setTag(cn.damai.common.image.a.b().c(userTicketTable.getStaticUrl()).e(new b(userTicketTable, imageView, context, str)).n(new a(imageView)).f());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void d(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1582636999")) {
            ipChange.ipc$dispatch("-1582636999", new Object[]{str, str2, str3, str4});
            return;
        }
        vl2.c(vl2.f("静态二维码加载失败", "", str, "", " performId:" + str2 + " , voucherUniqueKey:" + str3 + " , url:" + str4), vl2.TICKLET_PERFORM_DETAIL_RENDER_STATIC_ERROR_CODE, "静态二维码加载失败");
    }

    /* access modifiers changed from: private */
    public static void e(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681479086")) {
            ipChange.ipc$dispatch("-1681479086", new Object[]{str, str2, str3, str4});
            return;
        }
        vl2.c(vl2.f("静态二维码加载失败", "", str, "", " performId:" + str2 + " , voucherUniqueKey:" + str3 + " , url:" + str4), vl2.TICKLET_FLOAT_RENDER_STATIC_ERROR_CODE, "静态二维码加载失败");
    }
}
