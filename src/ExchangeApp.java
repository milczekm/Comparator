import stock.Stock;
import stock.StockComparator;

import java.util.*;
import java.util.stream.Collectors;

public class ExchangeApp {
    public static void main (String[] args) {
        List<Integer> prices = Arrays.asList(1, 4, 56, 59, 555, 89, 41, 7, 22);
        System.out.println("Nieposortowane: " + prices);

        Collections.sort(prices);

        System.out.println("Posortowane rosnąco: " + prices);

        Collections.reverse(prices);

        System.out.println("Posortowane malejąco: " + prices);

        System.out.println("-------------------------------------------------");

        Stock stock1 = new Stock("cd projekt blue", "cdp", 5.23);
        Stock stock2 = new Stock("amazon", "amz", 5.23);
        Stock stock3 = new Stock("amazon", "aat", 5.23);
        Stock stock4 = new Stock("google", "ggl", 7.08);
        Stock stock5 = new Stock("apple", "apl", 7.08);

        List<Stock> stockList = Arrays.asList(stock1, stock2, stock3, stock4, stock5);

        Collections.sort(stockList);

        stockList.forEach(System.out::println);

        System.out.println("COMPARATOR -----------------------------------------");

        Collections.sort(stockList, new StockComparator());

        stockList.forEach(System.out::println);

        System.out.println("ANONYMOUS INNER CLASS --------------------------------");

        Comparator<Stock> stockComparator = (o1, o2) -> {
            int compareResult = Double.compare(o1.getPrice(), o2.getPrice());
            if (compareResult == 0) {
                compareResult = o1.getName().compareToIgnoreCase(o2.getName());
                if(compareResult == 0){
                    compareResult = o1.getSymbol().compareToIgnoreCase(o2.getSymbol());
                }
            }
            return compareResult;
        };

        Collections.sort(stockList, stockComparator);

        stockList.forEach(System.out::println);

        System.out.println("STREAM -------------------------------------------------");

        List<Stock> stockStream = stockList.stream().
                sorted(stockComparator).
                collect(Collectors.toList());

        stockStream.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        stockList.sort(stockComparator);

        stockList.forEach(System.out::println);

        System.out.println("TREESET -----------------------------------------------");

        TreeSet<Stock> stockTreeSet = new TreeSet<>(stockComparator);

        stockTreeSet.add(stock1);
        stockTreeSet.add(stock2);
        stockTreeSet.add(stock3);
        stockTreeSet.add(stock4);
        stockTreeSet.add(stock5);

        stockTreeSet.forEach(System.out::println);

        System.out.println("TREEMAP -----------------------------------------------");

        TreeMap<Stock, String> stockStringTreeMap = new TreeMap<>(stockComparator);

        stockStringTreeMap.put(stock1, "stock 1");
        stockStringTreeMap.put(stock2, "stock 2");
        stockStringTreeMap.put(stock3, "stock 3");
        stockStringTreeMap.put(stock4, "stock 4");
        stockStringTreeMap.put(stock5, "stock 5");

        stockStringTreeMap.keySet().forEach(System.out::println);
    }

}


