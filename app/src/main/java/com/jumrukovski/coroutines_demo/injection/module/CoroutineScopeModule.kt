package com.jumrukovski.coroutines_demo.injection.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class CoroutineScopeModule {

    @Provides
    @Singleton
    internal fun provideParentJob(): Job {
        return Job()
    }

    @Provides
    @Singleton
    internal fun provideCoroutineContext(parentJob: Job): CoroutineContext {
        return parentJob + Dispatchers.Default
    }

    @Provides
    @Singleton
    internal fun provideCoroutineScope(coroutineContext: CoroutineContext): CoroutineScope {
        return CoroutineScope(coroutineContext)
    }
}