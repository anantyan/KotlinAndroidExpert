package com.tutorial.domain.executor

import java.util.concurrent.*

interface ThreadExecutor: Executor

class JobExecutor: ThreadExecutor {

    private var threadPoolExecutor = ThreadPoolExecutor(
        3,
        5,
        10,
        TimeUnit.SECONDS,
        LinkedBlockingDeque(),
        JobThreadFactory())

    override fun execute(command: Runnable) {
        command.let { threadPoolExecutor.execute(it) }
    }
}

class JobThreadFactory(private var counter: Int = 0): ThreadFactory {

    override fun newThread(r: Runnable): Thread {
        return Thread(r,"android_${counter.inc()}")
    }
}