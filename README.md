# Java Chart Benchmark

The purpose of this repository is to compare plotting libraries available for Java, especially in terms of speed and handling larger amounts of data. Tested libraries are following (feel free to suggest missing ones):

  * [Gral](http://trac.erichseifert.de/gral/) - release 0.10
  * [XChart](http://xeiam.com/xchart/) - release 2.4.3
  * [JFreeChart](http://www.jfree.org/) - release 1.0.19

## Results

| Library  | scatter 1k   |  scatter 10k |
|----------|:------------:|-------------:|
| Gral     | 647ms/785ms  |              |
| JFree    | 409ms/480ms  |              |
| XChart   |  50ms/253ms  |              |

First time is measured after initilization of plotting class, second one after displaying whole `JFrame`. This times could be very different on different platforms (and versions of Java).

## Charts

## System

Measured on Linux

 * Oracle Java 8 (1.8.0_40)
 * Intel i5 CPU 661 @ 3.33GHz (4 cores)
 * Linux (kernel 3.2.0-77)

