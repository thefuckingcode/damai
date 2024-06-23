package okhttp3;

import java.io.File;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"okhttp3/RequestBody$Companion$asRequestBody$1", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: RequestBody.kt */
public final class RequestBody$Companion$asRequestBody$1 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ File $this_asRequestBody;

    RequestBody$Companion$asRequestBody$1(File file, MediaType mediaType) {
        this.$this_asRequestBody = file;
        this.$contentType = mediaType;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.$contentType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.$this_asRequestBody.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) {
        Intrinsics.checkParameterIsNotNull(bufferedSink, "sink");
        Source source = Okio.source(this.$this_asRequestBody);
        Throwable th = null;
        bufferedSink.writeAll(source);
        CloseableKt.closeFinally(source, th);
    }
}
