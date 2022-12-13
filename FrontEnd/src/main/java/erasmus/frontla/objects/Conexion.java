package erasmus.frontla.objects;

import java.sql.Connection;

public class Conexion {
    private Connection conection;
    private String url = "jdbc:mysql://localhost:3306/learningagreementdb";
    private String usuario = "root";
    private String contraseña = "";

    public Connection getConection() {
        return conection;
    }

    public void setConection(Connection conection) {
        this.conection = conection;
    }

}
