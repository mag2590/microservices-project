pipeline {
    agent any
    tools{
        maven 'apache-maven-3.9.2'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mag2590/microservices-project']]])
                sh 'mvn clean install'
            }
        }
    }
}
