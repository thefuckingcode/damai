package com.taobao.tao.remotebusiness;

import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
public interface IRemoteBaseListener extends IRemoteListener {
    void onSystemError(int i, MtopResponse mtopResponse, Object obj);
}
