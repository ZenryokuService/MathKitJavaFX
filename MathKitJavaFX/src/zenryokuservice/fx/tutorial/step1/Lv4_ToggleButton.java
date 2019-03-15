/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.fx.tutorial.step1;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * OracleのJavaFXチュートリアル。
 * ToggleButton表示します。
 * JavaDocです。このクラスは「@see」に記載しているサイトの<br>
 * チュートリアルをやります。このクラスではLabelクラスの使用法を実行します。
 * 
 * @author takunoji
 * @see https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/toggle-button.htm#CACJDICF
 * 2019/03/08
 */
public class Lv4_ToggleButton extends Application {

	/**
	 * このメソッドは、Applicationクラス(JavaFXのフレームワーク部品)<br>
	 * のメソッドをオーバーライドする。
	 * {@link Application#launch(String...)}から呼び出される。
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// チュートリアルの乗っていない部分
		Group group = new Group();

		// トグルグループ
		ToggleGroup toggleGroup = new ToggleGroup();

		ToggleButton tb1 = new ToggleButton("Minor");
		tb1.setToggleGroup(toggleGroup);

		ToggleButton tb2 = new ToggleButton("Major");
		tb2.setToggleGroup(toggleGroup);

		ToggleButton tb3 = new ToggleButton ("Critical");
		tb3.setToggleGroup(toggleGroup);

		// ユーザーデータを追加
		tb1.setUserData(Color.LIGHTGREEN);
		tb2.setUserData(Color.LIGHTBLUE);
		tb3.setUserData(Color.SALMON);
		// 四角の領域
		Rectangle rect = new Rectangle();
		rect.setHeight(50);
		rect.setFill(Color.WHITE);
		rect.setStroke(Color.DARKGRAY);
		rect.setStrokeWidth(2);
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		// 横のレイアウト
		HBox lineLayout = new HBox();
		lineLayout.getChildren().addAll(tb1, tb2, tb3);
		// 縦のレイアウト
		VBox vbox = new VBox();
		vbox.getChildren().add(lineLayout);
		vbox.getChildren().add(rect);

		// トグルボタンのイベント処理
		toggleGroup.selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {
					System.out.println(lineLayout.getWidth());
					rect.setWidth(lineLayout.getWidth());
					if (newToggle == null) {
						System.out.println("null: ");
						rect.setFill(Color.WHITE);
					} else {
						System.out.println("!= null: ");
						rect.setFill((Color) toggleGroup.getSelectedToggle().getUserData());
					}
		});

		// Groupを追加する
		group.getChildren().addAll(vbox);
		// チュートリアルでは省略されている
		Scene scene = new Scene(group, 300, 300);
		// ここでサイズを指定する
		vbox.setPrefWidth(scene.getWidth());
		rect.setWidth(scene.getWidth());
		rect.setHeight(scene.getHeight());
		primaryStage.setScene(scene);
		primaryStage.setTitle("チュートリアル5");
		primaryStage.show();
	}

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
