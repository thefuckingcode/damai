package cn.damai.issue.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class CommentInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    private String commentGiftTxt;
    private String commentScore;
    private String commentText;
    private String commentTips;
    private String commentTotal;
    private String isHasComment;
    private String itemId;
    private String myCommentUrl;
    private String targetId;

    public String getCommentGiftTxt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1499633460")) {
            return this.commentGiftTxt;
        }
        return (String) ipChange.ipc$dispatch("-1499633460", new Object[]{this});
    }

    public String getCommentScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1700926594")) {
            return this.commentScore;
        }
        return (String) ipChange.ipc$dispatch("-1700926594", new Object[]{this});
    }

    public String getCommentText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "186998327")) {
            return this.commentText;
        }
        return (String) ipChange.ipc$dispatch("186998327", new Object[]{this});
    }

    public String getCommentTips() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-215680830")) {
            return this.commentTips;
        }
        return (String) ipChange.ipc$dispatch("-215680830", new Object[]{this});
    }

    public String getCommentTotal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-886686928")) {
            return this.commentTotal;
        }
        return (String) ipChange.ipc$dispatch("-886686928", new Object[]{this});
    }

    public String getIsHasComment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1708662470")) {
            return this.isHasComment;
        }
        return (String) ipChange.ipc$dispatch("-1708662470", new Object[]{this});
    }

    public String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1315133415")) {
            return this.itemId;
        }
        return (String) ipChange.ipc$dispatch("-1315133415", new Object[]{this});
    }

    public String getMyCommentUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1581847833")) {
            return this.myCommentUrl;
        }
        return (String) ipChange.ipc$dispatch("-1581847833", new Object[]{this});
    }

    public String getTargetId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "110500887")) {
            return this.targetId;
        }
        return (String) ipChange.ipc$dispatch("110500887", new Object[]{this});
    }

    public void setCommentGiftTxt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1638896274")) {
            ipChange.ipc$dispatch("1638896274", new Object[]{this, str});
            return;
        }
        this.commentGiftTxt = str;
    }

    public void setCommentScore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-791235808")) {
            ipChange.ipc$dispatch("-791235808", new Object[]{this, str});
            return;
        }
        this.commentScore = str;
    }

    public void setCommentText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-797970401")) {
            ipChange.ipc$dispatch("-797970401", new Object[]{this, str});
            return;
        }
        this.commentText = str;
    }

    public void setCommentTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396122380")) {
            ipChange.ipc$dispatch("-396122380", new Object[]{this, str});
            return;
        }
        this.commentTips = str;
    }

    public void setCommentTotal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1319609938")) {
            ipChange.ipc$dispatch("-1319609938", new Object[]{this, str});
            return;
        }
        this.commentTotal = str;
    }

    public void setIsHasComment(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1031047964")) {
            ipChange.ipc$dispatch("-1031047964", new Object[]{this, str});
            return;
        }
        this.isHasComment = str;
    }

    public void setItemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785445093")) {
            ipChange.ipc$dispatch("785445093", new Object[]{this, str});
            return;
        }
        this.itemId = str;
    }

    public void setMyCommentUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394761513")) {
            ipChange.ipc$dispatch("-1394761513", new Object[]{this, str});
            return;
        }
        this.myCommentUrl = str;
    }

    public void setTargetId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751767641")) {
            ipChange.ipc$dispatch("-751767641", new Object[]{this, str});
            return;
        }
        this.targetId = str;
    }
}
