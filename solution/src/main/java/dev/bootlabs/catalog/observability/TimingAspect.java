package dev.bootlabs.catalog.observability;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
class TimingAspect {
    private static final Logger log = LoggerFactory.getLogger(TimingAspect.class);

    @Around("@annotation(timed)")
    Object measure(ProceedingJoinPoint joinPoint, TimedOperation timed) throws Throwable {
        var watch = new StopWatch(); watch.start();
        try { return joinPoint.proceed(); }
        finally { watch.stop(); log.info("operation={} durationMs={}", timed.value(), watch.getTotalTimeMillis()); }
    }
}
