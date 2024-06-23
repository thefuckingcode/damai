package cn.damai.common.soloader.relinker;

/* compiled from: Taobao */
public interface ReLinker$LibraryLoader {
    void loadLibrary(String str);

    void loadPath(String str);

    String mapLibraryName(String str);

    String[] supportedAbis();

    String unmapLibraryName(String str);
}
