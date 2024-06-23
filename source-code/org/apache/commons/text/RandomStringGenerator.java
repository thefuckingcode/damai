package org.apache.commons.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
public final class RandomStringGenerator {
    private final List<Character> characterList;
    private final Set<CharacterPredicate> inclusivePredicates;
    private final int maximumCodePoint;
    private final int minimumCodePoint;
    private final TextRandomProvider random;

    /* compiled from: Taobao */
    public static class Builder implements Builder<RandomStringGenerator> {
        public static final int DEFAULT_LENGTH = 0;
        public static final int DEFAULT_MAXIMUM_CODE_POINT = 1114111;
        public static final int DEFAULT_MINIMUM_CODE_POINT = 0;
        private List<Character> characterList;
        private Set<CharacterPredicate> inclusivePredicates;
        private int maximumCodePoint = DEFAULT_MAXIMUM_CODE_POINT;
        private int minimumCodePoint = 0;
        private TextRandomProvider random;

        public Builder filteredBy(CharacterPredicate... characterPredicateArr) {
            if (characterPredicateArr == null || characterPredicateArr.length == 0) {
                this.inclusivePredicates = null;
                return this;
            }
            Set<CharacterPredicate> set = this.inclusivePredicates;
            if (set == null) {
                this.inclusivePredicates = new HashSet();
            } else {
                set.clear();
            }
            Collections.addAll(this.inclusivePredicates, characterPredicateArr);
            return this;
        }

        public Builder selectFrom(char... cArr) {
            this.characterList = new ArrayList();
            for (char c : cArr) {
                this.characterList.add(Character.valueOf(c));
            }
            return this;
        }

        public Builder usingRandom(TextRandomProvider textRandomProvider) {
            this.random = textRandomProvider;
            return this;
        }

        public Builder withinRange(int i, int i2) {
            boolean z = true;
            Validate.isTrue(i <= i2, "Minimum code point %d is larger than maximum code point %d", Integer.valueOf(i), Integer.valueOf(i2));
            Validate.isTrue(i >= 0, "Minimum code point %d is negative", (long) i);
            if (i2 > 1114111) {
                z = false;
            }
            Validate.isTrue(z, "Value %d is larger than Character.MAX_CODE_POINT.", (long) i2);
            this.minimumCodePoint = i;
            this.maximumCodePoint = i2;
            return this;
        }

        @Override // org.apache.commons.text.Builder
        public RandomStringGenerator build() {
            return new RandomStringGenerator(this.minimumCodePoint, this.maximumCodePoint, this.inclusivePredicates, this.random, this.characterList);
        }

        public Builder withinRange(char[]... cArr) {
            this.characterList = new ArrayList();
            for (char[] cArr2 : cArr) {
                Validate.isTrue(cArr2.length == 2, "Each pair must contain minimum and maximum code point", new Object[0]);
                char c = cArr2[0];
                char c2 = cArr2[1];
                Validate.isTrue(c <= c2, "Minimum code point %d is larger than maximum code point %d", Integer.valueOf(c), Integer.valueOf(c2));
                int i = c;
                while (i <= c2) {
                    this.characterList.add(Character.valueOf(i == 1 ? (char) 1 : 0));
                    i++;
                }
            }
            return this;
        }
    }

    private int generateRandomNumber(int i, int i2) {
        TextRandomProvider textRandomProvider = this.random;
        if (textRandomProvider != null) {
            return textRandomProvider.nextInt((i2 - i) + 1) + i;
        }
        return ThreadLocalRandom.current().nextInt(i, i2 + 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        if (r5 == false) goto L_0x0064;
     */
    public String generate(int i) {
        int i2;
        boolean z;
        if (i == 0) {
            return "";
        }
        long j = (long) i;
        Validate.isTrue(i > 0, "Length %d is smaller than zero.", j);
        StringBuilder sb = new StringBuilder(i);
        do {
            List<Character> list = this.characterList;
            if (list == null || list.isEmpty()) {
                i2 = generateRandomNumber(this.minimumCodePoint, this.maximumCodePoint);
            } else {
                i2 = generateRandomNumber(this.characterList);
            }
            int type = Character.getType(i2);
            if (!(type == 0 || type == 18 || type == 19)) {
                Set<CharacterPredicate> set = this.inclusivePredicates;
                if (set != null) {
                    Iterator<CharacterPredicate> it = set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().test(i2)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                }
                sb.appendCodePoint(i2);
                j--;
            }
        } while (j != 0);
        return sb.toString();
    }

    private RandomStringGenerator(int i, int i2, Set<CharacterPredicate> set, TextRandomProvider textRandomProvider, List<Character> list) {
        this.minimumCodePoint = i;
        this.maximumCodePoint = i2;
        this.inclusivePredicates = set;
        this.random = textRandomProvider;
        this.characterList = list;
    }

    private int generateRandomNumber(List<Character> list) {
        int size = list.size();
        TextRandomProvider textRandomProvider = this.random;
        if (textRandomProvider != null) {
            return String.valueOf(list.get(textRandomProvider.nextInt(size))).codePointAt(0);
        }
        return String.valueOf(list.get(ThreadLocalRandom.current().nextInt(0, size))).codePointAt(0);
    }

    public String generate(int i, int i2) {
        Validate.isTrue(i >= 0, "Minimum length %d is smaller than zero.", (long) i);
        Validate.isTrue(i <= i2, "Maximum length %d is smaller than minimum length %d.", Integer.valueOf(i2), Integer.valueOf(i));
        return generate(generateRandomNumber(i, i2));
    }
}
