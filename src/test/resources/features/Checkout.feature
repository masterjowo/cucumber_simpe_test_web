Feature: fungsi Checkout
  Description: Kami akan menguji beberapa skenario menerapkan Tes E2E pada web site https://www.saucedemo.com/ mengunakan cucumber, testng , dan jenkins 

  @Sprint2B @TestCase1
  Scenario: Sebagai pengguna saya dapat Checkout benar (positive case)
    Given Diberikan  user akses halaman "https://www.saucedemo.com/"
    When Ketika user di dalaman user dapat melihat "Swag Labs"
    And Dan user memasukan UserName "standard_user"
    And Dan user memasukan password "secret_sauce"
    And Dan user menekan tombol login
    And Dan user memilih barang sauce labs backpack dan barang sauce labs bike light
    And Dan user menekan tombol keranjang
    And Dan user menekan tombol checkout
    And Dan user memasukan nama depan "Muhammad" dan nama belakang " Ramadhan" dan kode pos "12345" dan menekan tombol continue
    And Dan user menekan tombol finish
    Then Maka user dapat melihat pemberitahuan "Thank you for your order!"
