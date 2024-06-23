package com.youku.skinmanager.download;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.realidentity.jsbridge.a;
import com.youku.analytics.AnalyticsAgent;
import com.youku.skinmanager.SkinManager;
import com.youku.skinmanager.entity.SkinDTO;
import com.youku.skinmanager.utils.FileUtils;
import com.youku.skinmanager.utils.Utils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: Taobao */
public class DownloadManager {
    public static final int DOWN_FAIL = 4;
    public static final int DOWN_START = 1;
    public static final int DOWN_SUCCESS = 3;
    public static final int DOWN_UPDATE = 2;
    private static final String SKIN_SAVE_COMMON_DIRECTORY_NAME = "common/";
    private static final String SKIN_SAVE_ZIP_FILE_NAME = "skin.zip";
    public static final String TAG = "DownloadManager_skin";
    public static final String URL_EXTRA = "url_extra";
    private static DownloadManager instance;
    private IDownloadListener mDownloadListener;
    private DownloadThread mDownloadThread;
    private String mFinalDownloadPath;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.youku.skinmanager.download.DownloadManager.AnonymousClass1 */

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                DownloadManager.this.mFinalDownloadPath = message.getData().getString(a.V);
                Log.d(DownloadManager.TAG, "get handler success msg, " + DownloadManager.this.mFinalDownloadPath);
                SkinManager.getInstance().loadSkin(DownloadManager.this.mSkinDto, DownloadManager.this.mFinalDownloadPath, null);
                if (DownloadManager.this.mSkinDto != null) {
                    if (DownloadManager.this.mDownloadListener != null) {
                        DownloadManager.this.mDownloadListener.onSuccess(DownloadManager.this.mSkinDto);
                    }
                    DownloadManager.this.sendData(1);
                }
                DownloadManager.this.clear();
            } else if (i == 4) {
                Log.d(DownloadManager.TAG, "get handler fail msg");
                if (DownloadManager.this.mSkinDto != null) {
                    if (DownloadManager.this.mDownloadListener != null) {
                        DownloadManager.this.mDownloadListener.onFail(DownloadManager.this.mSkinDto);
                    }
                    DownloadManager.this.sendData(0);
                }
                DownloadManager.this.clear();
            }
        }
    };
    private SkinDTO mSkinDto;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class DownloadThread extends Thread {
        boolean isCancel = false;
        private int progress;
        private String skinUrl;

        public DownloadThread(String str) {
            this.skinUrl = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x0240 A[Catch:{ IOException -> 0x023c }] */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0245 A[Catch:{ IOException -> 0x023c }] */
        /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x01b2  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x01b7  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x01bc  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x01e9  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01ee  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01f3  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0220  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0228  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x022d  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x0238 A[SYNTHETIC, Splitter:B:99:0x0238] */
        private void download() {
            FileOutputStream fileOutputStream;
            InputStream inputStream;
            Throwable th;
            MalformedURLException e;
            IOException e2;
            Exception e3;
            BufferedOutputStream bufferedOutputStream;
            int read;
            Log.d(DownloadManager.TAG, "skin download thread start");
            File createZipFile = DownloadManager.this.createZipFile();
            if (createZipFile == null) {
                Log.d(DownloadManager.TAG, "skin file is null");
                return;
            }
            Log.d(DownloadManager.TAG, "service download file created" + createZipFile.getAbsolutePath());
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.skinUrl).openConnection();
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                long availableInternalMemorySize = Utils.getAvailableInternalMemorySize();
                if (((long) contentLength) > availableInternalMemorySize) {
                    Log.d(DownloadManager.TAG, "service download fail length = " + contentLength + " availableMemorySize is " + availableInternalMemorySize);
                    DownloadManager.this.mHandler.sendEmptyMessage(4);
                } else if (contentLength > 0) {
                    DownloadManager.this.mHandler.sendEmptyMessage(1);
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        fileOutputStream = new FileOutputStream(createZipFile);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        } catch (MalformedURLException e4) {
                            e = e4;
                            Log.d(DownloadManager.TAG, "service download fail MalformedURLException" + e.getMessage());
                            e.printStackTrace();
                            DownloadManager.this.mHandler.sendEmptyMessage(4);
                            if (bufferedOutputStream2 != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (inputStream == null) {
                            }
                        } catch (IOException e5) {
                            e2 = e5;
                            Log.d(DownloadManager.TAG, "service download fail IOException" + e2.getMessage());
                            e2.printStackTrace();
                            DownloadManager.this.mHandler.sendEmptyMessage(4);
                            if (bufferedOutputStream2 != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (inputStream == null) {
                            }
                        } catch (Exception e6) {
                            e3 = e6;
                            try {
                                Log.d(DownloadManager.TAG, "service download fail Exception" + e3.getMessage());
                                e3.printStackTrace();
                                DownloadManager.this.mHandler.sendEmptyMessage(4);
                                if (bufferedOutputStream2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (inputStream == null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedOutputStream2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (MalformedURLException e7) {
                        e = e7;
                        fileOutputStream = null;
                        Log.d(DownloadManager.TAG, "service download fail MalformedURLException" + e.getMessage());
                        e.printStackTrace();
                        DownloadManager.this.mHandler.sendEmptyMessage(4);
                        if (bufferedOutputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (inputStream == null) {
                        }
                    } catch (IOException e8) {
                        e2 = e8;
                        fileOutputStream = null;
                        Log.d(DownloadManager.TAG, "service download fail IOException" + e2.getMessage());
                        e2.printStackTrace();
                        DownloadManager.this.mHandler.sendEmptyMessage(4);
                        if (bufferedOutputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (inputStream == null) {
                        }
                    } catch (Exception e9) {
                        e3 = e9;
                        fileOutputStream = null;
                        Log.d(DownloadManager.TAG, "service download fail Exception" + e3.getMessage());
                        e3.printStackTrace();
                        DownloadManager.this.mHandler.sendEmptyMessage(4);
                        if (bufferedOutputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (inputStream == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        if (bufferedOutputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        int i = 0;
                        while (!this.isCancel && (read = inputStream.read(bArr)) != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                            i += read;
                            int i2 = (int) ((((float) i) / ((float) contentLength)) * 100.0f);
                            if (i2 > this.progress) {
                                this.progress = i2;
                                Log.d(DownloadManager.TAG, "service download loop update " + this.progress);
                            }
                        }
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (this.isCancel) {
                            Log.d(DownloadManager.TAG, "skin download cancel");
                            if (createZipFile.exists()) {
                                Log.d(DownloadManager.TAG, "skin download cancel delete file");
                                createZipFile.delete();
                            }
                        } else if (i >= contentLength) {
                            Log.d(DownloadManager.TAG, this.skinUrl);
                            String unZipFolder = FileUtils.unZipFolder(createZipFile.getAbsolutePath(), createZipFile.getParent());
                            if (!TextUtils.isEmpty(unZipFolder)) {
                                Bundle bundle = new Bundle();
                                bundle.putString(a.V, unZipFolder);
                                Message obtainMessage = DownloadManager.this.mHandler.obtainMessage();
                                obtainMessage.what = 3;
                                obtainMessage.setData(bundle);
                                DownloadManager.this.mHandler.sendMessage(obtainMessage);
                            } else {
                                DownloadManager.this.mHandler.sendEmptyMessage(4);
                            }
                        }
                        try {
                            bufferedOutputStream.close();
                            fileOutputStream.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    } catch (MalformedURLException e11) {
                        e = e11;
                        bufferedOutputStream2 = bufferedOutputStream;
                        Log.d(DownloadManager.TAG, "service download fail MalformedURLException" + e.getMessage());
                        e.printStackTrace();
                        DownloadManager.this.mHandler.sendEmptyMessage(4);
                        if (bufferedOutputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (inputStream == null) {
                        }
                    } catch (IOException e12) {
                        e2 = e12;
                        bufferedOutputStream2 = bufferedOutputStream;
                        Log.d(DownloadManager.TAG, "service download fail IOException" + e2.getMessage());
                        e2.printStackTrace();
                        DownloadManager.this.mHandler.sendEmptyMessage(4);
                        if (bufferedOutputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (inputStream == null) {
                        }
                    } catch (Exception e13) {
                        e3 = e13;
                        bufferedOutputStream2 = bufferedOutputStream;
                        Log.d(DownloadManager.TAG, "service download fail Exception" + e3.getMessage());
                        e3.printStackTrace();
                        DownloadManager.this.mHandler.sendEmptyMessage(4);
                        if (bufferedOutputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (inputStream == null) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream2 = bufferedOutputStream;
                        if (bufferedOutputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } else {
                    Log.d(DownloadManager.TAG, "service download fail length = " + contentLength);
                    DownloadManager.this.mHandler.sendEmptyMessage(4);
                }
            } catch (MalformedURLException e14) {
                e = e14;
                inputStream = null;
                fileOutputStream = null;
                Log.d(DownloadManager.TAG, "service download fail MalformedURLException" + e.getMessage());
                e.printStackTrace();
                DownloadManager.this.mHandler.sendEmptyMessage(4);
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            } catch (IOException e15) {
                e2 = e15;
                inputStream = null;
                fileOutputStream = null;
                Log.d(DownloadManager.TAG, "service download fail IOException" + e2.getMessage());
                e2.printStackTrace();
                DownloadManager.this.mHandler.sendEmptyMessage(4);
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            } catch (Exception e16) {
                e3 = e16;
                inputStream = null;
                fileOutputStream = null;
                Log.d(DownloadManager.TAG, "service download fail Exception" + e3.getMessage());
                e3.printStackTrace();
                DownloadManager.this.mHandler.sendEmptyMessage(4);
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                fileOutputStream = null;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                        throw th;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        }

        public void run() {
            download();
        }
    }

    private DownloadManager() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clear() {
        this.mDownloadThread = null;
        this.mSkinDto = null;
        this.mFinalDownloadPath = null;
        this.mDownloadListener = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private File createZipFile() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(getDirectory(SkinManager.sContext));
            sb.append(System.currentTimeMillis());
            String str = File.separator;
            sb.append(str);
            File file = new File(sb.toString());
            FileUtils.deleteFiles(file, (File) null);
            file.mkdirs();
            File file2 = new File(file.getAbsolutePath() + str + SKIN_SAVE_ZIP_FILE_NAME);
            file2.createNewFile();
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, TAG, e);
            return null;
        }
    }

    public static synchronized DownloadManager getInstance() {
        DownloadManager downloadManager;
        synchronized (DownloadManager.class) {
            if (instance == null) {
                instance = new DownloadManager();
            }
            downloadManager = instance;
        }
        return downloadManager;
    }

    private String getRealUrl(SkinDTO skinDTO) {
        return skinDTO.getAndroidNewUrl();
    }

    private boolean isDownLoading() {
        DownloadThread downloadThread = this.mDownloadThread;
        return downloadThread != null && downloadThread.isAlive();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendData(int i) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("state", "" + i);
        hashMap.put("skinID", this.mSkinDto.getId());
        AnalyticsAgent.utCustomEvent("page_skinshop", 19999, "skinstate", (String) null, (String) null, hashMap);
    }

    public String getCurrentSkinPath() {
        return this.mFinalDownloadPath;
    }

    public String getDirectory(Context context) {
        return context.getFilesDir() + "/skin/" + SKIN_SAVE_COMMON_DIRECTORY_NAME;
    }

    public SkinDTO getDownloadingDto(IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            this.mDownloadListener = iDownloadListener;
        }
        return this.mSkinDto;
    }

    public void startDownload(SkinDTO skinDTO, IDownloadListener iDownloadListener) {
        if (skinDTO == null) {
            Log.d(TAG, "dto is null");
            return;
        }
        String realUrl = getRealUrl(skinDTO);
        if (TextUtils.isEmpty(realUrl)) {
            Log.d(TAG, "url is empty");
            if (iDownloadListener != null) {
                iDownloadListener.onFail(skinDTO);
                return;
            }
            return;
        }
        if (iDownloadListener != null) {
            this.mDownloadListener = iDownloadListener;
        }
        if (isDownLoading()) {
            SkinDTO skinDTO2 = this.mSkinDto;
            if (skinDTO2 == null || !skinDTO2.getId().equalsIgnoreCase(skinDTO.getId())) {
                Log.d(TAG, "is downloading now, cancel");
                this.mDownloadThread.isCancel = true;
            } else {
                Log.d(TAG, "the same skin id, return");
                return;
            }
        }
        this.mSkinDto = skinDTO;
        DownloadThread downloadThread = new DownloadThread(realUrl);
        this.mDownloadThread = downloadThread;
        downloadThread.start();
        Log.d(TAG, "start download thread ---");
    }
}
