#!/usr/bin/env groovy

def call() {
    echo "Building the application from $BRANCH_NAME"
    sh 'mvn package'
}

