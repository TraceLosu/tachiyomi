package eu.kanade.tachiyomi.data.updater

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Observable


/**
 * Used to connect with the Github API.
 */
interface GithubService {

    companion object {
        fun create(): GithubService {
            val restAdapter = Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()

            return restAdapter.create(GithubService::class.java)
        }
    }

    @GET("/repos/inorichi/tachiyomi/releases/latest")
    fun getLatestVersion(): Observable<GithubRelease>

}