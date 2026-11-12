package com.example.e_commerce_app.ui.theme.feature.network.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    /**
        val interceptor = HttpLoggingInterceptor{message ->
            Log.e("API",message)
        }
            .apply {
             level = HttpLoggingInterceptor.Level.BODY
        }
     */
    @Provides
    @Singleton
    fun ProvideOkHttpCleint (): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
             level = HttpLoggingInterceptor.Level.BODY
        }
        val client  = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return client
    }
    @Provides
    @Singleton
    fun ProvideRetrofit (okHttpClient: OkHttpClient): Retrofit {
       val retrofit =  Retrofit.Builder()
            .baseUrl(ApiEndPoints.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit
    }
    @Provides
    @Singleton
    fun ApiServices(retrofit: Retrofit): ApiServices{
        return retrofit.create(ApiServices:: class.java)
    }
}