/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.fx.tutorial.step3;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFXでのアニメーション(遷移)を行う。
 * 
 * @author takunoji
 * @see https://docs.oracle.com/javase/jp/8/javafx/visual-effects-tutorial/basics.htm
 * 2019/03/17
 */
public class FadeTransration extends Application {
	/**
	 * メインメソッド。
	 * 
	 * @param args プログラム引数
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 四角形を赤色から白に近づけて、また元に戻すアニメーションを行う。
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group gp = new Group();
		// チュートリアルにあるコード
		final Rectangle rect1 = new Rectangle(10, 10, 100, 100);
		rect1.setArcHeight(20);
		rect1.setArcWidth(20);
		rect1.setFill(Color.RED);
		FadeTransition ft = new FadeTransition(Duration.millis(3000), rect1);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();

		// シーンをステージに登録
		gp.getChildren().addAll(rect1);
		Scene scene = new Scene(gp, 450, 450);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Animation Basic1");
		primaryStage.show();
	}
}
