pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker_hub' // Jenkins Docker credentials ID
        DOCKERHUB_REPO = 'ristler/shoppingcartotp2'     // Docker Hub repository
        DOCKER_IMAGE_TAG = 'latest'              // Docker image tag
    }
    tools {
        maven 'Maven 3.9.11'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Ristler/shoppingCartOTP2'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '/Applications/Docker.app/Contents/Resources/bin/docker build -t $DOCKERHUB_REPO:$DOCKER_IMAGE_TAG .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: "${DOCKERHUB_CREDENTIALS_ID}",
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        # Use a temporary Docker config directory to bypass macOS credential helper
                        export DOCKER_CONFIG=$(mktemp -d)
                        echo $DOCKER_PASS | /Applications/Docker.app/Contents/Resources/bin/docker login -u $DOCKER_USER --password-stdin
                        /Applications/Docker.app/Contents/Resources/bin/docker push $DOCKERHUB_REPO:$DOCKER_IMAGE_TAG
                    '''
                }
            }
        }
    }
}