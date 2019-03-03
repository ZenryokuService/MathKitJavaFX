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
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import zenryokuservice.mathkit.MathKitView;

/**
 * @author takunoji
 *
 * 2019/02/28
 */
public class PracticeShapeView extends Parent implements MathKitView {

	/* (non-Javadoc)
	 * @see zenryokuservice.mathkit.MathKitView#loadView(javafx.scene.layout.VBox)
	 */
	@Override
	public Parent loadView(VBox root) {
		return null;
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
