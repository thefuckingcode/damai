package org.apache.commons.codec.language.bm;

import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.codec.language.bm.Languages;
import org.apache.commons.codec.language.bm.Rule;
import tb.jl1;

/* compiled from: Taobao */
public class PhoneticEngine {
    private static final int DEFAULT_MAX_PHONEMES = 20;
    private static final Map<NameType, Set<String>> NAME_PREFIXES;
    private final boolean concat;
    private final Lang lang;
    private final int maxPhonemes;
    private final NameType nameType;
    private final RuleType ruleType;

    /* access modifiers changed from: package-private */
    /* renamed from: org.apache.commons.codec.language.bm.PhoneticEngine$1  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$codec$language$bm$NameType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[NameType.values().length];
            $SwitchMap$org$apache$commons$codec$language$bm$NameType = iArr;
            iArr[NameType.SEPHARDIC.ordinal()] = 1;
            $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.ASHKENAZI.ordinal()] = 2;
            try {
                $SwitchMap$org$apache$commons$codec$language$bm$NameType[NameType.GENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class PhonemeBuilder {
        private final Set<Rule.Phoneme> phonemes;

        /* synthetic */ PhonemeBuilder(Set set, AnonymousClass1 r2) {
            this(set);
        }

        public static PhonemeBuilder empty(Languages.LanguageSet languageSet) {
            return new PhonemeBuilder(new Rule.Phoneme("", languageSet));
        }

        public void append(CharSequence charSequence) {
            for (Rule.Phoneme phoneme : this.phonemes) {
                phoneme.append(charSequence);
            }
        }

        public void apply(Rule.PhonemeExpr phonemeExpr, int i) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(i);
            loop0:
            for (Rule.Phoneme phoneme : this.phonemes) {
                Iterator<Rule.Phoneme> it = phonemeExpr.getPhonemes().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Rule.Phoneme next = it.next();
                        Languages.LanguageSet restrictTo = phoneme.getLanguages().restrictTo(next.getLanguages());
                        if (!restrictTo.isEmpty()) {
                            Rule.Phoneme phoneme2 = new Rule.Phoneme(phoneme, next, restrictTo);
                            if (linkedHashSet.size() < i) {
                                linkedHashSet.add(phoneme2);
                                if (linkedHashSet.size() >= i) {
                                    break loop0;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
            this.phonemes.clear();
            this.phonemes.addAll(linkedHashSet);
        }

        public Set<Rule.Phoneme> getPhonemes() {
            return this.phonemes;
        }

        public String makeString() {
            StringBuilder sb = new StringBuilder();
            for (Rule.Phoneme phoneme : this.phonemes) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(phoneme.getPhonemeText());
            }
            return sb.toString();
        }

        private PhonemeBuilder(Rule.Phoneme phoneme) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.phonemes = linkedHashSet;
            linkedHashSet.add(phoneme);
        }

        private PhonemeBuilder(Set<Rule.Phoneme> set) {
            this.phonemes = set;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class RulesApplication {
        private final Map<String, List<Rule>> finalRules;
        private boolean found;
        private int i;
        private final CharSequence input;
        private final int maxPhonemes;
        private PhonemeBuilder phonemeBuilder;

        public RulesApplication(Map<String, List<Rule>> map, CharSequence charSequence, PhonemeBuilder phonemeBuilder2, int i2, int i3) {
            Objects.requireNonNull(map, "The finalRules argument must not be null");
            this.finalRules = map;
            this.phonemeBuilder = phonemeBuilder2;
            this.input = charSequence;
            this.i = i2;
            this.maxPhonemes = i3;
        }

        public int getI() {
            return this.i;
        }

        public PhonemeBuilder getPhonemeBuilder() {
            return this.phonemeBuilder;
        }

        public RulesApplication invoke() {
            int i2;
            this.found = false;
            Map<String, List<Rule>> map = this.finalRules;
            CharSequence charSequence = this.input;
            int i3 = this.i;
            List<Rule> list = map.get(charSequence.subSequence(i3, i3 + 1));
            int i4 = 1;
            if (list != null) {
                Iterator<Rule> it = list.iterator();
                i2 = 1;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Rule next = it.next();
                    int length = next.getPattern().length();
                    if (next.patternAndContextMatches(this.input, this.i)) {
                        this.phonemeBuilder.apply(next.getPhoneme(), this.maxPhonemes);
                        this.found = true;
                        i2 = length;
                        break;
                    }
                    i2 = length;
                }
            } else {
                i2 = 1;
            }
            if (this.found) {
                i4 = i2;
            }
            this.i += i4;
            return this;
        }

        public boolean isFound() {
            return this.found;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(NameType.class);
        NAME_PREFIXES = enumMap;
        enumMap.put((Object) NameType.ASHKENAZI, (Object) Collections.unmodifiableSet(new HashSet(Arrays.asList("bar", "ben", "da", "de", "van", "von"))));
        enumMap.put((Object) NameType.SEPHARDIC, (Object) Collections.unmodifiableSet(new HashSet(Arrays.asList("al", "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", AppIconSetting.DEFAULT_LARGE_ICON, "do", "dos", "du", "van", "von"))));
        enumMap.put((Object) NameType.GENERIC, (Object) Collections.unmodifiableSet(new HashSet(Arrays.asList("da", "dal", "de", "del", "dela", "de la", "della", "des", AppIconSetting.DEFAULT_LARGE_ICON, "do", "dos", "du", "van", "von"))));
    }

    public PhoneticEngine(NameType nameType2, RuleType ruleType2, boolean z) {
        this(nameType2, ruleType2, z, 20);
    }

    private PhonemeBuilder applyFinalRules(PhonemeBuilder phonemeBuilder, Map<String, List<Rule>> map) {
        Objects.requireNonNull(map, "finalRules can not be null");
        if (map.isEmpty()) {
            return phonemeBuilder;
        }
        TreeMap treeMap = new TreeMap(Rule.Phoneme.COMPARATOR);
        for (Rule.Phoneme phoneme : phonemeBuilder.getPhonemes()) {
            PhonemeBuilder empty = PhonemeBuilder.empty(phoneme.getLanguages());
            String charSequence = phoneme.getPhonemeText().toString();
            PhonemeBuilder phonemeBuilder2 = empty;
            int i = 0;
            while (i < charSequence.length()) {
                RulesApplication invoke = new RulesApplication(map, charSequence, phonemeBuilder2, i, this.maxPhonemes).invoke();
                boolean isFound = invoke.isFound();
                phonemeBuilder2 = invoke.getPhonemeBuilder();
                if (!isFound) {
                    phonemeBuilder2.append(charSequence.subSequence(i, i + 1));
                }
                i = invoke.getI();
            }
            for (Rule.Phoneme phoneme2 : phonemeBuilder2.getPhonemes()) {
                if (treeMap.containsKey(phoneme2)) {
                    Rule.Phoneme mergeWithLanguage = ((Rule.Phoneme) treeMap.remove(phoneme2)).mergeWithLanguage(phoneme2.getLanguages());
                    treeMap.put(mergeWithLanguage, mergeWithLanguage);
                } else {
                    treeMap.put(phoneme2, phoneme2);
                }
            }
        }
        return new PhonemeBuilder(treeMap.keySet(), null);
    }

    private static String join(Iterable<String> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = iterable.iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    public String encode(String str) {
        return encode(str, this.lang.guessLanguages(str));
    }

    public Lang getLang() {
        return this.lang;
    }

    public int getMaxPhonemes() {
        return this.maxPhonemes;
    }

    public NameType getNameType() {
        return this.nameType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isConcat() {
        return this.concat;
    }

    public PhoneticEngine(NameType nameType2, RuleType ruleType2, boolean z, int i) {
        RuleType ruleType3 = RuleType.RULES;
        if (ruleType2 != ruleType3) {
            this.nameType = nameType2;
            this.ruleType = ruleType2;
            this.concat = z;
            this.lang = Lang.instance(nameType2);
            this.maxPhonemes = i;
            return;
        }
        throw new IllegalArgumentException("ruleType must not be " + ruleType3);
    }

    public String encode(String str, Languages.LanguageSet languageSet) {
        String str2;
        Map<String, List<Rule>> instanceMap = Rule.getInstanceMap(this.nameType, RuleType.RULES, languageSet);
        Map<String, List<Rule>> instanceMap2 = Rule.getInstanceMap(this.nameType, this.ruleType, "common");
        Map<String, List<Rule>> instanceMap3 = Rule.getInstanceMap(this.nameType, this.ruleType, languageSet);
        String trim = str.toLowerCase(Locale.ENGLISH).replace('-', ' ').trim();
        if (this.nameType == NameType.GENERIC) {
            if (trim.length() < 2 || !trim.substring(0, 2).equals("d'")) {
                for (String str3 : NAME_PREFIXES.get(this.nameType)) {
                    if (trim.startsWith(str3 + " ")) {
                        String substring = trim.substring(str3.length() + 1);
                        String str4 = str3 + substring;
                        return jl1.BRACKET_START_STR + encode(substring) + ")-(" + encode(str4) + jl1.BRACKET_END_STR;
                    }
                }
            } else {
                String substring2 = trim.substring(2);
                String str5 = "d" + substring2;
                return jl1.BRACKET_START_STR + encode(substring2) + ")-(" + encode(str5) + jl1.BRACKET_END_STR;
            }
        }
        List<String> asList = Arrays.asList(trim.split("\\s+"));
        ArrayList<String> arrayList = new ArrayList();
        int i = AnonymousClass1.$SwitchMap$org$apache$commons$codec$language$bm$NameType[this.nameType.ordinal()];
        if (i == 1) {
            for (String str6 : asList) {
                String[] split = str6.split("'");
                arrayList.add(split[split.length - 1]);
            }
            arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
        } else if (i == 2) {
            arrayList.addAll(asList);
            arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
        } else if (i == 3) {
            arrayList.addAll(asList);
        } else {
            throw new IllegalStateException("Unreachable case: " + this.nameType);
        }
        if (this.concat) {
            str2 = join(arrayList, " ");
        } else if (arrayList.size() == 1) {
            str2 = (String) asList.iterator().next();
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str7 : arrayList) {
                sb.append("-");
                sb.append(encode(str7));
            }
            return sb.substring(1);
        }
        PhonemeBuilder empty = PhonemeBuilder.empty(languageSet);
        int i2 = 0;
        while (i2 < str2.length()) {
            RulesApplication invoke = new RulesApplication(instanceMap, str2, empty, i2, this.maxPhonemes).invoke();
            i2 = invoke.getI();
            empty = invoke.getPhonemeBuilder();
        }
        return applyFinalRules(applyFinalRules(empty, instanceMap2), instanceMap3).makeString();
    }
}
