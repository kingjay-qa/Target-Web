pipeline {
    agent any

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run LoginTest') {
            steps {
                script {
                    // Run only the LoginTest class
                    sh 'mvn test -Dtest=TestsCase.LoginTest'
                }
            }
        }
    }

    post {
        always {
            // Collects test results for reporting
            junit '**/target/surefire-reports/*.xml'
        }
        failure {
            echo 'Test failed. Check logs and reports for details.'
        }
        success {
            echo 'LoginTest executed successfully!'
        }
    }
}
