package cn.damai.tetris.component.star.content.base.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class ContentItemBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private String card;
    private String content;
    private String contentId;
    private String coverImage;
    private List<String> images;
    private PraiseInfo praiseInfo;
    private String releaseTime;
    private String sourceId;
    private String title;
    private ContentVideoBean video;

    public String getCard() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1493124390")) {
            return this.card;
        }
        return (String) ipChange.ipc$dispatch("1493124390", new Object[]{this});
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-376928359")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("-376928359", new Object[]{this});
    }

    public String getContentId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1461425708")) {
            return this.contentId;
        }
        return (String) ipChange.ipc$dispatch("-1461425708", new Object[]{this});
    }

    public String getCoverImage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1514105926")) {
            return this.coverImage;
        }
        return (String) ipChange.ipc$dispatch("-1514105926", new Object[]{this});
    }

    public List<String> getImages() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-295701771")) {
            return this.images;
        }
        return (List) ipChange.ipc$dispatch("-295701771", new Object[]{this});
    }

    public PraiseInfo getPraiseInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1193247712")) {
            return this.praiseInfo;
        }
        return (PraiseInfo) ipChange.ipc$dispatch("-1193247712", new Object[]{this});
    }

    public String getReleaseTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1751951508")) {
            return this.releaseTime;
        }
        return (String) ipChange.ipc$dispatch("1751951508", new Object[]{this});
    }

    public String getSourceId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2039643092")) {
            return this.sourceId;
        }
        return (String) ipChange.ipc$dispatch("-2039643092", new Object[]{this});
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1664040648")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-1664040648", new Object[]{this});
    }

    public ContentVideoBean getVideo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1198117251")) {
            return this.video;
        }
        return (ContentVideoBean) ipChange.ipc$dispatch("-1198117251", new Object[]{this});
    }

    public void setCard(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250540936")) {
            ipChange.ipc$dispatch("-1250540936", new Object[]{this, str});
            return;
        }
        this.card = str;
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-416130819")) {
            ipChange.ipc$dispatch("-416130819", new Object[]{this, str});
            return;
        }
        this.content = str;
    }

    public void setContentId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24761566")) {
            ipChange.ipc$dispatch("-24761566", new Object[]{this, str});
            return;
        }
        this.contentId = str;
    }

    public void setCoverImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802526876")) {
            ipChange.ipc$dispatch("-1802526876", new Object[]{this, str});
            return;
        }
        this.coverImage = str;
    }

    public void setImages(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "35969655")) {
            ipChange.ipc$dispatch("35969655", new Object[]{this, list});
            return;
        }
        this.images = list;
    }

    public void setPraiseInfo(PraiseInfo praiseInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1334577276")) {
            ipChange.ipc$dispatch("1334577276", new Object[]{this, praiseInfo2});
            return;
        }
        this.praiseInfo = praiseInfo2;
    }

    public void setReleaseTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "470937954")) {
            ipChange.ipc$dispatch("470937954", new Object[]{this, str});
            return;
        }
        this.releaseTime = str;
    }

    public void setSourceId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313245746")) {
            ipChange.ipc$dispatch("1313245746", new Object[]{this, str});
            return;
        }
        this.sourceId = str;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849252290")) {
            ipChange.ipc$dispatch("-1849252290", new Object[]{this, str});
            return;
        }
        this.title = str;
    }

    public void setVideo(ContentVideoBean contentVideoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1645915305")) {
            ipChange.ipc$dispatch("-1645915305", new Object[]{this, contentVideoBean});
            return;
        }
        this.video = contentVideoBean;
    }
}
