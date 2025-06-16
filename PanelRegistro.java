import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {
    private JTextField campoAgua, campoPet, campoLuz;
    private DBHelper db;

    public PanelRegistro() {
        db = new DBHelper();
        setLayout(new GridLayout(5, 2, 10, 10));

        campoAgua = new JTextField();
        campoPet = new JTextField();
        campoLuz = new JTextField();

        add(new JLabel("Litros de agua ahorrados:"));
        add(campoAgua);
        add(new JLabel("Kilos de PET reciclado vendidos:"));
        add(campoPet);
        add(new JLabel("Electricidad ahorrada (kWh):"));
        add(campoLuz);

        JButton guardarBtn = new JButton("Guardar");
        guardarBtn.addActionListener(e -> guardar());

        add(new JLabel());
        add(guardarBtn);
    }

    private void guardar() {
        try {
            double litros = Double.parseDouble(campoAgua.getText());
            double pet = Double.parseDouble(campoPet.getText());
            double luz = Double.parseDouble(campoLuz.getText());

            datos ahorro = new datos(litros, pet, luz);
            db.guardarAhorro(ahorro);

            JOptionPane.showMessageDialog(this,
                    " Registro guardado.\nTu puntaje ambiental es: " + String.format("%.2f", ahorro.getPuntaje()),
                    "Puntaje Ambiental", JOptionPane.INFORMATION_MESSAGE);

            campoAgua.setText("");
            campoPet.setText("");
            campoLuz.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "❌ Ingresa valores numéricos válidos.");
        }
    }
}
