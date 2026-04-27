package com.al.rangers.controller;

import java.net.http.HttpRequest;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.al.rangers.service.ISeasonFinderMgmtService;
@Controller
@RequestMapping("/season")
public class SeasonFinderController {

    @Autowired
    private ISeasonFinderMgmtService service;

    @GetMapping("/")
    public String showHomePage() {
        return "welcome";
    }

    @GetMapping("/current")
    public String showSeason(Map<String, Object> map) {
        String msg = service.findSeason();
        map.put("seasonName", msg);
        return "show_result";
    }

    @PostMapping("/months")
    public String findSeasonMonths(@RequestParam String seasonName,
                                   Map<String, Object> map) {

        String output = service.findMonthsRange(seasonName);
        map.put("seasonName", output);

        return "FindSeason";  // ⚠️ IMPORTANT
    }
}

// Ambiguous mapping. Cannot map 'seasonFinderController2' method  when 2 different controller have the same mapping and methodRequest.get and get or put and put.
// here we introduce the global path 