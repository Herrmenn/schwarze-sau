package schwarzeSau;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


 public class NodeToPdf extends Application {

@Override
public void start(Stage primaryStage) {

    CategoryAxis xAxis = new CategoryAxis();
    xAxis.setLabel("x");
     NumberAxis yAxis = new NumberAxis();
    yAxis.setLabel("y");
    BarChart bar = new BarChart(xAxis, yAxis);
    bar.setMaxSize(300, 300);
    bar.setTitle("Bar node" );
    bar.setTranslateY(-100);

    Button btn = new Button();
    btn.setTranslateY(100);
    btn.setText("To Pdf'");



    btn.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            WritableImage nodeshot = bar.snapshot(new SnapshotParameters(), null);
            File file = new File("chart.png");

try {
    ImageIO.write(SwingFXUtils.fromFXImage(nodeshot, null), "png", file);
} catch (IOException e) {

}

            PDDocument doc    = new PDDocument();
            PDPage page = new PDPage();
            PDImageXObject pdimage;
            PDPageContentStream content;
            try {
                pdimage = PDImageXObject.createFromFile("chart.png",doc);
                content = new PDPageContentStream(doc, page);
                content.drawImage(pdimage, 100, 100);
                content.close();
                doc.addPage(page);
                doc.save("pdf_file.pdf");
                doc.close();
                file.delete();
            } catch (IOException ex) {
                Logger.getLogger(NodeToPdf.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    });


    StackPane root = new StackPane();

    root.getChildren().add(btn);
    root.getChildren().add(bar);




    Scene scene = new Scene(root, 600, 600);


    primaryStage.setScene(scene);
    primaryStage.show();
}


public static void main(String[] args) {
    launch(args);
}
