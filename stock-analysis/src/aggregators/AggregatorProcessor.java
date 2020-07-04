package aggregators;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import fileprocessors.StockFileReader;

public class AggregatorProcessor<T extends Aggregator> {
	
	String file;
	T aggregator;
	
	public AggregatorProcessor(T aggregator, String file) {
		super();
		this.file = file;
		this.aggregator = aggregator;
	}
	
	public double runAggregator(int colId) throws IOException {
		StockFileReader fileReader = new StockFileReader(file);
		List<String> lines = fileReader.readFileData();
			
			colId--;
			for(String line : lines) {
				if(line != null) {
					String [] cells = line.split(",");
					double cell = Double.parseDouble(cells[colId]);
					aggregator.add(cell);
				}
				
			}

			
			double result = aggregator.calculate();
		return result;
	}
	



}
