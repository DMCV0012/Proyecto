import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MostrarPersonal  extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 200, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("PERSONAL", 400, 10, 150, 100, Color.BLACK, 25);

    private Texto txtId = new Texto("ID", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtNombre = new Texto("NOMBRE", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtApellido = new Texto("APELLIDO", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtEspecialidad = new Texto("ESPECIALIDAD", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtCargo = new Texto("CARGO", 100, 280, 100, 25, Color.BLACK, 15);
    private Texto txtCi = new Texto("CI", 100, 320, 100, 25, Color.BLACK, 15);

    private Caja tbBuscar = new Caja(650, 180, 50, 30);
    private Caja tbnombre = new Caja(250, 120, 200, 25);
    private Caja tbapellido = new Caja(250, 160, 200, 25);
    private Caja tbespecialidad = new Caja(250, 200, 200, 25);
    private Caja tbcargo = new Caja(250, 240, 200, 25);
    private Caja tbci = new Caja(250, 280, 200, 25);
    private Caja tbid = new Caja(250, 320, 200, 25);

    private Boton btnCancelar = new Boton("CANCELAR", 500, 120, 125, 30);
    private Boton btnBuscar = new Boton("BUSCAR", 500, 180, 125, 30);
    private Boton btnModificar = new Boton("MODIFICAR", 500, 240, 125, 30);
    private Boton btnEleminar = new Boton("ELEMINAR", 500, 300, 125, 30);

    public MostrarPersonal(){
        add(titulo);
        add(ventana);

        add(txtNombre);
        add(txtApellido);
        add(txtEspecialidad);
        add(txtCargo);
        add(txtCi);
        add(txtId);

        add(tbBuscar);
        add(tbnombre);
        add(tbapellido);
        add(tbespecialidad);
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

    public void ImprimirPersonal()
    {
        int pos = Integer.parseInt(tbBuscar.getText());
        Personal per = DBA.getPersonal(pos);
        if (per != null) {
            tbid.setText(String.valueOf(per.getId()));
            tbnombre.setText(per.getNombre());
            tbapellido.setText(per.getApellido());
            tbespecialidad.setText(per.getEspecialidad());
            tbcargo.setText(per.getCargo());
            tbci.setText(String.valueOf(per.getCi()));
        } else {
            JOptionPane.showMessageDialog(this, "Registro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ModificarPersonal() {
        int pos = Integer.parseInt(tbBuscar.getText());
        String nombre = tbnombre.getText();
        String apellido = tbapellido.getText();
        String especialidad = tbespecialidad.getText();
        String cargo = tbcargo.getText();
        int id = Integer.parseInt(tbid.getText());
        int ci = Integer.parseInt(tbci.getText());

        Personal nuevoPersonal = new Personal( nombre, apellido, especialidad, cargo, id, ci);
        boolean success = DBA.ModificarPersonal(pos, nuevoPersonal);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarPersonal() {
        int pos = Integer.parseInt(tbBuscar.getText());
        boolean sucess = DBA.EliminarPersonal(pos);

        if(sucess){
            tbid.setText("");
            tbnombre.setText("");
            tbapellido.setText("");
            tbespecialidad.setText("");
            tbcargo.setText("");
            tbci.setText("");
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            ImprimirPersonal();
        }

        if (e.getSource() == btnModificar) {
            ModificarPersonal();
        }
        
        if (e.getSource() == btnEleminar) {
            EliminarPersonal();
        }
        
        if (e.getSource() == btnCancelar) {
            VentanaPersonal Vper = new VentanaPersonal();
            dispose();
        }
    }
}