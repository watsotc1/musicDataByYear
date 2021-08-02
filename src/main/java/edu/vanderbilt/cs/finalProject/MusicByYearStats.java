package edu.vanderbilt.cs.finalProject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import edu.vanderbilt.cs.finalProject.MusicByYearData.DataFrame;

public class MusicByYearStats {
	public static int firstYear,lastYear;
	
	public static List<DataFrame> slidingWindow(List<DataFrame> data, String yearWindow){
		try {
			firstYear = Integer.parseInt(yearWindow.substring(0,4));
			lastYear = Integer.parseInt(yearWindow.substring(5,9));
		} catch(Exception e) {
			//Initialize Frame
			JFrame frameError = new JFrame("Error!");
			frameError.setVisible(true);
			frameError.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frameError.setSize(150, 150);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			frameError.setLocation(dim.width/2-frameError.getSize().width/2, dim.height/2-frameError.getSize().height/2);

		    //Initialize Panel
		    JPanel panelError = new JPanel();
		    panelError.setLayout(new BoxLayout(panelError, BoxLayout.Y_AXIS));
		    frameError.add(panelError);
		    
		    JTextArea errorText = new JTextArea("Incorrect Input Format! Please enter Dates as follows: YYYY-YYYY");
		    errorText.setLineWrap(true);
		    errorText.setWrapStyleWord(true);
		    frameError.add(errorText);
		    
		    frameError.setVisible(true);
		    
			firstYear = 1921;
			lastYear = 2020;
		}
		
		//Find window size
		int windowSize = lastYear - firstYear;
        if((windowSize > data.size()) || windowSize < 1) {
        	 return Collections.emptyList();
        }
        
        int startLoc = firstYear - 1921;
        //return stream of values within said range
        return data.subList(startLoc, startLoc+windowSize+1);
    }
}
