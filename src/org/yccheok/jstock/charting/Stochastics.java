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
public class Stochastics {

    public static class Period {
        public final int fastKPeriod;
        public final int slowKPeriod;
        public final int slowDPeriod;
        
        private Period(int fastKPeriod, int slowKPeriod, int slowDPeriod) {
            this.fastKPeriod = fastKPeriod;
            this.slowKPeriod = slowKPeriod;
            this.slowDPeriod = slowDPeriod; 
            //System.out.println("constructor: PPO Signal period: "+period);
        }
        
        public static Period newInstance(int fastKPeriod, int slowKPeriod, int slowDPeriod) {
            return new Period(fastKPeriod, slowKPeriod, slowDPeriod);
        }
        
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + fastKPeriod;
            result = 31 * result + slowKPeriod;
            result = 31 * result + slowDPeriod;            
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
            return this.fastKPeriod == _period.fastKPeriod && this.slowKPeriod == _period.slowKPeriod && this.slowDPeriod == _period.slowDPeriod;
        }        
    }
    
    public static class ChartResult {
        public final XYDataset outSlowK;
        public final XYDataset outSlowD;
        //public final XYDataset outPPOHist;
        
        private ChartResult(XYDataset outSlowK, XYDataset outSlowD/*, XYDataset outPPOHist*/) {
            this.outSlowK = outSlowK;
            this.outSlowD = outSlowD;
            //this.outPPOHist = outPPOHist;            
        }
        
        public static ChartResult newInstance(XYDataset outSlowK, XYDataset outSlowD/*, XYDataset outPPOHist*/) {
            return new ChartResult(outSlowK, outSlowD/*, outPPOHist*/);
        }
    }
    
    public static class TimeSeriesResult {
        public final TimeSeries outSlowK;
        public final TimeSeries outSlowD;
        //public final TimeSeries outPPOHist;
        
        private TimeSeriesResult(TimeSeries outSlowK, TimeSeries outSlowD/*, TimeSeries outPPOHist*/) {
            this.outSlowK = outSlowK;
            this.outSlowD = outSlowD;
            //this.outPPOHist = outPPOHist;            
        }
        
        public static TimeSeriesResult newInstance(TimeSeries outSlowK, TimeSeries outSlowD/*, TimeSeries outPPOHist*/) {
            return new TimeSeriesResult(outSlowK, outSlowD/*, outPPOHist*/);
        }
    }
    
    public static class Result {
        public final double outSlowK;
        public final double outSlowD;
        //public final double outPPOHist;
        
        private Result(double outSlowK, double outSlowD/*, double outPPOHist*/) {
            this.outSlowK = outSlowK;
            this.outSlowD = outSlowD;
            //this.outPPOHist = outPPOHist;
        }
        
        public static Result newInstance(double outSlowK, double outSlowD/*, double outPPOHist*/) {
            return new Result(outSlowK, outSlowD/*, outPPOHist*/);
        }
        
        @Override
        public int hashCode() {
            int result = 17;
            long _outSlowK = Double.doubleToLongBits(outSlowK);
            long _outSlowD = Double.doubleToLongBits(outSlowD);
            //long _outPPOHist = Double.doubleToLongBits(outPPOHist);
            result = 31 * result + (int)(_outSlowK ^ (_outSlowK >>> 32));
            result = 31 * result + (int)(_outSlowD ^ (_outSlowD >>> 32));
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
            return this.outSlowK == macdResult.outSlowK && this.outSlowD == macdResult.outSlowD/* && this.outPPOHist == macdResult.outPPOHist*/;
        }        
    }    
}
