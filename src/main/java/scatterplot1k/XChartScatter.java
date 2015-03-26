/**
 * Copyright 2011 - 2015 Xeiam LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
