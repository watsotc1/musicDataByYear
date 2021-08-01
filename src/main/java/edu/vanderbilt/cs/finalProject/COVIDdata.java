package edu.vanderbilt.cs.finalProject;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class COVIDdata {
	
	public static class DataFrame {
		public final String date;
		public final double death;
		public final double deathIncrease;
		public final double hospitalizedCumulative;
		public final double hospitalizedCurrently;
		public final double hospitalizedIncrease;
		public final double inIcuCumulative;
		public final double inIcuCurrently;
		public final double negative;
		public final double negativeIncrease;
		public final double onVentilatorCurrently;
		public final double onVentilatorCumulative;
		public final double pending;
		public final double positive;
		public final double positiveIncrease;
		public final double totalTestResults;
		public final double totalTestResultsIncrease;
		
		public DataFrame(String date,double death,double deathIncrease,
				double hospitalizedCumulative,double hospitalizedCurrently,
				double hospitalizedIncrease,double inIcuCumulative,double inIcuCurrently,
				double negative,double negativeIncrease,double onVentilatorCurrently,double onVentilatorCumulative,
				double pending,double positive,double positiveIncrease,double totalTestResults,double totalTestResultsIncrease) {
			
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
			this.onVentilatorCumulative = onVentilatorCumulative;
			this.pending = pending;
			this.positive = positive;
			this.positiveIncrease = positiveIncrease;
			this.totalTestResults = totalTestResults;
			this.totalTestResultsIncrease = totalTestResultsIncrease;	
		}
		
		public String getDate() {
			return date;
		}
		
		public double getDeath() {
			return death;
		}
		public double getDeathIncrease() {
			return deathIncrease;
		}
		
		public double getHospitalizedCumulative() {
			return hospitalizedCumulative;
		}
		
		public double getHospitalizedCurrently() {
			return hospitalizedCurrently;
		}
		
		public double getHospitalizedIncrease() {
			return hospitalizedIncrease;
		}
		
		public double getInIcuCumulative() {
			return inIcuCumulative;
		}
		
		public double getInIcuCurrently() {
			return inIcuCurrently;
		}
		
		public double getNegative() {
			return negative;
		}
		
		public double getNegativeIncrease() {
			return negativeIncrease;
		}
		
		public double getOnVentilatorCurrently() {
			return onVentilatorCurrently;
		}
		
		public double getOnVentilatorCumulative() {
			return onVentilatorCumulative;
		}
		
		public double getPending() {
			return pending;
		}
		
		public double getPositive() {
			return positive;
		}
		
		public double getPositiveIncrease() {
			return positiveIncrease;
		}
		
		public double getTotalTestResults() {
			return totalTestResults;
		}
		
		public double getTotalTestResultsIncrease() {
			return totalTestResultsIncrease;
		}
	}
	
	public static class DataStream {
		
		public final double[] data;
		
		@JsonCreator
        public DataStream(@JsonProperty("data") double[] data) {
            this.data = data;
        }

        @JsonAnySetter
        public void setOther(String key, Object v) {}
	}
	
	public static class DateStream {
		
		public final String[] data;
		
		@JsonCreator
        public DateStream(@JsonProperty("data") String[] data) {
            this.data = data;
        }

        @JsonAnySetter
        public void setOther(String key, Object v) {}
	}
	
	public final String[] date;
	public final double[] death;
	public final double[] deathIncrease;
	public final double[] hospitalizedCumulative;
	public final double[] hospitalizedCurrently;
	public final double[] hospitalizedIncrease;
	public final double[] inIcuCumulative;
	public final double[] inIcuCurrently;
	public final double[] negative;
	public final double[] negativeIncrease;
	public final double[] onVentilatorCurrently;
	public final double[] onVentilatorCumulative;
	public final double[] pending;
	public final double[] positive;
	public final double[] positiveIncrease;
	public final double[] totalTestResults;
	public final double[] totalTestResultsIncrease;
	
	@JsonCreator
	public COVIDdata(@JsonProperty("date") DateStream date,
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
					 @JsonProperty("onVentilatorCumulative") DataStream onVentilatorCumulative,
					 @JsonProperty("pending") DataStream pending,
					 @JsonProperty("positive") DataStream positive,
					 @JsonProperty("positiveIncrease") DataStream positiveIncrease,
					 @JsonProperty("totalTestResults") DataStream totalTestResults,
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
		this.onVentilatorCumulative = onVentilatorCumulative.data;
		this.pending = pending.data;
		this.positive = positive.data;
		this.positiveIncrease = positiveIncrease.data;
		this.totalTestResults = totalTestResults.data;
		this.totalTestResultsIncrease = totalTestResultsIncrease.data;
	}
	
	public Stream<String> dateStream() {
		return Stream.of(date);
	}
	
	public DoubleStream deathStream() {
		return DoubleStream.of(death);
	}
	
	public DoubleStream deathIncreaseStream() {
		return DoubleStream.of(deathIncrease);
	}
	
	public DoubleStream hospitalizedCumulativeStream() {
		return DoubleStream.of(hospitalizedCumulative);
	}
	
	public DoubleStream hospitalizedCurrentlyStream() {
		return DoubleStream.of(hospitalizedCurrently);
	}
	
	public DoubleStream hospitalizedIncreaseStream() {
		return DoubleStream.of(hospitalizedIncrease);
	}
	
	public DoubleStream inIcuCumulativeStream() {
		return DoubleStream.of(inIcuCumulative);
	}
	
	public DoubleStream inIcuCurrentlyStream() {
		return DoubleStream.of(inIcuCurrently);
	}
	
	public DoubleStream negativeStream() {
		return DoubleStream.of(negative);
	}
	
	public DoubleStream negativeIncreaseStream() {
		return DoubleStream.of(negativeIncrease);
	}
	
	public DoubleStream onVentilatorCumulativeStream() {
		return DoubleStream.of(onVentilatorCumulative);
	}
	
	public DoubleStream onVentilatorCurrentlyStream() {
		return DoubleStream.of(onVentilatorCurrently);
	}
	
	public DoubleStream pendingStream() {
		return DoubleStream.of(pending);
	}
	
	public DoubleStream positiveStream() {
		return DoubleStream.of(positive);
	}
	
	public DoubleStream positiveIncreaseStream() {
		return DoubleStream.of(positiveIncrease);
	}
	
	public DoubleStream totalTestResultsStream() {
		return DoubleStream.of(totalTestResults);
	}
	
	
	public DoubleStream totalTestResultsIncreaseStream() {
		return DoubleStream.of(totalTestResultsIncrease);
	}
	
	public Stream<DataFrame> fusedFramesStream() {
        return IntStream
        		.range(0, date.length)
        		.mapToObj(i -> new DataFrame(date[i],death[i],deathIncrease[i],
        										hospitalizedCumulative[i],hospitalizedCurrently[i],
						        				hospitalizedIncrease[i],inIcuCumulative[i],inIcuCurrently[i],
						        				negative[i],negativeIncrease[i],onVentilatorCurrently[i],onVentilatorCumulative[i],
						        				pending[i],positive[i],positiveIncrease[i],totalTestResults[i],totalTestResultsIncrease[i]));
    }
	// Don't change me!
    //
    // There is nothing to see here, move along.
    @JsonAnySetter
    public void setOther(String key, Object v) {
    }

}
