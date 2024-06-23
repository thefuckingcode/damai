package cn.damai.tetris.v2.creator;

import tb.vl;

/* compiled from: Taobao */
public interface ICreator<T, DATA> {
    T create(vl<DATA> vlVar);
}
