package com.uploader.export;

import tb.ej2;

/* compiled from: Taobao */
public interface ITaskListener {
    void onCancel(IUploaderTask iUploaderTask);

    void onFailure(IUploaderTask iUploaderTask, ej2 ej2);

    void onPause(IUploaderTask iUploaderTask);

    void onProgress(IUploaderTask iUploaderTask, int i);

    void onResume(IUploaderTask iUploaderTask);

    void onStart(IUploaderTask iUploaderTask);

    void onSuccess(IUploaderTask iUploaderTask, ITaskResult iTaskResult);

    void onWait(IUploaderTask iUploaderTask);
}
