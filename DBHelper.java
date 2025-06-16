import java.sql.*;

public class DBHelper {
    private static final String DB_URL = "jdbc:sqlite:sqldatos.db";

    public DBHelper() {
        crearTablaSiNoExiste();
    }

    private void crearTablaSiNoExiste() {
        String sql = "CREATE TABLE IF NOT EXISTS ahorros (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "litros_agua REAL," +
                "kilos_pet REAL," +
                "kwh_luz REAL," +
                "puntaje REAL," +
                "fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP);";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("❌ Error al crear tabla: " + e.getMessage());
        }
    }

    public void guardarAhorro(datos ahorro) {
        String sql = "INSERT INTO ahorros (litros_agua, kilos_pet, kwh_luz, puntaje) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, ahorro.getLitrosAgua());
            pstmt.setDouble(2, ahorro.getKilosPet());
            pstmt.setDouble(3, ahorro.getKwhLuz());
            pstmt.setDouble(4, ahorro.getPuntaje());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("❌ Error al guardar el registro: " + e.getMessage());
        }
    }
}
