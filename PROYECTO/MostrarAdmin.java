import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MostrarAdmin extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 200, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("ADMINISTRATIVO", 350, 10, 250, 100, Color.BLACK, 25);

    private Texto txtId = new Texto("ID", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtNombre = new Texto("NOMBRE", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtApellido = new Texto("APELLIDO", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtCargo = new Texto("CARGO", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtCi = new Texto("CI", 100, 280, 100, 25, Color.BLACK, 15);

    private Caja tbBuscar = new Caja(650, 180, 50, 30);
    private Caja tbnombre = new Caja(250, 120, 200, 25);
    private Caja tbapellido = new Caja(250, 160, 200, 25);
    private Caja tbcargo = new Caja(250, 200, 200, 25);
    private Caja tbci = new Caja(250, 240, 200, 25);
    private Caja tbid = new Caja(250, 280, 200, 25);

    private Boton btnCancelar = new Boton("CANCELAR", 500, 120, 125, 30);
    private Boton btnBuscar = new Boton("BUSCAR", 500, 180, 125, 30);
    private Boton btnModificar = new Boton("MODIFICAR", 500, 240, 125, 30);
    private Boton btnEleminar = new Boton("ELEMINAR", 500, 300, 125, 30);

    public MostrarAdmin()
    {
        add(titulo);
        add(ventana);

        add(txtNombre);
        add(txtApellido);
        add(txtCargo);
        add(txtCi);
        add(txtId);

        add(tbBuscar);
        add(tbnombre);
        add(tbapellido);
        add(tbcargo);
        add(tbci);
        add(tbid);

        add(btnCancelar);
        add(btnBuscar);
        add(btnEleminar);
        add(btnModificar);

        btnCancelar.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnEleminar.addActionListener(this);

        //CONFIG FRAME
        setLayout(null);
        setTitle("CLINICA HEALTH");
        setSize(735, 500);
        setVisible(true);
    }

    public void ImprimirAdministrador()
    {
        int pos = Integer.parseInt(tbBuscar.getText());
        Administrativo admin = DBA.getAdministrativo(pos);
        Usuario usu = DBA.getUsuario(pos);
        if (admin != null || usu != null) {
            tbid.setText(String.valueOf(admin.getId()));
            tbnombre.setText(admin.getNombre());
            tbapellido.setText(admin.getApellido());
            tbcargo.setText(admin.getCargo());
            tbci.setText(String.valueOf(admin.getCi()));
        } else {
            JOptionPane.showMessageDialog(this, "Registro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ModificarAdministrador() {
        int pos = Integer.parseInt(tbBuscar.getText());
        String nombre = tbnombre.getText();
        String apellido = tbapellido.getText();
        String cargo = tbcargo.getText();
        int id = Integer.parseInt(tbid.getText());
        int ci = Integer.parseInt(tbci.getText());

        Administrativo nuevoAdmin = new Administrativo( nombre, apellido, cargo, id, ci);
        boolean success = DBA.ModificarAdministrativo(pos, nuevoAdmin);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarAdministrador() {
        int pos = Integer.parseInt(tbBuscar.getText());
        boolean sucess = DBA.EliminarAdministrativo(pos);

        if(sucess){
            tbid.setText("");
            tbnombre.setText("");
            tbapellido.setText("");
            tbcargo.setText("");
            tbci.setText("");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            ImprimirAdministrador();
        }

        if (e.getSource() == btnModificar) {
            ModificarAdministrador();
        }
        
        if (e.getSource() == btnEleminar) {
            EliminarAdministrador();
        }

        if (e.getSource() == btnCancelar) {
            VentanaAdmin Vadmin = new VentanaAdmin();
            dispose();
        }
    }
}