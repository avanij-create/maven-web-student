pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build WAR') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t student-portal:1.0 .'
            }
        }
    }

    post {
        success {
            echo 'Maven Web WAR and Docker image built successfully.'
        }
        failure {
            echo 'Build failed. Check the console output.'
        }
    }
}
