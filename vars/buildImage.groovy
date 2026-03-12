#!/usr/bin/env groovy

def call(String imageName, String version) {
    echo "Building the Docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'echo "Logging in to Docker Hub..."'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker build -t $imageName-$version . "
        sh "docker push $imageName-$version"
    }
}