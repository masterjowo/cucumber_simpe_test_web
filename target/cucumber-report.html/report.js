$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "fungsi login",
  "description": "  Description: Kami akan menguji beberapa skenario menerapkan Tes E2E pada web site https://www.saucedemo.com/ mengunakan cucumber, testng , dan jenkins ",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Sebagai pengguna saya dapat login dengan benar (positive case)",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Sprint2B"
    },
    {
      "name": "@TestCase1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Diberikan  user akses halaman saucedemo.com",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.diberikan_user_akses_halaman_saucedemo_com()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Ketika user di dalaman user dapat melihat \"Swag Labs\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.ketika_user_di_dalaman_user_dapat_melihat(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Dan user memasukan UserName \"standard_user\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.dan_user_memasukan_UserName(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Dan user memasukan password \"secret_sauce\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.dan_user_memasukan_password(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Dan user mmenekan tombol login",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.dan_user_mmenekan_tombol_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Maka user dapat melihat \"Products\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.maka_user_dapat_melihat(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Sebagai pengguna saya mendapatkan peringatan jika salah input saat login (negative case)",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Sprint2B"
    },
    {
      "name": "@TestCase2"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Diberikan  user akses halaman saucedemo.com",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.diberikan_user_akses_halaman_saucedemo_com()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Ketika user di dalaman user dapat melihat \"Swag Labs\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.ketika_user_di_dalaman_user_dapat_melihat(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Dan user memasukan UserName \"standard_user1\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.dan_user_memasukan_UserName(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Dan user memasukan password \"secret_sauce\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.dan_user_memasukan_password(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Dan user mmenekan tombol login",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.dan_user_mmenekan_tombol_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Maka user dapat melihat \"Epic sadface: Username and password do not match any user in this service\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefenitions.LoginStepDefenition.maka_user_dapat_melihat(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});