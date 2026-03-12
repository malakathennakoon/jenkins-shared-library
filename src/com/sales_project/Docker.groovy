#!/usr/bin/env groovy
package com.sales_project

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName, String version) {
        script.echo "Building the Docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh 'echo "Logging in to Docker Hub..."'
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
            script.sh "docker build -t $imageName-$version . "
            script.sh "docker push $imageName-$version"
        }
    }
}