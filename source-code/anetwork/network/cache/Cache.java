package anetwork.network.cache;

/* compiled from: Taobao */
public interface Cache {
    RpcCache get(String str, String str2);

    boolean put(String str, String str2, RpcCache rpcCache);

    boolean remove(String str);

    boolean remove(String str, String str2);

    boolean uninstall(String str);
}
