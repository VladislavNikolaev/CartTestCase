package by.tsetserskaya.carttestcase.di.modules

import by.tsetserskaya.carttestcase.BuildConfig.API_URL
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [OkHttpClientModule::class])
class RetrofitModule {

    @Singleton
    @Provides
    fun providesRetrofit(
        @Named("base") url: String,
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(url)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setLenient()
        gsonBuilder.setFieldNamingPolicy((FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES))
        return gsonBuilder.create()
    }

    @Singleton
    @Provides
    fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    @Named("base")
    fun providesUrl() = API_URL
}