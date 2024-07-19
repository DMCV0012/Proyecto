import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JPasswordField;
public class Login extends JFrame implements ActionListener
{
    Texto titulo= new Texto("Iniciar sesión", 10, 5, 150, 50, Color.BLACK, 25);

    Texto txtUsuario= new Texto("Nombre de Usuario", 20, 80, 150, 10, Color.BLACK, 15);
    Texto textPass= new Texto("Contraseña", 20, 110, 150, 10, Color.BLACK, 15);

    Caja tbUsuario= new Caja(150, 70, 90, 30);
    private JPasswordField tbPass= new CajaPass(150, 100, 90, 30);

    Boton btnAceptar= new Boton("ACEPTAR", 20, 150, 100, 30);
    Boton btnSalir= new Boton("CANCELAR", 150, 150, 100, 30);

    public Login()
    {
        //AÑADIR OBJETOS
        add(titulo);
        add(txtUsuario);
        add(tbUsuario);
        add(tbPass);
        add(textPass);

        add(btnAceptar);
        add(btnSalir);

        btnAceptar.addActionListener(this);
        btnSalir.addActionListener(this);

        //CONFIG FRAME
        setLayout(null);
        setTitle("LOGIN");
        setSize(300,250);
        setVisible(true);

        tbPass.setEchoChar('*');
    }

    public static void main()
    {
        Login login= new Login();
    }

    public static Sistema frmSistema;

    public void ingresar(){
        Usuario us= new Usuario(tbUsuario.getText(), tbPass.getText());
        String usu="admin";
        String pass="1234";
        if (DBA.existeUsuario(us) || (tbUsuario.getText().equals(usu) && tbPass.getText().equals(pass))) {
            frmSistema= new Sistema();
            dispose();
        } else {
            setTitle("ERROR");
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()== btnAceptar){
            ingresar();
            dispose();
        }

        if (e.getSource() == btnSalir) {
            // Obtener el componente raíz (ventana) que contiene el botón cancelar
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            // Cerrar la ventana actual
            window.dispose();
        }
    }
}