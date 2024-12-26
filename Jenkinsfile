pipeline {
    agent any  // Menjalankan pipeline pada agen manapun yang tersedia atau node atau vm 

    environment {
        // Definisikan variabel lingkungan jika diperlukan
        // Misalnya untuk kredensial, server, dll.
        DEPLOY_SERVER = 'your.deploy.server'
        BRANCH_NAME = 'main'
    }
    triggers{
        //https://crontab.guru/
        pollSCM('* * * * *')

    }

    stages {
        // stage('Continuous_Checkout') {
        //     steps {
        //         // Checkout kode dari repositori
        //         git branch: "${env.BRANCH_NAME}", url: 'https://github.com/masterjowo/cucumber_simpe_test_web.git'
        //     }
        // }




        stage('Continuous_Test_Browser ') {
            parallel {
                stage('Chrome'){
                    steps {
                        pwd()
                        echo 'Running tests on Chrome...'
                        // sh 'mvn test -Dbrowser=chrome'
                    }
                }
                stage('Firefox'){
                    steps {
                        echo 'Running tests on Chrome...'
                        echo 'Running tests on Firefox...'
                        // sh 'mvn test -Dbrowser=chrome'
                    }
                }

            }
        }

        stage('Continuous_Build') {
            steps {
                script {
                    // Simulasi proses build
                    // echo 'Building the project...'
                    sh 'mvn clean install'
                    // Contoh build, misalnya menggunakan Maven, Gradle, atau npm
                    // sh 'echo "Simulating build... build completed!"'
                            
                    // Contoh dengan Maven:
                    // sh 'mvn clean package'
                }
            }
        } 
        
        stage('Continuous_Deploy_report_html') {
            steps {
                script {
                    // Simulasi proses deployment ke server
                    // echo "Deploying to ${env.DEPLOY_SERVER}..."
                    
                    // Misalnya menggunakan SSH atau SCP untuk mengirim file ke server
                    sh 'echo "Simulating deploy... deployment success!"'
                    sh 'echo "Simulating deploy... deployment success!"'
                    
                    // Contoh perintah deploy:
                    // sh 'scp target/your-artifact.jar user@${env.DEPLOY_SERVER}:/path/to/deploy/'

                    // Jika menggunakan Ansible atau Docker:
                    // sh 'ansible-playbook deploy.yml'
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
}