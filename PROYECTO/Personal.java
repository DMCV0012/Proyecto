public class Personal
{
    private String nombre, apellido, especialidad, cargo;
    private int ci, id;

    public Personal()
    {
        this.nombre= "";
        this.apellido= "";
        this.especialidad= "";
        this.cargo= "";
        this.ci= 0;
        this.id= 0;
    }

    public Personal(String nombre,String apellido, String especialidad, String cargo, int ci, int id)
    {
        this.nombre= nombre;
        this.apellido= apellido;
        this.especialidad= especialidad;
        this.cargo= cargo;
        this.ci = ci;
        this.id= id;
    }

    public void setNombre(String nombre)
    {
        this.nombre= nombre;
    }

    public void setApellido(String apellido)
    {
        this.apellido= apellido;
    }

    public void setEspecialidad(String especialidad)
    {
        this.especialidad= especialidad;
    }

    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }

    public void setCi(int ci)
    {
        this.ci= ci;
    }

    public void setId(int id)
    {
        this.id= id;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getApellido()
    {
        return this.apellido;
    }

    public String getEspecialidad()
    {
        return this.especialidad;
    }

    public String getCargo()
    {
        return this.cargo;
    }

    public int getCi()
    {
        return this.ci;
    }

    public int getId()
    {
        return this.id;
    }
}