package stock;

import java.util.Comparator;

public class StockComparator implements Comparator<Stock> {
    @Override
    public int compare (Stock o1, Stock o2) {
        int compareResult = Double.compare(o1.getPrice(), o2.getPrice());
        if (compareResult == 0) {
            compareResult = o1.getName().compareToIgnoreCase(o2.getName());
            if(compareResult == 0){
                compareResult = o1.getSymbol().compareToIgnoreCase(o2.getSymbol());
            }
        }
        return compareResult;
    }
}
