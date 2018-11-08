package com.digwener.dto;

/**
 * General Dto for Foo API
 * Created by aberezin on 24.04.2016.
 */
public class BuyerResponse extends DtoResponse<Buyer> {

    public BuyerResponse(String status, String message, Buyer data) {
        super(status, message, data);
    }
}
