package tb;

import android.util.Pair;
import com.taobao.android.dinamic.log.DinamicLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Taobao */
public class d80 {
    public static final int MAX_CONST_LEN = 255;
    public static final int MAX_MTHNAME_LEN = 255;
    public static final int MAX_VARNAME_LEN = 255;
    public static final char TokenCMA = ',';
    public static final char TokenDLR = '@';
    public static final char TokenESC = '\\';
    public static final char TokenLBR = '{';
    public static final char TokenLPR = '(';
    public static final char TokenRBR = '}';
    public static final char TokenRPR = ')';
    public static final char TokenSEM = ';';
    public static final char TokenSQ = '\'';
    public static boolean[][] a = {new boolean[]{false, true, false, false, false, false, true, false, false, false, false, false, false, false, true}, new boolean[]{false, false, true, false, false, false, false, false, false, false, false, false, false, false, true}, new boolean[]{false, false, true, true, false, false, false, false, false, false, false, false, false, false, true}, new boolean[]{false, true, false, false, true, false, true, false, false, false, false, true, false, false, true}, new boolean[]{false, false, false, false, true, true, false, false, false, true, false, false, false, false, true}, new boolean[]{false, false, false, false, false, true, false, false, false, true, true, false, true, true, true}, new boolean[]{false, false, false, false, false, false, false, true, true, false, false, false, false, false, true}, new boolean[]{false, false, false, false, false, false, false, true, true, false, false, false, false, false, true}, new boolean[]{false, false, false, false, false, true, false, false, false, true, true, false, false, true, true}, new boolean[]{false, true, false, false, true, false, true, false, false, false, false, true, false, false, true}, new boolean[]{false, true, false, false, false, false, true, false, false, false, false, false, false, false, true}, new boolean[]{false, true, false, false, false, false, true, false, false, false, false, false, false, false, true}, new boolean[]{false, false, false, false, false, true, false, false, false, true, false, false, false, true, true}, new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, true}};
    public static char[] b = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static char[] c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final int kNumTokens = 14;

    /* JADX WARNING: Removed duplicated region for block: B:124:0x0281 A[SYNTHETIC] */
    public Pair<List, List> a(String str) {
        int i;
        int i2;
        if (str == null || str.isEmpty()) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c2 = charArray[0];
        if (c2 != '@' && c2 != '\'') {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        Stack stack = new Stack();
        int i3 = 0;
        char c3 = 0;
        boolean z = false;
        boolean z2 = true;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length && c3 != 14) {
            if (z) {
                i = 1;
                z = false;
            } else {
                char c4 = charArray[i3];
                if (!z2 || c4 != ' ') {
                    i2 = 0;
                } else {
                    i2 = 0;
                    while (c4 == ' ') {
                        i3++;
                        if (i3 < length) {
                            i2++;
                            c4 = charArray[i3];
                        } else if (i3 >= length) {
                        }
                    }
                    if (i3 >= length) {
                    }
                }
                if (c4 != ',') {
                    if (c4 != ';') {
                        if (c4 != '@') {
                            if (c4 != '\\') {
                                if (c4 != '{') {
                                    if (c4 != '}') {
                                        switch (c4) {
                                            case '\'':
                                                boolean[][] zArr = a;
                                                if (!zArr[c3][6]) {
                                                    if (zArr[c3][8] && sb3.length() <= 255) {
                                                        arrayList.add(7);
                                                        arrayList2.add(sb3.toString());
                                                        StringBuilder sb4 = new StringBuilder();
                                                        DinamicLog.h("TokenizerState.kTokenizerStateConstName");
                                                        arrayList.add(8);
                                                        arrayList2.add(" ");
                                                        DinamicLog.h("TokenizerState.kTokenizerStateConstEnd");
                                                        sb3 = sb4;
                                                        i = 1;
                                                        c3 = '\b';
                                                        z2 = true;
                                                        break;
                                                    }
                                                } else {
                                                    arrayList.add(6);
                                                    arrayList2.add(" ");
                                                    DinamicLog.h("TokenizerState.kTokenizerStateConstBegin");
                                                    i = 1;
                                                    c3 = 6;
                                                    z2 = false;
                                                    break;
                                                }
                                            case '(':
                                                if (a[c3][11]) {
                                                    arrayList.add(11);
                                                    arrayList2.add(" ");
                                                    i4++;
                                                    stack.push(11);
                                                    i = 1;
                                                    c3 = 11;
                                                    break;
                                                }
                                                break;
                                            case ')':
                                                if (a[c3][12]) {
                                                    arrayList.add(12);
                                                    arrayList2.add(" ");
                                                    i4--;
                                                    stack.push(12);
                                                    i = 1;
                                                    c3 = '\f';
                                                    break;
                                                }
                                                break;
                                            default:
                                                boolean[][] zArr2 = a;
                                                if (zArr2[c3][2] && b[c4] != 0) {
                                                    if (i2 <= 0) {
                                                        sb.append(c4);
                                                        i = 1;
                                                        c3 = 2;
                                                        break;
                                                    }
                                                } else if (zArr2[c3][4] && c[c4] != 0) {
                                                    if (i2 <= 0) {
                                                        sb2.append(c4);
                                                        i = 1;
                                                        c3 = 4;
                                                        break;
                                                    }
                                                } else if (zArr2[c3][7]) {
                                                    sb3.append(c4);
                                                    i = 1;
                                                    c3 = 7;
                                                    break;
                                                }
                                                break;
                                        }
                                    } else if (a[c3][5]) {
                                        if (sb2.length() > 0) {
                                            if (sb2.length() <= 255) {
                                                arrayList.add(4);
                                                arrayList2.add(sb2.toString());
                                                sb2 = new StringBuilder();
                                                DinamicLog.h("TokenizerState.kTokenizerStateVarName");
                                            }
                                        }
                                        i5--;
                                        arrayList.add(5);
                                        arrayList2.add(" ");
                                        DinamicLog.h("TokenizerState.kTokenizerStateMethodBodyEnd");
                                        i = 1;
                                        c3 = 5;
                                    }
                                } else if (a[c3][3] && sb.length() > 0 && sb.length() <= 255) {
                                    arrayList.add(2);
                                    arrayList2.add(sb.toString());
                                    DinamicLog.h("TokenizerState.kTokenizerStateMethodName");
                                    StringBuilder sb5 = new StringBuilder();
                                    i5++;
                                    arrayList.add(3);
                                    arrayList2.add(" ");
                                    DinamicLog.h("TokenizerState.kTokenizerStateMethodBodyBegin");
                                    sb = sb5;
                                    i = 1;
                                    c3 = 3;
                                }
                            } else if (c3 == 7 || c3 == 6) {
                                i = 1;
                                z = true;
                            }
                        } else if (a[c3][1]) {
                            arrayList.add(1);
                            arrayList2.add(" ");
                            DinamicLog.h("TokenizerState.kTokenizerStateMethodBegin");
                            i = 1;
                            c3 = 1;
                        }
                    } else if (a[c3][10]) {
                        arrayList.add(10);
                        arrayList2.add(" ");
                        stack.push(10);
                        DinamicLog.h("TokenizerState.kTokenizerStateMethodSep");
                        i = 1;
                        c3 = '\n';
                    }
                } else if (a[c3][9]) {
                    if (sb2.length() > 0) {
                        if (sb2.length() <= 255) {
                            arrayList.add(4);
                            arrayList2.add(sb2.toString());
                            sb2 = new StringBuilder();
                            DinamicLog.h("TokenizerState.kTokenizerStateVarName");
                        }
                    }
                    arrayList.add(9);
                    arrayList2.add(" ");
                    i = 1;
                    c3 = '\t';
                }
                i = 1;
                c3 = 14;
            }
            i3 += i;
        }
        if (a[c3][13]) {
            c3 = CharUtils.CR;
        }
        if (i5 != 0 || i4 != 0) {
            return null;
        }
        int size = stack.size();
        if (size > 0 && (size & 1) == 0) {
            while (!stack.empty()) {
                if (((Integer) stack.pop()).intValue() != 10) {
                    return null;
                }
            }
        }
        if (c3 != 14) {
            return Pair.create(arrayList, arrayList2);
        }
        return null;
    }
}
