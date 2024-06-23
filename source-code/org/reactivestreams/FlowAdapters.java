package org.reactivestreams;

import java.util.concurrent.Flow;

public final class FlowAdapters {
    private FlowAdapters() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: org.reactivestreams.Publisher<? extends T>, org.reactivestreams.Publisher<T> */
    public static <T> Publisher<T> toPublisher(Flow.Publisher<? extends T> publisher) {
        C$r8$backportedMethods$utility$Objects$2$requireNonNullMessage.requireNonNull(publisher, "flowPublisher");
        if (publisher instanceof FlowPublisherFromReactive) {
            return (Publisher<? extends T>) ((FlowPublisherFromReactive) publisher).reactiveStreams;
        }
        if (publisher instanceof Publisher) {
            return (Publisher) publisher;
        }
        return new ReactivePublisherFromFlow(publisher);
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: java.util.concurrent.Flow$Publisher<? extends T>, java.util.concurrent.Flow$Publisher<T> */
    public static <T> Flow.Publisher<T> toFlowPublisher(Publisher<? extends T> publisher) {
        C$r8$backportedMethods$utility$Objects$2$requireNonNullMessage.requireNonNull(publisher, "reactiveStreamsPublisher");
        if (publisher instanceof ReactivePublisherFromFlow) {
            return (Flow.Publisher<? extends T>) ((ReactivePublisherFromFlow) publisher).flow;
        }
        if (publisher instanceof Flow.Publisher) {
            return (Flow.Publisher) publisher;
        }
        return new FlowPublisherFromReactive(publisher);
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: org.reactivestreams.Processor<? super T, ? extends U>, org.reactivestreams.Processor<T, U> */
    public static <T, U> Processor<T, U> toProcessor(Flow.Processor<? super T, ? extends U> processor) {
        C$r8$backportedMethods$utility$Objects$2$requireNonNullMessage.requireNonNull(processor, "flowProcessor");
        if (processor instanceof FlowToReactiveProcessor) {
            return (Processor<? super T, ? extends U>) ((FlowToReactiveProcessor) processor).reactiveStreams;
        }
        if (processor instanceof Processor) {
            return (Processor) processor;
        }
        return new ReactiveToFlowProcessor(processor);
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: java.util.concurrent.Flow$Processor<? super T, ? extends U>, java.util.concurrent.Flow$Processor<T, U> */
    public static <T, U> Flow.Processor<T, U> toFlowProcessor(Processor<? super T, ? extends U> processor) {
        C$r8$backportedMethods$utility$Objects$2$requireNonNullMessage.requireNonNull(processor, "reactiveStreamsProcessor");
        if (processor instanceof ReactiveToFlowProcessor) {
            return (Flow.Processor<? super T, ? extends U>) ((ReactiveToFlowProcessor) processor).flow;
        }
        if (processor instanceof Flow.Processor) {
            return (Flow.Processor) processor;
        }
        return new FlowToReactiveProcessor(processor);
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: java.util.concurrent.Flow$Subscriber<? super T>, java.util.concurrent.Flow$Subscriber<T> */
    public static <T> Flow.Subscriber<T> toFlowSubscriber(Subscriber<T> subscriber) {
        C$r8$backportedMethods$utility$Objects$2$requireNonNullMessage.requireNonNull(subscriber, "reactiveStreamsSubscriber");
        if (subscriber instanceof ReactiveToFlowSubscriber) {
            return (Flow.Subscriber<? super T>) ((ReactiveToFlowSubscriber) subscriber).flow;
        }
        if (subscriber instanceof Flow.Subscriber) {
            return (Flow.Subscriber) subscriber;
        }
        return new FlowToReactiveSubscriber(subscriber);
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: org.reactivestreams.Subscriber<? super T>, org.reactivestreams.Subscriber<T> */
    public static <T> Subscriber<T> toSubscriber(Flow.Subscriber<T> subscriber) {
        C$r8$backportedMethods$utility$Objects$2$requireNonNullMessage.requireNonNull(subscriber, "flowSubscriber");
        if (subscriber instanceof FlowToReactiveSubscriber) {
            return (Subscriber<? super T>) ((FlowToReactiveSubscriber) subscriber).reactiveStreams;
        }
        if (subscriber instanceof Subscriber) {
            return (Subscriber) subscriber;
        }
        return new ReactiveToFlowSubscriber(subscriber);
    }

    static final class FlowToReactiveSubscription implements Flow.Subscription {
        final Subscription reactiveStreams;

        public FlowToReactiveSubscription(Subscription subscription) {
            this.reactiveStreams = subscription;
        }

        public void request(long j) {
            this.reactiveStreams.request(j);
        }

        public void cancel() {
            this.reactiveStreams.cancel();
        }
    }

    static final class ReactiveToFlowSubscription implements Subscription {
        final Flow.Subscription flow;

        public ReactiveToFlowSubscription(Flow.Subscription subscription) {
            this.flow = subscription;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.flow.request(j);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.flow.cancel();
        }
    }

    static final class FlowToReactiveSubscriber<T> implements Flow.Subscriber<T> {
        final Subscriber<? super T> reactiveStreams;

        public FlowToReactiveSubscriber(Subscriber<? super T> subscriber) {
            this.reactiveStreams = subscriber;
        }

        public void onSubscribe(Flow.Subscription subscription) {
            this.reactiveStreams.onSubscribe(subscription == null ? null : new ReactiveToFlowSubscription(subscription));
        }

        public void onNext(T t) {
            this.reactiveStreams.onNext(t);
        }

        public void onError(Throwable th) {
            this.reactiveStreams.onError(th);
        }

        public void onComplete() {
            this.reactiveStreams.onComplete();
        }
    }

    static final class ReactiveToFlowSubscriber<T> implements Subscriber<T> {
        final Flow.Subscriber<? super T> flow;

        public ReactiveToFlowSubscriber(Flow.Subscriber<? super T> subscriber) {
            this.flow = subscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.flow.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.flow.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.flow.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.flow.onComplete();
        }
    }

    static final class ReactiveToFlowProcessor<T, U> implements Processor<T, U> {
        final Flow.Processor<? super T, ? extends U> flow;

        public ReactiveToFlowProcessor(Flow.Processor<? super T, ? extends U> processor) {
            this.flow = processor;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.flow.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.flow.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.flow.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.flow.onComplete();
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super U> subscriber) {
            this.flow.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }
    }

    static final class FlowToReactiveProcessor<T, U> implements Flow.Processor<T, U> {
        final Processor<? super T, ? extends U> reactiveStreams;

        public FlowToReactiveProcessor(Processor<? super T, ? extends U> processor) {
            this.reactiveStreams = processor;
        }

        public void onSubscribe(Flow.Subscription subscription) {
            this.reactiveStreams.onSubscribe(subscription == null ? null : new ReactiveToFlowSubscription(subscription));
        }

        public void onNext(T t) {
            this.reactiveStreams.onNext(t);
        }

        public void onError(Throwable th) {
            this.reactiveStreams.onError(th);
        }

        public void onComplete() {
            this.reactiveStreams.onComplete();
        }

        public void subscribe(Flow.Subscriber<? super U> subscriber) {
            this.reactiveStreams.subscribe(subscriber == null ? null : new ReactiveToFlowSubscriber(subscriber));
        }
    }

    static final class ReactivePublisherFromFlow<T> implements Publisher<T> {
        final Flow.Publisher<? extends T> flow;

        public ReactivePublisherFromFlow(Flow.Publisher<? extends T> publisher) {
            this.flow = publisher;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            this.flow.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }
    }

    static final class FlowPublisherFromReactive<T> implements Flow.Publisher<T> {
        final Publisher<? extends T> reactiveStreams;

        public FlowPublisherFromReactive(Publisher<? extends T> publisher) {
            this.reactiveStreams = publisher;
        }

        public void subscribe(Flow.Subscriber<? super T> subscriber) {
            this.reactiveStreams.subscribe(subscriber == null ? null : new ReactiveToFlowSubscriber(subscriber));
        }
    }
}
