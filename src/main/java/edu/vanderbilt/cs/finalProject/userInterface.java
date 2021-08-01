package edu.vanderbilt.cs.finalProject;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.List;
import java.util.stream.Collectors;

import edu.vanderbilt.cs.finalProject.COVIDdata.DataFrame;

public class userInterface {
	
	JFrame frame;
	JPanel panel;
	JLabel lbl;
	JButton btn;
	COVIDdata data;
	final JComboBox<String> cb;
	dataChoiceHandler dcHandler = new dataChoiceHandler();
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	public static void main(String[] args) {
		new userInterface();
	}

	public userInterface() {
	    frame = new JFrame("COVID Data Plots");
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 700);
	    frame.setLocation(350, 50);
	    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

	    panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code
	    frame.add(panel);

	    
	    String[] choices = {"death","deathIncrease","hospitalizedCumulative","hospitalizedCurrently",
	    		"hospitalizedIncrease","inIcuCumulative","inIcuCurrently","negative","negativeIncrease",
	    		"onVentilatorCurrently","onVentilatorCumulative","pending","positive","positiveIncrease",
	    		"totalTestResults","totalTestResultsIncrease"};

	    cb = new JComboBox<String>(choices);

	    cb.setMaximumSize(cb.getPreferredSize());
	    cb.setAlignmentX(Component.CENTER_ALIGNMENT);
	    panel.add(cb);

	    btn = new JButton("PLOT");
	    btn.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btn.addActionListener(dcHandler);
	    panel.add(btn);

	    frame.setVisible(true);

	}
	
	public class dataChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			data = loadData();
			String selectedData = (String) cb.getSelectedItem();
			
			TimeSeriesCollection dataset = new TimeSeriesCollection();
			dataset.removeAllSeries();
			List<DataFrame> tmp = data.fusedFramesStream().collect(Collectors.toList());
			switch (selectedData) {
			case "positive":
				TimeSeries positiveSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					positiveSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getPositive());
				}
				dataset.addSeries(positiveSeries);
				break;
			case "negative":
				TimeSeries negativeSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					negativeSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getNegative());
				}
				dataset.addSeries(negativeSeries);
				break;
			case "pending":
				TimeSeries pendingSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					pendingSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getPending());
				}
				dataset.addSeries(pendingSeries);
				break;
			case "hospitalizedCurrently":
				TimeSeries hospitalizedCurrentlySeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					hospitalizedCurrentlySeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getHospitalizedCurrently());
				}
				dataset.addSeries(hospitalizedCurrentlySeries);
				break;
			case "hospitalizedCumulative":
				TimeSeries hospitalizedCumulativeSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					hospitalizedCumulativeSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getHospitalizedCumulative());
				}
				dataset.addSeries(hospitalizedCumulativeSeries);
				break;
			case "inIcuCurrently":
				TimeSeries inIcuCurrentlySeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					inIcuCurrentlySeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getInIcuCurrently());
				}
				dataset.addSeries(inIcuCurrentlySeries);
				break;
			case "inIcuCumulative":
				TimeSeries inIcuCumulativeSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					inIcuCumulativeSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getInIcuCumulative());
				}
				dataset.addSeries(inIcuCumulativeSeries);
				break;
			case "onVentilatorCurrently":
				TimeSeries onVentilatorCurrentlySeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					onVentilatorCurrentlySeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getOnVentilatorCurrently());
				}
				dataset.addSeries(onVentilatorCurrentlySeries);
				break;
			case "onVentilatorCumulative":
				TimeSeries onVentilatorCumulativeSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					onVentilatorCumulativeSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getOnVentilatorCumulative());
				}
				dataset.addSeries(onVentilatorCumulativeSeries);
				break;
			case "death":
				TimeSeries deathSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					deathSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getDeath());
				}
				dataset.addSeries(deathSeries);
				break;
			case "totalTestResults":
				TimeSeries totalTestResultsSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					totalTestResultsSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getTotalTestResults());
				}
				dataset.addSeries(totalTestResultsSeries);
				break;
			case "deathIncrease":
				TimeSeries deathIncreaseSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					deathIncreaseSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getDeathIncrease());
				}
				dataset.addSeries(deathIncreaseSeries);
				break;
			case "hospitalizedIncrease":
				TimeSeries hospitalizedIncreaseSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					hospitalizedIncreaseSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getHospitalizedIncrease());
				}
				dataset.addSeries(hospitalizedIncreaseSeries);
				break;
			case "negativeIncrease":
				TimeSeries negativeIncreaseSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					negativeIncreaseSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getNegativeIncrease());
				}
				dataset.addSeries(negativeIncreaseSeries);
				break;
			case "positiveIncrease":
				TimeSeries positiveIncreaseSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					positiveIncreaseSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getPositiveIncrease());
				}
				dataset.addSeries(positiveIncreaseSeries);
				break;
			case "totalTestResultsIncrease":
				TimeSeries totalTestResultsIncreaseSeries = new TimeSeries(selectedData);
				for (int i = 0; i < data.fusedFramesStream().count(); i++) {
					totalTestResultsIncreaseSeries.addOrUpdate(setDay(tmp.get(i).getDate()),tmp.get(i).getTotalTestResultsIncrease());
				}
				dataset.addSeries(totalTestResultsIncreaseSeries);
				break;
			}
			
			JFreeChart chart = ChartFactory.createTimeSeriesChart(
			        "COVID Data for April 2020 - March 2021", // Chart
			        "Date", // X-Axis Label
			        selectedData, // Y-Axis Label
			        dataset);
			removePlot();
			panel.add(new ChartPanel(chart));

		}
	}
	
	public void removePlot() {
		//Get the components in the panel
		Component[] componentList = panel.getComponents();

		//Loop through the components
		for(Component c : componentList){

		    //Find the components you want to remove
		    if(c instanceof ChartPanel){

		        //Remove it
		        panel.remove(c);
		    }
		}

		//IMPORTANT
		panel.revalidate();
		panel.repaint();
	}
	
	public Day setDay(String stringDate) {
		int day = Integer.parseInt(stringDate.substring(6,8));
		int month = Integer.parseInt(stringDate.substring(4,6));
		int year = Integer.parseInt(stringDate.substring(0, 4));
		Day formatedDay = new Day(day,month,year);
		return formatedDay;
	}
	
	public static COVIDdata loadData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new FileInputStream("src/main/resources/covidData.json"), COVIDdata.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

