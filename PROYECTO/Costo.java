
/**
 * Write a description of class Costo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Costo
{
    private String medico, administrativo, paciente;
    private int NroConsul;
    private double costo;
    
    public Costo()
    {
        this.medico = "";
        this.administrativo = "";
        this.paciente = "";
        this.costo = 0.0;
        this.NroConsul = 0;
    }

    public Costo(String medico, String administrativo, String paciente, int NroConsul, double costo)
    {
        this.medico = medico;
        this.administrativo = administrativo;
        this.paciente = paciente;
        this.costo = costo;
        this.NroConsul = NroConsul;
    }

    public void setMedico(String medico)
    {
        this.medico = medico;
    }

    public void setAdministrativo(String administrativo)
    {
        this.administrativo = administrativo;
    }

    public void setPaciente(String paciente)
    {
        this.paciente = paciente;
    }

    public void setCosto(double costo)
    {
        this.costo = costo;
    }

    public void setNroConsul(int NroConsul)
    {
        this.NroConsul = NroConsul;
    }

    public String getMedico()
    {
        return this.medico;
    }
    
    public String getAdministrativo()
    {
        return this.administrativo;
    }

    public String getPaciente()
    {
        return this.paciente;
    }

    public double getCosto()
    {
        return this.costo;
    }

    public int getNroConsul()
    {
        return this.NroConsul;
    }
}