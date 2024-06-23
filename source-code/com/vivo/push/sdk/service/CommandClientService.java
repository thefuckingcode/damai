package com.vivo.push.sdk.service;

/* compiled from: Taobao */
public class CommandClientService extends CommandService {
    /* access modifiers changed from: protected */
    @Override // com.vivo.push.sdk.service.CommandService
    public final boolean a(String str) {
        return "com.vivo.pushclient.action.RECEIVE".equals(str);
    }
}
