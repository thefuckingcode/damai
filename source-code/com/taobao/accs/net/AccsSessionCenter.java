package com.taobao.accs.net;

import anet.channel.Session;
import anet.channel.c;
import anet.channel.entity.ConnType;
import com.taobao.accs.connection.ConnectionServiceManager;

/* compiled from: Taobao */
public class AccsSessionCenter {
    private static final String TAG = "AccsSessionCenter";

    public static Session get(c cVar, String str, long j) {
        if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return null;
        }
        return cVar.h(str, j);
    }

    public static Session getThrowsException(c cVar, String str, long j) throws Exception {
        if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return null;
        }
        return cVar.r(str, j);
    }

    public static Session get(c cVar, String str, ConnType.TypeLevel typeLevel, long j) {
        if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return null;
        }
        return cVar.i(str, typeLevel, j);
    }

    public static Session getThrowsException(c cVar, String str, ConnType.TypeLevel typeLevel, long j) throws Exception {
        if (!ConnectionServiceManager.getInstance().isCurProcessAllow2Connect()) {
            return null;
        }
        return cVar.s(str, typeLevel, j);
    }
}
