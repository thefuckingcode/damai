package androidx.room.util;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* compiled from: Taobao */
public class FileUtil {
    private FileUtil() {
    }

    @SuppressLint({"LambdaLast"})
    public static void copy(@NonNull ReadableByteChannel readableByteChannel, @NonNull FileChannel fileChannel) throws IOException {
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                InputStream newInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream newOutputStream = Channels.newOutputStream(fileChannel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    newOutputStream.write(bArr, 0, read);
                }
            } else {
                fileChannel.transferFrom(readableByteChannel, 0, AbsPerformance.LONG_NIL);
            }
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
