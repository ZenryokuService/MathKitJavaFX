/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.fx.tutorial3d;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * チュートリアル「40 テキストへの効果の適用」＜パースペクティブを使用する部分＞
 * @author takunoji
 * @see https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/text-effects.htm
 * 2019/03/03
 */
public class JavaFx_3_PerspectiveTransform extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		PerspectiveTransform form = new PerspectiveTransform();
		// Ulの設定
		form.setUlx(10.0f);
		form.setUly(10.0f);
		// Urの設定
		form.setUrx(180.0f);
		form.setUry(50.0f);
		// Llの設定
		form.setLlx(10.0f);
		form.setLly(100.0f);
		// Lrの設定
		form.setLrx(180.0f);
		form.setLry(60.0f);
		// グループ
		Group group = new Group();
		group.setEffect(form);
		group.setCache(true);
		// 
		Rectangle rec = new Rectangle();
		rec.setX(10.0);
		rec.setY(10.0);
		rec.setWidth(280.0);
		rec.setHeight(80.0);
		rec.setFill(Color.BLUE);
		// 
		Text text = new Text();
		text.setX(20.0f);
		text.setY(65.0f);
		text.setText("Perspective");
		text.setFill(Color.YELLOW);
		text.setFont(Font.font(null, FontWeight.BOLD, 36));

		group.getChildren().addAll(rec, text);
		/* ****** 固定の部分 ***********/
		Scene scene = new Scene(group, 650, 150, Color.WHITE);
		primaryStage.setTitle("2nd JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * メインメソッド
	 * @param args プログラム引数
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
