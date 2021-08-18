// plum tree garden
// Smile.java

// tutorial to fx
//https://gluonhq.com/products/javafx/
//https://www.youtube.com/watch?v=bk28ytggz7E



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.Ellipse; 
import javafx.scene.shape.Polygon;
import javafx.scene.shape.*; 


public class Smile extends Application {
	@Override
	public void start(Stage primaryStage) 
	{
		
		Pane pane = new Pane();
		Circle face = new Circle();
		Circle leftPupil = new Circle();
		Circle rightPupil = new Circle();
		
		// set face
		face.centerXProperty().bind(pane.widthProperty().divide(2));
		face.centerYProperty().bind(pane.heightProperty().divide(2));
		face.setRadius(200);
		face.setStroke(Color.BLACK);
		face.setFill(Color.WHITE);

	      // set eyes
		 Ellipse leftEye = new Ellipse(); 
		 leftEye.setCenterX(200.0f); 
		 leftEye.setCenterY(200.0f); 
		 leftEye.setRadiusX(45.0f); 
		 leftEye.setRadiusY(30.0f); 
		 leftEye.setStroke(Color.BLACK);
		 leftEye.setFill(Color.WHITE);
	      
		 Ellipse rightEye = new Ellipse(); 
		 rightEye.setCenterX(300.0f); 
		 rightEye.setCenterY(200.0f); 
		 rightEye.setRadiusX(45.0f); 
		 rightEye.setRadiusY(30.0f); 
		 rightEye.setStroke(Color.BLACK);
		 rightEye.setFill(Color.WHITE); 
		
		
		 // set pupils
		 leftPupil.setCenterX(200);
		 leftPupil.setCenterY(200);
		 leftPupil.setStroke(Color.BLACK);
		 leftPupil.setRadius(20);
		
		 rightPupil.setCenterX(300);
		 rightPupil.setCenterY(200);
		 rightPupil.setStroke(Color.BLACK);
		 rightPupil.setRadius(20);
		
		 // create nose
	      Polygon nose = new Polygon();  
	      nose.getPoints().addAll(new Double[]{ 
	         250.0, 220.0, 
	         300.0, 300.0, 
	         200.0, 300.0, 
	      }); 

	      nose.setStroke(Color.BLACK);
	      nose.setFill(Color.WHITE);
	      
	      // create smile
	      Arc smile = new Arc();
	      smile.setCenterX(250.0f);
	      smile.setCenterY(325.0f);
	      smile.setRadiusX(100.0f);
	      smile.setRadiusY(25.0f);
	      smile.setStroke(Color.BLACK);
	      smile.setFill(Color.WHITE);
	      smile.setStartAngle(180.0f);
	      smile.setLength(180.0f);
		
	    // add children to pane  
		pane.getChildren().add(face);
		pane.getChildren().add(leftEye);
		pane.getChildren().add(rightEye);
		pane.getChildren().add(leftPupil);
		pane.getChildren().add(rightPupil);
		pane.getChildren().add(nose);
		pane.getChildren().add(smile);
		
		// create scene
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("Smile");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		// launch application
		Application.launch(args);
	}
}
