package com.youku.skinmanager.download;

import com.youku.skinmanager.entity.SkinDTO;

/* compiled from: Taobao */
public interface IDownloadListener {
    void onFail(SkinDTO skinDTO);

    void onSuccess(SkinDTO skinDTO);

    void update(int i);
}
