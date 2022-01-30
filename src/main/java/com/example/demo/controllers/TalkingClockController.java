package com.example.demo.controllers;

import javax.validation.constraints.Max;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TalkingClock;
import com.example.demo.services.TalkingClockService;

@RestController
@RequestMapping("/api/v1/talkingclock")
@Validated
public class TalkingClockController {
	
	@Autowired
	TalkingClockService talkingClockService;

	// The function receives a GET request, processes it, and gives back a list of
	// TalkingClock as a response.
	@GetMapping(value = "/time/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TalkingClock> getTimeText(@RequestParam("hrs") @Max(24) Integer hrs,
			@RequestParam("mins") @Max(59) Integer mins) {
		return new ResponseEntity<>(talkingClockService.getTime(hrs, mins), HttpStatus.OK);
	}
}
