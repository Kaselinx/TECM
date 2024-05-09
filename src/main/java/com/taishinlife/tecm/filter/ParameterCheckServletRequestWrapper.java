package com.taishinlife.tecm.filter;

import java.time.LocalDateTime;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ParameterCheckServletRequestWrapper extends HttpServletRequestWrapper {

	ParameterCheckServletRequestWrapper(HttpServletRequest request) {
		super(request);
		LocalDateTime now = LocalDateTime.now();
		log.info("Incoming Request at:" + now);
	}

}
