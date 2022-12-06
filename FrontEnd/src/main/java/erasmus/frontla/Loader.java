package erasmus.frontla;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class Loader {

        public static URL LoaderViewCont(String path) throws IOException {
            return Loader.class.getResource(path);
        }
    public static AnchorPane LoaderView(String path) throws IOException {
        return FXMLLoader.load(Loader.class.getResource(path));
    }
}
