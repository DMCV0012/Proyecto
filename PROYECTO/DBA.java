public class DBA
{
    /*      COSTO       */
    public static void setCosto(Costo cos)
    {
        DB.RegistrarCosto(cos);
    }

    public static Costo getCosto(int pos)
    {
        if(pos <= DB.cos){
            return DB.costoPos(pos - 1);
        } else{
            return null;
        }
    }

    public static boolean EliminarCosto(int pos)
    {
        return DB.eliminarCosto(pos - 1);
    }

    public static boolean ModificarCosto(int pos, Costo nuevoCosto) {
        if (pos <= DB.cos) {
            return DB.modificarCosto(pos - 1, nuevoCosto);
        } else {
            return false;
        }
    }

    /*      PACIENTE        */
    public static void setPaciente(Paciente pac)
    {
        DB.RegistrarPaciente(pac);
    }

    public static Paciente getPaciente(int pos)
    {
        if(pos <= DB.pa){
            return DB.pacientePos(pos - 1);
        } else{
            return null;
        }
    }

    public static boolean EliminarPaciente(int pos)
    {
        return DB.eliminarPaciente(pos - 1);
    }

    public static boolean ModificarPaciente(int pos, Paciente nuevoPaciente) {
        if (pos <= DB.pa) {
            return DB.modificarPaciente(pos - 1, nuevoPaciente);
        } else {
            return false;
        }
    }

    /*      ADMINISTRATIVO      */
    public static void setAdministrativo(Administrativo admin)
    {
        DB.RegistrarAdministrativo(admin);
    }

    public static Administrativo getAdministrativo(int pos)
    {
        if(pos <= DB.ad){
            return DB.administrativoPos(pos - 1);
        } else{
            return null;
        }
    }

    public static boolean EliminarAdministrativo(int pos)
    {
        return DB.eliminarAdministrativo(pos - 1);
    }

    public static boolean ModificarAdministrativo(int pos, Administrativo nuevoAdministrativo) {
        if (pos <= DB.ad) {
            return DB.modificarAdministrativo(pos - 1, nuevoAdministrativo);
        } else {
            return false;
        }
    }

    /*      CONSULTORIO     */
    public static void setConsultorio(Consultorio co)
    {
        DB.RegistrarConsultorio(co);
    }

    public static Consultorio getConsultorio(int pos) {
        if (pos <= DB.con) {
            return DB.consultorioPos(pos - 1);
        } else {
            return null;
        }
    }

    public static boolean EliminarConsultorio(int pos)
    {
        return DB.eliminarConsultorio(pos - 1);
    }

    public static boolean ModificarConsultorio(int pos, Consultorio nuevoConsultorio) {
        if (pos <= DB.con) {
            return DB.modificarConsultorio(pos - 1, nuevoConsultorio);
        } else {
            return false;
        }
    }

    /*      CONSULTA        */
    public static void setConsulta(Consulta c)
    {
        DB.RegistrarConsulta(c);
    }

    public static Consulta getConsulta(int pos) {
        if (pos <= DB.cons) {
            return DB.consultaPos(pos - 1);
        } else {
            return null;
        }
    }

    public static boolean EliminarConsulta(int pos)
    {
        return DB.eliminarConsulta(pos - 1);
    }

    public static boolean ModificarConsulta(int pos, Consulta nuevaConsulta) {
        if (pos <= DB.cons) {
            return DB.modificarConsulta(pos - 1, nuevaConsulta);
        } else {
            return false;
        }
    }

    /*      HISTORIAL       */
    public static void setHistorial(Historial h)
    {
        DB.RegistrarHistorial(h);
    }

    public static Historial getHistorial(int pos) {
        if (pos <= DB.his) {
            return DB.historialPos(pos - 1);
        } else {
            return null;
        }
    }

    public static boolean EliminarHistorial(int pos)
    {
        return DB.eliminarHistorial(pos - 1);
    }

    public static boolean ModificarHistorial(int pos, Historial nuevoHistorial) {
        if (pos <= DB.his) {
            return DB.modificarHistorial(pos - 1, nuevoHistorial);
        } else {
            return false;
        }
    }

    /*      PERSONAL        */
    public static void setPersonal(Personal p)
    {
        DB.RegistrarPersonal(p);
    }

    public static Personal getPersonal(int pos) {
        if (pos <= DB.pe) {
            return DB.personalPos(pos - 1);
        } else {
            return null;
        }
    }

    public static boolean EliminarPersonal(int pos)
    {
        return DB.eliminarPersonal(pos - 1);
    }

    public static boolean ModificarPersonal(int pos, Personal nuevoPersonal) {
        if (pos <= DB.pe) {
            return DB.modificarPersonal(pos - 1, nuevoPersonal);
        } else {
            return false;
        }
    }

    /*      USUARIO         */
    public static void setUsuario(Usuario us){
        DB.RegistrarUsuario(us);
    }

    public static Usuario getUsuario(int pos) {
        if (pos <= DB.us) {
            return DB.usuarioPos(pos - 1);
        } else {
            return null;
        }
    }

    public static boolean EliminarUsuario(int pos)
    {
        return DB.eliminarUsuario(pos - 1);
    }

    public static boolean ModificarUsuario(int pos, Usuario nuevoUsuario) {
        if (pos <= DB.us) {
            return DB.modificarUsuario(pos - 1, nuevoUsuario);
        } else {
            return false;
        }
    }

    public static boolean existeUsuario(Usuario usu){
        boolean res= false;
        for(int i=0; i<DB.us; i++){
            if(usu.getUsuario().equals(DB.usuario[i].getUsuario())&&usu.getContrasenha().equals(DB.usuario[i].getContrasenha()))
                res= true;
        }
        return res;
    }
}
