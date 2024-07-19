import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MostrarCosto extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 200, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("PERSONAL", 400, 10, 150, 100, Color.BLACK, 25);

    private Texto txtMedico= new Texto("MEDICO", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtAdministrativo = new Texto("ADMINISTRATIVO", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtPaciente = new Texto("PACIENTE", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtNroConsul = new Texto("NRO CONSULTORIO", 75, 240, 150, 25, Color.BLACK, 15);
    private Texto txtCosto = new Texto("COSTO", 100, 280, 100, 25, Color.BLACK, 15);

    private Caja tbBuscar = new Caja(650, 180, 50, 30);
    private Caja tbmedico = new Caja(250, 120, 200, 30);
    private Caja tbadministrativo = new Caja(250, 160, 200, 25);
    private Caja tbpaciente = new Caja(250, 200, 200, 25);
    private Caja tbnroconsul = new Caja(250, 240, 200, 25);
    private Caja tbcosto = new Caja(250, 280, 200, 25);

    private Boton btnCancelar = new Boton("CANCELAR", 500, 120, 125, 30);
    private Boton btnBuscar = new Boton("BUSCAR", 500, 180, 125, 30);
    private Boton btnModificar = new Boton("MODIFICAR", 500, 240, 125, 30);
    private Boton btnEleminar = new Boton("ELEMINAR", 500, 300, 125, 30);

    public MostrarCosto()
    {
        add(titulo);
        add(ventana);

        add(txtMedico);
        add(txtAdministrativo);
        add(txtPaciente);
        add(txtNroConsul);
        add(txtCosto);

        add(tbBuscar);
        add(tbmedico);
        add(tbadministrativo);
        add(tbpaciente);
        add(tbnroconsul);
        add(tbcosto);

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

    public void ImprimirCosto()
    {
        int pos = Integer.parseInt(tbBuscar.getText());
        Costo cos = DBA.getCosto(pos);

        if (cos != null) {
            tbmedico.setText(cos.getMedico());
            tbadministrativo.setText(cos.getAdministrativo());
            tbpaciente.setText(cos.getPaciente());
            tbnroconsul.setText(String.valueOf(cos.getNroConsul()));
            tbcosto.setText(String.valueOf(cos.getCosto()));
        } else {
            JOptionPane.showMessageDialog(this, "Registro no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ModificarCosto() {
        int pos = Integer.parseInt(tbBuscar.getText());
        String medico = tbmedico.getText();
        String administrativo = tbadministrativo.getText();
        String paciente = tbpaciente.getText();
        int nroConsul = Integer.parseInt(tbnroconsul.getText());
        double costo = Double.parseDouble(tbcosto.getText());

        Costo nuevoCosto = new Costo(medico, administrativo, paciente, nroConsul, costo);
        boolean success = DBA.ModificarCosto(pos, nuevoCosto);

        if (success) {
            JOptionPane.showMessageDialog(this, "Registro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminarCosto() {
        int pos = Integer.parseInt(tbBuscar.getText());
        boolean sucess = DBA.EliminarCosto(pos);

        if(sucess){
            tbmedico.setText("");
            tbadministrativo.setText("");
            tbpaciente.setText("");
            tbnroconsul.setText("");
            tbcosto.setText("");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            ImprimirCosto();
        }

        if (e.getSource() == btnModificar) {
            ModificarCosto();
        }

        if (e.getSource() == btnEleminar) {
            EliminarCosto();
        }

        if (e.getSource() == btnCancelar) {
            VentanaCosto Vcos = new VentanaCosto();
            dispose();
        }
    }
}