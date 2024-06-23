package com.alibaba.wireless.security.aopsdk;

public class AopManager {
    private static AopManager d;
    private AopBridge a;
    private final AopBridge b = new AopBridge();
    private boolean c = true;

    private AopManager() {
    }

    public static synchronized AopManager getInstance() {
        AopManager aopManager;
        synchronized (AopManager.class) {
            if (d == null) {
                d = new AopManager();
            }
            aopManager = d;
        }
        return aopManager;
    }

    public synchronized void addChainDelegate(AopBridge aopBridge) {
        AopBridge aopBridge2 = this.a;
        if (aopBridge2 == null) {
            AopDelegateChain aopDelegateChain = new AopDelegateChain(this.b);
            aopDelegateChain.addDelegate(aopBridge);
            this.a = aopDelegateChain;
        } else if (aopBridge2 instanceof AopDelegateChain) {
            ((AopDelegateChain) aopBridge2).addDelegate(aopBridge);
        } else {
            AopDelegateChain aopDelegateChain2 = new AopDelegateChain(aopBridge2);
            aopDelegateChain2.addDelegate(aopBridge);
            this.a = aopDelegateChain2;
        }
    }

    public AopBridge getBridge() {
        if (!this.c) {
            return this.b;
        }
        AopBridge aopBridge = this.a;
        if (aopBridge != null) {
            return aopBridge;
        }
        return this.b;
    }

    public AopBridge getDelegate() {
        return this.a;
    }

    public void removeChainDelegate(AopBridge aopBridge) {
        if (aopBridge != null) {
            AopBridge aopBridge2 = this.a;
            if (aopBridge2 instanceof AopDelegateChain) {
                ((AopDelegateChain) aopBridge2).removeDelegate(aopBridge);
            }
        }
    }

    public synchronized void setDelegate(AopBridge aopBridge) {
        AopBridge aopBridge2 = this.a;
        if (aopBridge2 instanceof AopDelegateChain) {
            ((AopDelegateChain) aopBridge2).setMainDelegate(aopBridge);
        } else {
            this.a = aopBridge;
        }
    }

    public void setDelegateEnabled(boolean z) {
        this.c = z;
    }
}
