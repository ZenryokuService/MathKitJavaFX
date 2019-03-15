/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.fx.tutorial.step1;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * OracleのJavaFXチュートリアル。
 * RadioButton表示します。
 * JavaDocです。このクラスは「@see」に記載しているサイトの<br>
 * チュートリアルをやります。このクラスではLabelクラスの使用法を実行します。
 * 
 * @author takunoji
 * @see https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/radio-button.htm#BABBJBDA
 * 2019/03/03
 */
public class Lv3_RadioButton extends Application {

	/**
	 * このメソッドは、Applicationクラス(JavaFXのフレームワーク部品)<br>
	 * のメソッドをオーバーライドする。
	 * {@link Application#launch(String...)}から呼び出される。
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// チュートリアルには省略されているものから変更
		// 横のレイアウト
		HBox lineLayout = new HBox();
		// 縦のレイアウト
		VBox group = new VBox(20d);
		// 横のレイアウトに追加
		lineLayout.getChildren().add(group);

		/* トグル・グループの追加
		 * トグルが設定されているラジオボタンは
		 * １つのグループとして扱われる
		 */
		final ToggleGroup togle = new ToggleGroup();
		//A radio button with an empty string for its label
		RadioButton rb1 = new RadioButton();
		//Setting a text label
		rb1.setText("Home");
		rb1.setToggleGroup(togle);
		rb1.setSelected(true);
		// イベント用UserData
		rb1.setUserData("home");
		// 縦のレイアウトに追加
		group.getChildren().add(rb1);
		//A radio button with the specified label
		RadioButton rb2 = new RadioButton("Calendar");
		rb2.setToggleGroup(togle);
		// イベント用UserData
		rb2.setUserData("calendar");
		// 縦のレイアウトに追加
		group.getChildren().add(rb2);

		RadioButton rb = new RadioButton("Agree");
		// イベント用UserData
		rb.setUserData("contacts");
		// サイズを合わせる
		rb.setToggleGroup(togle);
		// 縦のレイアウトに追加
		group.getChildren().add(rb);
		
		// 横のレイアウトに追加
		ImageView imageView = new ImageView();
		lineLayout.getChildren().add(imageView);
		final Map<String, Image> imageMap = createImageMap(imageView);

		// イベント処理
		togle.selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) ->{
					if (togle.getSelectedToggle() != null) {
						String userData = togle.getSelectedToggle().getUserData().toString();
						imageView.setImage(imageMap.get(userData));
					}
				});
		// 上のコンポーネント(Labelとか、イメージとか)
		// チュートリアルでは省略されている
		Scene scene = new Scene(lineLayout, 1000, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("チュートリアル4");
		primaryStage.show();
	}

	private Map<String, Image> createImageMap(ImageView imageView) {
		Map<String, Image> imgMap = new HashMap<>();
		// イメージファイルの読み込み
		Image img0 = new Image("/home.png");
		// 初期表示はhome.png
		imageView.setImage(img0);
		imgMap.put("home", img0);
		// イメージファイルの読み込み
		Image img1 = new Image("/calendar.png");
		imgMap.put("calendar", img1);
		// イメージファイルの読み込み
		Image img2 = new Image("/contacts.png");
		imgMap.put("contacts", img2);

		return imgMap;
	}

	/** チュートリアルに乗っていた、元々のコード */
	private void originCode(VBox group) {
		/* トグル・グループの追加
		 * トグルが設定されているラジオボタンは
		 * １つのグループとして扱われる
		 */
		final ToggleGroup togle = new ToggleGroup();
		RadioButton rb1 = new RadioButton();
		//Setting a text label
		rb1.setText("Home");
		rb1.setToggleGroup(togle);
		rb1.setSelected(true);
		group.getChildren().add(rb1);
		// イメージファイルの読み込み
		Image img0 = new Image("/home.png");
		rb1.setGraphic(new ImageView(img0));
		//A radio button with the specified label
		RadioButton rb2 = new RadioButton("Calendar");
		rb2.setToggleGroup(togle);
		// イメージファイルの読み込み
		Image img1 = new Image("/calendar.png");
		rb2.setGraphic(new ImageView(img1));
		group.getChildren().add(rb2);

		// イメージファイルの読み込み
		Image img2 = new Image("/contacts.png");
		RadioButton rb = new RadioButton("Agree");
		rb.setGraphic(new ImageView(img2));
		rb.setToggleGroup(togle);
		group.getChildren().add(rb);	}
	/**
	 * メインメソッド。
	 * Apllicationクラスのlaunchメソッドを呼び出す。
	 * 
	 * @param args プログラム引数
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
