/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.fx.tutorial.step3;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
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
 * JavaFXでのアニメーション(遷移)を行う。
 * 
 * @author takunoji
 * @see https://docs.oracle.com/javase/jp/8/javafx/visual-effects-tutorial/basics.htm
 * 2019/03/17
 */
public class TestPathTransition extends Application {
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
		rect.setArcHeight(50);
		rect.setArcWidth(50);
		rect.setFill(Color.ORANGE);

		Path path = new Path();
		path.getElements().add(new MoveTo(30,30));
		path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
		path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
		
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(10000));
		pathTransition.setPath(path);
		pathTransition.setNode(rect);
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(Timeline.INDEFINITE);
		pathTransition.setAutoReverse(true);
		pathTransition.play();
		// シーンをステージに登録
		gp.getChildren().addAll(rect, path);
		Scene scene = new Scene(gp, 450, 450);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Animation Basic2");
		primaryStage.show();
	}
}
