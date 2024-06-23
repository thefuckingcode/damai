package com.youku.live.dsl.share;

import java.util.List;

/* compiled from: Taobao */
public interface IShare {
    List<ShareTarget> getSupportTargets(ShareMode shareMode);

    void share(IShareInfo iShareInfo, IShareResult iShareResult);
}
