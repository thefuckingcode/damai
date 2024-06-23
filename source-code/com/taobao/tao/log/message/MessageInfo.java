package com.taobao.tao.log.message;

import android.content.Context;
import com.taobao.tao.log.TLogInitializer;

/* compiled from: Taobao */
public class MessageInfo {
    public static String keyName = "content";
    public String accsServiceId = TLogInitializer.getInstance().accsServiceId;
    public String accsTag = TLogInitializer.getInstance().accsTag;
    public String appKey = null;
    public String content = null;
    public Context context = null;
    public String deviceId = null;
    public String hostName = TLogInitializer.getInstance().messageHostName;
    public String publicKeyDigest = null;
    public String ttid = null;
}
