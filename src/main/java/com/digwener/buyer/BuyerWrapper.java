package com.digwener.buyer;

import com.google.gson.*;

public class BuyerWrapper {

    private final BuyerHttpService fooHttpService;

    private final Gson gson = new Gson();

    public BuyerWrapper(final BuyerHttpService fooHttpService) {
        this.fooHttpService = fooHttpService;
    }

    public BuyerDto getResponse() {
        final String rawResponse = fooHttpService.getApiResponse();
        return gson.fromJson(rawResponse, BuyerDto.class);

    }

}
