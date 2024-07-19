import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MostrarConsulta extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 200, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("CONSULTA", 400, 10, 150, 100, Color.BLACK, 25);

    private Texto txtMedico= new Texto("MEDICO", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtPaciente = new Texto("PACIENTE", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtFecha = new Texto("FECHA", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtHora = new Texto("HORA", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtNroConsul = new Texto("NRO CONSULTORIO", 75, 280, 150, 25, Color.BLACK, 15);

    private Caja tbBuscar = new Caja(650, 180, 50, 30);
    private Caja tbmedico = new Caja(250, 120, 200, 30);
    private Caja tbpaciente = new Caja(250, 160, 200, 25);
    private Caja tbfecha = new Caja(250, 200, 200, 25);
    private Caja tbhora = new Caja(250, 240, 200, 25);
    private Caja tbnroconsul = new Caja(250, 280, 200, 25);

    private Boton btnCancelar = new Boton("CANCELAR", 500, 120, 125, 30);
    private Boton btnBuscar = new Boton("BUSCAR", 500, 180, 125, 30);
    private Boton btnModificar = new Boton("MODIFICAR", 500, 240, 125, 30);
    private Boton btnEleminar = new Boton("ELEMINAR", 500, 300, 125, 30);

    public MostrarConsulta()
    {
        add(titulo);
        add(ventana);

        add(txtMedico);

        add(txtPaciente);
        add(txtFecha);
        add(txtHora);
        add(txtNroConsul);

        add(tbBuscar);
        add(tbmedico);
        add(tbpaciente);
        add(tbfecha);
        add(tbhora);
        add(tbnroconsul);

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

    public void ImprimirConsulta()
    {
        int pos = Integer.parseInt(tbBuscar.getText());
        Consulta cons = DBA.getConsulta(pos);

        if (cons != null) {
            tbmedico.setText(cons.getMedico());
            tbpaciente.setText(cons.getPaciente());
            tbfecha.setText(cons.getFecha());
            tbhora.setText(cons.getHora());
            tbnroconsul.setText(String.valueOf(cons.getNroConsul()));
        } else {
            JOptionPane.showMessageDialog(this, "Registro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ModificarConsulta() {
        int pos = Integer.parseInt(tbBuscar.getText());
        String medico = tbmedico.getText();
        String paciente = tbpaciente.getText();
        String fecha = tbfecha.getText();
        String hora = tbhora.getText();
        int nroConsul = Integer.parseInt(tbnroconsul.getText());

        Consulta nuevaConsulta = new Consulta(medico, paciente, fecha, hora, nroConsul);
        boolean success = DBA.ModificarConsulta(pos, nuevaConsulta);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarConsulta() {
        int pos = Integer.parseInt(tbBuscar.getText());
        boolean sucess = DBA.EliminarConsulta(pos);

        if(sucess){
            tbmedico.setText("");
            tbpaciente.setText("");
            tbfecha.setText("");
            tbhora.setText("");
            tbnroconsul.setText("");
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            ImprimirConsulta();
        }
        
        if (e.getSource() == btnModificar) {
            ModificarConsulta();
        }
        
        if (e.getSource() == btnEleminar) {
            EliminarConsulta();
        }

        if (e.getSource() == btnCancelar) {
            VentanaConsulta Vcon = new VentanaConsulta();
            dispose();
        }
    }
}