package edu.vanderbilt.cs.finalProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class COVIDstatsTest {
	
	@Test
    public void testAveragedDataFrameStream(){
		COVIDdata data = COVIDdataTest.loadData();
        COVIDstats stats = new COVIDstats(COVIDdataTest.loadData());

        // Consistency checks
        double deathAverage = stats.averagedDataFrameStream(1)
                                    .mapToDouble(COVIDdata.DataFrame::getDeath)
                                    .average()
                                    .getAsDouble();
        double expectedVelocityAverage = data.deathStream().average().getAsDouble();
        assertEquals(expectedVelocityAverage, deathAverage, 0.1);

        // Check that Data gets 1st and last of every window
        //ToDo

        assertEquals(
                data.deathStream().limit(5).average().getAsDouble(),
                stats.averagedDataFrameStream(5)
                        .findFirst().get().death);

        assertEquals(
                data.deathStream().limit(25).average().getAsDouble(),
                stats.averagedDataFrameStream(25)
                        .findFirst().get().death);

        // Checks to see if the sum of the values in each sliding window
        // equals the average for the corresponding data frame times the
        // number of items in the window
        int windowSize = Math.max(
                1,
                (int)Math.rint(Math.random() * data.deathStream().count()));

        IntStream.range(0, (int) data.deathStream().count() - windowSize)
                    .forEach( i -> {
                        assertEquals(
                        		data.deathStream()
                                        .skip(i)
                                        .limit(windowSize)
                                        .sum(),
                                stats.averagedDataFrameStream(windowSize)
                                        .skip(i)
                                        .limit(1)
                                        .mapToDouble(f -> f.getDeath() * windowSize)
                                        .sum(),
                                0.01);
                    });

        // Consistency checks
        double hospitalizedCurrentlyAverage = stats.averagedDataFrameStream(1)
                .mapToDouble(COVIDdata.DataFrame::getHospitalizedCurrently)
                .average()
                .getAsDouble();
        
        double expectedhospitalizedCurrentlyAverage = data.hospitalizedCurrentlyStream().average().getAsDouble();
        assertEquals(expectedhospitalizedCurrentlyAverage, hospitalizedCurrentlyAverage, 0.1);
        
    }

}
