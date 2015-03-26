/*
 * GRAL: GRAphing Library for Java(R)
 *
 * (C) Copyright 2009-2015 Erich Seifert <dev[at]erichseifert.de>,
 * Michael Seifert <mseifert[at]error-reports.org>
 *
 * This file is part of GRAL.
 *
 * GRAL is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GRAL is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GRAL.  If not, see <http://www.gnu.org/licenses/>.
 */
package scatterplot1k;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.util.Insets2D;
import gral.ExamplePanel;
import java.awt.BorderLayout;
import java.util.Random;

/**
 *
 * @author deric
 */
public class GralScatter extends ExamplePanel {

    /**
     * Version id for serialization.
     */
    private static final long serialVersionUID = -412699430625953887L;

    private final int sampleCount = 1000;
    /**
     * Instance to generate random data values.
     */
    private static final Random random = new Random();

    @SuppressWarnings("unchecked")
    public GralScatter(int sampleCount) {
        DataTable data = new DataTable(Double.class, Double.class);
        for (int i = 0; i <= sampleCount; i++) {
            data.add(random.nextGaussian() * 2.0, random.nextGaussian() * 2.0);
        }

        // Create a new xy-plot
        XYPlot plot = new XYPlot(data);

        // Format plot
        plot.setInsets(new Insets2D.Double(20.0, 40.0, 40.0, 40.0));
        plot.getTitle().setText(getDescription());

        // Format points
        plot.getPointRenderer(data).setColor(COLOR1);

        // Add plot to Swing component
        add(new InteractivePanel(plot), BorderLayout.CENTER);
    }

    @Override
    public String getTitle() {
        return "Scatter plot";
    }

    @Override
    public String getDescription() {
        return String.format("Scatter plot with %d data points", sampleCount);
    }

    public static void plot(int sampleSize) {
        long start = System.currentTimeMillis();
        GralScatter gs = new GralScatter(sampleSize);
        long create = (System.currentTimeMillis() - start);
        System.out.println("gral create = " + create + " ms");
        gs.showInFrame();
        long end = (System.currentTimeMillis() - start);
        System.out.println("gral show = " + end + " ms");
    }

    public static void main(String[] args) {
        plot(1000);
    }

}
