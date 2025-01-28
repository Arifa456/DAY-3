package com.streamAPIs;

import java.util.*;
import java.util.stream.*;

class Staff {
    int staffId;
    String staffName;
    String team;
    double income;

    public Staff(int staffId, String staffName, String team, double income) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.team = team;
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", team='" + team + '\'' +
                ", income=" + income +
                '}';
    }
}

public class APIs {

    public static void main(String[] args) {
        List<Staff> staffList = Arrays.asList(
                new Staff(101, "Rahul", "Finance", 52000),
                new Staff(102, "Sneha", "Development", 58000),
                new Staff(103, "Aryan", "Development", 49000),
                new Staff(104, "Simran", "Sales", 45000),
                new Staff(105, "Rohit", "Finance", 60000),
                new Staff(106, "Ishika", "Development", 57000)
        );

        // 1. Find Staff with Highest Income
        staffList.stream()
                .max(Comparator.comparingDouble(s -> s.income))
                .ifPresent(s -> System.out.println("Staff with Highest Income: " + s));

        // 2. Filter Staff with Income Greater Than 5000
        System.out.println("Staff with Income > 5000:");
        staffList.stream()
                .filter(s -> s.income > 5000)
                .forEach(System.out::println);

        // 3. Get Staff Names and Incomes
        System.out.println("Staff Names and Incomes:");
        staffList.stream()
                .map(s -> s.staffName + " - " + s.income)
                .forEach(System.out::println);

        // 4. Count Staff
        long totalCount = staffList.stream().count();
        System.out.println("Total Staff: " + totalCount);

        // 5. Group Staff by Team
        System.out.println("Staff Grouped by Team:");
        Map<String, List<Staff>> groupByTeam = staffList.stream()
                .collect(Collectors.groupingBy(s -> s.team));
        groupByTeam.forEach((team, staffMembers) -> {
            System.out.println(team + ": " + staffMembers);
        });

        // 6. Calculate Average Income
        double avgIncome = staffList.stream()
                .mapToDouble(s -> s.income)
                .average()
                .orElse(0.0);
        System.out.println("Average Income: " + avgIncome);

        // 7. Sort Staff by Income
        System.out.println("Staff Sorted by Income:");
        staffList.stream()
                .sorted(Comparator.comparingDouble(s -> s.income))
                .forEach(System.out::println);

        // 8. Find Staff with Second Highest Income
        staffList.stream()
                .sorted(Comparator.comparingDouble(Staff::getIncome).reversed())
                .skip(1)
                .findFirst()
                .ifPresent(s -> System.out.println("Second Highest Income: " + s));

        // 9. Partition Staff by Income Threshold
        System.out.println("Partition Staff by Income > 5000:");
        Map<Boolean, List<Staff>> partitionByIncome = staffList.stream()
                .collect(Collectors.partitioningBy(s -> s.income > 5000));
        partitionByIncome.forEach((isAboveThreshold, staffMembers) -> {
            System.out.println((isAboveThreshold ? "Above" : "Below") + " 5000: " + staffMembers);
        });

        // 10. Find Staff with Longest Name
        staffList.stream()
                .max(Comparator.comparingInt(s -> s.staffName.length()))
                .ifPresent(s -> System.out.println("Staff with Longest Name: " + s));

        // 11. Group Staff by Team and Calculate Average Income
        System.out.println("Average Income by Team:");
        Map<String, Double> avgIncomeByTeam = staffList.stream()
                .collect(Collectors.groupingBy(
                        s -> s.team,
                        Collectors.averagingDouble(s -> s.income)));
        avgIncomeByTeam.forEach((team, averageIncome) -> {
            System.out.println(team + ": " + averageIncome);
        });

        // 12. Find Top 3 Highest Paid Staff
        System.out.println("Top 3 Highest Paid Staff:");
        staffList.stream()
                .sorted(Comparator.comparingDouble(Staff::getIncome).reversed())
                .limit(3)
                .forEach(System.out::println);

        // 13. Calculate Total Income of All Staff Using Reduce
        double totalIncome = staffList.stream()
                .map(Staff::getIncome)
                .reduce(0.0, Double::sum);
        System.out.println("Total Income of All Staff: " + totalIncome);
    }
}