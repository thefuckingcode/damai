package com.youku.live.livesdk.model.mtop.base;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class MtopBaseBean<T> implements Serializable {
    public String api;
    public T data;
    public List<String> ret;
    public String v;
}
