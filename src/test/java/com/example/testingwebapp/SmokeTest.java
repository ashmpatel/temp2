package com.example.testingwebapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.testingwebapp.controller.DSAACController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private DSAACController dsaaacController;

	@Test
	public void dsaacControllerLoads() throws Exception {
		assertThat(dsaaacController).isNotNull();
	}
}
