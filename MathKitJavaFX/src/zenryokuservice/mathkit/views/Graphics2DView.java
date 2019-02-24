/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.mathkit.views;

import javafx.collections.ObservableList;
import javafx.scene.Node;
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
		ObservableList<Node> nodeList = root.getChildren();
		Text txt = new Text("y = ax");
		txt.setFont(new Font(20));
		txt.setTextAlignment(TextAlignment.RIGHT);
		nodeList.add(txt);
		Canvas canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		// グラフの土台を作る
		drawGraphBase(ctx, root);
		// 関数を描画する
		drawFunction(ctx, root);
		nodeList.add(canvas);
		return root;
	}

	/**
	 * グラフの土台になる部分を描画します。
	 * @param ctx Canvasから取得したクラス
	 * @param root レイアウトクラス(シーン追加する)
	 */
	private void drawGraphBase(GraphicsContext ctx, VBox root) {
		ctx.setFont(new Font(15));
		ctx.strokeText("X", CANVAS_SIZE - 20, (CANVAS_SIZE / 2) + 15);
		ctx.strokeText("Y", (CANVAS_SIZE / 2) - 15, 15);
		ctx.strokeText("0", CANVAS_SIZE / 2 + 10, CANVAS_SIZE / 2 + 20);
//		ctx.fillText("X軸", CANVAS_SIZE / 2, CANVAS_SIZE / 2);

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
		double a = 0.0001;
		for (double x = -(CANVAS_SIZE / 2); x <= (CANVAS_SIZE / 2); x = x + 0.1) {
			double y = y_ax3(a, x);
			//if (x == 1) System.out.println("==> " + y);
			ctx.fillOval(convertCenter(x, true), convertCenter(y, false), 2, 2);
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
	/**
	 * y=axの計算を行う。
	 * @param a 傾き
	 * @param x Xの値
	 * @return yの値
	 */
	private double y_ax(double a, double x) {
		return a * x;
	}

	/**
	 * 2次関数
	 * @param a 傾き
	 * @param x Xの値
	 * @return Yの値
	 */
	private double y_ax2(double a, double x) {
		double d = x / 1; 
		return a * Math.pow(d, 2.0);
	}

	/**
	 * 3次関数
	 * @param a 傾き
	 * @param x Xの値
	 * @return Yの値
	 */
	private double y_ax3(double a, double x) {
		return a * Math.pow(x, 3);
	}
}
