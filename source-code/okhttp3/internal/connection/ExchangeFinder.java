package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ0\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0002J8\u0010&\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002J\u0006\u0010(\u001a\u00020%J\b\u0010)\u001a\u00020%H\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectingConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryCurrentRoute", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExchangeFinder.kt */
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address2, RealCall realCall, EventListener eventListener2) {
        Intrinsics.checkParameterIsNotNull(realConnectionPool, "connectionPool");
        Intrinsics.checkParameterIsNotNull(address2, "address");
        Intrinsics.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(eventListener2, "eventListener");
        this.connectionPool = realConnectionPool;
        this.address = address2;
        this.call = realCall;
        this.eventListener = eventListener2;
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics.checkParameterIsNotNull(realInterceptorChain, "chain");
        try {
            return findHealthyConnection(realInterceptorChain.getConnectTimeoutMillis$okhttp(), realInterceptorChain.getReadTimeoutMillis$okhttp(), realInterceptorChain.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), !Intrinsics.areEqual(realInterceptorChain.getRequest$okhttp().method(), "GET")).newCodec$okhttp(okHttpClient, realInterceptorChain);
        } catch (RouteException e) {
            trackFailure(e.getLastConnectException());
            throw e;
        } catch (IOException e2) {
            trackFailure(e2);
            throw new RouteException(e2);
        }
    }

    private final RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, i4, z);
            if (findConnection.isHealthy(z2)) {
                return findConnection;
            }
            findConnection.noNewExchanges();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r6.supportsUrl(r18.address.url()) == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e1, code lost:
        if (r4.hasNext() == false) goto L_0x00e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010f A[SYNTHETIC] */
    private final RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket socket;
        boolean z2;
        boolean z3;
        RealConnection realConnection = null;
        Route route = null;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.connectionPool) {
            if (!this.call.isCanceled()) {
                objectRef.element = (T) this.call.getConnection();
                if (this.call.getConnection() != null) {
                    RealConnection connection = this.call.getConnection();
                    if (connection == null) {
                        Intrinsics.throwNpe();
                    }
                    if (!connection.getNoNewExchanges()) {
                        RealConnection connection2 = this.call.getConnection();
                        if (connection2 == null) {
                            Intrinsics.throwNpe();
                        }
                    }
                    socket = this.call.releaseConnectionNoEvents$okhttp();
                    if (this.call.getConnection() != null) {
                        realConnection = this.call.getConnection();
                        objectRef.element = (T) null;
                    }
                    if (realConnection == null) {
                        this.refusedStreamCount = 0;
                        this.connectionShutdownCount = 0;
                        this.otherFailureCount = 0;
                        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
                            realConnection = this.call.getConnection();
                            z2 = true;
                            Unit unit = Unit.INSTANCE;
                        } else {
                            Route route2 = this.nextRouteToTry;
                            if (route2 != null) {
                                this.nextRouteToTry = null;
                                route = route2;
                            }
                        }
                    }
                    z2 = false;
                    Unit unit2 = Unit.INSTANCE;
                }
                socket = null;
                if (this.call.getConnection() != null) {
                }
                if (realConnection == null) {
                }
                z2 = false;
                Unit unit22 = Unit.INSTANCE;
            } else {
                throw new IOException("Canceled");
            }
        }
        if (socket != null) {
            Util.closeQuietly(socket);
        }
        if (objectRef.element != null) {
            EventListener eventListener2 = this.eventListener;
            RealCall realCall = this.call;
            T t = objectRef.element;
            if (t == null) {
                Intrinsics.throwNpe();
            }
            eventListener2.connectionReleased(realCall, t);
        }
        if (z2) {
            EventListener eventListener3 = this.eventListener;
            RealCall realCall2 = this.call;
            if (realConnection == null) {
                Intrinsics.throwNpe();
            }
            eventListener3.connectionAcquired(realCall2, realConnection);
        }
        if (realConnection != null) {
            if (realConnection == null) {
                Intrinsics.throwNpe();
            }
            return realConnection;
        }
        if (route == null) {
            RouteSelector.Selection selection = this.routeSelection;
            if (selection != null) {
                if (selection == null) {
                    Intrinsics.throwNpe();
                }
            }
            RouteSelector routeSelector2 = this.routeSelector;
            if (routeSelector2 == null) {
                routeSelector2 = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                this.routeSelector = routeSelector2;
            }
            this.routeSelection = routeSelector2.next();
            z3 = true;
            List<Route> list = null;
            synchronized (this.connectionPool) {
                if (!this.call.isCanceled()) {
                    if (z3) {
                        RouteSelector.Selection selection2 = this.routeSelection;
                        if (selection2 == null) {
                            Intrinsics.throwNpe();
                        }
                        list = selection2.getRoutes();
                        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, list, false)) {
                            realConnection = this.call.getConnection();
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        if (route == null) {
                            RouteSelector.Selection selection3 = this.routeSelection;
                            if (selection3 == null) {
                                Intrinsics.throwNpe();
                            }
                            route = selection3.next();
                        }
                        RealConnectionPool realConnectionPool = this.connectionPool;
                        if (route == null) {
                            Intrinsics.throwNpe();
                        }
                        realConnection = new RealConnection(realConnectionPool, route);
                        this.connectingConnection = realConnection;
                    }
                    Unit unit3 = Unit.INSTANCE;
                } else {
                    throw new IOException("Canceled");
                }
            }
            if (z2) {
                EventListener eventListener4 = this.eventListener;
                RealCall realCall3 = this.call;
                if (realConnection == null) {
                    Intrinsics.throwNpe();
                }
                eventListener4.connectionAcquired(realCall3, realConnection);
                if (realConnection == null) {
                    Intrinsics.throwNpe();
                }
                return realConnection;
            }
            if (realConnection == null) {
                Intrinsics.throwNpe();
            }
            realConnection.connect(i, i2, i3, i4, z, this.call, this.eventListener);
            RouteDatabase routeDatabase = this.call.getClient().getRouteDatabase();
            if (realConnection == null) {
                Intrinsics.throwNpe();
            }
            routeDatabase.connected(realConnection.route());
            Socket socket2 = null;
            synchronized (this.connectionPool) {
                this.connectingConnection = null;
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, list, true)) {
                    if (realConnection == null) {
                        Intrinsics.throwNpe();
                    }
                    realConnection.setNoNewExchanges(true);
                    if (realConnection == null) {
                        Intrinsics.throwNpe();
                    }
                    socket2 = realConnection.socket();
                    realConnection = this.call.getConnection();
                    this.nextRouteToTry = route;
                } else {
                    RealConnectionPool realConnectionPool2 = this.connectionPool;
                    if (realConnection == null) {
                        Intrinsics.throwNpe();
                    }
                    realConnectionPool2.put(realConnection);
                    RealCall realCall4 = this.call;
                    if (realConnection == null) {
                        Intrinsics.throwNpe();
                    }
                    realCall4.acquireConnectionNoEvents(realConnection);
                }
                Unit unit4 = Unit.INSTANCE;
            }
            if (socket2 != null) {
                Util.closeQuietly(socket2);
            }
            EventListener eventListener5 = this.eventListener;
            RealCall realCall5 = this.call;
            if (realConnection == null) {
                Intrinsics.throwNpe();
            }
            eventListener5.connectionAcquired(realCall5, realConnection);
            if (realConnection == null) {
                Intrinsics.throwNpe();
            }
            return realConnection;
        }
        z3 = false;
        List<Route> list2 = null;
        synchronized (this.connectionPool) {
        }
    }

    public final RealConnection connectingConnection() {
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnectionPool)) {
            return this.connectingConnection;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(realConnectionPool);
        throw new AssertionError(sb.toString());
    }

    public final void trackFailure(IOException iOException) {
        Intrinsics.checkParameterIsNotNull(iOException, "e");
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (!Util.assertionsEnabled || !Thread.holdsLock(realConnectionPool)) {
            synchronized (this.connectionPool) {
                this.nextRouteToTry = null;
                if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                } else if (iOException instanceof ConnectionShutdownException) {
                    this.connectionShutdownCount++;
                } else {
                    this.otherFailureCount++;
                }
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(realConnectionPool);
        throw new AssertionError(sb.toString());
    }

    public final boolean retryAfterFailure() {
        synchronized (this.connectionPool) {
            if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
                return false;
            }
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                RealConnection connection = this.call.getConnection();
                if (connection == null) {
                    Intrinsics.throwNpe();
                }
                this.nextRouteToTry = connection.route();
                return true;
            }
            RouteSelector.Selection selection = this.routeSelection;
            if (selection != null && selection.hasNext()) {
                return true;
            }
            RouteSelector routeSelector2 = this.routeSelector;
            if (routeSelector2 == null) {
                return true;
            }
            return routeSelector2.hasNext();
        }
    }

    private final boolean retryCurrentRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null || connection.getRouteFailureCount$okhttp() != 0 || !Util.canReuseConnectionFor(connection.route().address().url(), this.address.url())) {
            return false;
        }
        return true;
    }
}
