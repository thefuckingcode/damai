package cn.damai.issue.bean;

import android.text.TextUtils;
import cn.damai.comment.bean.QueryThemeCliqueInfoBean;
import cn.damai.issue.tool.draft.DraftBox;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.List;
import tb.g91;
import tb.s41;
import tb.yb0;

/* compiled from: Taobao */
public class DraftBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<QueryThemeCliqueInfoBean> circle;
    public List<QueryThemeCliqueInfoBean> circleList;
    public String draftMd5FileName;
    public String itemType;
    public DraftExtra mExtra;
    public String storeId;
    public String themeId;
    public String themeName;
    public String userInput;

    public DraftBean() {
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1458091841")) {
            return ((Boolean) ipChange.ipc$dispatch("1458091841", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj != null && getClass() == obj.getClass()) {
                DraftBean draftBean = (DraftBean) obj;
                if (!TextUtils.equals(this.draftMd5FileName, draftBean.draftMd5FileName) || !TextUtils.equals(this.userInput, draftBean.userInput) || !TextUtils.equals(this.themeName, draftBean.themeName) || this.circle != draftBean.circle || !TextUtils.equals(this.storeId, draftBean.storeId)) {
                    z = false;
                }
                if (z) {
                    return yb0.c(this.mExtra, draftBean.mExtra);
                }
            }
            return false;
        }
    }

    @JSONField(deserialize = false, serialize = false)
    public byte[] generateDraftBytes() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-502212932")) {
            return (byte[]) ipChange.ipc$dispatch("-502212932", new Object[]{this});
        }
        try {
            String e = s41.e(this);
            g91.f(DraftBox.TAG, "generateDraftBytes " + e);
            return e.getBytes(Charset.forName("UTF-8"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @JSONField(deserialize = false, serialize = false)
    public boolean isValidDraft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1244521643")) {
            return ((Boolean) ipChange.ipc$dispatch("-1244521643", new Object[]{this})).booleanValue();
        } else if (TextUtils.isEmpty(this.draftMd5FileName)) {
            return false;
        } else {
            if (!TextUtils.isEmpty(this.userInput)) {
                return true;
            }
            DraftExtra draftExtra = this.mExtra;
            if (draftExtra == null || !draftExtra.isValid()) {
                return false;
            }
            return true;
        }
    }

    public DraftBean(String str, String str2, String str3, String str4, List<QueryThemeCliqueInfoBean> list, List<QueryThemeCliqueInfoBean> list2, String str5, String str6, DraftExtra draftExtra) {
        this.draftMd5FileName = str;
        this.userInput = str2;
        this.themeName = str3;
        this.themeId = str4;
        this.circle = list;
        this.circleList = list2;
        this.storeId = str5;
        this.itemType = str6;
        this.mExtra = draftExtra;
    }

    public DraftBean(String str) {
        this.draftMd5FileName = str;
        this.userInput = null;
        this.themeName = null;
    }
}
