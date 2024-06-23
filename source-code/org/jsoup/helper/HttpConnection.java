package org.jsoup.helper;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.lzy.okgo.model.HttpHeaders;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.text.Typography;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;

public class HttpConnection implements Connection {
    public static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";
    private static final int HTTP_TEMP_REDIR = 307;
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private Connection.Request req = new Request();
    private Connection.Response res = new Response();

    public static Connection connect(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(str);
        return httpConnection;
    }

    public static Connection connect(URL url) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(url);
        return httpConnection;
    }

    /* access modifiers changed from: private */
    public static String encodeUrl(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll(" ", "%20");
    }

    /* access modifiers changed from: private */
    public static String encodeMimeName(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\"", "%22");
    }

    private HttpConnection() {
    }

    @Override // org.jsoup.Connection
    public Connection url(URL url) {
        this.req.url(url);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection url(String str) {
        Validate.notEmpty(str, "Must supply a valid URL");
        try {
            this.req.url(new URL(encodeUrl(str)));
            return this;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Malformed URL: " + str, e);
        }
    }

    @Override // org.jsoup.Connection
    public Connection proxy(Proxy proxy) {
        this.req.proxy(proxy);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection proxy(String str, int i) {
        this.req.proxy(str, i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection userAgent(String str) {
        Validate.notNull(str, "User agent must not be null");
        this.req.header(HttpHeaders.HEAD_KEY_USER_AGENT, str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection timeout(int i) {
        this.req.timeout(i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection maxBodySize(int i) {
        this.req.maxBodySize(i);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection followRedirects(boolean z) {
        this.req.followRedirects(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection referrer(String str) {
        Validate.notNull(str, "Referrer must not be null");
        this.req.header("Referer", str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection method(Connection.Method method) {
        this.req.method(method);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection ignoreHttpErrors(boolean z) {
        this.req.ignoreHttpErrors(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection ignoreContentType(boolean z) {
        this.req.ignoreContentType(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection validateTLSCertificates(boolean z) {
        this.req.validateTLSCertificates(z);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2) {
        this.req.data(KeyVal.create(str, str2));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String str, String str2, InputStream inputStream) {
        this.req.data(KeyVal.create(str, str2, inputStream));
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(Map<String, String> map) {
        Validate.notNull(map, "Data map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.data(KeyVal.create(entry.getKey(), entry.getValue()));
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(String... strArr) {
        Validate.notNull(strArr, "Data key value pairs must not be null");
        Validate.isTrue(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        for (int i = 0; i < strArr.length; i += 2) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            Validate.notEmpty(str, "Data key must not be empty");
            Validate.notNull(str2, "Data value must not be null");
            this.req.data(KeyVal.create(str, str2));
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection data(Collection<Connection.KeyVal> collection) {
        Validate.notNull(collection, "Data collection must not be null");
        for (Connection.KeyVal keyVal : collection) {
            this.req.data(keyVal);
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.KeyVal data(String str) {
        Validate.notEmpty(str, "Data key must not be empty");
        for (Connection.KeyVal keyVal : request().data()) {
            if (keyVal.key().equals(str)) {
                return keyVal;
            }
        }
        return null;
    }

    @Override // org.jsoup.Connection
    public Connection requestBody(String str) {
        this.req.requestBody(str);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection header(String str, String str2) {
        this.req.header(str, str2);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection cookie(String str, String str2) {
        this.req.cookie(str, str2);
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection cookies(Map<String, String> map) {
        Validate.notNull(map, "Cookie map must not be null");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.req.cookie(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection parser(Parser parser) {
        this.req.parser(parser);
        return this;
    }

    @Override // org.jsoup.Connection
    public Document get() throws IOException {
        this.req.method(Connection.Method.GET);
        execute();
        return this.res.parse();
    }

    @Override // org.jsoup.Connection
    public Document post() throws IOException {
        this.req.method(Connection.Method.POST);
        execute();
        return this.res.parse();
    }

    @Override // org.jsoup.Connection
    public Connection.Response execute() throws IOException {
        Response execute = Response.execute(this.req);
        this.res = execute;
        return execute;
    }

    @Override // org.jsoup.Connection
    public Connection.Request request() {
        return this.req;
    }

    @Override // org.jsoup.Connection
    public Connection request(Connection.Request request) {
        this.req = request;
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection.Response response() {
        return this.res;
    }

    @Override // org.jsoup.Connection
    public Connection response(Connection.Response response) {
        this.res = response;
        return this;
    }

    @Override // org.jsoup.Connection
    public Connection postDataCharset(String str) {
        this.req.postDataCharset(str);
        return this;
    }

    /* access modifiers changed from: private */
    public static abstract class Base<T extends Connection.Base> implements Connection.Base<T> {
        Map<String, String> cookies;
        Map<String, String> headers;
        Connection.Method method;
        URL url;

        private Base() {
            this.headers = new LinkedHashMap();
            this.cookies = new LinkedHashMap();
        }

        @Override // org.jsoup.Connection.Base
        public URL url() {
            return this.url;
        }

        @Override // org.jsoup.Connection.Base
        public T url(URL url2) {
            Validate.notNull(url2, "URL must not be null");
            this.url = url2;
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public Connection.Method method() {
            return this.method;
        }

        @Override // org.jsoup.Connection.Base
        public T method(Connection.Method method2) {
            Validate.notNull(method2, "Method must not be null");
            this.method = method2;
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public String header(String str) {
            Validate.notNull(str, "Header name must not be null");
            return getHeaderCaseInsensitive(str);
        }

        @Override // org.jsoup.Connection.Base
        public T header(String str, String str2) {
            Validate.notEmpty(str, "Header name must not be empty");
            Validate.notNull(str2, "Header value must not be null");
            removeHeader(str);
            this.headers.put(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            return getHeaderCaseInsensitive(str) != null;
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasHeaderWithValue(String str, String str2) {
            return hasHeader(str) && header(str).equalsIgnoreCase(str2);
        }

        @Override // org.jsoup.Connection.Base
        public T removeHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            Map.Entry<String, String> scanHeaders = scanHeaders(str);
            if (scanHeaders != null) {
                this.headers.remove(scanHeaders.getKey());
            }
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, String> headers() {
            return this.headers;
        }

        private String getHeaderCaseInsensitive(String str) {
            Map.Entry<String, String> scanHeaders;
            Validate.notNull(str, "Header name must not be null");
            String str2 = this.headers.get(str);
            if (str2 == null) {
                str2 = this.headers.get(str.toLowerCase());
            }
            return (str2 != null || (scanHeaders = scanHeaders(str)) == null) ? str2 : scanHeaders.getValue();
        }

        private Map.Entry<String, String> scanHeaders(String str) {
            String lowerCase = str.toLowerCase();
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                if (entry.getKey().toLowerCase().equals(lowerCase)) {
                    return entry;
                }
            }
            return null;
        }

        @Override // org.jsoup.Connection.Base
        public String cookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.cookies.get(str);
        }

        @Override // org.jsoup.Connection.Base
        public T cookie(String str, String str2) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            Validate.notNull(str2, "Cookie value must not be null");
            this.cookies.put(str, str2);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public boolean hasCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.cookies.containsKey(str);
        }

        @Override // org.jsoup.Connection.Base
        public T removeCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            this.cookies.remove(str);
            return this;
        }

        @Override // org.jsoup.Connection.Base
        public Map<String, String> cookies() {
            return this.cookies;
        }
    }

    public static class Request extends Base<Connection.Request> implements Connection.Request {
        private String body;
        private Collection<Connection.KeyVal> data;
        private boolean followRedirects;
        private boolean ignoreContentType;
        private boolean ignoreHttpErrors;
        private int maxBodySizeBytes;
        private Parser parser;
        private boolean parserDefined;
        private String postDataCharset;
        private Proxy proxy;
        private int timeoutMilliseconds;
        private boolean validateTSLCertificates;

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        private Request() {
            super();
            this.body = null;
            this.ignoreHttpErrors = false;
            this.ignoreContentType = false;
            this.parserDefined = false;
            this.validateTSLCertificates = true;
            this.postDataCharset = "UTF-8";
            this.timeoutMilliseconds = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.maxBodySizeBytes = 1048576;
            this.followRedirects = true;
            this.data = new ArrayList();
            this.method = Connection.Method.GET;
            this.headers.put(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, "gzip");
            this.parser = Parser.htmlParser();
        }

        @Override // org.jsoup.Connection.Request
        public Proxy proxy() {
            return this.proxy;
        }

        @Override // org.jsoup.Connection.Request
        public Request proxy(Proxy proxy2) {
            this.proxy = proxy2;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Request proxy(String str, int i) {
            this.proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i));
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public int timeout() {
            return this.timeoutMilliseconds;
        }

        @Override // org.jsoup.Connection.Request
        public Request timeout(int i) {
            Validate.isTrue(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.timeoutMilliseconds = i;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public int maxBodySize() {
            return this.maxBodySizeBytes;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request maxBodySize(int i) {
            Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
            this.maxBodySizeBytes = i;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public boolean followRedirects() {
            return this.followRedirects;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public boolean ignoreHttpErrors() {
            return this.ignoreHttpErrors;
        }

        @Override // org.jsoup.Connection.Request
        public boolean validateTLSCertificates() {
            return this.validateTSLCertificates;
        }

        @Override // org.jsoup.Connection.Request
        public void validateTLSCertificates(boolean z) {
            this.validateTSLCertificates = z;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request ignoreHttpErrors(boolean z) {
            this.ignoreHttpErrors = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public boolean ignoreContentType() {
            return this.ignoreContentType;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request ignoreContentType(boolean z) {
            this.ignoreContentType = z;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Request data(Connection.KeyVal keyVal) {
            Validate.notNull(keyVal, "Key val must not be null");
            this.data.add(keyVal);
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Collection<Connection.KeyVal> data() {
            return this.data;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request requestBody(String str) {
            this.body = str;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public String requestBody() {
            return this.body;
        }

        @Override // org.jsoup.Connection.Request
        public Request parser(Parser parser2) {
            this.parser = parser2;
            this.parserDefined = true;
            return this;
        }

        @Override // org.jsoup.Connection.Request
        public Parser parser() {
            return this.parser;
        }

        @Override // org.jsoup.Connection.Request
        public Connection.Request postDataCharset(String str) {
            Validate.notNull(str, "Charset must not be null");
            if (Charset.isSupported(str)) {
                this.postDataCharset = str;
                return this;
            }
            throw new IllegalCharsetNameException(str);
        }

        @Override // org.jsoup.Connection.Request
        public String postDataCharset() {
            return this.postDataCharset;
        }
    }

    public static class Response extends Base<Connection.Response> implements Connection.Response {
        private static final String LOCATION = "Location";
        private static final int MAX_REDIRECTS = 20;
        private static SSLSocketFactory sslSocketFactory;
        private static final Pattern xmlContentTypeRxp = Pattern.compile("(application|text)/\\w*\\+?xml.*");
        private ByteBuffer byteData;
        private String charset;
        private String contentType;
        private boolean executed = false;
        private int numRedirects = 0;
        private Connection.Request req;
        private int statusCode;
        private String statusMessage;

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        @Override // org.jsoup.helper.HttpConnection.Base, org.jsoup.Connection.Base
        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        Response() {
            super();
        }

        private Response(Response response) throws IOException {
            super();
            if (response != null) {
                int i = response.numRedirects + 1;
                this.numRedirects = i;
                if (i >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", response.url()));
                }
            }
        }

        static Response execute(Connection.Request request) throws IOException {
            return execute(request, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.lang.String */
        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: java.lang.String */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x007c A[Catch:{ all -> 0x01cf }] */
        static Response execute(Connection.Request request, Response response) throws IOException {
            String str;
            HttpURLConnection createConnection;
            int responseCode;
            Response response2;
            Validate.notNull(request, "Request must not be null");
            String protocol = request.url().getProtocol();
            if (protocol.equals("http") || protocol.equals("https")) {
                boolean hasBody = request.method().hasBody();
                boolean z = request.requestBody() != null;
                if (!hasBody) {
                    Validate.isFalse(z, "Cannot set a request body for HTTP method " + request.method());
                }
                InputStream inputStream = null;
                if (request.data().size() > 0 && (!hasBody || z)) {
                    serialiseRequestUrl(request);
                } else if (hasBody) {
                    str = setOutputContentType(request);
                    createConnection = createConnection(request);
                    createConnection.connect();
                    if (createConnection.getDoOutput()) {
                        writePost(request, createConnection.getOutputStream(), str);
                    }
                    responseCode = createConnection.getResponseCode();
                    response2 = new Response(response);
                    response2.setupFromConnection(createConnection, response);
                    response2.req = request;
                    if (!response2.hasHeader("Location") && request.followRedirects()) {
                        if (responseCode != 307) {
                            request.method(Connection.Method.GET);
                            request.data().clear();
                        }
                        String header = response2.header("Location");
                        if (!(header == null || !header.startsWith("http:/") || header.charAt(6) == '/')) {
                            header = header.substring(6);
                        }
                        request.url(StringUtil.resolve(request.url(), HttpConnection.encodeUrl(header)));
                        for (Map.Entry entry : response2.cookies.entrySet()) {
                            request.cookie((String) entry.getKey(), (String) entry.getValue());
                        }
                        return execute(request, response2);
                    } else if ((responseCode >= 200 || responseCode >= 400) && !request.ignoreHttpErrors()) {
                        throw new HttpStatusException("HTTP error fetching URL", responseCode, request.url().toString());
                    } else {
                        String contentType2 = response2.contentType();
                        if (contentType2 == null || request.ignoreContentType() || contentType2.startsWith("text/") || xmlContentTypeRxp.matcher(contentType2).matches()) {
                            if (contentType2 != null && xmlContentTypeRxp.matcher(contentType2).matches() && (request instanceof Request) && !((Request) request).parserDefined) {
                                request.parser(Parser.xmlParser());
                            }
                            response2.charset = DataUtil.getCharsetFromContentType(response2.contentType);
                            if (createConnection.getContentLength() == 0 || request.method() == Connection.Method.HEAD) {
                                response2.byteData = DataUtil.emptyByteBuffer();
                            } else {
                                try {
                                    InputStream errorStream = createConnection.getErrorStream() != null ? createConnection.getErrorStream() : createConnection.getInputStream();
                                    GZIPInputStream gZIPInputStream = errorStream;
                                    if (response2.hasHeaderWithValue("Content-Encoding", "gzip")) {
                                        gZIPInputStream = new GZIPInputStream(errorStream);
                                    }
                                    response2.byteData = DataUtil.readToByteBuffer(gZIPInputStream, request.maxBodySize());
                                } finally {
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                }
                            }
                            createConnection.disconnect();
                            response2.executed = true;
                            return response2;
                        }
                        throw new UnsupportedMimeTypeException("Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml", contentType2, request.url().toString());
                    }
                }
                str = inputStream;
                createConnection = createConnection(request);
                try {
                    createConnection.connect();
                    if (createConnection.getDoOutput()) {
                    }
                    responseCode = createConnection.getResponseCode();
                    response2 = new Response(response);
                    response2.setupFromConnection(createConnection, response);
                    response2.req = request;
                    if (!response2.hasHeader("Location")) {
                    }
                    if (responseCode >= 200) {
                    }
                    throw new HttpStatusException("HTTP error fetching URL", responseCode, request.url().toString());
                } finally {
                    createConnection.disconnect();
                }
            } else {
                throw new MalformedURLException("Only http & https protocols supported");
            }
        }

        @Override // org.jsoup.Connection.Response
        public int statusCode() {
            return this.statusCode;
        }

        @Override // org.jsoup.Connection.Response
        public String statusMessage() {
            return this.statusMessage;
        }

        @Override // org.jsoup.Connection.Response
        public String charset() {
            return this.charset;
        }

        @Override // org.jsoup.Connection.Response
        public String contentType() {
            return this.contentType;
        }

        @Override // org.jsoup.Connection.Response
        public Document parse() throws IOException {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            Document parseByteData = DataUtil.parseByteData(this.byteData, this.charset, this.url.toExternalForm(), this.req.parser());
            this.byteData.rewind();
            this.charset = parseByteData.outputSettings().charset().name();
            return parseByteData;
        }

        @Override // org.jsoup.Connection.Response
        public String body() {
            String str;
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            String str2 = this.charset;
            if (str2 == null) {
                str = Charset.forName("UTF-8").decode(this.byteData).toString();
            } else {
                str = Charset.forName(str2).decode(this.byteData).toString();
            }
            this.byteData.rewind();
            return str;
        }

        @Override // org.jsoup.Connection.Response
        public byte[] bodyAsBytes() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            return this.byteData.array();
        }

        private static HttpURLConnection createConnection(Connection.Request request) throws IOException {
            URLConnection uRLConnection;
            if (request.proxy() == null) {
                uRLConnection = request.url().openConnection();
            } else {
                uRLConnection = request.url().openConnection(request.proxy());
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setRequestMethod(request.method().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(request.timeout());
            httpURLConnection.setReadTimeout(request.timeout());
            if ((httpURLConnection instanceof HttpsURLConnection) && !request.validateTLSCertificates()) {
                initUnSecureTSL();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
                httpsURLConnection.setHostnameVerifier(getInsecureVerifier());
            }
            if (request.method().hasBody()) {
                httpURLConnection.setDoOutput(true);
            }
            if (request.cookies().size() > 0) {
                httpURLConnection.addRequestProperty(HttpHeaders.HEAD_KEY_COOKIE, getRequestCookieString(request));
            }
            for (Map.Entry<String, String> entry : request.headers().entrySet()) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
            return httpURLConnection;
        }

        private static HostnameVerifier getInsecureVerifier() {
            return new HostnameVerifier() {
                /* class org.jsoup.helper.HttpConnection.Response.AnonymousClass1 */

                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            };
        }

        private static synchronized void initUnSecureTSL() throws IOException {
            synchronized (Response.class) {
                if (sslSocketFactory == null) {
                    TrustManager[] trustManagerArr = {new X509TrustManager() {
                        /* class org.jsoup.helper.HttpConnection.Response.AnonymousClass2 */

                        @Override // javax.net.ssl.X509TrustManager
                        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                        }

                        @Override // javax.net.ssl.X509TrustManager
                        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                        }

                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                    }};
                    try {
                        SSLContext instance = SSLContext.getInstance("SSL");
                        instance.init(null, trustManagerArr, new SecureRandom());
                        sslSocketFactory = instance.getSocketFactory();
                    } catch (NoSuchAlgorithmException unused) {
                        throw new IOException("Can't create unsecure trust manager");
                    } catch (KeyManagementException unused2) {
                        throw new IOException("Can't create unsecure trust manager");
                    }
                }
            }
        }

        private void setupFromConnection(HttpURLConnection httpURLConnection, Connection.Response response) throws IOException {
            this.method = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.url = httpURLConnection.getURL();
            this.statusCode = httpURLConnection.getResponseCode();
            this.statusMessage = httpURLConnection.getResponseMessage();
            this.contentType = httpURLConnection.getContentType();
            processResponseHeaders(createHeaderMap(httpURLConnection));
            if (response != null) {
                for (Map.Entry<String, String> entry : response.cookies().entrySet()) {
                    if (!hasCookie(entry.getKey())) {
                        cookie(entry.getKey(), entry.getValue());
                    }
                }
            }
        }

        private static LinkedHashMap<String, List<String>> createHeaderMap(HttpURLConnection httpURLConnection) {
            LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();
            int i = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
                String headerField = httpURLConnection.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    return linkedHashMap;
                }
                i++;
                if (!(headerFieldKey == null || headerField == null)) {
                    if (linkedHashMap.containsKey(headerFieldKey)) {
                        linkedHashMap.get(headerFieldKey).add(headerField);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(headerField);
                        linkedHashMap.put(headerFieldKey, arrayList);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void processResponseHeaders(Map<String, List<String>> map) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    List<String> value = entry.getValue();
                    if (key.equalsIgnoreCase(HttpHeaders.HEAD_KEY_SET_COOKIE)) {
                        for (String str : value) {
                            if (str != null) {
                                TokenQueue tokenQueue = new TokenQueue(str);
                                String trim = tokenQueue.chompTo("=").trim();
                                String trim2 = tokenQueue.consumeTo(";").trim();
                                if (trim.length() > 0) {
                                    cookie(trim, trim2);
                                }
                            }
                        }
                    } else {
                        if (value.size() == 1) {
                            header(key, value.get(0));
                        } else if (value.size() > 1) {
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < value.size(); i++) {
                                String str2 = value.get(i);
                                if (i != 0) {
                                    sb.append(", ");
                                }
                                sb.append(str2);
                            }
                            header(key, sb.toString());
                        }
                    }
                }
            }
        }

        private static String setOutputContentType(Connection.Request request) {
            if (HttpConnection.needsMultipart(request)) {
                String mimeBoundary = DataUtil.mimeBoundary();
                request.header("Content-Type", "multipart/form-data; boundary=" + mimeBoundary);
                return mimeBoundary;
            }
            request.header("Content-Type", "application/x-www-form-urlencoded; charset=" + request.postDataCharset());
            return null;
        }

        private static void writePost(Connection.Request request, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.KeyVal> data = request.data();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, request.postDataCharset()));
            if (str != null) {
                for (Connection.KeyVal keyVal : data) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.key()));
                    bufferedWriter.write("\"");
                    if (keyVal.hasInputStream()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.encodeMimeName(keyVal.value()));
                        bufferedWriter.write("\"\r\nContent-Type: application/octet-stream\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.crossStreams(keyVal.inputStream(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(keyVal.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else if (request.requestBody() != null) {
                bufferedWriter.write(request.requestBody());
            } else {
                boolean z = true;
                for (Connection.KeyVal keyVal2 : data) {
                    if (!z) {
                        bufferedWriter.append(Typography.amp);
                    } else {
                        z = false;
                    }
                    bufferedWriter.write(URLEncoder.encode(keyVal2.key(), request.postDataCharset()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(keyVal2.value(), request.postDataCharset()));
                }
            }
            bufferedWriter.close();
        }

        private static String getRequestCookieString(Connection.Request request) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Map.Entry<String, String> entry : request.cookies().entrySet()) {
                if (!z) {
                    sb.append("; ");
                } else {
                    z = false;
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            return sb.toString();
        }

        private static void serialiseRequestUrl(Connection.Request request) throws IOException {
            boolean z;
            URL url = request.url();
            StringBuilder sb = new StringBuilder();
            sb.append(url.getProtocol());
            sb.append("://");
            sb.append(url.getAuthority());
            sb.append(url.getPath());
            sb.append("?");
            if (url.getQuery() != null) {
                sb.append(url.getQuery());
                z = false;
            } else {
                z = true;
            }
            for (Connection.KeyVal keyVal : request.data()) {
                Validate.isFalse(keyVal.hasInputStream(), "InputStream data not supported in URL query string.");
                if (!z) {
                    sb.append(Typography.amp);
                } else {
                    z = false;
                }
                sb.append(URLEncoder.encode(keyVal.key(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(keyVal.value(), "UTF-8"));
            }
            request.url(new URL(sb.toString()));
            request.data().clear();
        }
    }

    /* access modifiers changed from: private */
    public static boolean needsMultipart(Connection.Request request) {
        for (Connection.KeyVal keyVal : request.data()) {
            if (keyVal.hasInputStream()) {
                return true;
            }
        }
        return false;
    }

    public static class KeyVal implements Connection.KeyVal {
        private String key;
        private InputStream stream;
        private String value;

        public static KeyVal create(String str, String str2) {
            return new KeyVal().key(str).value(str2);
        }

        public static KeyVal create(String str, String str2, InputStream inputStream) {
            return new KeyVal().key(str).value(str2).inputStream(inputStream);
        }

        private KeyVal() {
        }

        @Override // org.jsoup.Connection.KeyVal
        public KeyVal key(String str) {
            Validate.notEmpty(str, "Data key must not be empty");
            this.key = str;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String key() {
            return this.key;
        }

        @Override // org.jsoup.Connection.KeyVal
        public KeyVal value(String str) {
            Validate.notNull(str, "Data value must not be null");
            this.value = str;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public String value() {
            return this.value;
        }

        @Override // org.jsoup.Connection.KeyVal
        public KeyVal inputStream(InputStream inputStream) {
            Validate.notNull(this.value, "Data input stream must not be null");
            this.stream = inputStream;
            return this;
        }

        @Override // org.jsoup.Connection.KeyVal
        public InputStream inputStream() {
            return this.stream;
        }

        @Override // org.jsoup.Connection.KeyVal
        public boolean hasInputStream() {
            return this.stream != null;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}
