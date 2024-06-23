package cn.damai.ticklet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$styleable;
import cn.damai.ticklet.bean.TicketEventCodeBean;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import tb.by0;
import tb.g91;
import tb.gl2;
import tb.lw2;
import tb.q92;
import tb.s50;
import tb.sl2;

/* compiled from: Taobao */
public class TickletDetailEventCodeView extends ConstraintLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TicketEventCodeBean codeBean;
    Context context;
    private ImageView downArrow;
    private TextView eventCodeCopy;
    private TextView eventCodeNum;
    private DMIconFontTextView eventCodeTipIcon;
    private TextView eventCodeTitle;
    private DMIconFontTextView iconArrow;
    private Map<String, String> map;
    View parent;
    private String performId;
    private TextView popText;
    private View popWindowView;
    int popupHeight;
    int popupWidth;
    private PopupWindow popupWindow;
    private String projectId;
    private ImageView upArrow;
    private String viewType;
    float xloc;
    float ylocArrow;

    /* compiled from: Taobao */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-36095054")) {
                ipChange.ipc$dispatch("-36095054", new Object[]{this});
                return;
            }
            TickletDetailEventCodeView.this.popText.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            TickletDetailEventCodeView tickletDetailEventCodeView = TickletDetailEventCodeView.this;
            tickletDetailEventCodeView.popupWidth = tickletDetailEventCodeView.popWindowView.getMeasuredWidth();
            TickletDetailEventCodeView tickletDetailEventCodeView2 = TickletDetailEventCodeView.this;
            tickletDetailEventCodeView2.popupHeight = tickletDetailEventCodeView2.popWindowView.getMeasuredHeight();
            g91.b("TickletDetailEventCodeView", "addOnGlobalLayoutListener.getHeight = " + TickletDetailEventCodeView.this.popWindowView.getMeasuredHeight());
            g91.b("TickletDetailEventCodeView", "addOnGlobalLayoutListener.width = " + TickletDetailEventCodeView.this.popWindowView.getMeasuredWidth());
            TickletDetailEventCodeView.this.popupWindow.dismiss();
            PopupWindow popupWindow = TickletDetailEventCodeView.this.popupWindow;
            ImageView imageView = TickletDetailEventCodeView.this.downArrow;
            TickletDetailEventCodeView tickletDetailEventCodeView3 = TickletDetailEventCodeView.this;
            popupWindow.showAtLocation(imageView, 0, (int) tickletDetailEventCodeView3.xloc, tickletDetailEventCodeView3.popWindowYCal(tickletDetailEventCodeView3.ylocArrow));
        }
    }

    public TickletDetailEventCodeView(Context context2) {
        this(context2, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void downArrow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627838625")) {
            ipChange.ipc$dispatch("1627838625", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (this.downArrow.getVisibility() != 0) {
                this.downArrow.setVisibility(0);
            }
        } else if (this.downArrow.getVisibility() != 4) {
            this.downArrow.setVisibility(4);
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "605366235")) {
            ipChange.ipc$dispatch("605366235", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_detail_event_code_layout, this);
        this.parent = inflate;
        this.eventCodeTitle = (TextView) inflate.findViewById(R$id.ticklet_detail_event_code_title);
        this.eventCodeNum = (TextView) this.parent.findViewById(R$id.ticklet_detail_event_code_num);
        this.eventCodeCopy = (TextView) this.parent.findViewById(R$id.ticklet_detail_event_code_copy);
        this.eventCodeTipIcon = (DMIconFontTextView) this.parent.findViewById(R$id.ticklet_detail_event_code_tip_icon);
        this.iconArrow = (DMIconFontTextView) this.parent.findViewById(R$id.tiklet_detail_event_code_icon_arrow);
        this.downArrow = (ImageView) this.parent.findViewById(R$id.ticklet_down_code_arrow);
        this.upArrow = (ImageView) this.parent.findViewById(R$id.ticklet_down_code_arrow_bottom);
        popWindowInit();
        this.eventCodeTipIcon.setOnClickListener(this);
        this.eventCodeTitle.setOnClickListener(this);
        this.eventCodeCopy.setOnClickListener(this);
        this.iconArrow.setOnClickListener(this);
    }

    private void popWindowInit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1891553271")) {
            ipChange.ipc$dispatch("-1891553271", new Object[]{this});
            return;
        }
        View inflate = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R$layout.ticklet_detail_pop_layout, (ViewGroup) null, false);
        this.popWindowView = inflate;
        this.popText = (TextView) inflate.findViewById(R$id.ticklet_detail_pop_tip_content);
        PopupWindow popupWindow2 = new PopupWindow(this.popWindowView, -2, -2, true);
        this.popupWindow = popupWindow2;
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class cn.damai.ticklet.view.TickletDetailEventCodeView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onDismiss() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "516966530")) {
                    ipChange.ipc$dispatch("516966530", new Object[]{this});
                    return;
                }
                TickletDetailEventCodeView.this.downArrow(false);
                TickletDetailEventCodeView.this.upArrow(false);
            }
        });
        this.popText.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int popWindowYCal(float f) {
        int i;
        int i2;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-432762417")) {
            return ((Integer) ipChange.ipc$dispatch("-432762417", new Object[]{this, Float.valueOf(f)})).intValue();
        }
        Context context2 = this.context;
        if (context2 == null || !(context2 instanceof TicketDeatilActivity)) {
            i2 = 0;
            i = 0;
        } else {
            i2 = ((TicketDeatilActivity) context2).getBarStatusBarHeight();
            i = ((TicketDeatilActivity) this.context).getTitleHeight();
        }
        if ((f - ((float) i2)) - ((float) i) < ((float) this.popupHeight)) {
            upArrow(true);
            downArrow(false);
            int[] iArr = new int[2];
            this.upArrow.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            f2 = ((float) iArr[1]) + ((float) s50.a(this.context, 6.0f));
        } else {
            upArrow(false);
            downArrow(true);
            f2 = f - ((float) this.popupHeight);
        }
        g91.b("TickletDetailEventCodeView", "yloc = " + f2);
        return (int) f2;
    }

    private void showPop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007799002")) {
            ipChange.ipc$dispatch("-1007799002", new Object[]{this});
            return;
        }
        this.popWindowView.measure(0, 0);
        this.popupWidth = this.popWindowView.getMeasuredWidth();
        int a2 = s50.a(this.context, 6.0f);
        g91.b("TickletDetailEventCodeView", "popupWidth = " + this.popupWidth);
        g91.b("TickletDetailEventCodeView", "popupHeight = " + this.popupHeight);
        int i = DisplayMetrics.getwidthPixels(s50.b(this.context));
        int a3 = s50.a(this.context, 15.0f);
        int i2 = i - (a3 * 2);
        int i3 = this.popupWidth;
        if (i3 > i2) {
            this.popupWindow.setWidth(i2);
            this.popupWidth = i2;
        } else {
            this.popupWindow.setWidth(i3);
        }
        int[] iArr = new int[2];
        this.downArrow.getLocationOnScreen(iArr);
        float f = (float) iArr[1];
        float f2 = (float) iArr[0];
        this.xloc = f2;
        this.ylocArrow = f;
        if (f2 >= ((float) (i / 2))) {
            int i4 = this.popupWidth;
            if (((float) (i - a3)) - f2 >= ((float) (i4 / 2))) {
                this.xloc = (f2 - ((float) (i4 / 2))) + ((float) a2);
            } else {
                this.xloc = (f2 - ((float) (i4 / 2))) - (((float) (i4 / 2)) - ((((float) i) - f2) - ((float) a3)));
            }
        } else {
            float f3 = (float) a3;
            int i5 = this.popupWidth;
            if (f2 - f3 >= ((float) (i5 / 2))) {
                this.xloc = (f2 - ((float) (i5 / 2))) + ((float) a2);
            } else {
                this.xloc = f3;
            }
        }
        g91.b("TickletDetailEventCodeView", "xloc = " + this.xloc);
        g91.b("TickletDetailEventCodeView", "y = " + f);
        this.popupWindow.showAtLocation(this.downArrow, 0, (int) this.xloc, popWindowYCal(f));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void upArrow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-516767352")) {
            ipChange.ipc$dispatch("-516767352", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (this.upArrow.getVisibility() != 0) {
                this.upArrow.setVisibility(0);
            }
        } else if (this.upArrow.getVisibility() != 4) {
            this.upArrow.setVisibility(4);
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763769089")) {
            ipChange.ipc$dispatch("763769089", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_detail_event_code_copy) {
            Context context2 = this.context;
            if (context2 != null) {
                q92.b(context2, this.codeBean.code, "券码已复制至剪切板");
                c.e().x(b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "thirdcode", by0.ARG_COPY, sl2.j().s(this.projectId, this.performId), Boolean.FALSE));
            }
        } else if (view.getId() == R$id.tiklet_detail_event_code_icon_arrow) {
            lw2.f().n(this.context, this.codeBean.schema);
            c.e().x(b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "thirdcode", "open", sl2.j().s(this.projectId, this.performId), Boolean.FALSE));
        } else if ((view.getId() == R$id.ticklet_detail_event_code_tip_icon || view.getId() == R$id.ticklet_detail_event_code_title) && !TextUtils.isEmpty(this.codeBean.description)) {
            showPop();
            c.e().x(b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, "thirdcode", "info", sl2.j().s(this.projectId, this.performId), Boolean.FALSE));
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0100, code lost:
        if (r15.equals("3") == false) goto L_0x00ed;
     */
    public void update(TicketEventCodeBean ticketEventCodeBean, String str) {
        IpChange ipChange = $ipChange;
        char c = 2;
        if (AndroidInstantRuntime.support(ipChange, "-942833460")) {
            ipChange.ipc$dispatch("-942833460", new Object[]{this, ticketEventCodeBean, str});
        } else if (ticketEventCodeBean == null || (TextUtils.isEmpty(ticketEventCodeBean.title) && TextUtils.isEmpty(ticketEventCodeBean.code))) {
            setVisibility(8);
        } else {
            if (getVisibility() == 8) {
                setVisibility(0);
                Context context2 = this.context;
                if (((TicketDeatilActivity) context2) != null) {
                    this.performId = ((TicketDeatilActivity) context2).getPerformId();
                    this.projectId = ((TicketDeatilActivity) this.context).getProjectId();
                    this.map = sl2.j().s(this.projectId, this.performId);
                }
                c.e().G(this.parent, "card", "thirdcode", sl2.TICKLET_DETAIL_PAGE, this.map);
            }
            this.codeBean = ticketEventCodeBean;
            if (TextUtils.isEmpty(ticketEventCodeBean.title)) {
                lw2.D(this.eventCodeTitle, false);
                lw2.D(this.eventCodeTipIcon, false);
                lw2.D(this.iconArrow, false);
            } else {
                lw2.E(this.eventCodeTitle, ticketEventCodeBean.title);
                if (!TextUtils.isEmpty(ticketEventCodeBean.description)) {
                    lw2.D(this.eventCodeTipIcon, true);
                    c.e().G(this.eventCodeTipIcon, "info", "thirdcode", sl2.TICKLET_DETAIL_PAGE, this.map);
                }
                if (!TextUtils.isEmpty(ticketEventCodeBean.schema)) {
                    lw2.D(this.iconArrow, true);
                    c.e().G(this.iconArrow, "open", "thirdcode", sl2.TICKLET_DETAIL_PAGE, this.map);
                }
            }
            if (!TextUtils.isEmpty(ticketEventCodeBean.code)) {
                lw2.E(this.eventCodeNum, ticketEventCodeBean.code);
                lw2.D(this.eventCodeCopy, true);
            }
            str.hashCode();
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 51:
                    break;
                case SecExceptionCode.SEC_ERROR_SIMULATORDETECT_UNSUPPORTED /*{ENCODED_INT: 1598}*/:
                    if (str.equals("20")) {
                        c = 3;
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
                case 1:
                case 2:
                case 3:
                    this.eventCodeTitle.setTextColor(Color.parseColor("#000000"));
                    this.eventCodeNum.setTextColor(Color.parseColor("#000000"));
                    break;
                default:
                    this.eventCodeTitle.setTextColor(Color.parseColor("#DDDDDD"));
                    this.eventCodeNum.setTextColor(Color.parseColor("#DDDDDD"));
                    lw2.D(this.iconArrow, false);
                    lw2.D(this.eventCodeCopy, false);
                    break;
            }
            this.popText.setText(ticketEventCodeBean.description);
        }
    }

    public TickletDetailEventCodeView(Context context2, @Nullable AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletDetailEventCodeView(Context context2, @Nullable AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.map = new HashMap();
        this.viewType = "DEFAULT";
        this.popupWidth = 0;
        this.popupHeight = 0;
        this.xloc = 0.0f;
        this.ylocArrow = 0.0f;
        this.context = context2;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.ViewType);
        if (obtainStyledAttributes != null) {
            this.viewType = obtainStyledAttributes.getString(R$styleable.ViewType_view_type);
            obtainStyledAttributes.recycle();
        }
        if (gl2.TICKLET_TICKET_VIEW_DETAIL_NFT.equals(this.viewType)) {
            setBackgroundResource(R$drawable.shape_solid_all_radius8_white);
        } else {
            setBackgroundResource(R$drawable.shape_solid_all_radius8_f5f5f5);
        }
        initView();
    }
}
