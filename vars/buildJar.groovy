#!/usr/bin/env groovy

def call() {
    sh 'echo "Building the application..."'
    sh 'mvn package'
}

