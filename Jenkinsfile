pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven-3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/tirasruya/E-Junkie_Team2.git'
            }
        }

        stage('Run Test') {
            steps {
                // For Mac/Linux
                // sh 'mvn clean test'

                // For Windows
                bat 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure([
                    commandline: 'Allure',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
