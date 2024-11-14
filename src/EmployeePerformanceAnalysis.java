import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EmployeePerformanceAnalysis extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, Employee Performance Analysis!");
        Scene scene = new Scene(label, 400, 300);
        primaryStage.setTitle("Employee Performance Analysis");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

