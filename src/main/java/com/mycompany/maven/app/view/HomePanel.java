/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maven.app.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author mac
 */
public class HomePanel extends javax.swing.JPanel {
    
    /**
     * Creates new form DashboardPanel
     */
    public HomePanel() {
        initComponents();
        ChartPanel chartPanel = (ChartPanel) createPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        Chart.repaint();
        Chart.revalidate();
        Chart.add(chartPanel, java.awt.BorderLayout.CENTER);
        Chart.repaint();
        Chart.revalidate();
    }
    
     private static JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Statik Pengunjung",  // title
            "Tanggal",             // x-axis label
            "Jumlah Pengunjung",   // y-axis label
            dataset
        );

        chart.setBackgroundPaint(Color.WHITE);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setDefaultShapesVisible(true);
            renderer.setDefaultShapesFilled(true);
            renderer.setDrawSeriesLineAsPath(true);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

        return chart;

    }
    
    private static XYDataset createDataset() {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MMM");
        String dateNow = formatDate.format(dateTimeNow);
        
        TimeSeries s1 = new TimeSeries("Bulan " + dateNow);
        s1.add(new Month(2, 2001), 181.8);
        s1.add(new Month(3, 2001), 167.3);
        s1.add(new Month(4, 2001), 153.8);
        s1.add(new Month(5, 2001), 167.6);
        s1.add(new Month(6, 2001), 158.8);
        s1.add(new Month(7, 2001), 148.3);
        s1.add(new Month(8, 2001), 153.9);
        s1.add(new Month(9, 2001), 142.7);
        s1.add(new Month(10, 2001), 123.2);
        s1.add(new Month(11, 2001), 131.8);
        s1.add(new Month(12, 2001), 139.6);
        s1.add(new Month(1, 2002), 142.9);
        s1.add(new Month(2, 2002), 138.7);
        s1.add(new Month(3, 2002), 137.3);
        s1.add(new Month(4, 2002), 143.9);
        s1.add(new Month(5, 2002), 139.8);
        s1.add(new Month(6, 2002), 137.0);
        s1.add(new Month(7, 2002), 132.8);

//        TimeSeries s2 = new TimeSeries("L&G UK Index Trust");
//        s2.add(new Month(2, 2001), 129.6);
//        s2.add(new Month(3, 2001), 123.2);
//        s2.add(new Month(4, 2001), 117.2);
//        s2.add(new Month(5, 2001), 124.1);
//        s2.add(new Month(6, 2001), 122.6);
//        s2.add(new Month(7, 2001), 119.2);
//        s2.add(new Month(8, 2001), 116.5);
//        s2.add(new Month(9, 2001), 112.7);
//        s2.add(new Month(10, 2001), 101.5);
//        s2.add(new Month(11, 2001), 106.1);
//        s2.add(new Month(12, 2001), 110.3);
//        s2.add(new Month(1, 2002), 111.7);
//        s2.add(new Month(2, 2002), 111.0);
//        s2.add(new Month(3, 2002), 109.6);
//        s2.add(new Month(4, 2002), 113.2);
//        s2.add(new Month(5, 2002), 111.6);
//        s2.add(new Month(6, 2002), 108.8);
//        s2.add(new Month(7, 2002), 101.6);
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
//        dataset.addSeries(s2);

        return dataset;

    }
    public static JPanel createPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart, false);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        return panel;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        Main = new javax.swing.JPanel();
        Card = new javax.swing.JPanel();
        PasienCard = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15,15);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
            }
        };
        PasienCardTitle = new javax.swing.JLabel();
        PasienCardTotal = new javax.swing.JLabel();
        DokterCard = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15,15);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
            }
        };
        DokterCardTitle = new javax.swing.JLabel();
        DokterCardTotal = new javax.swing.JLabel();
        ObatCard = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15,15);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
            }
        };
        ObatCardTitle = new javax.swing.JLabel();
        ObatCardTotal = new javax.swing.JLabel();
        StockCard = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(15,15);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
            }
        };
        StockCardTitle = new javax.swing.JLabel();
        StockCardTotal = new javax.swing.JLabel();
        ChartBody = new javax.swing.JPanel();
        Chart = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(223, 230, 233));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new java.awt.BorderLayout(40, 0));

        titleLabel.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(99, 110, 114));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText("Home");
        titleLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        titleLabel.setPreferredSize(new java.awt.Dimension(34, 40));
        add(titleLabel, java.awt.BorderLayout.PAGE_START);

        Main.setBackground(new java.awt.Color(223, 230, 233));
        Main.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 0));
        Main.setLayout(new java.awt.BorderLayout());

        Card.setBackground(new java.awt.Color(223, 230, 233));
        Card.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 5));

        PasienCard.setBounds(10,10,100,30);
        PasienCard.setOpaque(false);
        PasienCard.setBackground(new java.awt.Color(255, 255, 255));
        PasienCard.setForeground(new java.awt.Color(255, 255, 255));
        PasienCard.setPreferredSize(new java.awt.Dimension(120, 100));
        PasienCard.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        PasienCardTitle.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        PasienCardTitle.setForeground(new java.awt.Color(159, 162, 180));
        PasienCardTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasienCardTitle.setText("Pasien");
        PasienCardTitle.setPreferredSize(new java.awt.Dimension(120, 16));
        PasienCard.add(PasienCardTitle);

        PasienCardTotal.setFont(new java.awt.Font("Mulish", 0, 36)); // NOI18N
        PasienCardTotal.setForeground(new java.awt.Color(37, 39, 51));
        PasienCardTotal.setText("60");
        PasienCard.add(PasienCardTotal);

        Card.add(PasienCard);

        PasienCard.setBounds(10,10,100,30);
        PasienCard.setOpaque(false);
        DokterCard.setBackground(new java.awt.Color(255, 255, 255));
        DokterCard.setForeground(new java.awt.Color(255, 255, 255));
        DokterCard.setPreferredSize(new java.awt.Dimension(120, 100));
        DokterCard.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        DokterCardTitle.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        DokterCardTitle.setForeground(new java.awt.Color(159, 162, 180));
        DokterCardTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DokterCardTitle.setText("Dokter");
        DokterCardTitle.setPreferredSize(new java.awt.Dimension(120, 16));
        DokterCard.add(DokterCardTitle);

        DokterCardTotal.setFont(new java.awt.Font("Mulish", 0, 36)); // NOI18N
        DokterCardTotal.setForeground(new java.awt.Color(37, 39, 51));
        DokterCardTotal.setText("60");
        DokterCard.add(DokterCardTotal);

        Card.add(DokterCard);

        PasienCard.setBounds(10,10,100,30);
        PasienCard.setOpaque(false);
        ObatCard.setBackground(new java.awt.Color(255, 255, 255));
        ObatCard.setForeground(new java.awt.Color(255, 255, 255));
        ObatCard.setPreferredSize(new java.awt.Dimension(120, 100));
        ObatCard.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        ObatCardTitle.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        ObatCardTitle.setForeground(new java.awt.Color(159, 162, 180));
        ObatCardTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ObatCardTitle.setText("Obat Terjual");
        ObatCardTitle.setPreferredSize(new java.awt.Dimension(120, 16));
        ObatCard.add(ObatCardTitle);

        ObatCardTotal.setFont(new java.awt.Font("Mulish", 0, 36)); // NOI18N
        ObatCardTotal.setForeground(new java.awt.Color(37, 39, 51));
        ObatCardTotal.setText("60");
        ObatCard.add(ObatCardTotal);

        Card.add(ObatCard);

        PasienCard.setBounds(10,10,100,30);
        PasienCard.setOpaque(false);
        StockCard.setBackground(new java.awt.Color(255, 255, 255));
        StockCard.setForeground(new java.awt.Color(255, 255, 255));
        StockCard.setPreferredSize(new java.awt.Dimension(120, 100));
        StockCard.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        StockCardTitle.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        StockCardTitle.setForeground(new java.awt.Color(159, 162, 180));
        StockCardTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StockCardTitle.setText("Stock Obat");
        StockCardTitle.setPreferredSize(new java.awt.Dimension(120, 16));
        StockCard.add(StockCardTitle);

        StockCardTotal.setFont(new java.awt.Font("Mulish", 0, 36)); // NOI18N
        StockCardTotal.setForeground(new java.awt.Color(37, 39, 51));
        StockCardTotal.setText("60");
        StockCard.add(StockCardTotal);

        Card.add(StockCard);

        Main.add(Card, java.awt.BorderLayout.PAGE_START);

        ChartBody.setBackground(new java.awt.Color(223, 230, 233));
        ChartBody.setPreferredSize(new java.awt.Dimension(400, 400));
        ChartBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Chart.setBackground(new java.awt.Color(255, 255, 255));
        Chart.setLayout(new java.awt.BorderLayout());
        ChartBody.add(Chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 520, 280));

        Main.add(ChartBody, java.awt.BorderLayout.CENTER);

        add(Main, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Card;
    private javax.swing.JPanel Chart;
    private javax.swing.JPanel ChartBody;
    private javax.swing.JPanel DokterCard;
    private javax.swing.JLabel DokterCardTitle;
    private javax.swing.JLabel DokterCardTotal;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel ObatCard;
    private javax.swing.JLabel ObatCardTitle;
    private javax.swing.JLabel ObatCardTotal;
    private javax.swing.JPanel PasienCard;
    private javax.swing.JLabel PasienCardTitle;
    private javax.swing.JLabel PasienCardTotal;
    private javax.swing.JPanel StockCard;
    private javax.swing.JLabel StockCardTitle;
    private javax.swing.JLabel StockCardTotal;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
