package com.loc;

import com.amap.api.maps.AMapException;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public final class k extends Exception {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private int g;
    private volatile boolean h;
    private String i;
    private Map<String, List<String>> j;

    /* JADX WARNING: Removed duplicated region for block: B:74:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0185  */
    public k(String str) {
        super(str);
        int i2;
        String str2;
        String str3;
        this.a = AMapException.ERROR_UNKNOWN;
        this.b = "";
        this.c = "";
        this.d = "1900";
        this.e = "UnknownError";
        this.f = -1;
        this.g = -1;
        this.h = false;
        this.a = str;
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f = 21;
            this.d = "1902";
            str3 = "IOException";
        } else {
            if (AMapException.ERROR_SOCKET.equals(str)) {
                i2 = 22;
            } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
                this.f = 23;
                this.d = "1802";
                str3 = "SocketTimeoutException";
            } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
                this.f = 24;
                this.d = "1901";
                str3 = "IllegalArgumentException";
            } else if ("空指针异常 - NullPointException".equals(str)) {
                this.f = 25;
                this.d = "1903";
                str3 = "NullPointException";
            } else if ("url异常 - MalformedURLException".equals(str)) {
                this.f = 26;
                this.d = "1803";
                str3 = "MalformedURLException";
            } else if ("未知主机 - UnKnowHostException".equals(str)) {
                this.f = 27;
                this.d = "1804";
                str3 = "UnknownHostException";
            } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
                this.f = 28;
                this.d = "1805";
                str3 = "CannotConnectToHostException";
            } else if ("协议解析错误 - ProtocolException".equals(str)) {
                this.f = 29;
                this.d = "1801";
                str3 = "ProtocolException";
            } else {
                if (AMapException.ERROR_CONNECTION.equals(str)) {
                    this.f = 30;
                    str2 = "1806";
                } else if ("服务QPS超限".equalsIgnoreCase(str)) {
                    this.f = 30;
                    str2 = "2001";
                } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
                    i2 = 31;
                } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
                    i2 = 32;
                } else if ("requeust is null".equals(str)) {
                    i2 = 1;
                } else {
                    if ("request url is empty".equals(str)) {
                        this.f = 2;
                    } else {
                        if (!"response is null".equals(str)) {
                            if ("thread pool has exception".equals(str)) {
                                i2 = 4;
                            } else if ("sdk name is invalid".equals(str)) {
                                i2 = 5;
                            } else if ("sdk info is null".equals(str)) {
                                this.f = 6;
                            } else if ("sdk packages is null".equals(str)) {
                                this.f = 7;
                            } else if ("线程池为空".equals(str)) {
                                i2 = 8;
                            } else if ("获取对象错误".equals(str)) {
                                i2 = 101;
                            } else if (!"DNS解析失败".equals(str)) {
                                i2 = -1;
                            }
                        }
                        this.f = 3;
                    }
                    if (!"IO 操作异常 - IOException".equals(str)) {
                        this.g = 7;
                        return;
                    } else if (AMapException.ERROR_SOCKET.equals(str)) {
                        this.g = 6;
                        return;
                    } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
                        this.g = 2;
                        return;
                    } else {
                        if (!"未知主机 - UnKnowHostException".equals(str)) {
                            if (AMapException.ERROR_CONNECTION.equals(str)) {
                                this.g = 6;
                                return;
                            } else if (!AMapException.ERROR_UNKNOWN.equals(str) && "DNS解析失败".equals(str)) {
                                this.g = 3;
                                return;
                            }
                        }
                        this.g = 9;
                        return;
                    }
                }
                this.d = str2;
                this.e = "ConnectionException";
                if (!"IO 操作异常 - IOException".equals(str)) {
                }
            }
            this.f = i2;
            if (!"IO 操作异常 - IOException".equals(str)) {
            }
        }
        this.e = str3;
        if (!"IO 操作异常 - IOException".equals(str)) {
        }
    }

    public k(String str, String str2, String str3) {
        this(str);
        this.b = str2;
        this.c = str3;
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.i = str;
    }

    public final void a(Map<String, List<String>> map) {
        this.j = map;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        this.g = 10;
        return 10;
    }

    public final boolean i() {
        return this.h;
    }

    public final void j() {
        this.h = true;
    }
}
