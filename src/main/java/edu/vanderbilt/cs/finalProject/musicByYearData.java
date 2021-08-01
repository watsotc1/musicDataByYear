package edu.vanderbilt.cs.finalProject;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class musicByYearData {
	
	public static class DataFrame {
		public final int mode; 
		public final int key;
		public final String year; 
		public final double acousticness; 
		public final double danceability; 
		public final double duration; 
		public final double energy; 
		public final double instrumentalness; 
		public final double liveness; 
		public final double loudness; 
		public final double speechiness; 
		public final double tempo; 
		public final double valence; 
		public final double popularity; 

		
		public DataFrame(int mode,int key,String year, double acousticness,
				double danceability,double duration,double energy,
				double instrumentalness,double liveness,double loudness,
				double speechiness,double tempo,double valence,double popularity) {
			
			super();
			this.mode = mode; 
			this.key = key;
			this.year = year; 
			this.acousticness = acousticness; 
			this.danceability = danceability; 
			this.duration = duration; 
			this.energy = energy; 
			this.instrumentalness = instrumentalness; 
			this.liveness = liveness; 
			this.loudness = loudness; 
			this.speechiness = speechiness; 
			this.tempo = tempo; 
			this.valence = valence; 
			this.popularity =popularity; 	
		}
		
		public int mode() {
			return mode;
		}
		
		public int key() {
			return key;
		}
		
		public String year() { 
			return year;
		}
		public double acousticness() { 
			return acousticness;
		}
		
		public double danceability() { 
			return danceability;
		}
		
		public double duration() { 
			return duration;
		}
		public double energy() { 
			return energy;
		}
		
		public double instrumentalness() { 
			return instrumentalness;
		}
		
		public double liveness() {
			return liveness;
		}
		
		public double loudness() { 
			return loudness;
		}
		
		public double speechiness() { 
			return speechiness;
		}
		
		public double tempo() { 
			return tempo;
		}
		public double valence() { 
			return valence;
		}
		
		public double popularity() { 
			return popularity;
		}
	}
	
	public static class doubleDataStream {
		
		public final double[] data;
		
		@JsonCreator
        public doubleDataStream(@JsonProperty("data") double[] data) {
            this.data = data;
        }

        @JsonAnySetter
        public void setOther(String key, Object v) {}
	}
	
	public static class stringDataStream {
		
		public final String[] data;
		
		@JsonCreator
        public stringDataStream(@JsonProperty("data") String[] data) {
            this.data = data;
        }

        @JsonAnySetter
        public void setOther(String key, Object v) {}
	}
	
	public static class intDataStream {
		
		public final int[] data;
		
		@JsonCreator
        public intDataStream(@JsonProperty("data") int[] data) {
            this.data = data;
        }

        @JsonAnySetter
        public void setOther(String key, Object v) {}
	}
	
	public final int[] mode; 
	public final int[] key;
	public final String[] year; 
	public final double[] acousticness; 
	public final double[] danceability; 
	public final double[] duration; 
	public final double[] energy; 
	public final double[] instrumentalness; 
	public final double[] liveness; 
	public final double[] loudness; 
	public final double[] speechiness; 
	public final double[] tempo; 
	public final double[] valence; 
	public final double[] popularity; 
	
	@JsonCreator
	public musicByYearData(@JsonProperty("mode") intDataStream mode,
					 @JsonProperty("key") intDataStream key,
					 @JsonProperty("year") stringDataStream year,
					 @JsonProperty("acousticness") doubleDataStream acousticness,
					 @JsonProperty("danceability") doubleDataStream danceability,
					 @JsonProperty("duration") doubleDataStream duration,
					 @JsonProperty("energy") doubleDataStream energy,
					 @JsonProperty("instrumentalness") doubleDataStream instrumentalness,
					 @JsonProperty("liveness") doubleDataStream liveness,
					 @JsonProperty("loudness") doubleDataStream loudness,
					 @JsonProperty("speechiness") doubleDataStream speechiness,
					 @JsonProperty("tempo") doubleDataStream tempo,
					 @JsonProperty("valence") doubleDataStream valence,
					 @JsonProperty("popularity") doubleDataStream popularity) {
	
		super();
		this.mode = mode.data; 
		this.key = key.data;
		this.year = year.data; 
		this.acousticness = acousticness.data; 
		this.danceability = danceability.data; 
		this.duration = duration.data; 
		this.energy = energy.data; 
		this.instrumentalness = instrumentalness.data; 
		this.liveness = liveness.data; 
		this.loudness = loudness.data; 
		this.speechiness = speechiness.data; 
		this.tempo = tempo.data; 
		this.valence = valence.data; 
		this.popularity =popularity.data;
	}
	
	public IntStream modeStream() {
		return IntStream.of(mode);
	}
	
	public IntStream keyStream() {
		return IntStream.of(key);
	}
	
	public Stream<String> yearStream() { 
		return Stream.of(year);
	}
	
	public DoubleStream acousticnessStream() { 
		return DoubleStream.of(acousticness);
	}
	
	public DoubleStream danceabilityStream() { 
		return DoubleStream.of(danceability);
	}
	
	public DoubleStream durationStream() { 
		return DoubleStream.of(duration);
	}
	
	public DoubleStream energyStream() { 
		return DoubleStream.of(energy);
	}
	
	public DoubleStream instrumentalnessStream() { 
		return DoubleStream.of(instrumentalness);
	}
	
	public DoubleStream livenessStream() { 
		return DoubleStream.of(liveness);
	}
	
	public DoubleStream loudnessStream() { 
		return DoubleStream.of(loudness);
	}
	
	public DoubleStream speechinessStream() { 
		return DoubleStream.of(speechiness);
	}
	
	public DoubleStream tempoStream() { 
		return DoubleStream.of(tempo);
	}
	
	public DoubleStream valenceStream() { 
		return DoubleStream.of(valence);
	}
	
	public DoubleStream popularityStream() { 
		return DoubleStream.of(popularity);
	}
	
	public Stream<DataFrame> fusedFramesStream() {
        return IntStream
        		.range(0, year.length)
        		.mapToObj(i -> new DataFrame(mode[i],key[i],year[i],acousticness[i],
        				danceability[i],duration[i],energy[i],
        				instrumentalness[i],liveness[i],loudness[i],
        				speechiness[i],tempo[i],valence[i],popularity[i]));
    }
	// Don't change me!
    //
    // There is nothing to see here, move along.
    @JsonAnySetter
    public void setOther(String key, Object v) {
    }

}
