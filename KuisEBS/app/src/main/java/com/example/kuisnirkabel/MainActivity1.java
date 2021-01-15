
package com.example.kuisnirkabel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    String[]pertanyaan_kuis = new String[]{
            "1. Siapakah pendiri dari ESQ Business School?",
            "2. Ada dilantai berapa ESQ Business School berada?",
            "3. Apa Visi ESQ Business School?",
            "4. Apa 5 Values ESQ Business School?",
            "5. Apa itu 165?"

    };

    String[] pilihan_jawaban = new String[]{
            "Prof. Ir. H. Surna Tjahja Djajadiningrat, M.Sc., Ph.D. & Dr. (H.C.) Ary Ginanjar Agustian","Chairul Tanjung & Erick Thohir Manurung","Surya Wonowidjoyo & Tommy Suharto","Sudono Salim & Boenjamin Setiawan",
            "14","12 & 12A","2, 18, & 19","2, 3, & 4",
            "A World Class University in continuous pursuit of innovation and enterprise.","Menjadi perguruan tinggi yang terpercaya di bidang pendidikan, penelitian dan pengabdian masyarakat untuk mewujudkan peradaban emas.","Sebagai lembaga pendidikan tinggi yang berperan aktif dalam pembangunan pendidikan nasional melalui pengembangan sumber daya manusia profesional yang berwatak : mandiri, peduli dan kreatif serta adaptif dengan perkembangan global.","Terwujudnya Program Studi Teknik Mesin yang menghasilkan lulusan  berkualitas dan profesional dengan menguasai ilmu pengetahuan dan teknologi terkini di bidang teknik mesin yang dapat bersaing di tingkat internasional serta berjiwa kewirausahaan pada tahun 2020.",
            "Indonesia Bangkit, Indonesia Jaya, Indonesia Maju, Indonesia Berkembang, & Indonesia Pintar","Passion, Smart, Calm, Integrity, & Proffesionalism", "Inntegrity, Passion, Creativity, Famous, & Humility", "Integrity, Passion, Creativity, Humility, Proffesionalism",
            "1 Ihsan, 6 Prinsip, 5 Langkah, ","1 Prinsip, 6 Iman, 5 Iman","1 Hati, 6 Prinsip, 5 Langkah","1 Ihsan, 6 Langkah, 5 Prinsip",

    };

    String[] jawaban_benar = new String[]{
            "Prof. Ir. H. Surna Tjahja Djajadiningrat, M.Sc., Ph.D. & Dr. (H.C.) Ary Ginanjar Agustian",
            "2, 18, & 19",
            "Menjadi perguruan tinggi yang terpercaya di bidang pendidikan, penelitian dan pengabdian masyarakat untuk mewujudkan peradaban emas.",
            "Integrity, Passion, Creativity, Humility, Proffesionalism",
            "1 Hati, 6 Prinsip, 5 Langkah",

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = (TextView) findViewById(R.id.pertanyaan);
        rg = (RadioGroup) findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;


    }

    public  void next(View view){
        if(PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() ||PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);


            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this, "Pilih Jawaban Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}
