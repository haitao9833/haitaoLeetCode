package GoF.Creational.SimpleFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ChartFactory {
    public static Chart getChart(String type) {
        Chart chart = null;
        if (type.equalsIgnoreCase("histogram")) {
            chart = new HistogramChart();
        } else if (type.equalsIgnoreCase("pie")) {
            chart = new PieChart();
        } else if (type.equalsIgnoreCase("line")) {
            chart = new LineChart();
        }
        return chart;
    }

    // 更简洁的工厂
    private static Map<String  , Supplier<Chart>> factoryMap = new HashMap<>(){
        {
            put("histogram" , HistogramChart::new);
            put("pie" , PieChart::new);
            put("line" , LineChart::new);
        }
    };
    public static Chart getChartByMap(String type) {
        return factoryMap.get(type.toLowerCase()).get();
    }
}
