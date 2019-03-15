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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * OracleのJavaFXチュートリアル。
 * Button表示します。
 * JavaDocです。このクラスは「@see」に記載しているサイトの<br>
 * チュートリアルをやります。このクラスではLabelクラスの使用法を実行します。
 * 
 * @author takunoji
 * @see https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/button.htm
 * 2019/03/03
 */
public class Lv2_Button extends Application {

	/**
	 * このメソッドは、Applicationクラス(JavaFXのフレームワーク部品)<br>
	 * のメソッドをオーバーライドする。
	 * {@link Application#launch(String...)}から呼び出される。
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// チュートリアルには省略されている部分
		Group group = new Group();
		// この部分がチュートリアルに記載されている。

		// Fontを使用する方法
		Label label1 = new Label();
		label1.setFont(new Font("Aeial", 30));
		label1.setText("Text1");
		label1.setTranslateX(60);
		label1.setTranslateY(60);

		// 回転させる
		label1.setRotate(-45.0);

		// ボタンを追加する
		Button btn = new Button("ボタン");
		btn.setLayoutX(100.0);
		btn.setLayoutY(120.0);
		// イメージファイルの読み込み
		Image img = new Image(this.getClass().getResourceAsStream("check.png"));
		btn.setGraphic(new ImageView(img));
		// アクションの追加
		btn.setOnAction(event -> {
			label1.setRotate(label1.getRotate() + 15.0);
		});
		// 上のコンポーネント(Labelとか、イメージとか)
		group.getChildren().addAll(label1, btn);
		// チュートリアルでは省略されている
		Scene scene = new Scene(group, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("チュートリアル2");
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
