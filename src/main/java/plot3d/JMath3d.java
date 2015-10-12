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
package plot3d;

import java.util.Random;
import javax.swing.JFrame;
import org.math.plot.Plot3DPanel;

/**
 *
 * @author deric
 */
public class JMath3d {

    public JMath3d() {
    }

    public static void main(String[] args) {
        plot(1000);
    }

    public static void plot(int sampleSize) {
        JMath3d plot = new JMath3d();
        long start = System.currentTimeMillis();
        Plot3DPanel chart = plot.getChart(sampleSize);
        long create = (System.currentTimeMillis() - start);
        System.out.println("jmath create = " + create + " ms");

        // put the PlotPanel in a JFrame like a JPanel
        JFrame frame = new JFrame("JMath 3D plot");
        frame.setSize(800, 600);
        frame.setContentPane(chart);
        frame.setVisible(true);

        long end = (System.currentTimeMillis() - start);
        System.out.println("jmath show = " + end + " ms");
    }

    public Plot3DPanel getChart(int size) {
        Plot3DPanel plot = new Plot3DPanel();
        Random random = new Random();

        double[] x = new double[size];
        double[] y = new double[size];
        double[] z = new double[size];

        for (int i = 0; i < size; i++) {
            x[i] = random.nextGaussian() * 2.0;
            y[i] = random.nextGaussian() * 2.0;
            z[i] = random.nextGaussian() * 2.0;
        }

        plot.addScatterPlot("gaussian data", x, y, z);
        return plot;
    }

}
