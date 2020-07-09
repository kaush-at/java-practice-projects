package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		// files wala tiyena file 2 build path ekata dagatta use karanna kalin project
		// ekata
		// right click on project -> configure buildpath -> java build path -> source ->
		// add folder -> apply & close

		// EX - 1 /
		IntStream.range(1, 10) // these 11,12 lines are the source (range function not inclusive last value)
				.forEach((x) -> System.out.print(x)); // this is the terminal operation (we don't have any intermediate
														// operations in this
		// // example) for each going to loop through 1 to 10
		System.out.println();

		// EX - 2 /
		IntStream.range(1, 10).skip(5) // reduce no of result from stram / skip 5 elements of the stream(elements 5k
										// skip karanna) - intermediate operations
				.forEach((x) -> System.out.print(x));
		System.out.println();

		// EX - 3
		// integer stream with the sum operations
		int val = IntStream.range(1, 5).sum();
		System.out.println(val);

		// EX - 4
		// Stream of, sorted and findfirst
		Stream.of("Hello", "bottle", "Africa").sorted() // intermediate
				.findFirst() // terminal operation
				.ifPresent((x) -> System.out.println(x)); // ifPresent we use to prevent null pointer exceptions

		// EX - 5
		// Stream from Array, sort, filter and print
		String[] items = { "car", "computer", "toothpaste", "box", "pencil", "tent", "door", "toy" };
		Stream.of(items).filter((x) -> x.startsWith("t")) // intermediate operation
				.sorted() // another intermediate operation
				.forEach(x -> System.out.print(x + ", ")); // terminal operation
		System.out.println();

		// EX - 6
		// Average of squares of an int array
		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(x -> x * x).average().ifPresent(n -> System.out.print(n));
		System.out.println();

		// EX - 7
		// Stream from a list, filter and print
		List<String> listOfItems = Arrays.asList("car", "computer", "toothpaste", "box", "pencil", "tent", "door",
				"toy");
		listOfItems.stream().map(x -> x.toLowerCase()).filter((x) -> x.startsWith("c")) // intermediate operation
				.sorted() // another intermediate operation
				.forEach(x -> System.out.print(x + ", ")); // terminal operation
		System.out.println();

		// EX - 8
		try {
			Stream<String> lines = Files.lines(Paths.get("files/wordFile.txt"));// new way of openning files assign it
																				// to stram of string
			lines.sorted() // elements
					.filter(l -> l.length() > 6).forEach(x -> System.out.print(x + ", "));
			lines.close(); // always make sure to close the resources you opend other wise it will cause
							// your memory leaks
		} catch (IOException e) {
			e.printStackTrace();
		}
		// filter karala sort karanna puluwan nam hodai ewita sort or other operations
		// karanna one wena elements gaana adui

		// EX - 9
		try {
			List<String> words = Files.lines(Paths.get("files/wordFile.txt")).filter(x -> x.contains("th"))
					.collect(Collectors.toList()); // convert stream of words in to a collection list elements
			words.forEach(x -> System.out.print(x + ", "));
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// EX - 10
		try {
			Stream<String> rows = Files.lines(Paths.get("files/stockData.txt"));
			int rowCount = (int) rows.map(x -> x.split(",")).filter(l -> l.length > 3).count();
			System.out.println(rowCount + " Good rows");
			rows.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// EX - 11
		try {
			Stream<String> rows = Files.lines(Paths.get("files/stockData.txt"));
			rows.map(x -> x.split(",")).filter(l -> l.length > 3).filter(x -> Integer.parseInt(x[1].trim()) > 15)
					.forEach(x -> System.out.println(x[0].trim() + " " + x[2].trim() + " " + x[3].trim()));
			rows.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
