package com.streamAPIs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedCurrentTime = currentTime.format(customFormatter);
        System.out.println("Current Date and Time: " + formattedCurrentTime);

        // Time after 6 hours
        LocalDateTime timeAfter6Hours = currentTime.plusHours(6);
        String formattedTimeAfter6Hours = timeAfter6Hours.format(customFormatter);
        System.out.println("Time after 6 hours: " + formattedTimeAfter6Hours);

        // Time after 2 weeks
        LocalDateTime timeAfter2Weeks = currentTime.plusWeeks(2);
        String formattedTimeAfter2Weeks = timeAfter2Weeks.format(customFormatter);
        System.out.println("Time after 2 weeks: " + formattedTimeAfter2Weeks);

        // Time after 3 months
        LocalDateTime timeAfter3Months = currentTime.plusMonths(3);
        String formattedTimeAfter3Months = timeAfter3Months.format(customFormatter);
        System.out.println("Time after 3 months: " + formattedTimeAfter3Months);
    }
}
