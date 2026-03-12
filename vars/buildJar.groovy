#!/usr/bin/env groovy

def call() {
    echo "Building the application from the branch ${env.BRANCH_NAME}"
    sh 'mvn package'
}


