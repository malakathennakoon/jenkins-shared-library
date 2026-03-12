#!/usr/bin/env groovy

import com.sales_project.Docker

def call(String imageName, String version) {
    new Docker(this).pushDockerImage(imageName,version)
}
