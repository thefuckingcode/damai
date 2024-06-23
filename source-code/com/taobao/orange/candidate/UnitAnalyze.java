package com.taobao.orange.candidate;

import android.os.RemoteException;
import android.text.TextUtils;
import com.taobao.orange.aidl.OrangeCandidateCompareStub;
import com.taobao.orange.aidl.ParcelableCandidateCompare;
import com.taobao.orange.util.OLog;
import com.taobao.orange.util.OrangeUtils;
import com.youku.alixplayer.config.FeatureManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.jl1;

/* compiled from: Taobao */
public class UnitAnalyze {
    private static final Pattern BASE_FORMAT;
    private static final String CANDIDATE_HASH_BUCKET = "did_hash";
    private static final Map<String, OPERATOR> OPERATOR_SYMBOL_MAP = new HashMap();
    private static final String TAG = "UnitAnalyze";
    public String key;
    private OPERATOR opr;
    private String val;

    /* access modifiers changed from: package-private */
    /* renamed from: com.taobao.orange.candidate.UnitAnalyze$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[OPERATOR.values().length];
            $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR = iArr;
            iArr[OPERATOR.EQUALS.ordinal()] = 1;
            $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.NOT_EQUALS.ordinal()] = 2;
            $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.GREATER.ordinal()] = 3;
            $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.GREATER_EQUALS.ordinal()] = 4;
            $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.LESS.ordinal()] = 5;
            $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.LESS_EQUALS.ordinal()] = 6;
            $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.FUZZY.ordinal()] = 7;
            $SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[OPERATOR.NOT_FUZZY.ordinal()] = 8;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum OPERATOR {
        EQUALS("="),
        GREATER_EQUALS(jl1.GE),
        LESS_EQUALS(jl1.LE),
        GREATER(jl1.G),
        LESS(jl1.L),
        NOT_EQUALS(jl1.NOT_EQUAL2),
        FUZZY("~="),
        NOT_FUZZY("!~");
        
        private String symbol;

        private OPERATOR(String str) {
            this.symbol = str;
        }

        public String getSymbol() {
            return this.symbol;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        OPERATOR[] values = OPERATOR.values();
        for (OPERATOR operator : values) {
            OPERATOR_SYMBOL_MAP.put(operator.getSymbol(), operator);
            arrayList.add(operator.getSymbol());
        }
        BASE_FORMAT = Pattern.compile(String.format("^\\s*(\\w+)\\s*(%s)\\s*(.+)\\s*$", OrangeUtils.formatOperateSymbols(arrayList)));
    }

    private UnitAnalyze(String str) {
        Matcher matcher = BASE_FORMAT.matcher(str);
        if (matcher.find()) {
            this.key = matcher.group(1);
            this.opr = OPERATOR_SYMBOL_MAP.get(matcher.group(2));
            this.val = matcher.group(3);
            if (this.key.equals("did_hash") && this.opr != OPERATOR.EQUALS) {
                throw new IllegalArgumentException(String.format("invalid hash candidate:%s", str));
            }
            return;
        }
        throw new IllegalArgumentException(String.format("fail parse candidate:%s", str));
    }

    static UnitAnalyze complie(String str) {
        return new UnitAnalyze(str);
    }

    /* access modifiers changed from: package-private */
    public boolean match(String str, ParcelableCandidateCompare parcelableCandidateCompare) throws RemoteException {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "match no clientVal", "key", this.key);
            }
            return false;
        } else if (parcelableCandidateCompare == null) {
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "match no compare", "key", this.key);
            }
            return false;
        } else {
            if (OLog.isPrintLog(0)) {
                String str2 = null;
                if (parcelableCandidateCompare instanceof OrangeCandidateCompareStub) {
                    str2 = ((OrangeCandidateCompareStub) parcelableCandidateCompare).getName();
                }
                OLog.v(TAG, "match start", "key", this.key, "clientVal", str, FeatureManager.FEATURE_KEY_OPR, this.opr.getSymbol(), "serverVal", this.val, "compare", str2);
            }
            switch (AnonymousClass1.$SwitchMap$com$taobao$orange$candidate$UnitAnalyze$OPERATOR[this.opr.ordinal()]) {
                case 1:
                    z = parcelableCandidateCompare.equals(str, this.val);
                    break;
                case 2:
                    z = parcelableCandidateCompare.equalsNot(str, this.val);
                    break;
                case 3:
                    z = parcelableCandidateCompare.greater(str, this.val);
                    break;
                case 4:
                    z = parcelableCandidateCompare.greaterEquals(str, this.val);
                    break;
                case 5:
                    z = parcelableCandidateCompare.less(str, this.val);
                    break;
                case 6:
                    z = parcelableCandidateCompare.lessEquals(str, this.val);
                    break;
                case 7:
                    z = parcelableCandidateCompare.fuzzy(str, this.val);
                    break;
                case 8:
                    z = parcelableCandidateCompare.fuzzyNot(str, this.val);
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z && OLog.isPrintLog(1)) {
                OLog.d(TAG, "match fail", "key", this.key);
            }
            return z;
        }
    }

    public String toString() {
        return String.format("%s%s%s", this.key, this.opr.getSymbol(), this.val);
    }
}
