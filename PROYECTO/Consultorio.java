public class Consultorio
{
    private String medico, dia, hora;
    private int nroConsul;

    public Consultorio()
    {
        this.medico = "";
        this.dia = "";
        this.hora = "";
        this.nroConsul = 0;
    }

    public Consultorio(String medico, String dia, String hora, int nroConsul)
    {
        this.medico = medico;
        this.dia = dia;
        this.hora = hora;
        this.nroConsul = nroConsul;
    }

    public void setMedico(String medico)
    {
        this.medico = medico;
    }

    public void setDia(String dia)
    {
        this.dia = dia;
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
    
    public String getDia()
    {
    return this.dia;
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