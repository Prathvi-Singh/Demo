pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Prathvi-Singh/demo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'  // Corrected build step
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'  // Run unit tests
            }
        }
    }

    post {
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build or tests failed! Check logs for details.'
        }
    }
}
