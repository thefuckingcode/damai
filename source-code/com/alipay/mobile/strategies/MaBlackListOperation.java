package com.alipay.mobile.strategies;

import android.text.TextUtils;
import com.alipay.ma.MaBuryRecord;
import com.alipay.ma.MaLogger;
import com.alipay.ma.strategies.MaInterceptOperation;
import com.alipay.ma.util.StringEncodeUtils;
import com.alipay.mobile.mascanengine.MaScanResult;
import com.alipay.mobile.mascanengine.MultiMaScanResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class MaBlackListOperation extends MaInterceptOperation {
    public static final String MA_STRING_BLACK_LISTS = "scan_black_list";
    public static final String MA_SYNC_BLACK_LISTS = "sync_black_list";
    public static final String SCAN_LAZY_RECOGNIZE_TIME = "scan_lazy_recognize_time";
    public static final String TAG = "MaBlackListOperation";
    private List<String> a = new ArrayList();
    private long b;
    private long c;
    public long firstScanBlackCodeTime = 0;
    public boolean hitBlackList;
    public String lastBlackCode = null;
    public boolean recentCandidate = false;

    public void addToBlackList(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = ";";
        }
        if (!TextUtils.isEmpty(str)) {
            MaLogger.d(TAG, "addToBlackList() : " + str);
            String[] split = str.split(str2);
            if (!(split == null || split.length == 0)) {
                for (String str3 : split) {
                    String trim = str3.toLowerCase().trim();
                    if (!TextUtils.isEmpty(trim) && !this.a.contains(trim)) {
                        this.a.add(trim);
                    }
                }
            }
        }
    }

    public boolean inBlackLists(String str) {
        List<String> list;
        boolean z = false;
        if (this.c < 0) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && (list = this.a) != null && !list.isEmpty()) {
            String lowerCase = str.toLowerCase();
            for (String str2 : this.a) {
                if (!lowerCase.startsWith(str2)) {
                    if (!lowerCase.startsWith("http://" + str2)) {
                        if (!lowerCase.startsWith("https://" + str2)) {
                        }
                    }
                }
                z = true;
            }
            if (z) {
                this.hitBlackList = true;
            }
        }
        return z;
    }

    public boolean isDelayEnd() {
        if (this.c <= 0) {
            return true;
        }
        if (this.b > 0 && System.currentTimeMillis() - this.b > this.c * 1000) {
            return true;
        }
        return false;
    }

    @Override // com.alipay.ma.strategies.MaInterceptOperation
    public boolean isIntercepted(byte[] bArr) {
        String str;
        List<String> list;
        boolean z = false;
        String stringEncode = StringEncodeUtils.getStringEncode(bArr, false);
        try {
            if (TextUtils.isEmpty(stringEncode)) {
                str = new String(bArr, "utf-8");
            } else {
                str = new String(bArr, stringEncode);
            }
        } catch (UnsupportedEncodingException e) {
            MaLogger.d(TAG, "UnsupportedEncodingException : " + e.getMessage());
            str = null;
        }
        if (!TextUtils.isEmpty(str) && (list = this.a) != null && !list.isEmpty()) {
            String lowerCase = str.toLowerCase();
            for (String str2 : this.a) {
                if (!lowerCase.startsWith(str2)) {
                    if (!lowerCase.startsWith("http://" + str2)) {
                        if (!lowerCase.startsWith("https://" + str2)) {
                        }
                    }
                }
                z = true;
            }
        }
        return z;
    }

    public MultiMaScanResult preOperateResults(MultiMaScanResult multiMaScanResult) {
        MaScanResult[] maScanResultArr;
        if (!(multiMaScanResult == null || (maScanResultArr = multiMaScanResult.maScanResults) == null || maScanResultArr.length == 0)) {
            ArrayList arrayList = new ArrayList();
            MaScanResult[] maScanResultArr2 = multiMaScanResult.maScanResults;
            for (MaScanResult maScanResult : maScanResultArr2) {
                if (maScanResult != null && !inBlackLists(maScanResult.text)) {
                    arrayList.add(maScanResult);
                }
            }
            if (multiMaScanResult.maScanResults.length >= 2 && arrayList.size() > 0 && arrayList.size() != multiMaScanResult.maScanResults.length) {
                MaBuryRecord.recordTwoCodeHasBlackList(((MaScanResult) arrayList.get(0)).text);
            }
            if (arrayList.isEmpty() && this.b == 0) {
                this.b = System.currentTimeMillis();
            }
            long j = -1;
            if (this.b > 0) {
                j = System.currentTimeMillis() - this.b;
            }
            long j2 = this.c;
            if (j2 <= 0 || j > j2 * 1000) {
                if (arrayList.isEmpty()) {
                    arrayList.add(multiMaScanResult.maScanResults[0]);
                }
                multiMaScanResult.maScanResults = (MaScanResult[]) arrayList.toArray(new MaScanResult[arrayList.size()]);
            } else if (!arrayList.isEmpty()) {
                multiMaScanResult.maScanResults = (MaScanResult[]) arrayList.toArray(new MaScanResult[arrayList.size()]);
                return multiMaScanResult;
            } else {
                multiMaScanResult.candidate = true;
                this.recentCandidate = true;
                if (this.firstScanBlackCodeTime <= 0) {
                    this.firstScanBlackCodeTime = System.currentTimeMillis();
                }
                this.lastBlackCode = multiMaScanResult.maScanResults[0].text;
                return multiMaScanResult;
            }
        }
        return multiMaScanResult;
    }

    public void setEnableFunction(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = 0;
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt > 0) {
                this.c = (long) parseInt;
                MaLogger.d(TAG, "enable frames delay: framesDelay is " + str);
            }
        } catch (Exception e) {
            MaLogger.e(TAG, e.getMessage());
            this.c = 0;
        }
    }
}
