Feature: fungsi filter
  Description: Kami akan menguji beberapa skenario menerapkan Tes E2E pada web site https://www.saucedemo.com/ mengunakan cucumber, testng , dan jenkins 

  @Sprint2B @TestCase1
  Scenario: Sebagai pengguna saya dapat memfilter dengan benar (positive case)
    Given Diberikan  user akses halaman "https://www.saucedemo.com/"
    When Ketika user di dalaman user dapat melihat "Swag Labs"
    And Dan user memasukan UserName "standard_user"
    And Dan user memasukan password "secret_sauce"
    And Dan user menekan tombol login
    And Dan user melakukan pengurutan Z ke A mengunakan fitur filter
    Then Maka user dapat melihat pengurutan "Name (Z to A)"
