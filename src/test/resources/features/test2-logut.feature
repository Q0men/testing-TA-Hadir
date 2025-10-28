@Auth

 @SmokeTest
    Feature: logout feature untuk pengguna terdaftar.
    
    @PositiveTest
    Scenario: Memverifikasi pengguna terdaftar dapat berhasil logout dari aplikasi.
        Given Pengguna telah login dengan kredensial valid.
        When Klik tombol 'Logout'.
        Then Pengguna berhasil logout dan diarahkan ke halaman utama.