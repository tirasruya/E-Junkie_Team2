pipeline {

tools{
    jdk 'JDK21'
    maven 'Maven-3.9'
}

stages {
    stage('Checkout')
        git branch: 'master',
        url: 'https://github.com/tirasruya/E-Junkie_Team2.git'

    stage('Run Test')
        //Mac
        //sh 'mvn clean test'

        //Windows
        bat 'mvn clean test'

    stage('Generate Allure Report')
        allure([
            results: [[path: 'target/allure-results']]
        ])
}
}