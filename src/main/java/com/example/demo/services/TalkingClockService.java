package com.example.demo.services;

import com.example.demo.model.TalkingClock;

public interface TalkingClockService {

	TalkingClock getTime(Integer hrs, Integer mins);
}
