package cn.damai.issue.listener;

import cn.damai.issue.bean.DraftBean;

/* compiled from: Taobao */
public interface OnCheckDraftListener {
    void onHasDraft(DraftBean draftBean);

    void onNoneDraft();
}
