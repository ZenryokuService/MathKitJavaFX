package zenryokuservice.mathkit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * 数学キットアプリケーション。
 * このアプリケーションは、数学をJavaFXで理解していくためのアプリケーションです<br/>
 * <ul>
 * <li>数学=数式(公式など)をグラフを描画して理解します。</li>
 * <li></li>
 * </ul>
 * @author takunoji
 *
 * 2019/02/21
 */
public class MathKit extends Application {
	private static final String PROPERTIES_FILE_PATH = "/views.properties";
	/** 使用する画面を作成するクラスのリスト */
	private static List<Parent> childViewList;
	/** 画面のMap<画面名, 画面クラス> */
	private Map<String, MathKitView> childViewMap;

	/**
	 * コンストラクタ。
	 * <ul>
	 * <li>childViewMapを作成します。
	 * </ul>
	 */
	public MathKit() {
		childViewMap = new HashMap<>();
		loadChildView();

	}
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			// メインの画面
			childViewMap.get("LineChart").loadView(root); 
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * メインメソッド。
	 * <ul>
	 * <li>表示する画面のリスト(childViewList)を生成</li>
	 * <li>JavaFXを起動</li>
	 * </ul>
	 * @param args
	 */
	public static void main(String[] args) {
		MathKit main = new MathKit();
		launch(args);
	}

	/**
	 * views.propertiesに定義している、子画面をロードします。
	 * <ol>
	 * <li>resources/views.propertiesに完全クラス名を記載する</li>
	 * <li>画面名=完全クラス名</li>
	 * <li>TestView=zenryokuservice.mathkit.views.LineChartView</li>
	 * </ol>
	 */
	private void loadChildView() {
		Properties prop = new Properties();
		try {
			prop.load(getClass().getResourceAsStream(PROPERTIES_FILE_PATH));
		} catch (IOException ie) {
			ie.printStackTrace();
			System.exit(-1);
		}
		prop.keySet().stream().forEach(key-> {
			// key = 画面名
			String className = prop.getProperty(key.toString());
			try {
				Class<?> klass = Class.forName(className);
				MathKitView view = (MathKitView) klass.newInstance();
				childViewMap.put(key.toString(), view);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});;
		System.out.println("MapSize = " + childViewMap.values().size());
		if (childViewMap.size() == 0) {
			System.out.println("プロパティファイルに画面が登録されていません。");
			System.exit(-1);
		}
 	}
}
