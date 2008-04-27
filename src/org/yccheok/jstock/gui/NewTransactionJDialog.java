/*
 * NewTransactionJDialog.java
 *
 * Created on March 30, 2008, 6:31 AM
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * Copyright (C) 2008 Cheok YanCheng <yccheok@yahoo.com>
 */

package org.yccheok.jstock.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
import javax.swing.SwingUtilities;
import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yccheok.jstock.engine.SimpleDate;
import org.yccheok.jstock.engine.StockCodeAndSymbolDatabase;
import org.yccheok.jstock.portfolio.Broker;
import org.yccheok.jstock.portfolio.BrokingFirm;
import org.yccheok.jstock.portfolio.ClearingFee;
import org.yccheok.jstock.portfolio.Contract;
import org.yccheok.jstock.portfolio.SimpleBroker;
import org.yccheok.jstock.portfolio.SimpleClearingFee;
import org.yccheok.jstock.portfolio.SimpleStampDuty;
import org.yccheok.jstock.portfolio.StampDuty;
import org.yccheok.jstock.portfolio.Transaction;

/**
 *
 * @author  yccheok
 */
public class NewTransactionJDialog extends javax.swing.JDialog {
    /** Creates new form NewTransactionJDialog */
    public NewTransactionJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        if(shouldAutoCalculateBrokerFee())
        {
            this.jFormattedTextField3.setEditable(false);
            this.jFormattedTextField4.setEditable(false);
            this.jFormattedTextField5.setEditable(false);
        }
    }
    
    private boolean shouldAutoCalculateBrokerFee() {
        final JStockOptions jStockOptions = MainFrame.getJStockOptions();
        
        return 
                (jStockOptions.isAutoBrokerFeeCalculationEnabled()) && 
                (jStockOptions.getSelectedBrokingFirm() != null);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel3 = CalendarFactory.createDateField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextField1 = getCurrencyJFormattedTextField();
        jFormattedTextField2 = getCurrencyJFormattedTextField();
        jFormattedTextField3 = getCurrencyJFormattedTextField();
        jFormattedTextField4 = getCurrencyJFormattedTextField();
        jFormattedTextField5 = getCurrencyJFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jFormattedTextField6 = getCurrencyJFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new AutoCompleteJComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Transaction");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaction"));

        jTextField1.setEditable(false);

        jLabel2.setText("Symbol");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(1), null, Integer.valueOf(100)));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel4.setText("Date");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buy", "Sell" }));

        jLabel6.setText("Type");

        jFormattedTextField1.setValue(new Double(0.0));
        jFormattedTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusLost(evt);
            }
        });

        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setValue(new Double(0.0));

        jFormattedTextField3.setValue(new Double(0.0));
        jFormattedTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField3FocusLost(evt);
            }
        });

        jFormattedTextField4.setValue(new Double(0.0));
        jFormattedTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField4FocusLost(evt);
            }
        });

        jFormattedTextField5.setValue(new Double(0.0));
        jFormattedTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField5FocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setText("Net Value");

        jFormattedTextField6.setEditable(false);
        jFormattedTextField6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jFormattedTextField6.setValue(new Double(0.0));

        jLabel1.setText("Unit");

        jLabel3.setText("Price");

        jLabel5.setText("Value");

        jLabel7.setText("Broker");

        jLabel8.setText("Clearing Fee");

        jLabel9.setText("Stamp Duty");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/apply.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/button_cancel.png"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock"));

        jComboBox1.setEditable(true);
        jComboBox1.setPreferredSize(new java.awt.Dimension(110, 24));
        //this.jComboBox1.getEditor().getEditorComponent().addKeyListener(jComboBox1EditorComponentKeyAdapter);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.transaction = null;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void setTransaction(Transaction transaction) {
        final String symbol = transaction.getContract().getStock().getSymbol();
        final Date date = transaction.getContract().getDate().getCalendar().getTime();
        final int quantity = transaction.getContract().getQuantity();
        final double price = transaction.getContract().getPrice();
        final double value = transaction.getTotal();
        final double brokerFee = transaction.getCalculatedBroker();
        final double clearingFee = transaction.getCalculatdClearingFee();
        final double stampDuty = transaction.getCalculatedStampDuty();
        final double netValue = transaction.getNetTotal();
        
        this.jTextField1.setText(symbol);
        ((DateField)jPanel3).setValue(date);
        this.jSpinner1.setValue(quantity);
        this.jFormattedTextField1.setValue(price);
        this.jFormattedTextField2.setValue(value);
        this.jFormattedTextField3.setValue(brokerFee);
        this.jFormattedTextField4.setValue(clearingFee);
        this.jFormattedTextField5.setValue(stampDuty);
        this.jFormattedTextField6.setValue(netValue);
    }
    
    private Transaction generateTransaction() {
        MainFrame m = (MainFrame)NewTransactionJDialog.this.getParent();
                        
        if(m == null) return null;
                        
        final StockCodeAndSymbolDatabase stockCodeAndSymbolDatabase = m.getStockCodeAndSymbolDatabase();
        
        final String symbol = jTextField1.getText();
        final String code = stockCodeAndSymbolDatabase.symbolToCode(symbol);
        final DateField dateField = (DateField)jPanel3;
                
        Date date = (Date)dateField.getValue();
        
        Contract contract = new Contract(
            Utils.getEmptyStock(code, symbol), 
            new org.yccheok.jstock.engine.SimpleDate(date),
            Contract.Type.Buy, 
            ((java.lang.Integer)this.jSpinner1.getValue()), 
            (Double)this.jFormattedTextField1.getValue());
        
        Broker broker = null;
        StampDuty stampDuty = null;
        ClearingFee clearingFee = null;
        
        if(this.shouldAutoCalculateBrokerFee()) {
            final BrokingFirm brokingFirm = MainFrame.getJStockOptions().getSelectedBrokingFirm();
            broker = brokingFirm.getBroker();
            stampDuty = brokingFirm.getStampDuty();
            clearingFee = brokingFirm.getClearingFee();
        }
        else {
            final double brokerFeeValue = (Double)this.jFormattedTextField3.getValue();
            final double clearingFeeValue = (Double)this.jFormattedTextField4.getValue();
            final double stampDutyValue = (Double)jFormattedTextField5.getValue();
            
            broker = new SimpleBroker("SimpleBroker", Double.MAX_VALUE, brokerFeeValue, 0);
            /* We are limit to ourselves, that the fraction calculation, is based on contract's total. */
            stampDuty = new SimpleStampDuty("SimpleStampDuty", Double.MAX_VALUE, contract.getTotal(), stampDutyValue);
            clearingFee = new SimpleClearingFee("SimpleClearingfee", Double.MAX_VALUE, clearingFeeValue, 0);
        }
        
        Transaction t = new Transaction(contract, broker, stampDuty, clearingFee);

        return t;
    }
    
    private boolean isValidInput() {
        if(this.jTextField1.getText().length() <= 0)
        {
            this.jComboBox1.requestFocus();
            return false;
        }
        
        if(this.jFormattedTextField1.getText().length() <= 0) {
            this.jFormattedTextField1.requestFocus();
            return false;
        }

        if(this.jFormattedTextField2.getText().length() <= 0) {
            this.jFormattedTextField2.requestFocus();
            return false;
        }

        if(this.jFormattedTextField3.getText().length() <= 0) {
            this.jFormattedTextField3.requestFocus();
            return false;
        }

        if(this.jFormattedTextField4.getText().length() <= 0) {
            this.jFormattedTextField4.requestFocus();
            return false;
        }

        if(this.jFormattedTextField5.getText().length() <= 0) {
            this.jFormattedTextField5.requestFocus();
            return false;
        }

        if(this.jFormattedTextField6.getText().length() <= 0) {
            this.jFormattedTextField6.requestFocus();
            return false;
        }
        
        return true;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(isValidInput() == false) {
            return;
        }
        
        this.transaction = generateTransaction();
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void update() {
        
        if(shouldAutoCalculateBrokerFee())
        {
            final BrokingFirm brokingFirm = MainFrame.getJStockOptions().getSelectedBrokingFirm();
            
            SwingUtilities.invokeLater(new Runnable() { public void run() {
                final String name = jTextField1.getText();
                final int unit = (Integer)jSpinner1.getValue();
                final double price = (Double)jFormattedTextField1.getValue();
                final DateField dateField = (DateField)jPanel3;
                final Date date = (Date)dateField.getValue();
                // Stock and date information is not important at this moment.
                final Contract contract = new Contract(Utils.getEmptyStock(name, name), new SimpleDate(date), Contract.Type.Buy, unit, price);
                final double brokerFee = brokingFirm.brokerCalculate(contract);
                final double clearingFee = brokingFirm.clearingFeeCalculate(contract);
                final double stampDuty = brokingFirm.stampDutyCalculate(contract);
                jFormattedTextField3.setValue(brokerFee);
                jFormattedTextField4.setValue(clearingFee);
                jFormattedTextField5.setValue(stampDuty);
                jFormattedTextField2.setValue(price * (double)unit);                
                jFormattedTextField6.setValue(price * (double)unit + brokerFee + clearingFee + stampDuty);                
            }});
        }
        else {
            SwingUtilities.invokeLater(new Runnable() { public void run() {
                final int unit = (Integer)jSpinner1.getValue();
                final double price = (Double)jFormattedTextField1.getValue();
                final double brokerFee = (Double)jFormattedTextField3.getValue();
                final double clearingFee = (Double)jFormattedTextField4.getValue();
                final double stampDuty = (Double)jFormattedTextField5.getValue();
                jFormattedTextField2.setValue(price * (double)unit);                
                jFormattedTextField6.setValue(price * (double)unit + brokerFee + clearingFee + stampDuty);
            }});            
        }
    }
    
    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:  
        update();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jFormattedTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField1FocusLost
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_jFormattedTextField1FocusLost

    private void jFormattedTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField3FocusLost
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_jFormattedTextField3FocusLost

    private void jFormattedTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField4FocusLost
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_jFormattedTextField4FocusLost

    private void jFormattedTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField5FocusLost
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_jFormattedTextField5FocusLost
        
    private JFormattedTextField getCurrencyJFormattedTextField() {
        NumberFormat format= NumberFormat.getNumberInstance();
        NumberFormatter formatter= new NumberFormatter(format);
        formatter.setMinimum(0.0);
        formatter.setValueClass(Double.class);
        JFormattedTextField field= new JFormattedTextField(formatter);
        return field;
    }

    public void setPrice(double price) { 
        this.jFormattedTextField1.setValue(price);
        update();
    }
    
    public void setJComboBoxEnabled(boolean enable) {
        this.jComboBox1.setEnabled(enable);
    }
    
    public void setStockSymbol(String name) {
        this.jTextField1.setText(name);
    }
    
    public void setStockSelectionEnabled(boolean flag) {
        jComboBox1.setEnabled(flag);
    }
    
    public void setStockCodeAndSymbolDatabase(StockCodeAndSymbolDatabase stockCodeAndSymbolDatabase) {
        ((AutoCompleteJComboBox)jComboBox1).setStockCodeAndSymbolDatabase(stockCodeAndSymbolDatabase);
    }
    
    public void initjComboBox1EditorComponentKeyListerner() {
        KeyListener[] listeners = this.jComboBox1.getEditor().getEditorComponent().getKeyListeners();
        
        for(KeyListener listener : listeners) {
            if(listener == jComboBox1EditorComponentKeyAdapter) {
                return;
            }
        }
        
        // Bug in Java 6. Most probably this listener had been removed during look n feel updating, reassign!
        this.jComboBox1.getEditor().getEditorComponent().addKeyListener(jComboBox1EditorComponentKeyAdapter);
        log.info("Reassign key adapter to combo box");
    }
    
    public Transaction getTransaction() {
        return this.transaction;
    }
    
    private KeyAdapter getjComboBox1EditorComponentKeyAdapter() {
     
        return new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()) {

                    String stock = NewTransactionJDialog.this.jComboBox1.getEditor().getItem().toString();
                    
                    if(stock.length() > 0) {
                        MainFrame m = (MainFrame)NewTransactionJDialog.this.getParent();
                        
                        if(m == null) return;
                        
                        final StockCodeAndSymbolDatabase stockCodeAndSymbolDatabase = m.getStockCodeAndSymbolDatabase();
                        
                        String code = stockCodeAndSymbolDatabase.searchStockCode(stock);
                        String symbol = null;
                            
                        if(code != null) {
                            symbol = stockCodeAndSymbolDatabase.codeToSymbol(code);
                            
                        }
                        else {
                            symbol = stockCodeAndSymbolDatabase.searchStockSymbol(stock);
                                
                            if(symbol != null) {                                   
                                code = stockCodeAndSymbolDatabase.symbolToCode(symbol);

                            }
                        }
                        
                        NewTransactionJDialog.this.jTextField1.setText(symbol);
                    }   /* if(stock.length() > 0) */
                }   /* if(KeyEvent.VK_ENTER == e.getKeyCode()) */
                
            }   /* public void keyReleased(KeyEvent e) */
        };
    }
    
    private static final Log log = LogFactory.getLog(NewTransactionJDialog.class);
    
    private final KeyListener jComboBox1EditorComponentKeyAdapter = getjComboBox1EditorComponentKeyAdapter();
    
    private Transaction transaction = null;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JFormattedTextField jFormattedTextField6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}
