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

import java.awt.RenderingHints;
import java.util.Random;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author deric
 */
public class JFreeScatter extends ApplicationFrame {

    /**
     * The data.
     */
    private float[][] data;

    private int sampleCount;

    /**
     * Creates a new fast scatter plot demo.
     *
     * @param title      the frame title.
     * @param sampleSize
     */
    public JFreeScatter(final String title, int sampleSize) {
        super(title);
        this.sampleCount = sampleSize;

        data = new float[2][sampleSize];
        populateData();
        final NumberAxis domainAxis = new NumberAxis("X");
        domainAxis.setAutoRangeIncludesZero(false);
        final NumberAxis rangeAxis = new NumberAxis("Y");
        rangeAxis.setAutoRangeIncludesZero(false);
        final FastScatterPlot plot = new FastScatterPlot(this.data, domainAxis, rangeAxis);
        final JFreeChart chart = new JFreeChart("Fast Scatter Plot", plot);
//        chart.setLegend(null);

        // force aliasing of the rendered content..
        chart.getRenderingHints().put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        final ChartPanel panel = new ChartPanel(chart, true);
        panel.setPreferredSize(new java.awt.Dimension(800, 600));
        //      panel.setHorizontalZoom(true);
        //    panel.setVerticalZoom(true);
        panel.setMinimumDrawHeight(10);
        panel.setMaximumDrawHeight(2000);
        panel.setMinimumDrawWidth(20);
        panel.setMaximumDrawWidth(2000);

        setContentPane(panel);

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    *
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    /**
     * Populates the data array with random values.
     */
    private void populateData() {
        Random random = new Random();

        for (int i = 0; i < this.data[0].length; i++) {
            this.data[0][i] = (float) (random.nextGaussian() * 2.0);
            this.data[1][i] = (float) (random.nextGaussian() * 2.0);
        }
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(final String[] args) {
        long start = System.currentTimeMillis();
        final JFreeScatter demo = new JFreeScatter("JFreeChart Scatter Plot - 1k", 1000);
        long create = (System.currentTimeMillis() - start);
        System.out.println("jfree create = " + create + " ms");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        long end = (System.currentTimeMillis() - start);
        System.out.println("jfree show = " + end + " ms");

    }

}
