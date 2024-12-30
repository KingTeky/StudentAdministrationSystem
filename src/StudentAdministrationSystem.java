import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Main class for the StudentProfiles Management System.
 * This class sets up the GUI and handles user interactions.
 */


public class StudentAdministrationSystem extends Application {
    // Observable list to store student data
    private ObservableList<StudentProfiles> studentList = FXCollections.observableArrayList();

    /**
     * Starts the JavaFX application.
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("StudentProfiles Management System");

        // Main layout of the application
        BorderPane mainLayout = new BorderPane();

        // Top menu bar
        MenuBar menuBar = new MenuBar();
        Menu studentMenu = new Menu("StudentProfiles");
        MenuItem addStudent = new MenuItem("Add StudentProfiles");
        MenuItem updateStudent = new MenuItem("Update StudentProfiles");
        MenuItem viewStudent = new MenuItem("View StudentProfiles Details");
        studentMenu.getItems().addAll(addStudent, updateStudent, viewStudent);
        menuBar.getMenus().add(studentMenu);
        mainLayout.setTop(menuBar);

        // Center content area
        VBox centerContent = new VBox();
        Label welcomeLabel = new Label("Welcome to the StudentProfiles Management System");
        centerContent.getChildren().add(welcomeLabel);
        mainLayout.setCenter(centerContent);

        // Set the scene and show the stage
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Event handlers for menu items
        addStudent.setOnAction(e -> showAddStudentDialog());
        viewStudent.setOnAction(e -> showStudentDetails());
    }

    /**
     * Displays a dialog to add a new student.
     */
    private void showAddStudentDialog() {
        Stage addStudentStage = new Stage();
        addStudentStage.setTitle("Add StudentProfiles");

        VBox addStudentLayout = new VBox();
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField idField = new TextField();
        idField.setPromptText("StudentProfiles ID");
        Button submitButton = new Button("Submit");

        // Event handler for the submit button
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String id = idField.getText();
            if (name.isEmpty() || id.isEmpty()) {
                showAlert("Error", "Name and ID cannot be empty.");
            } else {
                addStudent(name, id);
                addStudentStage.close();
            }
        });

        addStudentLayout.getChildren().addAll(new Label("Enter StudentProfiles Details"), nameField, idField, submitButton);
        Scene addStudentScene = new Scene(addStudentLayout, 300, 200);
        addStudentStage.setScene(addStudentScene);
        addStudentStage.show();
    }

    /**
     * Displays a table with student details.
     */
    private void showStudentDetails() {
        Stage viewStudentStage = new Stage();
        viewStudentStage.setTitle("View StudentProfiles Details");

        TableView<StudentProfiles> studentTable = new TableView<>();
        TableColumn<StudentProfiles, String> nameColumn = new TableColumn<>("Name");
        TableColumn<StudentProfiles, String> idColumn = new TableColumn<>("StudentProfiles ID");

        studentTable.getColumns().addAll(nameColumn, idColumn);
        studentTable.setItems(studentList);

        VBox viewStudentLayout = new VBox(studentTable);
        Scene viewStudentScene = new Scene(viewStudentLayout, 400, 300);
        viewStudentStage.setScene(viewStudentScene);
        viewStudentStage.show();
    }

    /**
     * Adds a new student to the system.
     * @param name the name of the student
     * @param id the ID of the student
     */
    private void addStudent(String name, String id) {
        studentList.add(new StudentProfiles(name, id));
    }

    /**
     * Displays an alert dialog with the specified title and message.
     * @param title the title of the alert
     * @param message the message of the alert
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * The main method to launch the JavaFX application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    	}
	}
