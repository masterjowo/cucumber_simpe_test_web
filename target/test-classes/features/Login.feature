Feature: fungsi login
  Description: Kami akan menguji beberapa skenario menerapkan Tes E2E pada web site https://www.saucedemo.com/ mengunakan cucumber, testng , dan jenkins 

  @Sprint2B @TestCase1
  Scenario: Sebagai pengguna saya dapat login dengan benar (positive case)
    Given Diberikan  user akses halaman saucedemo.com
    When Ketika user di dalaman user dapat melihat "Swag Labs"
    And Dan user memasukan UserName "standard_user"
    And Dan user memasukan password "secret_sauce"
    And Dan user mmenekan tombol login
    Then Maka user dapat melihat "Products"

  @Sprint2B @TestCase2
  Scenario: Sebagai pengguna saya mendapatkan peringatan jika salah input saat login (negative case)
    Given Diberikan  user akses halaman saucedemo.com
    When Ketika user di dalaman user dapat melihat "Swag Labs"
    And Dan user memasukan UserName "standard_user1"
    And Dan user memasukan password "secret_sauce"
    And Dan user mmenekan tombol login
    Then Maka user dapat melihat "Epic sadface: Username and password do not match any user in this service"
