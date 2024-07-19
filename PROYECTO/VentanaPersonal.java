import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class VentanaPersonal extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 300, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("PERSONAL", 400, 10, 300, 100, Color.BLACK, 25);

    private Texto txtId = new Texto("ID", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtNombre = new Texto("NOMBRE", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtApellido = new Texto("APELLIDO", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtEspecialidad = new Texto("ESPECIALIDAD", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtCargo = new Texto("CARGO", 100, 280, 100, 25, Color.BLACK, 15);
    private Texto txtCi = new Texto("CI", 100, 320, 100, 25, Color.BLACK, 15);
    private Texto txtUsuario = new Texto("USUARIO", 100, 360, 100, 25, Color.BLACK, 15);
    private Texto txtPass = new Texto("CONTRASEÑA", 100, 400, 100, 25, Color.BLACK, 15);

    private Caja tbid = new Caja(200, 120, 200, 25);
    private Caja tbnombre = new Caja(200, 160, 200, 25);
    private Caja tbapellido = new Caja(200, 200, 200, 25);
    private Caja tbespecialidad = new Caja(200, 240, 200, 25);
    private Caja tbcargo = new Caja(200, 280, 200, 25);
    private Caja tbci = new Caja(200, 320, 200, 25);
    private Caja tbusuario = new Caja(200, 360, 200, 25);
    private JPasswordField tbpass= new CajaPass(200, 400, 200, 25);

    private Boton menu = new Boton("", 625, 10, 80, 80);
    private Boton btnRegistrar = new Boton("REGISTRAR", 450, 120, 125, 30);
    private Boton btnCancelar = new Boton("CANCELAR", 450, 180, 125, 30);
    private Boton btnVisualizar = new Boton("VISUALIZAR", 450, 240, 125, 30);

    public VentanaPersonal()
    {
        ImageIcon Menu = new ImageIcon("G:/PROYECTO/iconos/Menu.png");

        menu.setIcon(Menu);

        add(titulo);
        add(ventana);

        add(txtNombre);
        add(txtApellido);
        add(txtEspecialidad);
        add(txtCargo);
        add(txtCi);
        add(txtId);
        add(txtUsuario);
        add(txtPass);

        add(tbnombre);
        add(tbapellido);
        add(tbespecialidad);
        add(tbcargo);
        add(tbci);
        add(tbid);
        add(tbusuario);
        add(tbpass);

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

    public void RegistrarPersonal(){
        String nom = tbnombre.getText();
        String ape = tbapellido.getText();
        String espe = tbespecialidad.getText();
        String car = tbcargo.getText();
        int ci = Integer.parseInt(tbci.getText());
        int id = Integer.parseInt(tbid.getText());
        String us = tbusuario.getText();
        String pas = tbpass.getText();

        Personal per = new Personal(nom, ape, espe, car, ci, id);
        DBA.setPersonal(per);
        Usuario usu = new Usuario(us, pas); // Ajusta el constructor de Animal según corresponda
        DBA.setUsuario(usu);

        // Limpiar los campos después del registro
        tbid.setText("");
        tbnombre.setText("");
        tbapellido.setText("");
        tbespecialidad.setText("");
        tbcargo.setText("");
        tbci.setText("");
        tbusuario.setText("");
        tbpass.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu) {
            Sistema sist = new Sistema();
            dispose();
        }

        if (e.getSource() == btnRegistrar) {
            RegistrarPersonal();
        }

        if (e.getSource() == btnVisualizar) {
            MostrarPersonal Mper = new MostrarPersonal();
            dispose();
        }

        if (e.getSource() == btnCancelar) {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
}