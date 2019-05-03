package com.jumrukovski.coroutines_demo.injection.builders

import com.jumrukovski.coroutines_demo.main.MainActivity
import com.jumrukovski.coroutines_demo.injection.module.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}