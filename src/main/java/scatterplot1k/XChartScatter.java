/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scatterplot1k;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.StyleManager;
import com.xeiam.xchart.SwingWrapper;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author deric
 */
public class XChartScatter {

    private int sampleCount;

    public XChartScatter(int sampleCnt) {
        this.sampleCount = sampleCnt;
    }

    public static void main(String[] args) {
        XChartScatter scatter = new XChartScatter(1000);
        long start = System.currentTimeMillis();
        Chart chart = scatter.getChart();
        long create = (System.currentTimeMillis() - start);
        System.out.println("xchart create = " + create + " ms");
        new SwingWrapper(chart).displayChart();
        long end = (System.currentTimeMillis() - start);
        System.out.println("xchart show = " + end + " ms");
    }

    public Chart getChart() {

        Set<Double> xData = new HashSet<>();
        Set<Double> yData = new HashSet<>();
        Random random = new Random();
        int size = sampleCount;
        for (int i = 0; i < size; i++) {
            xData.add(random.nextGaussian() * 2.0);
            yData.add(random.nextGaussian() * 2.0);
        }

        // Create Chart
        Chart chart = new Chart(800, 600);
        chart.getStyleManager().setChartType(StyleManager.ChartType.Scatter);

        // Customize Chart
        chart.getStyleManager().setChartTitleVisible(false);
        chart.getStyleManager().setLegendPosition(StyleManager.LegendPosition.InsideSW);
        chart.getStyleManager().setMarkerSize(16);

        // Series
        chart.addSeries("Gaussian Blob", xData, yData);

        return chart;
    }

}
