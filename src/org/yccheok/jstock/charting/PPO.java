/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yccheok.jstock.charting;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author jens
 */
public class PPO {

    public static class Period {
        public final int fastPeriod;
        public final int slowPeriod;
        public final int period;
        
        private Period(int fastPeriod, int slowPeriod, int period) {
            this.fastPeriod = fastPeriod;
            this.slowPeriod = slowPeriod;
            this.period = period; 
            System.out.println("constructor: PPO Signal period: "+period);
        }
        
        public static Period newInstance(int fastPeriod, int slowPeriod, int period) {
            return new Period(fastPeriod, slowPeriod, period);
        }
        
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + fastPeriod;
            result = 31 * result + slowPeriod;
            result = 31 * result + period;            
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof Period)) {
                return false;
            }

            Period _period = (Period)o;
            return this.fastPeriod == _period.fastPeriod && this.slowPeriod == _period.slowPeriod && this.period == _period.period;
        }        
    }
    
    public static class ChartResult {
        public final XYDataset outPPO;
        public final XYDataset outPPOSignal;
        public final XYDataset outPPOHist;
        
        private ChartResult(XYDataset outPPO, XYDataset outPPOSignal, XYDataset outPPOHist) {
            this.outPPO = outPPO;
            this.outPPOSignal = outPPOSignal;
            this.outPPOHist = outPPOHist;            
        }
        
        public static ChartResult newInstance(XYDataset outPPO, XYDataset outPPOSignal, XYDataset outPPOHist) {
            return new ChartResult(outPPO, outPPOSignal, outPPOHist);
        }
    }
    
    public static class TimeSeriesResult {
        public final TimeSeries outPPO;
        public final TimeSeries outPPOSignal;
        public final TimeSeries outPPOHist;
        
        private TimeSeriesResult(TimeSeries outPPO, TimeSeries outPPOSignal, TimeSeries outPPOHist) {
            this.outPPO = outPPO;
            this.outPPOSignal = outPPOSignal;
            this.outPPOHist = outPPOHist;            
        }
        
        public static TimeSeriesResult newInstance(TimeSeries outPPO, TimeSeries outPPOSignal, TimeSeries outPPOHist) {
            return new TimeSeriesResult(outPPO, outPPOSignal, outPPOHist);
        }
    }
    
    public static class Result {
        public final double outPPO;
        public final double outPPOSignal;
        public final double outPPOHist;
        
        private Result(double outPPO, double outPPOSignal, double outPPOHist) {
            this.outPPO = outPPO;
            this.outPPOSignal = outPPOSignal;
            this.outPPOHist = outPPOHist;
        }
        
        public static Result newInstance(double outPPO, double outPPOSignal, double outPPOHist) {
            return new Result(outPPO, outPPOSignal, outPPOHist);
        }
        
        @Override
        public int hashCode() {
            int result = 17;
            long _outPPO = Double.doubleToLongBits(outPPO);
            long _outPPOSignal = Double.doubleToLongBits(outPPOSignal);
            //long _outPPOHist = Double.doubleToLongBits(outPPOHist);
            result = 31 * result + (int)(_outPPO ^ (_outPPO >>> 32));
            result = 31 * result + (int)(_outPPOSignal ^ (_outPPOSignal >>> 32));
            //result = 31 * result + (int)(_outPPOHist ^ (_outPPOHist >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof Result)) {
                return false;
            }

            Result macdResult = (Result)o;
            return this.outPPO == macdResult.outPPO && this.outPPOSignal == macdResult.outPPOSignal/* && this.outPPOHist == macdResult.outPPOHist*/;
        }        
    }    
}
