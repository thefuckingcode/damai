package com.alibaba.gaiax.studio.third.socket.java_websocket;

import android.util.Log;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

@Keep
/* compiled from: Taobao */
public abstract class AbstractWebSocket extends WebSocketAdapter {
    private int connectionLostTimeout = 60;
    private Timer connectionLostTimer;
    private TimerTask connectionLostTimerTask;
    private boolean reuseAddr;
    private final Object syncConnectionLost = new Object();
    private boolean tcpNoDelay;
    private boolean websocketRunning = false;

    private void cancelConnectionLostTimer() {
        Timer timer = this.connectionLostTimer;
        if (timer != null) {
            timer.cancel();
            this.connectionLostTimer = null;
        }
        TimerTask timerTask = this.connectionLostTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.connectionLostTimerTask = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void executeConnectionLostDetection(WebSocket webSocket, long j) {
        if (webSocket instanceof WebSocketImpl) {
            WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
            if (webSocketImpl.getLastPong() < j) {
                Log.e("[GaiaX]", "Closing connection due to no pong received: {}");
                webSocketImpl.closeConnection(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
            } else if (webSocketImpl.isOpen()) {
                webSocketImpl.sendPing();
            } else {
                Log.e("[GaiaX]", "Trying to ping a non open connection: {}");
            }
        }
    }

    private void restartConnectionLostTimer() {
        cancelConnectionLostTimer();
        this.connectionLostTimer = new Timer("WebSocketTimer");
        AnonymousClass1 r3 = new TimerTask() {
            /* class com.alibaba.gaiax.studio.third.socket.java_websocket.AbstractWebSocket.AnonymousClass1 */
            private ArrayList<WebSocket> connections = new ArrayList<>();

            public void run() {
                this.connections.clear();
                try {
                    this.connections.addAll(AbstractWebSocket.this.getConnections());
                    long currentTimeMillis = System.currentTimeMillis() - ((long) (AbstractWebSocket.this.connectionLostTimeout * 1500));
                    Iterator<WebSocket> it = this.connections.iterator();
                    while (it.hasNext()) {
                        AbstractWebSocket.this.executeConnectionLostDetection(it.next(), currentTimeMillis);
                    }
                } catch (Exception unused) {
                }
                this.connections.clear();
            }
        };
        this.connectionLostTimerTask = r3;
        Timer timer = this.connectionLostTimer;
        int i = this.connectionLostTimeout;
        timer.scheduleAtFixedRate(r3, ((long) i) * 1000, 1000 * ((long) i));
    }

    public int getConnectionLostTimeout() {
        int i;
        synchronized (this.syncConnectionLost) {
            i = this.connectionLostTimeout;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public abstract Collection<WebSocket> getConnections();

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public void setConnectionLostTimeout(int i) {
        synchronized (this.syncConnectionLost) {
            this.connectionLostTimeout = i;
            if (i <= 0) {
                Log.e("[GaiaX]", "Connection lost timer stopped");
                cancelConnectionLostTimer();
                return;
            }
            if (this.websocketRunning) {
                Log.e("[GaiaX]", "Connection lost timer restarted");
                try {
                    Iterator it = new ArrayList(getConnections()).iterator();
                    while (it.hasNext()) {
                        WebSocket webSocket = (WebSocket) it.next();
                        if (webSocket instanceof WebSocketImpl) {
                            ((WebSocketImpl) webSocket).updateLastPong();
                        }
                    }
                } catch (Exception e) {
                    Log.e("[GaiaX]", "Exception during connection lost restart", e);
                }
                restartConnectionLostTimer();
            }
        }
    }

    public void setReuseAddr(boolean z) {
        this.reuseAddr = z;
    }

    public void setTcpNoDelay(boolean z) {
        this.tcpNoDelay = z;
    }

    /* access modifiers changed from: protected */
    public void startConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            if (this.connectionLostTimeout <= 0) {
                Log.e("[GaiaX]", "Connection lost timer deactivated");
                return;
            }
            Log.e("[GaiaX]", "Connection lost timer started");
            this.websocketRunning = true;
            restartConnectionLostTimer();
        }
    }

    /* access modifiers changed from: protected */
    public void stopConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            if (!(this.connectionLostTimer == null && this.connectionLostTimerTask == null)) {
                this.websocketRunning = false;
                Log.e("[GaiaX]", "Connection lost timer stopped");
                cancelConnectionLostTimer();
            }
        }
    }
}
