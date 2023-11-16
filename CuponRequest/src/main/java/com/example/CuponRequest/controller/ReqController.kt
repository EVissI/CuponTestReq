package com.example.CuponRequest.controller

import com.example.CuponRequest.devtools.math.MathOperation
import com.example.CuponRequest.models.Coupon
import com.example.CuponRequest.req.Req
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.io.IOException

@RestController
class ReqController(private val restTemplate: RestTemplate) {
    @GetMapping("/test")
    @kotlin.Throws(IOException::class)
    fun Test(): Coupon {
        val promoResponse = Req.promo_req("flamp")
        val listResponse = Req.list_req(promoResponse.header("Set-Cookie"))
        val jsonListString = listResponse.body!!.string()
        val jsonPromoString = promoResponse.body!!.string()
        val objectMapper = ObjectMapper()
        val jsonListNode = objectMapper.readTree(jsonListString)
        val jsonPromoNode = objectMapper.readTree(jsonPromoString)
        val promoName = jsonListNode["data"]["PROMOCODE"]
        val promoStatus = jsonPromoNode["data"]["status"]
        val promoMessage = jsonPromoNode["data"]["message"]
        val price = jsonListNode["data"]["LIST"][0]["BASE_PRICE"]
        val priceAfterUserPromo = jsonListNode["data"]["LIST"][0]["PRICE"]
        val promoInfo = Coupon()
        promoInfo.setPromoName(promoName.toString())
        promoInfo.setStatus(promoStatus.asBoolean())
        promoInfo.setPromoMassage(promoMessage.toString())
        promoInfo.setPromoValue(
            MathOperation.calculatePercentageChange(
                price.asDouble(),
                priceAfterUserPromo.asDouble()
            )
        )
        return promoInfo
    }
}