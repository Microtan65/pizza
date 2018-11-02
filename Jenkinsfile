pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "mvn install -DskipTests"
            }
        }
        stage('Push Docker Image') {
            steps {
                sh "mvn dockerfile:push"
            }
        }
    }
}
