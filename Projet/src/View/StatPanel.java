
package View;

import Controller.StatController;
import Model.Order;
import Model.OrderedProduct;
import com.mysql.cj.conf.PropertyKey;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Shape;
import java.text.AttributedString;
import java.util.ArrayList;
import javax.swing.Renderer;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.util.Rotation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtils;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;


public class StatPanel extends javax.swing.JPanel
{
    private StatController controller;
    private int memory1;
    private int memory2;
    private int memory3;
    
    public StatPanel()
    {
        controller = new  StatController();
        initComponents();
        memory1 = jComboBox2.getSelectedIndex();
        memory2 = jComboBox3.getSelectedIndex();
        memory3 = jComboBox4.getSelectedIndex();
        set();
    }
    

    
    public void buildPieChart(String category)
    {
        PieDataset dataset = createPieDataset(category);
        
        JFreeChart chart = ChartFactory.createPieChart3D("", dataset);
        
        chart.setBackgroundPaint(new Color(54, 63, 73));
        chart.setBorderVisible(false);
        chart.setBorderPaint(new Color(54, 63, 73));
        chart.getLegend().setBackgroundPaint(new Color(54, 63, 73));
        
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setOutlineVisible(false);
        plot.setBackgroundAlpha(0f);
        plot.setDepthFactor(0.3);
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.8f);
        plot.setNoDataMessage("No data to display");
        
        plot.setLabelPaint(new Color(255,255,255));
        plot.setLabelLinkStyle(PieLabelLinkStyle.QUAD_CURVE);
        plot.setLabelLinkPaint(new Color(255, 255, 255));
        plot.setLabelBackgroundPaint(new Color(53,63,74));
        plot.setLabelShadowPaint(new Color(53,63,74));
        plot.setLabelOutlinePaint(new Color(53,63,74));
        
        chart.removeLegend();
        
        ChartPanel cp = new ChartPanel(chart);
        cp.setBackground(new Color(54, 63, 73));
        panelGraph1.add(cp, BorderLayout.CENTER);
        panelGraph1.validate();
    }
    
    public PieDataset createPieDataset(String category)
    {
        ArrayList<OrderedProduct> list = controller.getPieData(category);
       
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(int i=0 ; i < list.size() ; i++)
        {
            dataset.insertValue(0, list.get(i).getProductName(), list.get(i).getQuantity());
        }
        
        if(list.size() > 0)
            panelGraph1.setVisible(true);
        else
            panelGraph1.setVisible(false);
        
        return dataset;
    }
    
    
    
    public void buildAreaChart(int month1, int month2, int month3)
    {
        DefaultCategoryDataset dataset = createAreaDataset( month1, month2, month3);

        JFreeChart chart = ChartFactory.createAreaChart("", "x", "y", dataset);
        chart.setBackgroundPaint(new Color(54, 63, 73));
        chart.setBorderVisible(false);
        chart.setBorderPaint(new Color(54, 63, 73));
        chart.getCategoryPlot().setBackgroundPaint(new Color(54, 63, 73));
        chart.getCategoryPlot().setDomainGridlinePaint(new Color(54, 63, 73));
        //chart.getCategoryPlot().setRangeGridlinePaint(new Color(54, 63, 73));
        chart.getCategoryPlot().setDomainGridlinesVisible(true);
        chart.getCategoryPlot().setRangeGridlinesVisible(true);
        chart.getLegend().setBackgroundPaint(new Color(54, 63, 73));
        chart.getLegend().setItemPaint(new Color(255,255,255));

        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        ValueAxis valAxis = plot.getRangeAxis();
        
        valAxis.setLabel("Sales (€)");
        valAxis.setLabelPaint(new Color(255,255,255));
        valAxis.setTickMarkPaint(new Color(255,255,255));
        valAxis.setTickLabelPaint(new Color(255,255,255));
        
        domainAxis.setLabel("Days");
        domainAxis.setLabelPaint(new Color(255,255,255));
        domainAxis.setTickMarkPaint(new Color(255,255,255));
        domainAxis.setTickLabelPaint(new Color(255,255,255));
        
        plot.setOutlineVisible(false);
        plot.getRenderer().getClass().getCanonicalName();
        plot.setForegroundAlpha(0.4F);
        
        ChartPanel cp = new ChartPanel(chart);
        cp.setBackground(new Color(54, 63, 73));
        
        panelGraph.add(cp, BorderLayout.CENTER);
        panelGraph.validate();
    }
    
    public DefaultCategoryDataset createAreaDataset(int month1, int month2, int month3)
    {
        ArrayList<Order> listMonth1;
        ArrayList<Order> listMonth2;
        ArrayList<Order> listMonth3;
        
        String month1Name = controller.findMonth(month1);
        String month2Name = controller.findMonth(month2);
        String month3Name = controller.findMonth(month3);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        System.out.println("get orders");
        controller.getOrders();
        listMonth1 = controller.getAreaOrders(month1);
        listMonth2 = controller.getAreaOrders(month2);
        listMonth3 = controller.getAreaOrders(month3);
        System.out.println("finish");
        
        boolean présent=false;
        double total =0;
        
        if(listMonth1!=null)
            for(int i=1 ; i<=30 ; i++)
            {
                for(int j=0 ; j < listMonth1.size() ; j++)
                {
                    String date = listMonth1.get(j).getDate().toString();
                    String day = String.valueOf(date.charAt(date.length()-2)) + String.valueOf(date.charAt(date.length()-1));
                    if(day.charAt(0)=='0')
                        day=String.valueOf(date.charAt(date.length()-1));
                    
                    if(day.equals(String.valueOf(i)))
                    {
                        total += listMonth1.get(j).totalCost();
                        //dataset.addValue(listMonth1.get(j).totalCost(), month1Name, ""+ String.valueOf(i));
                        présent = true;
                    }
                }
                if(présent == false)
                    dataset.addValue(0, month1Name, ""+ String.valueOf(i));
                else
                    dataset.addValue(total, month1Name, ""+ String.valueOf(i));
                présent = false;
                total = 0;
            }
        total=0;
        if(listMonth2!=null)
            for(int i=1 ; i<=30 ; i++)
            {
                for(int j=0 ; j < listMonth2.size() ; j++)
                {
                    String date = listMonth2.get(j).getDate().toString();
                    String day = String.valueOf(date.charAt(date.length()-2)) + String.valueOf(date.charAt(date.length()-1));
                    if(day.charAt(0)=='0')
                        day=String.valueOf(date.charAt(date.length()-1));
                    
                    if(day.equals(String.valueOf(i)))
                    {
                        total += listMonth2.get(j).totalCost();
                        //dataset.addValue(listMonth2.get(j).totalCost(), month2Name, ""+ String.valueOf(i));
                        présent = true;
                    }
                }
                if(présent == false)
                    dataset.addValue(0, month2Name, ""+ String.valueOf(i));
                else
                    dataset.addValue(total, month2Name, ""+ String.valueOf(i));
                présent = false;
                total=0;
            }
        total=0;
        if(listMonth3!=null)
            for(int i=1 ; i<=30 ; i++)
            {
                for(int j=0 ; j < listMonth3.size() ; j++)
                {
                    String date = listMonth3.get(j).getDate().toString();
                    String day = String.valueOf(date.charAt(date.length()-2)) + String.valueOf(date.charAt(date.length()-1));
                    if(day.charAt(0)=='0')
                        day=String.valueOf(date.charAt(date.length()-1));
                    
                    if(day.equals(String.valueOf(i)))
                    {
                        total += listMonth3.get(j).totalCost();
                        //dataset.addValue(listMonth3.get(j).totalCost(), month3Name, ""+ String.valueOf(i));
                        présent = true;
                    }
                }
                if(présent == false)
                    dataset.addValue(0, month3Name, ""+ String.valueOf(i));
                else
                    dataset.addValue(total, month3Name, ""+ String.valueOf(i));
                présent = false;
                total=0;
            }
        
        return dataset;
    }
    
    public void updatePie(String category)
    {
        panelGraph1.removeAll();
        buildPieChart(category);
    }
    
    public void updateArea()
    {
        panelGraph.removeAll();
        buildAreaChart(jComboBox2.getSelectedIndex()+1,jComboBox3.getSelectedIndex()+1,jComboBox4.getSelectedIndex()+1);
    }
    
    public void update(String category)
    {
        panelGraph.removeAll();
        panelGraph1.removeAll();
        buildAreaChart(jComboBox2.getSelectedIndex()+1,jComboBox3.getSelectedIndex()+1,jComboBox4.getSelectedIndex()+1);
        buildPieChart(category);
    }
    
    public void setData()
    {
        String[] categories = controller.getCategories();
        if(categories!=null)
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(categories));
        update((String) jComboBox1.getItemAt(0));
    }
    
    public void set()
    {
        String[] categories = controller.getCategories();
        if(categories!=null)
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(categories));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelGraph = new javax.swing.JPanel();
        panelGraph1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(53, 63, 74));
        setMinimumSize(new java.awt.Dimension(1130, 650));
        setPreferredSize(new java.awt.Dimension(1130, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Category");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 310, 350, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Orders");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        panelGraph.setLayout(new java.awt.BorderLayout());
        add(panelGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 690, 200));

        panelGraph1.setLayout(new java.awt.BorderLayout());
        add(panelGraph1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 360, 220));

        jComboBox2.setBackground(new java.awt.Color(53, 63, 74));
        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox2.setSelectedIndex(9);
        jComboBox2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox2ActionPerformed(evt);
            }
        });
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 150, 40));

        jComboBox1.setBackground(new java.awt.Color(53, 63, 74));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 380, 220, 40));

        jComboBox3.setBackground(new java.awt.Color(53, 63, 74));
        jComboBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox3.setSelectedIndex(10);
        jComboBox3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox3ActionPerformed(evt);
            }
        });
        add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, 150, 40));

        jComboBox4.setBackground(new java.awt.Color(53, 63, 74));
        jComboBox4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox4.setSelectedIndex(11);
        jComboBox4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox4ActionPerformed(evt);
            }
        });
        add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, 150, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedIndex() >= 0)
        {
            jLabel2.setText((String) jComboBox1.getSelectedItem());
            updatePie((String) jComboBox1.getSelectedItem());
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox2ActionPerformed
    {//GEN-HEADEREND:event_jComboBox2ActionPerformed
        if (jComboBox2.getSelectedIndex() >= 0)
        {
            if(jComboBox2.getSelectedIndex() == jComboBox3.getSelectedIndex() || jComboBox2.getSelectedIndex() == jComboBox4.getSelectedIndex())
            {
                jComboBox2.setSelectedIndex(memory1);
            }
            memory1 = jComboBox2.getSelectedIndex();
            updateArea();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox3ActionPerformed
    {//GEN-HEADEREND:event_jComboBox3ActionPerformed
        if (jComboBox3.getSelectedIndex() >= 0)
        {
            if(jComboBox3.getSelectedIndex() == jComboBox2.getSelectedIndex() || jComboBox3.getSelectedIndex() == jComboBox4.getSelectedIndex())
            {
                jComboBox3.setSelectedIndex(memory2);
            }
            memory2 = jComboBox3.getSelectedIndex();
            updateArea();
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox4ActionPerformed
    {//GEN-HEADEREND:event_jComboBox4ActionPerformed
        if (jComboBox4.getSelectedIndex() >= 0)
        {
            if(jComboBox4.getSelectedIndex() == jComboBox2.getSelectedIndex() || jComboBox4.getSelectedIndex() == jComboBox3.getSelectedIndex())
            {
                jComboBox4.setSelectedIndex(memory3);
            }
            memory3 = jComboBox4.getSelectedIndex();
            updateArea();
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelGraph;
    private javax.swing.JPanel panelGraph1;
    // End of variables declaration//GEN-END:variables
}
