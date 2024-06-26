package com.xiaomi.push;

import java.net.UnknownHostException;
import java.util.Objects;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ff {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        ez a;

        /* renamed from: a  reason: collision with other field name */
        String f349a;

        a() {
        }
    }

    static a a(Exception exc) {
        m472a(exc);
        boolean z = exc instanceof gh;
        Exception exc2 = exc;
        if (z) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        String str = exc2.getClass().getSimpleName() + ":" + message;
        int a2 = fy.a(exc2);
        if (a2 != 0) {
            aVar.a = ez.a(ez.GSLB_REQUEST_SUCCESS.a() + a2);
        }
        if (aVar.a == null) {
            aVar.a = ez.GSLB_TCP_ERR_OTHER;
        }
        if (aVar.a == ez.GSLB_TCP_ERR_OTHER) {
            aVar.f349a = str;
        }
        return aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m472a(Exception exc) {
        Objects.requireNonNull(exc);
    }

    static a b(Exception exc) {
        ez ezVar;
        Throwable cause;
        m472a(exc);
        boolean z = exc instanceof gh;
        Exception exc2 = exc;
        if (z) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fy.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            ez a3 = ez.a(ez.CONN_SUCCESS.a() + a2);
            aVar.a = a3;
            if (a3 == ez.CONN_BOSH_ERR && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                ezVar = ez.CONN_BOSH_UNKNOWNHOST;
            }
            ez ezVar2 = aVar.a;
            if (ezVar2 == ez.CONN_TCP_ERR_OTHER || ezVar2 == ez.CONN_XMPP_ERR || ezVar2 == ez.CONN_BOSH_ERR) {
                aVar.f349a = str;
            }
            return aVar;
        }
        ezVar = ez.CONN_XMPP_ERR;
        aVar.a = ezVar;
        ez ezVar22 = aVar.a;
        aVar.f349a = str;
        return aVar;
    }

    static a c(Exception exc) {
        ez ezVar;
        m472a(exc);
        boolean z = exc instanceof gh;
        Exception exc2 = exc;
        if (z) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        if (exc2.getCause() != null) {
            message = exc2.getCause().getMessage();
        }
        int a2 = fy.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            ezVar = ez.BIND_TCP_READ_TIMEOUT;
        } else if (a2 == 199) {
            ezVar = ez.BIND_TCP_ERR;
        } else if (a2 != 499) {
            ezVar = a2 != 109 ? a2 != 110 ? ez.BIND_XMPP_ERR : ez.BIND_TCP_BROKEN_PIPE : ez.BIND_TCP_CONNRESET;
        } else {
            aVar.a = ez.BIND_BOSH_ERR;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ezVar = ez.BIND_BOSH_ITEM_NOT_FOUND;
            }
            ez ezVar2 = aVar.a;
            if (ezVar2 == ez.BIND_TCP_ERR || ezVar2 == ez.BIND_XMPP_ERR || ezVar2 == ez.BIND_BOSH_ERR) {
                aVar.f349a = str;
            }
            return aVar;
        }
        aVar.a = ezVar;
        ez ezVar22 = aVar.a;
        aVar.f349a = str;
        return aVar;
    }

    static a d(Exception exc) {
        ez ezVar;
        m472a(exc);
        boolean z = exc instanceof gh;
        Exception exc2 = exc;
        if (z) {
            gh ghVar = (gh) exc;
            exc2 = exc;
            if (ghVar.a() != null) {
                exc2 = ghVar.a();
            }
        }
        a aVar = new a();
        String message = exc2.getMessage();
        int a2 = fy.a(exc2);
        String str = exc2.getClass().getSimpleName() + ":" + message;
        if (a2 == 105) {
            ezVar = ez.CHANNEL_TCP_READTIMEOUT;
        } else if (a2 == 199) {
            ezVar = ez.CHANNEL_TCP_ERR;
        } else if (a2 != 499) {
            ezVar = a2 != 109 ? a2 != 110 ? ez.CHANNEL_XMPPEXCEPTION : ez.CHANNEL_TCP_BROKEN_PIPE : ez.CHANNEL_TCP_CONNRESET;
        } else {
            aVar.a = ez.CHANNEL_BOSH_EXCEPTION;
            if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                ezVar = ez.CHANNEL_BOSH_ITEMNOTFIND;
            }
            ez ezVar2 = aVar.a;
            if (ezVar2 == ez.CHANNEL_TCP_ERR || ezVar2 == ez.CHANNEL_XMPPEXCEPTION || ezVar2 == ez.CHANNEL_BOSH_EXCEPTION) {
                aVar.f349a = str;
            }
            return aVar;
        }
        aVar.a = ezVar;
        ez ezVar22 = aVar.a;
        aVar.f349a = str;
        return aVar;
    }
}
