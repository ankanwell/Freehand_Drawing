//free hand drawing
package ApplicationPack;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MainPanel extends JPanel implements MouseListener,MouseMotionListener,ActionListener
{
    private int pX,pY,cX,cY;
    private JButton btnClear;
    private MainPanel self;
    private JButton makeButton(String cap)
    {
        JButton temp = new JButton(cap);
        temp.setFont(new Font("Courier New", Font.BOLD, 16));
        temp.addActionListener(this);
        super.add(temp);
        return temp;
    }
    public MainPanel()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
        btnClear = makeButton("Clear");
        self = this;
    }
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawLine(pX,pY,cX,cY);
        pX = cX;
        pY = cY;
    }

    @Override
    public void mouseClicked(MouseEvent e){}
    @Override
    public void mousePressed(MouseEvent e) 
    {
        pX = e.getX();
        pY = e.getY();
    }
    @Override
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseDragged(MouseEvent e)
    {
        cX = e.getX();
        cY = e.getY();
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e){}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        self.setOpaque(false);
        pX = pY = cX = cY = 0;
        repaint();
    }
}
class MainFrame extends JFrame
{
    private MainPanel panel;
    public MainFrame()
    {
        panel = new MainPanel();
        panel.setForeground(Color.red);
        super.add(panel);
    }
}
public class MainClass
{
    public static void main(String[] args)
    {
        JFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Experimenting Freehand Line Drawing");
        frame.setResizable(false);
    }
}