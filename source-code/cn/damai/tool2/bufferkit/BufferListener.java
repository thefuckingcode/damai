package cn.damai.tool2.bufferkit;

/* compiled from: Taobao */
public interface BufferListener<T> {
    void doRequestAsync();

    void onFail(String str, String str2);

    void onSuccess(T t);
}
