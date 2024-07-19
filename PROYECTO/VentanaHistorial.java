import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class VentanaHistorial extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 300, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("HISTORIAL", 400, 10, 300, 100, Color.BLACK, 25);

    private Texto txtNroConsul = new Texto("NRO CONSULTORIO", 100, 120, 150, 25, Color.BLACK, 15);
    private Texto txtMedico= new Texto("MEDICO", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtAdministrativo = new Texto("ADMINISTRATIVO", 100, 200, 150, 25, Color.BLACK, 15);
    private Texto txtPaciente = new Texto("PACIENTE", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtDescripcion = new Texto("DESCRIPCION", 100, 280, 100, 25, Color.BLACK, 15);

    private Caja tbnroconsul = new Caja(250, 120, 200, 25);
    private Caja tbmedico = new Caja(250, 160, 200, 30);
    private Caja tbadministrativo = new Caja(250, 200, 200, 25);
    private Caja tbpaciente = new Caja(250, 240, 200, 25);
    private Caja tbdescripcion = new Caja(250, 280, 200, 25); 

    private Boton menu = new Boton("", 625, 10, 80, 80);
    private Boton btnRegistrar = new Boton("REGISTRAR", 475, 120, 125, 30);
    private Boton btnCancelar = new Boton("CANCELAR", 475, 180, 125, 30);
    private Boton btnVisualizar = new Boton("VISUALIZAR", 475, 240, 125, 30);

    public VentanaHistorial()
    {
        ImageIcon Menu = new ImageIcon("G:/PROYECTO/iconos/Menu.png");

        menu.setIcon(Menu);

        add(titulo);
        add(ventana);

        add(txtMedico);
        add(txtAdministrativo);
        add(txtPaciente);
        add(txtNroConsul);
        add(txtDescripcion);

        add(tbmedico);
        add(tbadministrativo);
        add(tbpaciente);
        add(tbnroconsul);
        add(tbdescripcion);

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

    public void RegistrarHistorial(){
        int nc = Integer.parseInt(tbnroconsul.getText());
        String med = tbmedico.getText();
        String admin = tbadministrativo.getText();
        String pac = tbpaciente.getText();
        String des = tbdescripcion.getText();

        Historial hist = new Historial(nc, med, admin, pac, des);
        DBA.setHistorial(hist);

        tbnroconsul.setText("");
        tbmedico.setText("");
        tbadministrativo.setText("");
        tbpaciente.setText("");
        tbdescripcion.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu) {
            Sistema sist = new Sistema();
            dispose();
        }

        if (e.getSource() == btnRegistrar) {
            RegistrarHistorial();
        }

        if (e.getSource() == btnVisualizar) {
            MostrarHistorial Mhis = new MostrarHistorial();
            dispose();
        }

        if (e.getSource() == btnCancelar) {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
}