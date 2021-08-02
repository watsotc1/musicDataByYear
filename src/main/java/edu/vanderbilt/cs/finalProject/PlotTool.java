package edu.vanderbilt.cs.finalProject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.vanderbilt.cs.finalProject.MusicByYearData.DataFrame;

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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlotTool {
	
	JFrame frame;
	JPanel plotPanel,infoPanel;
	JLabel choiceLbl, windowLbl;
	JButton plotBtn;
	JTextArea dataInfo;
	JTextField windowInput;
	MusicByYearData data;
	final JComboBox<String> cb;
	dataChoiceHandler dcHandler = new dataChoiceHandler();
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	public static void main(String[] args) {
		new PlotTool();
	}

	public PlotTool() {
		//Set Theme 
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available carry on with basic type
		}
		
		//Initialize Frame
		frame = new JFrame("Spotify Music Data Plotting Tool");
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 700);
	    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

	    //Initialize Panel
	    plotPanel = new JPanel();
	    plotPanel.setLayout(new BoxLayout(plotPanel, BoxLayout.Y_AXIS));
	    frame.add(plotPanel);

	    choiceLbl = new JLabel("Select Data:");
	    choiceLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    plotPanel.add(choiceLbl);
	    
	    //Initialize User Selection Tool
	    String[] choices = {"Mode","Acousticness","Danceability",
	    		"Duration","Energy","Instrumentalness","Liveness","Loudness",
	    		"Speechiness","Tempo","Valence","Popularity","Key"};

	    cb = new JComboBox<String>(choices);

	    cb.setMaximumSize(cb.getPreferredSize());
	    cb.setAlignmentX(Component.CENTER_ALIGNMENT);
	    plotPanel.add(cb);
	    
	    windowLbl = new JLabel("Select Time Frame (YYYY-YYYY): ");
	    windowLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    plotPanel.add(windowLbl);
	    
	    //Initialize Window Input
	    windowInput = new JTextField("1921-2020",3);
	    windowInput.setAlignmentX(Component.CENTER_ALIGNMENT);
	    windowInput.setMaximumSize(new Dimension(75,30));
	    plotPanel.add(windowInput);
	    

	    //Initialize Plot Button
	    plotBtn = new JButton("PLOT");
	    plotBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
	    plotBtn.addActionListener(dcHandler);
	    plotPanel.add(plotBtn);

	    frame.setVisible(true);

	}
	
	public class dataChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			//Load and Properly Store Data
			data = loadData();
			List<DataFrame> tmp = data.fusedFramesStream().collect(Collectors.toList());
			
			//Get sublist if specified
			if (!windowInput.getText().equals("1921-2020")) {
				tmp = MusicByYearStats.slidingWindow(tmp, windowInput.getText());
			}
			
			//Load Data Info
			Map<String, String> musicDataInfo = setMusicInfo();
			
			//Call User Selection 
			String selectedData = (String) cb.getSelectedItem();
			
			//Initialize Time Series
			TimeSeriesCollection dataset = new TimeSeriesCollection();
			TimeSeries series = new TimeSeries(selectedData);
			
			//Gather Series Data according to User Input
			switch (selectedData) {
			case "Mode":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getMode());
				}
				break;
			case "Key":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getKey());
				}
				break;
			case "Acousticness":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getAcousticness());
				}
				break;
			case "Danceability":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getDanceability());
				}
				break;
			case "Duration":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getDuration());
				}
				break;
			case "Energy":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getEnergy());
				}
				break;
			case "Instrumentalness":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getInstrumentalness());
				}
				break;
			case "Liveness":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getLiveness());
				}
				break;
			case "Loudness":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getLoudness());
				}
				break;
			case "Speechiness":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getSpeechiness());
				}
				break;
			case "Tempo":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getTempo());
				}
				break;
			case "Valence":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getValence());
				}
				break;
			case "Popularity":
				for (int i = 0; i < tmp.size(); i++) {
					series.addOrUpdate(setDay(tmp.get(i).getYear()),tmp.get(i).getPopularity());
				}
				break;
			}
			//Add series to Time Collection
			dataset.addSeries(series);
			
			//Build Chart
			JFreeChart chart = ChartFactory.createTimeSeriesChart(
			        "Spotify Dataset " + windowInput.getText() + ", ~600k Tracks", // Chart
			        "Year", // X-Axis Label
			        selectedData, // Y-Axis Label
			        dataset);
			
			//Remove any previous plot components
			removePlotComponents();
			
			//Build Data Info Box
			dataInfo = new JTextArea(musicDataInfo.get(selectedData));
			dataInfo.setLineWrap(true);
			dataInfo.setWrapStyleWord(true);
			
			//Add components to window
			plotPanel.add(new ChartPanel(chart));
			plotPanel.add(dataInfo);
		}
	}
	
	public void removePlotComponents() {
		Component[] componentList = plotPanel.getComponents();
		for(Component c : componentList){
		    if(c instanceof ChartPanel){
		        plotPanel.remove(c);
		    } else if (c instanceof JTextArea) {
		    	plotPanel.remove(c);
		    }
		}
		plotPanel.revalidate();
		plotPanel.repaint();
	}
	
	public static MusicByYearData loadData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new FileInputStream("src/main/resources/musicData.json"), MusicByYearData.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
	
	public Day setDay(String stringDate) {
		return new Day(1,1,Integer.parseInt(stringDate));
	}
	
private Map<String, String> musicDataInfo = new LinkedHashMap<>();
	
	public Map<String, String> setMusicInfo(){
    	musicDataInfo.put("Mode", "Mode indicates the modality (major or minor) of a track, "
    			+ "the type of scale from which its melodic content is derived."
    			+ "Major is represented by 1 and minor is 0.");
    	
    	musicDataInfo.put("Key", "The key the track is in. Integers map to pitches using "
    			+ "standard Pitch Class notation . E.g. 0 = C, 1 = C Sharp/D Flat, 2 = D, and so on.");
    	
    	musicDataInfo.put("Acousticness", "A confidence measure from 0.0 to 1.0 of whether the track is "
    			+ "acoustic. 1.0 represents high confidence the track is acoustic.");
    	
    	musicDataInfo.put("Danceability", "Danceability describes how suitable a track is for "
    			+ "dancing based on a combination of musical elements including tempo, "
    			+ "rhythm stability, beat strength, and overall regularity. "
    			+ "A value of 0.0 is least danceable and 1.0 is most danceable.");
    	
    	musicDataInfo.put("Duration", "The duration of the track in milliseconds.");
    	
    	musicDataInfo.put("Energy", "Energy is a measure from 0.0 to 1.0 and "
    			+ "represents a perceptual measure of intensity and activity. "
    			+ "Typically, energetic tracks feel fast, loud, and noisy. "
    			+ "For example, death metal has high energy, while a Bach prelude "
    			+ "scores low on the scale. Perceptual features contributing to "
    			+ "this attribute include dynamic range, perceived loudness, timbre, "
    			+ "onset rate, and general entropy.");
    	
    	musicDataInfo.put("Instrumentalness", "Predicts whether a track contains no vocals. "
    			+ "“Ooh” and “aah” sounds are treated as instrumental in this context. "
    			+ "Rap or spoken word tracks are clearly “vocal”. The closer the "
    			+ "instrumentalness value is to 1.0, the greater likelihood the "
    			+ "track contains no vocal content. Values above 0.5 are intended to "
    			+ "represent instrumental tracks, but confidence is higher as the value "
    			+ "approaches 1.0.");
    	
    	musicDataInfo.put("Liveness", "Detects the presence of an audience in the recording. "
    			+ "Higher liveness values represent an increased probability that "
    			+ "the track was performed live. A value above 0.8 provides strong "
    			+ "likelihood that the track is live.");
    	
    	musicDataInfo.put("Loudness", "The overall loudness of a track in decibels (dB). "
    			+ "Loudness values are averaged across the entire track and are useful "
    			+ "for comparing relative loudness of tracks. Loudness is the quality "
    			+ "of a sound that is the primary psychological correlate of physical "
    			+ "strength (amplitude). Values typical range between -60 and 0 db.");
    	
    	musicDataInfo.put("Speechiness", "Speechiness detects the presence of spoken words "
    			+ "in a track. The more exclusively speech-like the recording "
    			+ "(e.g. talk show, audio book, poetry), the closer to 1.0 the "
    			+ "attribute value. Values above 0.66 describe tracks that are "
    			+ "probably made entirely of spoken words. Values between 0.33 "
    			+ "and 0.66 describe tracks that may contain both music and speech, "
    			+ "either in sections or layered, including such cases as rap music. "
    			+ "Values below 0.33 most likely represent music and other non-speech-like tracks.");
    	
    	musicDataInfo.put("Tempo", "The overall estimated tempo of a track in beats per minute (BPM). "
    			+ "In musical terminology, tempo is the speed or pace of a given piece and "
    			+ "derives directly from the average beat duration.");
    	
    	musicDataInfo.put("Valence", "A measure from 0.0 to 1.0 describing the musical "
    			+ "positiveness conveyed by a track. Tracks with high valence sound "
    			+ "more positive (e.g. happy, cheerful, euphoric), while tracks with low "
    			+ "valence sound more negative (e.g. sad, depressed, angry).");
    	
    	musicDataInfo.put("Popularity", "The popularity of the track. The value will be between 0 and 100, "
    			+ "with 100 being the most popular. The popularity of a track is a value "
    			+ "between 0 and 100, with 100 being the most popular. The popularity is "
    			+ "calculated by algorithm and is based, in the most part, on the total number "
    			+ "of plays the track has had and how recent those plays are. Generally speaking, "
    			+ "songs that are being played a lot now will have a higher popularity than "
    			+ "songs that were played a lot in the past. Duplicate tracks (e.g. the same "
    			+ "track from a single and an album) are rated independently. Artist and album "
    			+ "popularity is derived mathematically from track popularity. Note that the "
    			+ "popularity value may lag actual popularity by a few days: the value is not "
    			+ "updated in real time.");
    	
    	return musicDataInfo;
    } 
}

