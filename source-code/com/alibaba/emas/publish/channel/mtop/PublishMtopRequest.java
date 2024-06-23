package com.alibaba.emas.publish.channel.mtop;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Keep
/* compiled from: Taobao */
public class PublishMtopRequest implements Serializable {
    public String API_NAME = "mtop.alibaba.emas.publish.update.get";
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = true;
    public String VERSION = "1.0";
    public long apiLevel = 0;
    public String appVersion = null;
    public Map<String, String> args = null;
    public List<String> bizTypes;
    public String brand = null;
    public String channel = null;
    public String identifier = null;
    public String locale = null;
    public String md5Sum = null;
    public String model = null;
    public Map<String, String> versions = null;
}
