package com.youku.danmaku.engine.danmaku.loader;

import com.youku.danmaku.engine.danmaku.parser.IDataSource;
import java.io.InputStream;

/* compiled from: Taobao */
public interface ILoader {
    IDataSource<?> getDataSource();

    void load(InputStream inputStream) throws IllegalDataException;

    void load(String str) throws IllegalDataException;
}
