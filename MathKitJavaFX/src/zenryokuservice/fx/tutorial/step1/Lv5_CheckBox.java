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
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
 * @see https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/checkbox.htm#CHDFEJCD
 * 2019/03/14
 */
public class Lv5_CheckBox extends Application {

	/**
	 * このメソッドは、Applicationクラス(JavaFXのフレームワーク部品)<br>
	 * のメソッドをオーバーライドする。
	 * {@link Application#launch(String...)}から呼び出される。
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// チュートリアルの乗っていない部分
		Group group = new Group();
		VBox virtical = new VBox();
		HBox horizonal = new HBox();

		/* チュートリアルにあるコード */
		//A checkbox without a caption
		CheckBox cb1 = new CheckBox();
		//A checkbox with a string caption
		CheckBox cb2 = new CheckBox("Second");

		cb1.setText("First");
		cb1.setSelected(true);

		// CheckBoxの動きの設定
		final String[] names = new String[]{"ore", "min", "twit"};
		final Image[] images = new Image[names.length];
		final ImageView[] icons = new ImageView[names.length];
		final CheckBox[] cbs = new CheckBox[names.length];

		// イメージ用のグループ
		Group gp = new Group();
		for (int i = 0; i < names.length; i++) {
		    final Image image = images[i] =
		        new Image("/" + names[i] + ".png");
		    final ImageView icon = icons[i] = new ImageView();
		    gp.getChildren().add(icon);
		    final CheckBox cb = cbs[i] = new CheckBox(names[i]);
		    cb.selectedProperty().addListener(
		        (ObservableValue<? extends Boolean> ov,
		            Boolean old_val, Boolean new_val) -> {
		                icon.setImage(new_val ? image : null);
		    });
		    virtical.getChildren().add(cb);
		}
		// Groupを追加する
//		group.getChildren().addAll(cb1, cb2);
		// チュートリアルでは省略されている
		virtical.getChildren().addAll(cb1, cb2);
		// チェックボックスの表示領域
		horizonal.getChildren().add(virtical);
		// イメージの表示領域
		Label iconSpace = new Label("Icon Space");
		iconSpace.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(5), Insets.EMPTY)));
		horizonal.getChildren().add(gp);
		group.getChildren().add(horizonal);

		// 毎度おなじみのコード(この部分はだいたい同じになる)
		Scene scene = new Scene(group, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("チュートリアル6");
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
