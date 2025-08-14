pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run LoginTest') {
            steps {
                script {
                    // This runs only the LoginTest class
                    sh 'mvn test -Dtest=LoginTest'
                }
            }
        }
    }

    post {
        always {
            // Collects test results for reporting
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
