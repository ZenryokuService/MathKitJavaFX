/**
 * Copyright (c) 2012-present Lightweight Java Game Library All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name Lightweight Java Game Library nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 */
package zenryokuservice.mathkit.views;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Camera;
import javafx.scene.Parent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import zenryokuservice.mathkit.MathKitView;

/**
 * LineChartを表示する数学キットの子画面クラスです。
 * 
 * @author takunoji
 * 2019/02/21
 */
public class LineChartView extends Parent implements MathKitView {
	/** このクラスのインスタンス */
	private LineChartView instance;

	/** コンストラクタ */
	public LineChartView() {
	}

	/**
	 * LineChartを作成する。
	 * ND4Jで生成したデータをとりあえずで表示する。
	 * @see zenryokuservice.mathkit.MathKitView#loadView()
	 */
	@Override
	public Parent loadView(VBox root) {
		final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");       
        
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring, 2010");
                                
        XYChart.Series series = new XYChart.Series();
        series.setName("初めのグラフ");
        INDArray data = createRandomData();
        int inc = 0;
        System.out.println(data.getInt(0));
        series.getData().add(new XYChart.Data("Jan", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Feb", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Mar", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Apr", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("May", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Jun", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Jul", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Aug", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Sep", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Oct", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Nov", data.getDouble(inc++) * 100));
        series.getData().add(new XYChart.Data("Dec", data.getDouble(inc++) * 100));

        root.getChildren().add(lineChart);
        // データのセット
        lineChart.getData().add(series);
		return root;
	}

	/**
	 * ND4Jでのデータ作成処理。
	 * 
	 * @return INDArray 生成したデータ
	 */
	private INDArray createRandomData() {
		// １〜１２月までの平均気温一覧(テストデータ)
		INDArray res = Nd4j.rand(1, 12);
		System.out.println(res);
		return res;
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
