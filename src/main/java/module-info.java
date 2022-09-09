module com.example.whack {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.management;

    opens com.example.whack to javafx.fxml;
    exports com.example.whack;
}