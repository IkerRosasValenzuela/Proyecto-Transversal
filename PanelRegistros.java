import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class PanelRegistros extends JPanel {
    private JTextArea areaTexto;

    public PanelRegistros() {
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        JButton actualizar = new JButton("Actualizar");
        actualizar.addActionListener(e -> cargarRegistros());

        add(scroll, BorderLayout.CENTER);
        add(actualizar, BorderLayout.SOUTH);

        cargarRegistros();
    }

    private void cargarRegistros() {
        areaTexto.setText("");
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sqldatos.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ahorros")) {

            while (rs.next()) {
                String linea = String.format("ID: %d | Agua: %.2f L | PET: %.2f kg | Luz: %.2f kWh | Puntaje: %.2f \n",
                        rs.getInt("id"),
                        rs.getDouble("litros_agua"),
                        rs.getDouble("kilos_pet"),
                        rs.getDouble("kwh_luz"),
                        rs.getDouble("puntaje"),
                        rs.getString("fecha"));
                areaTexto.append(linea);
            }

        } catch (SQLException e) {
            areaTexto.setText("Error al cargar registros: " + e.getMessage());
        }
    }
}
