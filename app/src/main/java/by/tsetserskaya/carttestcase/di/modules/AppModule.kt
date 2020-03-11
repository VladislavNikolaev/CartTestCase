package by.tsetserskaya.carttestcase.di.modules

import android.content.Context
import by.tsetserskaya.carttestcase.CartApp
import by.tsetserskaya.carttestcase.model.CartRepository
import by.tsetserskaya.carttestcase.network.CartApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesApplicationContext(application: CartApp): Context = application.applicationContext

}