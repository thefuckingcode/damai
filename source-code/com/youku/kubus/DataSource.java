package com.youku.kubus;

import android.util.LongSparseArray;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
@NoProguard
/* compiled from: Taobao */
public class DataSource {
    private Map<String, Object> dataSets = new HashMap();
    private Map<String, Event> mStickEventSets = new HashMap();
    private LongSparseArray<Request> requests = new LongSparseArray<>();
    private LongSparseArray<Response> responses = new LongSparseArray<>();

    DataSource() {
    }

    /* access modifiers changed from: protected */
    public synchronized Object getData(String str) {
        return this.dataSets.get(str);
    }

    /* access modifiers changed from: protected */
    public Request getRequest(long j) {
        return this.requests.get(j);
    }

    /* access modifiers changed from: protected */
    public Response getResponse(long j) {
        return this.responses.get(j);
    }

    /* access modifiers changed from: protected */
    public synchronized void putData(String str, Object obj) {
        this.dataSets.put(str, obj);
    }

    /* access modifiers changed from: protected */
    public synchronized void putRequest(long j, Request request) {
        this.requests.put(j, request);
    }

    /* access modifiers changed from: protected */
    public synchronized void putResponse(long j, Response response) {
        this.responses.put(j, response);
    }

    /* access modifiers changed from: protected */
    public synchronized void removeRequest(long j) {
        this.requests.remove(j);
    }

    /* access modifiers changed from: protected */
    public synchronized void removeResponse(long j) {
        this.responses.remove(j);
    }
}
