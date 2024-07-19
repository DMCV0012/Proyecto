public class Consulta
{
    private String medico, paciente, fecha, hora;
    private int nroConsul;

    public Consulta()
    {
        this.medico = "";
        this.paciente = "";
        this.fecha = "";
        this.hora = "";
        this.nroConsul = 0;
    }

    public Consulta(String medico, String paciente, String hora, String fecha, int nroConsul)
    {
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.nroConsul = nroConsul;
    }

    public void setMedico(String medico)
    {
        this.medico = medico;
    }

    public void setPaciente(String paciente)
    {
        this.paciente = paciente;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }

    public void setNroConsul(int nroConsul)
    {
        this.nroConsul = nroConsul;
    }

    public String getMedico()
    {
        return this.medico;
    }

    public String getPaciente()
    {
        return this.paciente;
    }

    public String getFecha()
    {
        return this.fecha;
    }

    public String getHora()
    {
        return this.hora;
    }

    public int getNroConsul()
    {
        return this.nroConsul;
    }
}