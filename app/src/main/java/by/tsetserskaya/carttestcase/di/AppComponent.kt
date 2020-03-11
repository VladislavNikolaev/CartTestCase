package by.tsetserskaya.carttestcase.di

import by.tsetserskaya.carttestcase.CartApp
import by.tsetserskaya.carttestcase.di.modules.ActivityModule
import by.tsetserskaya.carttestcase.di.modules.AppModule
import by.tsetserskaya.carttestcase.di.modules.ServiceModule
import by.tsetserskaya.carttestcase.di.modules.ToolsBuilder
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ServiceModule::class,
        ActivityModule::class,
        ToolsBuilder::class
    ]
)
interface AppComponent : AndroidInjector<CartApp> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<CartApp>
}