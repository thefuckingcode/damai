package com.alibaba.gaiax.studio.third.socket.java_websocket;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;

@Keep
/* compiled from: Taobao */
public interface WebSocketServerFactory extends WebSocketFactory {
    void close();

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketFactory
    /* bridge */ /* synthetic */ WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft);

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketFactory
    /* bridge */ /* synthetic */ WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, List list);

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketFactory
    WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft);

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketFactory
    WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list);

    ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) throws IOException;
}
