
public class Paciente
{
    private String nombre, apellido, direccion, telefono;
    private int ci;

    public Paciente()
    {
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = "";
        this.ci = 0;
    }

    public Paciente(String nombre, String apellido, String direccion, String telefono, int ci)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ci = ci;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public void setCi(int ci)
    {
        this.ci = ci;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getApellido()
    {
        return this.apellido;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public String getTelefono()
    {
        return this.telefono;
    }

    public int getCi()
    {
        return this.ci;
    }
}
