package com.example.mygankkotlin.di.module

import android.util.Log

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2017/7/18
 */

@dagger.Module(includes = arrayOf(AppModule::class))
class ApiModule {

    @dagger.Provides
    fun provideRetrofit(baseUrl: okhttp3.HttpUrl, client: okhttp3.OkHttpClient, gson: com.google.gson.Gson) =
            retrofit2.Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(retrofit2.adapter.rxjava.RxJavaCallAdapterFactory.createWithScheduler(rx.schedulers.Schedulers.io()))
                    .build()

    @dagger.Provides
    fun provideBaseUrl() = okhttp3.HttpUrl.parse("http://gank.io/api/")

    @dagger.Provides
    fun provideOkhttp(context: android.content.Context, interceptor: okhttp3.logging.HttpLoggingInterceptor): okhttp3.OkHttpClient {
        val cacheSize = 1024*1024*10L
        val cacheDir = java.io.File(context.cacheDir, "http")
        val cache = okhttp3.Cache(cacheDir, cacheSize)
        return okhttp3.OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .build()
    }


    @dagger.Provides
    fun provideInterceptor(): okhttp3.logging.HttpLoggingInterceptor {
        val interceptor = okhttp3.logging.HttpLoggingInterceptor {
            msg ->
            Log.d("okhttp", msg)
        }
        interceptor.level = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @dagger.Provides
    fun proviceGson() = com.google.gson.GsonBuilder().create()

    @dagger.Provides
    fun provideApi(retrofit: retrofit2.Retrofit) = retrofit.create(com.example.mygankkotlin.api.GankApi::class.java)

}