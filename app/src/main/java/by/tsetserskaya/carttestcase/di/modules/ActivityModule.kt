package by.tsetserskaya.carttestcase.di.modules

import by.tsetserskaya.carttestcase.MainActivity
import by.tsetserskaya.carttestcase.di.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}