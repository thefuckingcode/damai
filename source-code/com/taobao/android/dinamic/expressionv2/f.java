package com.taobao.android.dinamic.expressionv2;

import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
public class f extends DinamicASTNode {
    @Override // com.taobao.android.dinamic.expressionv2.DinamicASTNode
    public Object c() {
        DinamicLog.h("VarName:" + this.d);
        return this.d;
    }
}
