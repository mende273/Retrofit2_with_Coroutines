package com.jumrukovski.coroutines_demo

import android.app.Activity
import android.app.Application
import com.jumrukovski.coroutines_demo.injection.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? = activityDispatchingAndroidInjector
}