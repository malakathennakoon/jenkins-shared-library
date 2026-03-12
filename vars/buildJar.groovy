#!/usr/bin/env groovy

def call() {
    sh 'echo "Building the application from $BRANCH_NAME"'
    sh 'mvn package'
}

