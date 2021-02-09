package zenryokuservice.mathkit.util;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CsvUtilsTest {

	@BeforeEach
	public void init() {
		System.out.println("*** Testing ***");
	}

	@Test
	public void testReadCsv() {

		List<String[]> res = CsvUtils.readCsv("D:\\csv\\c01.csv", "SJIS");
		res.forEach(arr -> {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println();
		});
	}

	@Test
	public void testReadCsv2() {
		List<String[]> res = CsvUtils.readCsv("D:\\csv\\c01.csv", "SJIS", false);
		res.forEach(arr -> {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println();
		});
	}


}
