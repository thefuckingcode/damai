package com.youku.live.dsl.network;

import java.io.Serializable;

/* compiled from: Taobao */
public interface IResponseModel<Model extends Serializable> extends IResponse {
    Model getModel();
}
