package cn.damai.issue.view;

import android.graphics.Bitmap;

/* compiled from: Taobao */
public interface DMIssueImageLoader$DownloadDelegate {
    void onFailed(String str);

    void onSuccess(String str, Bitmap bitmap);
}
