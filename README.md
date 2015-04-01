# Java Chart Benchmark

The purpose of this repository is to compare plotting libraries available for Java, especially in terms of speed and handling larger amounts of data. Tested libraries are following (feel free to suggest missing ones):

  * [Gral](http://trac.erichseifert.de/gral/) - release 0.10
  * [XChart](http://xeiam.com/xchart/) - release 2.4.3
  * [JFreeChart](http://www.jfree.org/) - release 1.0.19

## Results

| Library  | scatter 1k   |  scatter 10k |
|----------|:------------:|-------------:|
| Gral     | 647ms/785ms  | 867ms/1028ms |
| JFree    | 409ms/480ms  |  471ms/522ms |
| XChart   |  50ms/253ms  |  103ms/313ms |
| JMathPlot| 450ms/507ms  |  459ms/532ms |

First time is measured after initilization of plotting class, second one after displaying whole `JFrame`. This times could be very different on different platforms (and versions of Java). Time measurement is not exact and might slightly differ each run, the goal is just to get a rough approximation of rendering speed.

## Charts

### Gral
[Source code](https://github.com/deric/java-chart-benchmark/blob/master/src/main/java/scatterplot1k/GralScatter.java)
Features:
  * allows zooming

![Grall scatterplot](https://raw.githubusercontent.com/deric/java-chart-benchmark/master/images/gral-scatter-1k.png)

### JFree

[Source code](https://github.com/deric/java-chart-benchmark/blob/master/src/main/java/scatterplot1k/JFreeScatter2.java)
![JFree scatterplot](https://raw.githubusercontent.com/deric/java-chart-benchmark/master/images/jfree-scatter-1k.png)


### XChart

[Source code](https://github.com/deric/java-chart-benchmark/blob/master/src/main/java/scatterplot1k/XChartScatter.java)
![XChart scatterplot](https://raw.githubusercontent.com/deric/java-chart-benchmark/master/images/xchart-scatter-1k.png)


### XChart

[Source code](https://github.com/deric/java-chart-benchmark/blob/master/src/main/java/scatterplot1k/JMathScatter.java)
![XChart scatterplot](https://raw.githubusercontent.com/deric/java-chart-benchmark/master/images/jmath-scatter-1k.png)


## System

Measured on Linux

 * Oracle Java 8 (1.8.0_40)
 * Intel i5 CPU 661 @ 3.33GHz (4 cores)
 * Linux (kernel 3.2.0-77)

