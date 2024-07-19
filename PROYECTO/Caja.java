import javax.swing.*;
public class Caja extends JTextField
{
    public Caja(int px, int py, int tx, int ty)
    {
        setLocation(px, py);
        setSize(tx, ty);
    }
}