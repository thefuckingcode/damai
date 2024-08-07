package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public final class ConnectionPool {
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000;
    private static final ConnectionPool systemDefault;
    private final LinkedList<Connection> connections = new LinkedList<>();
    private final Runnable connectionsCleanupRunnable = new Runnable() {
        /* class com.squareup.okhttp.ConnectionPool.AnonymousClass1 */

        public void run() {
            ConnectionPool.this.runCleanupUntilPoolIsEmpty();
        }
    };
    private Executor executor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000;
        if (property != null && !Boolean.parseBoolean(property)) {
            systemDefault = new ConnectionPool(0, parseLong);
        } else if (property3 != null) {
            systemDefault = new ConnectionPool(Integer.parseInt(property3), parseLong);
        } else {
            systemDefault = new ConnectionPool(5, parseLong);
        }
    }

    public ConnectionPool(int i, long j) {
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = j * 1000 * 1000;
    }

    private void addConnection(Connection connection) {
        boolean isEmpty = this.connections.isEmpty();
        this.connections.addFirst(connection);
        if (isEmpty) {
            this.executor.execute(this.connectionsCleanupRunnable);
        } else {
            notifyAll();
        }
    }

    public static ConnectionPool getDefault() {
        return systemDefault;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void runCleanupUntilPoolIsEmpty() {
        do {
        } while (performCleanup());
    }

    public void evictAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.connections);
            this.connections.clear();
            notifyAll();
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Util.closeQuietly(((Connection) arrayList.get(i)).getSocket());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        r0 = r2;
     */
    public synchronized Connection get(Address address) {
        Connection connection;
        connection = null;
        LinkedList<Connection> linkedList = this.connections;
        ListIterator<Connection> listIterator = linkedList.listIterator(linkedList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Connection previous = listIterator.previous();
            if (previous.getRoute().getAddress().equals(address) && previous.isAlive()) {
                if (System.nanoTime() - previous.getIdleStartTimeNs() < this.keepAliveDurationNs) {
                    listIterator.remove();
                    if (previous.isSpdy()) {
                        break;
                    }
                    try {
                        Platform.get().tagSocket(previous.getSocket());
                        break;
                    } catch (SocketException e) {
                        Util.closeQuietly(previous.getSocket());
                        Platform platform = Platform.get();
                        platform.logW("Unable to tagSocket(): " + e);
                    }
                }
            }
        }
        if (connection != null && connection.isSpdy()) {
            this.connections.addFirst(connection);
        }
        return connection;
    }

    public synchronized int getConnectionCount() {
        return this.connections.size();
    }

    /* access modifiers changed from: package-private */
    public synchronized List<Connection> getConnections() {
        return new ArrayList(this.connections);
    }

    public synchronized int getHttpConnectionCount() {
        return this.connections.size() - getMultiplexedConnectionCount();
    }

    public synchronized int getMultiplexedConnectionCount() {
        int i;
        i = 0;
        Iterator<Connection> it = this.connections.iterator();
        while (it.hasNext()) {
            if (it.next().isSpdy()) {
                i++;
            }
        }
        return i;
    }

    @Deprecated
    public synchronized int getSpdyConnectionCount() {
        return getMultiplexedConnectionCount();
    }

    /* access modifiers changed from: package-private */
    public boolean performCleanup() {
        synchronized (this) {
            if (this.connections.isEmpty()) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            long nanoTime = System.nanoTime();
            long j = this.keepAliveDurationNs;
            LinkedList<Connection> linkedList = this.connections;
            ListIterator<Connection> listIterator = linkedList.listIterator(linkedList.size());
            int i = 0;
            while (listIterator.hasPrevious()) {
                Connection previous = listIterator.previous();
                long idleStartTimeNs = (previous.getIdleStartTimeNs() + this.keepAliveDurationNs) - nanoTime;
                if (idleStartTimeNs > 0) {
                    if (previous.isAlive()) {
                        if (previous.isIdle()) {
                            i++;
                            j = Math.min(j, idleStartTimeNs);
                        }
                    }
                }
                listIterator.remove();
                arrayList.add(previous);
            }
            LinkedList<Connection> linkedList2 = this.connections;
            ListIterator<Connection> listIterator2 = linkedList2.listIterator(linkedList2.size());
            while (listIterator2.hasPrevious() && i > this.maxIdleConnections) {
                Connection previous2 = listIterator2.previous();
                if (previous2.isIdle()) {
                    arrayList.add(previous2);
                    listIterator2.remove();
                    i--;
                }
            }
            if (arrayList.isEmpty()) {
                try {
                    long j2 = j / 1000000;
                    Long.signum(j2);
                    wait(j2, (int) (j - (1000000 * j2)));
                    return true;
                } catch (InterruptedException unused) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Util.closeQuietly(((Connection) arrayList.get(i2)).getSocket());
                    }
                    return true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void recycle(Connection connection) {
        if (connection.isSpdy() || !connection.clearOwner()) {
            return;
        }
        if (!connection.isAlive()) {
            Util.closeQuietly(connection.getSocket());
            return;
        }
        try {
            Platform.get().untagSocket(connection.getSocket());
            synchronized (this) {
                addConnection(connection);
                connection.incrementRecycleCount();
                connection.resetIdleStartTime();
            }
        } catch (SocketException e) {
            Platform platform = Platform.get();
            platform.logW("Unable to untagSocket(): " + e);
            Util.closeQuietly(connection.getSocket());
        }
    }

    /* access modifiers changed from: package-private */
    public void replaceCleanupExecutorForTests(Executor executor2) {
        this.executor = executor2;
    }

    /* access modifiers changed from: package-private */
    public void share(Connection connection) {
        if (!connection.isSpdy()) {
            throw new IllegalArgumentException();
        } else if (connection.isAlive()) {
            synchronized (this) {
                addConnection(connection);
            }
        }
    }
}
