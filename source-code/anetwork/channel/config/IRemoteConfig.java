package anetwork.channel.config;

/* compiled from: Taobao */
public interface IRemoteConfig {
    String getConfig(String... strArr);

    void onConfigUpdate(String str);

    void register();

    void unRegister();
}
