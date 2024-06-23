package com.taobao.weex.bridge;

/* compiled from: Taobao */
public class ModuleFactoryImpl {
    public boolean hasRigster = false;
    public ModuleFactory mFactory = null;

    public ModuleFactoryImpl(ModuleFactory moduleFactory) {
        this.mFactory = moduleFactory;
    }

    public ModuleFactoryImpl(ModuleFactory moduleFactory, boolean z) {
        this.mFactory = moduleFactory;
        this.hasRigster = z;
    }
}
