package cn.damai.ticklet.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.db.db.annotation.Column;
import cn.damai.common.db.db.annotation.Table;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import tb.p41;
import tb.ql1;
import tb.s41;
import tb.xf2;

@Table(name = "ticket")
/* compiled from: Taobao */
public class UserTicketTable implements Serializable, Comparable<UserTicketTable>, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CHECK_OVER = "2";
    public static final String COUPON_TICKET = "41";
    public static final String DYNAMIC_TICKET = "1";
    public static final String FOREIGNERLIVING = "8";
    public static final String HONGKONGLIVINGCERT = "7";
    public static final String HONGKONGMACAU = "3";
    public static final String IDCARD = "1";
    public static final String INVAILD_TICKET = "5";
    public static final String LIVE_TICKET = "31";
    public static final String NUMBER_CODE_TICKET = "5";
    public static final String PAPER_TICKET = "4";
    public static final String PASSPORT = "2";
    public static final String PDF_TICKET = "21";
    public static final String REAL_NAMR = "3";
    public static final String REFUND_OVER = "4";
    public static final String STATIC_NUM_TICKET = "6";
    public static final String STATIC_TICKET = "2";
    public static final String TAIWAN = "4";
    public static final String TAKE_OVER = "3";
    public static final String TICKET_VOUCHER_SUB_TYPE = "1";
    public static final String TICKLET_BIND_FACE = "1";
    public static final String TIRNSFER_SELLING = "8";
    public static final String TIRNSFER_SOLD = "9";
    public static final String TRANSFER_OVER = "7";
    public static final String TRANSFER_RUNNING = "6";
    public static final String UNUSED = "1";
    public static final String USING = "20";
    private static final long serialVersionUID = 1;
    public TicketEventCodeBean activityCodeInfoVO;
    @Column(name = "checkCountDown")
    public String checkCountDown;
    @Column(name = "checkDirection")
    public String checkDirection;
    @Column(name = "ecertState")
    public String ecertState;
    @Column(name = "exchangeCode")
    public String exchangeCode;
    private TicketExtAttr extAttr;
    @Column(isId = true, name = "id")
    public int id;
    public String isForgotCardEntrance;
    @Column(name = "localExtAttr")
    private String localExtAttr;
    private ArrayList<PerformOpModule> opTypeList;
    @Column(name = "opTypeListLocal")
    private String opTypeListLocal;
    @Column(name = "orderby")
    public int orderby;
    @Column(name = TicketDetailExtFragment.PERFORM_ID)
    public String performId;
    @Column(name = "price")
    public String price;
    @Column(name = TicketDetailExtFragment.PRODUCT_SYSTEM_ID)
    public String productSystemId;
    @Column(name = "productSystemVoucherId")
    public String productSystemVoucherId;
    @Column(name = "productSystemVoucherIdWithPre")
    public String productSystemVoucherIdWithPre;
    @Column(name = "pubKey")
    public String pubKey;
    @Column(name = "realNameTicketQrCodeType")
    public String realNameTicketQrCodeType;
    @Column(name = "realNameTicketShowMode")
    public String realNameTicketShowMode;
    @Column(name = "recvUserMobile")
    public String recvUserMobile;
    @Column(name = "recvUserNick")
    public String recvUserNick;
    @Column(name = "seatInfo")
    public String seatInfo;
    @Column(name = "staticUrl")
    public String staticUrl;
    private ArrayList<SubCouponNumBean> subTicketList;
    @Column(name = "subTicketListLocal")
    public String subTicketListLocal;
    @Column(name = "tips")
    public String tips;
    @Column(name = "tradeOrderId")
    public String tradeOrderId;
    @Column(name = "transferState")
    private String transferState;
    @Column(name = "useTips")
    public String useTips;
    @Column(name = "userCode")
    public String userCode;
    @Column(name = "verifyCode")
    public String verifyCode;
    @Column(name = "voucherCertName")
    public String voucherCertName;
    @Column(name = "voucherCertNo")
    public String voucherCertNo;
    @Column(name = "voucherCertType")
    public String voucherCertType;
    @Column(name = "voucherState")
    public String voucherState;
    @Column(name = "voucherSubType")
    private String voucherSubType;
    @Column(name = "voucherType")
    public String voucherType;
    @Column(name = "voucherUniqueKey")
    public String voucherUniqueKey;

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903214790")) {
            return ipChange.ipc$dispatch("903214790", new Object[]{this});
        }
        try {
            return (UserTicketTable) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public String getCheckCountDown() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-17134858")) {
            return this.checkCountDown;
        }
        return (String) ipChange.ipc$dispatch("-17134858", new Object[]{this});
    }

    public String getCheckDirection() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1317758244")) {
            return this.checkDirection;
        }
        return (String) ipChange.ipc$dispatch("1317758244", new Object[]{this});
    }

    public String getExchangeCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2049323645")) {
            return this.exchangeCode;
        }
        return (String) ipChange.ipc$dispatch("2049323645", new Object[]{this});
    }

    public TicketExtAttr getExtAttr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2101200931")) {
            return (TicketExtAttr) ipChange.ipc$dispatch("2101200931", new Object[]{this});
        }
        if (this.extAttr == null && !TextUtils.isEmpty(this.localExtAttr)) {
            this.extAttr = (TicketExtAttr) s41.a(getLocalExtAttr(), TicketExtAttr.class);
        }
        return this.extAttr;
    }

    public int getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-261772373")) {
            return this.id;
        }
        return ((Integer) ipChange.ipc$dispatch("-261772373", new Object[]{this})).intValue();
    }

    public String getLocalExtAttr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-428780524")) {
            return this.localExtAttr;
        }
        return (String) ipChange.ipc$dispatch("-428780524", new Object[]{this});
    }

    public ArrayList<PerformOpModule> getOpTypeList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585470196")) {
            return (ArrayList) ipChange.ipc$dispatch("585470196", new Object[]{this});
        }
        if (xf2.e(this.opTypeList) == 0 && !TextUtils.isEmpty(this.opTypeListLocal)) {
            this.opTypeList = p41.a(this.opTypeListLocal, PerformOpModule.class);
        }
        return this.opTypeList;
    }

    public String getOpTypeListLocal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-507324805")) {
            return this.opTypeListLocal;
        }
        return (String) ipChange.ipc$dispatch("-507324805", new Object[]{this});
    }

    public int getOrderby() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1459639461")) {
            return this.orderby;
        }
        return ((Integer) ipChange.ipc$dispatch("1459639461", new Object[]{this})).intValue();
    }

    public String getPerformId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "536642917")) {
            return this.performId;
        }
        return (String) ipChange.ipc$dispatch("536642917", new Object[]{this});
    }

    public String getPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-320589614")) {
            return this.price;
        }
        return (String) ipChange.ipc$dispatch("-320589614", new Object[]{this});
    }

    public String getProductSystemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "277262274")) {
            return this.productSystemId;
        }
        return (String) ipChange.ipc$dispatch("277262274", new Object[]{this});
    }

    public String getProductSystemVoucherIdWithPre() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2147148411")) {
            return this.productSystemVoucherIdWithPre;
        }
        return (String) ipChange.ipc$dispatch("2147148411", new Object[]{this});
    }

    public String getPubKey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-980844945")) {
            return this.pubKey;
        }
        return (String) ipChange.ipc$dispatch("-980844945", new Object[]{this});
    }

    public String getRealNameTicketQrCodeType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1267001366")) {
            return this.realNameTicketQrCodeType;
        }
        return (String) ipChange.ipc$dispatch("-1267001366", new Object[]{this});
    }

    public String getRealNameTicketShowMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-466193438")) {
            return this.realNameTicketShowMode;
        }
        return (String) ipChange.ipc$dispatch("-466193438", new Object[]{this});
    }

    public String getRecvUserMobile() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-215148896")) {
            return this.recvUserMobile;
        }
        return (String) ipChange.ipc$dispatch("-215148896", new Object[]{this});
    }

    public String getRecvUserNick() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2100487073")) {
            return this.recvUserNick;
        }
        return (String) ipChange.ipc$dispatch("2100487073", new Object[]{this});
    }

    public String getStaticUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "570365098")) {
            return this.staticUrl;
        }
        return (String) ipChange.ipc$dispatch("570365098", new Object[]{this});
    }

    public ArrayList<SubCouponNumBean> getSubTicketList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169477735")) {
            return (ArrayList) ipChange.ipc$dispatch("1169477735", new Object[]{this});
        }
        if (xf2.e(this.subTicketList) == 0 && !TextUtils.isEmpty(this.subTicketListLocal)) {
            this.subTicketList = p41.a(this.subTicketListLocal, SubCouponNumBean.class);
        }
        return this.subTicketList;
    }

    public String getSubTicketListLocal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1916795602")) {
            return this.subTicketListLocal;
        }
        return (String) ipChange.ipc$dispatch("-1916795602", new Object[]{this});
    }

    public String getTips() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1639174907")) {
            return this.tips;
        }
        return (String) ipChange.ipc$dispatch("-1639174907", new Object[]{this});
    }

    public String getTransferState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1916569711")) {
            return this.transferState;
        }
        return (String) ipChange.ipc$dispatch("1916569711", new Object[]{this});
    }

    public String getUseTips() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-206769560")) {
            return this.useTips;
        }
        return (String) ipChange.ipc$dispatch("-206769560", new Object[]{this});
    }

    public String getUserCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-781424347")) {
            return this.userCode;
        }
        return (String) ipChange.ipc$dispatch("-781424347", new Object[]{this});
    }

    public String getVerifyCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "762422099")) {
            return this.verifyCode;
        }
        return (String) ipChange.ipc$dispatch("762422099", new Object[]{this});
    }

    public String getVoucherCertName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "464683942")) {
            return this.voucherCertName;
        }
        return (String) ipChange.ipc$dispatch("464683942", new Object[]{this});
    }

    public String getVoucherCertNo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1505242148")) {
            return this.voucherCertNo;
        }
        return (String) ipChange.ipc$dispatch("-1505242148", new Object[]{this});
    }

    public String getVoucherCertType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1946981675")) {
            return this.voucherCertType;
        }
        return (String) ipChange.ipc$dispatch("-1946981675", new Object[]{this});
    }

    public String getVoucherState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-142580016")) {
            return this.voucherState;
        }
        return (String) ipChange.ipc$dispatch("-142580016", new Object[]{this});
    }

    public String getVoucherSubType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1964079193")) {
            return this.voucherSubType;
        }
        return (String) ipChange.ipc$dispatch("1964079193", new Object[]{this});
    }

    public String getVoucherType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1597239663")) {
            return this.voucherType;
        }
        return (String) ipChange.ipc$dispatch("-1597239663", new Object[]{this});
    }

    public String getVoucherUniqueKey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1258505357")) {
            return this.voucherUniqueKey;
        }
        return (String) ipChange.ipc$dispatch("1258505357", new Object[]{this});
    }

    public boolean hasAvailableTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1347347434")) {
            return "1".equals(getVoucherState()) || "20".equals(getVoucherState());
        }
        return ((Boolean) ipChange.ipc$dispatch("1347347434", new Object[]{this})).booleanValue();
    }

    public boolean isCertCardTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-907782533")) {
            return "3".equals(getVoucherType());
        }
        return ((Boolean) ipChange.ipc$dispatch("-907782533", new Object[]{this})).booleanValue();
    }

    public boolean isCertETicketShowMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1039257770")) {
            return "2".equals(getRealNameTicketShowMode());
        }
        return ((Boolean) ipChange.ipc$dispatch("1039257770", new Object[]{this})).booleanValue();
    }

    public boolean isCertShowMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-76758153")) {
            return "1".equals(getRealNameTicketShowMode());
        }
        return ((Boolean) ipChange.ipc$dispatch("-76758153", new Object[]{this})).booleanValue();
    }

    public boolean isCouponTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1323840919")) {
            return COUPON_TICKET.equals(getVoucherType());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1323840919", new Object[]{this})).booleanValue();
    }

    public boolean isDynamicQrcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600485142")) {
            return ((Boolean) ipChange.ipc$dispatch("-1600485142", new Object[]{this})).booleanValue();
        } else if (isDynamicTicket() || (isCertCardTicket() && isCertETicketShowMode() && "2".equals(getRealNameTicketQrCodeType()))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDynamicTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1346451284")) {
            return "1".equals(getVoucherType());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1346451284", new Object[]{this})).booleanValue();
    }

    public boolean isLiveTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "311249123")) {
            return "31".equals(getVoucherType());
        }
        return ((Boolean) ipChange.ipc$dispatch("311249123", new Object[]{this})).booleanValue();
    }

    public boolean isNftTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-858445105")) {
            return "1".equals(getVoucherSubType());
        }
        return ((Boolean) ipChange.ipc$dispatch("-858445105", new Object[]{this})).booleanValue();
    }

    public boolean isNumCodeTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1380576472")) {
            return "5".equals(getVoucherType());
        }
        return ((Boolean) ipChange.ipc$dispatch("1380576472", new Object[]{this})).booleanValue();
    }

    public boolean isPaperTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1827698047")) {
            return "4".equals(getVoucherType());
        }
        return ((Boolean) ipChange.ipc$dispatch("1827698047", new Object[]{this})).booleanValue();
    }

    public boolean isPdfTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1449844825")) {
            return "21".equals(getVoucherType());
        }
        return ((Boolean) ipChange.ipc$dispatch("1449844825", new Object[]{this})).booleanValue();
    }

    public boolean isStaticQrcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "688203103")) {
            return ((Boolean) ipChange.ipc$dispatch("688203103", new Object[]{this})).booleanValue();
        } else if (isStaticTicket() || isThirdStaticNumTicket() || isCouponTicket() || (isCertCardTicket() && isCertETicketShowMode() && "1".equals(getRealNameTicketQrCodeType()))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStaticTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "942236961")) {
            return "2".equals(getVoucherType());
        }
        return ((Boolean) ipChange.ipc$dispatch("942236961", new Object[]{this})).booleanValue();
    }

    public boolean isThirdStaticNumTicket() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1705712546")) {
            return "6".equals(getVoucherType());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1705712546", new Object[]{this})).booleanValue();
    }

    public boolean isTransferStateEnable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-100555506")) {
            return "1".equals(this.transferState);
        }
        return ((Boolean) ipChange.ipc$dispatch("-100555506", new Object[]{this})).booleanValue();
    }

    public void setCheckCountDown(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "351712680")) {
            ipChange.ipc$dispatch("351712680", new Object[]{this, str});
            return;
        }
        this.checkCountDown = str;
    }

    public void setCheckDirection(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216274118")) {
            ipChange.ipc$dispatch("-1216274118", new Object[]{this, str});
            return;
        }
        this.checkDirection = str;
    }

    public void setExchangeCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497595391")) {
            ipChange.ipc$dispatch("-497595391", new Object[]{this, str});
            return;
        }
        this.exchangeCode = str;
    }

    public void setExtAttr(TicketExtAttr ticketExtAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927881213")) {
            ipChange.ipc$dispatch("1927881213", new Object[]{this, ticketExtAttr});
            return;
        }
        this.extAttr = ticketExtAttr;
    }

    public void setId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "260403799")) {
            ipChange.ipc$dispatch("260403799", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.id = i;
    }

    public void setLocalExtAttr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-9413302")) {
            ipChange.ipc$dispatch("-9413302", new Object[]{this, str});
            return;
        }
        this.localExtAttr = str;
    }

    public void setOpTypeList(ArrayList<PerformOpModule> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1321564636")) {
            ipChange.ipc$dispatch("1321564636", new Object[]{this, arrayList});
            return;
        }
        this.opTypeList = arrayList;
    }

    public void setOpTypeListLocal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734613595")) {
            ipChange.ipc$dispatch("1734613595", new Object[]{this, str});
            return;
        }
        this.opTypeListLocal = str;
    }

    public void setOrderby(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "527443973")) {
            ipChange.ipc$dispatch("527443973", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.orderby = i;
    }

    public void setPerformId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1785823665")) {
            ipChange.ipc$dispatch("1785823665", new Object[]{this, str});
            return;
        }
        this.performId = str;
    }

    public void setPrice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143024100")) {
            ipChange.ipc$dispatch("1143024100", new Object[]{this, str});
            return;
        }
        this.price = str;
    }

    public void setProductSystemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "287009268")) {
            ipChange.ipc$dispatch("287009268", new Object[]{this, str});
            return;
        }
        this.productSystemId = str;
    }

    public void setProductSystemVoucherIdWithPre(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025357477")) {
            ipChange.ipc$dispatch("-1025357477", new Object[]{this, str});
            return;
        }
        this.productSystemVoucherIdWithPre = str;
    }

    public void setPubKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1736514225")) {
            ipChange.ipc$dispatch("-1736514225", new Object[]{this, str});
            return;
        }
        this.pubKey = str;
    }

    public void setRealNameTicketQrCodeType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891815476")) {
            ipChange.ipc$dispatch("891815476", new Object[]{this, str});
            return;
        }
        this.realNameTicketQrCodeType = str;
    }

    public void setRealNameTicketShowMode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-118278596")) {
            ipChange.ipc$dispatch("-118278596", new Object[]{this, str});
            return;
        }
        this.realNameTicketShowMode = str;
    }

    public void setRecvUserMobile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1491755202")) {
            ipChange.ipc$dispatch("-1491755202", new Object[]{this, str});
            return;
        }
        this.recvUserMobile = str;
    }

    public void setRecvUserNick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088470877")) {
            ipChange.ipc$dispatch("1088470877", new Object[]{this, str});
            return;
        }
        this.recvUserNick = str;
    }

    public void setStaticUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463756020")) {
            ipChange.ipc$dispatch("-1463756020", new Object[]{this, str});
            return;
        }
        this.staticUrl = str;
    }

    public void setSubTicketList(ArrayList<SubCouponNumBean> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1352169167")) {
            ipChange.ipc$dispatch("-1352169167", new Object[]{this, arrayList});
            return;
        }
        this.subTicketList = arrayList;
    }

    public void setSubTicketListLocal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666871920")) {
            ipChange.ipc$dispatch("666871920", new Object[]{this, str});
            return;
        }
        this.subTicketListLocal = str;
    }

    public void setTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432428665")) {
            ipChange.ipc$dispatch("432428665", new Object[]{this, str});
            return;
        }
        this.tips = str;
    }

    public void setTransferState(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1710422503")) {
            ipChange.ipc$dispatch("1710422503", new Object[]{this, str});
            return;
        }
        this.transferState = str;
    }

    public void setUseTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "563824654")) {
            ipChange.ipc$dispatch("563824654", new Object[]{this, str});
            return;
        }
        this.useTips = str;
    }

    public void setUserCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1663321177")) {
            ipChange.ipc$dispatch("1663321177", new Object[]{this, str});
            return;
        }
        this.userCode = str;
    }

    public void setVerifyCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50365163")) {
            ipChange.ipc$dispatch("50365163", new Object[]{this, str});
            return;
        }
        this.verifyCode = str;
    }

    public void setVoucherCertName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1802113680")) {
            ipChange.ipc$dispatch("1802113680", new Object[]{this, str});
            return;
        }
        this.voucherCertName = str;
    }

    public void setVoucherCertNo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1286530022")) {
            ipChange.ipc$dispatch("-1286530022", new Object[]{this, str});
            return;
        }
        this.voucherCertNo = str;
    }

    public void setVoucherCertType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54923585")) {
            ipChange.ipc$dispatch("54923585", new Object[]{this, str});
            return;
        }
        this.voucherCertType = str;
    }

    public void setVoucherState(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "272867854")) {
            ipChange.ipc$dispatch("272867854", new Object[]{this, str});
            return;
        }
        this.voucherState = str;
    }

    public void setVoucherSubType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639806117")) {
            ipChange.ipc$dispatch("1639806117", new Object[]{this, str});
            return;
        }
        this.voucherSubType = str;
    }

    public void setVoucherType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274773243")) {
            ipChange.ipc$dispatch("-274773243", new Object[]{this, str});
            return;
        }
        this.voucherType = str;
    }

    public void setVoucherUniqueKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812834319")) {
            ipChange.ipc$dispatch("-812834319", new Object[]{this, str});
            return;
        }
        this.voucherUniqueKey = str;
    }

    public int compareTo(@NonNull UserTicketTable userTicketTable) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1524220455")) {
            return ((Integer) ipChange.ipc$dispatch("1524220455", new Object[]{this, userTicketTable})).intValue();
        }
        int a = ql1.a(this) - ql1.a(userTicketTable);
        if (a == 0) {
            if (isCertCardTicket() && userTicketTable.isCertCardTicket() && getVoucherCertNo() != null && userTicketTable.getVoucherCertNo() != null) {
                return getVoucherCertNo().compareTo(userTicketTable.getVoucherCertNo());
            }
            if (isNumCodeTicket() && userTicketTable.isNumCodeTicket() && getExchangeCode() != null && userTicketTable.getExchangeCode() != null) {
                return getExchangeCode().compareTo(userTicketTable.getExchangeCode());
            }
            if (isCouponTicket() && userTicketTable.isCouponTicket() && (str = this.productSystemVoucherId) != null && (str2 = userTicketTable.productSystemVoucherId) != null) {
                return str.compareTo(str2);
            }
        }
        return a;
    }
}
