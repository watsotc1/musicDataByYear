<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/watsotc1/musicDataByYear">
    <img src="images/icon.png" alt="Logo" width="500" height="200">
  </a>

  <h3 align="center">Spotify API Data Visualization Tool</h3>

  <p align="center">
    Visualization tool for open source data collected during the COVID-19 pandemic. 
    <br />
    <a href="https://github.com/watsotc1/musicDataByYear"><strong>Explore the docs »</strong></a>
    <a href="https://developer.spotify.com/documentation/web-api/quick-start/">View/Download the data for yourself! »</strong></a>
  </p>
</p>


<!-- ABOUT THE PROJECT -->
## About The Project

The Spotify API Data Visualization Tool allows users to navigate through and visualize the data provided through Spotify's Web API. 

![alt text](https://github.com/watsotc1/musicDataByYear/blob/main/images/screenShot.PNG)

The tool (pictured above) features a simple design that allows the user to select from the available data and see the recorded music trends from the last one hundred years.

### Overall Design

The tool is made up of three primary files as well as a testing script that runs upon each push to the repo:
1) _PlotTool.java_
2) _MusicByYearData.java_
3) _MusicByYearStats.java_

The main script is _PlotTool.java_, which builds the GUI and calls the classes found in the remaining two files. 
To start, the user selects the data they want to plot from the drop down menu.

![alt text](https://github.com/watsotc1/musicDataByYear/blob/main/images/dropDown.png)

Then the user can select the years they want to see data through:

![alt text](https://github.com/watsotc1/musicDataByYear/blob/main/images/enterDate.PNG)

Finally, the user can click the plot button which triggers the _dataChoiceHandler_ function which implements Java's _ActionListener_. This function first calls _loadData()_ which will read in the JSON data file, then use the _MusicByYearData_ Class to sort and store said data. A stream is then generated using _MusicByYearData's fusedFramesStream()_.

```
  public static MusicByYearData loadData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new FileInputStream("src/main/resources/musicData.json"), MusicByYearData.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
  }
```

Next, the function will check if the user updated the selected years. If so, it will call _MusicByYearStats's slidingWindow()_ which will return a sublist of data for the years selected.

```
  //Get sublist if specified
  if (!windowInput.getText().equals("1921-2020")) {
      List<DataFrame> subList = MusicByYearStats.slidingWindow(dataFrameStream, windowInput.getText());
  }
```

Note: If the user inputs the dates in an incorrect format, or outside of the data's range then the function will return an empty list and display a popup window reminding the user of the correct format and time range. 

![alt text](https://github.com/watsotc1/musicDataByYear/blob/main/images/errorPopup.PNG)

Next, the selected data's description will be loaded from the _musicDataInfo_ Map. The Map is set up using the data name as the key, and the data's description as the value. 

```
//Load Data Info
Map<String, String> musicDataInfo = setMusicInfo();
```

```
public Map<String, String> setMusicInfo(){
    musicDataInfo.put("Mode", "Mode indicates the modality (major or minor) of a track, "
              + "the type of scale from which its melodic content is derived."
              + "Major is represented by 1 and minor is 0.");
    ...
}
```

Following this, the scrip initializes the Time Series and uses a switch case to format the data for the plot. Then the plot is generated and added/updated in the window.

```
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
```

![alt text](https://github.com/watsotc1/musicDataByYear/blob/main/images/screenShot.PNG)

Note: The user can generate a plot for another data set without having to reset the tool. 

### Interesting Challenges And Solutions

I originally wanted to make this into an Android App using Android Studio. However, my personal laptop wasn't able to support the heavy loads of the program. Instead I switched focus and learned about Java's Swing. Swing is the successor to AWT and builds directly onto it, fixing and replacing many of the features as well as including additional functionality. The majority of my prior experience in building GUIs has been through Python and MATLAB so this was a large learning curve for me.

### Built With

* [Java]()
* [Gradle]()


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

1. Clone the repo
   ```sh
   git clone https://github.com/watsotc1/covidDataTracking.git
   ```
2. Import project into Eclipse
3. Sync Gradle and run 'PlotTool.java'

