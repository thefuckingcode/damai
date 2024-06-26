package cn.damai.issue.tool.file;

import cn.damai.issue.bean.DraftBean;
import cn.damai.issue.listener.OnDraftListener;

/* compiled from: Taobao */
public interface IDraftStore {
    void deleteAsync(DraftBean draftBean);

    void queryAsync(String str, OnDraftListener onDraftListener);

    void quitSafely();

    void saveAsync(DraftBean draftBean);
}
