public class DB
{
    public static Usuario[] usuario = new Usuario[100];
    public static int us = 0;

    public static Personal[] personal = new Personal[100];
    public static int pe = 0;

    public static Administrativo[] administrativo = new Administrativo[100];
    public static int ad = 0;

    public static Paciente[] paciente = new Paciente[100];
    public static int pa = 0;

    public static Consulta[] consulta = new Consulta[100];
    public static int cons = 0;

    public static Consultorio[] consultorio = new Consultorio[100];
    public static int con = 0;

    public static Historial[] historial = new Historial[100];
    public static int his = 0;

    public static Costo[] costo = new Costo[100];
    public static int cos = 0;

    /*      REGISTRAR       */
    public static void RegistrarUsuario(Usuario usu)
    {
        usuario[us] = usu;
        us++;
    }

    public static void RegistrarPersonal(Personal per)
    {
        personal[pe] = per;
        pe++;
    }

    public static void RegistrarAdministrativo(Administrativo admin)
    {
        administrativo[ad] = admin;
        ad++;
    }

    public static void RegistrarPaciente(Paciente pac)
    {
        paciente[pa] = pac;
        pa++;
    }

    public static void RegistrarConsulta(Consulta consul)
    {
        consulta[cons] = consul;
        cons++;
    }

    public static void RegistrarConsultorio(Consultorio consult)
    {
        consultorio[con] = consult;
        con++;
    }

    public static void RegistrarHistorial(Historial hist)
    {
        historial[his] = hist;
        his++;
    }

    public static void RegistrarCosto(Costo cost)
    {
        costo[cos] = cost;
        cos++;
    }

    /*      MODIFICAR       */
    public static boolean modificarUsuario(int pos, Usuario nuevoUsuario)
    {
        if (pos >= 0 && pos < us) {
            usuario[pos] = nuevoUsuario;
            return true;
        }
        return false;
    }

    public static boolean modificarPersonal(int pos, Personal nuevoPersonal)
    {
        if (pos >= 0 && pos < pe) {
            personal[pos] = nuevoPersonal;
            return true;
        }
        return false;
    }

    public static boolean modificarAdministrativo(int pos, Administrativo nuevoAdministrativo)
    {
        if (pos >= 0 && pos < ad) {
            administrativo[pos] = nuevoAdministrativo;
            return true;
        }
        return false;
    }

    public static boolean modificarPaciente(int pos, Paciente nuevoPaciente)
    {
        if (pos >= 0 && pos < pa) {
            paciente[pos] = nuevoPaciente;
            return true;
        }
        return false;
    }

    public static boolean modificarConsulta(int pos, Consulta nuevaConsulta)
    {
        if (pos >= 0 && pos < cons) {
            consulta[pos] = nuevaConsulta;
            return true;
        }
        return false;
    }

    public static boolean modificarConsultorio(int pos, Consultorio nuevoConsultorio)
    {
        if (pos >= 0 && pos < con) {
            consultorio[pos] = nuevoConsultorio;
            return true;
        }
        return false;
    }

    public static boolean modificarHistorial(int pos, Historial nuevoHistorial)
    {
        if (pos >= 0 && pos < his) {
            historial[pos] = nuevoHistorial;
            return true;
        }
        return false;
    }

    public static boolean modificarCosto(int pos, Costo nuevoCosto)
    {
        if (pos >= 0 && pos < cos) {
            costo[pos] = nuevoCosto;
            return true;
        }
        return false;
    }

    /*      ELEMINAR         */
    public static boolean eliminarUsuario(int pos) {
        if (pos >= 0 && pos < us) {
            if(usuario[pos] != null){
                for (int i = pos; i < us - 1; i++) {
                    usuario[i] = usuario[i + 1];
                }
                usuario[us - 1] = null;
                us--;
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarPersonal(int pos) {
        if (pos >= 0 && pos < pe) {
            if(personal[pos] != null){
                for (int i = pos; i < pe - 1; i++) {
                    personal[i] = personal[i + 1];
                }
                personal[pe - 1] = null;
                pe--;
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarAdministrativo(int pos) {
        if (pos >= 0 && pos < ad) {
            if(administrativo[pos] != null){
                for (int i = pos; i < ad - 1; i++) {
                    administrativo[i] = administrativo[i + 1];
                }
                administrativo[ad - 1] = null;
                ad--;
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarPaciente(int pos) {
        if (pos >= 0 && pos < pa) {
            if(paciente[pos] != null){
                for (int i = pos; i < pa - 1; i++) {
                    paciente[i] = paciente[i + 1];
                }
                paciente[pa - 1] = null;
                pa--;
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarConsulta(int pos) {
        if (pos >= 0 && pos < cons) {
            if(consulta[pos] != null){
                for (int i = pos; i < cons - 1; i++) {
                    consulta[i] = consulta[i + 1];
                }
                consulta[cons - 1] = null;
                cons--;
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarConsultorio(int pos) {
        if (pos >= 0 && pos < con) {
            if(consultorio[pos] != null){
                for (int i = pos; i < con - 1; i++) {
                    consultorio[i] = consultorio[i + 1];
                }
                consultorio[con - 1] = null;
                con--;
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarHistorial(int pos) {
        if (pos >= 0 && pos < his) {
            if(historial[pos] != null){
                for (int i = pos; i < his - 1; i++) {
                    historial[i] = historial[i + 1];
                }
                historial[his - 1] = null;
                his--;
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarCosto(int pos) {
        if (pos >= 0 && pos < cos) {
            if(costo[pos] != null){
                for (int i = pos; i < cos - 1; i++) {
                    costo[i] = costo[i + 1];
                }
                costo[cos - 1] = null;
                cos--;
                return true;
            }
        }
        return false;
    }

    /*      POSICION        */  
    public static Personal personalPos(int pos)
    {
        return personal[pos];
    }

    public static Administrativo administrativoPos(int pos)
    {
        return administrativo[pos];
    }

    public static Consultorio consultorioPos(int pos)
    {
        return consultorio[pos];
    }

    public static Consulta consultaPos(int pos)
    {
        return consulta[pos];
    }

    public static Historial historialPos(int pos)
    {
        return historial[pos];
    }

    public static Usuario usuarioPos(int pos)
    {
        return usuario[pos];
    }

    public static Costo costoPos(int pos)
    {
        return costo[pos];
    }

    public static Paciente pacientePos(int pos)
    {
        return paciente[pos];
    }
}