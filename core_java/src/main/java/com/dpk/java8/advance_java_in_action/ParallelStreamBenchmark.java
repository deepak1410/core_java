package com.dpk.java8.advance_java_in_action;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value=2, jvmArgs={"-Xms4G", "-Xmx4G"})
@State(Scope.Thread)  // Indicates state scope (e.g., thread-local state)
public class ParallelStreamBenchmark {
    private static final long N= 10_000_000L;

    @Benchmark
    public long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1).limit(N)
                .reduce( 0L, Long::sum);
    }

    @Benchmark
    public long iterativeSum() {
        long result = 0;
        for (long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }
}
