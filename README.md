# LATIHAN5DPBO2023
Saya Fikry Idham Dwiyana NIM 2101294 mengerjakan Latihan 5 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Tugas:
* Ketik ulang code di atas untuk melengkapi file Menu.java.
* Tambahkan satu atribut baru di class Mahasiswa sekaligus component input-nya di form. (Usahakan setiap orang atribut barunya berbeda)
* Tambah confirmation prompt sebelum delete.

## Desain Program
Program didesain menjadi 2 class dengan 1 class utama yaitu class `Mahasiswa`:
* **Mahasiswa** -> Class yang datanya akan diisi pada GUI
* **Menu** -> Class yang berisi program untuk GUI

Pada class `Mahasiswa` terdapat lima atribut:
* **nim** -> NIM mahasiswa, `String`
* **nama** -> Nama mahasiswa, `String`
* **prodi** -> Prodi mahasiswa, `String`
* **jKelamin** -> Jenis kelamin mahasiswa, `String`

Pada class `Menu` berisi method-method untuk GUI:
* **Set Tabel** -> Men-set Tabel untuk ditampilkan pada GUI, `DefaultTableModel`
* **Insert Data** -> Menambah data, `void`
* **Update Data** -> Mengubah data yang dipilih, `void`
* **Delete Data** -> Menghapus data yang dipilih, `void`
* **Reset Form** -> Mereset form menjadi default, `void`
* Selain dari method di atas, terdapat juga method-method untuk setting GUInya

## Desain GUI
![Design](https://github.com/FikryIdhamD/LP5DPBO2024C2/assets/147605722/8f4355da-e2f0-4daa-bc71-d433d5b394b0)


## Alur Program GUI
Terdapat textfield untuk mengisi data nim, nama dan prodi. JComboBox untuk mengisi data jenis kelamin. Jika semua data sudah diisi dan klik button `add` maka akan menambahkan data serta data akan ditampilkan pada tabel dan data pada field juga akan direset ke default (kosong). Jika user sedang mengisi data dan klik tombol `cancel` maka akan mengosongkan semua data yang sebelumnya sedang diisi (bukan data pada tabel). Jika user klik salah satu data pada tabel, data akan otomatis terisi pada field untuk mengisi data, sesuai dengan data yang dipilih, serta user dapat mengubah atau menghapus data tesebut. Jika user mengubah salah satu data dan klik tombol `update` maka data pada tabel akan berubah. Jika user klik tombol `delete` maka akan muncul kotak dialog untuk konfirmasi dan jika diklik `Yes` maka data akan dihapus.

## Dokumentasi
**Jar File**
![Jar File](https://github.com/FikryIdhamD/LP5DPBO2024C2/assets/147605722/4cec7f23-cdc4-4156-87d8-7d9f9023170a)

**Tambah Data**
![Add_Data](https://github.com/FikryIdhamD/LP5DPBO2024C2/assets/147605722/638ac153-2de9-4f8a-b7d0-23aeaf704ba6)


**Ubah Data**
![Update_Data](https://github.com/FikryIdhamD/LP5DPBO2024C2/assets/147605722/ba3a14d3-d562-4cf5-a3c5-f5006c2b19d1)


**Hapus Data**
![Delete_Data](https://github.com/FikryIdhamD/LP5DPBO2024C2/assets/147605722/9335f203-01ac-4c78-8d31-282014f18a30)
![Delete_Data](https://github.com/FikryIdhamD/LP5DPBO2024C2/assets/147605722/03cb56e2-7d3e-4f1d-85d0-622321231156)
