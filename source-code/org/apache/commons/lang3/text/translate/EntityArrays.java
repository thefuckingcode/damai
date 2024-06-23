package org.apache.commons.lang3.text.translate;

import com.youku.uplayer.AliMediaPlayer;
import java.lang.reflect.Array;
import org.apache.commons.lang3.StringUtils;
import tb.jl1;

@Deprecated
/* compiled from: Taobao */
public class EntityArrays {
    private static final String[][] APOS_ESCAPE;
    private static final String[][] APOS_UNESCAPE;
    private static final String[][] BASIC_ESCAPE;
    private static final String[][] BASIC_UNESCAPE;
    private static final String[][] HTML40_EXTENDED_ESCAPE;
    private static final String[][] HTML40_EXTENDED_UNESCAPE;
    private static final String[][] ISO8859_1_ESCAPE;
    private static final String[][] ISO8859_1_UNESCAPE;
    private static final String[][] JAVA_CTRL_CHARS_ESCAPE;
    private static final String[][] JAVA_CTRL_CHARS_UNESCAPE;

    static {
        String[][] strArr = {new String[]{" ", "&nbsp;"}, new String[]{"¡", "&iexcl;"}, new String[]{"¢", "&cent;"}, new String[]{"£", "&pound;"}, new String[]{"¤", "&curren;"}, new String[]{"¥", "&yen;"}, new String[]{"¦", "&brvbar;"}, new String[]{"§", "&sect;"}, new String[]{"¨", "&uml;"}, new String[]{"©", "&copy;"}, new String[]{"ª", "&ordf;"}, new String[]{"«", "&laquo;"}, new String[]{"¬", "&not;"}, new String[]{"­", "&shy;"}, new String[]{"®", "&reg;"}, new String[]{"¯", "&macr;"}, new String[]{"°", "&deg;"}, new String[]{"±", "&plusmn;"}, new String[]{"²", "&sup2;"}, new String[]{"³", "&sup3;"}, new String[]{"´", "&acute;"}, new String[]{"µ", "&micro;"}, new String[]{"¶", "&para;"}, new String[]{"·", "&middot;"}, new String[]{"¸", "&cedil;"}, new String[]{"¹", "&sup1;"}, new String[]{"º", "&ordm;"}, new String[]{"»", "&raquo;"}, new String[]{"¼", "&frac14;"}, new String[]{"½", "&frac12;"}, new String[]{"¾", "&frac34;"}, new String[]{"¿", "&iquest;"}, new String[]{"À", "&Agrave;"}, new String[]{"Á", "&Aacute;"}, new String[]{"Â", "&Acirc;"}, new String[]{"Ã", "&Atilde;"}, new String[]{"Ä", "&Auml;"}, new String[]{"Å", "&Aring;"}, new String[]{"Æ", "&AElig;"}, new String[]{"Ç", "&Ccedil;"}, new String[]{"È", "&Egrave;"}, new String[]{"É", "&Eacute;"}, new String[]{"Ê", "&Ecirc;"}, new String[]{"Ë", "&Euml;"}, new String[]{"Ì", "&Igrave;"}, new String[]{"Í", "&Iacute;"}, new String[]{"Î", "&Icirc;"}, new String[]{"Ï", "&Iuml;"}, new String[]{"Ð", "&ETH;"}, new String[]{"Ñ", "&Ntilde;"}, new String[]{"Ò", "&Ograve;"}, new String[]{"Ó", "&Oacute;"}, new String[]{"Ô", "&Ocirc;"}, new String[]{"Õ", "&Otilde;"}, new String[]{"Ö", "&Ouml;"}, new String[]{"×", "&times;"}, new String[]{"Ø", "&Oslash;"}, new String[]{"Ù", "&Ugrave;"}, new String[]{"Ú", "&Uacute;"}, new String[]{"Û", "&Ucirc;"}, new String[]{"Ü", "&Uuml;"}, new String[]{"Ý", "&Yacute;"}, new String[]{"Þ", "&THORN;"}, new String[]{"ß", "&szlig;"}, new String[]{"à", "&agrave;"}, new String[]{"á", "&aacute;"}, new String[]{"â", "&acirc;"}, new String[]{"ã", "&atilde;"}, new String[]{"ä", "&auml;"}, new String[]{"å", "&aring;"}, new String[]{"æ", "&aelig;"}, new String[]{"ç", "&ccedil;"}, new String[]{"è", "&egrave;"}, new String[]{"é", "&eacute;"}, new String[]{"ê", "&ecirc;"}, new String[]{"ë", "&euml;"}, new String[]{"ì", "&igrave;"}, new String[]{"í", "&iacute;"}, new String[]{"î", "&icirc;"}, new String[]{"ï", "&iuml;"}, new String[]{"ð", "&eth;"}, new String[]{"ñ", "&ntilde;"}, new String[]{"ò", "&ograve;"}, new String[]{"ó", "&oacute;"}, new String[]{"ô", "&ocirc;"}, new String[]{"õ", "&otilde;"}, new String[]{"ö", "&ouml;"}, new String[]{"÷", "&divide;"}, new String[]{"ø", "&oslash;"}, new String[]{"ù", "&ugrave;"}, new String[]{"ú", "&uacute;"}, new String[]{"û", "&ucirc;"}, new String[]{"ü", "&uuml;"}, new String[]{"ý", "&yacute;"}, new String[]{"þ", "&thorn;"}, new String[]{"ÿ", "&yuml;"}};
        ISO8859_1_ESCAPE = strArr;
        ISO8859_1_UNESCAPE = invert(strArr);
        String[][] strArr2 = new String[AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR][];
        strArr2[0] = new String[]{"ƒ", "&fnof;"};
        strArr2[1] = new String[]{"Α", "&Alpha;"};
        strArr2[2] = new String[]{"Β", "&Beta;"};
        strArr2[3] = new String[]{"Γ", "&Gamma;"};
        strArr2[4] = new String[]{"Δ", "&Delta;"};
        strArr2[5] = new String[]{"Ε", "&Epsilon;"};
        strArr2[6] = new String[]{"Ζ", "&Zeta;"};
        strArr2[7] = new String[]{"Η", "&Eta;"};
        strArr2[8] = new String[]{"Θ", "&Theta;"};
        strArr2[9] = new String[]{"Ι", "&Iota;"};
        strArr2[10] = new String[]{"Κ", "&Kappa;"};
        strArr2[11] = new String[]{"Λ", "&Lambda;"};
        strArr2[12] = new String[]{"Μ", "&Mu;"};
        strArr2[13] = new String[]{"Ν", "&Nu;"};
        strArr2[14] = new String[]{"Ξ", "&Xi;"};
        strArr2[15] = new String[]{"Ο", "&Omicron;"};
        strArr2[16] = new String[]{"Π", "&Pi;"};
        strArr2[17] = new String[]{"Ρ", "&Rho;"};
        strArr2[18] = new String[]{"Σ", "&Sigma;"};
        strArr2[19] = new String[]{"Τ", "&Tau;"};
        strArr2[20] = new String[]{"Υ", "&Upsilon;"};
        strArr2[21] = new String[]{"Φ", "&Phi;"};
        strArr2[22] = new String[]{"Χ", "&Chi;"};
        strArr2[23] = new String[]{"Ψ", "&Psi;"};
        strArr2[24] = new String[]{"Ω", "&Omega;"};
        strArr2[25] = new String[]{"α", "&alpha;"};
        strArr2[26] = new String[]{"β", "&beta;"};
        strArr2[27] = new String[]{"γ", "&gamma;"};
        strArr2[28] = new String[]{"δ", "&delta;"};
        strArr2[29] = new String[]{"ε", "&epsilon;"};
        strArr2[30] = new String[]{"ζ", "&zeta;"};
        strArr2[31] = new String[]{"η", "&eta;"};
        strArr2[32] = new String[]{"θ", "&theta;"};
        strArr2[33] = new String[]{"ι", "&iota;"};
        strArr2[34] = new String[]{"κ", "&kappa;"};
        strArr2[35] = new String[]{"λ", "&lambda;"};
        strArr2[36] = new String[]{"μ", "&mu;"};
        strArr2[37] = new String[]{"ν", "&nu;"};
        strArr2[38] = new String[]{"ξ", "&xi;"};
        strArr2[39] = new String[]{"ο", "&omicron;"};
        strArr2[40] = new String[]{"π", "&pi;"};
        strArr2[41] = new String[]{"ρ", "&rho;"};
        strArr2[42] = new String[]{"ς", "&sigmaf;"};
        strArr2[43] = new String[]{"σ", "&sigma;"};
        strArr2[44] = new String[]{"τ", "&tau;"};
        strArr2[45] = new String[]{"υ", "&upsilon;"};
        strArr2[46] = new String[]{"φ", "&phi;"};
        strArr2[47] = new String[]{"χ", "&chi;"};
        strArr2[48] = new String[]{"ψ", "&psi;"};
        strArr2[49] = new String[]{"ω", "&omega;"};
        strArr2[50] = new String[]{"ϑ", "&thetasym;"};
        strArr2[51] = new String[]{"ϒ", "&upsih;"};
        strArr2[52] = new String[]{"ϖ", "&piv;"};
        strArr2[53] = new String[]{"•", "&bull;"};
        strArr2[54] = new String[]{"…", "&hellip;"};
        strArr2[55] = new String[]{"′", "&prime;"};
        strArr2[56] = new String[]{"″", "&Prime;"};
        strArr2[57] = new String[]{"‾", "&oline;"};
        strArr2[58] = new String[]{"⁄", "&frasl;"};
        strArr2[59] = new String[]{"℘", "&weierp;"};
        strArr2[60] = new String[]{"ℑ", "&image;"};
        strArr2[61] = new String[]{"ℜ", "&real;"};
        strArr2[62] = new String[]{"™", "&trade;"};
        strArr2[63] = new String[]{"ℵ", "&alefsym;"};
        strArr2[64] = new String[]{"←", "&larr;"};
        strArr2[65] = new String[]{"↑", "&uarr;"};
        strArr2[66] = new String[]{"→", "&rarr;"};
        strArr2[67] = new String[]{"↓", "&darr;"};
        strArr2[68] = new String[]{"↔", "&harr;"};
        strArr2[69] = new String[]{"↵", "&crarr;"};
        strArr2[70] = new String[]{"⇐", "&lArr;"};
        strArr2[71] = new String[]{"⇑", "&uArr;"};
        strArr2[72] = new String[]{"⇒", "&rArr;"};
        strArr2[73] = new String[]{"⇓", "&dArr;"};
        strArr2[74] = new String[]{"⇔", "&hArr;"};
        strArr2[75] = new String[]{"∀", "&forall;"};
        strArr2[76] = new String[]{"∂", "&part;"};
        strArr2[77] = new String[]{"∃", "&exist;"};
        strArr2[78] = new String[]{"∅", "&empty;"};
        strArr2[79] = new String[]{"∇", "&nabla;"};
        strArr2[80] = new String[]{"∈", "&isin;"};
        strArr2[81] = new String[]{"∉", "&notin;"};
        strArr2[82] = new String[]{"∋", "&ni;"};
        strArr2[83] = new String[]{"∏", "&prod;"};
        strArr2[84] = new String[]{"∑", "&sum;"};
        strArr2[85] = new String[]{"−", "&minus;"};
        strArr2[86] = new String[]{"∗", "&lowast;"};
        strArr2[87] = new String[]{"√", "&radic;"};
        strArr2[88] = new String[]{"∝", "&prop;"};
        strArr2[89] = new String[]{"∞", "&infin;"};
        strArr2[90] = new String[]{"∠", "&ang;"};
        strArr2[91] = new String[]{"∧", "&and;"};
        strArr2[92] = new String[]{"∨", "&or;"};
        strArr2[93] = new String[]{"∩", "&cap;"};
        strArr2[94] = new String[]{"∪", "&cup;"};
        strArr2[95] = new String[]{"∫", "&int;"};
        strArr2[96] = new String[]{"∴", "&there4;"};
        strArr2[97] = new String[]{"∼", "&sim;"};
        strArr2[98] = new String[]{"≅", "&cong;"};
        strArr2[99] = new String[]{"≈", "&asymp;"};
        strArr2[100] = new String[]{"≠", "&ne;"};
        strArr2[101] = new String[]{"≡", "&equiv;"};
        strArr2[102] = new String[]{"≤", "&le;"};
        strArr2[103] = new String[]{"≥", "&ge;"};
        strArr2[104] = new String[]{"⊂", "&sub;"};
        strArr2[105] = new String[]{"⊃", "&sup;"};
        strArr2[106] = new String[]{"⊄", "&nsub;"};
        strArr2[107] = new String[]{"⊆", "&sube;"};
        strArr2[108] = new String[]{"⊇", "&supe;"};
        strArr2[109] = new String[]{"⊕", "&oplus;"};
        strArr2[110] = new String[]{"⊗", "&otimes;"};
        strArr2[111] = new String[]{"⊥", "&perp;"};
        strArr2[112] = new String[]{"⋅", "&sdot;"};
        strArr2[113] = new String[]{"⌈", "&lceil;"};
        strArr2[114] = new String[]{"⌉", "&rceil;"};
        strArr2[115] = new String[]{"⌊", "&lfloor;"};
        strArr2[116] = new String[]{"⌋", "&rfloor;"};
        strArr2[117] = new String[]{"〈", "&lang;"};
        strArr2[118] = new String[]{"〉", "&rang;"};
        strArr2[119] = new String[]{"◊", "&loz;"};
        strArr2[120] = new String[]{"♠", "&spades;"};
        strArr2[121] = new String[]{"♣", "&clubs;"};
        strArr2[122] = new String[]{"♥", "&hearts;"};
        strArr2[123] = new String[]{"♦", "&diams;"};
        strArr2[124] = new String[]{"Œ", "&OElig;"};
        strArr2[125] = new String[]{"œ", "&oelig;"};
        strArr2[126] = new String[]{"Š", "&Scaron;"};
        strArr2[127] = new String[]{"š", "&scaron;"};
        strArr2[128] = new String[]{"Ÿ", "&Yuml;"};
        strArr2[129] = new String[]{"ˆ", "&circ;"};
        strArr2[130] = new String[]{"˜", "&tilde;"};
        strArr2[131] = new String[]{" ", "&ensp;"};
        strArr2[132] = new String[]{" ", "&emsp;"};
        strArr2[133] = new String[]{" ", "&thinsp;"};
        strArr2[134] = new String[]{"‌", "&zwnj;"};
        strArr2[135] = new String[]{"‍", "&zwj;"};
        strArr2[136] = new String[]{"‎", "&lrm;"};
        strArr2[137] = new String[]{"‏", "&rlm;"};
        strArr2[138] = new String[]{"–", "&ndash;"};
        strArr2[139] = new String[]{"—", "&mdash;"};
        strArr2[140] = new String[]{"‘", "&lsquo;"};
        strArr2[141] = new String[]{"’", "&rsquo;"};
        strArr2[142] = new String[]{"‚", "&sbquo;"};
        strArr2[143] = new String[]{"“", "&ldquo;"};
        strArr2[144] = new String[]{"”", "&rdquo;"};
        strArr2[145] = new String[]{"„", "&bdquo;"};
        strArr2[146] = new String[]{"†", "&dagger;"};
        strArr2[147] = new String[]{"‡", "&Dagger;"};
        strArr2[148] = new String[]{"‰", "&permil;"};
        strArr2[149] = new String[]{"‹", "&lsaquo;"};
        strArr2[150] = new String[]{"›", "&rsaquo;"};
        strArr2[151] = new String[]{"€", "&euro;"};
        HTML40_EXTENDED_ESCAPE = strArr2;
        HTML40_EXTENDED_UNESCAPE = invert(strArr2);
        String[][] strArr3 = {new String[]{"\"", "&quot;"}, new String[]{"&", "&amp;"}, new String[]{jl1.L, "&lt;"}, new String[]{jl1.G, "&gt;"}};
        BASIC_ESCAPE = strArr3;
        BASIC_UNESCAPE = invert(strArr3);
        String[][] strArr4 = {new String[]{"'", "&apos;"}};
        APOS_ESCAPE = strArr4;
        APOS_UNESCAPE = invert(strArr4);
        String[][] strArr5 = {new String[]{"\b", "\\b"}, new String[]{StringUtils.LF, "\\n"}, new String[]{"\t", "\\t"}, new String[]{"\f", "\\f"}, new String[]{StringUtils.CR, "\\r"}};
        JAVA_CTRL_CHARS_ESCAPE = strArr5;
        JAVA_CTRL_CHARS_UNESCAPE = invert(strArr5);
    }

    public static String[][] APOS_ESCAPE() {
        return (String[][]) APOS_ESCAPE.clone();
    }

    public static String[][] APOS_UNESCAPE() {
        return (String[][]) APOS_UNESCAPE.clone();
    }

    public static String[][] BASIC_ESCAPE() {
        return (String[][]) BASIC_ESCAPE.clone();
    }

    public static String[][] BASIC_UNESCAPE() {
        return (String[][]) BASIC_UNESCAPE.clone();
    }

    public static String[][] HTML40_EXTENDED_ESCAPE() {
        return (String[][]) HTML40_EXTENDED_ESCAPE.clone();
    }

    public static String[][] HTML40_EXTENDED_UNESCAPE() {
        return (String[][]) HTML40_EXTENDED_UNESCAPE.clone();
    }

    public static String[][] ISO8859_1_ESCAPE() {
        return (String[][]) ISO8859_1_ESCAPE.clone();
    }

    public static String[][] ISO8859_1_UNESCAPE() {
        return (String[][]) ISO8859_1_UNESCAPE.clone();
    }

    public static String[][] JAVA_CTRL_CHARS_ESCAPE() {
        return (String[][]) JAVA_CTRL_CHARS_ESCAPE.clone();
    }

    public static String[][] JAVA_CTRL_CHARS_UNESCAPE() {
        return (String[][]) JAVA_CTRL_CHARS_UNESCAPE.clone();
    }

    public static String[][] invert(String[][] strArr) {
        int length = strArr.length;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = length;
        String[][] strArr2 = (String[][]) Array.newInstance(String.class, iArr);
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i][0] = strArr[i][1];
            strArr2[i][1] = strArr[i][0];
        }
        return strArr2;
    }
}
