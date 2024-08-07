package com.alibaba.gaiax.studio.third.socket.java_websocket.server;

import androidx.annotation.Keep;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketAdapter;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketImpl;
import com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory;
import com.alibaba.gaiax.studio.third.socket.java_websocket.drafts.Draft;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;

@Keep
/* compiled from: Taobao */
public class DefaultWebSocketServerFactory implements WebSocketServerFactory {
    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory
    public void close() {
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory
    public SocketChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) {
        return socketChannel;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketFactory
    public WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft) {
        return new WebSocketImpl(webSocketAdapter, draft);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketServerFactory, com.alibaba.gaiax.studio.third.socket.java_websocket.WebSocketFactory
    public WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list) {
        return new WebSocketImpl(webSocketAdapter, list);
    }
}
