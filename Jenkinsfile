
pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/avanij-create/maven-web-student.git'
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

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.war'
            }
        }

        stage('Deploy') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'TOMCAT_CREDENTIALS',
                    usernameVariable: 'TOMCAT_USER',
                    passwordVariable: 'TOMCAT_PASS'
                )]) {
                    sh '''
                        curl --fail --silent --show-error \
                          -u "$TOMCAT_USER:$TOMCAT_PASS" \
                          --upload-file target/student-portal.war \
                          "http://${TOMCAT_HOST}:8080/manager/text/deploy?path=/student-portal&update=true"
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'Web application deployed successfully!'
        }

        failure {
            echo 'Build failed. Check Console Output.'
        }
    }
}



