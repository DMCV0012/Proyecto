import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Sistema extends JFrame implements ActionListener
{
    private Texto titulo = new Texto("CLINICA HELTH", 300, 10, 300, 100, Color.BLUE, 40);

    private Boton btAdmin = new Boton("ADMINISTRATIVO",10,100,140, 40);
    private Boton btPersonal = new Boton("PERSONAL",150,100,100,40);
    private Boton btPaciente = new Boton("PACIENTE",250,100,100,40);
    private Boton btConsulta = new Boton("CONSULTA",350,100,100,40);
    private Boton btConsultorio = new Boton("CONSULTORIO",450,100,140,40);
    private Boton btCosto = new Boton("COSTO",590,100,100,40);
    private Boton btHistorial = new Boton("HISTORIAL",690,100,100,40);
    private Boton btSalir = new Boton("SALIR",790,100,100,40);
    public Sistema()
    {
        add(titulo);

        add(btAdmin);
        add(btPersonal);
        add(btPaciente);
        add(btConsulta);
        add(btConsultorio);
        add(btCosto);
        add(btHistorial);
        add(btSalir);

        btAdmin.addActionListener(this);
        btPersonal.addActionListener(this);
        btPaciente.addActionListener(this);
        btConsulta.addActionListener(this);
        btConsultorio.addActionListener(this);
        btCosto.addActionListener(this);
        btHistorial.addActionListener(this);
        btSalir.addActionListener(this);
        
        setLayout(null);
        setTitle("LOGIN");
        setSize(920,450);
        setVisible(true);
    }

    VentanaAdmin frmAdmin;
    VentanaPersonal frmPer;
    VentanaPaciente frmPac;
    VentanaConsulta frmCon;
    VentanaConsultorio frmCons;
    VentanaCosto frmCos;
    VentanaHistorial frmHis;

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == btAdmin) 
        {
            frmAdmin = new VentanaAdmin();
            dispose();
        }

        if (e.getSource() == btPaciente) 
        {
            frmPac = new VentanaPaciente();
            dispose();
        }

        if (e.getSource() == btPersonal) 
        {
            frmPer = new VentanaPersonal();
            dispose();
        }

        if (e.getSource() == btConsulta) 
        {
            frmCon = new VentanaConsulta();
            dispose();
        }

        if (e.getSource() == btConsultorio) 
        {
            frmCons = new VentanaConsultorio();
            dispose();
        }

        if (e.getSource() == btHistorial) 
        {
            frmHis = new VentanaHistorial();
            dispose();
        }

        if (e.getSource() == btCosto) 
        {
            frmCos = new VentanaCosto();
            dispose();
        }

        if (e.getSource() == btSalir) 
        {
            Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
            window.dispose();
        }
    }
}