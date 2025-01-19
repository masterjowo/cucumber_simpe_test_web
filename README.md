

# Automation Testing Web UI - SauceDemo

Proyek ini adalah implementasi automation testing untuk pengujian UI pada website [SauceDemo](https://www.saucedemo.com) menggunakan Cucumber, Selenium, dan TestNG. Proyek ini dirancang untuk berjalan menggunakan Maven dengan parameter browser yang dapat dikonfigurasi.

## Fitur Utama
- Framework menggunakan **Cucumber** untuk mendukung pengujian berbasis Gherkin.
- **Selenium WebDriver** untuk interaksi langsung dengan elemen pada halaman web.
- **TestNG** untuk pengelolaan pengujian dan laporan.
- Dukungan untuk menjalankan pengujian di berbagai browser melalui parameter konfigurasi (`-Dbrowser`).

---

## Persiapan Proyek

### 1. Prasyarat
Pastikan Anda telah menginstal hal berikut pada sistem Anda:
- **Java Development Kit (JDK)** (versi 8 atau lebih baru)
- **Maven** (versi terbaru)
- **Browser Driver**:
  - [ChromeDriver](https://chromedriver.chromium.org/downloads) untuk Google Chrome
  - Pastikan versi ChromeDriver sesuai dengan versi browser Chrome yang terinstal
- **Browser** (Chrome diutamakan)
- **IDE** (opsional tetapi disarankan, seperti IntelliJ IDEA atau Eclipse)

### 2. Clone Repository
Clone repository proyek ini ke lokal Anda:
```bash
git clone https://github.com/masterjowo/cucumber_simpe_test_web.git
cd cucumber_simpe_test_web
```

### 3. Instalasi Dependency
Jalankan perintah berikut untuk mengunduh dan menginstal semua dependency yang diperlukan:
```bash
mvn clean install
```

---

## Struktur Proyek

```
cucumber_simpe_test_web
│   pom.xml 																					# File konfigurasi Maven
│   
├───src
│   ├───main 																					# Kode utama (Berisi pageobjects, dan Singleton Pattern)
│   │   ├───java
│   │   │   └───com
│   │   │       └───simple_web_automation_saucedemo_com
│   │   │           ├───pageobjects
│   │   │           │       CheckoutCompletePage.java
│   │   │           │       CheckoutStepOnePage.java
│   │   │           │       CheckoutStepTwoPage.java
│   │   │           │       ContohParameterizedConstructor.txt
│   │   │           │       HomePage.java
│   │   │           │       keranjangPage.java
│   │   │           │       LoginPage.java
│   │   │           │       SayaratPOM.txt
│   │   │           │
│   │   │           └───singleton
│   │   │                   DriverSingleton.java
│   │   │                   Singleton Pattern adalah salah satu pola desain.docx
│   │   │
│   │   └───resources
│   └───test
│       ├───java
│       │   ├───runners 																		# Test runner Cucumber + TestNG
│       │   │       TestRunner.java
│       │   │
│       │   └───stepdefenitions 																# Definisi langkah Gherkin
│       │           CheckoutDefenition.java
│       │           FilterStepDefenition.java
│       │           LoginStepDefenition.java
│       │
│       └───resources
│           └───features  																		# File fitur Gherkin (*.feature)
│                   Checkout.feature
│                   Filter.feature
│                   Login.feature
│
├───target
│   │   cucumber-report.json
│   │   cucumber-report.xml
│   │   simple_web_automation_saucedemo_com-1.0-SNAPSHOT.jar
│   │
│   ├───cucumber-report
│   │       formatter.js
│   │       index.html # hasil report pengujian  
│   │       jquery-3.4.1.min.js
│   │       report.js
│   │       style.css
│
└───testSuites
        testng.xml 										                                        # Konfigurasi TestNG
```

---

## Cara Menjalankan Proyek

1. **Menjalankan Test**
   Jalankan perintah berikut dari direktori root proyek untuk menjalankan pengujian dengan browser Chrome:
   ```bash
   mvn test -PTestng -Dbrowser=chrome
   ```

   Anda juga dapat mengganti parameter `-Dbrowser` dengan browser lain (misalnya, `firefox`) jika mendukung.

2. **Output Test**
   - Hasil test akan ditampilkan pada konsol.
   - Laporan detail dapat ditemukan pada folder `target`.

---

## Menambahkan Pengujian Baru

1. Tambahkan skenario baru di file fitur yang relevan di folder `src/test/resources/features`.
2. Implementasikan langkah-langkahnya di `stepDefinitions`.
3. Jalankan kembali pengujian menggunakan perintah `mvn`.

---

## Troubleshooting
- **Masalah dengan ChromeDriver**: Pastikan versi ChromeDriver sesuai dengan versi browser Chrome Anda.
- **Pengujian Gagal**: Periksa log pada konsol atau laporan di folder `target` untuk detail kesalahan.

---

## Teknologi yang Digunakan
- **Java**
- **Maven**
- **Cucumber**
- **Selenium**
- **TestNG**
- **ChromeDriver**