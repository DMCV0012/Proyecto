public class Historial
{
    private String medico, administrativo, paciente, descripcion;
    private int NroConsul;

    public Historial()
    {
        this.medico = "";
        this.administrativo = "";
        this.paciente = "";
        this.descripcion = "";
        this.NroConsul = 0;
    }

    public Historial(int NroConsul, String medico, String administrativo, String paciente, String descripcion)
    {
        this.medico = medico;
        this.administrativo = administrativo;
        this.paciente = paciente;
        this.descripcion = descripcion;
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

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
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

    public String getDescripcion()
    {
        return this.descripcion;
    }

    public int getNroConsul()
    {
        return this.NroConsul;
    }
}