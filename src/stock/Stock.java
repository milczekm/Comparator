package stock;

public class Stock implements Comparable<Stock> {
    private String name;
    private String symbol;
    private Double price;

    public Stock (String name, String symbol, Double price) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }

    public String getName () {
        return name;
    }

    public String getSymbol () {
        return symbol;
    }

    public Double getPrice () {
        return price;
    }

    @Override
    public String toString () {
        return "Stock{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo (Stock o) {
        int compareResult = Double.compare(this.getPrice(), o.getPrice());
        if (compareResult == 0) {
            compareResult = this.getName().compareToIgnoreCase(o.getName());
            if(compareResult == 0){
                compareResult = this.getSymbol().compareToIgnoreCase(o.getSymbol());
            }
        }
        return compareResult;
    }
}


