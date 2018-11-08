package com.digwener.api;

import com.digwener.dto.*;
import com.digwener.http.*;
import com.google.gson.*;

public class BuyerWrapper {

    private final BuyerHttpService fooHttpService;

    private final Gson gson = new Gson();

    public BuyerWrapper(final BuyerHttpService fooHttpService) {
        this.fooHttpService = fooHttpService;
    }

    public BuyerResponse getResponse() {
        final String rawResponse = fooHttpService.getApiResponse();
        return gson.fromJson(rawResponse, BuyerResponse.class);

    }

}
