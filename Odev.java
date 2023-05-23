import javax.swing.*;
import java.awt.*;

public class Odev extends JFrame {
    private int lambaIndex; // Hangi lamba yanicak onu tutuyor

    public Odev() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        setSize(500, 600);
    }

    public void paint(Graphics g) {
        // Trafik lambası arkaplan
        g.setColor(Color.darkGray);
        g.fillRect(100, 0, 350, 600);

        int y = 50;

        // Burada lambalar oluşturuluyor ve siradaki yanacak lambaya göre(lambaIndex'ten anlıyoruz bunu) renk
        // dağılımı yapılıyor
        for (int i = 0; i < 3; i++) {
            if (i == lambaIndex) {
                if (i == 0) {
                    g.setColor(Color.red);
                } else if (i == 1) {
                    g.setColor(Color.yellow);
                } else if (i == 2) {
                    g.setColor(Color.green);
                }
                g.fillOval(200, y + (i * 200), 150, 150);
            } else {
                g.setColor(Color.black);
                g.fillOval(200, y + (i * 200), 150, 150); // x aynı tutup y'yi değiştiriyoruz ki lambalar üst üste gelmesin(Yanyana yapmak istersek x'i değiştirebiliriz).                                                
            }
        }

        lambaIndex++;
        if (lambaIndex == 3)
            lambaIndex = lambaIndex % 3; // Yanacak lambanın index'i 3 olursa geri 0 yapıyoruz

        try {
            Thread.sleep(5000); // Her lamba pozisyonundan sonra 5 saniye bekliyoruz ki kullanıcı görebilsin. Yoksa karmaşa olur
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint(); // Sürekli devam etmesi için
    }

    public static void main(String[] args) {
        Odev trafikIsiklari = new Odev();
        trafikIsiklari.setVisible(true);
    }
}
