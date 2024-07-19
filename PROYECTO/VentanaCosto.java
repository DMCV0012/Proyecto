import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class VentanaCosto extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 300, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("COSTO", 400, 10, 300, 100, Color.BLACK, 25);

    private Texto txtMedico= new Texto("MEDICO", 50, 120, 150, 25, Color.BLACK, 15);
    private Texto txtAdministrativo = new Texto("ADMINISTRATIVO", 50, 160, 100, 25, Color.BLACK, 15);
    private Texto txtPaciente = new Texto("PACIENTE", 50, 200, 100, 25, Color.BLACK, 15);
    private Texto txtNroConsul = new Texto("NRO CONSULTORIO", 50, 240, 150, 25, Color.BLACK, 15);
    private Texto txtCosto = new Texto("COSTO", 50, 280, 100, 25, Color.BLACK, 15);

    private Caja tbmedico = new Caja(200, 120, 200, 25);
    private Caja tbadministrativo = new Caja(200, 160, 200, 25);
    private Caja tbpaciente = new Caja(200, 200, 200, 25);
    private Caja tbnroconsul = new Caja(200, 240, 200, 25);
    private Caja tbcosto = new Caja(200, 280, 200, 25);

    private Boton menu = new Boton("", 625, 10, 80, 80);
    private Boton btnRegistrar = new Boton("REGISTRAR", 450, 120, 125, 30);
    private Boton btnCancelar = new Boton("CANCELAR", 450, 180, 125, 30);
    private Boton btnVisualizar = new Boton("VISUALIZAR", 450, 240, 125, 30);

    public VentanaCosto()
    {
        ImageIcon Menu = new ImageIcon("G:/PROYECTO/iconos/Menu.png");

        menu.setIcon(Menu);

        add(titulo);
        add(ventana);

        add(txtMedico);
        add(txtAdministrativo);
        add(txtPaciente);
        add(txtNroConsul);
        add(txtCosto);

        add(tbmedico);
        add(tbadministrativo);
        add(tbpaciente);
        add(tbnroconsul);
        add(tbcosto);

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

    public void RegistrarCosto(){
        String med = tbmedico.getText();
        String admin = tbadministrativo.getText();
        String pac = tbpaciente.getText();
        int nc = Integer.parseInt(tbnroconsul.getText());
        double cs = Double.parseDouble(tbcosto.getText());

        Costo cost = new Costo(med, admin, pac, nc, cs);
        DBA.setCosto(cost);

        tbmedico.setText("");
        tbadministrativo.setText("");
        tbpaciente.setText("");
        tbnroconsul.setText("");
        tbcosto.setText("");
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu) 
        {
            Sistema sist = new Sistema();
            dispose();
        }

        if (e.getSource() == btnRegistrar) 
        {
            RegistrarCosto();
        }

        if (e.getSource() == btnVisualizar) 
        {
            MostrarCosto Mcosto = new MostrarCosto();
            dispose();
        }

        if (e.getSource() == btnCancelar) {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
}
