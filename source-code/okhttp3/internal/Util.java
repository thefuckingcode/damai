package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.lzy.okgo.cookie.SerializableCookie;
import com.lzy.okgo.model.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS = Options.Companion.of(ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000"));
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    public static final boolean assertionsEnabled = false;
    public static final String okHttpName;

    public static final int and(byte b, int i) {
        return b & i;
    }

    public static final int and(short s, int i) {
        return s & i;
    }

    public static final long and(int i, long j) {
        return j & ((long) i);
    }

    public static final int parseHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        if (timeZone == null) {
            Intrinsics.throwNpe();
        }
        UTC = timeZone;
        String name = OkHttpClient.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "OkHttpClient::class.java.name");
        okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix(name, (CharSequence) "okhttp3."), (CharSequence) "Client");
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final ThreadFactory threadFactory(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        return new Util$threadFactory$1(str, z);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics.checkParameterIsNotNull(strArr, "$this$intersect");
        Intrinsics.checkParameterIsNotNull(strArr2, "other");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics.checkParameterIsNotNull(strArr, "$this$hasIntersection");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z) {
        String str;
        Intrinsics.checkParameterIsNotNull(httpUrl, "$this$toHostHeader");
        if (StringsKt.contains$default((CharSequence) httpUrl.host(), (CharSequence) ":", false, 2, (Object) null)) {
            str = '[' + httpUrl.host() + ']';
        } else {
            str = httpUrl.host();
        }
        if (!z && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return str;
        }
        return str + ':' + httpUrl.port();
    }

    public static final String[] concat(String[] strArr, String str) {
        Intrinsics.checkParameterIsNotNull(strArr, "$this$concat");
        Intrinsics.checkParameterIsNotNull(str, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        strArr2[ArraysKt.getLastIndex(strArr2)] = str;
        if (strArr2 != null) {
            return strArr2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$indexOfLastNonAsciiWhitespace");
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char charAt = str.charAt(i3);
                if (charAt == '\t' || charAt == '\n' || charAt == '\f' || charAt == '\r' || charAt == ' ') {
                    if (i3 == i) {
                        break;
                    }
                    i3--;
                } else {
                    return i3 + 1;
                }
            }
        }
        return i;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return trimSubstring(str, i, i2);
    }

    public static final String trimSubstring(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$trimSubstring");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i, i2);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i2));
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, str2, i, i2);
    }

    public static final int delimiterOffset(String str, String str2, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$delimiterOffset");
        Intrinsics.checkParameterIsNotNull(str2, "delimiters");
        while (i < i2) {
            if (StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    public static final int delimiterOffset(String str, char c, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "$this$delimiterOffset");
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean canParseAsIpAddress(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final String format(String str, Object... objArr) {
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(objArr, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) {
        Intrinsics.checkParameterIsNotNull(bufferedSource, "$this$readBomAsCharset");
        Intrinsics.checkParameterIsNotNull(charset, "default");
        int select = bufferedSource.select(UNICODE_BOMS);
        if (select == -1) {
            return charset;
        }
        if (select == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            Intrinsics.checkExpressionValueIsNotNull(charset2, "UTF_8");
            return charset2;
        } else if (select == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            Intrinsics.checkExpressionValueIsNotNull(charset3, "UTF_16BE");
            return charset3;
        } else if (select == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            Intrinsics.checkExpressionValueIsNotNull(charset4, "UTF_16LE");
            return charset4;
        } else if (select == 3) {
            return Charsets.INSTANCE.UTF32_BE();
        } else {
            if (select == 4) {
                return Charsets.INSTANCE.UTF32_LE();
            }
            throw new AssertionError();
        }
    }

    public static final int checkDuration(String str, long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        boolean z = true;
        if (j >= 0) {
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis <= ((long) Integer.MAX_VALUE)) {
                    if (millis == 0 && j > 0) {
                        z = false;
                    }
                    if (z) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException((str + " too small.").toString());
                }
                throw new IllegalArgumentException((str + " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException((str + " < 0").toString());
    }

    public static final Headers toHeaders(List<Header> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    public static final List<Header> toHeaderList(Headers headers) {
        Intrinsics.checkParameterIsNotNull(headers, "$this$toHeaderList");
        IntRange until = RangesKt.until(0, headers.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        Intrinsics.checkParameterIsNotNull(httpUrl, "$this$canReuseConnectionFor");
        Intrinsics.checkParameterIsNotNull(httpUrl2, "other");
        return Intrinsics.areEqual(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && Intrinsics.areEqual(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        Intrinsics.checkParameterIsNotNull(eventListener, "$this$asFactory");
        return new Util$asFactory$1(eventListener);
    }

    public static final void writeMedium(BufferedSink bufferedSink, int i) {
        Intrinsics.checkParameterIsNotNull(bufferedSink, "$this$writeMedium");
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    public static final int readMedium(BufferedSource bufferedSource) {
        Intrinsics.checkParameterIsNotNull(bufferedSource, "$this$readMedium");
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        if (r5 == kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        r11.timeout().clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005b, code lost:
        r11.timeout().deadlineNanoTime(r0 + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        if (r5 != kotlin.jvm.internal.LongCompanionObject.MAX_VALUE) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        return r12;
     */
    public static final boolean skipAll(Source source, int i, TimeUnit timeUnit) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(source, "$this$skipAll");
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos((long) i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                buffer.clear();
            }
            z = true;
        } catch (InterruptedIOException unused) {
            z = false;
        } catch (Throwable th) {
            if (deadlineNanoTime == LongCompanionObject.MAX_VALUE) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static final boolean discard(Source source, int i, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(source, "$this$discard");
        Intrinsics.checkParameterIsNotNull(timeUnit, "timeUnit");
        try {
            return skipAll(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String peerName(Socket socket) {
        Intrinsics.checkParameterIsNotNull(socket, "$this$peerName");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        Intrinsics.checkExpressionValueIsNotNull(hostName, "address.hostName");
        return hostName;
    }

    /* JADX INFO: finally extract failed */
    public static final boolean isHealthy(Socket socket, BufferedSource bufferedSource) {
        Intrinsics.checkParameterIsNotNull(socket, "$this$isHealthy");
        Intrinsics.checkParameterIsNotNull(bufferedSource, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z = !bufferedSource.exhausted();
                socket.setSoTimeout(soTimeout);
                return z;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final void ignoreIoExceptions(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "block");
        try {
            function0.invoke();
        } catch (IOException unused) {
        }
    }

    public static final void threadName(String str, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(str, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(function0, "block");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            currentThread.setName(name);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final int skipAll(Buffer buffer, byte b) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$skipAll");
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0) == b) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return indexOfNonWhitespace(str, i);
    }

    public static final int indexOfNonWhitespace(String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "$this$indexOfNonWhitespace");
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    public static final long headersContentLength(Response response) {
        Intrinsics.checkParameterIsNotNull(response, "$this$headersContentLength");
        String str = response.headers().get(HttpHeaders.HEAD_KEY_CONTENT_LENGTH);
        if (str != null) {
            return toLongOrDefault(str, -1);
        }
        return -1;
    }

    public static final long toLongOrDefault(String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toLongOrDefault");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int toNonNegativeInt(String str, int i) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > ((long) Integer.MAX_VALUE)) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$this$toImmutableList");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <T> List<T> immutableListOf(T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableList, "Collections.unmodifiable…sList(*elements.clone()))");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final void closeQuietly(Closeable closeable) {
        Intrinsics.checkParameterIsNotNull(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(Socket socket) {
        Intrinsics.checkParameterIsNotNull(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        Intrinsics.checkParameterIsNotNull(serverSocket, "$this$closeQuietly");
        try {
            serverSocket.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final String toHexString(long j) {
        String hexString = Long.toHexString(j);
        Intrinsics.checkExpressionValueIsNotNull(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    public static final String toHexString(int i) {
        String hexString = Integer.toHexString(i);
        Intrinsics.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    public static final void wait(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$wait");
        obj.wait();
    }

    public static final void notify(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$notify");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$notifyAll");
        obj.notifyAll();
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        Object readFieldOrNull;
        Intrinsics.checkParameterIsNotNull(obj, "instance");
        Intrinsics.checkParameterIsNotNull(cls, "fieldType");
        Intrinsics.checkParameterIsNotNull(str, "fieldName");
        Class<?> cls2 = obj.getClass();
        while (!Intrinsics.areEqual(cls2, Object.class)) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                Intrinsics.checkExpressionValueIsNotNull(declaredField, "field");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    return null;
                }
                return cls.cast(obj2);
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
                Intrinsics.checkExpressionValueIsNotNull(cls2, "c.superclass");
            }
        }
        if (!(!Intrinsics.areEqual(str, "delegate")) || (readFieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
            return null;
        }
        return (T) readFieldOrNull(readFieldOrNull, cls, str);
    }

    public static final <E> void addIfAbsent(List<E> list, E e) {
        Intrinsics.checkParameterIsNotNull(list, "$this$addIfAbsent");
        if (!list.contains(e)) {
            list.add(e);
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$assertThreadHoldsLock");
        if (assertionsEnabled && !Thread.holdsLock(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(obj);
            throw new AssertionError(sb.toString());
        }
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(obj);
            throw new AssertionError(sb.toString());
        }
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        Intrinsics.checkParameterIsNotNull(strArr, "$this$indexOf");
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }
}
