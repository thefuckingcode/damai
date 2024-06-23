package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class AnimationInfo extends SpecialEffectsInfo {
        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim = false;

        AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mIsPop = z;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SpecialEffectsInfo {
        @NonNull
        private final SpecialEffectsController.Operation mOperation;
        @NonNull
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        /* access modifiers changed from: package-private */
        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        /* access modifiers changed from: package-private */
        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return from == finalState || !(from == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (final AnimationInfo animationInfo : list) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo.completeSpecialEffect();
                        } else {
                            final boolean z3 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z3) {
                                list2.remove(operation);
                            }
                            final View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() {
                                /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass2 */

                                public void onAnimationEnd(Animator animator) {
                                    container.endViewTransition(view);
                                    if (z3) {
                                        operation.getFinalState().applyState(view);
                                    }
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            animationInfo.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() {
                                /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass3 */

                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final AnimationInfo animationInfo2 = (AnimationInfo) it.next();
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.completeSpecialEffect();
            } else if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() {
                        /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass4 */

                        public void onAnimationEnd(Animation animation) {
                            container.post(new Runnable() {
                                /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass4.AnonymousClass1 */

                                public void run() {
                                    AnonymousClass4 r0 = AnonymousClass4.this;
                                    container.endViewTransition(view2);
                                    animationInfo2.completeSpecialEffect();
                                }
                            });
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() {
                    /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass5 */

                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo2.completeSpecialEffect();
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:149:0x0012 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x029f, code lost:
        r0 = (android.view.View) r9.get(r11.get(0));
     */
    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, final boolean z, @Nullable final SpecialEffectsController.Operation operation, @Nullable final SpecialEffectsController.Operation operation2) {
        Iterator<TransitionInfo> it;
        ArrayList<View> arrayList;
        ArrayList<View> arrayList2;
        View view;
        View view2;
        Object obj;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation operation4;
        Object obj2;
        Object obj3;
        ArrayMap arrayMap;
        SpecialEffectsController.Operation operation5;
        FragmentTransitionImpl fragmentTransitionImpl;
        View view3;
        Rect rect;
        DefaultSpecialEffectsController defaultSpecialEffectsController;
        ArrayList<View> arrayList3;
        SpecialEffectsController.Operation operation6;
        ArrayList<View> arrayList4;
        SharedElementCallback sharedElementCallback;
        SharedElementCallback sharedElementCallback2;
        ArrayList<String> arrayList5;
        View view4;
        final View view5;
        String findKeyForValue;
        ArrayList<String> arrayList6;
        DefaultSpecialEffectsController defaultSpecialEffectsController2 = this;
        boolean z2 = z;
        SpecialEffectsController.Operation operation7 = operation;
        SpecialEffectsController.Operation operation8 = operation2;
        HashMap hashMap = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl2 = 0;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (!(handlingImpl == null || fragmentTransitionImpl2 == handlingImpl)) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return hashMap;
        }
        View view6 = new View(getContainer().getContext());
        final Rect rect2 = new Rect();
        ArrayList<View> arrayList7 = new ArrayList<>();
        ArrayList<View> arrayList8 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Object obj4 = null;
        View view7 = null;
        boolean z3 = false;
        for (TransitionInfo transitionInfo3 : list) {
            if (!transitionInfo3.hasSharedElementTransition() || operation7 == null || operation8 == null) {
                arrayMap = arrayMap2;
                arrayList4 = arrayList8;
                defaultSpecialEffectsController = defaultSpecialEffectsController2;
                operation6 = operation7;
                arrayList3 = arrayList7;
                rect = rect2;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                operation5 = operation8;
                view3 = view6;
                view7 = view7;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(transitionInfo3.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                int i = 0;
                for (ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames(); i < sharedElementTargetNames.size(); sharedElementTargetNames = sharedElementTargetNames) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i));
                    }
                    i++;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (!z2) {
                    sharedElementCallback2 = operation.getFragment().getExitTransitionCallback();
                    sharedElementCallback = operation2.getFragment().getEnterTransitionCallback();
                } else {
                    sharedElementCallback2 = operation.getFragment().getEnterTransitionCallback();
                    sharedElementCallback = operation2.getFragment().getExitTransitionCallback();
                }
                int i2 = 0;
                for (int size = sharedElementSourceNames.size(); i2 < size; size = size) {
                    arrayMap2.put(sharedElementSourceNames.get(i2), sharedElementTargetNames2.get(i2));
                    i2++;
                }
                ArrayMap arrayMap3 = new ArrayMap();
                defaultSpecialEffectsController2.findNamedViews(arrayMap3, operation.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view8 = (View) arrayMap3.get(str);
                        if (view8 == null) {
                            arrayMap2.remove(str);
                            arrayList6 = sharedElementSourceNames;
                        } else {
                            arrayList6 = sharedElementSourceNames;
                            if (!str.equals(ViewCompat.getTransitionName(view8))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view8), (String) arrayMap2.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList6;
                    }
                    arrayList5 = sharedElementSourceNames;
                } else {
                    arrayList5 = sharedElementSourceNames;
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                final ArrayMap arrayMap4 = new ArrayMap();
                defaultSpecialEffectsController2.findNamedViews(arrayMap4, operation2.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view9 = (View) arrayMap4.get(str2);
                        if (view9 == null) {
                            String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, str2);
                            if (findKeyForValue2 != null) {
                                arrayMap2.remove(findKeyForValue2);
                            }
                        } else if (!str2.equals(ViewCompat.getTransitionName(view9)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, str2)) != null) {
                            arrayMap2.put(findKeyForValue, ViewCompat.getTransitionName(view9));
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                defaultSpecialEffectsController2.retainMatchingViews(arrayMap3, arrayMap2.keySet());
                defaultSpecialEffectsController2.retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    operation6 = operation;
                    arrayMap = arrayMap2;
                    arrayList4 = arrayList8;
                    defaultSpecialEffectsController = defaultSpecialEffectsController2;
                    arrayList3 = arrayList7;
                    rect = rect2;
                    view3 = view6;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    view7 = view7;
                    obj4 = null;
                    operation5 = operation2;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z2, arrayMap3, true);
                    arrayMap = arrayMap2;
                    OneShotPreDrawListener.add(getContainer(), new Runnable() {
                        /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass6 */

                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z, arrayMap4, false);
                        }
                    });
                    arrayList7.addAll(arrayMap3.values());
                    if (!arrayList5.isEmpty()) {
                        View view10 = (View) arrayMap3.get(arrayList5.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view10);
                        view7 = view10;
                    } else {
                        view7 = view7;
                    }
                    arrayList4 = arrayList8;
                    arrayList4.addAll(arrayMap4.values());
                    if (sharedElementTargetNames2.isEmpty() || view5 == null) {
                        defaultSpecialEffectsController = this;
                        view4 = view6;
                    } else {
                        defaultSpecialEffectsController = this;
                        OneShotPreDrawListener.add(getContainer(), new Runnable() {
                            /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass7 */

                            public void run() {
                                fragmentTransitionImpl2.getBoundsOnScreen(view5, rect2);
                            }
                        });
                        view4 = view6;
                        z3 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view4, arrayList7);
                    arrayList3 = arrayList7;
                    rect = rect2;
                    view3 = view4;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(wrapTransitionInSet, null, null, null, null, wrapTransitionInSet, arrayList4);
                    Boolean bool = Boolean.TRUE;
                    operation6 = operation;
                    hashMap = hashMap;
                    hashMap.put(operation6, bool);
                    operation5 = operation2;
                    hashMap.put(operation5, bool);
                    obj4 = wrapTransitionInSet;
                }
            }
            z2 = z;
            arrayList7 = arrayList3;
            defaultSpecialEffectsController2 = defaultSpecialEffectsController;
            rect2 = rect;
            view6 = view3;
            operation8 = operation5;
            arrayMap2 = arrayMap;
            arrayList8 = arrayList4;
            operation7 = operation6;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
        }
        View view11 = view7;
        ArrayList<View> arrayList9 = arrayList8;
        ArrayList<View> arrayList10 = arrayList7;
        SpecialEffectsController.Operation operation9 = operation8;
        View view12 = view6;
        ArrayList arrayList11 = new ArrayList();
        Iterator<TransitionInfo> it2 = list.iterator();
        Object obj5 = null;
        Object obj6 = null;
        while (it2.hasNext()) {
            TransitionInfo next = it2.next();
            if (next.isVisibilityUnchanged()) {
                hashMap.put(next.getOperation(), Boolean.FALSE);
                next.completeSpecialEffect();
            } else {
                Object cloneTransition = fragmentTransitionImpl2.cloneTransition(next.getTransition());
                SpecialEffectsController.Operation operation10 = next.getOperation();
                boolean z4 = obj4 != null && (operation10 == operation7 || operation10 == operation9);
                if (cloneTransition == null) {
                    if (!z4) {
                        hashMap.put(operation10, Boolean.FALSE);
                        next.completeSpecialEffect();
                    }
                    arrayList = arrayList9;
                    arrayList2 = arrayList10;
                    it = it2;
                    view = view12;
                    obj = obj5;
                    operation3 = operation9;
                    view2 = view11;
                } else {
                    it = it2;
                    final ArrayList<View> arrayList12 = new ArrayList<>();
                    defaultSpecialEffectsController2.captureTransitioningViews(arrayList12, operation10.getFragment().mView);
                    if (z4) {
                        if (operation10 == operation7) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        fragmentTransitionImpl2.addTarget(cloneTransition, view12);
                        arrayList = arrayList9;
                        arrayList2 = arrayList10;
                        view = view12;
                        operation4 = operation10;
                        obj3 = obj6;
                        operation3 = operation9;
                        obj2 = obj5;
                    } else {
                        fragmentTransitionImpl2.addTargets(cloneTransition, arrayList12);
                        view = view12;
                        obj2 = obj5;
                        arrayList2 = arrayList10;
                        obj3 = obj6;
                        arrayList = arrayList9;
                        operation3 = operation9;
                        fragmentTransitionImpl2.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList12, null, null, null, null);
                        if (operation10.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation4 = operation10;
                            list2.remove(operation4);
                            ArrayList<View> arrayList13 = new ArrayList<>(arrayList12);
                            arrayList13.remove(operation4.getFragment().mView);
                            fragmentTransitionImpl2.scheduleHideFragmentView(cloneTransition, operation4.getFragment().mView, arrayList13);
                            OneShotPreDrawListener.add(getContainer(), new Runnable() {
                                /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass8 */

                                public void run() {
                                    FragmentTransition.setViewVisibility(arrayList12, 4);
                                }
                            });
                        } else {
                            operation4 = operation10;
                        }
                    }
                    if (operation4.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z3) {
                            fragmentTransitionImpl2.setEpicenter(cloneTransition, rect2);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        fragmentTransitionImpl2.setEpicenter(cloneTransition, view2);
                    }
                    hashMap.put(operation4, Boolean.TRUE);
                    if (next.isOverlapAllowed()) {
                        obj6 = fragmentTransitionImpl2.mergeTransitionsTogether(obj3, cloneTransition, null);
                        obj = obj2;
                    } else {
                        obj = fragmentTransitionImpl2.mergeTransitionsTogether(obj2, cloneTransition, null);
                        obj6 = obj3;
                    }
                }
                operation9 = operation3;
                obj5 = obj;
                view11 = view2;
                view12 = view;
                arrayList10 = arrayList2;
                arrayList9 = arrayList;
                it2 = it;
            }
        }
        Object mergeTransitionsInSequence = fragmentTransitionImpl2.mergeTransitionsInSequence(obj6, obj5, obj4);
        for (final TransitionInfo transitionInfo4 : list) {
            if (!transitionInfo4.isVisibilityUnchanged()) {
                Object transition = transitionInfo4.getTransition();
                SpecialEffectsController.Operation operation11 = transitionInfo4.getOperation();
                boolean z5 = obj4 != null && (operation11 == operation7 || operation11 == operation9);
                if (transition != null || z5) {
                    if (!ViewCompat.isLaidOut(getContainer())) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation11);
                        }
                        transitionInfo4.completeSpecialEffect();
                    } else {
                        fragmentTransitionImpl2.setListenerForTransitionEnd(transitionInfo4.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo4.getSignal(), new Runnable() {
                            /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass9 */

                            public void run() {
                                transitionInfo4.completeSpecialEffect();
                            }
                        });
                    }
                }
            }
        }
        if (!ViewCompat.isLaidOut(getContainer())) {
            return hashMap;
        }
        FragmentTransition.setViewVisibility(arrayList11, 4);
        ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl2.prepareSetNameOverridesReordered(arrayList9);
        fragmentTransitionImpl2.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
        fragmentTransitionImpl2.setNameOverridesReordered(getContainer(), arrayList10, arrayList9, prepareSetNameOverridesReordered, arrayMap2);
        FragmentTransition.setViewVisibility(arrayList11, 0);
        fragmentTransitionImpl2.swapSharedElementTargets(obj4, arrayList10, arrayList9);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    /* access modifiers changed from: package-private */
    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!ViewGroupCompat.isTransitionGroup(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        captureTransitioningViews(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int i = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList<SpecialEffectsController.Operation> arrayList3 = new ArrayList(list);
        for (final SpecialEffectsController.Operation operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation4, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (operation4 != operation) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.addCompletionListener(new Runnable() {
                        /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass1 */

                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
            } else if (operation4 != operation2) {
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.addCompletionListener(new Runnable() {
                    /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass1 */

                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            }
            z2 = true;
            arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
            operation4.addCompletionListener(new Runnable() {
                /* class androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass1 */

                public void run() {
                    if (arrayList3.contains(operation4)) {
                        arrayList3.remove(operation4);
                        DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                    }
                }
            });
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        for (SpecialEffectsController.Operation operation5 : arrayList3) {
            applyContainerChanges(operation5);
        }
        arrayList3.clear();
    }

    /* access modifiers changed from: package-private */
    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        @Nullable
        private final Object mSharedElementTransition;
        @Nullable
        private final Object mTransition;

        TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            Object obj;
            Object obj2;
            boolean z3;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z) {
                    obj2 = operation.getFragment().getReenterTransition();
                } else {
                    obj2 = operation.getFragment().getEnterTransition();
                }
                this.mTransition = obj2;
                if (z) {
                    z3 = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    z3 = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = z3;
            } else {
                if (z) {
                    obj = operation.getFragment().getReturnTransition();
                } else {
                    obj = operation.getFragment().getExitTransition();
                }
                this.mTransition = obj;
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
