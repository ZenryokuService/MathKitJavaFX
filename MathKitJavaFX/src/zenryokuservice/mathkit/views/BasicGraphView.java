/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.mathkit.views;

import com.sun.prism.paint.Color;

import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import zenryokuservice.mathkit.MathKitView;

/**
 * @author takunoji
 *
 * 2019/02/23
 */
public class BasicGraphView extends Parent implements MathKitView {

	/* (non-Javadoc)
	 * @see zenryokuservice.mathkit.MathKitView#loadView(javafx.scene.layout.VBox)
	 */
	@Override
	public Parent loadView(VBox root) {
		double width = 300.0;
		double height = 300.0;

		// 横線
		double horizonalY = height / 2;
		double verticalX = width / 2;
		System.out.println("height; " + root.getHeight());
		System.out.println("width: " + root.getWidth());
		Line horizonal = new Line(0.0f, 100.0f, 300.0f, 100.0f);
		root.getChildren().add(horizonal);
		// 縦線
		Line vertical = new Line(150.0f, 0.0f, 150.0f, 300.0f);
		root.getChildren().add(vertical);
		return root;
	}

	/* (non-Javadoc)
	 * @see zenryokuservice.mathkit.MathKitView#useCamera()
	 */
	@Override
	public boolean useCamera() {
		return false;
	}

	/* (non-Javadoc)
	 * @see zenryokuservice.mathkit.MathKitView#getCamera()
	 */
	@Override
	public Camera getCamera() {
		return null;
	}

}
