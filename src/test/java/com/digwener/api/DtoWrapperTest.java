package com.digwener.api;

import com.digwener.common.*;
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
public class DtoWrapperTest {

    @Mock
    private DtoHttpService dtoHttpService;

    @InjectMocks
    private DtoWrapper dtoWrapper;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldLoadPerson() throws Exception {
        given(dtoHttpService.getApiResponse(DataType.PERSON)).willReturn(getResource("person.json"));

        DtoResponse<Person> person = dtoWrapper.getResponse(DataType.PERSON, Person.class);
        Person data = person.getData();
        assertNotNull(person);
        assertEquals(data.getName(), "John");
        assertEquals(data.getSurname(), "Smith");
    }

    @Test
    public void shouldLoadDepartment() throws Exception {
        given(dtoHttpService.getApiResponse(DataType.DEPARTMENT)).willReturn(getResource("department.json"));

        DtoResponse<Department> department = dtoWrapper.getResponse(DataType.DEPARTMENT, Department.class);

        assertNotNull(department);
        assertEquals(department.getData().getName(), "Agriculture");
        assertEquals(department.getData().getPeopleCount(), 42);
    }

    private String getResource(final String fileName) throws Exception {
        return IOUtils.toString(
                this.getClass().getResourceAsStream(fileName),
                "UTF-8"
        );
    }

}