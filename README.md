<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
***
***
***
*** To avoid retyping too much info. Do a search and replace for the following:
*** watsotc1, covidDataTracking, twitter_handle, email, COVID Data GUI , project_description
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->



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
1) PlotTool.java
2) MusicByYearData.java
3) MusicByYearStats.java

The main script is 'PlotTool.java', which builds the GUI and calls the sumplemental functions found in the remaining two files. 

To start, the user selects the data they want to plot from the drop down menu.
![alt text](https://github.com/watsotc1/musicDataByYear/blob/main/images/dropDown.PNG)

Then the user can select the years they want to see data through:
![alt text](https://github.com/watsotc1/musicDataByYear/blob/main/images/enterDate.PNG)

Todo: explain process after plot:

Note: If the user inputs the dates in an incorrect format, or outside of the data's range then the function will return an empty list and display a popup window reminding the user of the correct format and time range. 
![alt text](https://github.com/watsotc1/musicDataByYear/blob/main/images/errorPopup.PNG)

### Interesting Challenges And Solutions


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

