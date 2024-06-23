package cn.damai.user.repertoite.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class RepertoireDetailDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean favoriteFlag;
    private List<ProjectCardInfoBean> projectCardInfo;
    private RepertoireInfoBean repertoireInfo;

    /* compiled from: Taobao */
    public static class ProjectCardInfoBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        private String cityId;
        private String cityName;
        private String priceRange;
        private String projectId;
        private String projectName;
        private String projectPic;
        private String recReason;
        private int recReasonType;
        public String schema;
        private String showTime;
        private List<String> tagList;
        private String venueCity;
        private int venueId;
        private String venueName;

        public String getCityId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1000208518")) {
                return this.cityId;
            }
            return (String) ipChange.ipc$dispatch("-1000208518", new Object[]{this});
        }

        public String getCityName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "943171562")) {
                return this.cityName;
            }
            return (String) ipChange.ipc$dispatch("943171562", new Object[]{this});
        }

        public String getPriceRange() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1183854984")) {
                return this.priceRange;
            }
            return (String) ipChange.ipc$dispatch("1183854984", new Object[]{this});
        }

        public String getProjectId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1486577546")) {
                return this.projectId;
            }
            return (String) ipChange.ipc$dispatch("-1486577546", new Object[]{this});
        }

        public String getProjectName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1693970918")) {
                return this.projectName;
            }
            return (String) ipChange.ipc$dispatch("1693970918", new Object[]{this});
        }

        public String getProjectPic() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "973741893")) {
                return this.projectPic;
            }
            return (String) ipChange.ipc$dispatch("973741893", new Object[]{this});
        }

        public String getRecReason() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "383322454")) {
                return this.recReason;
            }
            return (String) ipChange.ipc$dispatch("383322454", new Object[]{this});
        }

        public int getRecReasonType() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "702694499")) {
                return this.recReasonType;
            }
            return ((Integer) ipChange.ipc$dispatch("702694499", new Object[]{this})).intValue();
        }

        public String getShowTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "871233214")) {
                return this.showTime;
            }
            return (String) ipChange.ipc$dispatch("871233214", new Object[]{this});
        }

        public List<String> getTagList() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-622399071")) {
                return this.tagList;
            }
            return (List) ipChange.ipc$dispatch("-622399071", new Object[]{this});
        }

        public String getVenueCity() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "811280348")) {
                return this.venueCity;
            }
            return (String) ipChange.ipc$dispatch("811280348", new Object[]{this});
        }

        public int getVenueId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-986371577")) {
                return this.venueId;
            }
            return ((Integer) ipChange.ipc$dispatch("-986371577", new Object[]{this})).intValue();
        }

        public String getVenueName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "155465980")) {
                return this.venueName;
            }
            return (String) ipChange.ipc$dispatch("155465980", new Object[]{this});
        }

        public void setCityId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1958182308")) {
                ipChange.ipc$dispatch("1958182308", new Object[]{this, str});
                return;
            }
            this.cityId = str;
        }

        public void setCityName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-708780492")) {
                ipChange.ipc$dispatch("-708780492", new Object[]{this, str});
                return;
            }
            this.cityName = str;
        }

        public void setPriceRange(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "229882710")) {
                ipChange.ipc$dispatch("229882710", new Object[]{this, str});
                return;
            }
            this.priceRange = str;
        }

        public void setProjectId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-804468544")) {
                ipChange.ipc$dispatch("-804468544", new Object[]{this, str});
                return;
            }
            this.projectId = str;
        }

        public void setProjectName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1326460336")) {
                ipChange.ipc$dispatch("-1326460336", new Object[]{this, str});
                return;
            }
            this.projectName = str;
        }

        public void setProjectPic(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1988655815")) {
                ipChange.ipc$dispatch("-1988655815", new Object[]{this, str});
                return;
            }
            this.projectPic = str;
        }

        public void setRecReason(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1327856608")) {
                ipChange.ipc$dispatch("1327856608", new Object[]{this, str});
                return;
            }
            this.recReason = str;
        }

        public void setRecReasonType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-302200569")) {
                ipChange.ipc$dispatch("-302200569", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.recReasonType = i;
        }

        public void setShowTime(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1356098016")) {
                ipChange.ipc$dispatch("1356098016", new Object[]{this, str});
                return;
            }
            this.showTime = str;
        }

        public void setTagList(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1282412259")) {
                ipChange.ipc$dispatch("1282412259", new Object[]{this, list});
                return;
            }
            this.tagList = list;
        }

        public void setVenueCity(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1709649434")) {
                ipChange.ipc$dispatch("1709649434", new Object[]{this, str});
                return;
            }
            this.venueCity = str;
        }

        public void setVenueId(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2010513123")) {
                ipChange.ipc$dispatch("2010513123", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.venueId = i;
        }

        public void setVenueName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1440726790")) {
                ipChange.ipc$dispatch("-1440726790", new Object[]{this, str});
                return;
            }
            this.venueName = str;
        }
    }

    /* compiled from: Taobao */
    public static class RepertoireInfoBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        private String artsDesc;
        private Long childRepertoireType;
        private String childRepertoireTypeName;
        private String focusComment;
        private String repertoireId;
        private String repertoireName;
        private String repertoirePic;
        private int repertoireType;
        private String repertoireTypeName;
        private StoryPicsInfoBean storyPicsInfo;
        private String summary;

        /* compiled from: Taobao */
        public static class StoryPicsInfoBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange;
            private List<PicInfosBean> picInfos;

            /* compiled from: Taobao */
            public static class PicInfosBean implements Serializable {
                private static transient /* synthetic */ IpChange $ipChange;
                private String height;
                private String picUrl;
                private String width;

                public String getHeight() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "-1588456586")) {
                        return this.height;
                    }
                    return (String) ipChange.ipc$dispatch("-1588456586", new Object[]{this});
                }

                public String getPicUrl() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "2110349012")) {
                        return this.picUrl;
                    }
                    return (String) ipChange.ipc$dispatch("2110349012", new Object[]{this});
                }

                public String getWidth() {
                    IpChange ipChange = $ipChange;
                    if (!AndroidInstantRuntime.support(ipChange, "-206060019")) {
                        return this.width;
                    }
                    return (String) ipChange.ipc$dispatch("-206060019", new Object[]{this});
                }

                public void setHeight(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "902361384")) {
                        ipChange.ipc$dispatch("902361384", new Object[]{this, str});
                        return;
                    }
                    this.height = str;
                }

                public void setPicUrl(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-398782070")) {
                        ipChange.ipc$dispatch("-398782070", new Object[]{this, str});
                        return;
                    }
                    this.picUrl = str;
                }

                public void setWidth(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "398474249")) {
                        ipChange.ipc$dispatch("398474249", new Object[]{this, str});
                        return;
                    }
                    this.width = str;
                }
            }

            public List<PicInfosBean> getPicInfos() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-772690196")) {
                    return this.picInfos;
                }
                return (List) ipChange.ipc$dispatch("-772690196", new Object[]{this});
            }

            public void setPicInfos(List<PicInfosBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1326862432")) {
                    ipChange.ipc$dispatch("1326862432", new Object[]{this, list});
                    return;
                }
                this.picInfos = list;
            }
        }

        public String getArtsDesc() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-474784589")) {
                return this.artsDesc;
            }
            return (String) ipChange.ipc$dispatch("-474784589", new Object[]{this});
        }

        public Long getChildRepertoireType() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2138006618")) {
                return this.childRepertoireType;
            }
            return (Long) ipChange.ipc$dispatch("-2138006618", new Object[]{this});
        }

        public String getChildRepertoireTypeName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1718689564")) {
                return this.childRepertoireTypeName;
            }
            return (String) ipChange.ipc$dispatch("1718689564", new Object[]{this});
        }

        public String getFocusComment() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-205683847")) {
                return this.focusComment;
            }
            return (String) ipChange.ipc$dispatch("-205683847", new Object[]{this});
        }

        public String getRepertoireId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1597664956")) {
                return this.repertoireId;
            }
            return (String) ipChange.ipc$dispatch("-1597664956", new Object[]{this});
        }

        public String getRepertoireName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1981814988")) {
                return this.repertoireName;
            }
            return (String) ipChange.ipc$dispatch("-1981814988", new Object[]{this});
        }

        public String getRepertoirePic() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1824999479")) {
                return this.repertoirePic;
            }
            return (String) ipChange.ipc$dispatch("1824999479", new Object[]{this});
        }

        public int getRepertoireType() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1006025680")) {
                return this.repertoireType;
            }
            return ((Integer) ipChange.ipc$dispatch("1006025680", new Object[]{this})).intValue();
        }

        public String getRepertoireTypeName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-271667826")) {
                return this.repertoireTypeName;
            }
            return (String) ipChange.ipc$dispatch("-271667826", new Object[]{this});
        }

        public StoryPicsInfoBean getStoryPicsInfo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1354303136")) {
                return this.storyPicsInfo;
            }
            return (StoryPicsInfoBean) ipChange.ipc$dispatch("1354303136", new Object[]{this});
        }

        public String getSummary() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1317940554")) {
                return this.summary;
            }
            return (String) ipChange.ipc$dispatch("1317940554", new Object[]{this});
        }

        public void setArtsDesc(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1715748213")) {
                ipChange.ipc$dispatch("-1715748213", new Object[]{this, str});
                return;
            }
            this.artsDesc = str;
        }

        public void setChildRepertoireType(Long l) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "449571802")) {
                ipChange.ipc$dispatch("449571802", new Object[]{this, l});
                return;
            }
            this.childRepertoireType = l;
        }

        public void setChildRepertoireTypeName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1909646886")) {
                ipChange.ipc$dispatch("-1909646886", new Object[]{this, str});
                return;
            }
            this.childRepertoireTypeName = str;
        }

        public void setFocusComment(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1683350907")) {
                ipChange.ipc$dispatch("-1683350907", new Object[]{this, str});
                return;
            }
            this.focusComment = str;
        }

        public void setRepertoireId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1885092326")) {
                ipChange.ipc$dispatch("-1885092326", new Object[]{this, str});
                return;
            }
            this.repertoireId = str;
        }

        public void setRepertoireName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-423829206")) {
                ipChange.ipc$dispatch("-423829206", new Object[]{this, str});
                return;
            }
            this.repertoireName = str;
        }

        public void setRepertoirePic(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1128254689")) {
                ipChange.ipc$dispatch("-1128254689", new Object[]{this, str});
                return;
            }
            this.repertoirePic = str;
        }

        public void setRepertoireType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-636701486")) {
                ipChange.ipc$dispatch("-636701486", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.repertoireType = i;
        }

        public void setRepertoireTypeName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "126225424")) {
                ipChange.ipc$dispatch("126225424", new Object[]{this, str});
                return;
            }
            this.repertoireTypeName = str;
        }

        public void setStoryPicsInfo(StoryPicsInfoBean storyPicsInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1183808508")) {
                ipChange.ipc$dispatch("-1183808508", new Object[]{this, storyPicsInfoBean});
                return;
            }
            this.storyPicsInfo = storyPicsInfoBean;
        }

        public void setSummary(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "585197932")) {
                ipChange.ipc$dispatch("585197932", new Object[]{this, str});
                return;
            }
            this.summary = str;
        }
    }

    public List<ProjectCardInfoBean> getProjectCardInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1420640931")) {
            return this.projectCardInfo;
        }
        return (List) ipChange.ipc$dispatch("1420640931", new Object[]{this});
    }

    public RepertoireInfoBean getRepertoireInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1761536334")) {
            return this.repertoireInfo;
        }
        return (RepertoireInfoBean) ipChange.ipc$dispatch("-1761536334", new Object[]{this});
    }

    public boolean isFavoriteFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1162143735")) {
            return this.favoriteFlag;
        }
        return ((Boolean) ipChange.ipc$dispatch("1162143735", new Object[]{this})).booleanValue();
    }

    public void setFavoriteFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-21508903")) {
            ipChange.ipc$dispatch("-21508903", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.favoriteFlag = z;
    }

    public void setProjectCardInfo(List<ProjectCardInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "127078945")) {
            ipChange.ipc$dispatch("127078945", new Object[]{this, list});
            return;
        }
        this.projectCardInfo = list;
    }

    public void setRepertoireInfo(RepertoireInfoBean repertoireInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400582598")) {
            ipChange.ipc$dispatch("-1400582598", new Object[]{this, repertoireInfoBean});
            return;
        }
        this.repertoireInfo = repertoireInfoBean;
    }
}
