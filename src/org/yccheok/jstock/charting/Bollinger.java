/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yccheok.jstock.charting;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author jens
 */

public class Bollinger {
    public static class ChartResult {
        public final XYDataset bollingerCentral;
        public final XYDataset bollinger1Up;
        public final XYDataset bollinger1Down;
        public final XYDataset bollinger2Up;
        public final XYDataset bollinger2Down;
        
        private ChartResult(XYDataset bollingerCentral, XYDataset bollinger1Up, XYDataset bollinger1Down, XYDataset bollinger2Up, XYDataset bollinger2Down) {
            this.bollingerCentral = bollingerCentral;
            this.bollinger1Up = bollinger1Up;
            this.bollinger1Down = bollinger1Down;
            this.bollinger2Up = bollinger2Up;
            this.bollinger2Down = bollinger2Down;
        }
        
        public static ChartResult newInstance(XYDataset bollingerCentral, XYDataset bollinger1Up, XYDataset bollinger1Down, XYDataset bollinger2Up, XYDataset bollinger2Down) {
            return new ChartResult(bollingerCentral, bollinger1Up, bollinger1Down, bollinger2Up, bollinger2Down);
        }
    }
    
    public static class TimeSeriesResult {
        public final TimeSeries bollingerCentral;
        public final TimeSeries bollinger1Up;
        public final TimeSeries bollinger1Down;
        public final TimeSeries bollinger2Up;
        public final TimeSeries bollinger2Down;
        
        private TimeSeriesResult(TimeSeries bollingerCentral, TimeSeries bollinger1Up, TimeSeries bollinger1Down, TimeSeries bollinger2Up, TimeSeries bollinger2Down) {
            this.bollingerCentral = bollingerCentral;
            this.bollinger1Up = bollinger1Up;
            this.bollinger1Down = bollinger1Down;
            this.bollinger2Up = bollinger2Up;
            this.bollinger2Down = bollinger2Down;
        }
        
        public static TimeSeriesResult newInstance(TimeSeries bollingerCentral, TimeSeries bollinger1Up, TimeSeries bollinger1Down, TimeSeries bollinger2Up, TimeSeries bollinger2Down) {
            return new TimeSeriesResult(bollingerCentral, bollinger1Up, bollinger1Down, bollinger2Up, bollinger2Down);
        }
    }
    
    /*public ChartResult BBTimeSeries2Chart(TimeSeriesResult src) {
        return Bollinger.TimeSeriesResult.TimeSeriesResult(new TimeSeriesCollection(src.bollingerCentral), new TimeSeriesCollection(src.bollinger1Up), new TimeSeriesCollection(src.bollinger1Down), new TimeSeriesCollection(src.bollinger2Up), new TimeSeriesCollection(src.bollinger2Down));
    }*/
    
    public static class Result {
        public final double bollingerCentral;
        public final double bollinger1Up;
        public final double bollinger1Down;
        public final double bollinger2Up;
        public final double bollinger2Down;
        
        private Result(double bollingerCentral, double bollinger1Up, double bollinger1Down, double bollinger2Up, double bollinger2Down) {
            this.bollingerCentral = bollingerCentral;
            this.bollinger1Up = bollinger1Up;
            this.bollinger1Down = bollinger1Down;
            this.bollinger2Up = bollinger2Up;
            this.bollinger2Down = bollinger2Down;
        }
        
        public static Result newInstance(double bollingerCentral, double bollinger1Up, double bollinger1Down, double bollinger2Up, double bollinger2Down) {
            return new Result(bollingerCentral, bollinger1Up, bollinger1Down, bollinger2Up, bollinger2Down);
        }
        
        @Override
        public int hashCode() {
            int result = 17;
            long _bollingerCentral = Double.doubleToLongBits(bollingerCentral);
            long _bollinger1Up = Double.doubleToLongBits(bollinger1Up);
            long _bollinger1Down = Double.doubleToLongBits(bollinger1Down);
            long _bollinger2Up = Double.doubleToLongBits(bollinger2Up);
            long _bollinger2Down = Double.doubleToLongBits(bollinger2Down);
            result = 31 * result + (int)(_bollingerCentral ^ (_bollingerCentral >>> 32));
            result = 31 * result + (int)(_bollinger1Up ^ (_bollinger1Up >>> 32));
            result = 31 * result + (int)(_bollinger1Down ^ (_bollinger1Down >>> 32));
            result = 31 * result + (int)(_bollinger2Up ^ (_bollinger2Up >>> 32));
            result = 31 * result + (int)(_bollinger2Down ^ (_bollinger2Down >>> 32));
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

            Result bollResult = (Result)o;
            return this.bollingerCentral == bollResult.bollingerCentral && this.bollinger1Up == bollResult.bollinger1Up && this.bollinger1Down == bollResult.bollinger1Down && this.bollinger2Up == bollResult.bollinger2Up && this.bollinger2Down == bollResult.bollinger2Down;
        }        
    }
}
