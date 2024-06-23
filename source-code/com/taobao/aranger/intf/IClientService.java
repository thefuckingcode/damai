package com.taobao.aranger.intf;

import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;

/* compiled from: Taobao */
public interface IClientService extends IService {
    Reply sendCallback(Callback callback) throws Exception;
}
