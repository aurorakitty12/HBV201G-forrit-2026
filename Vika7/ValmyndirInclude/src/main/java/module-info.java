module is.vidmot {
    requires javafx.controls;
    requires javafx.fxml;


    opens vidmot to javafx.fxml, javafx.controls;
    exports vidmot ;
}