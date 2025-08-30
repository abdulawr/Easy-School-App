package com.basit.cz.easyschoolapp.controller;

import com.basit.cz.easyschoolapp.service.HolidayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.basit.cz.easyschoolapp.model.Holiday;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class HolidayController {

    private final HolidayService holidayService;

    @Autowired
    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/holidays")
    public String holidays(@RequestParam(required = false) boolean festival,
                           @RequestParam(required = false) boolean federal, Model model) {

        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);
        List<Holiday> filteredHolidays = holidayService.filterHolidays(festival, federal);

        // Group holidays by type
        for (Holiday.Type type : Holiday.Type.values()) {
            List<Holiday> holidaysByType = filteredHolidays.stream()
                    .filter(holiday -> holiday.getType().equals(type))
                    .collect(Collectors.toList());
            model.addAttribute(type.toString(), holidaysByType);
        }

        return "holidays";
    }
}
