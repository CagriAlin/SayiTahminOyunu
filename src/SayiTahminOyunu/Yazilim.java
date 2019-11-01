package SayiTahminOyunu;

import javax.swing.*; // grafiksel arayüzler hazırlamak için
import java.awt.*;   // arayüzle kullanıcı etkileşimi için gerekli
import java.awt.event.ActionEvent; //düğmeye basma, listeden birisini çift tıklama, menüden seçim
import java.awt.event.ActionListener; // actionEvent 'i algılar (dinler) ve gereğini yapacak metodu çalıştırır
import java.util.ArrayList; // gerekli dizileri oluşturmak için
import java.util.Collections; // gereklilistelerioluşturmak için
import java.util.List; // collections a bağlı listeler i

// yazilim sınıfı

public class Yazilim extends JFrame implements ActionListener {

    private static final int ALAN_YUKSELIK = 600; // arayüz genişlik
    private static final int ALAN_GENISLIK = 1300; // arayüz yükseklik
    private static final int ALAN_X = 0; // x için başlangıç
    private static final int ALAN_Y = 0; // y için başlangıç
    private static final int BUTON_YUKEKLİK = 80; // button genişlik
    private static final int BUTON_GENISLIK = 30; // button yükseklik
    private static final String BOS_ALAN = ""; // veri girilecek alan için

    private final JLabel talimatlar = new JLabel ("Tahmin Ettiğin Sayı: "); //arayüzdeki sabit başlıklar

    private final JLabel talimatlar2 = new JLabel ("artı: ");

    private final JLabel talimatlar3 = new JLabel ("eksi: ");

    private final JLabel talimatlar4 = new JLabel ("Tahmin Ettiğim Sayı: ");

    private final JLabel talimatlar5 = new JLabel("Bu bir sayı tahmin oyunu. Önce sol tarafta ben bir sayı " +
            "tutacağım sen tahmin ederek o sayıyı bulacan. Sonra sağ tarafta" +
            "sen bir sayı tutacaksın ben tahmin ederek sayıyı bulacam. Bakalım" +
            "c" +
            "Bol şanlar. Kurallara uymayı unutma! ");

    private List<Integer> basamaklar;  // sayılarının basamak sayısı için

    private List<Integer> basamaklar2;

    private JButton tahminButonu; // Tahmin Et butonu

    private JButton tekrarOyna;   // Tekrar et butonu

    private JButton ipucuVer;    // İpucu ver butonu

    private JTextField girdiAlani; // veri girdi alanları

    private JTextField girdialani2;

    private JTextField girdialani3;

    private JTextArea yaziAlani; // yazı alanları

    private JTextArea yaziAlani2;

    private JTextArea yaziAlani3;

    private int sayi;

    private int sayi2;

    private int tahminEdilenSayilar; // tahmin edilen sayıların dizisi


    public void actionPerformed(ActionEvent event){ // tuşların aksiyonları için


        if(event.getSource().equals(ipucuVer)){

            karsilastirma2();

        }

        // oyunu yeniden başlatmak için

        if(event.getSource().equals(tekrarOyna)){

            // tahmin edilen sayıları sıfırlamak için
            tahminEdilenSayilar = 0;

            // yazı alanını sıfırlamak için
            yaziAlani.setText(BOS_ALAN);

            // yazı alanına kuralları eklemek için
            yaziAlani.append("Bu bir sayı tahmin oyunu. Önce sol tarafta ben bir sayı tutacağım sen \n" +
                    "tahmin ederek o sayıyı bulacaksın. Sonra sağ tarafta sen sayı tutacaksın \n" +
                    "ben tahmin ederek sayıyı bulacağım. Bakalım hangimiz en az tahminde \n" +
                    "bulunarak tuttuğumuz sayıları tahmin edecek. \n \n" +
                    "Bol şanlar. Kurallara uymayı unutma! :) :) \n" +
                    "\n" +"Kurallar: \n" + "Tekrarlama ve sıfırlama olmadan dört basamaklı sayılar tahmin et. "
                    + "\n\"artı\" " + "doğru yerde doğru rakamın olduğu anlamına gelir "
                    + "\"eksi\" yanlış \n yerde doğru rakam olduğuna gelir." + "\n" + "\n");

            // rastgele sayı üretmek için

            basamaklar = new ArrayList<Integer>();

            for(int i = 0; i <= 9; i++){

                basamaklar.add(i);

            }

            Collections.shuffle(basamaklar); // sayıyı basamaklarına ayırmak için

            sayi = basamaklar.get(0) * 1000 + basamaklar.get(1) * 100 + basamaklar.get(2) * 10 + basamaklar.get(3); //sayının sıfırla başlamaması için

            if (basamaklar.get(0)==0)
            {

                sayi = basamaklar.get(0) * 1000 + basamaklar.get(1) * 100 + basamaklar.get(2) * 10 + basamaklar.get(3);

            }

            // sayının basamaklarının tekrar etmemesi için

            if(basamaklar.get(0)== basamaklar.get(1) || basamaklar.get(0)== basamaklar.get(2) || basamaklar.get(0)== basamaklar.get(3) || basamaklar.get(1)== basamaklar.get(2) || basamaklar.get(1)== basamaklar.get(3) || basamaklar.get(2)== basamaklar.get(3))
            {

                sayi = basamaklar.get(0) * 1000 + basamaklar.get(1) * 100 + basamaklar.get(2) * 10 + basamaklar.get(3);

            }

            sayi2 = basamaklar2.get(0) * 1000 + basamaklar2.get(1) * 100 + basamaklar2.get(2) * 10 + basamaklar2.get(3);

            yaziAlani2.setText(BOS_ALAN); // yazı alanı sıfırlamak için

            yaziAlani2.append("Kurallar: \n" + "Sürekli olarak tahmin ettiğim sayılara artı ver eksi ipucları ver. " // yazı alanına yazı eklemek için
                    + "\n\"artı\" " + "doğru yerde doğru rakamın olduğu anlamına gelir "
                    + "\"eksi\" yanlış \n yerde doğru rakam olduğuna gelir." + "\n" + "Ama dikkatli ol eğer oyunun mantığına aykırı ipuçları girersen seni \nuyaracağım." + "\n" + "\n");

            yaziAlani2.append("   İlk tahminim:" + sayi2);

            basamaklar2 = new ArrayList<Integer>();

            for(int i = 0; i <= 9; i++){

                basamaklar2.add(i);

            }

            Collections.shuffle(basamaklar2); // sayıyı basamaklarına ayırmak için

            if (basamaklar2.get(0)==0)
            {

                sayi2 = basamaklar2.get(0) * 1000 + basamaklar2.get(1) * 100 + basamaklar2.get(2) * 10 + basamaklar2.get(3);

            }

            if(basamaklar2.get(0) == basamaklar2.get(1) || basamaklar2.get(0)== basamaklar2.get(2) || basamaklar2.get(0)== basamaklar2.get(3) || basamaklar2.get(1)== basamaklar2.get(2) || basamaklar2.get(1)== basamaklar2.get(3) || basamaklar2.get(2)== basamaklar2.get(3))
            {

                sayi2 = basamaklar2.get(0) * 1000 + basamaklar2.get(1) * 100 + basamaklar2.get(2) * 10 + basamaklar2.get(3);

            }





        }
        if (event.getSource().equals(tahminButonu)) {

            String temp = girdiAlani.getText();
            girdiAlani.setText(BOS_ALAN);


            // eğer numarayı tahmin etmek imkansız olursa tutulan sayıyı göstermek için

            if(temp.equals("bulamadım sayı kaç")){

                JOptionPane.showMessageDialog(null, sayi);

            }

            // girdi alanının durumunu kontrol eder
            if(!temp.equals("")){

                tahminEdilenSayilar++;
                karsilastirma(temp);

            }

        }


    }

    public int arayuzFormu(){  // arayüz oluşturmak için

        Container contentPane;

        // çerçeve özelliklerini ayarlamak için
        setSize(ALAN_GENISLIK, ALAN_YUKSELIK);
        setResizable(false);
        setTitle("4 Basamaklı SayıTahmin Oyunu");
        setLocation(ALAN_X, ALAN_Y);

        contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.lightGray);

        // rastgele 4 basamaklı sayı oluşturmak için
        basamaklar = new ArrayList<Integer>();

        for(int i = 0; i <= 9; i++){

            basamaklar.add(i);

        }

        Collections.shuffle(basamaklar); // sayıyı basamaklarına ayırmak için

        sayi = basamaklar.get(0) * 1000 + basamaklar.get(1) * 100 + basamaklar.get(2) * 10 + basamaklar.get(3);

        if (basamaklar.get(0)==0)
        {

            return sayi;

        }

        if(basamaklar.get(0)== basamaklar.get(1) || basamaklar.get(0)== basamaklar.get(2) || basamaklar.get(0)== basamaklar.get(3) || basamaklar.get(1)== basamaklar.get(2) || basamaklar.get(1)== basamaklar.get(3) || basamaklar.get(2)== basamaklar.get(3))
        {

            return sayi;

        }

        tahminEdilenSayilar = 0;

        basamaklar2 = new ArrayList<Integer>();

        for(int i = 0; i <= 9; i++){

            basamaklar2.add(i);

        }

        Collections.shuffle(basamaklar2); // sayıyı basamaklarına ayırmak için

        sayi2 = basamaklar2.get(0) * 1000 + basamaklar2.get(1) * 100 + basamaklar2.get(2) * 10 + basamaklar2.get(3);

        if (basamaklar2.get(0)==0)
        {

            return sayi2;

        }

        if(basamaklar2.get(0)== basamaklar2.get(1) || basamaklar2.get(0)== basamaklar2.get(2) || basamaklar2.get(0)== basamaklar2.get(3) || basamaklar2.get(1)== basamaklar2.get(2) || basamaklar2.get(1)== basamaklar2.get(3) || basamaklar2.get(2)== basamaklar2.get(3))
        {

            return sayi2;

        }



        // tahmin düğmesi için alan oluşturma
        tahminButonu = new JButton("Tahmin Et");
        tahminButonu.setBounds(330, 60, BUTON_YUKEKLİK, BUTON_GENISLIK);
        tahminButonu.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(tahminButonu);

        // restart düğmesi için alan oluşturma
        tekrarOyna = new JButton("Tekrar Oyna");
        tekrarOyna.setBounds(420, 60, BUTON_YUKEKLİK, BUTON_GENISLIK);
        tekrarOyna.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(tekrarOyna);

        //İpucu ver düğmesi için
        ipucuVer = new JButton("İpucu Ver");
        ipucuVer.setBounds(1120, 500, BUTON_YUKEKLİK, BUTON_GENISLIK);
        ipucuVer.setBorder(BorderFactory.createRaisedBevelBorder());
        contentPane.add(ipucuVer);

        // her üç düğmeyide aktif etmek için
        tahminButonu.addActionListener(this);
        tekrarOyna.addActionListener(this);
        ipucuVer.addActionListener(this);

        // girdi alanı oluşturmak için
        girdiAlani = new JTextField();
        girdiAlani.setBounds(100, 60, 220,25);
        contentPane.add(girdiAlani);

        // girdi alanını aktif etmek için
        girdiAlani.addActionListener(this);


        // girdi alanı oluşturmak için
        girdialani2 = new JTextField();
        girdialani2.setBounds(850, 500, 50, 25);
        contentPane.add(girdialani2);

        // girdi alanını aktif etmek için
        girdialani2.addActionListener(this);

        // girdi alanı oluşturmak için
        girdialani3 = new JTextField();
        girdialani3.setBounds(1000, 500, 50, 25);
        contentPane.add(girdialani3);

        // girdi alanını aktif etmek için
        girdialani3.addActionListener(this);


        // kırmızı kenarlıklı bir metin alanı ve kaydırma çubuğu eklemek için
        yaziAlani = new JTextArea();
        yaziAlani.setEditable(false);
        JScrollPane scrollText = new JScrollPane(yaziAlani);
        scrollText.setBounds(100, 100, 400, 425);
        scrollText.setBorder(BorderFactory.createLineBorder(Color.red));
        yaziAlani.append("Bu bir sayı tahmin oyunu. Önce sol tarafta ben bir sayı tutacağım sen \n" +
                "tahmin ederek o sayıyı bulacaksın. Sonra sağ tarafta sen sayı tutacaksın \n" +
                "ben tahmin ederek sayıyı bulacağım. Bakalım hangimiz en az tahminde \n" +
                "bulunarak tuttuğumuz sayıları tahmin edecek. \n \n" +
                "Bol şanlar. Kurallara uymayı unutma! :) :) \n" +
                "\n" +"Kurallar: \n" + "Tekrarlama ve sıfırlama olmadan dört basamaklı sayılar tahmin et. "
                + "\n\"artı\" " + "doğru yerde doğru rakamın olduğu anlamına gelir "
                + "\"eksi\" yanlış \n yerde doğru rakam olduğuna gelir." + "\n" + "\n");

        contentPane.add(scrollText);

        yaziAlani2 = new JTextArea();
        yaziAlani2.setEditable(false);
        JScrollPane scrollTexts = new JScrollPane(yaziAlani2);
        scrollTexts.setBounds(800, 60, 400, 400);
        scrollTexts.setBorder(BorderFactory.createLineBorder(Color.red));
        yaziAlani2.append("Kurallar: \n" + "Sürekli olarak tahmin ettiğim sayılara artı ver eksi ipucları ver. " // yazı alanına yazı eklemek için
                + "\n\"artı\" " + "doğru yerde doğru rakamın olduğu anlamına gelir "
                + "\"eksi\" yanlış \n yerde doğru rakam olduğuna gelir." + "\n" + "Ama dikkatli ol eğer oyunun mantığına aykırı ipuçları girersen seni \nuyaracağım." + "\n" + "\n");

        yaziAlani2.append("   İlk tahminim:" + sayi2);

        contentPane.add(scrollTexts);


        // yazı alanına talimatları eklemek için
        talimatlar.setBounds(100, 33, 300, 20);
        contentPane.add(talimatlar);

        talimatlar2.setBounds(800, 500, 50, 20);
        contentPane.add(talimatlar2);

        talimatlar3.setBounds(950, 500, 50, 20);
        contentPane.add(talimatlar3);

        talimatlar4.setBounds(800, 33, 300, 20);
        contentPane.add(talimatlar4);




        return 0;
    }

    private void karsilastirma (String sayiString){ // Kullanıcının yazılımın tuttuğu sayıyı tahmin ettiği oyun

        int artilar = 0;
        int eksiler = 0;

        int tahmin = Integer.parseInt(sayiString);


        //tahminin geçerli olduğundan emin olmak için

        if((tahmin/1000) < 1 || (tahmin/1000) > 10 )
        {

            // Uyarı mesajı penceresi için
            JOptionPane.showMessageDialog(null, "\n" + "Lütfen tekrarlayan ve başında sıfır olmayan dört haneli bir sayı gir.");
            tahminEdilenSayilar--;

        }

        // oyunu kazanmak için
        else if(tahmin == sayi){

            yaziAlani.append("\n"+"\n"+"Kazanadın :) Tahminin " + sayi + "." + " Tahmin Sayısı:" + " " +tahminEdilenSayilar );

        }
        else{

            for(int i = 0; i < 4; i++){

                if((sayi / (int) Math.pow(10, i)) % 10 == (tahmin / (int) Math.pow(10, i) % 10)){

                    artilar++;

                }
                else{

                    for(int j = 0; j < 4; j++){

                        if((sayi / (int) Math.pow(10, i)) % 10 == (tahmin / (int) Math.pow(10, j) % 10)){

                            eksiler++;

                        }

                    }

                }

            }

            // yazı alanına karşılaştırılan her tahminin listesini eklemek için

            yaziAlani.append("      " + tahminEdilenSayilar + "      Tahminin: " + tahmin +
                    "      |      artı: " + artilar + "   eksi: " + eksiler + "\n");

        }

        girdiAlani.setText(BOS_ALAN);

    }

    private int karsilastirma2() { // yazılımın kullanıcının tahmin ettiği sayıyı bulabilmesi için

        int arti;
        int eksi;

        arti = Integer.parseInt(girdialani2.getText());
        eksi = Integer.parseInt(girdialani3.getText());



        if(arti < 0 || arti > 4 || eksi < 0 || eksi >4 ){ // ipuclarının değer kontrolü için

            JOptionPane.showMessageDialog(null, "\n" + "Lütfen 0 ile 4 arasında bir sayı gir ( 0 ve 4 dahil ).");

        }

        else if ( arti == 4 && eksi == 0 ){ // kazanma durumu için

            yaziAlani2.append("\n"+"\n"+"Kazanadım :) Tahminim " + sayi2 + ".");
            yaziAlani2.append("\n" + "İstersen Tekrar Oyna a basarak tekrar oynayabilirsin.");

        }

        // oyun mantığına aykırı ipuçlarının durumları için

        else if ( (arti == 1 && eksi == 4) || (arti == 2 && eksi == 3) || (arti == 2 && eksi == 4) || (arti == 3 && eksi == 2) ||(arti == 3 && eksi == 3) ||(arti == 3 && eksi == 4) || (arti == 4 && eksi == 1) || (arti == 4 && eksi == 2) ||(arti == 4 && eksi == 3) ||(arti == 4 && eksi == 4)){

            JOptionPane.showMessageDialog(null, "\n" + "Lütfen Oyunun kuralları gereği mantıksal ipuçları ver."
                    + "\n" + "1-4, 2-3, 2-4, 3-2, 3-3, 3-4, 4-1, 4-2, 4-3, 4-4, ipuçları"
                    + "\n" + "mantıksal olarak uygun değil uygun değil");

            tahminEdilenSayilar--;

        }

        else{



            basamaklar2 = new ArrayList<Integer>();

            for(int i = 0; i <= 9; i++){

                basamaklar2.add(i);

            }

            Collections.shuffle(basamaklar2); // sayıyı basamaklarına ayırmak için

            sayi2 = basamaklar2.get(0) * 1000 + basamaklar2.get(1) * 100 + basamaklar2.get(2) * 10 + basamaklar2.get(3);

            if (basamaklar2.get(0)==0)
            {

                return sayi2;

            }

            if(basamaklar2.get(0)== basamaklar2.get(1) || basamaklar2.get(0)== basamaklar2.get(2) || basamaklar2.get(0)== basamaklar2.get(3) || basamaklar2.get(1)== basamaklar2.get(2) || basamaklar2.get(1)== basamaklar2.get(3) || basamaklar2.get(2)== basamaklar2.get(3))
            {

                return sayi2;

            }



            tahminEdilenSayilar++;


            yaziAlani2.append("\n" + "           " +tahminEdilenSayilar +"       Tahminim: " + sayi2);

        }


        girdialani2.setText(BOS_ALAN);
        girdialani3.setText(BOS_ALAN);

        return 0;
    }



}