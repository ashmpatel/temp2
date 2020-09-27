package com.example.testingwebapp;

import com.example.testingwebapp.controller.DSAACController;
import com.example.testingwebapp.model.SubmtBatchResponse;
import com.example.testingwebapp.service.DSAACService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DSAACController.class)
public class DsaacTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DSAACService service;


	@Test
	public void dsaacHealth() throws Exception {
		when(service.health()).thenReturn("OK");
		this.mockMvc.perform(get("/v1/health")).
				andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("OK")));
	}

	@Test
	public void submitGrids() throws Exception {
		GridId gridId = new GridId();
		List<Long> gridIds = new ArrayList<>();
		gridIds.add(10L);
		gridId.setGridIds(gridIds);

		SubmtBatchResponse test = new SubmtBatchResponse();
		test.setBatchId(10);

		Mockito.when(
				service.getDataForGrids(
						Mockito.any(GridId.class))).thenReturn(test);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.
				 post("/v1/submitgrids")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(gridId)) // send the data in the post
				.accept(MediaType.APPLICATION_JSON)
				;

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("{\"batchId\":10}", response.getContentAsString());
	}

	// utility method to convert objects to JSON
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
