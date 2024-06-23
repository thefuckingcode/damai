package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopListener;

/* compiled from: Taobao */
abstract class MtopBaseListener {
    protected MtopListener listener;
    protected MtopBusiness mtopBusiness;

    protected MtopBaseListener(MtopBusiness mtopBusiness2, MtopListener mtopListener) {
        this.mtopBusiness = mtopBusiness2;
        this.listener = mtopListener;
    }
}
