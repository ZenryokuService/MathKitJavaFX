/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.mathkit;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;

/**
 * MathKitでの画面クラスに実装するインターフェース。
 * このインターフェースを実装しないと画面として使用できません。
 * 
 * @author takunoji
 * 2019/02/21
 */
public interface MathKitView {
	/** GameNのクラスタイプ=view */
	public static final int VIEW_CLASS_TYPE = 1;
	/** 作成した画面を取得する */
	public Parent loadView(VBox root);
}
