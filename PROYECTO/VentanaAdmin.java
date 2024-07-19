import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class VentanaAdmin extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 300, 100, Color.BLUE , 25);
    private Texto ventana = new Texto("ADMINISTRATIVO", 400, 10, 300, 100, Color.BLACK, 25);
    
    private Texto txtNombre = new Texto("NOMBRE", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtApellido = new Texto("APELLIDO", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtCargo = new Texto("CARGO", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtCi = new Texto("CI", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtId = new Texto("ID", 100, 280, 100, 25, Color.BLACK, 15);
    private Texto txtUsuario = new Texto("USUARIO", 100, 320, 100, 25, Color.BLACK, 15);
    private Texto txtPass = new Texto("CONTRASEÑA", 100, 360, 100, 25, Color.BLACK, 15);

    private Caja tbnombre = new Caja(200, 120, 200, 25);
    private Caja tbapellido = new Caja(200, 160, 200, 25);
    private Caja tbcargo = new Caja(200, 200, 200, 25);
    private Caja tbCi = new Caja(200, 240, 200, 25);
    private Caja tbId = new Caja(200, 280, 200, 25);
    private Caja tbusuario = new Caja(200, 320, 200, 25);
    private JPasswordField tbpass= new CajaPass(200, 360, 200, 25);

    private Boton menu = new Boton("", 625, 10, 80, 80);
    private Boton btnRegistrar = new Boton("REGISTRAR", 450, 120, 125, 30);
    private Boton btnCancelar = new Boton("CANCELAR", 450, 180, 125, 30);
    private Boton btnVisualizar = new Boton("VISUALIZAR", 450, 240, 125, 30);

    public VentanaAdmin()
    {
        ImageIcon Menu = new ImageIcon("F:/PROYECTO/iconos/Menu.png");

        menu.setIcon(Menu);

        add(titulo);
        add(ventana);

        add(txtNombre);
        add(txtApellido);
        add(txtCargo);
        add(txtCi);
        add(txtId);
        add(txtUsuario);
        add(txtPass);

        add(tbnombre);
        add(tbapellido);
        add(tbcargo);
        add(tbCi);
        add(tbId);
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

    public void RegistrarAdministrador(){
        String nom = tbnombre.getText();
        String ape = tbapellido.getText();
        String car = tbcargo.getText();
        String us = tbusuario.getText();
        String pas = tbpass.getText();
        int ci = Integer.parseInt(tbCi.getText());
        int id = Integer.parseInt(tbId.getText());
        
        Administrativo admin = new Administrativo(nom, ape, car, ci, id);
        DBA.setAdministrativo(admin);
        Usuario usu = new Usuario(us, pas); // Ajusta el constructor de Animal según corresponda
        DBA.setUsuario(usu);

        // Limpiar los campos después del registro
        tbId.setText("");
        tbnombre.setText("");
        tbapellido.setText("");
        tbcargo.setText("");
        tbCi.setText("");
        tbusuario.setText("");
        tbpass.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu) {
            Sistema sist = new Sistema();
            dispose();
        }

        if (e.getSource() == btnRegistrar) {
            RegistrarAdministrador();
        }

        if(e.getSource() == btnVisualizar){
            MostrarAdmin Madmin = new MostrarAdmin();
            dispose();
        }

        if (e.getSource() == btnCancelar) {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
}
