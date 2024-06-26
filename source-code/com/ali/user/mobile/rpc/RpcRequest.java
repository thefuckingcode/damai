package com.ali.user.mobile.rpc;

import com.ali.user.mobile.rpc.filter.IAfterFilter;
import com.ali.user.mobile.rpc.filter.IBeforeFilter;
import com.taobao.login4android.config.LoginSwitch;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
public class RpcRequest {
    public String API_NAME;
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = false;
    public boolean SHOW_LOGIN_UI = true;
    public String VERSION = "1.0";
    protected final List<IAfterFilter> afterFilters = new LinkedList();
    protected final List<IBeforeFilter> beforeFilters = new LinkedList();
    public int connectionTimeoutMilliSecond = LoginSwitch.LOGOUT_POST_DEFAULT;
    public String dailyDomain;
    public String onlineDomain;
    public ArrayList<String> paramNames = new ArrayList<>();
    public ArrayList<Object> paramValues = new ArrayList<>();
    public String preDomain;
    public int requestSite;
    public int socketTimeoutMilliSecond = LoginSwitch.LOGOUT_POST_DEFAULT;
    public int timeoutMilliSecond = LoginSwitch.LOGOUT_POST_DEFAULT;

    public void addAfter(IAfterFilter iAfterFilter) {
        this.afterFilters.add(iAfterFilter);
    }

    public void addBefore(IBeforeFilter iBeforeFilter) {
        this.beforeFilters.add(iBeforeFilter);
    }

    public void addParam(String str, Object obj) {
        this.paramNames.add(str);
        this.paramValues.add(obj);
    }

    public List<IAfterFilter> getAfterFilters() {
        return this.afterFilters;
    }

    public List<IBeforeFilter> getBeforeFilters() {
        return this.beforeFilters;
    }

    public String toString() {
        return "RpcRequest{API_NAME='" + this.API_NAME + '\'' + ", VERSION='" + this.VERSION + '\'' + ", dailyDomain='" + this.dailyDomain + '\'' + ", preDomain='" + this.preDomain + '\'' + ", onlineDomain='" + this.onlineDomain + '\'' + '}';
    }
}
