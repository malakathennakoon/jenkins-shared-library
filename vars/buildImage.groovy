#!/usr/bin/env groovy

def call(string ImageName, string version) {
    echo "Building the Docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'echo "Logging in to Docker Hub..."'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker build -t $ImageName-$version . "
        sh "docker push $ImageName-$version"
    }
}