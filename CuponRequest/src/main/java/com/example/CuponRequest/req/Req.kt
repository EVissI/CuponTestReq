package com.example.CuponRequest.req

import okhttp3.*
import okhttp3.Request.Builder.addHeader
import okhttp3.Request.Builder.build
import okhttp3.Request.Builder.post
import okhttp3.Request.Builder.url
import java.io.IOException

object Req {
    @kotlin.Throws(IOException::class)
    fun promo_req(promo: String): Response {
        val client = OkHttpClient()
        val mediaType: MediaType = parse.parse("application/x-www-form-urlencoded")
        val body: RequestBody = create.create(mediaType, "promocode=$promo")
        val request: Request = Builder()
            .url("https://amournsk.ru/api/cart/promo.php")
            .post(body)
            .addHeader(
                "cookie",
                "BITRIX_SM_TZ=Etc/GMT-3; BITRIX_SM_GUEST_ID=3748788; BITRIX_SM_SALE_UID=2081633; _ga=GA1.2.1878222335.1699163763; _ym_uid=1699163763621085419; _ym_d=1699163763; BX_USER_ID=7767ebc6ebf43858f6e2d15fade3aac9; _gid=GA1.2.117458737.1700031108; _ym_isad=1; PHPSESSID=U1kLU0hRbpgptlk8kMVsbEhi2OnnzKyS; BITRIX_CONVERSION_CONTEXT_s1=%7B%22ID%22%3A1%2C%22EXPIRE%22%3A1700067540%2C%22UNIQUE%22%3A%5B%22conversion_visit_day%22%5D%7D; BITRIX_SM_LAST_VISIT=15.11.2023%2013%3A52%3A16; _ga_MCF1SLFZQE=GS1.2.1700031108.20.1.1700031138.0.0.0; _ga_K5GFDK3RCN=GS1.2.1700031109.20.1.1700031138.31.0.0"
            )
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("authority", "amournsk.ru")
            .addHeader("accept", "application/json, text/plain, */*")
            .addHeader("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
            .addHeader("origin", "https://amournsk.ru")
            .addHeader("referer", "https://amournsk.ru/personal/cart/")
            .addHeader("sec-ch-ua-mobile", "?0")
            .addHeader("sec-ch-ua-platform", "Windows")
            .addHeader("sec-fetch-dest", "empty")
            .addHeader("sec-fetch-mode", "cors")
            .addHeader("sec-fetch-site", "same-origin")
            .addHeader(
                "user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36"
            )
            .build()
        return client.newCall(request).execute()
    }

    @kotlin.Throws(IOException::class)
    fun list_req(cookie: String?): Response {
        val client = OkHttpClient()
        val request: Request = Builder()
            .url("https://amournsk.ru/api/cart/list.php")
            .addHeader("cookie", cookie)
            .addHeader("authority", "amournsk.ru")
            .addHeader("accept", "application/json, text/plain, */*")
            .addHeader("accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
            .addHeader("content-type", "multipart/form-data; boundary=---011000010111000001101001")
            .addHeader("origin", "https://amournsk.ru")
            .addHeader("referer", "https://amournsk.ru/personal/cart/")
            .addHeader("sec-ch-ua-mobile", "?0")
            .addHeader("sec-ch-ua-platform", "Windows")
            .addHeader("sec-fetch-dest", "empty")
            .addHeader("sec-fetch-mode", "cors")
            .addHeader("sec-fetch-site", "same-origin")
            .addHeader(
                "user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36"
            )
            .build()
        return client.newCall(request).execute()
    }
}