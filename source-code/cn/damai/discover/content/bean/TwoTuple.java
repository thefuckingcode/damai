package cn.damai.discover.content.bean;

import java.io.Serializable;

/* compiled from: Taobao */
public class TwoTuple<F, S> implements Serializable {
    public final F first;
    public final S second;

    public TwoTuple(F f, S s) {
        this.first = f;
        this.second = s;
    }
}
