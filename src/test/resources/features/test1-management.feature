@Testtombol
Feature: Test tombol pada halaman Management User

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