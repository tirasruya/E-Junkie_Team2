pipeline {

    agent any                            // Pipeline can run on any available agent (node).

    // ─────────────────────────────────────────────────────────────
    // GLOBAL OPTIONS – Controls general build behavior.
    // ─────────────────────────────────────────────────────────────
    options {
        timestamps()                     // Adds timestamps to console output → easier log tracing.
        disableConcurrentBuilds()        // Prevents the same job from running simultaneously.
        buildDiscarder(logRotator(       // Removes old builds to save disk space.
            numToKeepStr: '20',          // Keep last 20 builds.
            artifactNumToKeepStr: '10'   // Keep artifacts of last 10 builds.
        ))
    }

    // ─────────────────────────────────────────────────────────────
    // ENVIRONMENT – Constants reusable across pipeline.
    // ─────────────────────────────────────────────────────────────
    environment {
        ALLURE_RESULTS_PATH = 'target/allure-results' // Allure results directory.
        RECIPIENTS          = 'tirasruya@gmail.com'   // Email recipients.
    }

    // ─────────────────────────────────────────────────────────────
    // TOOLS – Uses globally configured JDK/Maven from Jenkins.
    // ─────────────────────────────────────────────────────────────
    tools {
        jdk    'JDK21'                   // Uses Jenkins configured JDK21.
        maven  'Maven-3.9'               // Uses Jenkins configured Maven 3.9.
    }

    stages {

        // ─────────────────────────────────────────────────────────
        stage('Prepare Workspace') {     // Cleans workspace before build starts.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Cleaning workspace..."
                deleteDir()              // Removes all files/folders for a fresh environment.
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Checkout') {              // Pulls source code from Git.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Fetching source code..."
                git branch: 'main',      // Specify branch name like main/master.
                    url: 'https://github.com/tirasruya/E-Junkie_Team2.git'
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Build & Test') {          // Runs project tests via Maven.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Running Maven tests..."
                bat 'mvn -U -B clean test'
                // -U: Update snapshot dependencies.
                // -B: Batch mode (non-interactive for Jenkins).
                // clean test → cleans then runs test suite.
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Publish JUnit Results') { // Publishes test results in Jenkins.
        // ─────────────────────────────────────────────────────────
            steps {
                junit 'target/surefire-reports/*.xml'
                // Publishes TestNG Surefire XML files to Jenkins as JUnit reports.
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Generate Allure Report') { // Generates Allure test report.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Generating Allure report..."
                allure([
                    commandLine:'Allure',
                    results: [[path: "${ALLURE_RESULTS_PATH}"]] // Allure results path.
                ])
            }
        }

        // ─────────────────────────────────────────────────────────
        stage('Zip Allure Results') {    // Zips Allure results & stores as artifact.
        // ─────────────────────────────────────────────────────────
            steps {
                echo "Zipping and archiving Allure results..."

                bat 'rm -f allure-results.zip || true'
                // Remove existing zip file if exists. Ignore errors.

                bat "zip -r allure-results.zip ${ALLURE_RESULTS_PATH}"
                // Create zip file (-r recursive)

                archiveArtifacts artifacts: 'allure-results.zip', fingerprint: true
                // Makes file downloadable in Jenkins interface.
            }
        }
    }

    // ─────────────────────────────────────────────────────────────
    // POST CONDITIONS – Executes depending on build result.
    // ─────────────────────────────────────────────────────────────
    post {

        success {                         // Runs when build is successful.
            emailext(
                subject: "✅ Jenkins Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Hello,

Jenkins job: ${env.JOB_NAME}
Build number: ${env.BUILD_NUMBER}
Result: ✅ SUCCESS

Allure results have been archived as a zip.
For detailed Allure report:
${env.BUILD_URL}allure

Regards,
Jenkins
""",
                to: "${RECIPIENTS}",      // Defined above in environment.
                attachLog: false,         // Do not attach console log.
                attachmentsPattern: 'allure-results.zip' // Attach result zip file.
            )
        }

        failure {                         // Runs when build fails.
            emailext(
                subject: "❌ Jenkins Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Hello,

Jenkins job: ${env.JOB_NAME}
Build number: ${env.BUILD_NUMBER}
Result: ❌ FAILED

Please check Jenkins logs and Allure report:
${env.BUILD_URL}

Regards,
Jenkins
""",
                to: "${RECIPIENTS}",
                attachLog: true,          // Attach console output for debugging.
                attachmentsPattern: 'allure-results.zip'
            )
        }

        always {                          // Runs regardless of result.
            echo "Build completed: Result = ${currentBuild.currentResult}"
        }
    }
}