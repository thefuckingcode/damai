package com.alibaba.emas.publish.channel.mtop;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.List;
import tb.pm;

@Keep
/* compiled from: Taobao */
public class PublishMtopResponse implements Serializable {
    public String clientRetCode;
    public String clientRetMsg;
    public boolean hasUpdate;
    public String retCode;
    public String retMsg;
    public String source = pm.o;
    public Boolean success;
    public List<PublishMtopUpdateInfo> updateInfo;
}
