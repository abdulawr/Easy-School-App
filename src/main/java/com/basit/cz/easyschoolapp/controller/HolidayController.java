package com.basit.cz.easyschoolapp.controller;

import com.basit.cz.easyschoolapp.repository.HolidayRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.basit.cz.easyschoolapp.model.Holiday;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
public class HolidayController {

    @Autowired
    private HolidayRepository holidaysRepository;


    @GetMapping("/holidays")
    public String displayHolidays(Model model) {
        String display = "all";
        if(null != display && display.equals("all")){
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("federal")){
            model.addAttribute("federal",true);
        }else if(null != display && display.equals("festival")){
            model.addAttribute("festival",true);
        }

        Iterable<Holiday> holidays = holidaysRepository.findAll();
        List<Holiday> holidayList = StreamSupport
                .stream(holidays.spliterator(), false)
                .collect(Collectors.toList());

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            List<Holiday> filteredHolidays = holidayList.stream()
                    .filter(holiday -> holiday.getType().toString().equals(type.toString())) // Explicit string comparison
                    .collect(Collectors.toList());

            model.addAttribute(type.toString(), filteredHolidays);
        }

        return "holidays";
    }

}
