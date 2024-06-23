package com.youku.skinmanager;

import com.youku.skinmanager.entity.SkinDTO;

/* compiled from: Taobao */
public interface ILoadSkinListener {
    void onLoadFail(SkinDTO skinDTO);

    void onLoadSuccess(SkinDTO skinDTO);
}
