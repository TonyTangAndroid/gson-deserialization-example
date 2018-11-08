package com.digwener.api;

import com.digwener.dto.*;
import com.digwener.http.*;

import org.apache.commons.io.*;
import org.junit.*;
import org.mockito.*;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

/**
 * Test class which demonstrates deserialization
 * Created by aberezin on 24.04.2016.
 */
public class BuyerWrapperTest {

    @Mock
    private BuyerHttpService buyerHttpService;

    @InjectMocks
    private BuyerWrapper buyerWrapper;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldLoadBuyer() throws Exception {
        given(buyerHttpService.getApiResponse()).willReturn(getResource());

        BuyerResponse buyerResponse = buyerWrapper.getResponse();
        Buyer buyer = buyerResponse.getData();
        assertNotNull(buyerResponse);
        assertEquals(buyer.getId(), "430426999XX");
        assertEquals(buyer.getName(), "John");
        assertEquals(buyer.getSurname(), "Smith");
    }


    private String getResource() throws Exception {
        return IOUtils.toString(
                this.getClass().getResourceAsStream("buyer.json"),
                "UTF-8"
        );
    }

}