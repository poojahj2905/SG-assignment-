package com.example.demo.test.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.EmployeeController;
import com.example.demo.exceptions.EmployeeAlreadyExistsException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Employee employee;
    @MockBean
    EmployeeService employeeService;
    @InjectMocks
    EmployeeController employeeController;
	
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
       
        employee= new Employee();
        employee.setFirstName("pooja");
        employee.setLastName("HJ");
        employee.setGender("Female");
        employee.setDob("29thMay");
        employee.setDepartment("CommsMedia");   
    }
	
    @Test
    public void registerUserSuccess() throws Exception {

        when(employeeService.saveEmployee(employee)).thenReturn(true);
        mockMvc.perform(post("/api/employees/register")
                .contentType(MediaType.APPLICATION_JSON).content(jsonToString(employee)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

    }
    
    
    @Test
    public void registerUserFailure() throws Exception {

        when(employeeService.saveEmployee(any())).thenThrow(EmployeeAlreadyExistsException.class);
        mockMvc.perform(post("/api/employees/register")
                .contentType(MediaType.APPLICATION_JSON).content(jsonToString(employee)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

    }
    
    @Test
      public void findAllEmployeesByFirstNameAsc() throws Exception {
    	  
    	  when(employeeService.findAllEmployeesOrderByFirstNameAsc());
    	  mockMvc.perform(get("/api/employees/asc").contentType(MediaType.APPLICATION_JSON))
    			  .andExpect(status().isFound()).andDo(MockMvcResultHandlers.print());
    	  
    	  
      }

    // Parsing String format data into JSON format
    private static String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            result = jsonContent;
        } catch (JsonProcessingException e) {
            result = "Json processing error";
        }
        return result;
    }
	
	

}
