@Auth

@SmokeTest
Feature: logout feature untuk pengguna terdaftar.

  @PositiveTest
  Scenario: Pengguna berhasil masuk ke halaman Management Divisi.
    Given Klik tombol management.
    When Klik tombol divisi.
    Then Pengguna berhasil masuk kehalaman Management Divisi.


