package com.uc.webview.export.internal.interfaces;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: Taobao */
public interface INetworkDelegate {
    IResponseData onReceiveResponse(IResponseData iResponseData);

    IRequestData onSendRequest(IRequestData iRequestData);
}
