package cn.damai.ticklet.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.member.R$styleable;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import tb.gl2;
import tb.i42;
import tb.lw2;
import tb.s50;
import tb.vl2;
import tb.yf2;
import tb.yz0;

/* compiled from: Taobao */
public class TickletTicketMainView extends RelativeLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String CERT;
    private final String DEFAULT;
    private final String FACE;
    private final String IMEI;
    private final String LIVE;
    private final String OTHER;
    private final String PAPER;
    private final String PDF;
    private final String QR_CODE;
    private final String QR_CODE_NUM;
    private final String TRANSFER;
    private TextView bnt_number;
    private Context context;
    private ImageView iv_num_zxing;
    private ImageView iv_zxing;
    private ImageView iv_zxing_state;
    private DMIconFontTextView leftArrow;
    private ImageView liveBg;
    private DMPosterView liveIcon;
    private View partent;
    private int pos;
    private DMIconFontTextView rightArrow;
    private TUrlImageView tUrlImageView;
    private UserTicketTable ticket;
    private TickletTicketCallback ticketCallback;
    private LinearLayout ticklet_card_view;
    private DMIconFontTextView ticklet_face_icon;
    private TextView ticklet_face_name_cert;
    private LinearLayout ticklet_face_view;
    private LinearLayout ticklet_imei_view;
    private ImageView ticklet_iv_paper_icon;
    private ImageView ticklet_iv_pdf_icon;
    private ImageView ticklet_iv_transfer_icon;
    private TextView ticklet_iv_transfer_receive_info;
    private TextView ticklet_iv_transfer_receive_tip;
    private FrameLayout ticklet_live_view;
    private LinearLayout ticklet_num_qr_code_view;
    private ImageView ticklet_other_icon;
    private TextView ticklet_other_tip;
    private LinearLayout ticklet_other_view;
    private LinearLayout ticklet_paper_view;
    private TextView ticklet_pdf_tip;
    private LinearLayout ticklet_pdf_view;
    private LinearLayout ticklet_qr_code_view;
    private LinearLayout ticklet_transfer_ticklet_view;
    private int totalPage;
    private ImageView tv_card_image;
    private TextView tv_card_name;
    private TextView tv_card_num;
    private TextView tv_imei;
    private String viewType;

    public TickletTicketMainView(Context context2) {
        this(context2, null);
    }

    private void cardView(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619809941")) {
            ipChange.ipc$dispatch("-1619809941", new Object[]{this, userTicketTable});
            return;
        }
        setViewShow("cert");
        lw2.E(this.tv_card_name, userTicketTable.getVoucherCertName());
        lw2.E(this.tv_card_num, userTicketTable.getVoucherCertNo());
        if ("1".equals(userTicketTable.voucherCertType)) {
            this.tv_card_image.setImageResource(R$drawable.ticket_card_new_icon);
        } else if ("2".equals(userTicketTable.voucherCertType)) {
            this.tv_card_image.setImageResource(R$drawable.ticket_passport_icon);
        } else if ("3".equals(userTicketTable.voucherCertType)) {
            this.tv_card_image.setImageResource(R$drawable.ticket_hongkong_icon);
        } else if ("4".equals(userTicketTable.voucherCertType)) {
            this.tv_card_image.setImageResource(R$drawable.ticket_taiwai_icon);
        } else if ("7".equals(userTicketTable.voucherCertType)) {
            this.tv_card_image.setImageResource(R$drawable.ticket_hongkong_living_icon);
        } else if ("8".equals(userTicketTable.voucherCertType)) {
            this.tv_card_image.setImageResource(R$drawable.ticket_foreigner_living_icon);
        } else {
            this.tv_card_image.setImageResource(R$drawable.ticklet_ticket_imei_icon);
        }
    }

    private void imeiView(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1611051741")) {
            ipChange.ipc$dispatch("-1611051741", new Object[]{this, userTicketTable});
        } else if (yf2.c(userTicketTable.getExchangeCode())) {
            setViewShow("default");
            if (gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(this.viewType)) {
                renderfloatImeiErrorXFlushMonitor(userTicketTable.getPerformId(), userTicketTable.getVoucherUniqueKey());
            } else {
                renderDetailImeiErrorXFlushMonitor(userTicketTable.getPerformId(), userTicketTable.getVoucherUniqueKey());
            }
        } else {
            setViewShow("imei");
            if (!"1".equals(userTicketTable.getVoucherState())) {
                this.tv_imei.setTextColor(Color.parseColor("#4D111111"));
            } else {
                this.tv_imei.setTextColor(this.context.getResources().getColor(R$color.color_111111));
            }
            this.tv_imei.setText(userTicketTable.getExchangeCode());
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-484181294")) {
            ipChange.ipc$dispatch("-484181294", new Object[]{this});
            return;
        }
        if (gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
            this.partent = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_main_float_layer_layout, this);
        } else {
            this.partent = LayoutInflater.from(this.context).inflate(R$layout.ticklet_ticket_main_layout, this);
        }
        this.tUrlImageView = (TUrlImageView) this.partent.findViewById(R$id.test_apng);
        this.ticklet_qr_code_view = (LinearLayout) this.partent.findViewById(R$id.ticklet_qr_code_view);
        this.iv_zxing = (ImageView) this.partent.findViewById(R$id.iv_zxing);
        this.ticklet_num_qr_code_view = (LinearLayout) this.partent.findViewById(R$id.ticklet_num_qr_code_view);
        this.bnt_number = (TextView) this.partent.findViewById(R$id.bnt_number);
        this.iv_num_zxing = (ImageView) this.partent.findViewById(R$id.iv_num_zxing);
        this.ticklet_imei_view = (LinearLayout) this.partent.findViewById(R$id.ticklet_imei_view);
        this.tv_imei = (TextView) this.partent.findViewById(R$id.tv_imei);
        this.ticklet_card_view = (LinearLayout) this.partent.findViewById(R$id.ticklet_card_view);
        this.tv_card_num = (TextView) this.partent.findViewById(R$id.tv_card_num);
        this.tv_card_name = (TextView) this.partent.findViewById(R$id.tv_card_name);
        this.tv_card_image = (ImageView) this.partent.findViewById(R$id.tv_card_image);
        this.ticklet_transfer_ticklet_view = (LinearLayout) this.partent.findViewById(R$id.ticklet_transfer_ticklet_view);
        this.ticklet_iv_transfer_icon = (ImageView) this.partent.findViewById(R$id.ticklet_iv_transfer_icon);
        this.ticklet_iv_transfer_receive_tip = (TextView) this.partent.findViewById(R$id.ticklet_iv_transfer_receive_tip);
        this.ticklet_iv_transfer_receive_info = (TextView) this.partent.findViewById(R$id.ticklet_iv_transfer_receive_info);
        this.ticklet_paper_view = (LinearLayout) this.partent.findViewById(R$id.ticklet_paper_view);
        this.ticklet_iv_paper_icon = (ImageView) this.partent.findViewById(R$id.ticklet_iv_paper_icon);
        this.ticklet_pdf_view = (LinearLayout) this.partent.findViewById(R$id.ticklet_pdf_view);
        this.ticklet_pdf_tip = (TextView) this.partent.findViewById(R$id.ticklet_pdf_tip);
        this.ticklet_iv_pdf_icon = (ImageView) this.partent.findViewById(R$id.ticklet_iv_pdf_icon);
        this.ticklet_other_view = (LinearLayout) this.partent.findViewById(R$id.ticklet_other_view);
        this.ticklet_other_icon = (ImageView) this.partent.findViewById(R$id.ticklet_other_icon);
        this.ticklet_other_tip = (TextView) this.partent.findViewById(R$id.ticklet_other_tip);
        this.ticklet_face_view = (LinearLayout) this.partent.findViewById(R$id.ticklet_face_view);
        this.ticklet_face_icon = (DMIconFontTextView) this.partent.findViewById(R$id.ticklet_iv_face_icon);
        this.ticklet_face_name_cert = (TextView) this.partent.findViewById(R$id.ticklet_face_name_cert);
        this.leftArrow = (DMIconFontTextView) this.partent.findViewById(R$id.ticklet_ticket_left_arrow);
        this.rightArrow = (DMIconFontTextView) this.partent.findViewById(R$id.ticklet_ticket_right_arrow);
        this.iv_zxing_state = (ImageView) this.partent.findViewById(R$id.iv_zxing_state);
        if (!gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
            this.ticklet_imei_view.setOnClickListener(this);
            this.iv_zxing.setOnClickListener(this);
            this.iv_num_zxing.setOnClickListener(this);
            this.ticklet_qr_code_view.setOnClickListener(this);
            this.ticklet_num_qr_code_view.setOnClickListener(this);
            this.ticklet_card_view.setOnClickListener(this);
            this.ticklet_transfer_ticklet_view.setOnClickListener(this);
            this.ticklet_face_view.setOnClickListener(this);
            this.ticklet_other_view.setOnClickListener(this);
            this.ticklet_paper_view.setOnClickListener(this);
            this.ticklet_live_view = (FrameLayout) this.partent.findViewById(R$id.ticklet_live_view);
            this.liveBg = (ImageView) this.partent.findViewById(R$id.ticklet_live_bg);
            this.liveIcon = (DMPosterView) this.partent.findViewById(R$id.ticklet_live_project_icon);
        }
        this.leftArrow.setOnClickListener(this);
        this.rightArrow.setOnClickListener(this);
        if (!lw2.e(this.context)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            LinearLayout linearLayout = this.ticklet_qr_code_view;
            int i = R$drawable.ticklet_qrcode_bg;
            linearLayout.setBackgroundResource(i);
            this.ticklet_num_qr_code_view.setBackgroundResource(i);
        } else if (!gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
            LinearLayout linearLayout2 = this.ticklet_qr_code_view;
            int i2 = R$drawable.shape_solid_radius4_white_eeeeee;
            linearLayout2.setBackgroundResource(i2);
            this.ticklet_num_qr_code_view.setBackgroundResource(i2);
            this.ticklet_qr_code_view.setForceDarkAllowed(false);
            this.ticklet_num_qr_code_view.setForceDarkAllowed(false);
            this.iv_zxing.setForceDarkAllowed(false);
            this.iv_num_zxing.setForceDarkAllowed(false);
        } else {
            LinearLayout linearLayout3 = this.ticklet_qr_code_view;
            int i3 = R$drawable.ticklet_qrcode_bg;
            linearLayout3.setBackgroundResource(i3);
            this.ticklet_num_qr_code_view.setBackgroundResource(i3);
        }
    }

    private void liveView(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2106205693")) {
            ipChange.ipc$dispatch("-2106205693", new Object[]{this, userTicketTable, tickletExtraInfo});
        } else if (!gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
            setViewShow("live");
            if (!TextUtils.isEmpty(tickletExtraInfo.liveTicketBgUrl)) {
                lw2.s(this.liveBg, tickletExtraInfo.liveTicketBgUrl, R$drawable.uikit_default_image_bg_grey);
            } else {
                this.liveBg.setImageResource(R$drawable.uikit_default_image_bg_grey);
            }
            if (!TextUtils.isEmpty(tickletExtraInfo.projectImage)) {
                this.liveIcon.setPlaceholder(R$drawable.uikit_default_image_bg_gradient);
                this.liveIcon.setImageUrl(tickletExtraInfo.projectImage);
            }
        }
    }

    private void otherView(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1458365873")) {
            ipChange.ipc$dispatch("-1458365873", new Object[]{this, userTicketTable});
            return;
        }
        setViewShow("other");
        this.ticklet_other_tip.setText(this.context.getResources().getString(R$string.ticklet_detail_ticket_other_tip));
    }

    private void paperView(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-111954997")) {
            ipChange.ipc$dispatch("-111954997", new Object[]{this, userTicketTable});
            return;
        }
        setViewShow("paper");
    }

    private void pdfView(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1302495951")) {
            ipChange.ipc$dispatch("-1302495951", new Object[]{this, userTicketTable});
            return;
        }
        setViewShow("pdf");
        this.ticklet_pdf_tip.setText(this.context.getResources().getString(R$string.ticklet_detail_ticket_pdf_tip));
    }

    private void qrCodeView(View view, UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1533643359")) {
            ipChange.ipc$dispatch("1533643359", new Object[]{this, view, userTicketTable});
            return;
        }
        if (yf2.c(userTicketTable.getExchangeCode())) {
            setViewShow("qr_code");
        } else {
            setViewShow("qr_code_num");
        }
        if (Build.VERSION.SDK_INT >= 4) {
            if (yf2.c(userTicketTable.getExchangeCode())) {
                yz0.c(this.context, userTicketTable, this.iv_zxing, this.viewType);
                this.iv_zxing.setTag(R$id.tag_two, userTicketTable);
                view.setTag(R$id.tag_one, this.iv_zxing);
            } else {
                yz0.c(this.context, userTicketTable, this.iv_num_zxing, this.viewType);
                this.iv_num_zxing.setTag(R$id.tag_two, userTicketTable);
                view.setTag(R$id.tag_one, this.iv_num_zxing);
            }
        }
        if (yf2.c(userTicketTable.getExchangeCode())) {
            this.bnt_number.setVisibility(8);
            return;
        }
        this.bnt_number.setVisibility(0);
        if (!userTicketTable.hasAvailableTicket()) {
            this.bnt_number.setTextColor(Color.parseColor("#1A000000"));
        } else {
            this.bnt_number.setTextColor(this.context.getResources().getColor(R$color.color_000000));
        }
        this.bnt_number.setText(userTicketTable.getExchangeCode());
    }

    private static void renderDetailImeiErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-568412730")) {
            ipChange.ipc$dispatch("-568412730", new Object[]{str, str2});
            return;
        }
        vl2.c(vl2.f("串码票-票码为空", "", "", "", " performId:" + str + " , voucherUniqueKey:" + str2), vl2.TICKLET_PERFORM_DETAIL_RENDER_IMEI_ERROR_CODE, "串码票-票码为空");
    }

    private static void renderfloatImeiErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-730346685")) {
            ipChange.ipc$dispatch("-730346685", new Object[]{str, str2});
            return;
        }
        vl2.c(vl2.f("串码票-票码为空", "", "", "", " performId:" + str + " , voucherUniqueKey:" + str2), vl2.TICKLET_PERFORM_FLOAT_RENDER_IMEI_ERROR_CODE, "串码票-票码为空");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b9, code lost:
        if (r7.equals(com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem.TYPE_FACE) == false) goto L_0x0060;
     */
    private void setViewShow(String str) {
        IpChange ipChange = $ipChange;
        char c = 2;
        if (AndroidInstantRuntime.support(ipChange, "154277545")) {
            ipChange.ipc$dispatch("154277545", new Object[]{this, str});
            return;
        }
        lw2.D(this.ticklet_card_view, false);
        lw2.D(this.ticklet_imei_view, false);
        lw2.D(this.ticklet_transfer_ticklet_view, false);
        lw2.D(this.ticklet_paper_view, false);
        lw2.D(this.ticklet_pdf_view, false);
        lw2.D(this.ticklet_other_view, false);
        lw2.D(this.ticklet_face_view, false);
        lw2.D(this.ticklet_qr_code_view, false);
        lw2.D(this.ticklet_num_qr_code_view, false);
        if (!gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
            lw2.D(this.ticklet_live_view, false);
        }
        str.hashCode();
        switch (str.hashCode()) {
            case 110834:
                if (str.equals("pdf")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3050020:
                if (str.equals("cert")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3135069:
                break;
            case 3236040:
                if (str.equals("imei")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3322092:
                if (str.equals("live")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 106069776:
                if (str.equals("other")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 106434956:
                if (str.equals("paper")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 563217739:
                if (str.equals("qr_code")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1280882667:
                if (str.equals("transfer")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1398096530:
                if (str.equals("qr_code_num")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                lw2.D(this.ticklet_pdf_view, true);
                return;
            case 1:
                lw2.D(this.ticklet_card_view, true);
                return;
            case 2:
                lw2.D(this.ticklet_face_view, true);
                return;
            case 3:
                lw2.D(this.ticklet_imei_view, true);
                return;
            case 4:
                if (!gl2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(getViewType())) {
                    lw2.D(this.ticklet_live_view, true);
                    return;
                }
                return;
            case 5:
                lw2.D(this.ticklet_other_view, true);
                return;
            case 6:
                lw2.D(this.ticklet_paper_view, true);
                return;
            case 7:
                lw2.D(this.ticklet_qr_code_view, true);
                return;
            case '\b':
                lw2.D(this.ticklet_transfer_ticklet_view, true);
                return;
            case '\t':
                lw2.D(this.ticklet_num_qr_code_view, true);
                return;
            default:
                return;
        }
    }

    private void transferView(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-298207226")) {
            ipChange.ipc$dispatch("-298207226", new Object[]{this, userTicketTable});
            return;
        }
        setViewShow("transfer");
        StringBuilder sb = new StringBuilder();
        if ("7".equals(userTicketTable.voucherState)) {
            if (!TextUtils.isEmpty(userTicketTable.getRecvUserNick())) {
                sb.append(userTicketTable.getRecvUserNick() + " ");
            }
            if (!TextUtils.isEmpty(userTicketTable.getRecvUserMobile())) {
                if (!TextUtils.isEmpty(sb.toString())) {
                    sb.append(" ");
                }
                sb.append(userTicketTable.getRecvUserMobile());
            }
        } else if ("6".equals(userTicketTable.voucherState)) {
            if (!TextUtils.isEmpty(userTicketTable.getRecvUserNick())) {
                sb.append(userTicketTable.getRecvUserNick());
            } else if (!TextUtils.isEmpty(userTicketTable.getRecvUserMobile())) {
                sb.append(userTicketTable.getRecvUserMobile());
            }
        }
        lw2.E(this.ticklet_iv_transfer_receive_info, sb.toString());
    }

    public String getViewType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "289685650")) {
            return this.viewType;
        }
        return (String) ipChange.ipc$dispatch("289685650", new Object[]{this});
    }

    public void onClick(View view) {
        UserTicketTable userTicketTable;
        TickletTicketCallback tickletTicketCallback;
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196895176")) {
            ipChange.ipc$dispatch("-1196895176", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_imei_view || view.getId() == R$id.ticklet_qr_code_view || view.getId() == R$id.ticklet_num_qr_code_view || view.getId() == R$id.iv_zxing || view.getId() == R$id.iv_num_zxing || view.getId() == R$id.ticklet_card_view || view.getId() == R$id.ticklet_transfer_ticklet_view || view.getId() == R$id.ticklet_other_view || view.getId() == R$id.ticklet_face_view || view.getId() == R$id.ticklet_paper_view) {
            if (this.ticketCallback != null && (userTicketTable = this.ticket) != null && !userTicketTable.isLiveTicket()) {
                this.ticketCallback.showTickletDialog(this.ticket.getPerformId(), this.pos);
            }
        } else if (view.getId() == R$id.ticklet_ticket_left_arrow) {
            TickletTicketCallback tickletTicketCallback2 = this.ticketCallback;
            if (tickletTicketCallback2 != null && (i2 = this.pos) > 0) {
                tickletTicketCallback2.viewPageSlide(i2 - 1);
            }
        } else if (view.getId() == R$id.ticklet_ticket_right_arrow && (tickletTicketCallback = this.ticketCallback) != null && this.totalPage - 1 > (i = this.pos)) {
            tickletTicketCallback.viewPageSlide(i + 1);
        }
    }

    public void setTicketCallback(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648463054")) {
            ipChange.ipc$dispatch("-1648463054", new Object[]{this, tickletTicketCallback});
            return;
        }
        this.ticketCallback = tickletTicketCallback;
    }

    public void setViewType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "507992716")) {
            ipChange.ipc$dispatch("507992716", new Object[]{this, str});
            return;
        }
        this.viewType = str;
    }

    public void update(View view, UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-79950171")) {
            ipChange.ipc$dispatch("-79950171", new Object[]{this, view, userTicketTable, tickletExtraInfo, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (userTicketTable != null) {
            this.ticket = userTicketTable;
            this.pos = i2;
            this.totalPage = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iv_zxing_state.getLayoutParams();
            if (gl2.TICKLET_TICKET_VIEW_DETAIL_NFT.equals(getViewType())) {
                lw2.v(this.leftArrow);
                lw2.v(this.rightArrow);
                layoutParams.removeRule(11);
                int i3 = R$id.ticklet_ll_main_view;
                layoutParams.addRule(19, i3);
                layoutParams.addRule(6, i3);
                layoutParams.topMargin = -s50.a(this.context, 60.0f);
                layoutParams.setMarginEnd(-s50.a(this.context, 9.0f));
            } else {
                layoutParams.removeRule(19);
                layoutParams.removeRule(6);
                layoutParams.addRule(11);
                layoutParams.setMarginEnd(s50.a(this.context, 15.0f));
                if (i < 2) {
                    this.leftArrow.setVisibility(8);
                    this.rightArrow.setVisibility(8);
                } else {
                    this.leftArrow.setVisibility(0);
                    this.rightArrow.setVisibility(0);
                    if (i - 1 == i2) {
                        this.leftArrow.setTextColor(this.context.getResources().getColor(R$color.color_111111));
                        this.rightArrow.setTextColor(this.context.getResources().getColor(R$color.color_999999));
                    } else if (i2 == 0) {
                        this.leftArrow.setTextColor(this.context.getResources().getColor(R$color.color_999999));
                        this.rightArrow.setTextColor(this.context.getResources().getColor(R$color.color_111111));
                    } else {
                        DMIconFontTextView dMIconFontTextView = this.leftArrow;
                        Resources resources = this.context.getResources();
                        int i4 = R$color.color_111111;
                        dMIconFontTextView.setTextColor(resources.getColor(i4));
                        this.rightArrow.setTextColor(this.context.getResources().getColor(i4));
                    }
                }
            }
            if (!"6".equals(userTicketTable.voucherState) && !"7".equals(userTicketTable.voucherState)) {
                String voucherType = userTicketTable.getVoucherType();
                voucherType.hashCode();
                char c = 65535;
                switch (voucherType.hashCode()) {
                    case 49:
                        if (voucherType.equals("1")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 50:
                        if (voucherType.equals("2")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 51:
                        if (voucherType.equals("3")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 52:
                        if (voucherType.equals("4")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 53:
                        if (voucherType.equals("5")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 54:
                        if (voucherType.equals("6")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1599:
                        if (voucherType.equals("21")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1630:
                        if (voucherType.equals("31")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1661:
                        if (voucherType.equals(UserTicketTable.COUPON_TICKET)) {
                            c = '\b';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                    case 5:
                    case '\b':
                        qrCodeView(view, userTicketTable);
                        break;
                    case 2:
                        if (!userTicketTable.isCertETicketShowMode()) {
                            cardView(userTicketTable);
                            break;
                        } else {
                            qrCodeView(view, userTicketTable);
                            break;
                        }
                    case 3:
                        paperView(userTicketTable);
                        break;
                    case 4:
                        imeiView(userTicketTable);
                        break;
                    case 6:
                        pdfView(userTicketTable);
                        break;
                    case 7:
                        liveView(userTicketTable, tickletExtraInfo);
                        break;
                    default:
                        otherView(userTicketTable);
                        break;
                }
            } else {
                transferView(userTicketTable);
            }
            if (tickletExtraInfo != null && "1".equals(userTicketTable.getVoucherState()) && "1".equals(tickletExtraInfo.moreType) && userTicketTable.getCheckDirection() != null && !userTicketTable.getCheckDirection().equals("0")) {
                lw2.B(userTicketTable.getCheckDirection(), this.iv_zxing_state);
            } else if (userTicketTable.isCouponTicket() && "4".equals(userTicketTable.getVoucherState())) {
                lw2.u(this.iv_zxing_state);
            } else if (!userTicketTable.isPaperTicket() || !"3".equals(userTicketTable.getVoucherState())) {
                lw2.A(userTicketTable.getVoucherState(), this.iv_zxing_state);
            } else {
                lw2.D(this.iv_zxing_state, false);
            }
            if (userTicketTable.hasAvailableTicket() && !userTicketTable.isPaperTicket() && !userTicketTable.isPdfTicket() && !userTicketTable.isLiveTicket()) {
                try {
                    if (this.tUrlImageView.getVisibility() == 8) {
                        this.tUrlImageView.setVisibility(0);
                    }
                    this.tUrlImageView.setImageUrl(i42.p("ticklet_unused_apng_anim.png"));
                } catch (Exception unused) {
                    if (this.tUrlImageView.getVisibility() == 0) {
                        this.tUrlImageView.setVisibility(8);
                    }
                }
            } else if (this.tUrlImageView.getVisibility() == 0) {
                this.tUrlImageView.setVisibility(8);
            }
        }
    }

    public TickletTicketMainView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletTicketMainView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.viewType = "DEFAULT";
        this.QR_CODE = "qr_code";
        this.QR_CODE_NUM = "qr_code_num";
        this.IMEI = "imei";
        this.CERT = "cert";
        this.PAPER = "paper";
        this.TRANSFER = "transfer";
        this.PDF = "pdf";
        this.FACE = BaseCellItem.TYPE_FACE;
        this.OTHER = "other";
        this.LIVE = "live";
        this.DEFAULT = "default";
        this.context = context2;
        setGravity(16);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.ViewType);
        if (obtainStyledAttributes != null) {
            this.viewType = obtainStyledAttributes.getString(R$styleable.ViewType_view_type);
            obtainStyledAttributes.recycle();
        }
        initView();
    }
}
