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
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * <dl>
 * <dt>チュートリアル「40 テキストへの効果の適用」＜リフレクション＞を実装する</dt>
 * <dd>InnerShadowクラスを使用して文字にぼかし効果を入れる</dd>
 * </dl>
 * @author takunoji
 *　@see https://docs.oracle.com/javase/jp/8/javafx/user-interface-tutorial/text-effects.htm
 * 2019/03/03
 */
public class JavaFx_3_Blend extends Application {
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
		// 例40-6
		Text tx = new Text();
		tx.setX(50.0f);
		tx.setY(50.0f);
		tx.setCache(true);

		TextField field = new TextField();
		field.setText("Wood Sign");
		tx.textProperty().bind(field.textProperty());
		// 例40-7
		Blend blend = new Blend();
		blend.setMode(BlendMode.MULTIPLY);

		DropShadow ds = new DropShadow();
		ds.setColor(Color.rgb(254, 235, 66, 0.3));
		ds.setOffsetX(5);
		ds.setOffsetY(5);
		ds.setRadius(5);
		ds.setSpread(0.2);

		blend.setBottomInput(ds);

		DropShadow ds1 = new DropShadow();
		ds1.setColor(Color.web("#f13a00"));
		ds1.setRadius(20);
		ds1.setSpread(0.2);

		Blend blend2 = new Blend();
		blend2.setMode(BlendMode.MULTIPLY);

		InnerShadow is = new InnerShadow();
		is.setColor(Color.web("#feeb42"));
		is.setRadius(9);
		is.setChoke(0.8);
		blend2.setBottomInput(is);

		InnerShadow is1 = new InnerShadow();
		is1.setColor(Color.web("#f13a00"));
		is1.setRadius(5);
		is1.setChoke(0.4);
		blend2.setTopInput(is1);

		Blend blend1 = new Blend();
		blend1.setMode(BlendMode.MULTIPLY);
		blend1.setBottomInput(ds1);
		blend1.setTopInput(blend2);

		blend.setTopInput(blend1);

		tx.setEffect(blend);

		group.getChildren().addAll(tx, field);
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
