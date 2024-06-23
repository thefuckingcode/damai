package org.apache.commons.text.similarity;

/* compiled from: Taobao */
public interface SimilarityScore<R> {
    R apply(CharSequence charSequence, CharSequence charSequence2);
}
