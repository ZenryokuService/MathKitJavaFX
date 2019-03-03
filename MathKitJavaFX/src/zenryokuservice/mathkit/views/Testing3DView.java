/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.mathkit.views;

import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Box;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import zenryokuservice.mathkit.MathKitView;

/**
 * @author takunoji
 *
 * 2019/02/26
 */
public class Testing3DView extends Parent implements MathKitView {
	public Testing3DView() {
	}

	/* (non-Javadoc)
	 * @see zenryokuservice.mathkit.MathKitView#loadView(javafx.scene.layout.VBox)
	 */
	@Override
	public Parent loadView(VBox root) {
		Path path = new Path();

		MoveTo moveTo = new MoveTo();
		moveTo.setX(100.0f);
		moveTo.setY(100.0f);

		HLineTo hLineTo = new HLineTo();
		hLineTo.setX(170.0f);

		QuadCurveTo quadCurveTo = new QuadCurveTo();
		quadCurveTo.setX(220.0f);
		quadCurveTo.setY(160.0f);
		quadCurveTo.setControlX(200.0f);
		quadCurveTo.setControlY(20.0f);

		LineTo lineTo = new LineTo();
		lineTo.setX(175.0f);
		lineTo.setY(55.0f);

		ArcTo arcTo = new ArcTo();
		arcTo.setX(50.0f);
		arcTo.setY(50.0f);
		arcTo.setRadiusX(50.0f);
		arcTo.setRadiusY(50.0f);

		path.getElements().add(moveTo);
		path.getElements().add(hLineTo);
		path.getElements().add(quadCurveTo);
		path.getElements().add(lineTo);
		path.getElements().add(arcTo);
		root.getChildren().add(path);
	    return root;
	}

	/* (non-Javadoc)
	 * @see zenryokuservice.mathkit.MathKitView#useCamera()
	 */
	@Override
	public boolean useCamera() {
		return false;
	}

	private void pathTest() {
		Path path = new Path();
		// Step1
		MoveTo move = new MoveTo();
		move.setX(50.0);
		move.setY(50.0);
		// Step2
		LineTo line = new LineTo();
		line.setX(75.0);
		line.setY(75.0);
		// Step3
		path.getElements().add(move);
		path.getElements().add(line);
		// Step4
//		root.getChildren().add(path);
	}
	@Override
	public Camera getCamera() {
	    // カメラ
	    PerspectiveCamera camera = new PerspectiveCamera(false);
	    camera.getTransforms().addAll(
	    		new Rotate(-20, Rotate.Y_AXIS)
	    		, new Rotate(-20, Rotate.X_AXIS)
	    		, new Translate(0,0,-15)
	    		);
	    camera.setTranslateX(100);
	    camera.setTranslateY(-50);
	    camera.setTranslateZ(300);		
	    return camera;
	}
}
