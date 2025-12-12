pipeline {
    agent any
    tools {
        maven 'Maven'  // Assume you configure Maven in Jenkins global tools
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t grid-app:latest .'
            }
        }
        stage('Deploy Staging') {
            steps {
                sh 'docker-compose -f docker-compose.staging.yml up -d --build'
            }
        }
        stage('Manual Approval') {
            steps {
                input message: 'Approve deployment to Production?', ok: 'Deploy'
            }
        }
        stage('Deploy Prod') {
            steps {
                sh 'docker-compose -f docker-compose.prod.yml up -d --build'
            }
        }
    }
    post {
        failure {
            echo 'Pipeline failed - Rolling back'
            sh 'docker-compose -f docker-compose.staging.yml down || true'
            sh 'docker-compose -f docker-compose.prod.yml down || true'
        }
    }
}