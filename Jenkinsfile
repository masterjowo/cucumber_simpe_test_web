pipeline {
    agent any  // Menjalankan pipeline pada agen manapun yang tersedia atau node atau vm 

    environment {
        // Definisikan variabel lingkungan jika diperlukan
        // Misalnya untuk kredensial, server, dll.
        DEPLOY_SERVER = 'your.deploy.server'
        BRANCH_NAME = 'master'
    }
        tools {
        maven '3.8.7'
        jdk '21.0.6'
    }

    // triggers{
    //     //https://crontab.guru///
    //     pollSCM('* * * * *')
    // }

    stages {
        stage('Continuous_Checkout') {
            steps {
                // Checkout kode dari repositori
                git branch: "${env.BRANCH_NAME}", url: 'https://github.com/masterjowo/cucumber_simpe_test_web.git'
                sh 'pwd'
                sh'docker compose down'
                sh 'mvn clean install'
            }
        }
        stage('Continuous_Test_Browser_Edge ') {
            steps {
                        //sh 'mvn test'/
                        echo 'Running tests on edge...'
                        sh 'mvn test -PTestng  -Dbrowser=edge'
                    }
        }
        stage('Continuous_Test_Browser_Chrome ') {
            steps {
                        //sh 'mvn test'/
                        sh 'mvn test -PTestng  -Dbrowser=chrome'
                        echo 'Running tests on Chrome...'
                        sh''' cd target/cucumber-report
                            ls -a 
                        '''
                    }
            // parallel { // Menjalankan beberapa tahap secara paralel akan mengakibatkan cucumber-report terimpa dan menjadi error pada report.js
            //     stage('edge'){
            //         steps {
            //             echo 'Running tests on edge...'
            //             sh 'mvn test -PTestng  -Dbrowser=edge'
                        
            //         }
            //     }
            //     stage('Chrome'){
            //         steps {
            //             //sh 'mvn test'/
            //             sh 'mvn test -PTestng  -Dbrowser=chrome'
            //             echo 'Running tests on Chrome...'
            //             sh''' cd target/cucumber-report
            //                 ls -a 
            //             '''
            //         }
            //     }
            // }
        }

        stage('Continuous_Build') {
            steps {
                script {
                    // dir('/Hasil_Test_Web_UI_Mengunakan_Testng_Dan_Cucumber_Versi_Final/target/cucumber-report') {
                    //     sh 'docker compose build'
                    // }
                    sh'''
                        cd target/cucumber-report
                        cat report.js
                        cat formatter.js
                        cat index.html
                        cat jquery-3.4.1.min.js
                    '''
                    echo 'report.js error '
                    sh'docker compose build'
                    
                }
            }
        } 
        
        stage('Continuous_Deploy_report_html') {
            steps {
                script {
                    // sh 'docker compose up -d'
                    sh'docker compose up -d'
                }
            }
        }

        stage('Continuous_Cleanup') {
            steps {
                echo 'Cleaning up the environment...'
                sh 'mvn clean install' 
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

