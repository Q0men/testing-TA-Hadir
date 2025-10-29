@Auth
Feature: login Logout feature untuk pengguna terdaftar.

  @PositiveTest
  Scenario: Memverifikasi pengguna terdaftar dapat berhasil login dengan kredensial valid.
    Given Buka halaman utama.
    When Masukkan email dan password yang valid.
    And Klik tombol 'Login'.
    Then Pengguna berhasil login dan diarahkan ke dashboard.

  @Negativetest
  Scenario: Memverifikasi pesan kesalahan muncul saat pengguna memasukkan kredensial tidak valid.
    Given Buka halaman utama.
    When Masukkan email atau password yang tidak valid.
    And Klik tombol 'Login'.
    Then Pesan kesalahan 'Kredensial tidak valid' ditampilkan. 
    
    @PositiveTest
    Scenario: Memverifikasi pengguna terdaftar dapat berhasil logout dari aplikasi.
        Given Pengguna telah login dengan kredensial valid.
        When Klik tombol 'Logout'.
        Then Pengguna berhasil logout dan diarahkan ke halaman utama.