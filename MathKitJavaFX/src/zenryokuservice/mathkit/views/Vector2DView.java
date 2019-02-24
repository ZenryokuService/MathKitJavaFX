/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.mathkit.views;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.rng.Random;
import org.nd4j.linalg.factory.Nd4j;

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import zenryokuservice.mathkit.MathKitView;

/**
 * @author takunoji
 *
 * 2019/02/24
 */
public class Vector2DView extends Parent implements MathKitView {
	/** キャンパスのサイズ */
	private static final double CANVAS_SIZE = 600.0;
	/** 画面の升目サイズ */
	private double span = 0.0;
	
	/* (non-Javadoc)
	 * @see zenryokuservice.mathkit.MathKitView#loadView(javafx.scene.layout.VBox)
	 */
	@Override
	public Parent loadView(VBox root) {
		Canvas canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);

		GraphicsContext ctx = canvas.getGraphicsContext2D();
		// 升目のサイズを指定
		span = 5.0;
		// グラフの土台を描画する
		drawGraphBase(ctx);

		// ベクトルを描画する
		drawVector(ctx);

		root.getChildren().add(canvas);
		return root;
	}

	private void drawVector(GraphicsContext ctx) {
		Random dom = Nd4j.getRandom();
		dom.setSeed(1);
		INDArray vec = Nd4j.rand(new int[] {4, 1}, 0.5, 1.0, dom);
		vec = vec.mul(100);
		ctx.setStroke(Color.BROWN);
		ctx.setLineWidth(2.0);
		Color[] c = {Color.RED, Color.BLUE, Color.YELLOW};
		for (int i = 0; i < vec.length(); i = i + 2) {
			System.out.println("x: " + vec.getDouble(i) + " y: "+ vec.getDouble(i + 1)); 
			Arrow ar = new Arrow(convertCenter(0.0, true), convertCenter(0.0, false)
					, convertCenter(vec.getDouble(i), true), convertCenter(vec.getDouble(i + 1), false));
			ar.drawArrow(ctx, c[i]);
		}
	}
	/**
	 * グラフの土台を描く
	 * @param ctx グラフィックコンテキスト
	 */
	private void drawGraphBase(GraphicsContext ctx) {
		ctx.setFont(new Font(15));
		double baseSize = CANVAS_SIZE / 2;
		ctx.strokeText("X", CANVAS_SIZE - 20, baseSize + 15);
		ctx.strokeText("Y", baseSize - 15, 15);
		ctx.strokeText("O", baseSize + 10, baseSize + 20);
		// 中点
		ctx.setStroke(Color.BLACK);
		double centerSize = 10.0;
		ctx.fillOval(baseSize - (centerSize / 2), baseSize - (centerSize /2), centerSize, centerSize);

		ctx.setStroke(Color.BLACK);
		ctx.setLineWidth(2.0);
		// X軸
		ctx.strokeLine(0, baseSize, CANVAS_SIZE, baseSize);
		// Y軸
		ctx.strokeLine(baseSize, 0, baseSize, CANVAS_SIZE);
		
		// 補助線
		ctx.setLineWidth(0.5);
		for (double i = -baseSize; i <= baseSize; i = i + span ) {
			if (i == 0 || i == 2 || i == 4) {
				continue;
			}
			// 縦の補助線
			ctx.strokeLine(i * span, 0, i * span, CANVAS_SIZE);
			// 横の補助線
			ctx.strokeLine(0, i * span, CANVAS_SIZE, i * span);
		}
	}

	/**
	 * X, Yの値をグラフ上の値から描画する座標に変換する。
	 * @param value グラフ上の値(0,0)は画面の中心
	 * @return 描画するCanvas上の値(0,0)は画面の左端
	 */
	private double convertCenter(double value, boolean isX) {
		double graphValue = 0;
		if (isX) {
			graphValue = value + (CANVAS_SIZE / 2);
		} else {
			// 画面上の見え方を調節するために10分の1にする
			graphValue = (CANVAS_SIZE / 2) - value;
		}
		return graphValue;
	}

	private class Arrow {
		private double startX;
		private double startY;
		private double endX;
		private double endY;
		// X軸の２点間距離
		private double wideX;
		// Y軸の2転換の曲
		private double wideY;

		/**
		 * コンストラクタ。矢印を描画します。
		 * 
		 * @param startX 矢印の始点X座標
		 * @param startY 矢印の始点Y座標
		 * @param endX 矢印の終点X座標
		 * @param endY 矢印の終点Y座標
		 */
		public Arrow(double startX, double startY, double endX, double endY) {
			this.startX = startX;
			this.startY = startY;
			this.endX = endX;
			this.endY = endY;
			this.wideX = endX - startX;
			this.wideY = endY - startY;
		}

		/**
		 * 矢印を描く
		 * @param ctx GraphicsContext
		 * @param color Colorクラスの定数
		 */
		public void drawArrow(GraphicsContext ctx, Color color) {
			// TODO-[矢印の頭の描画はちょいと待ち]
			double a = 1.0;
			ctx.setStroke(color);
			// 矢印の長いところ
			ctx.strokeLine(this.startX, this.startY, this.endX, this.endY);
		}
	}
}
