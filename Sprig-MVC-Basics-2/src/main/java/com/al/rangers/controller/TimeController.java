package com.al.rangers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TimeController {

    @GetMapping("/time")
    public String getTime(Model model) {

        LocalDateTime now = LocalDateTime.now();

        String time = now.format(DateTimeFormatter.ofPattern("HH : mm : ss"));
        String date = now.format(DateTimeFormatter.ofPattern("dd"));
        String month = now.format(DateTimeFormatter.ofPattern("MMMM"));

        // sending data to HTML
        model.addAttribute("time", time);
        model.addAttribute("date", date);
        model.addAttribute("month", month);

        return "time";  // 👉 time.html
    }
}