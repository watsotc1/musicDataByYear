package edu.vanderbilt.cs.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.vanderbilt.cs.streams.COVIDdata.DataFrame;

public class COVIDstats {
	
	private COVIDdata data;
	
	public COVIDstats(COVIDdata data) {
		this.data = data;
	}
	
	/**
     *
     * Creates a stream of DataFrames representing the average of the
     * sliding windows generated from the given window size.
     * 
     * Note: Only stores first day, use windowSize to determine date count!
     *
     * @param windowSize
     * @return
     */
    public Stream<COVIDdata.DataFrame> averagedDataFrameStream(int windowSize){  	
    	return StreamUtils.slidingWindow(data.fusedFramesStream().collect(Collectors.toList()), windowSize)
			    		  .map(ls -> new DataFrame(ls.get(0).getDate(),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getDeath).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getDeathIncrease).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getHospitalizedCumulative).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getHospitalizedCurrently).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getHospitalizedIncrease).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getInIcuCumulative).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getInIcuCurrently).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getNegative).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getNegativeIncrease).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getOnVentilatorCurrently).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getPending).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getPositive).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getPositiveIncrease).apply(ls),
		    	    			StreamUtils.averageOfProperty(COVIDdata.DataFrame::getTotalTestResultsIncrease).apply(ls)));
    	
    	
    }

}
