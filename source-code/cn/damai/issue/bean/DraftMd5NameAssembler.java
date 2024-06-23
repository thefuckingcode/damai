package cn.damai.issue.bean;

import android.text.TextUtils;
import cn.damai.issue.tool.draft.DraftBox;
import cn.damai.model.IssueViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.d20;
import tb.g91;
import tb.wb1;

/* compiled from: Taobao */
public class DraftMd5NameAssembler implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public final String mCommentId;
    public final String mCommentType;
    public final String mIpId;
    public final String mIssueType;
    public final String mItemId;
    public final String mTargetId;
    private String tempFileName;

    public DraftMd5NameAssembler(IssueViewModel issueViewModel) {
        this.mIssueType = issueViewModel.getmIssueType();
        this.mCommentType = issueViewModel.getmCommentType();
        this.mTargetId = issueViewModel.getmTargetId();
        this.mItemId = issueViewModel.getmItemId();
        this.mCommentId = issueViewModel.getmCommentId();
        this.mIpId = issueViewModel.getmIpId();
    }

    public String getDraftMd5FileName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902315895")) {
            return (String) ipChange.ipc$dispatch("1902315895", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.tempFileName)) {
            String str = "ucode_" + d20.E() + "_isstype_" + this.mIssueType + "_ctype_" + this.mCommentType + "_tid_" + this.mTargetId + "_itemid_" + this.mItemId + "_cid_" + this.mCommentId;
            g91.c(DraftBox.TAG, "un md5 file name:" + str);
            this.tempFileName = wb1.b(str);
            g91.c(DraftBox.TAG, "md5 file name:" + this.tempFileName);
        }
        return this.tempFileName;
    }
}
