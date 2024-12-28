pipeline {
    agent any  // Menjalankan pipeline pada agen manapun yang tersedia atau node atau vm 

    environment {
        // Definisikan variabel lingkungan jika diperlukan
        // Misalnya untuk kredensial, server, dll.
        DEPLOY_SERVER = 'your.deploy.server'
        BRANCH_NAME = 'master'
    }

    triggers{
        //https://crontab.guru/
        pollSCM('* * * * *')
    }

    stages {
        stage('Continuous_Checkout') {
            steps {
                // Checkout kode dari repositori
                git branch: "${env.BRANCH_NAME}", url: 'https://github.com/masterjowo/cucumber_simpe_test_web.git'
                sh''' cd target/cucumber-report
                docker compose down
                '''
            }
        }
        stage('Continuous_Test_Browser ') {
            parallel {
                stage('Chrome'){
                    steps {
                        //sh 'mvn test'
                        sh 'mvn test -Dbrowser=chrome'
                        echo 'Running tests on Chrome...'
                        // sh 'mvn test -Dbrowser=chrome'//
                    }
                }
                stage('Firefox'){
                    steps {
                        echo 'Running tests on Firefox...'
                        
                    }
                }

            }
        }

        stage('Continuous_Build') {
            steps {
                script {
                    // dir('/Hasil_Test_Web_UI_Mengunakan_Testng_Dan_Cucumber_Versi_Final/target/cucumber-report') {
                    //     sh 'docker compose build'
                    // }
                    sh''' cd target/cucumber-report
                    docker compose build
                     '''
                    
                }
            }
        } 
        
        stage('Continuous_Deploy_report_html') {
            steps {
                script {
                    // sh 'docker compose up -d'
                    sh''' cd target/cucumber-report
                    docker compose up -d
                     '''
                }
            }
        }

        stage('Continuous_Cleanup') {
            steps {
                echo 'Cleaning up the environment...'
                // Membersihkan file sementara atau proses lain yang tidak dibutuhkan
            }
        }
    }

    post {
        success {
            // Kirim notifikasi ke Discord setelah build
            discordSend description: "Jenkins Pipeline Build", 
                        footer: "Pipeline berhasil! Proyek telah dibangun, diuji, dan dideploy.", 
                        // link: env.BUILD_URL, 
                        result: currentBuild.currentResult, // or   result: "#3498db",
                        thumbnail: "https://example.com/thumbnail.png",
                        webhookURL: "https://discord.com/api/webhooks/1306897325678923816/uIkmBEq4CNJWxNIZ3mzrVjswV4Hn8E90QA_-7iQvQ1GxuWXZmtquU6FeHzFsQdJ5fJ1R"
        }
        failure {
            echo 'Pipeline gagal. Periksa log untuk detail kesalahan.'
        }
        always {
            echo 'Pipeline selesai menjalankan semua tahap.'
        }
    }

//https://www.jenkins.io/doc/pipeline/steps/workflow-basic-steps/#pwd-determine-current-directory
}

