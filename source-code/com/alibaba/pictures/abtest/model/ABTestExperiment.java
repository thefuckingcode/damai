package com.alibaba.pictures.abtest.model;

import java.io.Serializable;

/* compiled from: Taobao */
public class ABTestExperiment implements Serializable {
    public Long experimentId;
    public String experimentVersionId;
    public Params params;
    public String scenario;

    /* compiled from: Taobao */
    public static class Params implements Serializable {
        public String bucketId;
    }
}
