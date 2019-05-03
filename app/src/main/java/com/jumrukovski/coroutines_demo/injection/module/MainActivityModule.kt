package com.jumrukovski.coroutines_demo.injection.module

import android.app.Activity
import com.jumrukovski.coroutines_demo.main.MainActivity
import com.jumrukovski.coroutines_demo.injection.scope.PerActivity
import dagger.Binds
import dagger.Module


@Module
abstract class MainActivityModule {

    @Binds
    @PerActivity
    internal abstract fun activity(mainActivity: MainActivity): Activity
}