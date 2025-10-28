@smoketest

@mencariuser
Feature: Mencari User di Halaman Management User

  Scenario: Mencari User yang ada di halaman Management User
    Given Admin sudah berada di halaman Management User
    When Admin memasukkan data user pada kolom pencarian
    And Admin menekan tombol cari
    Then Sistem menampilkan data user yang dicari pada tabel di halaman Management User
