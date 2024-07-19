import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class VentanaConsultorio extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 100, 10, 300, 100, Color.BLUE, 25);
    private Texto ventana = new Texto("CONSULTORIO", 400, 10, 300, 100, Color.BLACK, 25);

    private Texto txtMedico = new Texto("MEDICO", 100, 120, 100, 25, Color.BLACK, 15);
    private Texto txtDia = new Texto("DIA", 100, 160, 100, 25, Color.BLACK, 15);
    private Texto txtHora = new Texto("HORA", 100, 200, 100, 25, Color.BLACK, 15);
    private Texto txtNroConsul = new Texto("NRO CONSULTORIO", 100, 240, 150, 25, Color.BLACK, 15);

    private Caja tbmedico = new Caja(300, 120, 140, 30);
    private Caja tbdia = new Caja(300, 160, 140, 30);
    private Caja tbhora = new Caja(300, 200, 140, 30);
    private Caja tbnroconsul = new Caja(300, 240, 140, 30);

    private Boton menu = new Boton("", 625, 10, 80, 80);
    private Boton btnRegistrar = new Boton("REGISTRAR", 450, 120, 125, 30);
    private Boton btnCancelar = new Boton("CANCELAR", 450, 180, 125, 30);
    private Boton btnVisualizar = new Boton("VISUALIZAR", 450, 240, 125, 30);

    public VentanaConsultorio()
    {
        ImageIcon Menu = new ImageIcon("G:/PROYECTO/iconos/Menu.png");

        menu.setIcon(Menu);

        add(titulo);
        add(ventana);

        add(txtMedico);
        add(txtDia);
        add(txtHora);
        add(txtNroConsul);

        add(tbmedico);
        add(tbdia);
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

    public void RegistrarConsultorio(){
        String med = tbmedico.getText();
        String d = tbdia.getText();
        String hr = tbhora.getText();
        int nc = Integer.parseInt(tbnroconsul.getText());

        Consultorio cons = new Consultorio(med, d, hr, nc);
        DBA.setConsultorio(cons);

        tbmedico.setText("");
        tbdia.setText("");
        tbhora.setText("");
        tbnroconsul.setText("");

        setVisible(false);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == menu) 
        {
            Sistema sist = new Sistema();
            dispose();
        }

        if (e.getSource() == btnRegistrar) 
        {
            RegistrarConsultorio();
        }

        if (e.getSource() == btnVisualizar) 
        {
            MostrarConsultorio Mconsul = new MostrarConsultorio();
            dispose();
        }

        if (e.getSource() == btnCancelar) 
        {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
}
