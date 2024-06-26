package com.alibaba.security.biometrics.sensor.model;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class DisplayInfo implements Serializable {
    private float density;
    private float densityDPI;
    private int displayId;
    private int height;
    private int modeID;
    private List<a> modes;
    private int rotation;
    private float scaleDensity;
    private int state;
    private int type;
    private int width;
    private float xdip;
    private float ydip;

    /* compiled from: Taobao */
    public static class a {
        public float a;
        public int b;
        public int c;
        public int d;

        private float a() {
            return this.a;
        }

        private int b() {
            return this.b;
        }

        private int c() {
            return this.c;
        }

        private int d() {
            return this.d;
        }

        private void a(float f) {
            this.a = f;
        }

        private void b(int i) {
            this.c = i;
        }

        private void c(int i) {
            this.d = i;
        }

        private void a(int i) {
            this.b = i;
        }
    }

    public float getDensity() {
        return this.density;
    }

    public float getDensityDPI() {
        return this.densityDPI;
    }

    public int getDisplayId() {
        return this.displayId;
    }

    public int getHeight() {
        return this.height;
    }

    public int getModeID() {
        return this.modeID;
    }

    public List<a> getModes() {
        return this.modes;
    }

    public int getRotation() {
        return this.rotation;
    }

    public float getScaleDensity() {
        return this.scaleDensity;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public float getXdip() {
        return this.xdip;
    }

    public float getYdip() {
        return this.ydip;
    }

    public void setDensity(float f) {
        this.density = f;
    }

    public void setDensityDPI(float f) {
        this.densityDPI = f;
    }

    public void setDisplayId(int i) {
        this.displayId = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setModeID(int i) {
        this.modeID = i;
    }

    public void setModes(List<a> list) {
        this.modes = list;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    public void setScaleDensity(float f) {
        this.scaleDensity = f;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setXdip(float f) {
        this.xdip = f;
    }

    public void setYdip(float f) {
        this.ydip = f;
    }
}
