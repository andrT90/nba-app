package app.nba.app.data.net.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder()
        builder
            .addHeader("x-rapidapi-host", "free-nba.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "bfacf0dd8emsh440e742deecaa97p12b1a7jsn7a91dcdd4841")
        return chain.proceed(builder.build())
    }
}