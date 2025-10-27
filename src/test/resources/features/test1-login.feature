@Auth
Feature: login feature untuk pengguna terdaftar dan pendaftaran akun baru.

  @SmokeTest
  Scenario: Memverifikasi pengguna terdaftar dapat berhasil login dengan kredensial valid.
    Given Buka halaman utama.
    When Masukkan email dan password yang valid.
    And Klik tombol 'Login'.
    Then Pengguna berhasil login dan diarahkan ke dashboard.