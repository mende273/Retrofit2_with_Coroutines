package com.jumrukovski.coroutines_demo.injection.builders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jumrukovski.coroutines_demo.main.MainActivityVM
import com.jumrukovski.coroutines_demo.base.ViewModelFactory
import com.jumrukovski.coroutines_demo.injection.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilder {

    @Binds
    internal abstract fun bindViewModelFactory(projectViewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityVM::class)
    internal abstract fun bindMainActivityVM(viewModel: MainActivityVM): ViewModel
}