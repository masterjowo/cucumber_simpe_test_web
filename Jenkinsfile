pipeline {
    agent any  // Menjalankan pipeline pada agen manapun yang tersedia atau node atau vm 

    environment {
        // Definisikan variabel lingkungan jika diperlukan
        // Misalnya untuk kredensial, server, dll.
        DEPLOY_SERVER = 'your.deploy.server'
        BRANCH_NAME = 'main'
    }
    triggers{
        pollSCM('* * * * *')
    }

    stages {
        stage('Continuous_Checkout') {
            steps {
                // Checkout kode dari repositori
                git branch: "${env.BRANCH_NAME}", url: 'https://github.com/masterjowo/cucumber_simpe_test_web.git'
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


        stage('Continuous_Test_Browser ') {
            parallel {
                stage('Chrome '){
                    steps {
                        // echo 'Running tests on Chrome...'
                        // sh 'mvn test -Dbrowser=chrome'
                    }
                }
                stage('Firefox'){
                    steps {
                        // echo 'Running tests on Chrome...'
                        // sh 'mvn test -Dbrowser=chrome'
                    }
                }

            }
        }
        
        stage('Continuous_Deploy') {
            steps {
                script {
                    // Simulasi proses deployment ke server
                    // echo "Deploying to ${env.DEPLOY_SERVER}..."
                    
                    // Misalnya menggunakan SSH atau SCP untuk mengirim file ke server
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

    // post {
    //     success {
    //         echo 'Pipeline berhasil! Proyek telah dibangun, diuji, dan dideploy.'
    //     }
    //     failure {
    //         echo 'Pipeline gagal. Periksa log untuk detail kesalahan.'
    //     }
    //     always {
    //         echo 'Pipeline selesai menjalankan semua tahap.'
    //     }
    // }
}