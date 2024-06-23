package com.alibaba.emas.publish;

import androidx.annotation.Keep;
import com.alibaba.emas.publish.channel.mtop.PublishMtopUpdateInfo;
import com.alibaba.emas.publish.channel.slide.PublishSlideUpdateInfo;

@Keep
/* compiled from: Taobao */
public interface EmasPublishCallback {
    void fullAmountNotify(PublishSlideUpdateInfo publishSlideUpdateInfo);

    void updateCallback(PublishMtopUpdateInfo publishMtopUpdateInfo);
}
