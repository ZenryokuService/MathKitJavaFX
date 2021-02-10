package zenryokuservice.mathkit.util;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CsvUtilsTest {

	private static final String TARGET_PATH = "C:\\Users\\tkm-yogo\\Documents\\タスク_ドキュメント\\タスクリスト\\入学前学習\\csv\\";

	private static final String DST_PATH = TARGET_PATH + "dst\\";

	@BeforeEach
	public void init() {
		System.out.println("*** Testing ***");
	}

//	@Test
	public void testReadCsv() {

		List<String[]> res = CsvUtils.readCsv(TARGET_PATH + "group.csv", "SJIS");
		res.forEach(arr -> {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println();
		});
	}

//	@Test
	public void testReadCsv2() {
		List<String[]> res = CsvUtils.readCsv(TARGET_PATH + "group.csv", "SJIS", false);
		res.forEach(arr -> {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println();
		});
	}

//	@Test
	public void testExportCsv1() {
		List<String[]> res = CsvUtils.readCsv(TARGET_PATH + "group.csv", "SJIS", true);
		List<String[]> res1 = CsvUtils.readCsv(TARGET_PATH + "group (1).csv", "SJIS", false);
		res.addAll(res1);
		CsvUtils.exportCsv(res, DST_PATH + "export1.csv");
	}

//	@Test
	public void testExportTargetCsv1() {
		List<String[]> res = CsvUtils.readCsv(TARGET_PATH + "group1.csv", "SJIS", true);

		// Checkerの実装
		CsvUtils.CsvChecker check = new CsvUtils.CsvChecker() {

			@Override
			public String[] check(String[] data, int targetColumn, Object checkValue) {
				System.out.println("CSV: " + data[targetColumn] + " = " + (String) checkValue);
				if (data[targetColumn].equals((String) checkValue)) {
					return data;
				}
				return null;
			}

		};
		CsvUtils.exportTarget(res, DST_PATH + "export2.csv", check, CsvUtils.CsvChecker.ログイン回数, "0");
	}

//	@Test
	public void testLoadFiles() {
		List<Path> list = CsvUtils.loadCsvFiles(TARGET_PATH);
		for (Path p : list) {
			System.out.println("Path: " + p.toString());
		}
	}

	@Test
	public void test0kaiLogin() {
		final String ENC = "MS932";
		List<Path> list = CsvUtils.loadCsvFiles(TARGET_PATH);
		List<String[]> outList =  new ArrayList<>();

		boolean isFirst = true;
		for (Path p : list) {
			System.out.println("Path: " + p.toString());
			List<String[]> readList = null;
			if (isFirst) {
				readList =  CsvUtils.readCsv(p.toString(), ENC, true);
				isFirst = false;
			} else {
				readList =  CsvUtils.readCsv(p.toString(), ENC, false);
			}
			if (readList == null) {
				continue;
			}
			outList.addAll(readList);
		}
		// Checkerの実装
		CsvUtils.CsvChecker check = new CsvUtils.CsvChecker() {

			@Override
			public String[] check(String[] data, int targetColumn, Object checkValue) {
				System.out.println(data[targetColumn]);
				if (data[targetColumn].equals((String) checkValue)) {
					System.out.println("CSV: " + data[targetColumn] + " = " + (String) checkValue);
					return data;
				}
				System.out.println("CSV: is Null");
				return null;
			}

		};

		CsvUtils.exportTarget(outList, DST_PATH + "export2.csv", check, CsvUtils.CsvChecker.ログイン回数, "0");
	}
}
