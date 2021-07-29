package edu.vanderbilt.cs.streams;

import java.io.FileInputStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.vanderbilt.cs.streams.BikeRide.DataFrame;
import edu.vanderbilt.cs.streams.BikeRide.DataStream;

public class COVIDdata {
	
	public static class DataFrame {
		public final int date;
		public final int death;
		public final int deathIncrease;
		public final int hospitalizedCumulative;
		public final int hospitalizedCurrently;
		public final int hospitalizedIncrease;
		public final int inIcuCumulative;
		public final int inIcuCurrently;
		public final int negative;
		public final int negativeIncrease;
		public final int onVentilatorCurrently;
		public final int pending;
		public final int positive;
		public final int positiveIncrease;
		public final int totalTestResultsIncrease;
		
		public DataFrame(int date,int death,int deathIncrease,
				int hospitalizedCumulative,int hospitalizedCurrently,
				int hospitalizedIncrease,int inIcuCumulative,int inIcuCurrently,
				int negative,int negativeIncrease,int onVentilatorCurrently,
				int pending,int positive,int positiveIncrease,int totalTestResultsIncrease) {
			
			super();
			this.date = date;
			this.death = death;
			this.deathIncrease = deathIncrease;
			this.hospitalizedCumulative = hospitalizedCumulative;
			this.hospitalizedCurrently = hospitalizedCurrently;
			this.hospitalizedIncrease = hospitalizedIncrease;
			this.inIcuCumulative = inIcuCumulative;
			this.inIcuCurrently = inIcuCurrently;
			this.negative = negative;
			this.negativeIncrease = negativeIncrease;
			this.onVentilatorCurrently = onVentilatorCurrently;
			this.pending = pending;
			this.positive = positive;
			this.positiveIncrease = positiveIncrease;
			this.totalTestResultsIncrease = totalTestResultsIncrease;	
		}
		
		public int getDate() {
			return date;
		}
		
		public int getDeath() {
			return death;
		}
		public int getDeathIncrease() {
			return deathIncrease;
		}
		
		public int getHospitalizedCumulative() {
			return hospitalizedCumulative;
		}
		
		public int getHospitalizedCurrently() {
			return hospitalizedCurrently;
		}
		
		public int getHospitalizedIncrease() {
			return hospitalizedIncrease;
		}
		
		public int getInIcuCumulative() {
			return inIcuCumulative;
		}
		
		public int getInIcuCurrently() {
			return inIcuCurrently;
		}
		
		public int getNegative() {
			return negative;
		}
		
		public int getNegativeIncrease() {
			return negativeIncrease;
		}
		
		public int getOnVentilatorCurrently() {
			return onVentilatorCurrently;
		}
		
		public int getPending() {
			return pending;
		}
		
		public int getPositive() {
			return positive;
		}
		
		public int getPositiveIncrease() {
			return positiveIncrease;
		}
		
		public int getTotalTestResultsIncrease() {
			return totalTestResultsIncrease;
		}
	}
	
	public static class DataStream {
		
		public final int[] data;
		
		@JsonCreator
        public DataStream(@JsonProperty("data") int[] data) {
            this.data = data;
        }

        @JsonAnySetter
        public void setOther(String key, Object v) {}
	}
	
	public final int[] date;
	public final int[] death;
	public final int[] deathIncrease;
	public final int[] hospitalizedCumulative;
	public final int[] hospitalizedCurrently;
	public final int[] hospitalizedIncrease;
	public final int[] inIcuCumulative;
	public final int[] inIcuCurrently;
	public final int[] negative;
	public final int[] negativeIncrease;
	public final int[] onVentilatorCurrently;
	public final int[] pending;
	public final int[] positive;
	public final int[] positiveIncrease;
	public final int[] totalTestResultsIncrease;
	
	@JsonCreator
	public COVIDdata(@JsonProperty("date") DataStream date,
					 @JsonProperty("death") DataStream death,
					 @JsonProperty("deathIncrease") DataStream deathIncrease,
					 @JsonProperty("hospitalizedCumulative") DataStream hospitalizedCumulative,
					 @JsonProperty("hospitalizedCurrently") DataStream hospitalizedCurrently,
					 @JsonProperty("hospitalizedIncrease") DataStream hospitalizedIncrease,
					 @JsonProperty("inIcuCumulative") DataStream inIcuCumulative,
					 @JsonProperty("inIcuCurrently") DataStream inIcuCurrently,
					 @JsonProperty("negative") DataStream negative,
					 @JsonProperty("negativeIncrease") DataStream negativeIncrease,
					 @JsonProperty("onVentilatorCurrently") DataStream onVentilatorCurrently,
					 @JsonProperty("pending") DataStream pending,
					 @JsonProperty("positive") DataStream positive,
					 @JsonProperty("positiveIncrease") DataStream positiveIncrease,
					 @JsonProperty("totalTestResultsIncrease") DataStream totalTestResultsIncrease) {
	
		super();
		this.date = date.data;
		this.death = death.data;
		this.deathIncrease = deathIncrease.data;
		this.hospitalizedCumulative = hospitalizedCumulative.data;
		this.hospitalizedCurrently = hospitalizedCurrently.data;
		this.hospitalizedIncrease = hospitalizedIncrease.data;
		this.inIcuCumulative = inIcuCumulative.data;
		this.inIcuCurrently = inIcuCurrently.data;
		this.negative = negative.data;
		this.negativeIncrease = negativeIncrease.data;
		this.onVentilatorCurrently = onVentilatorCurrently.data;
		this.pending = pending.data;
		this.positive = positive.data;
		this.positiveIncrease = positiveIncrease.data;
		this.totalTestResultsIncrease = totalTestResultsIncrease.data;
	}
	
	public IntStream dateStream() {
		return IntStream.of(date);
	}
	
	public IntStream deathStream() {
		return IntStream.of(death);
	}
	
	public IntStream deathIncreaseStream() {
		return IntStream.of(deathIncrease);
	}
	
	public IntStream hospitalizedCumulativeStream() {
		return IntStream.of(hospitalizedCumulative);
	}
	
	public IntStream hospitalizedCurrentlyStream() {
		return IntStream.of(hospitalizedCurrently);
	}
	
	public IntStream hospitalizedIncreaseStream() {
		return IntStream.of(hospitalizedIncrease);
	}
	
	public IntStream inIcuCumulativeStream() {
		return IntStream.of(inIcuCumulative);
	}
	
	public IntStream inIcuCurrentlyStream() {
		return IntStream.of(inIcuCurrently);
	}
	
	public IntStream negativeStream() {
		return IntStream.of(negative);
	}
	
	public IntStream negativeIncreaseStream() {
		return IntStream.of(negativeIncrease);
	}
	
	public IntStream onVentilatorCurrentlyStream() {
		return IntStream.of(onVentilatorCurrently);
	}
	
	public IntStream pendingStream() {
		return IntStream.of(pending);
	}
	
	public IntStream positiveStream() {
		return IntStream.of(positive);
	}
	
	public IntStream positiveIncreaseStream() {
		return IntStream.of(positiveIncrease);
	}
	
	public IntStream totalTestResultsIncreaseStream() {
		return IntStream.of(totalTestResultsIncrease);
	}
	
	public Stream<DataFrame> fusedFramesStream() {
        return IntStream
        		.range(0, date.length)
        		.mapToObj(i -> new DataFrame(date[i],death[i],deathIncrease[i],
        										hospitalizedCumulative[i],hospitalizedCurrently[i],
						        				hospitalizedIncrease[i],inIcuCumulative[i],inIcuCurrently[i],
						        				negative[i],negativeIncrease[i],onVentilatorCurrently[i],
						        				pending[i],positive[i],positiveIncrease[i],totalTestResultsIncrease[i]));
    }
	// Don't change me!
    //
    // There is nothing to see here, move along.
    @JsonAnySetter
    public void setOther(String key, Object v) {
    }

}
