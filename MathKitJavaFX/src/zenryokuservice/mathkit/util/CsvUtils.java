package zenryokuservice.mathkit.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

	/**
	 * メソッドをオーバーライドして使用してください
	 * exportTarget()と併用する
	 */
	public interface CsvChecker {
		public static final int 学部=0;
		public static final int 学年=1;
		public static final int 学科=2;
		public static final int ユーザID=3;
		public static final int 番号=4;
		public static final int 氏名=5;
		public static final int ログイン回数=6;
		public static final int 最終ログイン日=7;
		public static final int テスト最新実施日=8;
		public static final int ドリル最新実施日=9;
		public static final int Five教科平均点=10;
		public static final int テスト数学平均点=11;
		public static final int テスト国語平均点=12;
		public static final int テスト英語平均点=13;
		public static final int テスト理科平均点=14;
		public static final int テスト社会平均点=15;
		public static final int テスト数学クリア数=16;
		public static final int テスト国語クリア数=17;
		public static final int テスト英語クリア数=18;
		public static final int テスト理科クリア数=19;
		public static final int テスト社会クリア数=20;
		public static final int テスト数学実施回数=21;
		public static final int テスト国語実施回数=22;
		public static final int テスト英語実施回数=23;
		public static final int テスト理科実施回数=24;
		public static final int テスト社会実施回数=25;
		public static final int ドリル数学実施回数=26;
		public static final int ドリル国語実施回数=27;
		public static final int ドリル英語実施回数=28;
		public static final int ドリル理科実施回数=29;
		public static final int ドリル社会実施回数=30;
		public static final int テスト実施時間=31;
		public static final int ドリル実施時間=32;
		public static final int 合計学習時間=33;
		public static final int グループ=34;

		/**
		 * このメソッドをオーバーライド、
		 * @param data チェックするデータ
		 * @param checkValue 検証するデータ
		 * @return true: 対象データとして、判定する false: 対象データとしてない
		 */
		public String[] check(String[] data,int targetColmn, Object checkValue);
	};

	/**
	 * CSVファイルを読み込みListで返却する。
	 *
	 * @param filePath 読み込むファイルのパス(完全パス)
	 * @param encordName UTF-0, SJISなどのエンコード名
	 * @return String配列のList
	 */
	public static List<String[]> readCsv(String filePath, String encordName) {
		List<String[]> dataList = new ArrayList<>();
		String line = null;
		int lineNum = 0;
		try {
			BufferedReader buf = Files.newBufferedReader(Paths.get(filePath), Charset.forName(encordName));

			boolean isFirst = true;
			int cols = 0;
			while((line = buf.readLine()) != null) {
				if (isFirst) {
					cols = line.split(",").length;
					isFirst = false;
				}
				if (cols == line.split(",").length) {
					dataList.add(line.replaceAll("\" ", "").split(","));
				}
				lineNum++;
			}
			buf.close();
		} catch (MalformedInputException me) {
			System.out.println("ファイルがこわれています。: " + filePath + " >>> encode: " + encordName + " : " + lineNum);
			//me.printStackTrace();
		} catch (IOException e) {
			System.out.println("File: " + filePath + " >>> encode: " + encordName);
			//e.printStackTrace();
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
		String line = null;
		int lineNum = 0;
		try {

			if (isHeader) {
				// ヘッダーありの場合は上のメソッドを使用する
				return readCsv(filePath, encordName);
			}
			BufferedReader buf = Files.newBufferedReader(Paths.get(filePath), Charset.forName(encordName));
			// 1行分を飛ばす
			buf.readLine();

			boolean isFirst = true;
			int cols = 0;
			while((line = buf.readLine()) != null) {
				if (isFirst) {
					cols = line.split(",").length;
					isFirst = false;
				}
				if (cols == line.split(",").length) {
					dataList.add(line.replaceAll("\" ", "").split(","));
				}
			}
			buf.close();
		} catch (MalformedInputException me) {
			System.out.println("ファイルがこわれています。: " + filePath + " >>> encode: " + encordName + " : " + lineNum);
			dataList = null;
			//me.printStackTrace();
		} catch (IOException e) {
			System.out.println("File: " + filePath + " >>> encode: " + encordName);
			//e.printStackTrace();
			dataList = null;
		}
		return dataList;
	}

	/**
	 * List<String[]>のデータをCSV出力する
	 * @param dataList String[]配列のリスト
	 * @param exportPath 出力するCSVファイルのパス
	 */
	public static void exportCsv(List<String[]> dataList, String exportPath) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(exportPath), Charset.forName("SJIS"));) {

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
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * チェックしたいデータを判定するための処理を
	 * this.CsvChecker#checkをオーバーライドして判定する。
	 *
	 * @param dataList 対象のデータリスト
	 * @param exportPath 出力先の完全パス
	 * @param check チェックインターフェースの実装
	 * @param chValue 判定する値
	 */
	public static void exportTarget(List<String[]> dataList, String exportPath, CsvChecker check, int column, Object chValue) {

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(exportPath), Charset.forName("SJIS"));) {
			StringBuilder build = new StringBuilder();

			for (String[] data : dataList) {
				build.setLength(0);

				String[] res = check.check(data, column, chValue);
				if (res != null) {
					for (int i = 0; i < res.length; i++) {
						if (i == data.length - 1) {
							build.append(res[i]);
						} else {
							build.append(res[i] + ", ");
						}
					}
					writer.write(build.toString());
					writer.newLine();
				}
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 引数のパスにある*.csvを読み込み完全パスのリストを返却する
	 *
	 * @param path 対象ディレクトリ
	 * @return 対象ディレクトリにCSVファイルがない場合はNULLを返却
	 */
	public static List<Path> loadCsvFiles(String path) {
		List<Path> result = new ArrayList();
		File[] files = Paths.get(path).toFile().listFiles();
		for (File f : files) {
			if (f.getName().endsWith(".csv")) {
//				System.out.println(f.toString());
				result.add(f.toPath());
			}
		}
		if (result.size() == 0) {
			result = null;
		}
		return result;
	}
}
