import java.util.Scanner
class Akun(private val username: String,private val password: String){
    fun login(inputUsername: String, inputPassword: String):Boolean{
        return username == inputUsername && password == inputPassword
    }
}

class Mahasiswa(nama: String, nim: String, prodi: String, angkatan: Int, kelas: String){
    private var nama: String = nama;
    private var nim: String = nim;
    private var prodi: String = prodi;
    private var angkatan: Int = angkatan;
    private var kelas: String = kelas;

    fun getNama(): String{
        return nama
    }

    fun detailMahasiswa() : Unit{
        println("""
            |
            |Nama : $nama
            |NIM : $nim
            |Kelas : $kelas
            |Prodi : $prodi
            |Angkatan : $angkatan
            |
        """.trimMargin())
    }

    fun updateMahasiswa(nama : String, nim : String, kelas : String, prodi : String, angkatan: Int) : Unit{
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.kelas = kelas;
        this.angkatan = angkatan;

        println("Data telah terupdate!")
    }


}


fun main() {

    var statusLogin = false;

    val akuns = ArrayList<Akun>()
    val mahasiswas = ArrayList<Mahasiswa>()

    println("Selamat Datang di Aplikasi Pendataan Mahasiswa")
    println()
    println("Silahkan Registrasi Dulu Akun Anda : ")
    print("Username : ");
    val username = readLine() ?: "defaultUser";
    print("Password : ")
    val password = readLine() ?: "defaultPassword";

    val akun = Akun(username, password)
    akuns.add(akun)

    println("<}==========================={>")
    println("Akun sudah berhasil dibuat!")
    val hasilDaftar = """
        Username : $username
        Password : $password
    """.trimIndent()

    println(hasilDaftar)

    println("<}==========================={>")

    while (!statusLogin){
            println("Silahkan login dahulu !")
            print("Username : ")
            val logUser = readLine() ?: "defaultUser";
            print("Password : ")
            val logPass = readLine() ?: "defaultPass";

            akuns.forEach{
                    it -> if(it.login(logUser,logPass)){
                statusLogin = true;
                println()
                println("Anda berhasil masuk!")
                println("<}==========================={>")
            }else{
                statusLogin = false;
                println()
                println("Kridential yang dimasukan salah!")
                println("<}==========================={>")
            }
        }
    }


    if(statusLogin){
        var pilihan = 0;
        while(pilihan != 5){
            println()
            println("Silahkan pilih opsi menu yang ingin dilakukan!")
            println("1.Daftar Mahasiswa")
            println("2.Cari Mahsiswa")
            println("3.Hapus Mahasiswa")
            println("4.Edit Mahasiswa")
            println("5.Keluar")
            print("Menu yang dipilih : ")
            pilihan = readLine()!!.toInt();
            when(pilihan){
                1 -> {
                    println("<}==========================={>")
                    println()
                    println("Silahkan masukan data diri anda")
                    print("Nama : ")
                    val nama = readLine();
                    print("NIM : ")
                    val nim = readLine();
                    print("Kelas : ")
                    val kelas = readLine()
                    print("Prodi : ")
                    val prodi = readLine()
                    print("Angkatan : ")
                    val angkatan = readLine()!!.toInt()

                    val mahasiswa = Mahasiswa(nama.toString(), nim.toString() ,prodi.toString(), angkatan, kelas.toString())
                    mahasiswas.add(mahasiswa)
                    println()
                    println("Data berhasil dibuat!")
                    println("<}==========================={>")
                }

                2 -> {
                    println("<}==========================={>")
                    println()
                    println("Silahkan masukan nama dari mahasiswa yang ingin dicari")
                    print("Nama : ")
                    val cariNama = readLine();

                    val mahasiswaDitemukan = mahasiswas.find{it.getNama() == cariNama};

                    if(mahasiswaDitemukan != null){
                        mahasiswaDitemukan.detailMahasiswa()
                        println("<}==========================={>")
                    }else{
                        println()
                        println("Data tidak ditemukan!")
                        println("<}==========================={>")
                    }

                }

                3 -> {
                    println("<}==========================={>")
                    println()
                    println("Silahkan masukan nama dari mahasiswa yang ingin dicari")
                    print("Nama : ")
                    val cariNama = readLine();

                    val mahasiswaDitemukan = mahasiswas.find{it.getNama() == cariNama};

                    if(mahasiswaDitemukan != null){
                        mahasiswas.remove(mahasiswaDitemukan)
                        println()
                        println("Data berhasil di hapus!")
                        println("<}==========================={>")
                    }else{
                        println()
                        println("Data tidak ditemukan!")
                        println("<}==========================={>")
                    }
                }
                4 -> {
                    println("<}==========================={>")
                    println()
                    println("Silahkan masukan nama dari mahasiswa yang ingin dicari")
                    print("Nama : ")
                    val cariNama = readLine();

                    val mahasiswaDitemukan = mahasiswas.find{it.getNama() == cariNama}

                    if(mahasiswaDitemukan != null){
                        println("<}==========================={>")
                        println()
                            println("Silahkan masukan data mahasiswa : ")
                            print("Nama : ")
                            val upNama = readLine();
                            print("NIM : ")
                            val upNIM = readLine();
                            print("Kelas : ")
                            val upKelas = readLine();
                            print("Prodi : ")
                            val upProdi = readLine();
                            print("Angkatan : ")
                            val upAngkatan = readLine()!!.toInt();

                            mahasiswaDitemukan.updateMahasiswa(upNama.toString() ,upNIM.toString(), upKelas.toString(), upProdi.toString(), upAngkatan )
                        }else{
                            println()
                            println("Data yang anda cari tidak ada!")
                            println("<}==========================={>")
                        }
                    }



                5 -> {
                    println("Keluar dari system!")
                    break
                }
            }


        }




    }


}
