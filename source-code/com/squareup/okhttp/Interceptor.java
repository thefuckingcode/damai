package com.squareup.okhttp;

import java.io.IOException;

/* compiled from: Taobao */
public interface Interceptor {

    /* compiled from: Taobao */
    public interface Chain {
        Connection connection();

        Response proceed(Request request) throws IOException;

        Request request();
    }

    Response intercept(Chain chain) throws IOException;
}
