pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "Acquiring source code from the specified directory path in the environment variable."
                echo "Building the project and creating necessary artifacts."
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
                echo "Analyzing code quality using a static analysis tool."
            }
        }
        stage('Security Analysis') {
            steps {
                echo "Performing security scans to detect vulnerabilities."
            }
        }
        stage('Staging Environment Testing') {
            steps {
                echo "Conducting integration tests on the staging setup."
            }
        }
        stage('Production Deployment') {
            steps {
                echo "Releasing the application to the production environment."
            }
        }
    }
    post {
        success {
            emailext(
                attachLog: true,
                compressLog: true,
                to: 'meetgadhiya8888@gmail.com',
                body: "The build log can be found at \$JENKINS_HOME/jobs/\$JOB_NAME/builds/lastSuccessfulBuild/log",
                subject: 'Deployment to Production Successful - Jenkins'
            )
        }
        failure {
            emailext(
                attachLog: true,
                compressLog: true,
                to: 'meetgadhiya8888@gmail.com',
                body: "The build log can be found at \$JENKINS_HOME/jobs/\$JOB_NAME/builds/lastSuccessfulBuild/log",
                subject: "Deployment to Production Failed - Jenkins"
            )
        }
    }
}
