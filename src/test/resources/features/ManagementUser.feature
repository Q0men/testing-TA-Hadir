@SmokeTest
Feature: Managmenent User feature untuk admin.

@positiveSearch
@mencariuser
  Scenario: Mencari User yang ada di halaman Management User
    Given Admin sudah berada di halaman Management User
    When Admin memasukkan data user pada kolom pencarian
    And Admin menekan tombol Search
    Then Sistem menampilkan data user yang dicari pada tabel di halaman Management User

@negativeSearch
@tidakmencariuser
  Scenario: Mencari User yang tidak ada di halaman Management User
    Given Admin sudah berada di halaman Management User
    When Admin memasukkan data user yang tidak terdaftar pada kolom pencarian
    And Admin menekan tombol Search
    Then Sistem menampilkan informasi bahwa data user tidak ditemukan pada halaman Management User

@buttonreset
@resetpencarianuser
  Scenario: Mereset kolom pencarian di halaman Management User
    Given Admin sudah berada di halaman Management User
    When Admin memasukkan data user pada kolom pencarian
    And Admin menekan tombol Reset
    Then Sistem mengosongkan kolom pencarian dan menampilkan semua data user pada tabel di halaman Management User

@buttonrole
@filterberdasarkanrole
  Scenario: Memfilter user berdasarkan role di halaman Management User
    Given Admin sudah berada di halaman Management User
    When Admin menekan tombol Role dan memilih role yang diinginkan
    And Admin mengisi kolom pencarian dengan data user sesuai role yang dipilih
    And Admin menekan tombol Search
    Then Sistem menampilkan data user sesuai dengan role yang dipilih pada tabel di halaman Management User

@buttonlogout
@logoutdarihalamanmanagementuser
  Scenario: Logout dari halaman Management User
    Given Admin sudah berada di halaman Management User
    When Admin menekan tombol Logout
    Then Sistem mengarahkan Admin ke halaman Login

@buttonfilter
@filter
  Scenario: Mengakses fitur filter di halaman Management User
    Given Admin sudah berada di halaman Management User
    When Admin menekan tombol Filter
    Then Sistem menampilkan opsi filter untuk mengelola tampilan data user di halaman Management User

@comboboxunit
@filterberdasarkanunit
  Scenario: Memfilter user berdasarkan unit di halaman Management User (contoh : Unit = Jakarta )
    Given Admin sudah berada di halaman Management User
    When Admin menekan tombol filter dan memilih unit
    And Admin memilih Unit
    Then Sistem menampilkan Unit pada combobox sesuai dengan unit yang dipilih

@filterSearch
@filterberdasarkanfilterdanmencariuser
  Scenario: Memfilter user berdasarkan filter di halaman Management User (contoh : Tipe Karyawan = Mitra )
    Given Admin sudah berada di halaman Management User
    When Admin menekan tombol filter dan memilih filter
    And Admin mengisi kolom pencarian dengan data user sesuai filter yang dipilih
    And Admin menekan tombol Search
    Then Sistem menampilkan data user sesuai dengan filter yang dipilih pada tabel di halaman Management User