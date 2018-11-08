package com.digwener.api;

import com.digwener.common.*;
import com.digwener.dto.*;
import com.digwener.http.*;
import com.google.gson.*;

import java.lang.reflect.*;

/**
 * class representing our library API
 * Created by aberezin on 24.04.2016.
 */
public class DtoWrapper {

    private final DtoHttpService fooHttpService;

    private final Gson gson = new Gson();

    public DtoWrapper(final DtoHttpService fooHttpService) {
        this.fooHttpService = fooHttpService;
    }

    /**
     * retrieves the resource of given type
     *
     * @param dataType  type of the resource
     * @param dataClass class which is used to deserialize "data" part
     * @param <T>       type of deserialized "data" object
     * @return deserialized object
     */
    public <T> DtoResponse<T> getResponse(final DataType dataType, final Class<T> dataClass) {

        final String rawResponse = fooHttpService.getApiResponse(dataType);

        return gson.fromJson(rawResponse, getType(DtoResponse.class, dataClass));

    }

    public static Type getType(final Class<?> rawClass, final Class<?> parameterClass) {
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{parameterClass};
            }

            @Override
            public Type getRawType() {
                return rawClass;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }

        };
    }
}
