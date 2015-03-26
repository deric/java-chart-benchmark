/*
 * Copyright 2015 deric.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package scatterplot1k;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author deric
 */
public class JFreeScatter2 extends ApplicationFrame {

    private int samplesCount;

    public JFreeScatter2(String title, int samplesCount) {
        super(title);
        this.samplesCount = samplesCount;
        JFreeChart chart = createChart(title, createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setMouseZoomable(false);
        this.add(panel);
    }

    private JFreeChart createChart(String title, XYDataset dataset) {
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
                title, "X", "Y", createDataset(),
                PlotOrientation.VERTICAL, true, true, false);
        //XYItemRenderer renderer = xyPlot.getRenderer();
        //renderer.setSeriesPaint(0, Color.blue);
        //NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
        //domain.setVerticalTickLabels(true);
        return jfreechart;
    }

    private XYDataset createDataset() {
        XYSeriesCollection result = new XYSeriesCollection();
        result.addSeries(populateData());
        return result;
    }

    private XYSeries populateData() {
        Random random = new Random();
        XYSeries series = new XYSeries("Gaussian");
        for (int i = 0; i < samplesCount; i++) {
            double x = random.nextGaussian() * 2.0;
            double y = random.nextGaussian() * 2.0;
            series.add(x, y);
        }
        return series;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        JFreeScatter2 demo = new JFreeScatter2("gaussian blob", 1000);
        long create = (System.currentTimeMillis() - start);
        System.out.println("jfree create = " + create + " ms");
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.pack();
        demo.setLocationRelativeTo(null);
        demo.setVisible(true);
        long end = (System.currentTimeMillis() - start);
        System.out.println("jfree show = " + end + " ms");
    }

}
