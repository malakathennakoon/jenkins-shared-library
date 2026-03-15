#!/usr/bin/env groovy
package com.sales_project

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def dockerLogin() {
        script.echo "Login into the docker Hub"
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh 'echo "Logging in to Docker Hub..."'
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    def buildDockerImage(String imageName, String version) {
        script.echo "Building the Docker image..."
        script.sh "docker build -t $imageName-$version . "
    }

    def pushDockerImage(String imageName, String version) {
        script.echo "Pushing the Docker image..."
        script.sh "docker push $imageName-$version"
    }
}