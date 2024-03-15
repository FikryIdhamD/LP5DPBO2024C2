import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;



public class Menu extends JFrame{
    public static void main(String[] args) {
        // buat object window
        Menu window = new Menu();
        // atur ukuran window
        window.setSize(480,  560);
        // letakkan window di tengah layar
        window.setLocationRelativeTo(null);
        // isi window
        window.setContentPane(window. mainPanel);
        // ubah warna background
        window.getContentPane().setBackground(Color.white);
        // tampilkan window
        window.setVisible(true);
        // agar program ikut berhenti saat window diclose
        window.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
    }

    // index baris yang diklik
    private int selectedIndex = -1;
    // list untuk menampung semua mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTextField prodiField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel prodiLabel;
    private JLabel jenisKelaminLabel;

    // constructor
    public Menu() {
        // inisialisasi listMahasiswa
        listMahasiswa = new ArrayList<>();
        // isi listMahasiswa
        populateList();
        // isi tabel mahasiswa
        mahasiswaTable.setModel(setTable());
        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));
        // atur isi combo box
        String[] jenisKelaminData = {"Laki-laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel(jenisKelaminData));
        // sembunyikan button delete
        deleteButton.setVisible(false);
        // saat tombol add/update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    insertData();
                }else{
                    updateData();
                }
            }
        });
        // saat tombol delete ditekan
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex >= 0) {
                    deleteData();
                }
            }
        });
        // saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        // saat salah satu baris tabel ditekan
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // ubah selectedIndex menjadi baris tabel yang diklik
                 selectedIndex = mahasiswaTable.getSelectedRow();
                // simpan value textfield dan combo box
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2). toString();
                String selectedProdi = mahasiswaTable.getModel().getValueAt(selectedIndex, 3). toString();
                String selectedJeniskelamin = mahasiswaTable.getModel(). getValueAt (selectedIndex, 4). toString();

                // ubah isi textfield dan combo box
                nimField.setText (selectedNim);
                namaField. setText (selectedNama) ;
                prodiField. setText (selectedProdi) ;
                jenisKelaminComboBox. setSelectedItem(selectedJeniskelamin);

                // ubah button "Add" menjadi "Update"
                addUpdateButton.setText("Update");
                // tampilkan button delete
                deleteButton. setVisible(true);
            }
        });
    }

    public final DefaultTableModel setTable() {
        // tentukan kolom tabel
        Object[] column = {"No", "NIM", "Name","Prodi", "Jenis Kelamin"};

        // buat objek tabel dengan kolom yang sudah dibuat
        DefaultTableModel temp = new DefaultTableModel(null, column);

        // isi tabel dengan listMahasiswa
        for (int i = 0; i < listMahasiswa.size(); i++) {
            Object[] row = new Object[5];
            row[0] = i + 1;
            row[1] = listMahasiswa.get(i).getNim();
            row[2] = listMahasiswa.get(i).getNama();
            row[3] = listMahasiswa.get(i).getProdi();
            row[4] = listMahasiswa.get(i).getJenisKelamin();
            temp.addRow(row);
        }
        return temp;
    }


    public void insertData() {
        // ambil value dari textfield dan combobox
        String nim = nimField.getText();

        String nama = namaField.getText();

        String prodi = prodiField.getText();

        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();

        // tambahkan data ke dalam list
        listMahasiswa.add(new Mahasiswa(nim, nama, prodi, jenisKelamin));

        // update tabel
        mahasiswaTable.setModel (setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Insert berhasil!");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambankan");
    }

    public void updateData() {
        // ambil data dari form
        String nim = nimField.getText();
        String nama = namaField.getText();
        String prodi = prodiField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();

        // ubah data mahasiswa di list
        listMahasiswa.get(selectedIndex).setNim(nim); ;
        listMahasiswa.get(selectedIndex).setNama(nama) ;
        listMahasiswa.get(selectedIndex).setProdi(prodi);
        listMahasiswa.get(selectedIndex).setJenisKelamin(jenisKelamin); ;

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Update Berhasili");
                JOptionPane.showMessageDialog(null,"Data berhaasil diubah!");

    }

    public void deleteData() {
        int confirmation = JOptionPane.showConfirmDialog(null, "Hapus Data?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            // hapus data dari list
            listMahasiswa.remove(selectedIndex);

            // update tabel
            mahasiswaTable.setModel(setTable());

            // bersihkan form
            clearForm();

            // feedback
            System.out.println("Delete berhasil!");
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        }
    }

    public void clearForm() {
        // kosongkan semua texfield dan combo box
        nimField.setText("");
        namaField.setText("");
        prodiField.setText("");
        jenisKelaminComboBox.setSelectedItem("");

        // ubah button "Update" menjadi "Add"
        addUpdateButton. setText("Add");
        // sembunyikan button delete
        deleteButton.setVisible(false);
        // ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }


    private void populateList() {
        listMahasiswa.add(new Mahasiswa("2203999", "Amelia Zalfa Julianti", "FPMIPA", "Perempuan"));
        listMahasiswa.add(new Mahasiswa("2202292", "Muhammad Iqbal Fadhilah", "FPTK", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2202346", "Muhammad Rifky Afandi", "FPIPS", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2210239", "Muhammad Hanif Abdillah", "FPOK", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2202046", "Nurainun", "FIP", "Perempuan"));
        listMahasiswa.add(new Mahasiswa("2205101", "Kelvin Julian Putra", "FPEB", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2200163", "Rifanny Lysara Annastasya", "FPSD", "Perempuan"));
        listMahasiswa.add(new Mahasiswa("2202869", "Revana Faliha Salma", "FPMIPA", "Perempuan"));
        listMahasiswa.add(new Mahasiswa("2209489", "Rakha Dhifiargo Hariadi", "FPTK", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2203142", "Roshan Syalwan Nurilham", "FPIPS", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2200311", "Raden Rahman Ismail", "FPOK", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2200978", "Ratu Syahirah Khairunnisa", "FIP", "Perempuan"));
        listMahasiswa.add(new Mahasiswa("2204509", "Muhammad Fahreza Fauzan", "FPEB", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2205027", "Muhammad Rizki Revandi", "FPSD", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2203484", "Arya Aydin Margono", "FPMIPA", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2200481", "Marvel Ravindra Dioputra", "FPTK", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2209889", "Muhammad Fadlul Hafiizh", "FPIPS", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2206697", "Rifa Sania", "FPOK", "Perempuan"));
        listMahasiswa.add(new Mahasiswa("2207260", "Imam Chalish Rafidhul Haque", "FIP", "Laki-laki"));
        listMahasiswa.add(new Mahasiswa("2204343", "Meiva Labibah Putri", "FPEB", "Perempuan"));
    }
}
