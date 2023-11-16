package com.example.CuponRequest.models

import com.fasterxml.jackson.annotation.JsonProperty

class Coupon {
    @JsonProperty("promo_name")
    private var promoName: String? = null

    @JsonProperty("promo_value")
    private var promoValue: Int? = null

    @JsonProperty("promo_massage")
    private var promoMassage: String? = null

    @JsonProperty("status")
    private var status = false

    @JsonProperty("work_once")
    private var workOnce = false

    @JsonProperty("limits")
    private var limits: String? = null
    fun setPromoName(promoName: String?) {
        this.promoName = promoName
    }

    fun setPromoValue(promoValue: Int?) {
        this.promoValue = promoValue
    }

    fun setPromoMassage(promoMassage: String?) {
        this.promoMassage = promoMassage
    }

    fun setStatus(status: Boolean) {
        this.status = status
    }

    fun setWorkOnce(workOnce: Boolean) {
        this.workOnce = workOnce
    }

    fun setLimits(limits: String?) {
        this.limits = limits
    }

    override fun toString(): String {
        return "CouponData{" +
                "promoName='" + promoName + '\'' +
                ", promoValue='" + promoValue + '\'' +
                ", promoText='" + promoMassage + '\'' +
                ", status=" + status +
                ", workOnce=" + workOnce +
                ", limits='" + limits + '\'' +
                '}'
    }
}