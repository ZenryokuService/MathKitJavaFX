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
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

/**
 * @author takunoji
 *
 * 2019/02/26
 */
public class Testing3D extends Application {


    public static void main(String[] args) 
    {
        Application.launch(args);
    }
     
    @Override
    public void start(Stage stage) 
    {
        // Create a Box
        Box box = new Box(100, 100, 100);
        box.setTranslateX(250);
        box.setTranslateY(0);
        box.setTranslateZ(400);
 
        // Create the Material
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.TAN);
        // Set the material for the box
        box.setMaterial(material);
         
        // Create a Box with texture
        Box textbox = new Box(100, 100, 100);
        textbox.setTranslateX(450);
        textbox.setTranslateY(50);
        textbox.setTranslateZ(400);
 
//        // Create the Material
//        PhongMaterial textureMaterial = new PhongMaterial();
//        // Create the Image
//        Image image = new Image("file:/img/core-logo-java.jpg");
//        textureMaterial.setDiffuseColor(Color.BEIGE);
//        textureMaterial.setDiffuseMap(image);
//        // Set the material for the box
//        textbox.setMaterial(textureMaterial);
         
        // Create a Light       
        PointLight light = new PointLight();
        light.setTranslateX(250);
        light.setTranslateY(100);
        light.setTranslateZ(300);
                         
        // Create a Camera to view the 3D Shapes
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(200);
        camera.setTranslateY(-50);
        camera.setTranslateZ(300);
 
        // Create the Group with both Boxes
        Group root = new Group(box, textbox);
         
        // Create a Scene with depth buffer enabled
        Scene scene = new Scene(root, 400, 200, true);
        // Add the Camera to the Scene
        scene.setCamera(camera);
 
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Set the Title of the Stage
        stage.setTitle("An Example with specified Material");
        // Display the Stage
        stage.show();       
    }
}
