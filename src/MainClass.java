import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass extends Application

{
    private BST newList;
    private TextField input;
    private TextArea list;

    public static void main(String[] args) throws FileNotFoundException {

        // launches the javaFX.
        launch(args);

    }

    /**
     * In this start method all the button characteristics and positions are declared and instantiated. The start() is used mainly for
     * the handlers specifically the Populate and Display button. User can paste a file pathway and then populate a BST with the contents
     * of that file. (line by line)
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        primaryStage.setTitle("Dictionary");
        newList = new BST();

        Button btnPopulate = new Button("Populate BST (after-pasting)");
        Button btnDisplay = new Button("Display (ABC order)");

        list = new TextArea(/*put list to display here*/);
        input = new TextField("Paste File Pathway");
        grid.add(list, 0, 0);
        grid.add(btnPopulate, 0, 35);
        grid.add(btnDisplay, 0, 33);
        grid.add(input,0,34);

        //setOnAction method puts a method call to a button
        btnPopulate.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Populate action button
             * @param event
             */
            @Override
            public void handle(ActionEvent event) {
                String fileName = input.getText();

                Scanner sc = null;
                try {
                    sc = new Scanner(new File(fileName));
                } catch (FileNotFoundException e) {
                    System.err.println("File not found");
                    return;
                }

                while (sc.hasNextLine())  {
                    newList.add(sc.nextLine());
                }
            }
        });

        //setOnAction method puts a method call to a button
        btnDisplay.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Display action button
             * @param event
             */
            @Override
            public void handle(ActionEvent event) {
                list.setText(fetchAllWords(newList.root));

            }
        });

        //For position alignment on the GUI along with show()
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        list.setPrefRowCount(15);
        list.setPrefColumnCount(35);
        primaryStage.setScene(new Scene(grid, 600, 550));
        primaryStage.show();
    }

    /** This fetchAllWords() is used mainly for the gathering of all the words from the BST nodes, both leftchild, rightchild,
     * and the root node. Some if statements placed in to check if there is even a node to search for or if there is a word in that node.
     * Big recursion method here.
     * @param start : start node to give access to the BSTNode nodes.
     * @return finishedString : which is the final bigString of all the words converted into String for the list purposes.
     *
     */
    public String fetchAllWords(BSTNode start){

        //empty bigString of words
        String finishedString = "";

        if(start.leftchild!=null){
            finishedString = fetchAllWords(start.leftchild);
        }

        finishedString = finishedString +"\n"+ start.data +" "+"("+"Occurences: "+start.count+")";

        if(start.rightchild!=null){
            finishedString = finishedString + fetchAllWords(start.rightchild);
        }

        return finishedString;
    }
}

// /Users/zakariasuleman/Desktop/morewords.txt
// /Users/zakariasuleman/Desktop/dictionary.txt