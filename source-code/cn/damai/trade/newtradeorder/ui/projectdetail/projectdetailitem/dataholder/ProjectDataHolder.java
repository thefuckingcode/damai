package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder;

import android.text.SpannableString;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.servicenotice.TicketNote;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.BrandAndArtists;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.InFieldCommentsBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectFreeTicketBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public final class ProjectDataHolder implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 7716181784824462662L;
    public List<BrandAndArtists> brandAndArtistsList;
    public String brandAndArtistsTitle;
    public BrandAndArtists brandOrArtists;
    private int commentNum;
    private int commentPosition;
    private int commentTotalNum;
    private List<String> commonProblems;
    private HtmlParserManager.a convertedItem;
    private int convertedItemPosition;
    private int convertedItemSize;
    private SpannableString discussionContent;
    private String discussionTips;
    private boolean hasShowLineup;
    private String highLightContent;
    private String highLightTitle;
    private CommentsItemBean hotComment;
    public List<InFieldCommentsBean> inFieldComments;
    private boolean isModuleDataBind;
    private boolean isShowLine;
    public boolean isTheater;
    private String mBannerPicUrl;
    private String mBannerRedirectUrl;
    private String mProjectId;
    private String mTheaterValue;
    private CommentsItemBean moduleComment;
    private int moduleType;
    private ArrayList<PicInfo> momentsInfo;
    private String moreContent;
    private int morePosition;
    private int moreType;
    private ProjectFreeTicketBean recommendFreeTicketItem;
    private ProjectItemBean recommendItem;
    private int recommendItemPosition;
    private int recommendListSize;
    private int richType;
    private String sectionTitleContent;
    private int sectionTitleType;
    private List<HtmlParserManager.a> shrinkConvertedItem;
    private int shrinkRichType;
    private int subTitlePosition;
    private TicketNote ticketNote;
    private TicketNote ticketNote2rd;
    private boolean ticketNoteEndPos;
    private CommentsItemBean userCommentItemBean;
    private ArrayList<VideoInfo> videoInfoList;

    public ProjectDataHolder(int i) {
        this.moduleType = i;
    }

    public String getBannerPicUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1853791217")) {
            return this.mBannerPicUrl;
        }
        return (String) ipChange.ipc$dispatch("-1853791217", new Object[]{this});
    }

    public String getBannerRedirectUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1265978785")) {
            return this.mBannerRedirectUrl;
        }
        return (String) ipChange.ipc$dispatch("-1265978785", new Object[]{this});
    }

    public int getCommentNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-536308402")) {
            return this.commentNum;
        }
        return ((Integer) ipChange.ipc$dispatch("-536308402", new Object[]{this})).intValue();
    }

    public int getCommentPosition() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1302624781")) {
            return this.commentPosition;
        }
        return ((Integer) ipChange.ipc$dispatch("-1302624781", new Object[]{this})).intValue();
    }

    public int getCommentTotalNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2043101478")) {
            return this.commentTotalNum;
        }
        return ((Integer) ipChange.ipc$dispatch("-2043101478", new Object[]{this})).intValue();
    }

    public List<String> getCommonProblems() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1955036124")) {
            return this.commonProblems;
        }
        return (List) ipChange.ipc$dispatch("-1955036124", new Object[]{this});
    }

    public HtmlParserManager.a getConvertedItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-672116114")) {
            return this.convertedItem;
        }
        return (HtmlParserManager.a) ipChange.ipc$dispatch("-672116114", new Object[]{this});
    }

    public int getConvertedItemPosition() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1029777037")) {
            return this.convertedItemPosition;
        }
        return ((Integer) ipChange.ipc$dispatch("1029777037", new Object[]{this})).intValue();
    }

    public int getConvertedItemSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-72091723")) {
            return this.convertedItemSize;
        }
        return ((Integer) ipChange.ipc$dispatch("-72091723", new Object[]{this})).intValue();
    }

    public SpannableString getDiscussionContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "170124513")) {
            return this.discussionContent;
        }
        return (SpannableString) ipChange.ipc$dispatch("170124513", new Object[]{this});
    }

    public String getDiscussionTips() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1445879678")) {
            return this.discussionTips;
        }
        return (String) ipChange.ipc$dispatch("1445879678", new Object[]{this});
    }

    public String getHighLightContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "276299779")) {
            return this.highLightContent;
        }
        return (String) ipChange.ipc$dispatch("276299779", new Object[]{this});
    }

    public String getHighLightTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1019786206")) {
            return this.highLightTitle;
        }
        return (String) ipChange.ipc$dispatch("-1019786206", new Object[]{this});
    }

    public CommentsItemBean getHotComment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-894714518")) {
            return this.hotComment;
        }
        return (CommentsItemBean) ipChange.ipc$dispatch("-894714518", new Object[]{this});
    }

    public CommentsItemBean getModuleComment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "57194853")) {
            return this.moduleComment;
        }
        return (CommentsItemBean) ipChange.ipc$dispatch("57194853", new Object[]{this});
    }

    public int getModuleType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1431605809")) {
            return this.moduleType;
        }
        return ((Integer) ipChange.ipc$dispatch("-1431605809", new Object[]{this})).intValue();
    }

    public ArrayList<PicInfo> getMomentsInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1167620575")) {
            return this.momentsInfo;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1167620575", new Object[]{this});
    }

    public String getMoreContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-431517220")) {
            return this.moreContent;
        }
        return (String) ipChange.ipc$dispatch("-431517220", new Object[]{this});
    }

    public int getMorePosition() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-736331849")) {
            return this.morePosition;
        }
        return ((Integer) ipChange.ipc$dispatch("-736331849", new Object[]{this})).intValue();
    }

    public int getMoreType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1678686202")) {
            return this.moreType;
        }
        return ((Integer) ipChange.ipc$dispatch("-1678686202", new Object[]{this})).intValue();
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2059666484")) {
            return this.mProjectId;
        }
        return (String) ipChange.ipc$dispatch("-2059666484", new Object[]{this});
    }

    public ProjectFreeTicketBean getRecommendFreeTicketItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1898825157")) {
            return this.recommendFreeTicketItem;
        }
        return (ProjectFreeTicketBean) ipChange.ipc$dispatch("-1898825157", new Object[]{this});
    }

    public ProjectItemBean getRecommendItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1387732337")) {
            return this.recommendItem;
        }
        return (ProjectItemBean) ipChange.ipc$dispatch("-1387732337", new Object[]{this});
    }

    public int getRecommendItemPosition() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2050873821")) {
            return this.recommendItemPosition;
        }
        return ((Integer) ipChange.ipc$dispatch("-2050873821", new Object[]{this})).intValue();
    }

    public int getRecommendListSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2098415008")) {
            return this.recommendListSize;
        }
        return ((Integer) ipChange.ipc$dispatch("-2098415008", new Object[]{this})).intValue();
    }

    public int getRichType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1381049503")) {
            return this.richType;
        }
        return ((Integer) ipChange.ipc$dispatch("1381049503", new Object[]{this})).intValue();
    }

    public String getSectionTitleContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1896420094")) {
            return this.sectionTitleContent;
        }
        return (String) ipChange.ipc$dispatch("1896420094", new Object[]{this});
    }

    public int getSectionTitleType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1934700072")) {
            return this.sectionTitleType;
        }
        return ((Integer) ipChange.ipc$dispatch("1934700072", new Object[]{this})).intValue();
    }

    public List<HtmlParserManager.a> getShrinkConvertedItem() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2135698341")) {
            return this.shrinkConvertedItem;
        }
        return (List) ipChange.ipc$dispatch("-2135698341", new Object[]{this});
    }

    public int getShrinkRichType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1687011606")) {
            return this.shrinkRichType;
        }
        return ((Integer) ipChange.ipc$dispatch("1687011606", new Object[]{this})).intValue();
    }

    public int getSubTitlePosition() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "666076340")) {
            return this.subTitlePosition;
        }
        return ((Integer) ipChange.ipc$dispatch("666076340", new Object[]{this})).intValue();
    }

    public String getTheaterValue() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "677363870")) {
            return this.mTheaterValue;
        }
        return (String) ipChange.ipc$dispatch("677363870", new Object[]{this});
    }

    public TicketNote getTicketNote() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1951298424")) {
            return this.ticketNote;
        }
        return (TicketNote) ipChange.ipc$dispatch("1951298424", new Object[]{this});
    }

    public TicketNote getTicketNote2rd() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-963118566")) {
            return this.ticketNote2rd;
        }
        return (TicketNote) ipChange.ipc$dispatch("-963118566", new Object[]{this});
    }

    public CommentsItemBean getUserCommentItemBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "894124521")) {
            return this.userCommentItemBean;
        }
        return (CommentsItemBean) ipChange.ipc$dispatch("894124521", new Object[]{this});
    }

    public ArrayList<VideoInfo> getVideoInfoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-661689253")) {
            return this.videoInfoList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-661689253", new Object[]{this});
    }

    public boolean hasShowLineup() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1192389686")) {
            return this.hasShowLineup;
        }
        return ((Boolean) ipChange.ipc$dispatch("1192389686", new Object[]{this})).booleanValue();
    }

    public boolean isModuleDataBind() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "117795449")) {
            return this.isModuleDataBind;
        }
        return ((Boolean) ipChange.ipc$dispatch("117795449", new Object[]{this})).booleanValue();
    }

    public boolean isShowLine() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "574110971")) {
            return this.isShowLine;
        }
        return ((Boolean) ipChange.ipc$dispatch("574110971", new Object[]{this})).booleanValue();
    }

    public boolean isTicketNoteEndPos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "692904597")) {
            return this.ticketNoteEndPos;
        }
        return ((Boolean) ipChange.ipc$dispatch("692904597", new Object[]{this})).booleanValue();
    }

    public void setBannerPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235071825")) {
            ipChange.ipc$dispatch("-1235071825", new Object[]{this, str});
            return;
        }
        this.mBannerPicUrl = str;
    }

    public void setBannerRedirectUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "420358135")) {
            ipChange.ipc$dispatch("420358135", new Object[]{this, str});
            return;
        }
        this.mBannerRedirectUrl = str;
    }

    public void setCommentNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-385814252")) {
            ipChange.ipc$dispatch("-385814252", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.commentNum = i;
    }

    public void setCommentPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413504393")) {
            ipChange.ipc$dispatch("-413504393", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.commentPosition = i;
    }

    public void setCommentTotalNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893445520")) {
            ipChange.ipc$dispatch("-1893445520", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.commentTotalNum = i;
    }

    public void setCommonProblems(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826850088")) {
            ipChange.ipc$dispatch("826850088", new Object[]{this, list});
            return;
        }
        this.commonProblems = list;
    }

    public void setConvertedItem(HtmlParserManager.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "601282122")) {
            ipChange.ipc$dispatch("601282122", new Object[]{this, aVar});
            return;
        }
        this.convertedItem = aVar;
    }

    public void setConvertedItemPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198491619")) {
            ipChange.ipc$dispatch("-1198491619", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.convertedItemPosition = i;
    }

    public void setConvertedItemSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1256072693")) {
            ipChange.ipc$dispatch("1256072693", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.convertedItemSize = i;
    }

    public void setDiscussionContent(SpannableString spannableString) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106880731")) {
            ipChange.ipc$dispatch("-106880731", new Object[]{this, spannableString});
            return;
        }
        this.discussionContent = spannableString;
    }

    public void setDiscussionTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539476960")) {
            ipChange.ipc$dispatch("-1539476960", new Object[]{this, str});
            return;
        }
        this.discussionTips = str;
    }

    public void setHasShowLineup(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1414787590")) {
            ipChange.ipc$dispatch("1414787590", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasShowLineup = z;
    }

    public void setHighLightContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196436165")) {
            ipChange.ipc$dispatch("-1196436165", new Object[]{this, str});
            return;
        }
        this.highLightContent = str;
    }

    public void setHighLightTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665708036")) {
            ipChange.ipc$dispatch("-665708036", new Object[]{this, str});
            return;
        }
        this.highLightTitle = str;
    }

    public void setHotComment(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "188630632")) {
            ipChange.ipc$dispatch("188630632", new Object[]{this, commentsItemBean});
            return;
        }
        this.hotComment = commentsItemBean;
    }

    public void setModuleComment(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1541767067")) {
            ipChange.ipc$dispatch("-1541767067", new Object[]{this, commentsItemBean});
            return;
        }
        this.moduleComment = commentsItemBean;
    }

    public void setModuleDataBind(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535488081")) {
            ipChange.ipc$dispatch("1535488081", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isModuleDataBind = z;
    }

    public void setModuleType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1924737203")) {
            ipChange.ipc$dispatch("1924737203", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.moduleType = i;
    }

    public void setMomentsInfo(ArrayList<PicInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1266915255")) {
            ipChange.ipc$dispatch("1266915255", new Object[]{this, arrayList});
            return;
        }
        this.momentsInfo = arrayList;
    }

    public void setMoreContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1502884122")) {
            ipChange.ipc$dispatch("1502884122", new Object[]{this, str});
            return;
        }
        this.moreContent = str;
    }

    public void setMorePosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1399818443")) {
            ipChange.ipc$dispatch("1399818443", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.morePosition = i;
    }

    public void setMoreType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411117660")) {
            ipChange.ipc$dispatch("411117660", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.moreType = i;
    }

    public void setProjectId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390356438")) {
            ipChange.ipc$dispatch("-1390356438", new Object[]{this, str});
            return;
        }
        this.mProjectId = str;
    }

    public void setRecommendFreeTicketItem(ProjectFreeTicketBean projectFreeTicketBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1306258579")) {
            ipChange.ipc$dispatch("1306258579", new Object[]{this, projectFreeTicketBean});
            return;
        }
        this.recommendFreeTicketItem = projectFreeTicketBean;
    }

    public void setRecommendItem(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892962753")) {
            ipChange.ipc$dispatch("892962753", new Object[]{this, projectItemBean});
            return;
        }
        this.recommendItem = projectItemBean;
    }

    public void setRecommendItemPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2085579591")) {
            ipChange.ipc$dispatch("2085579591", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.recommendItemPosition = i;
    }

    public void setRecommendListSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430406998")) {
            ipChange.ipc$dispatch("-1430406998", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.recommendListSize = i;
    }

    public void setRichType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773644003")) {
            ipChange.ipc$dispatch("773644003", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.richType = i;
    }

    public void setSectionTitleContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "334170168")) {
            ipChange.ipc$dispatch("334170168", new Object[]{this, str});
            return;
        }
        this.sectionTitleContent = str;
    }

    public void setSectionTitleType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898461818")) {
            ipChange.ipc$dispatch("1898461818", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.sectionTitleType = i;
    }

    public void setShowLine(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "864490383")) {
            ipChange.ipc$dispatch("864490383", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isShowLine = z;
    }

    public void setShrinkConvertedItem(List<HtmlParserManager.a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134402409")) {
            ipChange.ipc$dispatch("134402409", new Object[]{this, list});
            return;
        }
        this.shrinkConvertedItem = list;
    }

    public void setShrinkRichType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1000974260")) {
            ipChange.ipc$dispatch("-1000974260", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.shrinkRichType = i;
    }

    public void setSubTitlePosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1225831790")) {
            ipChange.ipc$dispatch("1225831790", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.subTitlePosition = i;
    }

    public void setTheaterValue(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78675456")) {
            ipChange.ipc$dispatch("-78675456", new Object[]{this, str});
            return;
        }
        this.mTheaterValue = str;
    }

    public void setTicketNote(TicketNote ticketNote2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004441758")) {
            ipChange.ipc$dispatch("1004441758", new Object[]{this, ticketNote2});
            return;
        }
        this.ticketNote = ticketNote2;
    }

    public void setTicketNote2rd(TicketNote ticketNote2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007091500")) {
            ipChange.ipc$dispatch("-2007091500", new Object[]{this, ticketNote2});
            return;
        }
        this.ticketNote2rd = ticketNote2;
    }

    public void setTicketNotePosition(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36279717")) {
            ipChange.ipc$dispatch("36279717", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.ticketNoteEndPos = z;
    }

    public void setUserCommentItemBean(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1963126943")) {
            ipChange.ipc$dispatch("-1963126943", new Object[]{this, commentsItemBean});
            return;
        }
        this.userCommentItemBean = commentsItemBean;
    }

    public void setVideoInfoList(ArrayList<VideoInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2011196349")) {
            ipChange.ipc$dispatch("2011196349", new Object[]{this, arrayList});
            return;
        }
        this.videoInfoList = arrayList;
    }
}
