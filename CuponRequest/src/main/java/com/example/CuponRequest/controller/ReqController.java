package com.example.CuponRequest.controller;

import com.example.CuponRequest.devtools.math.MathOperation;
import com.example.CuponRequest.models.Coupon;
import com.example.CuponRequest.req.Req;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Iterator;

@RestController
public class ReqController {
    private final RestTemplate restTemplate;

    public ReqController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public Coupon Test() throws IOException {
        Response promoResponse = Req.promo_req("flamp");
        Response listResponse = Req.list_req(promoResponse.header("Set-Cookie"));

        assert listResponse.body() != null;
        String jsonListString = listResponse.body().string();
        assert promoResponse.body() != null;
        String jsonPromoString = promoResponse.body().string();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonListNode = objectMapper.readTree(jsonListString);
        JsonNode jsonPromoNode = objectMapper.readTree(jsonPromoString);

        JsonNode promoName = jsonListNode.get("data").get("PROMOCODE");
        JsonNode promoStatus = jsonPromoNode.get("data").get("status");
        JsonNode promoMessage = jsonPromoNode.get("data").get("message");
        JsonNode price = jsonListNode.get("data").get("LIST").get(0).get("BASE_PRICE");
        JsonNode priceAfterUserPromo = jsonListNode.get("data").get("LIST").get(0).get("PRICE");


        Coupon promoInfo = new Coupon();
        promoInfo.setPromoName(promoName.toString());
        promoInfo.setStatus(promoStatus.asBoolean());
        promoInfo.setPromoMassage(promoMessage.toString());
        promoInfo.setPromoValue(MathOperation.calculatePercentageChange(price.asDouble(),priceAfterUserPromo.asDouble()));
        return promoInfo;
    }

}
