package com.youku.middlewareservice.provider.login;

/* compiled from: Taobao */
public class LoginConfig {
    private Env env;
    private String ttid;
    private String version;

    /* compiled from: Taobao */
    public static final class Builder {
        private Env env;
        private String ttid;
        private String version;

        public LoginConfig build() {
            return new LoginConfig(this);
        }

        public Builder env(Env env2) {
            this.env = env2;
            return this;
        }

        public Builder ttid(String str) {
            this.ttid = str;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        private Builder() {
        }
    }

    /* compiled from: Taobao */
    public enum Env {
        DAILY,
        PRE_RELEASE,
        RELEASE
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Env getEnv() {
        return this.env;
    }

    public String getTtid() {
        return this.ttid;
    }

    public String getVersion() {
        return this.version;
    }

    public void setEnv(Env env2) {
        this.env = env2;
    }

    public void setTtid(String str) {
        this.ttid = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    private LoginConfig(Builder builder) {
        setEnv(builder.env);
        setTtid(builder.ttid);
        setVersion(builder.version);
    }
}
