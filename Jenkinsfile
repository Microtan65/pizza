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
                withMaven {
                   sh "mvn test"
                }
            }
        }
        stage('Maven install & Build Docker Image') {
            steps {
                withMaven {
                   sh "mvn install -DskipTests"
               }
            }
        }
        stage('Push Docker Image') {
            steps {
                sh "mvn dockerfile:push"
            }
        }
        stage('k8s deploy') {
            steps {
                sh "kubectl --kubeconfig /var/lib/jenkins/config apply -f k8s.yaml"
            }
        }
    }
    post { 
        always { 
            cleanWs()
        }
    }
}
