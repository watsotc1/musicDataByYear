package edu.vanderbilt.cs.finalProject;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.vanderbilt.cs.finalProject.musicByYearData;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;

public class musicDataTest {
	public static final int EXPECTED_DATA_ITEMS = 100;
    public static final double EXPECTED_AVG_acousticness = 0.55631702199;
    public static final double EXPECTED_AVG_danceability = 0.5367828954;
    public static final double EXPECTED_AVG_duration = 227296.752236;
    public static final double EXPECTED_AVG_energy = 0.45270541581;
    public static final double EXPECTED_AVG_instrumentalness = 0.19358184665;
    public static final double EXPECTED_AVG_liveness = 0.2082238052;
    public static final double EXPECTED_AVG_loudness = -11.969054087029999;
    public static final double EXPECTED_AVG_speechiness = 0.10586108858;
    public static final double EXPECTED_AVG_tempo = 116.015674493;
    public static final double EXPECTED_AVG_valence = 0.53212011438;
    public static final double EXPECTED_AVG_popularity = 27.376065024210003;
	
 
    public static musicByYearData loadData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new FileInputStream("src/main/resources/musicData.json"), musicByYearData.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void testIntStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.modeStream().count());
        assertEquals(EXPECTED_DATA_ITEMS, data.keyStream().count());
    }
    
    @Test
    public void testYearStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.yearStream().count());
    }

    @Test
    public void testAcousticnessStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.acousticnessStream().count());
        assertEquals(EXPECTED_AVG_acousticness, data.acousticnessStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testDanceabilityStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.danceabilityStream().count());
        assertEquals(EXPECTED_AVG_danceability, data.danceabilityStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testDurationStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.durationStream().count());
        assertEquals(EXPECTED_AVG_duration, data.durationStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testeEnergyStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.energyStream().count());
        assertEquals(EXPECTED_AVG_energy, data.energyStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testInstrumentalnessStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.instrumentalnessStream().count());
        assertEquals(EXPECTED_AVG_instrumentalness, data.instrumentalnessStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testLivenessStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.livenessStream().count());
        assertEquals(EXPECTED_AVG_liveness, data.livenessStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testLoudnessStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.loudnessStream().count());
        assertEquals(EXPECTED_AVG_loudness, data.loudnessStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testSpeechinessDurationStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.speechinessStream().count());
        assertEquals(EXPECTED_AVG_speechiness, data.speechinessStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testTempoStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.tempoStream().count());
        assertEquals(EXPECTED_AVG_tempo, data.tempoStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testValenceStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.valenceStream().count());
        assertEquals(EXPECTED_AVG_valence, data.valenceStream().average().getAsDouble(), 0.1);
    }
    
    @Test
    public void testPopularityStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.popularityStream().count());
        assertEquals(EXPECTED_AVG_popularity, data.popularityStream().average().getAsDouble(), 0.1);
    }

    @Test
    public void testFusedDataFrameStream(){
    	musicByYearData data = loadData();
        assertEquals(EXPECTED_DATA_ITEMS, data.fusedFramesStream().count());

        assertEquals(EXPECTED_AVG_acousticness,
                data.fusedFramesStream().mapToDouble(f -> f.acousticness).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_danceability,
                data.fusedFramesStream().mapToDouble(f -> f.danceability).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_duration,
                data.fusedFramesStream().mapToDouble(f -> f.duration).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_energy,
                data.fusedFramesStream().mapToDouble(f -> f.energy).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_instrumentalness,
                data.fusedFramesStream().mapToDouble(f -> f.instrumentalness).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_liveness,
                data.fusedFramesStream().mapToDouble(f -> f.liveness).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_loudness,
                data.fusedFramesStream().mapToDouble(f -> f.loudness).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_speechiness,
                data.fusedFramesStream().mapToDouble(f -> f.speechiness).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_tempo,
                data.fusedFramesStream().mapToDouble(f -> f.tempo).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_valence,
                data.fusedFramesStream().mapToDouble(f -> f.valence).average().getAsDouble(),
                0.1);
        assertEquals(EXPECTED_AVG_popularity,
                data.fusedFramesStream().mapToDouble(f -> f.popularity).average().getAsDouble(),
                0.1);
    }

}

