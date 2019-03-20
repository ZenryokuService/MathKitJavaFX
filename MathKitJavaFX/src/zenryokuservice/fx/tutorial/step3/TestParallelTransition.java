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
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * JavaFXでのアニメーション(パラレル遷移)を行う。
 * 
 * @author takunoji
 * @see https://docs.oracle.com/javase/jp/8/javafx/visual-effects-tutorial/basics.htm
 * 2019/03/17
 */
public class TestParallelTransition extends Application {
	/**
	 * メインメソッド。
	 * 
	 * @param args プログラム引数
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 四角形が線の上を移動すして、また元に戻すアニメーションを行う。(動画付き)
	 * @see https://www.youtube.com/watch?v=7ED4Czs2fdk&feature=youtu.be
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group gp = new Group();
		// チュートリアルにあるコード
		final Rectangle rect = new Rectangle(60, 60);
		rect.setArcHeight(15);
		rect.setArcWidth(15);
		rect.setFill(Color.DARKBLUE);
		rect.setTranslateX(50);
		rect.setTranslateY(75);

		FadeTransition fadeTransition = 
		  new FadeTransition(Duration.millis(3000), rect);
		fadeTransition.setFromValue(1.0f);
		fadeTransition.setToValue(0.3f);
		fadeTransition.setCycleCount(2);
		fadeTransition.setAutoReverse(true);

		TranslateTransition translateTransition =
		 new TranslateTransition(Duration.millis(2000), rect);
		translateTransition.setFromX(50);
		translateTransition.setToX(350);
		translateTransition.setCycleCount(2);
		translateTransition.setAutoReverse(true);

		RotateTransition rotateTransition = 
		 new RotateTransition(Duration.millis(800), rect);
		rotateTransition.setAxis(new Point3D(0, 10, 0));
		rotateTransition.setByAngle(360f);
		rotateTransition.setInterpolator(Interpolator.TANGENT(Duration.millis(100), 10000.0));
		rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
//		rotateTransition.setAutoReverse(true);

		ScaleTransition scaleTransition = 
		 new ScaleTransition(Duration.millis(2000), rect);
		scaleTransition.setToX(2f);
		scaleTransition.setToY(2f);
		scaleTransition.setCycleCount(2);
		scaleTransition.setAutoReverse(true);
		
		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(
		  fadeTransition,
		  translateTransition,
		  rotateTransition,
		  scaleTransition
		);
		parallelTransition.setCycleCount(Timeline.INDEFINITE);
		parallelTransition.play();
		// シーンをステージに登録
		gp.getChildren().addAll(rect);
		Scene scene = new Scene(gp, 450, 450);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Animation Basic3");
		primaryStage.show();
	}
}
