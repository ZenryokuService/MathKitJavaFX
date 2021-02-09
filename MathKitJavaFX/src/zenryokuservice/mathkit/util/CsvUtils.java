package zenryokuservice.mathkit.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

	/**
	 * CSVファイルを読み込みListで返却する。
	 *
	 * @param filePath 読み込むファイルのパス(完全パス)
	 * @param encordName UTF-0, SJISなどのエンコード名
	 * @return String配列のList
	 */
	public static List<String[]> readCsv(String filePath, String encordName) {
		List<String[]> dataList = new ArrayList<>();
		try {
			BufferedReader buf = Files.newBufferedReader(Paths.get(filePath), Charset.forName(encordName));
			String line = null;

			while((line = buf.readLine()) != null) {
				dataList.add(line.replaceAll("\" ", "").split(","));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;
	}

	/**
	 * CSVファイルを読み込みListで返却する。
	 *
	 * @param filePath 読み込むファイルのパス(完全パス)
	 * @param encordName UTF-0, SJISなどのエンコード名
	 * @param isHeader ヘッダー行を飛ばす場合にfalse
	 * @return String配列のList
	 */
	public static List<String[]> readCsv(String filePath, String encordName, boolean isHeader) {
		List<String[]> dataList = new ArrayList<>();
		try {
			BufferedReader buf = Files.newBufferedReader(Paths.get(filePath), Charset.forName("SJIS"));
			String line = null;

			if (isHeader) {
				// ヘッダーありの場合は上のメソッドを使用する
				return readCsv(filePath, encordName);
			}
			// 1行分を飛ばす
			buf.readLine();

			while((line = buf.readLine()) != null) {
				dataList.add(line.replaceAll("\" ", "").split(","));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;
	}

	/**
	 * List<String[]>のデータをCSV出力する
	 * @param dataList String[]配列のリスト
	 * @param exportPath 出力するCSVファイルのパス
	 */
	public static void exportCsv(List<String[]> dataList, String exportPath) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(exportPath));) {

			StringBuilder build = new StringBuilder();
			for (String[] data : dataList) {
				build.setLength(0);
				for (int i = 0; i < data.length; i++) {
					if (i == data.length - 1) {
						build.append(data[i]);
					} else {
						build.append(data[i] + ", ");
					}
				}
				writer.write(build.toString());
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
