package br.com.acmecorp.controller;
	
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			final StageStyle stageStyle = configStageStyle();
			
			System.out.println(getClass().getResource("").getPath());
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/layouts/main.fxml"));
			BorderPane rootGroup = fxmlLoader.load();
	        final SampleController controller = fxmlLoader.getController();
	        controller.setStage(primaryStage);
	        controller.setupBinding(stageStyle);
	        
	        Scene scene = new Scene(rootGroup, 500, 300);
	        scene.setFill(Color.TRANSPARENT);
	        scene.getStylesheets().add(getClass().getResource("/assets/css/application.css").toExternalForm());
	        
	        primaryStage.setScene(scene);
	        primaryStage.setOnCloseRequest(we -> System.out.println("Stage is closing"));
	        primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private StageStyle configStageStyle() {
        StageStyle stageStyle = StageStyle.DECORATED;
        List<String> unnamedParams = getParameters().getUnnamed();
        if (unnamedParams.size() > 0) {
            String stageStyleParam = unnamedParams.get(0);
            if (stageStyleParam.equalsIgnoreCase("transparent")) {
                stageStyle = StageStyle.TRANSPARENT;
            } else if (stageStyleParam.equalsIgnoreCase("undecorated")) {
                stageStyle = StageStyle.UNDECORATED;
            } else if (stageStyleParam.equalsIgnoreCase("utility")) {
                stageStyle = StageStyle.UTILITY;
            }
        }
        return stageStyle;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
