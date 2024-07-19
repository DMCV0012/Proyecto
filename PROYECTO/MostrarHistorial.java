import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MostrarHistorial extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 200, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("HISTORIAL", 400, 10, 150, 100, Color.BLACK, 25);
    
    private Texto txtNroConsul = new Texto("NRO CONSULTORIO", 100, 120, 150, 25, Color.BLACK, 15);
    private Texto txtMedico= new Texto("MEDICO", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtAdministrativo = new Texto("ADMINISTRATIVO", 100, 200, 150, 25, Color.BLACK, 15);
    private Texto txtPaciente = new Texto("PACIENTE", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtDescripcion = new Texto("DESCRIPCION", 100, 280, 100, 25, Color.BLACK, 15);
    
    private Caja tbBuscar = new Caja(650, 180, 50, 30);
    private Caja tbnroconsul = new Caja(270, 120, 200, 25);
    private Caja tbmedico = new Caja(270, 160, 200, 25);
    private Caja tbadministrativo = new Caja(270, 200, 200, 25);
    private Caja tbpaciente = new Caja(270, 240, 200, 25);
    private Caja tbdescripcion = new Caja(270, 280, 200, 25); 
    
    private Boton btnCancelar = new Boton("CANCELAR", 500, 120, 125, 30);
    private Boton btnBuscar = new Boton("BUSCAR", 500, 180, 125, 30);
    private Boton btnModificar = new Boton("MODIFICAR", 500, 240, 125, 30);
    private Boton btnEleminar = new Boton("ELEMINAR", 500, 300, 125, 30);
    
    public MostrarHistorial()
    {
        add(titulo);
        add(ventana);

        add(txtMedico);
        add(txtAdministrativo);
        add(txtPaciente);
        add(txtNroConsul);
        add(txtDescripcion);
        
        add(tbBuscar);
        add(tbmedico);
        add(tbadministrativo);
        add(tbpaciente);
        add(tbnroconsul);
        add(tbdescripcion);
        
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

    public void ImprimirHistorial()
    {
        int pos = Integer.parseInt(tbBuscar.getText());
        Historial his = DBA.getHistorial(pos);
        
        if (his != null) {
            tbnroconsul.setText(String.valueOf(his.getNroConsul()));
            tbmedico.setText(his.getMedico());
            tbadministrativo.setText(his.getAdministrativo());
            tbpaciente.setText(his.getPaciente());
            tbdescripcion.setText(his.getDescripcion());
        } else {
            JOptionPane.showMessageDialog(this, "Registro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ModificarHistorial() {
        int pos = Integer.parseInt(tbBuscar.getText());
        int nroConsul = Integer.parseInt(tbnroconsul.getText());
        String medico = tbmedico.getText();
        String administrativo = tbadministrativo.getText();
        String paciente = tbpaciente.getText();
        String descripcion = tbdescripcion.getText();

        Historial nuevoHistorial = new Historial(nroConsul, medico, administrativo, paciente, descripcion);
        boolean success = DBA.ModificarHistorial(pos, nuevoHistorial);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarHistorial() {
        int pos = Integer.parseInt(tbBuscar.getText());
        boolean sucess = DBA.EliminarHistorial(pos);
        if(sucess){
            tbnroconsul.setText("");
            tbmedico.setText("");
            tbadministrativo.setText("");
            tbpaciente.setText("");
            tbdescripcion.setText("");
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            ImprimirHistorial();
        }
        
        if (e.getSource() == btnModificar) {
            ModificarHistorial();
        }
        
        if (e.getSource() == btnEleminar) {
            EliminarHistorial();
        }

        if (e.getSource() == btnCancelar) {
            VentanaHistorial Vhis = new VentanaHistorial();
            dispose();
        }
    }
}
