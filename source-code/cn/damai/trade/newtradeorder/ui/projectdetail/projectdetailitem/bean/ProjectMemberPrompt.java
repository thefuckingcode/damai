package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class ProjectMemberPrompt implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int PRIORITY_PURCHASE_TYPE_PRESALE = 1;
    public static final int PRIORITY_PURCHASE_TYPE_SPECIAL = 2;
    @Nullable
    private String alipayDetailUrl;
    @Nullable
    private String asac;
    @Nullable
    private String buttonStatus;
    @Nullable
    private String buttonText;
    @Nullable
    private ArrayList<ProfitDetailContent> contents;
    @Nullable
    private String exchange4Dm;
    @Nullable
    private String exchangeRule;
    @Nullable
    private String exchangeStartTime;
    @Nullable
    private String itemSaleStage;
    private long launchMsrdc;
    private long launchScd;
    @Nullable
    private String launchTag;
    @Nullable
    private String launchTime;
    private long launchTimeStamp;
    @Nullable
    private String layerButtonText;
    @Nullable
    private String layerTitle;
    private long msrdc;
    @Nullable
    private Long poolRemainingCount;
    @Nullable
    private String postImgUrl;
    @Nullable
    private String preBuyTime;
    private long preBuyTimestamp;
    @Nullable
    private Integer priorityPurchaseType;
    @Nullable
    private String priorityPurchaseTypeName;
    @Nullable
    private Boolean privilegeStart = Boolean.FALSE;
    @Nullable
    private String profitDesc;
    @Nullable
    private String profitId;
    @Nullable
    private String profitName;
    @Nullable
    private String profitType;
    private long scd;
    @Nullable
    private String score;
    private final long serialVersionUID = -1;
    @Nullable
    private String snatchTicketsTag;
    @Nullable
    private String speedUpCardUrl;
    @Nullable
    private String spreadId;
    @Nullable
    private String userScore;
    @Nullable
    private String vipLogo;

    /* compiled from: Taobao */
    public static final class BannerVO implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private Bitmap localBitmap;
        @Nullable
        private String pic;
        @Nullable
        private String url;

        @Nullable
        public final Bitmap getLocalBitmap() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "558502017")) {
                return this.localBitmap;
            }
            return (Bitmap) ipChange.ipc$dispatch("558502017", new Object[]{this});
        }

        @Nullable
        public final String getPic() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1231989395")) {
                return this.pic;
            }
            return (String) ipChange.ipc$dispatch("-1231989395", new Object[]{this});
        }

        @Nullable
        public final String getUrl() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1436386514")) {
                return this.url;
            }
            return (String) ipChange.ipc$dispatch("1436386514", new Object[]{this});
        }

        public final void setLocalBitmap(@Nullable Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "996870751")) {
                ipChange.ipc$dispatch("996870751", new Object[]{this, bitmap});
                return;
            }
            this.localBitmap = bitmap;
        }

        public final void setPic(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1881582505")) {
                ipChange.ipc$dispatch("1881582505", new Object[]{this, str});
                return;
            }
            this.pic = str;
        }

        public final void setUrl(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1298110236")) {
                ipChange.ipc$dispatch("-1298110236", new Object[]{this, str});
                return;
            }
            this.url = str;
        }
    }

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class ITEM_SALE_STAGE {
        @NotNull
        public static final String BEFORE_SALE = "BEFORE_SALE";
        @NotNull
        public static final ITEM_SALE_STAGE INSTANCE = new ITEM_SALE_STAGE();
        @NotNull
        public static final String IN_SALE = "IN_SALE";

        private ITEM_SALE_STAGE() {
        }
    }

    /* compiled from: Taobao */
    public static final class ProfitDetailContent implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private List<BannerVO> banners;
        @Nullable
        private String content;
        @Nullable
        private String subTitle;
        @Nullable
        private String title;

        @Nullable
        public final List<BannerVO> getBanners() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "297416612")) {
                return this.banners;
            }
            return (List) ipChange.ipc$dispatch("297416612", new Object[]{this});
        }

        @Nullable
        public final String getContent() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-861309073")) {
                return this.content;
            }
            return (String) ipChange.ipc$dispatch("-861309073", new Object[]{this});
        }

        @Nullable
        public final String getSubTitle() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1884917624")) {
                return this.subTitle;
            }
            return (String) ipChange.ipc$dispatch("1884917624", new Object[]{this});
        }

        @Nullable
        public final String getTitle() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "771206798")) {
                return this.title;
            }
            return (String) ipChange.ipc$dispatch("771206798", new Object[]{this});
        }

        public final void setBanners(@Nullable List<BannerVO> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-268072640")) {
                ipChange.ipc$dispatch("-268072640", new Object[]{this, list});
                return;
            }
            this.banners = list;
        }

        public final void setContent(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1747936231")) {
                ipChange.ipc$dispatch("1747936231", new Object[]{this, str});
                return;
            }
            this.content = str;
        }

        public final void setSubTitle(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1579423642")) {
                ipChange.ipc$dispatch("-1579423642", new Object[]{this, str});
                return;
            }
            this.subTitle = str;
        }

        public final void setTitle(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "628974504")) {
                ipChange.ipc$dispatch("628974504", new Object[]{this, str});
                return;
            }
            this.title = str;
        }
    }

    @Nullable
    public final String getAlipayDetailUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-633731734")) {
            return this.alipayDetailUrl;
        }
        return (String) ipChange.ipc$dispatch("-633731734", new Object[]{this});
    }

    @Nullable
    public final String getAsac() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1084718316")) {
            return this.asac;
        }
        return (String) ipChange.ipc$dispatch("-1084718316", new Object[]{this});
    }

    @Nullable
    public final String getButtonStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-374257660")) {
            return this.buttonStatus;
        }
        return (String) ipChange.ipc$dispatch("-374257660", new Object[]{this});
    }

    @Nullable
    public final String getButtonText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1067972479")) {
            return this.buttonText;
        }
        return (String) ipChange.ipc$dispatch("1067972479", new Object[]{this});
    }

    @Nullable
    public final ArrayList<ProfitDetailContent> getContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1775619424")) {
            return this.contents;
        }
        return (ArrayList) ipChange.ipc$dispatch("1775619424", new Object[]{this});
    }

    @Nullable
    public final String getExchange4Dm() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2009094800")) {
            return this.exchange4Dm;
        }
        return (String) ipChange.ipc$dispatch("2009094800", new Object[]{this});
    }

    @Nullable
    public final String getExchangeRule() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "461837951")) {
            return this.exchangeRule;
        }
        return (String) ipChange.ipc$dispatch("461837951", new Object[]{this});
    }

    @Nullable
    public final String getExchangeStartTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "62205410")) {
            return this.exchangeStartTime;
        }
        return (String) ipChange.ipc$dispatch("62205410", new Object[]{this});
    }

    @Nullable
    public final String getItemSaleStage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-974033638")) {
            return this.itemSaleStage;
        }
        return (String) ipChange.ipc$dispatch("-974033638", new Object[]{this});
    }

    public final long getLaunchMsrdc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1641532678")) {
            return this.launchMsrdc;
        }
        return ((Long) ipChange.ipc$dispatch("1641532678", new Object[]{this})).longValue();
    }

    public final long getLaunchScd() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-141210787")) {
            return this.launchScd;
        }
        return ((Long) ipChange.ipc$dispatch("-141210787", new Object[]{this})).longValue();
    }

    @Nullable
    public final String getLaunchTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1907700515")) {
            return this.launchTag;
        }
        return (String) ipChange.ipc$dispatch("-1907700515", new Object[]{this});
    }

    @Nullable
    public final String getLaunchTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "433241760")) {
            return this.launchTime;
        }
        return (String) ipChange.ipc$dispatch("433241760", new Object[]{this});
    }

    public final long getLaunchTimeStamp() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1288272581")) {
            return this.launchTimeStamp;
        }
        return ((Long) ipChange.ipc$dispatch("-1288272581", new Object[]{this})).longValue();
    }

    @Nullable
    public final String getLayerButtonText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "690927334")) {
            return this.layerButtonText;
        }
        return (String) ipChange.ipc$dispatch("690927334", new Object[]{this});
    }

    @Nullable
    public final String getLayerTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-152063097")) {
            return this.layerTitle;
        }
        return (String) ipChange.ipc$dispatch("-152063097", new Object[]{this});
    }

    public final long getMsrdc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1804293107")) {
            return this.msrdc;
        }
        return ((Long) ipChange.ipc$dispatch("1804293107", new Object[]{this})).longValue();
    }

    @Nullable
    public final Long getPoolRemainingCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1938261590")) {
            return this.poolRemainingCount;
        }
        return (Long) ipChange.ipc$dispatch("-1938261590", new Object[]{this});
    }

    @Nullable
    public final String getPostImgUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "454053612")) {
            return this.postImgUrl;
        }
        return (String) ipChange.ipc$dispatch("454053612", new Object[]{this});
    }

    @Nullable
    public final String getPreBuyTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-598657072")) {
            return this.preBuyTime;
        }
        return (String) ipChange.ipc$dispatch("-598657072", new Object[]{this});
    }

    public final long getPreBuyTimestamp() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1247994443")) {
            return this.preBuyTimestamp;
        }
        return ((Long) ipChange.ipc$dispatch("1247994443", new Object[]{this})).longValue();
    }

    @Nullable
    public final Integer getPriorityPurchaseType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1662729656")) {
            return this.priorityPurchaseType;
        }
        return (Integer) ipChange.ipc$dispatch("-1662729656", new Object[]{this});
    }

    @Nullable
    public final String getPriorityPurchaseTypeName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-25859446")) {
            return this.priorityPurchaseTypeName;
        }
        return (String) ipChange.ipc$dispatch("-25859446", new Object[]{this});
    }

    @Nullable
    public final Boolean getPrivilegeStart() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2073547660")) {
            return this.privilegeStart;
        }
        return (Boolean) ipChange.ipc$dispatch("2073547660", new Object[]{this});
    }

    @Nullable
    public final String getProfitDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-841902091")) {
            return this.profitDesc;
        }
        return (String) ipChange.ipc$dispatch("-841902091", new Object[]{this});
    }

    @Nullable
    public final String getProfitId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-610422849")) {
            return this.profitId;
        }
        return (String) ipChange.ipc$dispatch("-610422849", new Object[]{this});
    }

    @Nullable
    public final String getProfitName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1865044719")) {
            return this.profitName;
        }
        return (String) ipChange.ipc$dispatch("1865044719", new Object[]{this});
    }

    @Nullable
    public final String getProfitType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-546620898")) {
            return this.profitType;
        }
        return (String) ipChange.ipc$dispatch("-546620898", new Object[]{this});
    }

    public final long getScd() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-328750710")) {
            return this.scd;
        }
        return ((Long) ipChange.ipc$dispatch("-328750710", new Object[]{this})).longValue();
    }

    @Nullable
    public final String getScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "228946568")) {
            return this.score;
        }
        return (String) ipChange.ipc$dispatch("228946568", new Object[]{this});
    }

    @Nullable
    public final String getSnatchTicketsTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1177737466")) {
            return this.snatchTicketsTag;
        }
        return (String) ipChange.ipc$dispatch("-1177737466", new Object[]{this});
    }

    @Nullable
    public final String getSpeedUpCardUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1613041437")) {
            return this.speedUpCardUrl;
        }
        return (String) ipChange.ipc$dispatch("1613041437", new Object[]{this});
    }

    @Nullable
    public final String getSpreadId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "967067054")) {
            return this.spreadId;
        }
        return (String) ipChange.ipc$dispatch("967067054", new Object[]{this});
    }

    @Nullable
    public final String getUserScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-587291779")) {
            return this.userScore;
        }
        return (String) ipChange.ipc$dispatch("-587291779", new Object[]{this});
    }

    @Nullable
    public final String getVipLogo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1084291486")) {
            return this.vipLogo;
        }
        return (String) ipChange.ipc$dispatch("1084291486", new Object[]{this});
    }

    public final boolean isAuthPopWindow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2051384213")) {
            return k21.d(this.buttonStatus, "4");
        }
        return ((Boolean) ipChange.ipc$dispatch("-2051384213", new Object[]{this})).booleanValue();
    }

    public final boolean isButtonLight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1153274656")) {
            return isSpeedUpCardPage() || isAuthPopWindow() || isMemberAuthPage() || k21.d(this.buttonStatus, "6") || isMemberAlipayPage();
        }
        return ((Boolean) ipChange.ipc$dispatch("1153274656", new Object[]{this})).booleanValue();
    }

    public final boolean isMemberAlipayPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1529233435")) {
            return k21.d(this.buttonStatus, "14");
        }
        return ((Boolean) ipChange.ipc$dispatch("1529233435", new Object[]{this})).booleanValue();
    }

    public final boolean isMemberAuthPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-944932419")) {
            return k21.d(this.buttonStatus, "5");
        }
        return ((Boolean) ipChange.ipc$dispatch("-944932419", new Object[]{this})).booleanValue();
    }

    public final boolean isPromptBeforeSale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "300697092")) {
            return k21.d(ITEM_SALE_STAGE.BEFORE_SALE, this.itemSaleStage);
        }
        return ((Boolean) ipChange.ipc$dispatch("300697092", new Object[]{this})).booleanValue();
    }

    public final boolean isPromptInSale() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "602075678")) {
            return k21.d(ITEM_SALE_STAGE.IN_SALE, this.itemSaleStage);
        }
        return ((Boolean) ipChange.ipc$dispatch("602075678", new Object[]{this})).booleanValue();
    }

    public final boolean isSpecialBuy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072862527")) {
            return ((Boolean) ipChange.ipc$dispatch("-2072862527", new Object[]{this})).booleanValue();
        }
        Integer num = this.priorityPurchaseType;
        return num != null && 2 == num.intValue();
    }

    public final boolean isSpeedUpCardPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-377806749")) {
            return k21.d(this.buttonStatus, "3");
        }
        return ((Boolean) ipChange.ipc$dispatch("-377806749", new Object[]{this})).booleanValue();
    }

    public final void setAlipayDetailUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2110966092")) {
            ipChange.ipc$dispatch("2110966092", new Object[]{this, str});
            return;
        }
        this.alipayDetailUrl = str;
    }

    public final void setAsac(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440713802")) {
            ipChange.ipc$dispatch("440713802", new Object[]{this, str});
            return;
        }
        this.asac = str;
    }

    public final void setButtonStatus(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1680795482")) {
            ipChange.ipc$dispatch("1680795482", new Object[]{this, str});
            return;
        }
        this.buttonStatus = str;
    }

    public final void setButtonText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "932492351")) {
            ipChange.ipc$dispatch("932492351", new Object[]{this, str});
            return;
        }
        this.buttonText = str;
    }

    public final void setContents(@Nullable ArrayList<ProfitDetailContent> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869802512")) {
            ipChange.ipc$dispatch("-869802512", new Object[]{this, arrayList});
            return;
        }
        this.contents = arrayList;
    }

    public final void setExchange4Dm(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147554586")) {
            ipChange.ipc$dispatch("-147554586", new Object[]{this, str});
            return;
        }
        this.exchange4Dm = str;
    }

    public final void setExchangeRule(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829955647")) {
            ipChange.ipc$dispatch("1829955647", new Object[]{this, str});
            return;
        }
        this.exchangeRule = str;
    }

    public final void setExchangeStartTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355604780")) {
            ipChange.ipc$dispatch("-1355604780", new Object[]{this, str});
            return;
        }
        this.exchangeStartTime = str;
    }

    public final void setItemSaleStage(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1998935396")) {
            ipChange.ipc$dispatch("-1998935396", new Object[]{this, str});
            return;
        }
        this.itemSaleStage = str;
    }

    public final void setLaunchMsrdc(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267969894")) {
            ipChange.ipc$dispatch("267969894", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.launchMsrdc = j;
    }

    public final void setLaunchScd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913979153")) {
            ipChange.ipc$dispatch("-1913979153", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.launchScd = j;
    }

    public final void setLaunchTag(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974378695")) {
            ipChange.ipc$dispatch("-974378695", new Object[]{this, str});
            return;
        }
        this.launchTag = str;
    }

    public final void setLaunchTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1564290754")) {
            ipChange.ipc$dispatch("-1564290754", new Object[]{this, str});
            return;
        }
        this.launchTime = str;
    }

    public final void setLaunchTimeStamp(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31414737")) {
            ipChange.ipc$dispatch("31414737", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.launchTimeStamp = j;
    }

    public final void setLayerButtonText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "225724240")) {
            ipChange.ipc$dispatch("225724240", new Object[]{this, str});
            return;
        }
        this.layerButtonText = str;
    }

    public final void setLayerTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766095159")) {
            ipChange.ipc$dispatch("1766095159", new Object[]{this, str});
            return;
        }
        this.layerTitle = str;
    }

    public final void setMsrdc(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1647534873")) {
            ipChange.ipc$dispatch("1647534873", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.msrdc = j;
    }

    public final void setPoolRemainingCount(@Nullable Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163910846")) {
            ipChange.ipc$dispatch("163910846", new Object[]{this, l});
            return;
        }
        this.poolRemainingCount = l;
    }

    public final void setPostImgUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-919123342")) {
            ipChange.ipc$dispatch("-919123342", new Object[]{this, str});
            return;
        }
        this.postImgUrl = str;
    }

    public final void setPreBuyTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806583822")) {
            ipChange.ipc$dispatch("806583822", new Object[]{this, str});
            return;
        }
        this.preBuyTime = str;
    }

    public final void setPreBuyTimestamp(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1346281153")) {
            ipChange.ipc$dispatch("1346281153", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.preBuyTimestamp = j;
    }

    public final void setPriorityPurchaseType(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173672062")) {
            ipChange.ipc$dispatch("-173672062", new Object[]{this, num});
            return;
        }
        this.priorityPurchaseType = num;
    }

    public final void setPriorityPurchaseTypeName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "712509332")) {
            ipChange.ipc$dispatch("712509332", new Object[]{this, str});
            return;
        }
        this.priorityPurchaseTypeName = str;
    }

    public final void setPrivilegeStart(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168093226")) {
            ipChange.ipc$dispatch("168093226", new Object[]{this, bool});
            return;
        }
        this.privilegeStart = bool;
    }

    public final void setProfitDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1855922825")) {
            ipChange.ipc$dispatch("1855922825", new Object[]{this, str});
            return;
        }
        this.profitDesc = str;
    }

    public final void setProfitId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625566977")) {
            ipChange.ipc$dispatch("-1625566977", new Object[]{this, str});
            return;
        }
        this.profitId = str;
    }

    public final void setProfitName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-128071985")) {
            ipChange.ipc$dispatch("-128071985", new Object[]{this, str});
            return;
        }
        this.profitName = str;
    }

    public final void setProfitType(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1875262080")) {
            ipChange.ipc$dispatch("-1875262080", new Object[]{this, str});
            return;
        }
        this.profitType = str;
    }

    public final void setScd(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "335498594")) {
            ipChange.ipc$dispatch("335498594", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.scd = j;
    }

    public final void setScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998776558")) {
            ipChange.ipc$dispatch("998776558", new Object[]{this, str});
            return;
        }
        this.score = str;
    }

    public final void setSnatchTicketsTag(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973049496")) {
            ipChange.ipc$dispatch("973049496", new Object[]{this, str});
            return;
        }
        this.snatchTicketsTag = str;
    }

    public final void setSpeedUpCardUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652429727")) {
            ipChange.ipc$dispatch("-652429727", new Object[]{this, str});
            return;
        }
        this.speedUpCardUrl = str;
    }

    public final void setSpreadId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31979760")) {
            ipChange.ipc$dispatch("31979760", new Object[]{this, str});
            return;
        }
        this.spreadId = str;
    }

    public final void setUserScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1303586457")) {
            ipChange.ipc$dispatch("1303586457", new Object[]{this, str});
            return;
        }
        this.userScore = str;
    }

    public final void setVipLogo(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1932011416")) {
            ipChange.ipc$dispatch("1932011416", new Object[]{this, str});
            return;
        }
        this.vipLogo = str;
    }
}
