/**
 * Copyright (c) 2019-present Math Kit JavaFX Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Math Kit JavaFX Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.fx.tutorial3d;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * @author takunoji
 *
 * 2019/03/03
 */
public class JavaFx_2_TextFlow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		TextFlow textFlow = new TextFlow();
		Font font = new Font("Tahoma", 48);

		Text text1 = new Text("Hello World");
		text1.setFill(Color.RED);
		text1.setFont(font);

		Text text2 = new Text("Come on Baby!");
		text2.setFill(Color.BLUE);
		text2.setFont(new Font("Tahoma", 38));

		textFlow.getChildren().addAll(text1, text2);
		Group group = new Group(textFlow);
		Scene scene = new Scene(group, 650, 150, Color.WHITE);
		primaryStage.setTitle("2nd JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * メインメソッド
	 * @param args プログラム引数
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
