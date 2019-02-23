/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.mathkit.views;

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import zenryokuservice.mathkit.MathKitView;

/**
 * @author takunoji
 *
 * 2019/02/22
 */
public class Graphics2DView extends Parent implements MathKitView {
	/** CanvasSize */
	private static final int CANVAS_SIZE = 600;
	/* (non-Javadoc)
	 * @see zenryokuservice.mathkit.MathKitView#loadView(javafx.scene.layout.VBox)
	 */
	@Override
	public Parent loadView(VBox root) {
		Text txt = new Text("y = ax");
		txt.setFont(new Font(20));
		txt.setTextAlignment(TextAlignment.RIGHT);
		root.getChildren().add(txt);
		Canvas canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		// グラフの土台を作る
		drawGraphBase(ctx, root);
		// 関数を描画する
		drawFunction(ctx, root);
		root.getChildren().add(canvas);
		return root;
	}

	/**
	 * グラフの土台になる部分を描画します。
	 * @param ctx Canvasから取得したクラス
	 * @param root レイアウトクラス(シーン追加する)
	 */
	private void drawGraphBase(GraphicsContext ctx, VBox root) {
		ctx.setStroke(Color.BLACK);
		ctx.setLineWidth(2.0);
		// X軸
		ctx.strokeLine(0, CANVAS_SIZE / 2, CANVAS_SIZE, CANVAS_SIZE / 2);
		// Y軸
		ctx.strokeLine(CANVAS_SIZE / 2, 0, CANVAS_SIZE / 2, CANVAS_SIZE);
		// マスを作る
		double span = CANVAS_SIZE / 4;
		ctx.setLineWidth(0.5);
		for (int i = 0; i <= 4; i++) {
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
	 * 関数を描画する。
	 * @param ctx Canvasから取得したクラス
	 * @param root レイアウトクラス(シーン追加する)
	 */
	private void drawFunction(GraphicsContext ctx, VBox root) {
		/* 座標系を画面の端っこ(0, 0)を画面の中心にする */
		ctx.setFill(Color.RED);
		// 傾き
		int a = 1;
		for (int x = -(CANVAS_SIZE / 2); x <= (CANVAS_SIZE / 2); x++) {
			int y = y_ax(a, x);
			ctx.fillOval(convertCenter(x, true), convertCenter(y, false), 2, 2);
		}
	}

	/**
	 * X, Yの値をグラフ上の値から描画する座標に変換する。
	 * @param value グラフ上の値(0,0)は画面の中心
	 * @return 描画するCanvas上の値(0,0)は画面の左端
	 */
	private double convertCenter(int value, boolean isX) {
		int graphValue = 0;
		if (isX) {
			graphValue = value + (CANVAS_SIZE / 2);
		} else {
			graphValue = (CANVAS_SIZE / 2) - value;
		}
		return graphValue;
	}
	/**
	 * y=axの計算を行う。
	 * @param a 傾き
	 * @param x Xの値
	 * @return yの値
	 */
	private int y_ax(int a, int x) {
		return a * x;
	}
}
