package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* compiled from: Taobao */
public class ExceptionCode {
    public static final int CANCEL = 10000100;
    private static final String CONNECT = "connect";
    public static final int CONNECTION_ABORT = 10000402;
    public static final int CONNECTION_REFUSED = 10000404;
    public static final int CONNECTION_RESET = 10000401;
    public static final int CONNECT_FAILED = 10000403;
    public static final int CRASH_EXCEPTION = 10000000;
    public static final int INTERRUPT_CONNECT_CLOSE = 10000405;
    public static final int INTERRUPT_EXCEPTION = 10000804;
    public static final int NETWORK_CHANGED = 10000201;
    public static final int NETWORK_IO_EXCEPTION = 10000802;
    public static final int NETWORK_TIMEOUT = 10000101;
    public static final int NETWORK_UNREACHABLE = 10000200;
    public static final int NETWORK_UNSUPPORTED = 10000102;
    public static final int PROTOCOL_ERROR = 10000801;
    private static final String READ = "read";
    public static final int READ_ERROR = 10000601;
    public static final int ROUTE_FAILED = 10000301;
    public static final int SHUTDOWN_EXCEPTION = 10000202;
    public static final int SOCKET_CLOSE = 10000406;
    public static final int SOCKET_CONNECT_TIMEOUT = 10000400;
    public static final int SOCKET_READ_TIMEOUT = 10000600;
    public static final int SOCKET_TIMEOUT = 10000803;
    public static final int SOCKET_WRITE_TIMEOUT = 10000700;
    public static final int SSL_HANDSHAKE_EXCEPTION = 10000501;
    public static final int SSL_PEERUNVERIFIED_EXCEPTION = 10000502;
    public static final int SSL_PROTOCOL_EXCEPTION = 10000500;
    public static final int UNABLE_TO_RESOLVE_HOST = 10000300;
    public static final int UNEXPECTED_EOF = 10000800;
    private static final String WRITE = "write";

    private static String checkExceptionContainsKey(Exception exc, String... strArr) {
        return checkStrContainsKey(StringUtils.toLowerCase(exc.getMessage()), strArr);
    }

    private static String checkStrContainsKey(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }

    public static int getErrorCodeFromException(Exception exc) {
        if (exc == null) {
            return NETWORK_IO_EXCEPTION;
        }
        if (!(exc instanceof IOException)) {
            return CRASH_EXCEPTION;
        }
        String message = exc.getMessage();
        if (message == null) {
            return NETWORK_IO_EXCEPTION;
        }
        String lowerCase = StringUtils.toLowerCase(message);
        int errorCodeFromMsg = getErrorCodeFromMsg(lowerCase);
        if (errorCodeFromMsg != 10000802) {
            return errorCodeFromMsg;
        }
        if (exc instanceof SocketTimeoutException) {
            return getErrorCodeSocketTimeout(exc);
        }
        if (exc instanceof ConnectException) {
            return CONNECT_FAILED;
        }
        if (exc instanceof NoRouteToHostException) {
            return ROUTE_FAILED;
        }
        if (exc instanceof SSLProtocolException) {
            return SSL_PROTOCOL_EXCEPTION;
        }
        if (exc instanceof SSLHandshakeException) {
            return SSL_HANDSHAKE_EXCEPTION;
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return SSL_PEERUNVERIFIED_EXCEPTION;
        }
        if (exc instanceof UnknownHostException) {
            return UNABLE_TO_RESOLVE_HOST;
        }
        return exc instanceof InterruptedIOException ? lowerCase.contains("connection has been shut down") ? INTERRUPT_CONNECT_CLOSE : INTERRUPT_EXCEPTION : exc instanceof ProtocolException ? PROTOCOL_ERROR : errorCodeFromMsg;
    }

    private static int getErrorCodeFromMsg(String str) {
        if (str.contains("unexpected end of stream")) {
            return UNEXPECTED_EOF;
        }
        if (str.contains("unable to resolve host")) {
            return UNABLE_TO_RESOLVE_HOST;
        }
        if (str.contains("read error")) {
            return READ_ERROR;
        }
        if (str.contains("connection reset")) {
            return CONNECTION_RESET;
        }
        if (str.contains("software caused connection abort")) {
            return CONNECTION_ABORT;
        }
        if (str.contains("failed to connect to")) {
            return CONNECT_FAILED;
        }
        if (str.contains("connection refused")) {
            return CONNECTION_REFUSED;
        }
        if (str.contains("connection timed out")) {
            return SOCKET_CONNECT_TIMEOUT;
        }
        if (str.contains("no route to host")) {
            return ROUTE_FAILED;
        }
        if (str.contains("network is unreachable")) {
            return NETWORK_UNREACHABLE;
        }
        return str.contains("socket closed") ? SOCKET_CLOSE : NETWORK_IO_EXCEPTION;
    }

    private static int getErrorCodeSocketTimeout(Exception exc) {
        String checkExceptionContainsKey = checkExceptionContainsKey(exc, "connect", "read", "write");
        checkExceptionContainsKey.hashCode();
        char c = 65535;
        switch (checkExceptionContainsKey.hashCode()) {
            case 3496342:
                if (checkExceptionContainsKey.equals("read")) {
                    c = 0;
                    break;
                }
                break;
            case 113399775:
                if (checkExceptionContainsKey.equals("write")) {
                    c = 1;
                    break;
                }
                break;
            case 951351530:
                if (checkExceptionContainsKey.equals("connect")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return SOCKET_READ_TIMEOUT;
            case 1:
                return SOCKET_WRITE_TIMEOUT;
            case 2:
                return SOCKET_CONNECT_TIMEOUT;
            default:
                return SOCKET_TIMEOUT;
        }
    }
}
