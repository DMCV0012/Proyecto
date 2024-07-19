import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MostrarPaciente extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 300, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("PACIENTE", 400, 10, 150, 100, Color.BLACK, 25);

    private Texto txtNombre = new Texto("NOMBRE", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtApellido = new Texto("APELLIDO", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtDireccion = new Texto("DIRECCION", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtTelefono = new Texto("TELEFONO", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtCi = new Texto("CI", 100, 280, 100, 25, Color.BLACK, 15);

    private Caja tbBuscar = new Caja(650, 180, 50, 30);
    private Caja tbnombre = new Caja(250, 120, 200, 25);
    private Caja tbapellido = new Caja(250, 160, 200, 25);
    private Caja tbdireccion = new Caja(250, 200, 200, 25);
    private Caja tbtelefono = new Caja(250, 240, 200, 25);
    private Caja tbci = new Caja(250, 280, 200, 25);

    private Boton btnCancelar = new Boton("CANCELAR", 500, 120, 125, 30);
    private Boton btnBuscar = new Boton("BUSCAR", 500, 180, 125, 30);
    private Boton btnModificar = new Boton("MODIFICAR", 500, 240, 125, 30);
    private Boton btnEleminar = new Boton("ELEMINAR", 500, 300, 125, 30);
    public MostrarPaciente()
    {
        add(titulo);
        add(ventana);

        add(txtNombre);
        add(txtApellido);
        add(txtDireccion);
        add(txtTelefono);
        add(txtCi);

        add(tbBuscar);
        add(tbnombre);
        add(tbapellido);
        add(tbdireccion);
        add(tbtelefono);
        add(tbci);

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

    public void ImprimirPaciente()
    {
        int pos = Integer.parseInt(tbBuscar.getText());
        Paciente pac = DBA.getPaciente(pos);
        if (pac != null) {
            tbnombre.setText(pac.getNombre());
            tbapellido.setText(pac.getApellido());
            tbdireccion.setText(pac.getDireccion());
            tbtelefono.setText(pac.getTelefono());
            tbci.setText(String.valueOf(pac.getCi()));
        } else {
            JOptionPane.showMessageDialog(this, "Registro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ModificarPaciente() {
        int pos = Integer.parseInt(tbBuscar.getText());
        String nombre = tbnombre.getText();
        String apellido = tbapellido.getText();
        String direccion = tbdireccion.getText();
        String telefono = tbtelefono.getText();
        int ci = Integer.parseInt(tbci.getText());

        Paciente nuevoPaciente = new Paciente(nombre, apellido, direccion, telefono, ci);
        boolean success = DBA.ModificarPaciente(pos, nuevoPaciente);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminarPaciente() {
        int pos = Integer.parseInt(tbBuscar.getText());
        boolean sucess = DBA.EliminarPaciente(pos);

        if(sucess){
            tbnombre.setText("");
            tbapellido.setText("");
            tbdireccion.setText("");
            tbtelefono.setText("");
            tbci.setText("");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            ImprimirPaciente();
        }

        if (e.getSource() == btnModificar) {
            ModificarPaciente();
        }
        
        if (e.getSource() == btnEleminar) {
            EliminarPaciente();
        }

        if (e.getSource() == btnCancelar) {
            VentanaPaciente Vpa = new VentanaPaciente();
            dispose();
        }
    }
}