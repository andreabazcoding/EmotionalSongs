module com.studenti.uninsubria.emotionalsongs {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.studenti.uninsubria.emotionalsongs to javafx.fxml;
    exports com.studenti.uninsubria.emotionalsongs;
}