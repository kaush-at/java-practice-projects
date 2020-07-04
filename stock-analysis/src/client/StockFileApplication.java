package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		HashMap<String, Double> myHash = new HashMap<>();
//		HashMap<String, String> myHash = new HashMap();
		String line = null;
		String[] lineArr = null ;
		for(int i = 0; i < lines.size()-1; i++) {
			line = lines.get(i);
			lineArr = line.split(",");
			for(int j = 0; j < headers.size()-1; j++) {
				Double value = Double.valueOf(lineArr[j]);
				
				myHash.put(headers.get(j), value);
			}
			dataResult.add(myHash);
		}
		return dataResult;
	}
	
	
}
