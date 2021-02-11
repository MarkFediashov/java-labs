module com.team.mavenproject1 {
    requires javafx.controls;
    requires java.desktop;
    requires java.logging;
    exports com.team.mavenproject1;
    requires jackson.databind;
    requires jackson.core;
    requires java.sql;
    
    exports com.team.mavenproject1.dto;
}
