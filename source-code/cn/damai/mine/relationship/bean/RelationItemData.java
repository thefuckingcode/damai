package cn.damai.mine.relationship.bean;

import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.h03;

/* compiled from: Taobao */
public class RelationItemData implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private long createTime;
    private int dynamicNum;
    private int fansNum;
    private String from;
    private String objectDesc;
    private String objectIdStr;
    private String objectImg;
    private String objectName;
    private int objectType;
    private PerformFilmVipDO performFilmVipDO;
    private List<RecentShowProject> recentShowProject;
    private int recentShowTotalNum;
    private String schema;
    private Integer sex;
    private int status;
    private String tag;
    private boolean vip;
    private String vipLevel;
    private String vipLevelIcon;
    private int vtag;

    /* compiled from: Taobao */
    public static class RecentShowProject {
        private static transient /* synthetic */ IpChange $ipChange;
        private String formattedPriceStr;
        private long id;
        private String name;
        private String priceHigh;
        private String priceLow;
        private String priceStr;
        private List<String> promotionTags;
        private String showTime;
        private String subTitle;
        private List<String> tourProjects;
        private String type;
        private String venueCity;
        private String venueName;
        private String verticalPic;

        public String getFormattedPriceStr() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1847868314")) {
                return this.formattedPriceStr;
            }
            return (String) ipChange.ipc$dispatch("1847868314", new Object[]{this});
        }

        public long getId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "509458233")) {
                return this.id;
            }
            return ((Long) ipChange.ipc$dispatch("509458233", new Object[]{this})).longValue();
        }

        public String getName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "136877099")) {
                return this.name;
            }
            return (String) ipChange.ipc$dispatch("136877099", new Object[]{this});
        }

        public String getPriceHigh() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1144694433")) {
                return this.priceHigh;
            }
            return (String) ipChange.ipc$dispatch("1144694433", new Object[]{this});
        }

        public String getPriceLow() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1551134613")) {
                return this.priceLow;
            }
            return (String) ipChange.ipc$dispatch("-1551134613", new Object[]{this});
        }

        public String getPriceStr() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "210148040")) {
                return this.priceStr;
            }
            return (String) ipChange.ipc$dispatch("210148040", new Object[]{this});
        }

        public List<String> getPromotionTags() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "413271449")) {
                return this.promotionTags;
            }
            return (List) ipChange.ipc$dispatch("413271449", new Object[]{this});
        }

        public String getShowTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1399397642")) {
                return this.showTime;
            }
            return (String) ipChange.ipc$dispatch("1399397642", new Object[]{this});
        }

        public String getSubTitle() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1738525336")) {
                return this.subTitle;
            }
            return (String) ipChange.ipc$dispatch("1738525336", new Object[]{this});
        }

        public List<String> getTourProjects() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "117988409")) {
                return this.tourProjects;
            }
            return (List) ipChange.ipc$dispatch("117988409", new Object[]{this});
        }

        public String getType() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2020178778")) {
                return this.type;
            }
            return (String) ipChange.ipc$dispatch("2020178778", new Object[]{this});
        }

        public String getVenueCity() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "4508432")) {
                return this.venueCity;
            }
            return (String) ipChange.ipc$dispatch("4508432", new Object[]{this});
        }

        public String getVenueName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-651305936")) {
                return this.venueName;
            }
            return (String) ipChange.ipc$dispatch("-651305936", new Object[]{this});
        }

        public String getVerticalPic() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1223110390")) {
                return this.verticalPic;
            }
            return (String) ipChange.ipc$dispatch("-1223110390", new Object[]{this});
        }

        public void setFormattedPriceStr(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834629604")) {
                ipChange.ipc$dispatch("-1834629604", new Object[]{this, str});
                return;
            }
            this.formattedPriceStr = str;
        }

        public void setId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1601250261")) {
                ipChange.ipc$dispatch("-1601250261", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.id = j;
        }

        public void setName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-344533997")) {
                ipChange.ipc$dispatch("-344533997", new Object[]{this, str});
                return;
            }
            this.name = str;
        }

        public void setPriceHigh(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-839415819")) {
                ipChange.ipc$dispatch("-839415819", new Object[]{this, str});
                return;
            }
            this.priceHigh = str;
        }

        public void setPriceLow(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-722860589")) {
                ipChange.ipc$dispatch("-722860589", new Object[]{this, str});
                return;
            }
            this.priceLow = str;
        }

        public void setPriceStr(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1957673194")) {
                ipChange.ipc$dispatch("-1957673194", new Object[]{this, str});
                return;
            }
            this.priceStr = str;
        }

        public void setPromotionTags(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1467891477")) {
                ipChange.ipc$dispatch("-1467891477", new Object[]{this, list});
                return;
            }
            this.promotionTags = list;
        }

        public void setShowTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "549326100")) {
                ipChange.ipc$dispatch("549326100", new Object[]{this, str});
                return;
            }
            this.showTime = str;
        }

        public void setSubTitle(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1822617274")) {
                ipChange.ipc$dispatch("-1822617274", new Object[]{this, str});
                return;
            }
            this.subTitle = str;
        }

        public void setTourProjects(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1841663309")) {
                ipChange.ipc$dispatch("-1841663309", new Object[]{this, list});
                return;
            }
            this.tourProjects = list;
        }

        public void setType(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2091724092")) {
                ipChange.ipc$dispatch("-2091724092", new Object[]{this, str});
                return;
            }
            this.type = str;
        }

        public void setVenueCity(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1825443482")) {
                ipChange.ipc$dispatch("-1825443482", new Object[]{this, str});
                return;
            }
            this.venueCity = str;
        }

        public void setVenueName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-680852410")) {
                ipChange.ipc$dispatch("-680852410", new Object[]{this, str});
                return;
            }
            this.venueName = str;
        }

        public void setVerticalPic(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1561667668")) {
                ipChange.ipc$dispatch("-1561667668", new Object[]{this, str});
                return;
            }
            this.verticalPic = str;
        }
    }

    public long getCreateTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1467035512")) {
            return this.createTime;
        }
        return ((Long) ipChange.ipc$dispatch("-1467035512", new Object[]{this})).longValue();
    }

    public int getDynamicNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2038673687")) {
            return this.dynamicNum;
        }
        return ((Integer) ipChange.ipc$dispatch("-2038673687", new Object[]{this})).intValue();
    }

    public int getFansNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "66542426")) {
            return this.fansNum;
        }
        return ((Integer) ipChange.ipc$dispatch("66542426", new Object[]{this})).intValue();
    }

    public String getFrom() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-622468147")) {
            return this.from;
        }
        return (String) ipChange.ipc$dispatch("-622468147", new Object[]{this});
    }

    public String getObjectDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "191244691")) {
            return this.objectDesc;
        }
        return (String) ipChange.ipc$dispatch("191244691", new Object[]{this});
    }

    public String getObjectIdStr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1395231478")) {
            return this.objectIdStr;
        }
        return (String) ipChange.ipc$dispatch("-1395231478", new Object[]{this});
    }

    public String getObjectImg() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1895189367")) {
            return this.objectImg;
        }
        return (String) ipChange.ipc$dispatch("1895189367", new Object[]{this});
    }

    public String getObjectName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1396775795")) {
            return this.objectName;
        }
        return (String) ipChange.ipc$dispatch("-1396775795", new Object[]{this});
    }

    public int getObjectType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1851006295")) {
            return this.objectType;
        }
        return ((Integer) ipChange.ipc$dispatch("1851006295", new Object[]{this})).intValue();
    }

    public PerformFilmVipDO getPerformFilmVipDO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "778347157")) {
            return this.performFilmVipDO;
        }
        return (PerformFilmVipDO) ipChange.ipc$dispatch("778347157", new Object[]{this});
    }

    public List<RecentShowProject> getRecentShowProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-810028645")) {
            return this.recentShowProject;
        }
        return (List) ipChange.ipc$dispatch("-810028645", new Object[]{this});
    }

    public int getRecentShowTotalNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2029262614")) {
            return this.recentShowTotalNum;
        }
        return ((Integer) ipChange.ipc$dispatch("2029262614", new Object[]{this})).intValue();
    }

    public String getSchema() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1594103228")) {
            return this.schema;
        }
        return (String) ipChange.ipc$dispatch("-1594103228", new Object[]{this});
    }

    public Integer getSex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1991673330")) {
            return this.sex;
        }
        return (Integer) ipChange.ipc$dispatch("-1991673330", new Object[]{this});
    }

    public int getStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1886385630")) {
            return this.status;
        }
        return ((Integer) ipChange.ipc$dispatch("1886385630", new Object[]{this})).intValue();
    }

    public String getTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-593886707")) {
            return this.tag;
        }
        return (String) ipChange.ipc$dispatch("-593886707", new Object[]{this});
    }

    public String getVipLevel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-219968246")) {
            return this.vipLevel;
        }
        return (String) ipChange.ipc$dispatch("-219968246", new Object[]{this});
    }

    public String getVipLevelIcon() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1559969699")) {
            return this.vipLevelIcon;
        }
        return (String) ipChange.ipc$dispatch("1559969699", new Object[]{this});
    }

    public int getVtag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1694179116")) {
            return this.vtag;
        }
        return ((Integer) ipChange.ipc$dispatch("1694179116", new Object[]{this})).intValue();
    }

    public boolean isPerformFilmVip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160039175")) {
            return ((Boolean) ipChange.ipc$dispatch("-160039175", new Object[]{this})).booleanValue();
        }
        PerformFilmVipDO performFilmVipDO2 = this.performFilmVipDO;
        return performFilmVipDO2 != null && h03.d(performFilmVipDO2.memberFlag);
    }

    public boolean isVip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1220667748")) {
            return this.vip;
        }
        return ((Boolean) ipChange.ipc$dispatch("1220667748", new Object[]{this})).booleanValue();
    }

    public void setCreateTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826417340")) {
            ipChange.ipc$dispatch("826417340", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.createTime = j;
    }

    public void setDynamicNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285502169")) {
            ipChange.ipc$dispatch("285502169", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dynamicNum = i;
    }

    public void setFansNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291108848")) {
            ipChange.ipc$dispatch("291108848", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.fansNum = i;
    }

    public void setFrom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885567153")) {
            ipChange.ipc$dispatch("1885567153", new Object[]{this, str});
            return;
        }
        this.from = str;
    }

    public void setObjectDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-476265301")) {
            ipChange.ipc$dispatch("-476265301", new Object[]{this, str});
            return;
        }
        this.objectDesc = str;
    }

    public void setObjectIdStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692513196")) {
            ipChange.ipc$dispatch("1692513196", new Object[]{this, str});
            return;
        }
        this.objectIdStr = str;
    }

    public void setObjectImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "951090655")) {
            ipChange.ipc$dispatch("951090655", new Object[]{this, str});
            return;
        }
        this.objectImg = str;
    }

    public void setObjectName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834707185")) {
            ipChange.ipc$dispatch("1834707185", new Object[]{this, str});
            return;
        }
        this.objectName = str;
    }

    public void setObjectType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "606497323")) {
            ipChange.ipc$dispatch("606497323", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.objectType = i;
    }

    public void setPerformFilmVipDO(PerformFilmVipDO performFilmVipDO2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1387282009")) {
            ipChange.ipc$dispatch("-1387282009", new Object[]{this, performFilmVipDO2});
            return;
        }
        this.performFilmVipDO = performFilmVipDO2;
    }

    public void setRecentShowProject(List<RecentShowProject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1846275881")) {
            ipChange.ipc$dispatch("1846275881", new Object[]{this, list});
            return;
        }
        this.recentShowProject = list;
    }

    public void setRecentShowTotalNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-674046900")) {
            ipChange.ipc$dispatch("-674046900", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.recentShowTotalNum = i;
    }

    public void setSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "727315482")) {
            ipChange.ipc$dispatch("727315482", new Object[]{this, str});
            return;
        }
        this.schema = str;
    }

    public void setSex(Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608813340")) {
            ipChange.ipc$dispatch("-1608813340", new Object[]{this, num});
            return;
        }
        this.sex = num;
    }

    public void setStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877426556")) {
            ipChange.ipc$dispatch("-877426556", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.status = i;
    }

    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "187929353")) {
            ipChange.ipc$dispatch("187929353", new Object[]{this, str});
            return;
        }
        this.tag = str;
    }

    public void setVip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966879560")) {
            ipChange.ipc$dispatch("-966879560", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.vip = z;
    }

    public void setVipLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888591124")) {
            ipChange.ipc$dispatch("1888591124", new Object[]{this, str});
            return;
        }
        this.vipLevel = str;
    }

    public void setVipLevelIcon(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1512301467")) {
            ipChange.ipc$dispatch("1512301467", new Object[]{this, str});
            return;
        }
        this.vipLevelIcon = str;
    }

    public void setVtag(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891395062")) {
            ipChange.ipc$dispatch("891395062", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.vtag = i;
    }
}
