package com.jumrukovski.coroutines_demo.injection.component

import android.app.Application
import com.jumrukovski.coroutines_demo.App
import com.jumrukovski.coroutines_demo.injection.builders.ActivityBuilder
import com.jumrukovski.coroutines_demo.injection.builders.ViewModelBuilder
import com.jumrukovski.coroutines_demo.injection.module.AppModule
import com.jumrukovski.coroutines_demo.injection.module.CoroutineScopeModule
import com.jumrukovski.coroutines_demo.injection.module.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        ViewModelBuilder::class,
        RetrofitModule::class,
        CoroutineScopeModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}