/*
 * JStock - Free Stock Market Software
 * Copyright (C) 2012 Yan Cheng CHEOK <yccheok@yahoo.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package org.yccheok.jstock.analysis;

import com.tictactec.ta.lib.Core;
import org.yccheok.jstock.charting.TechnicalAnalysis;
import org.yccheok.jstock.engine.*;

/**
 *
 * @author yccheok
 */
public class CandlePatternOperator extends AbstractOperator {
    
    public enum Function
    {
        Doji,
        DragonflyDoji,
        GravestoneDoji,
        HangingMan,
        Hammer,
        InvertedHammer,
        InvertedBlackHammer
    }
    
    public enum Type
    {
        PrevPrice,
        OpenPrice,
        HighPrice,
        LowPrice,
        LastPrice,
        TypicalPrice,
        Volume,
        MarketCapital,
        SharesIssued
    }
    
    /** Creates a new instance of StockHistoryOperator */
    public CandlePatternOperator() {
        day = 1;
        skipDay = 0;
        value = null;
        this.function = Function.Doji;
        this.type = Type.OpenPrice;
    }
    
    @Override
    protected Object calculate() {
        return value;
    }
    
    public int getDay() {
        return day;
    }
    
    public int getSkipDay() {
        return skipDay;
    }
    
    public void setDay(int day) {
        if (day < 0) return;

        int oldDay = this.day;
        this.day = day;

        if(oldDay != this.day) {
            this.firePropertyChange("attribute", oldDay + "d " + getSkipDayAsString(skipDay) + this.function + " " + this.type, this.day + "d " + getSkipDayAsString(skipDay) + this.function + " " + this.type);
        }
    }
    
    public void setSkipDay(int skipDay) {
        if (skipDay < 0) return;

        int oldSkipDay = this.skipDay;
        this.skipDay = skipDay;

        if(oldSkipDay != this.skipDay) {
            this.firePropertyChange("attribute", this.day + "d " + getSkipDayAsString(oldSkipDay) + this.function + " " + this.type, this.day + "d " + getSkipDayAsString(skipDay) + this.function + " " + this.type);
        }        
    }
    
    public void setFunction(Function function) {
        Function oldFunction = this.function;
        this.function = function;                
                
        if(Utils.equals(oldFunction, this.function) == false) {
            this.firePropertyChange("attribute", this.day + "d " + getSkipDayAsString(skipDay) + oldFunction + " " + this.type, this.day + "d " + getSkipDayAsString(skipDay) + this.function + " " + this.type);
        }         
        
    }
    
    public Function getFunction() {
        return this.function;
    }
    
    @Override
    public int getNumOfInputConnector() {
        return 0;
    }    
    
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        Type oldType = this.type;
        this.type = type;
                
        if(Utils.equals(oldType, this.type) == false) {
            this.firePropertyChange("attribute", this.day + "d " + getSkipDayAsString(skipDay) + this.function + " " + oldType, this.day + "d " + getSkipDayAsString(skipDay) + this.function + " " + this.type);
        }         
    }

    private double average(java.util.List<Double> values) {
        final int size = values.size();
        assert (size >= 0);
        Double sum = 0.0;
        for (Double v : values) {
            sum = sum + v;
        }
        return sum / size;
    }

    /**
     * Returns minimum history size which is required by this operator.
     * 
     * @return minimum history size which is required by this operator
     */
    public int getRequiredHistorySize() {
        
            return day+5;        
    }
    
    public void calculate(StockHistoryServer stockHistoryServer)
    {
        System.out.println("CandlePatternOperator.calculate(), line 154");
        if (day <= 0 || skipDay < 0) {
            Object oldValue = this.value;
            this.value = null;
            if (Utils.equals(oldValue, value) == false) {
                this.firePropertyChange("value", oldValue, this.value);
            }
            return;
        }

        java.util.List<Stock> stocks = new java.util.ArrayList<Stock>();
        //java.util.List<Double> values = new java.util.ArrayList<Double>();

        // For MFI usage.
        java.util.List<Double> opens = new java.util.ArrayList<Double>();
        java.util.List<Double> highs = new java.util.ArrayList<Double>();
        java.util.List<Double> lows = new java.util.ArrayList<Double>();
        java.util.List<Double> closes = new java.util.ArrayList<Double>();
        // TODO: CRITICAL LONG BUG REVISED NEEDED.
        java.util.List<Long> volumes = new java.util.ArrayList<Long>();

        final int size = stockHistoryServer.size();
        /* Fill up stocks. */
        final int start = Math.max(0, size - getRequiredHistorySize());

        for (int i = Math.max(0, start - skipDay), ei = Math.max(0, size - skipDay); i < ei; i++) {
            final long timestamp = stockHistoryServer.getTimestamp(i);
            final Stock stock = stockHistoryServer.getStock(timestamp);
            stocks.add(stock);
        }

        for (Stock stock : stocks) {
            opens.add(stock.getOpenPrice());
            highs.add(stock.getHighPrice());
            lows.add(stock.getLowPrice());
            closes.add(stock.getLastPrice());
            volumes.add(stock.getVolume());
        }

        final int dataSize = opens.size();
        System.out.println(dataSize);
        
        if (dataSize == 0) {
            Object oldValue = this.value;
            this.value = null;
            if (Utils.equals(oldValue, value) == false) {
                this.firePropertyChange("value", oldValue, this.value);
            }
            return;
        }

        // Do not use primitive. As we do not want to perform auto unboxing
        // on TechnicalAnalysis's returned value. It might be null.
        Boolean v = false;
        // Use tmp_v to prevent frequent boxing/unboxing operation.
        boolean tmp_v = v;
        
        switch(function)
        {
            case Doji:
                
                break;
                
            case DragonflyDoji:
                
                break;

            case GravestoneDoji:
                                          
                break;

            case HangingMan:
                
                break;

            case Hammer:
               
                break;

            case InvertedHammer:
               
                break;

            case InvertedBlackHammer:
                
                break;
                
            default:
                assert(false);
        }                 
        
        Object oldValue = this.value;
        
        this.value = v;
        
        if (Utils.equals(oldValue, value) == false) {
            this.firePropertyChange("value", oldValue, this.value);
        }
    }
    
    @Override
    public Class getInputClass(int index) {
        return null;
    }

    @Override
    public Class getOutputClass(int index) {
        return Boolean.class;
    }

    private String getSkipDayAsString(int skipDay) {
        if (skipDay <= 0) {
            return "";
        }
        return "(-"+skipDay+") ";
    }
    private Object value;
    private Function function;
    private Type type;    
    private int day;
    private int skipDay;
}

