package by.tsetserskaya.carttestcase.di.modules

import by.tsetserskaya.carttestcase.model.CartRepository
import by.tsetserskaya.carttestcase.network.CartApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class ServiceModule {

    @Singleton
    @Provides
    fun providesCartApi(
        retrofit: Retrofit
    ): CartApi = retrofit.create()

}