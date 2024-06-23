package cn.damai.issue.uploadvideo;

import tb.nv2;

@Deprecated
/* compiled from: Taobao */
public interface VideoUploaderTaskListener {
    void onCancel(nv2 nv2);

    void onFailure(nv2 nv2, String str);

    void onPause(nv2 nv2);

    void onProgress(nv2 nv2, int i);

    void onResume(nv2 nv2);

    void onStart(nv2 nv2);

    void onSuccess(nv2 nv2, String str, String str2);

    void onWait(nv2 nv2);
}
