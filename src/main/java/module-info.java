module com.example.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires org.apache.logging.log4j;


    opens com.example.jfx to javafx.fxml;
    exports com.example.jfx;
}