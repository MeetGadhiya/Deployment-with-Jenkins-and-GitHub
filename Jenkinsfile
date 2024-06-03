pipeline {
    agent any
    stages {
        stage('Source Code Checkout') {
            steps {
                echo "Retrieving the source code from the directory path defined by the environment variable."
                echo "Building the code and creating necessary artifacts."
            }
        }
        stage('Testing') {
            steps {
                echo "Executing unit tests."
                echo "Executing integration tests."
            }
        }
        stage('Static Code Analysis') {
            steps {
                echo "Evaluating code quality using a static analysis tool."
            }
        }
        stage('Security Assessment') {
            steps {
                echo "Detecting vulnerabilities using a security scanning tool."
            }
        }
        stage('Staging Environment Tests') {
            steps {
                echo "Performing integration tests in the staging environment."
            }
        }
        stage('Production Deployment') {
            steps {
                echo "Releasing the code to the production environment."
            }
        }
    }
    post {
        success {
            emailext(
                attachLog: true,
                compressLog: true,
                to: 'meetgadhiya8888@gmail.com',
                body: "You can find the log at $JENKINS_HOME/jobs/$JOB_NAME/builds/lastSuccessfulBuild/log",
                subject: "Successful Production Deployment - Jenkins"
            )
        }
        failure {
            emailext(
                attachLog: true,
                compressLog: true,
                to: 'meetgadhiya8888@gmail.com',
                body: "You can find the log at $JENKINS_HOME/jobs/$JOB_NAME/builds/lastSuccessfulBuild/log",
                subject: "Failed Production Deployment - Jenkins"
            )
        }
    }
}
