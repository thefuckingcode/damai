package anetwork.channel;

/* compiled from: Taobao */
public interface IBodyHandler {
    boolean isCompleted();

    int read(byte[] bArr);
}
