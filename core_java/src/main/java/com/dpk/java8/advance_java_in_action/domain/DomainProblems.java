package com.dpk.java8.advance_java_in_action.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DomainProblems {
    public static List<Transaction>getTransactionsIn2011() {
        List<Transaction> transactions = getTransactions().stream().filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue)).toList();
        return transactions;
    }

    public static List<String> getUniqueCities() {
        List<String> cities = getTransactions().stream().map(t -> t.getTrader().getCity()).distinct().toList();
        return cities;
    }

    public static List<String> getTradersFromCambridge() {
        List<String> traders = getTransactions().stream()
                .filter(t -> "Cambridge".equalsIgnoreCase(t.getTrader().getCity()))
                .map(t -> t.getTrader().getName()).sorted().toList();
        return traders;
    }

    public static String getAllTraders() {
        String traders = getTransactions().stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted().collect(Collectors.joining(","));
        return traders;
    }

    public static boolean anyTraderFromMilan() {
        boolean traderFromMilan = getTransactions().stream()
                .anyMatch(t -> "Milan".equalsIgnoreCase(t.getTrader().getCity()));
        return traderFromMilan;
    }

    public static void transactionsValueFromTraderInCambridge() {
        getTransactions().stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    public static void highestTransaction() {
        int maxTransaction = getTransactions().stream().max(Comparator.comparingInt(Transaction::getValue)).map(Transaction::getValue).orElse(0);
        System.out.println("Highest Transaction value = " + maxTransaction);
    }

    public static void lowestTransaction() {
        int minTransaction = getTransactions().stream().min(Comparator.comparingInt(Transaction::getValue)).map(Transaction::getValue).orElse(0);
        System.out.println("Lowest Transaction value = " + minTransaction);
    }


    public static void main(String[] args) {
        getTransactionsIn2011();
        getUniqueCities();
        getTradersFromCambridge();
        getAllTraders();
        anyTraderFromMilan();
        transactionsValueFromTraderInCambridge();
        highestTransaction();
        lowestTransaction();
    }

    public static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }
}
