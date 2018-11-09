package com.digwener.index;

import com.google.common.truth.*;
import com.google.gson.*;

import org.apache.commons.io.*;
import org.junit.*;
import org.mockito.*;

import java.util.*;

public class IndexWrapperTest {


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldLoadBuyer() throws Exception {


        String json = json();
        CategoryDto actual = new Gson().fromJson(json, CategoryDto.class);

        Truth.assertThat(actual).isNotNull();
        Truth.assertThat(actual.code).isEqualTo(10);
        Truth.assertThat(actual.data).isNotNull();
        Truth.assertThat(actual.data.data_id).isEqualTo("ABC");
        List<Item> list = actual.data.item_list;
        Truth.assertThat(list).isNotEmpty();
        Truth.assertThat(list.size()).isEqualTo(2);

        {
            Item item = list.get(0);
            Truth.assertThat(item.type).isEqualTo(406);
            Truth.assertThat(item.item_id).isEqualTo("10091@2880956625");
            Object data = item.data;
            Truth.assertThat(data).isEqualTo(10000);
        }


    }


    private String json() throws Exception {
        return IOUtils.toString(this.getClass().getResourceAsStream("dto.json"), "UTF-8");
    }

}