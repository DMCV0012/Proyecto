import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class VentanaPaciente extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 300, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("PACIENTE", 400, 10, 300, 100, Color.BLACK, 25);

    private Texto txtNombre = new Texto("NOMBRE", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtApellido = new Texto("APELLIDO", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtDireccion = new Texto("DIRECCION", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtTelefono = new Texto("TELEFONO", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtCi = new Texto("CI", 100, 280, 100, 25, Color.BLACK, 15);

    private Caja tbnombre = new Caja(200, 120, 200, 25);
    private Caja tbapellido = new Caja(200, 160, 200, 25);
    private Caja tbdireccion = new Caja(200, 200, 200, 25);
    private Caja tbtelefono = new Caja(200, 240, 200, 25);
    private Caja tbci = new Caja(200, 280, 200, 25);

    private Boton menu = new Boton("", 625, 10, 80, 80);
    private Boton btnRegistrar = new Boton("REGISTRAR", 450, 120, 125, 30);
    private Boton btnCancelar = new Boton("CANCELAR", 450, 180, 125, 30);
    private Boton btnVisualizar = new Boton("VISUALIZAR", 450, 240, 125, 30);

    public VentanaPaciente()
    {
        ImageIcon Menu = new ImageIcon("G:/PROYECTO/iconos/Menu.png");

        menu.setIcon(Menu);

        add(titulo);
        add(ventana);

        add(txtNombre);
        add(txtApellido);
        add(txtDireccion);
        add(txtTelefono);
        add(txtCi);

        add(tbnombre);
        add(tbapellido);
        add(tbdireccion);
        add(tbtelefono);
        add(tbci);

        add(menu);
        add(btnRegistrar);
        add(btnCancelar);
        add(btnVisualizar);

        menu.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnRegistrar.addActionListener(this);
        btnVisualizar.addActionListener(this);

        //CONFIG FRAME
        setLayout(null);
        setTitle("CLINICA HEALTH");
        setSize(735, 500);
        setVisible(true);
    }

    public void RegistrarPaciente(){
        String nom = tbnombre.getText();
        String ape = tbapellido.getText();
        String dir = tbdireccion.getText();
        String tel = tbtelefono.getText();
        int ci = Integer.parseInt(tbci.getText());

        Paciente pac = new Paciente(nom, ape, dir, tel, ci);
        DBA.setPaciente(pac);

        tbnombre.setText("");
        tbapellido.setText("");
        tbdireccion.setText("");
        tbtelefono.setText("");
        tbci.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu) {
            Sistema sist = new Sistema();
            dispose();
        }

        if (e.getSource() == btnRegistrar) {
            RegistrarPaciente();
        }

        if (e.getSource() == btnVisualizar) {
            MostrarPaciente Mpac = new MostrarPaciente();
            dispose();
        }

        if (e.getSource() == btnCancelar) {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
}
