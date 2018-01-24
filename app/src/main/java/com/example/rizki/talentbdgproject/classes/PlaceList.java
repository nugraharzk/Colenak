package com.example.rizki.talentbdgproject.classes;

import android.content.Context;

import com.example.rizki.talentbdgproject.R;

import java.util.ArrayList;

/**
 * Created by Rizki on 11/15/2017.
 */

public class PlaceList {
    private Context context;
    private ArrayList<Place> placeList;

    public PlaceList(Context context, ArrayList<Place> places) {
        this.context = context;
        this.placeList = places;

        addData();
    }

    public void addData(){
        int[] covers = new int[]{
                R.drawable.lalin,
                R.drawable.hong,
                R.drawable.bsc,
                R.drawable.geologi,
                R.drawable.pustaka,
                R.drawable.bonbin,
                R.drawable.pos1,
                R.drawable.ujo1};

        int[] lalin = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5};
        int[] hong = new int[]{R.drawable.h1, R.drawable.h2, R.drawable.h3};
        int[] geo = new int[]{R.drawable.g1, R.drawable.g2, R.drawable.g3};
        int[] bsc = new int[]{R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5};
        int[] lib = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3};
        int[] bon = new int[]{R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5};
        int[] pos = new int[]{R.drawable.pos2, R.drawable.pos3, R.drawable.pos4, R.drawable.pos5, R.drawable.pos6};
        int[] ujo = new int[]{R.drawable.ujo1, R.drawable.ujo2, R.drawable.ujo3, R.drawable.ujo4};

        String deskripsi = "\tSebuah Taman Rekreasi dan Edukasi yang ada di jantung kota Bandung. Selain sebagai taman dan tempat bermain, disini juga dijadikan pusat latihan membaca rambu-rambu lalu lintas. Taman Lalu Lintas adalah sebuah taman dimana anak-anak dapat mempelajari aturan jalan. Tujuan dari Taman Lalu lintas adalah untuk meningkatkan kesadaran keselamatan lalu lintas di kalangan anak-anak usia sekolah. Taman lalu lintas dibuat karena kepedulian akan kesadaran keselamatan lalu lintas. Kesadaran ini diperkenalkan dari usia dini dengan cara bermain. Dari usia dini, sudah peduli akan tata tertib di jalan" +
                "Taman Lalu lintas memiliki 3 zona yaitu lalu lintas diperkotaan, dipegunungan dan air. Selain itu juga terdapat panggung kesenian, area piknik keluarga, dan playground\n\n";
        String desc = "Taman Lalu Lintas terbagi menjadi 3 zona :\n" +
                "•\tZona Kota\n" +
                "Di Zona Kota, jalur sepeda diperhalus dengan lapisan aspal, dengan rute baru mengelilingi zona lainnya. Edukasi pengendara sepeda cilik dalam berlalu lintas itu didukung dengan bangunan mini toko, kantor pos, minimarket, hingga pom bensin. Setelah melewati area kolam renang, jalur sepeda dibuat menaiki jembatan yang merefleksikan jalan layang.\n" +
                "Masih di Zona Kota, kereta api dipermak sebentuk kereta cepat yang akan hadir di Kota Bandung. Selain dilengkapi ampiteater, terdapat ruang tontonan edukasi yang menampilkan tayangan tentang berlalu lintas.\n" +
                "•\tZona Air\n" +
                "Taman Lalu Lintas juga menyediakan Zona Air untuk anak-anak yang ingin bermain air di kolam serupa wahana air Taman Sejarah. \n" +
                "•\tZona Gunung\n" +
                "Zona Gunung bisa dimanfaatkan semua kalangan yang ingin piknik di area rumput berbukit.\n";
        String jam = context.getString(R.string.jam_lalin);
        Place a = new Place("Taman Lalu Lintas", "Jl. Belitung No.1, Merdeka, Sumur Bandung, Kota Bandung, Jawa Barat 40113", "(022) 4201667", jam, context.getString(R.string.harga_lalin), deskripsi+desc, covers[0], lalin);
        a.setLat(-6.9111);
        a.setLng(107.6135);
        placeList.add(a);

        deskripsi = "Komunitas Hong merupakan tepat wisata edukasi dan budaya. Komunitas Hong adalah sebuah pusat Kajian Mainan Rakyat dengan tujuan Melestarikan aneka permainan rakyat, melakukan pembinaan dan pelatihan untuk anak-anak agar mengenal dan menjadikan budaya bermain lokal tetap eksis, mengembangkan aneka permainan rakyat sebagai dasar pengembangan mainan anak-anak untuk tujuan edukasi. Permainan Tradisional yang terdapat di Komunitas Hong memberikan nilai manfaat di dalamnya, mulai dari unsur hiburan, olah raga, kebersamaan, mencintai alam, hingga kecerdasan berpikir dan strategi.";
        jam = context.getString(R.string.jam_library);
        a = new Place("Komunitas Hong", "Jalan Bukit Pakar Utara 35 Dago", "(022) 2515773", jam, "Rp.100.000", deskripsi, covers[1], hong);
        a.setLat(-6.8580897);
        a.setLng(107.6334899);
        placeList.add(a);

        deskripsi = "BSC adalah Pusat Ilmu interaktif yang dirancang untuk semua orang dari segala usia. Pusat Ilmu ini akan mendidik masyarakat dengan ilmu pengetahuan dasar dan teknologi masa depan dimana pengunjung Pusat Ilmu ini akan mencoba sendiri secara interaktif peraga-peraga didalam dan diluar gedung Bandung Science Center ini dengan cara menyentuh, memainkan alat-alat peraga, melihat, melakukan, menganalisa eksperimen-experiment ilmu-ilmu dasar, serta mendengar suara dan aroma dari percobaan kimia dan fisika, disamping melakukan observasi fenomena-fenomena alam, dan mempelajari semua aspek yang berhubungan dengan ilmu pengetahuan dan teknologi termaju. Metode di BSC itu sendiri adalah dengan Menggunakan peralatan yang didisain khusus, baik berupa alat peraga, peralatan eksperimen,peralatan mekanis, peralatan audio/video, ataupun peralatan sederhana yang digunakan untuk bermain, berinteraksi dan bereksplorasi bertujuan untuk pembelajaran, pemahaman dan pembuktian dari suatu proses belajar terutama buat siswa-siswa sekolah.";
        jam = context.getString(R.string.jam_bsc);
        a = new Place("Bandung Science Center", "Jalan Sirnagalih No.15 Gegerkalong, Sukasari", "(022) 2060415", jam, "Rp.20.000", deskripsi, covers[2], bsc);
        a.setLat(-6.877424);
        a.setLng(107.594761);
        placeList.add(a);

        deskripsi = "•\tMuseum ini adalah Sebagai salah satu tempat wisata di bandung yang menarik sekaligus  sangat refresentatif dan sangat layak dikunjungi di Bandung untuk keperluan pendidikan atau penelitian. Koleksi yang ada di museum geologi bandung dinilai sangat berguna untuk ilmu pengetahuan serta dunia pendidikan tentang nilai-nilai sejarah kehidupan manusia dengan dan alam sekitarnya. Kegiatan wisata yang akan didapatkan apabila berkunjung ke museum geologi bandung adalah selain akan mengenal berbagai macam koleksi yang dimiliki oleh Museum Geologi Bandung seperti bebatuan, fosil, dan mineral, di tempat ini pun pengunjung juga dapat mempelajari banyak hal yang berhubungan dengan bencana alam, bumi, pemanfaatan sumber daya dengan benar, cara mengolah energi, dan lain-lain.Sebuah bangunan sejarah yang sangat penting nilai fungsi dan sejarahnya.";
        a = new Place("Museum Geologi", "Jalan Diponegoro No.57", "(022) 7213822", "10:00 - 17:00", "Rp.3000", deskripsi, covers[3], geo);
        a.setLat(-6.900719);
        a.setLng(107.621492);
        placeList.add(a);

        deskripsi = "•\tPerpustakaan untuk anak, warung buku anak dan kegiatan ruang terbuka untuk anak (khususnya usia 2 – 6 tahun). Pustakalana dapat menjadi tempat di mana orangtua (atau pendamping anak lainnya) dapat meluangkan waktu bersama anak untuk membaca bersama, menjadi alternatif tempat baik bagi anak maupun untuk orangtua agar dapat bermain dan saling bertukar pikiran, dan yang terpenting anak-anak mendapatkan akses mudah untuk bisa membaca buku-buku bermutu dengan harga terjangkau. Pustakalana bisa menjadi tempat bagi anak dan keluarga untuk bisa sama-sama membangun sebuah budaya sehat dan positif: melalui kegiatan membaca, berkreasi, dan sharing knowledge dalam berbagai kegiatan.";
        a = new Place("Pustakalana Bandung", "Jalan Taman Cibeunying Selatan No.5", "0812-2108-6013", "07:00 - 17:00", "Rp.5000", deskripsi, covers[4], lib);
        a.setLat(-6.908091);
        a.setLng(107.626352);
        placeList.add(a);

        deskripsi = "Kebun Binatang Bandung ini pada awalnya dikenal dengan nama Derenten (dalam Bahasa sunda, dierentuin) yang artinya kebun binatang. Kebun Binatang Bandung didirikan pada tahun 1930 oleh Bandung Zoological Park (BZP), yang dipelopori oleh Direktur Bank Dennis, Hoogland. Pengesahan pendirian Kebun Binatang ini diwenangi oleh Gubernur Jenderal Hindia Belanda dan pengesahannya dituangkan pada keputusan 12 April 1933 No.32. Pada saat Jepang menguasai daerah ini, tempat wisata ini kurang terkelola, hingga pada tahun 1948, dilakukan rehabilitasi untuk mengembalikan fungsi tempat wisata ini." + "\n" + "\n" +
                "Pada tahun 1956, atas inisiatif dari Raden Ema Bratakusumah, Bandung Zoological Park dibubarkan dan berganti menjadi Yayasan Marga Satwa Tamansari pada tahun 1957." + "\n" + "\n" +
                "Kebun binatang ini menempati luas lahan 13,5 ha yang topografinya bergelombang dengan penggunaan 18,25% untuk areal perkandangan, 55,20% untuk pertamanan dan lesehan, 4,7% untuk taman ria dan kolam perahu, dan 2,4% untuk pengolahan sampah. Sisanya digunakan untuk bangunan kantor, museum aquarium, dan jalan.";
        a = new Place("Kebun Binatang", "Jalan Kebun Binatang No.6, Lebak Siliwangi, Coblong, Bandung, Jawa Barat, Indonesia", "(022) 2507302", "Bonbin Bandung memberlakukan jam kunjungan setiap hari buka dengan jam operasional mulai pukul 07.00  s/d pukul 18.00 Wib.", "Informasi harga tiket masuk kebun binatang sekarang per 1 Januari 2015 menjadi Rp. 25.000,-/orang.\n" +
                "Untuk rombongan minimal 30 org dapat diskon : Pelajar diskon 50%, orgtua/guru/pembimbing diskon 20%.", deskripsi, covers[5], bon);
        a.setLat(-6.890144);
        a.setLng(107.606959);
        placeList.add(a);

        deskripsi = "Gedung Museum Pos Indonesia di Kota Bandung ini adalah banguan yang merupakan hasil rancang bangun atau diarsiteki oleh dua orang berkewarganegaraan Belanda, yaitu J.Berger dan juga Leutdsgebouwdienst.\n" +
                "\n" +
                "Museum Pos ini dibuka pertama kalinya pada tahun 1931, dengan nama Museum Pos, Telegraf dan Telepon (PTT), dengan sebagian besar koleksi museumnya pertama kali adalah berupa perangko yang berasal dari dalam dan luar negeri.\n" +
                "\n" +
                "Namun dalam perkembangannya, terutama di masa peralihan kekuasaan penjajahan di Indonesia dari pihak Belanda ke Jepang, atau sekitar masa Perang Dunia ke 2, Museum Pos ini menjadi kurang diperhatikan alias tidak terawat dengan baik bahkan terbengkalai.\n" +
                "\n" +
                "Hingga kemudian pada sekitar tahun 1980, Perum Pos dan Giro, berusaha mengambil inisiatif dengan membuat sebuah panitia yang difungsikan untuk program perbaikan serta perawatan dan inventarisasi benda-benda sejarah bisa dijadikan koleksi museum Pos\n" +
                "\n" +
                "Nah lantas sejarah mencatat, tepat pada Hari Bhakti Postel ke 30, yang jatuh pada tanggal 27 September 1983, Museum Pos Indonesia di Bandung ini pun akhirnya diresmikan oleh Achmad Tahir, yang pada saat itu menjabat sebagai Menteri Pariwisata Pos dan Telekomunikasi (Menparpostel) Indonesia.\n" +
                "\n" +
                "Pada saat diresmikan tersebut, Museum Pos Indonesia sudah memiliki banyak koleksi benda-benda hingga perakatan yang masih terkait hubungannya dengan proses sejarah panjang Pos dari masa ke masa.\n" +
                "\n" +
                "Tercatat pada waktu itu, terdapat tidak kurang benda sejarah pos dari 5 masa pemerintahan kolonialisme yang terjadi di indonesia, yaitu dari masa kompeni dan Bataafsche Republiek (1707-1803), Masa Pemerintahan Daendels (1808-1811), Masa Pemerintahan Inggris (1811-1816), Masa Pemerintahan Hindia Belanda (1866-1942), Masa Pendudukan Jepang (1942-1945) hingga masa kemerdekaan.\n" +
                "\n" +
                "Di Museum Pos Indonesia juga anda akan tahu, bagaimana proses perubahan Pos Indonesia dari waktu ke waktu, dimana di sini tercatat bahwa Pos Indonesia ini sudah 5 kali berganti nama dan juga Lambang.\n" +
                "\n" +
                "Jika diurut, maka fase perubahannya adalah adalah mulai dari Jawatan PTT (1945-1961), kemudian berubah menjadi PN Postel (1962-1965), lalu PN Pos dan Giro (1965-1978), terus Perum Pos dan Giro (1978-1995), sebelumnya akhirnya menjadi PT Pos Indonesia hingga saat ini.";
        a = new Place("Museum Pos Indonesia", "Jalan Cilaki No 73, Kota Bandung, Jawa Barat Indonesia", "022-4206195", "Waktu operasional Museum Pos ini adalah setiap hari, Senin hingga Sabtu dan Minggu Libur, mulai pukul 09.00 – 16.00 WIB", "Gratis", deskripsi, covers[6], pos);
        a.setLat(-6.902307);
        a.setLng(107.619957);
        placeList.add(a);

        deskripsi = "Saung Angklung Udjo (SAU) adalah sebuah tempat wisata atraksi pertunjukan, pusat kerajinan tangan dari bambu, dan workshop instrumen musik dari bambu.\n" +
                "\n" +
                "Selain itu, tempat ini didirikan sebagai laboratorium pendidikan serta edukasi untuk melestarikan kebudayaan Sunda, khususnya alat musik angklung.\n" +
                "\n" +
                "Tidak hanya itu saja, ketika anda berwisata di kawasan Saung Angklung mang Udjo ini,\n" +
                "\n" +
                "Anda sedang berada di sebuah tempat dengan suasana yang tenang dan udaranya segar karena lokasinya dikelilingi oleh pohon-pohon bambu.\n" +
                "\n" +
                "Bagaimana sahabat, sangat menarik bukan ?\n" +
                "\n" +
                "Dijamin harga tiket masuk saung angklung udjo yang harus anda keluarkan, akan sebanding dengan kepuasamn anda bermain di sini.";

        String harga = "Wisatawan Domestik\t60.000\n" +
                "Wisatawan Mancanegara\t100.000\n" +
                "Pelajar Domestik\t40.000\n" +
                "Pelajar Mancanegara\t60.000";
        a = new Place("Saung Angklung Udjo", "Jalan Padasuka no 118, Kota Bandung", "(022) 7271714", "Jam buka Saung angklung udjo sendiri adalah setiap hari, senin hingga minggu, mulai buka dari pukul 08.00 – 22.00 WIB.", harga, deskripsi, covers[7], ujo);
        a.setLat(-6.898048);
        a.setLng(107.654965);
        placeList.add(a);
    }

    public ArrayList<Place> getPlaceList() {
        return placeList;
    }
}
