public class Usuario{
    private String usuario;
    private String contrasenha;
    public Usuario()
    {
        this.usuario = "";
        this.contrasenha = "";
    }

    public Usuario(String usuario, String contrasenha)
    {
        this.usuario = usuario;
        this.contrasenha = contrasenha;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public void setContrasenha(String contrasenha){
        this.contrasenha = contrasenha;
    }

    public String getUsuario(){
        return this.usuario;
    }

    public String getContrasenha(){
        return this.contrasenha;
    }
}