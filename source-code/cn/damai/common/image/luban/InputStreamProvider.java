package cn.damai.common.image.luban;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public interface InputStreamProvider {
    String getPath();

    InputStream open() throws IOException;
}
