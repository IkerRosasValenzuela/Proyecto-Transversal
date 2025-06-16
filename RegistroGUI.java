import javax.swing.*;
import java.awt.*;

public class RegistroGUI extends JFrame {
    public RegistroGUI() {
        super("Registro Ambiental");

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Registrar Ahorro", new PanelRegistro());
        tabs.add("Ver Registros", new PanelRegistros());

        add(tabs);
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
