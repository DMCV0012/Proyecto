import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MostrarConsultorio extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 300, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("ADMINISTRATIVO", 500, 10, 300, 100, Color.BLACK, 25);

    private Texto txtMedico = new Texto("MEDICO", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtDia = new Texto("DIA", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtHora = new Texto("HORA", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtNroConsul = new Texto("NRO CONSULTORIO", 75, 240, 150, 25, Color.BLACK, 15);

    private Caja tbBuscar = new Caja(600, 240, 50, 30);
    private Caja tbmedico = new Caja(200, 120, 100, 30);
    private Caja tbdia = new Caja(200, 160, 100, 30);
    private Caja tbhora = new Caja(200, 200, 100, 30);
    private Caja tbnroconsul = new Caja(200, 240, 100, 30);

    private Boton btnCancelar = new Boton("CANCELAR", 450, 180, 125, 30);
    private Boton btnBuscar = new Boton("BUSCAR", 450, 240, 125, 30);
    private Boton btnModificar = new Boton("MODIFICAR", 450, 300, 125, 30);
    private Boton btnEleminar = new Boton("ELEMINAR", 450, 360, 125, 30);

    public MostrarConsultorio()
    {
        add(titulo);
        add(ventana);

        add(txtMedico);
        add(txtDia);
        add(txtHora);
        add(txtNroConsul);

        add(tbBuscar);
        add(tbmedico);
        add(tbdia);
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

    public void ImprimirConsultorio()
    {
        int pos = Integer.parseInt(tbBuscar.getText());
        Consultorio cons = DBA.getConsultorio(pos);        
        if (cons != null) {
            tbmedico.setText(cons.getMedico());
            tbdia.setText(cons.getDia());
            tbhora.setText(cons.getHora());
            tbnroconsul.setText(String.valueOf(cons.getNroConsul()));
        } else {
            JOptionPane.showMessageDialog(this, "Registro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ModificarConsultorio() {
        int pos = Integer.parseInt(tbBuscar.getText());
        String medico = tbmedico.getText();
        String dia = tbdia.getText();
        String hora = tbhora.getText();
        int nroConsul = Integer.parseInt(tbnroconsul.getText());

        Consultorio nuevoConsultorio = new Consultorio(medico, dia, hora, nroConsul);
        boolean success = DBA.ModificarConsultorio(pos, nuevoConsultorio);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarConsultorio() {
        int pos = Integer.parseInt(tbBuscar.getText());
        boolean sucess = DBA.EliminarConsultorio(pos);

        if(sucess){
            tbmedico.setText("");
            tbdia.setText("");
            tbhora.setText("");
            tbnroconsul.setText("");
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            ImprimirConsultorio();
        }
        
        if (e.getSource() == btnModificar) {
            ModificarConsultorio();
        }
        
        if (e.getSource() == btnEleminar) {
            EliminarConsultorio();
        }

        if (e.getSource() == btnCancelar) {
            VentanaConsultorio Vcon = new VentanaConsultorio();
            dispose();
        }
    }
}