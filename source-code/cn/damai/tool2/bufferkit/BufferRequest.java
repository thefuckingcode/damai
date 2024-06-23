package cn.damai.tool2.bufferkit;

/* compiled from: Taobao */
public interface BufferRequest<T> {
    void cancel();

    void doRequest(BufferListener<T> bufferListener);

    String getGroupType();

    String getUniKey();
}
