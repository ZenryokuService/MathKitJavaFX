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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * OracleのJavaFXチュートリアル。
 * Labelクラスで「Hello World」
 * JavaDocです。このクラスは「@see」に記載しているサイトの<br>
 * チュートリアルをやります。このクラスではLabelクラスの使用法を実行します。
 * 
 * @author takunoji
 * @see https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/label.htm#CIHHFIBJ
 * 2019/03/03
 */
public class Lv1_Label extends Application {

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
		
		Label label2 = new Label("Text1");
		label2.setFont(new Font("Cambria", 32));
		label2.setLayoutX(20.0); // Xを移動しない
		label2.setLayoutY(30.0); // Yを３０下に下げる
		// サイズを変更する
		label2.setScaleX(1.5);
		label2.setScaleY(1.5);
		Image image = new Image(this.getClass().getResourceAsStream("woodTile.png"));
		Label label3 = new Label("Search", new ImageView(image));
		
		// 上のコンポーネント(Labelとか、イメージとか)
		group.getChildren().add(label2);
//group.getChildren().addAll(label1, label2/*, label3 */);
		// チュートリアルでは省略されている
		Scene scene = new Scene(group, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("チュートリアル１");
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
