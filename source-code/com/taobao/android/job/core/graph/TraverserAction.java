package com.taobao.android.job.core.graph;

/* compiled from: Taobao */
public interface TraverserAction<T, R> {
    void onNewLevel(int i);

    void onNewPath(int i);

    void onNode(Node<T, R> node);
}
