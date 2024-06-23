package com.youku.antitheftchain.interfaces;

import android.content.Context;

/* compiled from: Taobao */
public class AntiTheftChainParam {
    private AntiTheftChainClientType antiTheftChainClientType = AntiTheftChainClientType.Unknown;
    private String authCode = "mwua";
    private String ccode;
    private String clientIP;
    private String clientTs;
    private Context context;
    private int serverEnv = 0;
    private String utid;
    private String vid;

    public AntiTheftChainClientType getAntiTheftChainClientType() {
        return this.antiTheftChainClientType;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public String getCcode() {
        return this.ccode;
    }

    public String getClientIP() {
        return this.clientIP;
    }

    public String getClientTs() {
        return this.clientTs;
    }

    public Context getContext() {
        return this.context;
    }

    public int getServerEnv() {
        return this.serverEnv;
    }

    public String getUtid() {
        return this.utid;
    }

    public String getVid() {
        return this.vid;
    }

    public void setAntiTheftChainClientType(AntiTheftChainClientType antiTheftChainClientType2) {
        this.antiTheftChainClientType = antiTheftChainClientType2;
    }

    public void setAuthCode(String str) {
        this.authCode = str;
    }

    public void setCcode(String str) {
        this.ccode = str;
    }

    public void setClientIP(String str) {
        this.clientIP = str;
    }

    public void setClientTs(String str) {
        this.clientTs = str;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public void setServerEnv(int i) {
        this.serverEnv = i;
    }

    public void setUtid(String str) {
        this.utid = str;
    }

    public void setVid(String str) {
        this.vid = str;
    }
}
