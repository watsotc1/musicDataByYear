package edu.vanderbilt.cs.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;

public class COVIDdataTest {
	public static final int EXPECTED_DATA_ITEMS = 328;
    public static final double EXPECTED_AVG_death = 223093.59;
    public static final double EXPECTED_AVG_deathIncrease = 1492.79;
    public static final double EXPECTED_AVG_hospitalizedCumulative = 348966.70;
    public static final double EXPECTED_AVG_hospitalizedCurrently = 61027.48;
    public static final double EXPECTED_AVG_hospitalizedIncrease = 2296.44;
    public static final double EXPECTED_AVG_inIcuCumulative = 22307.88;
    public static final double EXPECTED_AVG_inIcuCurrently = 12350.16;
    public static final double EXPECTED_AVG_negative = 34323354.08;
    public static final double EXPECTED_AVG_negativeIncrease = 223321.24;
    public static final double EXPECTED_AVG_onVentilatorCurrently = 4075.72;
    public static final double EXPECTED_AVG_pending = 8269.30;
    public static final double EXPECTED_AVG_positive = 10348849.78;
    public static final double EXPECTED_AVG_positiveIncrease = 85891.30;
    public static final double EXPECTED_AVG_totalTestResultsIncrease = 1099573.09;
	
 
    public static COVIDdata loadData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new FileInputStream("src/main/resources/covidData.json"), COVIDdata.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void testDateStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.dateStream().count());
    }

    @Test
    public void testDeathStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.deathStream().count());
        assertEquals(EXPECTED_AVG_death, data.deathStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testDeathIncreaseStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.deathIncreaseStream().count());
        assertEquals(EXPECTED_AVG_deathIncrease, data.deathIncreaseStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testHospitalizedCumulativeStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.hospitalizedCumulativeStream().count());
        assertEquals(EXPECTED_AVG_hospitalizedCumulative, data.hospitalizedCumulativeStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testHospitalizedCurrentlyStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.hospitalizedCurrentlyStream().count());
        assertEquals(EXPECTED_AVG_hospitalizedCurrently, data.hospitalizedCurrentlyStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testHospitalizedIncreaseStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.hospitalizedIncreaseStream().count());
        assertEquals(EXPECTED_AVG_hospitalizedIncrease, data.hospitalizedIncreaseStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testInIcuCumulativeStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.inIcuCumulativeStream().count());
        assertEquals(EXPECTED_AVG_inIcuCumulative, data.inIcuCumulativeStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testInIcuCurrentlyStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.inIcuCurrentlyStream().count());
        assertEquals(EXPECTED_AVG_inIcuCurrently, data.inIcuCurrentlyStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testNegativeStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.negativeStream().count());
        assertEquals(EXPECTED_AVG_negative, data.negativeStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testNegativeIncreaseStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.negativeIncreaseStream().count());
        assertEquals(EXPECTED_AVG_negativeIncrease, data.negativeIncreaseStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testOnVentilatorCurrentlyStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.onVentilatorCurrentlyStream().count());
        assertEquals(EXPECTED_AVG_onVentilatorCurrently, data.onVentilatorCurrentlyStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testPendingStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.pendingStream().count());
        assertEquals(EXPECTED_AVG_pending, data.pendingStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testPositiveStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.positiveStream().count());
        assertEquals(EXPECTED_AVG_positive, data.positiveStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testPositiveIncreaseStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.positiveIncreaseStream().count());
        assertEquals(EXPECTED_AVG_positiveIncrease, data.positiveIncreaseStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testTotalTestResultsIncreaseStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.totalTestResultsIncreaseStream().count());
        assertEquals(EXPECTED_AVG_totalTestResultsIncrease, data.totalTestResultsIncreaseStream().average().getAsDouble(), 0.1);
    }

    @Test
    public void testFusedDataFrameStream(){
    	COVIDdata data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.fusedFramesStream().count());

        assertEquals(EXPECTED_AVG_death,
                data.fusedFramesStream().mapToDouble(f -> f.death).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_deathIncrease,
                data.fusedFramesStream().mapToDouble(f -> f.deathIncrease).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_hospitalizedCumulative,
                data.fusedFramesStream().mapToDouble(f -> f.hospitalizedCumulative).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_hospitalizedCurrently,
                data.fusedFramesStream().mapToDouble(f -> f.hospitalizedCurrently).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_hospitalizedIncrease,
                data.fusedFramesStream().mapToDouble(f -> f.hospitalizedIncrease).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_inIcuCumulative,
                data.fusedFramesStream().mapToDouble(f -> f.inIcuCumulative).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_inIcuCurrently,
                data.fusedFramesStream().mapToDouble(f -> f.inIcuCurrently).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_negative,
                data.fusedFramesStream().mapToDouble(f -> f.negative).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_negativeIncrease,
                data.fusedFramesStream().mapToDouble(f -> f.negativeIncrease).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_onVentilatorCurrently,
                data.fusedFramesStream().mapToDouble(f -> f.onVentilatorCurrently).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_pending,
                data.fusedFramesStream().mapToDouble(f -> f.pending).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_positive,
                data.fusedFramesStream().mapToDouble(f -> f.positive).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_positiveIncrease,
                data.fusedFramesStream().mapToDouble(f -> f.positiveIncrease).average().getAsDouble(),
                0.1);
        
        assertEquals(EXPECTED_AVG_totalTestResultsIncrease,
                data.fusedFramesStream().mapToDouble(f -> f.totalTestResultsIncrease).average().getAsDouble(),
                0.1);
    }

}

