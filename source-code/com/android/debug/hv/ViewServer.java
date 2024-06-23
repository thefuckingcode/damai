package com.android.debug.hv;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.lang3.StringUtils;
import tb.jl1;

/* compiled from: Taobao */
public class ViewServer implements Runnable {
    private static final String BUILD_TYPE_USER = "user";
    private static final String COMMAND_PROTOCOL_VERSION = "PROTOCOL";
    private static final String COMMAND_SERVER_VERSION = "SERVER";
    private static final String COMMAND_WINDOW_MANAGER_AUTOLIST = "AUTOLIST";
    private static final String COMMAND_WINDOW_MANAGER_GET_FOCUS = "GET_FOCUS";
    private static final String COMMAND_WINDOW_MANAGER_LIST = "LIST";
    private static final String LOG_TAG = "ViewServer";
    private static final String VALUE_PROTOCOL_VERSION = "4";
    private static final String VALUE_SERVER_VERSION = "4";
    private static final int VIEW_SERVER_DEFAULT_PORT = 4939;
    private static final int VIEW_SERVER_MAX_CONNECTIONS = 10;
    private static ViewServer sServer;
    private final ReentrantReadWriteLock mFocusLock;
    private View mFocusedWindow;
    private final List<WindowListener> mListeners;
    private final int mPort;
    private ServerSocket mServer;
    private Thread mThread;
    private ExecutorService mThreadPool;
    private final HashMap<View, String> mWindows;
    private final ReentrantReadWriteLock mWindowsLock;

    /* compiled from: Taobao */
    private static class NoopViewServer extends ViewServer {
        @Override // com.android.debug.hv.ViewServer
        public void addWindow(Activity activity) {
        }

        @Override // com.android.debug.hv.ViewServer
        public void addWindow(View view, String str) {
        }

        @Override // com.android.debug.hv.ViewServer
        public boolean isRunning() {
            return false;
        }

        @Override // com.android.debug.hv.ViewServer
        public void removeWindow(Activity activity) {
        }

        @Override // com.android.debug.hv.ViewServer
        public void removeWindow(View view) {
        }

        @Override // com.android.debug.hv.ViewServer
        public void run() {
        }

        @Override // com.android.debug.hv.ViewServer
        public void setFocusedWindow(Activity activity) {
        }

        @Override // com.android.debug.hv.ViewServer
        public void setFocusedWindow(View view) {
        }

        @Override // com.android.debug.hv.ViewServer
        public boolean start() throws IOException {
            return false;
        }

        @Override // com.android.debug.hv.ViewServer
        public boolean stop() {
            return false;
        }

        private NoopViewServer() {
            super();
        }
    }

    /* compiled from: Taobao */
    private class ViewServerWorker implements WindowListener, Runnable {
        private Socket mClient;
        private final Object[] mLock = new Object[0];
        private boolean mNeedFocusedWindowUpdate;
        private boolean mNeedWindowListUpdate;

        public ViewServerWorker(Socket socket) {
            this.mClient = socket;
            this.mNeedWindowListUpdate = false;
            this.mNeedFocusedWindowUpdate = false;
        }

        private View findWindow(int i) {
            if (i == -1) {
                ViewServer.this.mWindowsLock.readLock().lock();
                try {
                    return ViewServer.this.mFocusedWindow;
                } finally {
                    ViewServer.this.mWindowsLock.readLock().unlock();
                }
            } else {
                ViewServer.this.mWindowsLock.readLock().lock();
                try {
                    for (Map.Entry entry : ViewServer.this.mWindows.entrySet()) {
                        if (System.identityHashCode(entry.getKey()) == i) {
                            return (View) entry.getKey();
                        }
                    }
                    ViewServer.this.mWindowsLock.readLock().unlock();
                    return null;
                } finally {
                    ViewServer.this.mWindowsLock.readLock().unlock();
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7 A[SYNTHETIC, Splitter:B:29:0x00a7] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        private boolean getFocusedWindow(Socket socket) {
            Throwable th;
            BufferedWriter bufferedWriter = null;
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 8192);
                try {
                    ViewServer.this.mFocusLock.readLock().lock();
                    try {
                        View view = ViewServer.this.mFocusedWindow;
                        if (view != null) {
                            ViewServer.this.mWindowsLock.readLock().lock();
                            try {
                                String str = (String) ViewServer.this.mWindows.get(ViewServer.this.mFocusedWindow);
                                ViewServer.this.mWindowsLock.readLock().unlock();
                                bufferedWriter2.write(Integer.toHexString(System.identityHashCode(view)));
                                bufferedWriter2.write(32);
                                bufferedWriter2.append((CharSequence) str);
                            } catch (Throwable th2) {
                                ViewServer.this.mWindowsLock.readLock().unlock();
                                throw th2;
                            }
                        }
                        bufferedWriter2.write(10);
                        bufferedWriter2.flush();
                        try {
                            bufferedWriter2.close();
                            return true;
                        } catch (IOException unused) {
                            return false;
                        }
                    } finally {
                        ViewServer.this.mFocusLock.readLock().unlock();
                    }
                } catch (Exception unused2) {
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                if (bufferedWriter != null) {
                    return false;
                }
                bufferedWriter.close();
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x008b A[SYNTHETIC, Splitter:B:20:0x008b] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        private boolean listWindows(Socket socket) {
            Throwable th;
            BufferedWriter bufferedWriter = null;
            try {
                ViewServer.this.mWindowsLock.readLock().lock();
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 8192);
                try {
                    for (Map.Entry entry : ViewServer.this.mWindows.entrySet()) {
                        bufferedWriter2.write(Integer.toHexString(System.identityHashCode(entry.getKey())));
                        bufferedWriter2.write(32);
                        bufferedWriter2.append((CharSequence) entry.getValue());
                        bufferedWriter2.write(10);
                    }
                    bufferedWriter2.write("DONE.\n");
                    bufferedWriter2.flush();
                    ViewServer.this.mWindowsLock.readLock().unlock();
                    try {
                        bufferedWriter2.close();
                        return true;
                    } catch (IOException unused) {
                        return false;
                    }
                } catch (Exception unused2) {
                    bufferedWriter = bufferedWriter2;
                    ViewServer.this.mWindowsLock.readLock().unlock();
                    if (bufferedWriter != null) {
                        return false;
                    }
                    bufferedWriter.close();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    ViewServer.this.mWindowsLock.readLock().unlock();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
                ViewServer.this.mWindowsLock.readLock().unlock();
                if (bufferedWriter != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                ViewServer.this.mWindowsLock.readLock().unlock();
                if (bufferedWriter != null) {
                }
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8 A[SYNTHETIC, Splitter:B:36:0x00b8] */
        private boolean windowCommand(Socket socket, String str, String str2) {
            Throwable th;
            Exception e;
            BufferedWriter bufferedWriter = null;
            try {
                int indexOf = str2.indexOf(32);
                if (indexOf == -1) {
                    indexOf = str2.length();
                }
                int parseLong = (int) Long.parseLong(str2.substring(0, indexOf), 16);
                str2 = indexOf < str2.length() ? str2.substring(indexOf + 1) : "";
                View findWindow = findWindow(parseLong);
                if (findWindow == null) {
                    return false;
                }
                Method declaredMethod = ViewDebug.class.getDeclaredMethod("dispatchCommand", View.class, String.class, String.class, OutputStream.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, findWindow, str, str2, new b(socket.getOutputStream()));
                if (!socket.isOutputShutdown()) {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    try {
                        bufferedWriter2.write("DONE\n");
                        bufferedWriter2.flush();
                        bufferedWriter = bufferedWriter2;
                    } catch (Exception e2) {
                        e = e2;
                        bufferedWriter = bufferedWriter2;
                        try {
                            Log.w(ViewServer.LOG_TAG, "Could not send command " + str + " with parameters " + str2, e);
                            if (bufferedWriter != null) {
                            }
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedWriter != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                }
                if (bufferedWriter == null) {
                    return true;
                }
                try {
                    bufferedWriter.close();
                    return true;
                } catch (IOException unused2) {
                }
            } catch (Exception e3) {
                e = e3;
                Log.w(ViewServer.LOG_TAG, "Could not send command " + str + " with parameters " + str2, e);
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                return false;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0065, code lost:
            if (r2 != null) goto L_0x0067;
         */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0074 A[SYNTHETIC, Splitter:B:45:0x0074] */
        private boolean windowManagerAutolistLoop() {
            Throwable th;
            BufferedWriter bufferedWriter;
            Exception e;
            boolean z;
            boolean z2;
            boolean z3;
            ViewServer.this.addWindowListener(this);
            BufferedWriter bufferedWriter2 = null;
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.mClient.getOutputStream()));
                while (!Thread.interrupted()) {
                    try {
                        synchronized (this.mLock) {
                            while (true) {
                                z = this.mNeedWindowListUpdate;
                                if (z || this.mNeedFocusedWindowUpdate) {
                                    z2 = false;
                                } else {
                                    this.mLock.wait();
                                }
                            }
                            z2 = false;
                            if (z) {
                                this.mNeedWindowListUpdate = false;
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (this.mNeedFocusedWindowUpdate) {
                                this.mNeedFocusedWindowUpdate = false;
                                z2 = true;
                            }
                        }
                        if (z3) {
                            bufferedWriter.write("LIST UPDATE\n");
                            bufferedWriter.flush();
                        }
                        if (z2) {
                            bufferedWriter.write("FOCUS UPDATE\n");
                            bufferedWriter.flush();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            Log.w(ViewServer.LOG_TAG, "Connection error: ", e);
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter2 = bufferedWriter;
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException unused) {
                                }
                            }
                            ViewServer.this.removeWindowListener(this);
                            throw th;
                        }
                    }
                }
            } catch (Exception e3) {
                bufferedWriter = null;
                e = e3;
                Log.w(ViewServer.LOG_TAG, "Connection error: ", e);
            } catch (Throwable th3) {
                th = th3;
                if (bufferedWriter2 != null) {
                }
                ViewServer.this.removeWindowListener(this);
                throw th;
            }
            try {
                bufferedWriter.close();
            } catch (IOException unused2) {
            }
            ViewServer.this.removeWindowListener(this);
            return true;
        }

        @Override // com.android.debug.hv.ViewServer.WindowListener
        public void focusChanged() {
            synchronized (this.mLock) {
                this.mNeedFocusedWindowUpdate = true;
                this.mLock.notifyAll();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce A[SYNTHETIC, Splitter:B:54:0x00ce] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00da  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x00e7 A[SYNTHETIC, Splitter:B:66:0x00e7] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x00f3 A[SYNTHETIC, Splitter:B:72:0x00f3] */
        /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
        public void run() {
            Throwable th;
            Socket socket;
            BufferedReader bufferedReader;
            IOException e;
            Socket socket2;
            String str;
            boolean z;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.mClient.getInputStream()), 1024);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        Socket socket3 = this.mClient;
                        if (socket3 != null) {
                            try {
                                socket3.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        int indexOf = readLine.indexOf(32);
                        if (indexOf == -1) {
                            str = "";
                        } else {
                            String substring = readLine.substring(0, indexOf);
                            str = readLine.substring(indexOf + 1);
                            readLine = substring;
                        }
                        if (ViewServer.COMMAND_PROTOCOL_VERSION.equalsIgnoreCase(readLine)) {
                            z = ViewServer.writeValue(this.mClient, "4");
                        } else if (ViewServer.COMMAND_SERVER_VERSION.equalsIgnoreCase(readLine)) {
                            z = ViewServer.writeValue(this.mClient, "4");
                        } else if (ViewServer.COMMAND_WINDOW_MANAGER_LIST.equalsIgnoreCase(readLine)) {
                            z = listWindows(this.mClient);
                        } else if (ViewServer.COMMAND_WINDOW_MANAGER_GET_FOCUS.equalsIgnoreCase(readLine)) {
                            z = getFocusedWindow(this.mClient);
                        } else if (ViewServer.COMMAND_WINDOW_MANAGER_AUTOLIST.equalsIgnoreCase(readLine)) {
                            z = windowManagerAutolistLoop();
                        } else {
                            z = windowCommand(this.mClient, readLine, str);
                        }
                        if (!z) {
                            Log.w(ViewServer.LOG_TAG, "An error occurred with the command: " + readLine);
                        }
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        Socket socket4 = this.mClient;
                        if (socket4 != null) {
                            try {
                                socket4.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                    try {
                        Log.w(ViewServer.LOG_TAG, "Connection error: ", e);
                        if (bufferedReader != null) {
                        }
                        socket2 = this.mClient;
                        if (socket2 == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        socket = this.mClient;
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e9) {
                bufferedReader = null;
                e = e9;
                Log.w(ViewServer.LOG_TAG, "Connection error: ", e);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                socket2 = this.mClient;
                if (socket2 == null) {
                    socket2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                }
                socket = this.mClient;
                if (socket != null) {
                }
                throw th;
            }
        }

        @Override // com.android.debug.hv.ViewServer.WindowListener
        public void windowsChanged() {
            synchronized (this.mLock) {
                this.mNeedWindowListUpdate = true;
                this.mLock.notifyAll();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface WindowListener {
        void focusChanged();

        void windowsChanged();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b extends OutputStream {
        private final OutputStream a;

        b(OutputStream outputStream) {
            this.a = outputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public boolean equals(Object obj) {
            return this.a.equals(obj);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.a.flush();
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a.toString();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.a.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.a.write(i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addWindowListener(WindowListener windowListener) {
        if (!this.mListeners.contains(windowListener)) {
            this.mListeners.add(windowListener);
        }
    }

    private void fireFocusChangedEvent() {
        for (WindowListener windowListener : this.mListeners) {
            windowListener.focusChanged();
        }
    }

    private void fireWindowsChangedEvent() {
        for (WindowListener windowListener : this.mListeners) {
            windowListener.windowsChanged();
        }
    }

    public static ViewServer get(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!BUILD_TYPE_USER.equals(Build.TYPE) || (applicationInfo.flags & 2) == 0) {
            sServer = new NoopViewServer();
        } else {
            if (sServer == null) {
                sServer = new ViewServer((int) VIEW_SERVER_DEFAULT_PORT);
            }
            if (!sServer.isRunning()) {
                try {
                    sServer.start();
                } catch (IOException e) {
                    Log.d(LOG_TAG, "Error:", e);
                }
            }
        }
        return sServer;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeWindowListener(WindowListener windowListener) {
        this.mListeners.remove(windowListener);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[SYNTHETIC, Splitter:B:15:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    public static boolean writeValue(Socket socket, String str) {
        Throwable th;
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 8192);
            try {
                bufferedWriter2.write(str);
                bufferedWriter2.write(StringUtils.LF);
                bufferedWriter2.flush();
                try {
                    bufferedWriter2.close();
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            } catch (Exception unused2) {
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            if (bufferedWriter != null) {
                return false;
            }
            bufferedWriter.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public void addWindow(Activity activity) {
        String str;
        String charSequence = activity.getTitle().toString();
        if (TextUtils.isEmpty(charSequence)) {
            str = activity.getClass().getCanonicalName() + "/0x" + System.identityHashCode(activity);
        } else {
            str = charSequence + jl1.BRACKET_START_STR + activity.getClass().getCanonicalName() + jl1.BRACKET_END_STR;
        }
        addWindow(activity.getWindow().getDecorView(), str);
    }

    public boolean isRunning() {
        Thread thread = this.mThread;
        return thread != null && thread.isAlive();
    }

    public void removeWindow(Activity activity) {
        removeWindow(activity.getWindow().getDecorView());
    }

    public void run() {
        try {
            this.mServer = new ServerSocket(this.mPort, 10, InetAddress.getLocalHost());
        } catch (Exception e) {
            Log.w(LOG_TAG, "Starting ServerSocket error: ", e);
        }
        while (this.mServer != null && Thread.currentThread() == this.mThread) {
            try {
                Socket accept = this.mServer.accept();
                ExecutorService executorService = this.mThreadPool;
                if (executorService != null) {
                    executorService.submit(new ViewServerWorker(accept));
                } else {
                    try {
                        accept.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                Log.w(LOG_TAG, "Connection error: ", e3);
            }
        }
    }

    public void setFocusedWindow(Activity activity) {
        setFocusedWindow(activity.getWindow().getDecorView());
    }

    public boolean start() throws IOException {
        if (this.mThread != null) {
            return false;
        }
        this.mThread = new Thread(this, "Local View Server [port=" + this.mPort + jl1.ARRAY_END_STR);
        this.mThreadPool = Executors.newFixedThreadPool(10);
        this.mThread.start();
        return true;
    }

    /* JADX INFO: finally extract failed */
    public boolean stop() {
        Thread thread = this.mThread;
        if (thread != null) {
            thread.interrupt();
            ExecutorService executorService = this.mThreadPool;
            if (executorService != null) {
                try {
                    executorService.shutdownNow();
                } catch (SecurityException unused) {
                    Log.w(LOG_TAG, "Could not stop all view server threads");
                }
            }
            this.mThreadPool = null;
            this.mThread = null;
            try {
                this.mServer.close();
                this.mServer = null;
                return true;
            } catch (IOException unused2) {
                Log.w(LOG_TAG, "Could not close the view server");
            }
        }
        this.mWindowsLock.writeLock().lock();
        try {
            this.mWindows.clear();
            this.mWindowsLock.writeLock().unlock();
            this.mFocusLock.writeLock().lock();
            try {
                this.mFocusedWindow = null;
                this.mFocusLock.writeLock().unlock();
                return false;
            } catch (Throwable th) {
                this.mFocusLock.writeLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.mWindowsLock.writeLock().unlock();
            throw th2;
        }
    }

    private ViewServer() {
        this.mListeners = new CopyOnWriteArrayList();
        this.mWindows = new HashMap<>();
        this.mWindowsLock = new ReentrantReadWriteLock();
        this.mFocusLock = new ReentrantReadWriteLock();
        this.mPort = -1;
    }

    /* JADX INFO: finally extract failed */
    public void removeWindow(View view) {
        this.mWindowsLock.writeLock().lock();
        try {
            View rootView = view.getRootView();
            this.mWindows.remove(rootView);
            this.mWindowsLock.writeLock().unlock();
            this.mFocusLock.writeLock().lock();
            try {
                if (this.mFocusedWindow == rootView) {
                    this.mFocusedWindow = null;
                }
                this.mFocusLock.writeLock().unlock();
                fireWindowsChangedEvent();
            } catch (Throwable th) {
                this.mFocusLock.writeLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.mWindowsLock.writeLock().unlock();
            throw th2;
        }
    }

    public void setFocusedWindow(View view) {
        View view2;
        this.mFocusLock.writeLock().lock();
        if (view == null) {
            view2 = null;
        } else {
            try {
                view2 = view.getRootView();
            } catch (Throwable th) {
                this.mFocusLock.writeLock().unlock();
                throw th;
            }
        }
        this.mFocusedWindow = view2;
        this.mFocusLock.writeLock().unlock();
        fireFocusChangedEvent();
    }

    /* JADX INFO: finally extract failed */
    public void addWindow(View view, String str) {
        this.mWindowsLock.writeLock().lock();
        try {
            this.mWindows.put(view.getRootView(), str);
            this.mWindowsLock.writeLock().unlock();
            fireWindowsChangedEvent();
        } catch (Throwable th) {
            this.mWindowsLock.writeLock().unlock();
            throw th;
        }
    }

    private ViewServer(int i) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mWindows = new HashMap<>();
        this.mWindowsLock = new ReentrantReadWriteLock();
        this.mFocusLock = new ReentrantReadWriteLock();
        this.mPort = i;
    }
}
