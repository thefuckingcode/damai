package cn.damai.tetris.v2.structure.container;

/* compiled from: Taobao */
public interface ValueTarget<T> {
    T getDefault();

    Class<T> getValueClass();
}
