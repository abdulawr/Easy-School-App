package com.basit.cz.easyschoolapp.service;

import com.basit.cz.easyschoolapp.model.Holiday;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayService {


     public List<Holiday> filterHolidays(boolean festival, boolean federal) {

        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 1 ","New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ","Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ","Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ","Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ","Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ","Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ","Veterans Day", Holiday.Type.FEDERAL)
        );

        if (festival && !federal) {
            return holidays.stream()
                    .filter(holiday -> holiday.getType().equals(Holiday.Type.FESTIVAL))
                    .collect(Collectors.toList());
        } else if (!festival && federal) {
            return holidays.stream()
                    .filter(holiday -> holiday.getType().equals(Holiday.Type.FEDERAL))
                    .collect(Collectors.toList());
        }

        return holidays;
    }
}
