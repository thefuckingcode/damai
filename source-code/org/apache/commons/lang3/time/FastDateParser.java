package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.d80;
import tb.jl1;

/* compiled from: Taobao */
public class FastDateParser implements Serializable, DateParser {
    private static final Strategy ABBREVIATED_YEAR_STRATEGY = new NumberStrategy(1) {
        /* class org.apache.commons.lang3.time.FastDateParser.AnonymousClass2 */

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            return i < 100 ? fastDateParser.adjustYear(i) : i;
        }
    };
    private static final Strategy DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    private static final Strategy DAY_OF_WEEK_STRATEGY = new NumberStrategy(7) {
        /* class org.apache.commons.lang3.time.FastDateParser.AnonymousClass4 */

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            if (i != 7) {
                return 1 + i;
            }
            return 1;
        }
    };
    private static final Strategy DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    private static final Strategy HOUR12_STRATEGY = new NumberStrategy(10) {
        /* class org.apache.commons.lang3.time.FastDateParser.AnonymousClass6 */

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            if (i == 12) {
                return 0;
            }
            return i;
        }
    };
    private static final Strategy HOUR24_OF_DAY_STRATEGY = new NumberStrategy(11) {
        /* class org.apache.commons.lang3.time.FastDateParser.AnonymousClass5 */

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            if (i == 24) {
                return 0;
            }
            return i;
        }
    };
    private static final Strategy HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    private static final Strategy HOUR_STRATEGY = new NumberStrategy(10);
    static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
    private static final Strategy LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    private static final Comparator<String> LONGER_FIRST_LOWERCASE = new Comparator<String>() {
        /* class org.apache.commons.lang3.time.FastDateParser.AnonymousClass1 */

        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    };
    private static final Strategy MILLISECOND_STRATEGY = new NumberStrategy(14);
    private static final Strategy MINUTE_STRATEGY = new NumberStrategy(12);
    private static final Strategy NUMBER_MONTH_STRATEGY = new NumberStrategy(2) {
        /* class org.apache.commons.lang3.time.FastDateParser.AnonymousClass3 */

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.NumberStrategy
        public int modify(FastDateParser fastDateParser, int i) {
            return i - 1;
        }
    };
    private static final Strategy SECOND_STRATEGY = new NumberStrategy(13);
    private static final Strategy WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    private static final Strategy WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    private static final ConcurrentMap<Locale, Strategy>[] caches = new ConcurrentMap[17];
    private static final long serialVersionUID = 3;
    private final int century;
    private final Locale locale;
    private final String pattern;
    private transient List<StrategyAndWidth> patterns;
    private final int startYear;
    private final TimeZone timeZone;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class CaseInsensitiveTextStrategy extends PatternStrategy {
        private final int field;
        private final Map<String, Integer> lKeyValues;
        final Locale locale;

        CaseInsensitiveTextStrategy(int i, Calendar calendar, Locale locale2) {
            super();
            this.field = i;
            this.locale = locale2;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)");
            this.lKeyValues = FastDateParser.appendDisplayNames(calendar, locale2, i, sb);
            sb.setLength(sb.length() - 1);
            sb.append(jl1.BRACKET_END_STR);
            createPattern(sb);
        }

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.set(this.field, this.lKeyValues.get(str.toLowerCase(this.locale)).intValue());
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class CopyQuotedStrategy extends Strategy {
        private final String formatField;

        CopyQuotedStrategy(String str) {
            super();
            this.formatField = str;
        }

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            for (int i2 = 0; i2 < this.formatField.length(); i2++) {
                int index = parsePosition.getIndex() + i2;
                if (index == str.length()) {
                    parsePosition.setErrorIndex(index);
                    return false;
                } else if (this.formatField.charAt(i2) != str.charAt(index)) {
                    parsePosition.setErrorIndex(index);
                    return false;
                }
            }
            parsePosition.setIndex(this.formatField.length() + parsePosition.getIndex());
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class ISO8601TimeZoneStrategy extends PatternStrategy {
        private static final Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
        private static final Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
        private static final Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");

        ISO8601TimeZoneStrategy(String str) {
            super();
            createPattern(str);
        }

        static Strategy getStrategy(int i) {
            if (i == 1) {
                return ISO_8601_1_STRATEGY;
            }
            if (i == 2) {
                return ISO_8601_2_STRATEGY;
            }
            if (i == 3) {
                return ISO_8601_3_STRATEGY;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            calendar.setTimeZone(FastTimeZone.getGmtTimeZone(str));
        }
    }

    /* compiled from: Taobao */
    private static class NumberStrategy extends Strategy {
        private final int field;

        NumberStrategy(int i) {
            super();
            this.field = i;
        }

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public int modify(FastDateParser fastDateParser, int i) {
            return i;
        }

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            int index = parsePosition.getIndex();
            int length = str.length();
            if (i == 0) {
                while (index < length && Character.isWhitespace(str.charAt(index))) {
                    index++;
                }
                parsePosition.setIndex(index);
            } else {
                int i2 = i + index;
                if (length > i2) {
                    length = i2;
                }
            }
            while (index < length && Character.isDigit(str.charAt(index))) {
                index++;
            }
            if (parsePosition.getIndex() == index) {
                parsePosition.setErrorIndex(index);
                return false;
            }
            int parseInt = Integer.parseInt(str.substring(parsePosition.getIndex(), index));
            parsePosition.setIndex(index);
            calendar.set(this.field, modify(fastDateParser, parseInt));
            return true;
        }
    }

    /* compiled from: Taobao */
    private static abstract class PatternStrategy extends Strategy {
        private Pattern pattern;

        private PatternStrategy() {
            super();
        }

        /* access modifiers changed from: package-private */
        public void createPattern(StringBuilder sb) {
            createPattern(sb.toString());
        }

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean isNumber() {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.Strategy
        public boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i) {
            Matcher matcher = this.pattern.matcher(str.substring(parsePosition.getIndex()));
            if (!matcher.lookingAt()) {
                parsePosition.setErrorIndex(parsePosition.getIndex());
                return false;
            }
            parsePosition.setIndex(parsePosition.getIndex() + matcher.end(1));
            setCalendar(fastDateParser, calendar, matcher.group(1));
            return true;
        }

        /* access modifiers changed from: package-private */
        public abstract void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str);

        /* access modifiers changed from: package-private */
        public void createPattern(String str) {
            this.pattern = Pattern.compile(str);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class Strategy {
        private Strategy() {
        }

        /* access modifiers changed from: package-private */
        public boolean isNumber() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean parse(FastDateParser fastDateParser, Calendar calendar, String str, ParsePosition parsePosition, int i);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class StrategyAndWidth {
        final Strategy strategy;
        final int width;

        StrategyAndWidth(Strategy strategy2, int i) {
            this.strategy = strategy2;
            this.width = i;
        }

        /* access modifiers changed from: package-private */
        public int getMaxWidth(ListIterator<StrategyAndWidth> listIterator) {
            if (!this.strategy.isNumber() || !listIterator.hasNext()) {
                return 0;
            }
            Strategy strategy2 = listIterator.next().strategy;
            listIterator.previous();
            if (strategy2.isNumber()) {
                return this.width;
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class StrategyParser {
        private int currentIdx;
        private final Calendar definingCalendar;

        StrategyParser(Calendar calendar) {
            this.definingCalendar = calendar;
        }

        private StrategyAndWidth letterPattern(char c) {
            int i = this.currentIdx;
            do {
                int i2 = this.currentIdx + 1;
                this.currentIdx = i2;
                if (i2 >= FastDateParser.this.pattern.length()) {
                    break;
                }
            } while (FastDateParser.this.pattern.charAt(this.currentIdx) == c);
            int i3 = this.currentIdx - i;
            return new StrategyAndWidth(FastDateParser.this.getStrategy(c, i3, this.definingCalendar), i3);
        }

        private StrategyAndWidth literal() {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            while (this.currentIdx < FastDateParser.this.pattern.length()) {
                char charAt = FastDateParser.this.pattern.charAt(this.currentIdx);
                if (!z && FastDateParser.isFormatLetter(charAt)) {
                    break;
                }
                if (charAt == '\'') {
                    int i = this.currentIdx + 1;
                    this.currentIdx = i;
                    if (i == FastDateParser.this.pattern.length() || FastDateParser.this.pattern.charAt(this.currentIdx) != '\'') {
                        z = !z;
                    }
                }
                this.currentIdx++;
                sb.append(charAt);
            }
            if (!z) {
                String sb2 = sb.toString();
                return new StrategyAndWidth(new CopyQuotedStrategy(sb2), sb2.length());
            }
            throw new IllegalArgumentException("Unterminated quote");
        }

        /* access modifiers changed from: package-private */
        public StrategyAndWidth getNextStrategy() {
            if (this.currentIdx >= FastDateParser.this.pattern.length()) {
                return null;
            }
            char charAt = FastDateParser.this.pattern.charAt(this.currentIdx);
            if (FastDateParser.isFormatLetter(charAt)) {
                return letterPattern(charAt);
            }
            return literal();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class TimeZoneStrategy extends PatternStrategy {
        private static final String GMT_OPTION = "GMT[+-]\\d{1,2}:\\d{2}";
        private static final int ID = 0;
        private static final String RFC_822_TIME_ZONE = "[+-]\\d{4}";
        private final Locale locale;
        private final Map<String, TzInfo> tzNames = new HashMap();

        /* compiled from: Taobao */
        private static class TzInfo {
            int dstOffset;
            TimeZone zone;

            TzInfo(TimeZone timeZone, boolean z) {
                this.zone = timeZone;
                this.dstOffset = z ? timeZone.getDSTSavings() : 0;
            }
        }

        TimeZoneStrategy(Locale locale2) {
            super();
            this.locale = locale2;
            StringBuilder sb = new StringBuilder();
            sb.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
            TreeSet<String> treeSet = new TreeSet(FastDateParser.LONGER_FIRST_LOWERCASE);
            String[][] zoneStrings = DateFormatSymbols.getInstance(locale2).getZoneStrings();
            for (String[] strArr : zoneStrings) {
                String str = strArr[0];
                if (!str.equalsIgnoreCase(TimeZones.GMT_ID)) {
                    TimeZone timeZone = TimeZone.getTimeZone(str);
                    TzInfo tzInfo = new TzInfo(timeZone, false);
                    TzInfo tzInfo2 = tzInfo;
                    for (int i = 1; i < strArr.length; i++) {
                        if (i == 3) {
                            tzInfo2 = new TzInfo(timeZone, true);
                        } else if (i == 5) {
                            tzInfo2 = tzInfo;
                        }
                        if (strArr[i] != null) {
                            String lowerCase = strArr[i].toLowerCase(locale2);
                            if (treeSet.add(lowerCase)) {
                                this.tzNames.put(lowerCase, tzInfo2);
                            }
                        }
                    }
                }
            }
            for (String str2 : treeSet) {
                sb.append('|');
                FastDateParser.simpleQuote(sb, str2);
            }
            sb.append(jl1.BRACKET_END_STR);
            createPattern(sb);
        }

        /* access modifiers changed from: package-private */
        @Override // org.apache.commons.lang3.time.FastDateParser.PatternStrategy
        public void setCalendar(FastDateParser fastDateParser, Calendar calendar, String str) {
            TimeZone gmtTimeZone = FastTimeZone.getGmtTimeZone(str);
            if (gmtTimeZone != null) {
                calendar.setTimeZone(gmtTimeZone);
                return;
            }
            TzInfo tzInfo = this.tzNames.get(str.toLowerCase(this.locale));
            calendar.set(16, tzInfo.dstOffset);
            calendar.set(15, tzInfo.zone.getRawOffset());
        }
    }

    protected FastDateParser(String str, TimeZone timeZone2, Locale locale2) {
        this(str, timeZone2, locale2, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int adjustYear(int i) {
        int i2 = this.century + i;
        return i >= this.startYear ? i2 : i2 + 100;
    }

    /* access modifiers changed from: private */
    public static Map<String, Integer> appendDisplayNames(Calendar calendar, Locale locale2, int i, StringBuilder sb) {
        HashMap hashMap = new HashMap();
        Map<String, Integer> displayNames = calendar.getDisplayNames(i, 0, locale2);
        TreeSet treeSet = new TreeSet(LONGER_FIRST_LOWERCASE);
        for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
            String lowerCase = entry.getKey().toLowerCase(locale2);
            if (treeSet.add(lowerCase)) {
                hashMap.put(lowerCase, entry.getValue());
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            simpleQuote(sb, (String) it.next()).append('|');
        }
        return hashMap;
    }

    private static ConcurrentMap<Locale, Strategy> getCache(int i) {
        ConcurrentMap<Locale, Strategy> concurrentMap;
        ConcurrentMap<Locale, Strategy>[] concurrentMapArr = caches;
        synchronized (concurrentMapArr) {
            if (concurrentMapArr[i] == null) {
                concurrentMapArr[i] = new ConcurrentHashMap(3);
            }
            concurrentMap = concurrentMapArr[i];
        }
        return concurrentMap;
    }

    private Strategy getLocaleSpecificStrategy(int i, Calendar calendar) {
        ConcurrentMap<Locale, Strategy> cache = getCache(i);
        Strategy strategy = cache.get(this.locale);
        if (strategy == null) {
            strategy = i == 15 ? new TimeZoneStrategy(this.locale) : new CaseInsensitiveTextStrategy(i, calendar, this.locale);
            Strategy putIfAbsent = cache.putIfAbsent(this.locale, strategy);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
        }
        return strategy;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Strategy getStrategy(char c, int i, Calendar calendar) {
        if (c != 'y') {
            if (c != 'z') {
                switch (c) {
                    case 'D':
                        return DAY_OF_YEAR_STRATEGY;
                    case 'E':
                        return getLocaleSpecificStrategy(7, calendar);
                    case 'F':
                        return DAY_OF_WEEK_IN_MONTH_STRATEGY;
                    case 'G':
                        return getLocaleSpecificStrategy(0, calendar);
                    case 'H':
                        return HOUR_OF_DAY_STRATEGY;
                    default:
                        switch (c) {
                            case 'K':
                                return HOUR_STRATEGY;
                            case 'M':
                                return i >= 3 ? getLocaleSpecificStrategy(2, calendar) : NUMBER_MONTH_STRATEGY;
                            case 'S':
                                return MILLISECOND_STRATEGY;
                            case 'a':
                                return getLocaleSpecificStrategy(9, calendar);
                            case 'd':
                                return DAY_OF_MONTH_STRATEGY;
                            case 'h':
                                return HOUR12_STRATEGY;
                            case 'k':
                                return HOUR24_OF_DAY_STRATEGY;
                            case 'm':
                                return MINUTE_STRATEGY;
                            case 's':
                                return SECOND_STRATEGY;
                            case 'u':
                                return DAY_OF_WEEK_STRATEGY;
                            case 'w':
                                return WEEK_OF_YEAR_STRATEGY;
                            default:
                                switch (c) {
                                    case 'W':
                                        return WEEK_OF_MONTH_STRATEGY;
                                    case 'X':
                                        return ISO8601TimeZoneStrategy.getStrategy(i);
                                    case 'Y':
                                        break;
                                    case 'Z':
                                        if (i == 2) {
                                            return ISO8601TimeZoneStrategy.ISO_8601_3_STRATEGY;
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Format '" + c + "' not supported");
                                }
                        }
                }
            }
            return getLocaleSpecificStrategy(15, calendar);
        }
        return i > 2 ? LITERAL_YEAR_STRATEGY : ABBREVIATED_YEAR_STRATEGY;
    }

    private void init(Calendar calendar) {
        this.patterns = new ArrayList();
        StrategyParser strategyParser = new StrategyParser(calendar);
        while (true) {
            StrategyAndWidth nextStrategy = strategyParser.getNextStrategy();
            if (nextStrategy != null) {
                this.patterns.add(nextStrategy);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean isFormatLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(Calendar.getInstance(this.timeZone, this.locale));
    }

    /* access modifiers changed from: private */
    public static StringBuilder simpleQuote(StringBuilder sb, String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == '$' || charAt == '.' || charAt == '?' || charAt == '^' || charAt == '[' || charAt == '\\' || charAt == '{' || charAt == '|')) {
                switch (charAt) {
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                        break;
                    default:
                        sb.append(charAt);
                }
            }
            sb.append(d80.TokenESC);
            sb.append(charAt);
        }
        return sb;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateParser)) {
            return false;
        }
        FastDateParser fastDateParser = (FastDateParser) obj;
        if (!this.pattern.equals(fastDateParser.pattern) || !this.timeZone.equals(fastDateParser.timeZone) || !this.locale.equals(fastDateParser.locale)) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Locale getLocale() {
        return this.locale;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public String getPattern() {
        return this.pattern;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return this.pattern.hashCode() + ((this.timeZone.hashCode() + (this.locale.hashCode() * 13)) * 13);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(str, parsePosition);
        if (parse != null) {
            return parse;
        }
        if (this.locale.equals(JAPANESE_IMPERIAL)) {
            throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\n" + "Unparseable date: \"" + str, parsePosition.getErrorIndex());
        }
        throw new ParseException("Unparseable date: " + str, parsePosition.getErrorIndex());
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str) throws ParseException {
        return parse(str);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + jl1.ARRAY_END_STR;
    }

    protected FastDateParser(String str, TimeZone timeZone2, Locale locale2, Date date) {
        int i;
        this.pattern = str;
        this.timeZone = timeZone2;
        this.locale = locale2;
        Calendar instance = Calendar.getInstance(timeZone2, locale2);
        if (date != null) {
            instance.setTime(date);
            i = instance.get(1);
        } else if (locale2.equals(JAPANESE_IMPERIAL)) {
            i = 0;
        } else {
            instance.setTime(new Date());
            i = instance.get(1) - 80;
        }
        int i2 = (i / 100) * 100;
        this.century = i2;
        this.startYear = i - i2;
        init(instance);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public Date parse(String str, ParsePosition parsePosition) {
        Calendar instance = Calendar.getInstance(this.timeZone, this.locale);
        instance.clear();
        if (parse(str, parsePosition, instance)) {
            return instance.getTime();
        }
        return null;
    }

    @Override // org.apache.commons.lang3.time.DateParser
    public boolean parse(String str, ParsePosition parsePosition, Calendar calendar) {
        ListIterator<StrategyAndWidth> listIterator = this.patterns.listIterator();
        while (listIterator.hasNext()) {
            StrategyAndWidth next = listIterator.next();
            if (!next.strategy.parse(this, calendar, str, parsePosition, next.getMaxWidth(listIterator))) {
                return false;
            }
        }
        return true;
    }
}
