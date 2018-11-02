pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                sh "mvn compile"
            }
        }
        stage('Unit test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Build Docker Image') {
            steps {
                sh "mvn install"
            }
        }
        stage('Push Docker Image') {
            steps {
                sh "mvn dockerfile:push"
            }
        }
    }
}
