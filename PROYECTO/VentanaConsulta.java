import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class VentanaConsulta extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 300, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("CONSULTA", 400, 10, 300, 100, Color.BLACK, 25);

    private Texto txtMedico= new Texto("MEDICO", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtPaciente = new Texto("PACIENTE", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtFecha = new Texto("FECHA", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtHora = new Texto("HORA", 100, 240, 100, 25, Color.BLACK, 15);
    private Texto txtNroConsul = new Texto("NRO CONSULTORIO", 100, 280, 150, 25, Color.BLACK, 15);

    private Caja tbmedico = new Caja(250, 120, 200, 30);
    private Caja tbpaciente = new Caja(250, 160, 200, 25);
    private Caja tbfecha = new Caja(250, 200, 200, 25);
    private Caja tbhora = new Caja(250, 240, 200, 25);
    private Caja tbnroconsul = new Caja(250, 280, 200, 25);

    private Boton menu = new Boton("", 625, 10, 80, 80);
    private Boton btnRegistrar = new Boton("REGISTRAR", 475, 120, 125, 30);
    private Boton btnCancelar = new Boton("CANCELAR", 475, 180, 125, 30);
    private Boton btnVisualizar= new Boton("VISUALIZAR", 475, 240, 125, 30);

    public VentanaConsulta()
    {
        ImageIcon Menu = new ImageIcon("G:/PROYECTO/iconos/Menu.png");

        menu.setIcon(Menu);

        add(titulo);
        add(ventana);

        add(txtMedico);

        add(txtPaciente);
        add(txtFecha);
        add(txtHora);
        add(txtNroConsul);

        add(tbmedico);
        add(tbpaciente);
        add(tbfecha);
        add(tbhora);
        add(tbnroconsul);

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

    public void RegistrarConsulta(){
        String med = tbmedico.getText();
        String pac = tbpaciente.getText();
        String fch = tbfecha.getText();
        String hr = tbhora.getText();
        int nc = Integer.parseInt(tbnroconsul.getText());

        Consulta con = new Consulta(med, pac, fch, hr, nc);
        DBA.setConsulta(con);

        tbmedico.setText("");
        tbpaciente.setText("");
        tbfecha.setText("");
        tbhora.setText("");
        tbnroconsul.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu) {
            Sistema sist = new Sistema();
            dispose();
        }

        if (e.getSource() == btnRegistrar) {
            RegistrarConsulta();
        }

        if (e.getSource() == btnVisualizar) {
            MostrarConsulta cs = new MostrarConsulta();
            dispose();
        }

        if (e.getSource() == btnCancelar) {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
}