/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.fx.tutorial.step2;

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
 * <dl>
 * <dt>チュートリアル「40 テキストへの効果の適用」を実装する</dt>
 * <dd>JavaFx_3_PerspectiveTransformをリファクタリングして</dd>
 * <dd>メソッドをたくさん作成できるようにした。</dd>
 * </dl>
 * @author takunoji
 *　@see https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/text-effects.htm
 * 2019/03/03
 */
public class JavaFx_3_Refact extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// グループ
		Group group = createView(new Group());
		/* ****** 固定の部分 ***********/
		Scene scene = new Scene(group, 650, 150, Color.WHITE);
		primaryStage.setTitle("2nd JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * チュートリアルのソース部分を実装します。
	 * @param group チュートリアルでは「g」とかの変数名になっているので注意
	 * @return　作成した画面(Group)
	 */
	private Group createView(Group group) {
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
		return group;
	}
	/**
	 * メインメソッド
	 * @param args プログラム引数
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
