
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                sh 'java -jar target/student-app-1.0.0.jar'
            }
        }
    }

    post {
        success {
            echo 'Java application completed successfully.'
        }
        failure {
            echo 'Build failed. Check the console output.'
        }
    }
}

