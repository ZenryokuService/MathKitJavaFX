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
import zenryokuservice.mathkit.MathKitView;

/**
 * @author takunoji
 *
 * 2019/02/22
 */
public class Graphics2DView extends Parent implements MathKitView {

	/* (non-Javadoc)
	 * @see zenryokuservice.mathkit.MathKitView#loadView(javafx.scene.layout.VBox)
	 */
	@Override
	public Parent loadView(VBox root) {
		Canvas canvas = new Canvas(600, 600);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		// グラフの土台を作る
		drawGraphBase(ctx, root);
		root.getChildren().add(canvas);
		return root;
	}

	/**
	 * グラフの土台になる部分を描画します。
	 * @param ctx
	 * @param root
	 */
	private void drawGraphBase(GraphicsContext ctx, VBox root) {
		ctx.setStroke(Color.BLACK);
		ctx.setLineWidth(2.0);
		// X軸
		ctx.strokeLine(0, 250, 500, 250);
		// Y軸
		ctx.strokeLine(250, 0, 250, 500);
		// マスを作る
		double span = 500 / 4;
		ctx.setLineWidth(0.5);
		for (int i = 0; i <= 4; i++) {
			if (i == 0 || i == 2 || i == 4) {
				continue;
			}
			// 縦の補助線
			ctx.strokeLine(i * span, 0, i * span, 500);
			// 横の補助線
			ctx.strokeLine(0, i * span, 500, i * span);
		}
	}
}
