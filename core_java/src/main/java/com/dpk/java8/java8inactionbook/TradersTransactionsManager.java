package com.dpk.java8.java8inactionbook;

import com.dpk.java8.java8inactionbook.model.Trader;
import com.dpk.java8.java8inactionbook.model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TradersTransactionsManager {

    private static List<Transaction> transactions;

    static {
        transactions = createTransaction();
    }

    public static List<Transaction> createTransaction() {
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

    /**
     * Find all transactions in the year 2011 and sort them by value (small to high).
     */
    public static List<Transaction> findTransactionsByYear() {
        return transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue)) // for asc order
               // .sorted((o1, o2) -> o2.getValue() - o1.getValue()) // for desc order
                .collect(Collectors.toList());
    }

    /**
     * What are all the unique cities where the traders work?
     */
    public static List<String> findUniqueOperationalCities() {
        return transactions.stream()
                .map(tx -> tx.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Find all traders from Cambridge and sort them by name
     */
    public static List<Trader> findTradersFromCambridge() {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equalsIgnoreCase("cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    /**
     * Return a string of all traders’ names sorted alphabetically.
     */
    public static String getAllTradersNames() {
        return transactions.stream()
                .map(tx -> tx.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
    }

    /**
     * Are any traders based in Milan?
     */
    public static boolean isAnyTradersFromMilan() {
        return transactions.stream()
                .anyMatch(tx -> tx.getTrader().getCity().equalsIgnoreCase("milan"));
    }

    /**
     * Print all transactions’ values from the traders living in Cambridge.
     */
    public static void totalTransactionValuesFromCambridge() {
        transactions.stream()
                .filter(tx -> tx.getTrader().getCity().equalsIgnoreCase("cambridge"))
                .mapToInt(Transaction::getValue)
                .forEach(System.out::println);
    }

    /**
     * What’s the highest value of all the transactions?
     */
    public static int highestTransactionValue() {
        return transactions.stream()
                .mapToInt(Transaction::getValue)
                .reduce(Integer::max).getAsInt();
    }

    /**
     * Find the transaction with the smallest value.
     */
    public static int smallestTransactionValue() {
        // Solution-1
        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .get().getValue();

        // Solution-2
        return transactions.stream()
                .mapToInt(Transaction::getValue)
                .min().getAsInt();
    }

    public static void main(String[] args) {
        List<Transaction> transactionList = findTransactionsByYear();

        List<String> uniqueCities = findUniqueOperationalCities();

        List<Trader> tradersFromCambridge = findTradersFromCambridge();

        String allTraders = getAllTradersNames();

        Boolean isAnyMilanTrader = isAnyTradersFromMilan();

        totalTransactionValuesFromCambridge();

        int highestTransaction = highestTransactionValue();

        int smallestTransaction = smallestTransactionValue();
    }
}
